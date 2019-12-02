package gui.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dados.interfaces.IRepoPersonagens;
import dados.repositorios.RepositorioPersonagens;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import negocio.Fachada;
import negocio.beans.Classe;
import negocio.beans.Personagem;
import negocio.beans.Raca;
import negocio.controladores.ControladorPersonagens;

public class ControllerTelaInicial {
		Fachada fachada = Fachada.getInstance();
	
	 	@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;
	    
	    @FXML
	    private Text textField;

	    @FXML
	    public TableView<Personagem> tabela;

	    @FXML
	    private TableColumn<Personagem, String> nomeTabela;

	    @FXML
	    private TableColumn<Personagem, String> classeTabela;

	    @FXML
	    private TableColumn<Personagem, String> racaTabela;
	    
	    @FXML
	    private TableColumn<Personagem,  String> visualizarTabela;
	    
	    @FXML
	    private Button criarFicha;

	    @FXML
	    private ImageView fundo;
	    
	    @FXML
	    private Button editarFicha;

	    @FXML
	    private Button removerFicha;
	    
	    @FXML
	    private ComboBox<String> buscaCombo;
	    
	    @FXML
	    private TextField buscaFicha;
	    
	    @FXML
	    void AcaoDoBotao(ActionEvent event) throws IOException {
	    	
	    	Parent Criacao_Ficha_parent = FXMLLoader.load(getClass().getResource("/gui/fxmls/FichaCreation.fxml"));
	    	Scene Criacao_Ficha_Scene = new Scene(Criacao_Ficha_parent);
	    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
	    	appStage.setScene(Criacao_Ficha_Scene);
	    	appStage.show();
	    	
	    		
	    }
	    
	    void tabela()
	    {
	    
	    	ObservableList obLista;
	    	obLista = FXCollections.observableArrayList(fachada.todas());
	    	
	    	nomeTabela.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNomePersonagem()));
	    	classeTabela.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getClasse().getNome()));
	    	racaTabela.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRaca().getNome()));
	    	tabela.setItems(obLista);
	    }
	    
	    @FXML
	    void busca(ActionEvent event) {
	    	if(buscaCombo.getValue().contains("Todos"))
	    	{
	    		ObservableList<Personagem> obLista = FXCollections.observableArrayList(fachada.todas());
	    		tabela.getItems().clear();
	    		tabela.getItems().addAll(obLista);
	    	}
	    }
	    
	    @FXML
	    void okFicha(ActionEvent event) {
	    	if(buscaCombo.getValue().contains("Nome")) {
	    		if(buscaFicha.getText() != null) {
	    			ObservableList<Personagem> obLista = FXCollections.observableArrayList(fachada.buscaPorPers(buscaFicha.getText()));
	    			tabela.getItems().clear();
	    			tabela.getItems().addAll(obLista);
	    		}
	    	}
	    	else if(buscaCombo.getValue().contains("Classe")) {
	    		if(buscaFicha.getText() != null) {
	    			ObservableList<Personagem> obLista = FXCollections.observableArrayList(fachada.listaDaClasse(fachada.buscarClasse(buscaFicha.getText())));
	    			tabela.getItems().clear();
	    			tabela.getItems().addAll(obLista);
	    		}
	    	}
	    	else if(buscaCombo.getValue().contains("Raça")) {
	    		if(buscaFicha.getText() != null) {
	    			ObservableList<Personagem> obLista = FXCollections.observableArrayList(fachada.listaDaRaca(fachada.buscarRaca(buscaFicha.getText())));
	    			tabela.getItems().clear();
	    			tabela.getItems().addAll(obLista);
	    		}
	    	}
	    }
	    
	    void carregarBusca()
	    {
	    	ArrayList<String> lista = new ArrayList<>();
	    	lista.add("Todos");
	    	lista.add("Nome");
	    	lista.add("Classe");
	    	lista.add("Raça");
	    	ObservableList<String> obLista = FXCollections.observableArrayList(lista);
	    	buscaCombo.getItems().addAll(obLista);
	    }
	    
	    @FXML
	    void visualizar(ActionEvent event) throws IOException
	    {
	    	
	    	
	    	Personagem nPerson = tabela.getSelectionModel().getSelectedItem();
	    	Personagem.visuPerson = nPerson;
	    	Stage stage = new Stage();
	    	FXMLLoader FxmlLoader = new FXMLLoader();
	    	Parent visualizar_parent = FxmlLoader.load(getClass().getResource("/gui/fxmls/VisualizarPersonagem.fxml").openStream());
	    	Scene visualizar_Scene = new Scene(visualizar_parent);
	        stage.setScene(visualizar_Scene);
	        stage.setTitle("Ficha");
	        stage.setResizable(false);
	        stage.showAndWait();
	    	
	    	
	    }
	    
	    @FXML
	    void editarPersonagem(ActionEvent event) throws IOException {
	    	Personagem nPerson = tabela.getSelectionModel().getSelectedItem();
	    	Personagem.visuPerson = nPerson;
	    	fachada.removerFicha(tabela.getSelectionModel().getSelectedItem().getNomePersonagem());
	    	tabela.getSelectionModel().clearSelection();
	    	Parent Editar_parent = FXMLLoader.load(getClass().getResource("/gui/fxmls/EditarFicha.fxml"));
	    	Scene Editar_Scene = new Scene(Editar_parent);
	    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
	    	appStage.setScene(Editar_Scene);
	    	appStage.show();
	    }
	    
	    @FXML
	    void criarClasse(ActionEvent event) throws IOException {
	    	Parent Criar_Classe_parent = FXMLLoader.load(getClass().getResource("/gui/fxmls/CriarClasse.fxml"));
	    	Scene Criar_Classe_Scene = new Scene(Criar_Classe_parent);
	    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
	    	appStage.setScene(Criar_Classe_Scene);
	    	appStage.show();
	    }
	    
	    @FXML
	    void criarRaca(ActionEvent event) throws IOException {
	    	Parent Criar_Raca_parent = FXMLLoader.load(getClass().getResource("/gui/fxmls/CriarRaca.fxml"));
	    	Scene Criar_Raca_Scene = new Scene(Criar_Raca_parent);
	    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
	    	appStage.setScene(Criar_Raca_Scene);
	    	appStage.show();
	    }
	    
	    @FXML
	    void remover(ActionEvent event) throws IOException {
	    	
	    	fachada.removerFicha(tabela.getSelectionModel().getSelectedItem().getNomePersonagem());
	    	tabela.getSelectionModel().clearSelection();
	    	fachada.salvarTodosRepositórios();
	    	tabela();
	    	
	    }
	    
	    @FXML
	    void criarItem(ActionEvent event) throws IOException {
	    	Parent Criar_Item_parent = FXMLLoader.load(getClass().getResource("/gui/fxmls/CriarItem.fxml"));
	    	Scene Criar_Item_Scene = new Scene(Criar_Item_parent);
	    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
	    	appStage.setScene(Criar_Item_Scene);
	    	appStage.show();
	    }
	    
	    @FXML
	    void criarHabilidade(ActionEvent event) throws IOException {
	    	Parent Criar_Habilidade_parent = FXMLLoader.load(getClass().getResource("/gui/fxmls/CriarHabilidade.fxml"));
	    	Scene Criar_Habilidade_Scene = new Scene(Criar_Habilidade_parent);
	    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
	    	appStage.setScene(Criar_Habilidade_Scene);
	    	appStage.show();
	    }
	    

	    @FXML
	    void initialize() {
	    	
	    	tabela();
	    	carregarBusca();
	    	
	    }


}
