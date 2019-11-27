package gui.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dados.interfaces.IRepoPersonagens;
import dados.repositorios.RepositorioPersonagens;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import negocio.beans.Personagem;
import negocio.controladores.ControladorPersonagens;

public class ControllerTelaInicial {
	
	 	@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;
	    
	    @FXML
	    private Text textField;

	    @FXML
	    private TableView<Personagem> tabela;

	    @FXML
	    private TableColumn<Personagem, String> nomeTabela;

	    @FXML
	    private TableColumn<Personagem, String> classeTabela;

	    @FXML
	    private TableColumn<Personagem, String> racaTabela;
	    
	    @FXML
	    private Button criarFicha;

	    @FXML
	    private ImageView fundo;
	    
	    @FXML
	    private Button editarFicha;

	    @FXML
	    private Button removerFicha;

	    
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
	    	IRepoPersonagens lista = RepositorioPersonagens.getInstance();
	    	//lista.carregarPersonagens();
	    	
	    	ObservableList<Personagem> obLista;
	    	obLista = FXCollections.observableArrayList(lista.todas());
	    	ControladorPersonagens cP = new ControladorPersonagens();
	    	
	    	nomeTabela.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNomePersonagem()));
	    	classeTabela.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getClasse().getNome()));
	    	racaTabela.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRaca().getNome()));
	    	tabela.setItems(obLista);
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
	    	IRepoPersonagens lista = RepositorioPersonagens.getInstance();
	    	lista.removerFicha(tabela.getSelectionModel().getSelectedItem());
	    	tabela.getSelectionModel().clearSelection();
	    	tabela();
	    	
	    }
	    
	    @FXML
	    void novoItem(ActionEvent event) throws IOException {
	    	Parent Criar_Item_parent = FXMLLoader.load(getClass().getResource("/gui/fxmls/CriarItem.fxml"));
	    	Scene Criar_Item_Scene = new Scene(Criar_Item_parent);
	    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
	    	appStage.setScene(Criar_Item_Scene);
	    	appStage.show();
	    }

	    @FXML
	    void initialize() {
	    	
	    	tabela();
	    	
	    }


}
