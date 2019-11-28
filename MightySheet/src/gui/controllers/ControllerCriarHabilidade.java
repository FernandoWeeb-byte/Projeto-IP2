package gui.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.Fachada;
import negocio.beans.Arma;
import negocio.beans.Equipamento;
import negocio.beans.Habilidade;

public class ControllerCriarHabilidade {
	Fachada fachada = Fachada.getInstance();
	
    @FXML
    private TextField textRequisitos;

    @FXML
    private TextField textDificuldade;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textMana;

    @FXML
    private TextField textDescricao;

    @FXML
    private ComboBox<?> comboCategoria;

    @FXML
    private ComboBox<?> comboTipo;

    @FXML
    private TextField textRacas;

    @FXML
    private TextField textClasses;
    
    Habilidade hab = new Habilidade("", "", "", "", 0, 0, null, null, "");

    @FXML
    void cancelarHabilidade(ActionEvent event) throws IOException {
		Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
    	Scene Criacao_Habilidade_Scene = new Scene(parent_voltar);
    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	appStage.setScene(Criacao_Habilidade_Scene);
    	appStage.show();
    }

    @FXML
	 void salvarHabilidade(ActionEvent event) throws IOException {
		 fachada.adicionarHabilidade(hab);
		 fachada.salvarHabilidades();
		 Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
		 Scene Criacao_Habilidade_Scene = new Scene(parent_voltar);
		 Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		 appStage.setScene(Criacao_Habilidade_Scene);
		 appStage.show();
	 }
    
    void carregarCategorias() {
    	List<String> lista = new ArrayList<String>();
    	lista.add("Característica");
    	lista.add("Técnica");
    	lista.add("Magia");
    	lista.add("-");
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	comboCategoria.setItems(obLista);
    }
    
    @FXML
    void selectCategoria(ActionEvent event) {
    	hab.setCategoria((String) comboCategoria.getSelectionModel().getSelectedItem());
    	if(hab.getCategoria() == "Magia") {
    		textDificuldade.setDisable(false);
    	}
    	else {
    		textDificuldade.setDisable(true);
    	}
    }
    
    void carregarTipos() {
    	List<String> lista = new ArrayList<String>();
    	lista.add("Ação");
    	lista.add("Suporte");
    	lista.add("Reação");
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	comboTipo.setItems(obLista);
    }
    
    @FXML
    void selectTipo(ActionEvent event) {
    	hab.setTipo((String) comboTipo.getSelectionModel().getSelectedItem());
    	if(hab.getTipo() == "Suporte") {
    		textMana.setDisable(true);
    	}
    	else {
    		textMana.setDisable(false);
    	}
    }

    @FXML
    void setTextClasses(ActionEvent event) {
    	hab.setClasses(textClasses.getText());
    }

    @FXML
    void setTextDescricao(ActionEvent event) {
    	hab.setDescricao(textDescricao.getText());
    }

    @FXML
    void setTextDificuldade(ActionEvent event) {
    	hab.setDificuldade(Integer.parseInt(textDificuldade.getText()));
    }

    @FXML
    void setTextMana(ActionEvent event) {
    	hab.setMana(Integer.parseInt(textMana.getText()));
    }

    @FXML
    void setTextNome(ActionEvent event) {
    	hab.setNome(textNome.getText());
    }

    @FXML
    void setTextRacas(ActionEvent event) {
    	hab.setRacas(textRacas.getText());
    }

    @FXML
    void setTextRequisitos(ActionEvent event) {
    	hab.setRequisito(textRequisitos.getText());
    }
    
    @FXML
    void initialize() {
    	carregarCategorias();
    	carregarTipos();
    }

}
