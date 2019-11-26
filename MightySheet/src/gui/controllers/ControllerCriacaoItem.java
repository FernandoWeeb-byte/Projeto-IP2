package gui.controllers;

import java.io.IOException;

import dados.interfaces.IRepoEquipamentos;
import dados.repositorios.RepositorioEquipamentos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.Fachada;
import negocio.beans.Arma;
import negocio.beans.Equipamento;

public class ControllerCriacaoItem {
	
	private Fachada fachada = Fachada.getInstance();
    @FXML
    private Button cancelar;

    @FXML
    private Button salvar;

    @FXML
    private TextField custo;

    @FXML
    private ComboBox<?> categoria;

    @FXML
    private TextField peso;

    @FXML
    private TextField fN;

    @FXML
    private TextField dano;

    @FXML
    private TextField tipo;

    @FXML
    private TextField bloqueio;

    @FXML
    private TextField esquiva;

    @FXML
    private TextField nome;

    @FXML
    private TextArea descricao;

    @FXML
    private ComboBox<?> alcance;
    
    @FXML
    private CheckBox canalizador;

    Equipamento item = new Equipamento("", 0, 0, "", false, "");
    
    @FXML
    void escolherAlcance(ActionEvent event) {
    	((Arma) item).setDistancia((String) alcance.getValue());
    }
    
    @FXML
    void escolherCategoria(ActionEvent event) {
    	item.setCategoria((String) categoria.getValue());
    }
    
    @FXML
    void isCanalizador(ActionEvent event) {
    	if(canalizador.isSelected() == true) {
    		item.setCanalizador(true);
    	}
    	else {
    		item.setCanalizador(false);
    	}
    }
    
    void carregarCategorias(){
    	ObservableList listaObservavel;
    	listaObservavel = FXCollections.observableArrayList(fachada.listarCategorias());
    	categoria.setItems(listaObservavel);
    }

    void carregarAlcances(){
    	ObservableList listaObservavel;
    	listaObservavel = FXCollections.observableArrayList(fachada.listarAlcances());
    	categoria.setItems(listaObservavel);
    }
    
    @FXML
    void cancelarCriacaoItem(ActionEvent event) throws IOException {
    	Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
    	Scene Criacao_Item_Scene = new Scene(parent_voltar);
    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	appStage.setScene(Criacao_Item_Scene);
    	appStage.show();
    }
    
    @FXML
    void salvarItem(ActionEvent event) throws IOException {
    	item.setNome(nome.getText());
    	IRepoEquipamentos lista = RepositorioEquipamentos.getInstance();
    	lista.adicionarEquipamento(item);
    	//fachada.salvar(person);
    	Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
    	Scene Tela_Inicial_Scene = new Scene(parent_voltar);
    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	appStage.setScene(Tela_Inicial_Scene);
    	appStage.show();
    }
    
    @FXML
    void initialize() {
    	carregarCategorias();
    }

}
