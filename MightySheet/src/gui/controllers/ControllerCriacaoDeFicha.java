package gui.controllers;

import java.io.IOException;
import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableIntegerArray;
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
import javafx.scene.layout.Pane;
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
    private ComboBox<Integer> nivel;

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
    private TextField deslocamento;

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
    private Label qtdHab;

    @FXML
    private Label ptsAtributos;
    
    Personagem person = new Personagem(null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, 0);
    
    

    @FXML
    void acaoBotao(ActionEvent event) throws IOException
    {
    	Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
    	Scene Criacao_Ficha_Scene = new Scene(parent_voltar);
    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	appStage.setScene(Criacao_Ficha_Scene);
    	appStage.show();
    	
    }
    
    @FXML
    void escolherNivel(ActionEvent event) {
    	person.setPtsAtributo(0);
    	person.setNivel((int)nivel.getValue());
    	person.calculoPtsAtributo(person.getNivel());
    	ptsAtributos.setText(String.format("%d", person.getPtsAtributo()));
    	
    	person.setQuantHabilidades();
    	qtdHab.setText(String.format("%d", person.getQuantHabilidades()));
    }
    
    void carregarNiveis()
    {
    	ObservableList<Integer> obLista;
    	Integer[] niveis = {1,2,3,4,5,6,7,8,9,10};
    	obLista = FXCollections.observableArrayList(niveis);
    	nivel.setItems(obLista);
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
    	//carrega as raças
    	ObservableList obLista;
    	
    	List<Raca> lista = fachada.listarTodasRacas();
    	
    	//lista.add(Raca);
    	obLista = FXCollections.observableArrayList(lista);
    	raca.setItems(obLista);
    }
    
    @FXML
    void selecionarRaca(ActionEvent event) {
    	// setar atributos
    	String str[] = {null, null, null, null};
    	if(classe.getValue() == null) {
    	str[0] = String.format("%d",raca.getValue().getForca());
    	forca.setText(str[0]);
    	str[1] = String.format("%d",raca.getValue().getAgilidade());
    	agilidade.setText(str[1]);
    	str[2] = String.format("%d",raca.getValue().getInteligencia());
    	inteligencia.setText(str[2]);
    	str[3] = String.format("%d",raca.getValue().getVontade());
    	vontade.setText(str[3]);
    	}
    	else {
    		str[0] = String.format("%d",raca.getValue().getForca() + classe.getValue().getBonusForca());
        	forca.setText(str[0]);
        	str[1] = String.format("%d",raca.getValue().getAgilidade() + classe.getValue().getBonusAgilidade());
        	agilidade.setText(str[1]);
        	str[2] = String.format("%d",raca.getValue().getInteligencia() + classe.getValue().getBonusInteligencia());
        	inteligencia.setText(str[2]);
        	str[3] = String.format("%d",raca.getValue().getVontade() + classe.getValue().getBonusVontade());
        	vontade.setText(str[3]);
    	}
    	
    	
    	//Mostrar as habilidades da raça na lista
    	ObservableList obLista = null;
    	skilList.getItems().clear();
    	List<Habilidade> lista = null;
    	lista = fachada.listarHabilidadesPorRaca(raca.getValue().getNome());
    	obLista = FXCollections.observableArrayList(lista);
    	skilList.getItems().addAll(obLista);
    	
    	//seta a raça e atributos
    	
    	person.setRaca(raca.getValue());
    	person.setForca(Integer.parseInt(forca.getText()));
    	person.setAgilidade(Integer.parseInt(agilidade.getText()));
    	person.setInteligencia(Integer.parseInt(inteligencia.getText()));
    	person.setVontade(Integer.parseInt(vontade.getText()));
    	//calculos
    	calcularValores();
    }
    
    @FXML
    void selecionarClasse(ActionEvent event) {
    	// mostrar atributos
    	String str[] = {null, null, null, null};
    	if(raca.getValue() == null) {
    	str[0] = String.format("%d", classe.getValue().getBonusForca());
    	forca.setText(str[0]);
    	str[1] = String.format("%d", classe.getValue().getBonusAgilidade());
    	agilidade.setText(str[1]);
    	str[2] = String.format("%d", classe.getValue().getBonusInteligencia());
    	inteligencia.setText(str[2]);
    	str[3] = String.format("%d",classe.getValue().getBonusVontade());
    	vontade.setText(str[3]);
    	}
    	else {
    		str[0] = String.format("%d",raca.getValue().getForca() + classe.getValue().getBonusForca());
        	forca.setText(str[0]);
        	str[1] = String.format("%d",raca.getValue().getAgilidade() + classe.getValue().getBonusAgilidade());
        	agilidade.setText(str[1]);
        	str[2] = String.format("%d",raca.getValue().getInteligencia() + classe.getValue().getBonusInteligencia());
        	inteligencia.setText(str[2]);
        	str[3] = String.format("%d",raca.getValue().getVontade() + classe.getValue().getBonusVontade());
        	vontade.setText(str[3]);
    	}
    	
    	
    	// mostrar as habilidades de classe na lista
    	ObservableList obLista = null;
    	skillListC.getItems().clear();
    	List<Habilidade> lista = null;
    	lista = fachada.listarHabilidadePorClasse(classe.getValue().getNome());
    	obLista = FXCollections.observableArrayList(lista);
    	skillListC.getItems().addAll(obLista);
    	
    	//seta a classe e atributos
    	
    	person.setClasse(classe.getValue());
    	person.setForca(Integer.parseInt(forca.getText()));
    	person.setAgilidade(Integer.parseInt(agilidade.getText()));
    	person.setInteligencia(Integer.parseInt(inteligencia.getText()));
    	person.setVontade(Integer.parseInt(vontade.getText()));
    	//calculos
    	calcularValores();
    }
    
    void calcularValores()
    {
    	String[] str = {null, null, null,null}; 
    	
    	//Carga basica
    	person.setCargaBasica(Integer.parseInt(forca.getText()));
    	str[0] = String.format("%d", person.getCargaBasica());
    	cargaBasica.setText(str[0]);
    	//carga Pesada
    	person.setCargaPesada(person.getCargaBasica());
    	str[1] = String.format("%d", person.getCargaPesada());
    	cargaPesada.setText(str[1]);
    	//carga Maxima
    	person.setCargaMaxima(person.getCargaBasica());
    	str[2] = String.format("%d", person.getCargaMaxima());
    	cargaMaxima.setText(str[2]);
    	//deslocamento
    	person.setDeslocamento();
    	str[3] = String.format("%d", person.getDeslocamento());
    	deslocamento.setText(str[3]);
    	
    }
    
    @FXML
    void Loja(ActionEvent event) throws IOException {
    	Stage stage = new Stage();
    	FXMLLoader FxmlLoader = new FXMLLoader();
    	Parent loja_parent = FxmlLoader.load(getClass().getResource("/gui/fxmls/Loja.fxml").openStream());
    	Scene loja_Scene = new Scene(loja_parent);
        stage.setScene(loja_Scene);
        stage.setTitle("Loja");
        stage.showAndWait();
    	
    }
    
    @FXML
    void initialize() {
    	carregarClasse();
    	carregarRaca();
    	carregarNiveis();
    }
	
}
