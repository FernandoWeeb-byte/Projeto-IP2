package gui.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import dados.interfaces.IRepoEquipamentos;
import dados.repositorios.RepositorioEquipamentos;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import negocio.Fachada;
import negocio.beans.Arma;
import negocio.beans.Equipamento;
import negocio.beans.Personagem;
import negocio.beans.Protecao;

public class ControllerLoja {

	Fachada fachada = Fachada.getInstance();
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
    private Label ouros;
    
    @FXML
    private TextArea descricao;

    @FXML
    private Button terminar;

    @FXML
    private Button cancelar;

    @FXML
    private RadioButton armadura;

    @FXML
    private CheckBox armas;

    @FXML
    private CheckBox equipamento;

    @FXML
    private CheckBox itensConjuracao;

    @FXML
    private ListView<?> compras;
    
    @FXML
    private ToggleGroup grupo;
    
    List<Equipamento> lista = new ArrayList<>();
    
    Personagem novoPerson = Personagem.novoPerson;

    @FXML
    void armaduras(ActionEvent event) {
    	
    	List<Protecao> lista = fachada.listarTodasArmaduras();
    	
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	
    	nome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
    	ouro.setCellValueFactory(data -> new SimpleStringProperty(String.format("%d",data.getValue().getCusto())));
    	//tipo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()
    	compra.setCellValueFactory(new PropertyValueFactory<Equipamento, String>("Button"));
    	tabela.setItems(obLista);
    	for(int i=0;i<lista.size();i++)
    	{
    		lista.get(i).getButton().setOnAction(this::acao);;
    	}

    }
    
    @FXML
    void armas(ActionEvent event) {
    
    	List<Arma> lista = fachada.listarTodasArmas();
    	
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	
    	nome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
    	ouro.setCellValueFactory(data -> new SimpleStringProperty(String.format("%d",data.getValue().getCusto())));
    	//tipo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()
    	compra.setCellValueFactory(new PropertyValueFactory<Equipamento, String>("Button"));
    	tabela.setItems(obLista);
    	for(int i=0;i<lista.size();i++)
    	{
    		lista.get(i).getButton().setOnAction(this::acao);;
    	}

    	
    }
    
    @FXML
    void itensConjuracao(ActionEvent event) {
    	
    	List<Equipamento> lista = fachada.listarTodosCanalizadores();
    	
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	
    	nome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
    	ouro.setCellValueFactory(data -> new SimpleStringProperty(String.format("%d",data.getValue().getCusto())));
    	//tipo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()
    	compra.setCellValueFactory(new PropertyValueFactory<Equipamento, String>("Button"));
    	tabela.setItems(obLista);
    	for(int i=0;i<lista.size();i++)
    	{
    		lista.get(i).getButton().setOnAction(this::acao);;
    	}
    }

    @FXML
    void equipamentos(ActionEvent event) {

    	List<Equipamento> lista = fachada.listarItensComuns();
    	
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	
    	nome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));
    	ouro.setCellValueFactory(data -> new SimpleStringProperty(String.format("%d",data.getValue().getCusto())));
    	//tipo.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()
    	compra.setCellValueFactory(new PropertyValueFactory<Equipamento, String>("Button"));
    	tabela.setItems(obLista);
    	for(int i=0;i<lista.size();i++)
    	{
    		lista.get(i).getButton().setOnAction(this::acao);;
    	}
    }

    
    @FXML
    void acao(ActionEvent event) {
    	//List<Equipamento> lista = new ArrayList<>();
    	for(Equipamento equip : tabela.getItems())
    	{
    		if(equip.getButton() == event.getSource())
    		{
    			if(novoPerson.getOuro() > 0 && novoPerson.getOuro() >= equip.getCusto()) {
    			lista.add(equip);
    			novoPerson.setOuro(novoPerson.getOuro() - equip.getCusto());
    			}
    			
    		}
    	}
    	ObservableList obLista;
		obLista = FXCollections.observableArrayList(lista);
		compras.setItems(obLista);
		ouros.setText(String.format("%d", novoPerson.getOuro()));
    }
    void carregarValor()
    {
    	ouros.setText(String.format("%d", novoPerson.getOuro()));
    }
    
    @FXML
    void terminarCompra(ActionEvent event) {
    	List<Equipamento> lista = (List<Equipamento>) compras.getItems();
        ArrayList<Equipamento> showing;
        if (lista instanceof ArrayList<?>) {
            showing = (ArrayList<Equipamento>) lista;
        } else {
            showing = new ArrayList<>(lista);
        }
    	novoPerson.setEquipamentos(showing);
    	Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	stage.close();
    	
    	
    }
    
    @FXML
    void mostraDescricao(ActionEvent event) {
    	if(tabela.getSelectionModel().isSelected(tabela.getSelectionModel().getSelectedIndex())) {
    		
    		descricao.setText(tabela.getSelectionModel().getSelectedItem().getNome());
    	
    	}
    }

    
    @FXML
    void initialize() {
    	carregarValor();
    	
    
    }
}
