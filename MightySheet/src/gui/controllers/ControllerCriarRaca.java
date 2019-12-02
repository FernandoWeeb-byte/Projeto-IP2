package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.Fachada;
import negocio.beans.Habilidade;
import negocio.beans.Raca;

public class ControllerCriarRaca {
	Fachada fachada = Fachada.getInstance();
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nome;

    @FXML
    private TextField forca;

    @FXML
    private TextField agilidade;

    @FXML
    private TextField inteligencia;

    @FXML
    private TextField vontade;

    @FXML
    private ListView<?> habList;

    @FXML
    private Button voltar;
    
    @FXML
    private ComboBox<Habilidade> habAuto;
    

    @FXML
    void salvar(ActionEvent event) throws IOException {
    	ObservableList obLista = habList.getSelectionModel().getSelectedItems();
    	List<Habilidade> lista = new ArrayList<>();
    	lista.addAll(obLista);
    	lista.add(habAuto.getValue());
    	Raca raca = new Raca(null, 0, 0, 0, 0, habAuto.getValue(), lista);
    	raca.setNome(nome.getText());
    	raca.setForca(Integer.parseInt(forca.getText()));
    	raca.setAgilidade(Integer.parseInt(agilidade.getText()));
    	raca.setInteligencia(Integer.parseInt(inteligencia.getText()));
    	raca.setVontade(Integer.parseInt(vontade.getText()));
    	fachada.adicionarRaca(raca);
    	fachada.salvarRacas();
    	
    	Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
    	Scene voltar_Scene = new Scene(parent_voltar);
    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	appStage.setScene(voltar_Scene);
    	appStage.show();
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
    	Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
    	Scene voltar_Scene = new Scene(parent_voltar);
    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	appStage.setScene(voltar_Scene);
    	appStage.show();
    }
    
    void carregarHab()
    {
    	// habilidade na lista
    	List<Habilidade> lista = new ArrayList<>();
    	for(Raca raca : fachada.listarTodasRacas())
    	{
    		lista.addAll(fachada.listarHabilidadesPorRaca(raca));
    	}
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	habList.setItems(obLista);
    	habList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
    	//habilidadeAuto
    	List<Habilidade> lista2 = new ArrayList<>();
    	for(Habilidade hab : fachada.listarTodasHabilidades())
    	{
    		if(hab.getTipo().contains("Suporte") && hab.getRequisito().contains("-"))
    		{
    			lista2.add(hab);
    		}
    	}
    	ObservableList obLista2 = FXCollections.observableArrayList(lista2);
    	habAuto.setItems(obLista2);
    			
    }

    @FXML
    void initialize() {
    	carregarHab();
    }
}
