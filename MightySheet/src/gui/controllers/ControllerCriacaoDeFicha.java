package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.beans.Classe;
import negocio.beans.Personagem;
import negocio.beans.Raca;

public class ControllerCriacaoDeFicha {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ComboBox<?> classe;

    @FXML
    private ComboBox<?> raca;

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
    private Button voltar;

    @FXML
    private Button salvar;
    
    @FXML
    private TextField pV;

    @FXML
    private TextField pM;


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
    	//isso seria num RepositorioClasses mas enquanto nao tem, é isso
    	ArrayList<Classe> lista = new ArrayList<>();
    	ObservableList obLista;
    	lista.add(Classe.FEITICEIRO);
    	lista.add(Classe.GUERREIRO);
    	lista.add(Classe.LADINO);
    	lista.add(Classe.SACERDOTE);
    	obLista = FXCollections.observableArrayList(lista);
    	classe.setItems(obLista);
    	
    }
    
    void carregarRaca()
    {
    	//estaria na futura RepositorioRacas
    	ArrayList<Raca> lista = new ArrayList<>();
    	ObservableList obLista;
    	lista.add(Raca.HUMANO);
    	lista.add(Raca.Anao);
    	lista.add(Raca.ELFO);
    	//lista.add(Raca);
    	obLista = FXCollections.observableArrayList(lista);
    	raca.setItems(obLista);
    }
    
    @FXML
    void salvar(ActionEvent event)
    {
    	
    }
    
    @FXML
    void initialize() {
    	carregarClasse();
    	carregarRaca();
    }
	
}
