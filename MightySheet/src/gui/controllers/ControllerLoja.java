package gui.controllers;

import java.util.Collection;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import dados.interfaces.IRepoEquipamentos;
import dados.repositorios.RepositorioEquipamentos;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import negocio.Fachada;
import negocio.beans.Equipamento;
import negocio.beans.Protecao;

public class ControllerLoja {

	@FXML
    private TableView<Equipamento> tabela;
	
	@FXML
    private TableColumn<Equipamento, String> nome;

    @FXML
    private TableColumn<Equipamento, String> ouro;

    @FXML
    private TableColumn<Equipamento, String> tipo;

    @FXML
    private TableColumn<Equipamento, String> compra;

	
    @FXML
    private TextArea descricao;

    @FXML
    private Button terminar;

    @FXML
    private Button cancelar;

    @FXML
    private CheckBox armadura;

    @FXML
    private CheckBox armas;

    @FXML
    private CheckBox equipamento;

    @FXML
    private CheckBox itensConjuracao;

    @FXML
    private ListView<?> compras;

    @FXML
    void armaduras(ActionEvent event) {
    	
    	IRepoEquipamentos lista = RepositorioEquipamentos.getInstance();
    	
    	ObservableList obLista = FXCollections.observableArrayList(lista.listarTodasArmaduras());
    	
    	nome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
    	ouro.setCellValueFactory(data -> new SimpleStringProperty(String.format("%d",data.getValue().getCusto())));
    	//tipo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()
    	
    	
    	tabela.setItems(obLista);

    }
    
    @FXML
    void initialize() {
    	
    
    }
}
