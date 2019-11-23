package gui.controllers;

import java.io.IOException;
import java.net.URL;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import negocio.Fachada;
import negocio.beans.Classe;
import negocio.beans.Habilidade;
import negocio.beans.Personagem;
import negocio.beans.Raca;
import negocio.controladores.ControladorPersonagens;

public class ControllerCriacaoDeFicha {

	/// Fachada
	private Fachada fachada = Fachada.getInstance();
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ComboBox<Classe> classe;

    @FXML
    private ComboBox<Raca> raca;

    @FXML
    private TextField forca;

    @FXML
    private TextField agilidade;

    @FXML
    private TextField inteligencia;

    @FXML
    private TextField vontade;

    @FXML
    private ComboBox<?> vestimenta;

    @FXML
    private ComboBox<?> maoDireita;

    @FXML
    private ComboBox<?> maoEsquerda;

    @FXML
    private Button adcForca;

    @FXML
    private Button adcAgilidade;

    @FXML
    private Button adcInteligencia;

    @FXML
    private Button adcVontade;

    @FXML
    private TextField nome;

    @FXML
    private TextField nivel;

    @FXML
    private TextField bloqueio;

    @FXML
    private TextField esquiva;

    @FXML
    private TextField determinacao;

    @FXML
    private TextField cargaBasica;

    @FXML
    private TextField cargaPesada;

    @FXML
    private TextField cargaMaxima;

    @FXML
    private TextField Deslocamento;

    @FXML
    private TextField corrida;
    
    @FXML
    private ListView<?> skilList;
    
    @FXML
    private ListView<?> skillListC;

    @FXML
    private Button voltar;

    @FXML
    private Button salvar;
    
    @FXML
    private TextField pV;

    @FXML
    private TextField pM;
    
    @FXML
    private Label erro;



    @FXML
    void acaoBotao(ActionEvent event) throws IOException
    {
    	Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
    	Scene Criacao_Ficha_Scene = new Scene(parent_voltar);
    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	appStage.setScene(Criacao_Ficha_Scene);
    	appStage.show();
    }
    
    
    
    void carregarClasse()
    {
    	
    	ObservableList obLista;
    	
    	List<Classe> lista = fachada.listarTodasClasses();
    	
    	obLista = FXCollections.observableArrayList(lista);
    	classe.setItems(obLista);
    }
    
    void carregarRaca()
    {
    	//estaria na futura RepositorioRacas
    	ObservableList obLista;
    	
    	List<Raca> lista = fachada.listarTodasRacas();
    	
    	//lista.add(Raca);
    	obLista = FXCollections.observableArrayList(lista);
    	raca.setItems(obLista);
    }
    
    @FXML
    void selecionarRaca(ActionEvent event) {
    	ObservableList obLista = null;
    	skilList.getItems().clear();
    	List<Habilidade> lista = null;
    	lista = fachada.listarHabilidadesPorRaca(raca.getValue().getNome());
    	obLista = FXCollections.observableArrayList(lista);
    	skilList.getItems().addAll(obLista);

    }
    
    @FXML
    void selecionarClasse(ActionEvent event) {
    	ObservableList obLista = null;
    	skillListC.getItems().clear();
    	List<Habilidade> lista = null;
    	lista = fachada.listarHabilidadePorClasse(classe.getValue().getNome());
    	obLista = FXCollections.observableArrayList(lista);
    	skillListC.getItems().addAll(obLista);
    }
    
    
    
    @FXML
    void initialize() {
    	carregarClasse();
    	carregarRaca();
    }
	
}
