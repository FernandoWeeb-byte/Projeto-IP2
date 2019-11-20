package gui.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class ControllerTelaInicial {
	
	 	@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;
	    
	    @FXML
	    private Text textField;

	    @FXML
	    private TableView<?> tabela;

	    @FXML
	    private TableColumn<?, ?> nomeTabela;

	    @FXML
	    private TableColumn<?, ?> classeTabela;

	    @FXML
	    private TableColumn<?, ?> racaTabela;
	    
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
	    	
	    	
	    	
	    }


}
