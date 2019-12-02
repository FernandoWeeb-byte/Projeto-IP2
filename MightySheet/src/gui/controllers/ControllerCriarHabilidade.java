package gui.controllers;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.Fachada;
import negocio.beans.Arma;
import negocio.beans.Classe;
import negocio.beans.Equipamento;
import negocio.beans.Habilidade;
import negocio.beans.Raca;

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
    private ComboBox<Raca> racas;

    @FXML
    private ComboBox<Classe> classes;
    
    @FXML
    private Label erro;

    
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
    	
    	if(!(textNome.getText() == null || textDescricao.getText() == null || classes.getValue()==null|| racas.getValue()==null
    			|| textRequisitos==null || comboCategoria.getValue()==null || comboTipo == null)) {
    	String[] str = {classes.getValue().getNome()};
    	hab.setClasses(str);
		hab.setNome(textNome.getText());
		hab.setDescricao(textDescricao.getText());
		if(!textDificuldade.isDisable()) {
			hab.setDificuldade(Integer.parseInt(textDificuldade.getText()));
		}
		if(!textMana.isDisable()) {
		hab.setMana(Integer.parseInt(textMana.getText()));
		}
		String[] str2 = {racas.getValue().getNome()};
		hab.setRacas(str2);
		hab.setRequisito(textRequisitos.getText());
		racas.getValue().getHabilidades().put(textNome.getText(), hab);
		classes.getValue().getHabilidades().put(textNome.getText(), hab);
    	fachada.adicionarHabilidade(hab);
		 fachada.salvarHabilidades();
		 Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
		 Scene Criacao_Habilidade_Scene = new Scene(parent_voltar);
		 Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		 appStage.setScene(Criacao_Habilidade_Scene);
		 appStage.show();
		 fachada.salvarTodosRepositórios();
    	}
    	else {
    		erro.setText("Preencha todos os espaços");
    	}
    		
    		
		 
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
    
    void carregarClasses()
    {
    	List<Classe> lista = new ArrayList<>();
    	lista.addAll(fachada.listarTodasClasses());
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	classes.getItems().addAll(obLista);
    }
    
    void carregarRacas()
    {
    	List<Raca> lista = new ArrayList<>();
    	lista.addAll(fachada.listarTodasRacas());
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	racas.getItems().addAll(obLista);
    			
    		
    			
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
    void setTextRequisitos(ActionEvent event) {
    	hab.setRequisito(textRequisitos.getText());
    }
    
    void soNumeros() {
    	textMana.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	            textMana.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    	
    	textDificuldade.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	            textDificuldade.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    	
    	
    }
    
    @FXML
    void initialize() {
    	carregarCategorias();
    	carregarTipos();
    	carregarClasses();
    	carregarRacas();
    	soNumeros();
    }

}
