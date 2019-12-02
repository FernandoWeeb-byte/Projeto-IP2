package gui.controllers;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import negocio.Fachada;
import negocio.beans.Equipamento;
import negocio.beans.Habilidade;
import negocio.beans.Personagem;

public class ControllerHabilidade {
	 Fachada fachada = Fachada.getInstance();
	
	@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private ListView<Habilidade> listaH;

	    @FXML
	    private Button visualizar;

	    @FXML
	    private Button pegar;

	    @FXML
	    private TextArea descrição;

	    @FXML
	    private ListView<Habilidade> listaHE;

	    @FXML
	    private Button finalizar;

	    @FXML
	    private Button cancelar;
	    
	    @FXML
	    private Label nHab;

	    Personagem person = Personagem.novoPerson;
	    Personagem novoPerson = new Personagem(null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, 0);
	    
	    @FXML
	    void cancelarH(ActionEvent event) {
	    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
	    	
	    	appStage.close();
	    }

	    @FXML
	    void finalizarH(ActionEvent event) {
	    	List<Habilidade> lista = (List<Habilidade>) listaHE.getItems();
	        ArrayList<Habilidade> showing;
	        if (lista instanceof ArrayList<?>) {
	            showing = (ArrayList<Habilidade>) lista;
	        } else {
	            showing = new ArrayList<>(lista);
	        }
	    	person.setHabilidades(showing);
	    	Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
	    	stage.close();
	    }

	    @FXML
	    void pegarHabilidade(ActionEvent event) {
	    	if(0 < person.getQuantHabilidades() && !listaHE.getItems().contains(listaH.getSelectionModel().getSelectedItem()) && !person.getHabilidades().contains(listaH.getSelectionModel().getSelectedItem())) {
	    	
	    		listaHE.getItems().add(listaH.getSelectionModel().getSelectedItem());
	    		person.setNumeroHabilidades(person.getQuantHabilidades()-1);
	    		nHab.setText(String.format("%d", person.getQuantHabilidades()));
	    	}
	    }

	    @FXML
	    void visu(ActionEvent event) {
	    	descrição.setText(listaH.getSelectionModel().getSelectedItem().descricaoCompleta());
	    }
	    
	    void carregarHabilidades()
	    {
	    	ObservableList<Habilidade> obLista = FXCollections.observableArrayList(fachada.habilidadesBasicaAvancadaOuFinal(person.getClasse(), 1));	   
	    	if(person.getNivel() >=5)
	    	{
	    		obLista.addAll(fachada.habilidadesBasicaAvancadaOuFinal(person.getClasse(), 5));
	    		
	    	}
	    	if(person.getNivel() == 10)
	    	{
	    		obLista.addAll(fachada.habilidadesBasicaAvancadaOuFinal(person.getClasse(), 10));
	    	}
	    	
	    	obLista.addAll(fachada.listarHabilidadesPorRaca(person.getRaca()));
	    	listaH.getItems().addAll(obLista);
	    	if(person.getHabilidades()==null) {
	    		person.setQuantHabilidades();
	    	}
	    	else {
	    		person.setQuantHabilidades();
	    		person.setNumeroHabilidades(person.getQuantHabilidades()- person.getHabilidades().size());
	    	}
	    	nHab.setText(String.format("%d", person.getQuantHabilidades()));
	    }

	    @FXML
	    void initialize() {
	    	carregarHabilidades();
	    }
}
