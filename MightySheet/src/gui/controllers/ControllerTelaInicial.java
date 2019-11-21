package gui.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import negocio.beans.Classe;
import negocio.beans.Personagem;
import negocio.beans.Raca;

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
	    	nomeTabela.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNomePersonagem()));
	    	classeTabela.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getClasse().getNome()));
	    	racaTabela.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRaca().getNome()));
	    	
	    	tabela.getItems().add(new Personagem("hawkboy",Classe.LADINO,Raca.ANAO));
	    }
	    
	    @FXML
	    void AcaoDoBotao2(ActionEvent event) throws IOException {
	    	Parent Ficha_parent = FXMLLoader.load(getClass().getResource("Fichas.fxml"));
	    	Scene Ficha_scene = new Scene(Ficha_parent);
	    	Stage appStage2 = (Stage) (((Node) event.getSource()).getScene().getWindow());
	    	appStage2.setScene(Ficha_scene);
	    	appStage2.show();
	    }

	    @FXML
	    void initialize() {
	    	
	    	tabela();
	    	
	    }


}
