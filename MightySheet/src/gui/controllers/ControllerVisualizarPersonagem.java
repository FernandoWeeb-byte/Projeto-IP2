package gui.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
	    private ListView<?> listaHab;

	    @FXML
	    private ListView<?> listaEquip;

	    @FXML
	    void initialize() {
	    	
	    }
}
