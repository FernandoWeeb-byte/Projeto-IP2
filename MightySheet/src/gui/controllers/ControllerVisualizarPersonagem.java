package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.beans.Equipamento;
import negocio.beans.Habilidade;
import negocio.beans.Personagem;

public class ControllerVisualizarPersonagem {
	 	@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField nome;

	    @FXML
	    private TextField raca;

	    @FXML
	    private TextField classe;

	    @FXML
	    private TextField nivel;

	    @FXML
	    private TextField ouro;

	    @FXML
	    private TextField forca;

	    @FXML
	    private TextField agilidade;

	    @FXML
	    private TextField inteligencia;

	    @FXML
	    private TextField vontade;

	    @FXML
	    private TextField vida;

	    @FXML
	    private TextField mana;

	    @FXML
	    private TextField vestimenta;

	    @FXML
	    private TextField maoDireita;

	    @FXML
	    private TextField maoEsquerda;

	    @FXML
	    private TextField corrida;

	    @FXML
	    private TextField deslocamento;

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
	    private ListView<Habilidade> listaHab;

	    @FXML
	    private ListView<Equipamento> listaEquip;
	    
	    
	    
	    Personagem person = Personagem.visuPerson;
	    Habilidade hab = new Habilidade(null, null, null, null, 0, 0, null, null, null);
	    Equipamento equip = new Equipamento(null, 0, 0, 0, null, false);
	    @FXML
	    void verEquipamento(ActionEvent event) throws IOException {
	    	
	    	equip = listaEquip.getSelectionModel().getSelectedItem();
	    	Equipamento.equipamento = equip; 
	    	Habilidade.habildade = null;
	    	Stage stage = new Stage();
	    	FXMLLoader FxmlLoader = new FXMLLoader();
	    	Parent visualizar_parent = FxmlLoader.load(getClass().getResource("/gui/fxmls/TelaVisu.fxml").openStream());
	    	Scene visualizar_Scene = new Scene(visualizar_parent);
	        stage.setScene(visualizar_Scene);
	        stage.setTitle("Ficha");
	        stage.setResizable(false);
	        stage.showAndWait();
	    }

	    @FXML
	    void verHabilidade(ActionEvent event) throws IOException {
	    	
	    	hab = listaHab.getSelectionModel().getSelectedItem();
	    	Habilidade.habildade = hab;
	    	Equipamento.equipamento = null;
	    	Stage stage = new Stage();
	    	FXMLLoader FxmlLoader = new FXMLLoader();
	    	Parent visualizar_parent = FxmlLoader.load(getClass().getResource("/gui/fxmls/TelaVisu.fxml").openStream());
	    	Scene visualizar_Scene = new Scene(visualizar_parent);
	        stage.setScene(visualizar_Scene);
	        stage.setTitle("Ficha");
	        stage.setResizable(false);
	        stage.showAndWait();
	    }
	    
	    void carregarValores() {
	    
	    	nome.setText(person.getNomePersonagem());
	    	raca.setText(person.getRaca().getNome());
	    	classe.setText(person.getClasse().getNome());
	    	nivel.setText(String.format("%d", person.getNivel()));
	    	ouro.setText(String.format("%d", person.getOuro()));
	    	forca.setText(String.format("%d", person.getForca()));
	    	agilidade.setText(String.format("%d", person.getAgilidade()));
	    	inteligencia.setText(String.format("%d", person.getInteligencia()));
	    	vontade.setText(String.format("%d", person.getVontade()));
	    	vida.setText(String.format("%d", person.getVida()));
	    	mana.setText(String.format("%d", person.getMana()));
	    	vestimenta.setText(person.getVestimenta().getNome());
	    	maoDireita.setText(person.getMaoDireita().getNome());
	    	maoEsquerda.setText(person.getMaoEsquerda().getNome());
	    	corrida.setText(String.format("%d", person.getCorrida()));
	    	deslocamento.setText(String.format("%d", person.getDeslocamento()));
	    	bloqueio.setText(String.format("%d", person.getBloqueio()));
	    	esquiva.setText(String.format("%d", person.getEsquiva()));
	    	determinacao.setText(String.format("%d", person.getDeterminacao()));
	    	cargaBasica.setText(String.format("%d", person.getCargaBasica()));
	    	cargaMaxima.setText(String.format("%d", person.getCargaMaxima()));
	    	cargaPesada.setText(String.format("%d", person.getCargaPesada()));
	    	ObservableList<Habilidade> obLista = FXCollections.observableArrayList(person.getHabilidades());
	    	ObservableList<Equipamento> obLista2 = FXCollections.observableArrayList(person.getEquipamentos());
	    	listaHab.setItems(obLista);
	    	listaEquip.setItems(obLista2);
	    }
	    
	    
	    @FXML
	    void initialize() {
	    	carregarValores();
	    }
}
