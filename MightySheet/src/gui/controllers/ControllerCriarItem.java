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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.Fachada;
import negocio.beans.Arma;
import negocio.beans.Equipamento;
import negocio.beans.Protecao;

public class ControllerCriarItem {
	Fachada fachada = Fachada.getInstance();	
	
	@FXML
    private Button cancelarItem;

    @FXML
    private Button salvarItem;

    @FXML
    private CheckBox checkCarregar;

    @FXML
    private CheckBox checkDuasMaos;

    @FXML
    private CheckBox checkPesada;

    @FXML
    private CheckBox checkCanalizador;

    @FXML
    private CheckBox checkEscudo;

    @FXML
    private CheckBox checkRigida;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textCusto;

    @FXML
    private TextField textDefesa;

    @FXML
    private TextField textFN;

    @FXML
    private TextField textPeso;

    @FXML
    private TextField textDano;

    @FXML
    private TextField textDescricao;

    @FXML
    private ComboBox<?> tipoItem;

    @FXML
    private ComboBox<?> tipoDano;

    @FXML
    private ComboBox<?> tipoDistancia;
    
    @FXML
    private Label erro;

	Equipamento item = new Equipamento("", 0, 0, 0, "", false);
	Arma arma = new Arma(null, 0, 0, 0, null, false, 0, null, null, false, false);
	Protecao prot = new Protecao(null, 0, 0, 0, null, false, 0, 0, false, false, false);
    
	@FXML
    void cancelarItem(ActionEvent event) throws IOException {
		Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
    	Scene Criacao_Item_Scene = new Scene(parent_voltar);
    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    	appStage.setScene(Criacao_Item_Scene);
    	appStage.show();
    }
	
	 @FXML
	 void salvarItem(ActionEvent event) throws IOException {
		 if(!(tipoItem.getSelectionModel().getSelectedItem() == null)) {
		 if((String) tipoItem.getSelectionModel().getSelectedItem() == "Arma") {
			if(!(textNome.getText() == null || textCusto.getText() == null || textDescricao.getText() == null 
					|| textFN.getText() == null || textPeso.getText() == null || textDano.getText() == null)) {
			 arma.setNome(textNome.getText());
			 arma.setCusto(Integer.parseInt(textCusto.getText()));
			 arma.setDescricao(textDescricao.getText());
			 arma.setfN(Integer.parseInt(textFN.getText()));
			 arma.setPeso(Double.parseDouble(textPeso.getText()));
			 arma.setDano(Integer.parseInt(textDano.getText()));
			 checkIsCarregar();
			 checkIsDuasMaos();
			 checkIsRigida();
			 fachada.adicionarEquipamento(arma);
			 fachada.salvarEquipamentos();
			 Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
			 Scene Criacao_Item_Scene = new Scene(parent_voltar);
			 Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
			 appStage.setScene(Criacao_Item_Scene);
			 appStage.show();
			 fachada.salvarTodosRepositórios();
			}else {
				erro.setText("Preencha todos os espaços");
			}
			 	
	    	}
	    	else if ((String) tipoItem.getSelectionModel().getSelectedItem() == "Protecao") {
	    	
	    		if(!(textNome.getText() == null || textCusto.getText() == null || textDescricao.getText() == null 
						|| textFN.getText() == null || textPeso.getText() == null)) {
	    		prot.setNome(textNome.getText());
	   		 	prot.setCusto(Integer.parseInt(textCusto.getText()));
	   		 	prot.setDescricao(textDescricao.getText());
	   		 	prot.setfN(Integer.parseInt(textFN.getText()));
			 	prot.setPeso(Double.parseDouble(textPeso.getText()));
			 	checkIsEscudo();
			 	checkIsPesada();
			 	if(checkEscudo.isSelected() == true) {
		    			prot.setBloqueio(Integer.parseInt(textDefesa.getText()));
		    			prot.setEsquiva(0);
		    		}
		    		else {
		    			prot.setBloqueio(Integer.parseInt(textDefesa.getText()));
		    			prot.setEsquiva(Integer.parseInt(textDefesa.getText()));
		    		}
	   		 	fachada.adicionarEquipamento(item);
	   		 	fachada.salvarEquipamentos();
	   		 	Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
	   		 	Scene Criacao_Item_Scene = new Scene(parent_voltar);
	   		 	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
	   		 	appStage.setScene(Criacao_Item_Scene);
	   		 	appStage.show();
	   		 	fachada.salvarTodosRepositórios();
	    		}else {
	    			erro.setText("Preencha todos os espaços");
	    		}
	    	}
	    	else {
	    	
	    		if(!(textNome.getText() == null || textCusto.getText() == null || textDescricao.getText() == null 
						|| textFN.getText() == null || textPeso.getText() == null)) {
	    			item.setNome(textNome.getText());
	    			item.setCusto(Integer.parseInt(textCusto.getText()));
	    			item.setDescricao(textDescricao.getText());
	    			item.setfN(Integer.parseInt(textFN.getText()));
	    			item.setPeso(Double.parseDouble(textPeso.getText()));
	    			checkIsCanalizador();
	    			fachada.adicionarEquipamento(item);
	    			fachada.salvarEquipamentos();
	    			Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
	    			Scene Criacao_Item_Scene = new Scene(parent_voltar);
	    			Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
	    			appStage.setScene(Criacao_Item_Scene);
	    			appStage.show();
	    			fachada.salvarTodosRepositórios();
	    		}else {
	    			erro.setText("Preencha todos os espaços");
	    		}
	    	}
		 }else {
			 erro.setText("Preencha todos os espaços");
		 }
		 
	 }
	
    
    void checkIsCanalizador() {
    	if(checkCanalizador.isSelected() == true) {
    		item.setCanalizador(true);
    	}
    	else {
    		item.setCanalizador(false);
    	}
    }

    
    void checkIsCarregar() {
    	if(checkCarregar.isSelected() == true) {
    		arma.setCarregar(true);
    	}
    	else {
    		arma.setCarregar(false);
    	}
    }

    
    void checkIsDuasMaos() {
    	if(checkDuasMaos.isSelected() == true) {
    		arma.setDuasMaos(true);
    	}
    	else {
    		arma.setDuasMaos(false);
    	}
    }

    
    void checkIsEscudo() {
    	if(checkEscudo.isSelected() == true) {
    		prot.setEscudo(true);
    	}
    	else {
    		prot.setEscudo(false);
    	}
    }

    
    void checkIsPesada() {
    	if(checkPesada.isSelected() == true) {
    		prot.setPesada(true);
    	}
    	else {
    		prot.setPesada(false);
    	}
    }

    
    void checkIsRigida() {
    	if(checkRigida.isSelected() == true) {
    		prot.setRigida(true);
    	}
    	else {
    		prot.setRigida(false);
    	}
    }
    
    void carregarDanos() {
    	List<String> lista = new ArrayList<String>();
    	lista.add("Contusão");
    	lista.add("Corte");
    	lista.add("Perfuração");
    	lista.add("Cont e Perf");
    	lista.add("Corte e Perf");
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	tipoDano.setItems(obLista);
    }
    
    @FXML
    void selectDano(ActionEvent event) {
    	arma.setTipoDano((String) tipoDano.getSelectionModel().getSelectedItem());
    }
    
    void carregarDistancias() {
    	List<String> lista = new ArrayList<String>();
    	lista.add("Corpo-a-corpo");
    	lista.add("Haste");
    	lista.add("Curto");
    	lista.add("Médio");
    	lista.add("Longo");
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	tipoDistancia.setItems(obLista);
    }
    
    @FXML
    void selectDistancia(ActionEvent event) {
    	arma.setDistancia((String) tipoDistancia.getSelectionModel().getSelectedItem());
    }
    
    void carregarItens() {
    	List<String> lista = new ArrayList<String>();
    	lista.add("Equipamento");
    	lista.add("Arma");
    	lista.add("Protecao");
    	ObservableList obLista = FXCollections.observableArrayList(lista);
    	tipoItem.setItems(obLista);
    }
    
    @FXML
    void selectItem(ActionEvent event) {
    	if((String) tipoItem.getSelectionModel().getSelectedItem() == "Arma") {
		 	checkCarregar.setDisable(false);
		 	checkDuasMaos.setDisable(false);
		 	checkCanalizador.setDisable(false);
		 	checkPesada.setDisable(true);
		 	checkRigida.setDisable(true);
		 	checkEscudo.setDisable(true);
		 	textDefesa.setDisable(true);
		 	textDano.setDisable(false);
		 	tipoDano.setDisable(false);
		 	tipoDistancia.setDisable(false);
		 	
		 	
		 	
		 	
    	}
    	else if ((String) tipoItem.getSelectionModel().getSelectedItem() == "Protecao") {
    		checkCarregar.setDisable(true);
		 	checkDuasMaos.setDisable(true);
		 	checkCanalizador.setDisable(true);
		 	checkPesada.setDisable(false);
		 	checkRigida.setDisable(false);
		 	checkEscudo.setDisable(false);
		 	textDefesa.setDisable(false);
		 	textDano.setDisable(true);
		 	tipoDano.setDisable(true);
		 	tipoDistancia.setDisable(true);
		 	
    	}
    	else {
    		checkCarregar.setDisable(true);
		 	checkDuasMaos.setDisable(true);
		 	checkCanalizador.setDisable(false);
		 	checkPesada.setDisable(true);
		 	checkRigida.setDisable(true);
		 	checkEscudo.setDisable(true);
		 	textDefesa.setDisable(true);
		 	textDano.setDisable(true);
		 	tipoDano.setDisable(true);
		 	tipoDistancia.setDisable(true);
    	}
    }
    
    void soNumeros() {
    	textCusto.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	            textCusto.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    	
    	textDano.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	            textDano.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    	
    	textDefesa.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	            textDefesa.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    	
    	textFN.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	            textFN.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    	
    	textPeso.textProperty().addListener(new ChangeListener<String>() {
    	    @Override
    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
    	        String newValue) {
    	        if (!newValue.matches("\\d*")) {
    	            textPeso.setText(newValue.replaceAll("[^\\d]", ""));
    	        }
    	    }
    	});
    }
    
    @FXML
    void initialize() {
    	carregarDanos();
    	carregarDistancias();
    	carregarItens();
    	soNumeros();
    }

}
