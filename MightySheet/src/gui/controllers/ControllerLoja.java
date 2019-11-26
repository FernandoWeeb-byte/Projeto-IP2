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
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import negocio.beans.Equipamento;
import negocio.beans.Protecao;

public class ControllerLoja {

	@FXML
    private TableView<?> tabela;
	

    @FXML
    private TextArea descricao;

    @FXML
    private Button terminar;

    @FXML
    private Button cancelar;

    @FXML
    private RadioButton armadura;

    @FXML
    private RadioButton armas;

    @FXML
    private RadioButton equipamento;

    @FXML
    private RadioButton itensConjuracao;

    @FXML
    private ListView<?> compras;

    @FXML
    void armaduras(ActionEvent event) {
    	IRepoEquipamentos lista = RepositorioEquipamentos.getInstance();
    	ObservableList obLista = FXCollections.observableArrayList(lista.listarTodasArmaduras());
    	TableColumn<Protecao, String> nome = new TableColumn<Protecao, String>("Nome");
    	TableColumn<Protecao, String> ouro = new TableColumn<>("Ouro");
    	TableColumn<Protecao, String> tipo = new TableColumn<>("Tipo");
    	
    	
    	nome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
    	ouro.setCellValueFactory(data -> new SimpleStringProperty(String.format("%d",data.getValue().getCusto())));
    	//tipo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()
    	

    }
}
