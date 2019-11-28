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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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

	Equipamento item = new Equipamento("", 0, 0, 0, "", true);
    
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
		 fachada.adicionarEquipamento(item);
		 fachada.salvarEquipamentos();
		 Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
		 Scene Criacao_Item_Scene = new Scene(parent_voltar);
		 Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
		 appStage.setScene(Criacao_Item_Scene);
		 appStage.show();
	 }
	
    @FXML
    void checkIsCanalizador(ActionEvent event) {
    	if(checkCanalizador.isSelected() == true) {
    		item.setCanalizador(true);
    	}
    	else {
    		item.setCanalizador(false);
    	}
    }

    @FXML
    void checkIsCarregar(ActionEvent event) {
    	if(checkCarregar.isSelected() == true) {
    		((Arma) item).setCarregar(true);
    	}
    	else {
    		((Arma) item).setCarregar(false);
    	}
    }

    @FXML
    void checkIsDuasMaos(ActionEvent event) {
    	if(checkDuasMaos.isSelected() == true) {
    		((Arma) item).setDuasMaos(true);
    	}
    	else {
    		((Arma) item).setDuasMaos(false);
    	}
    }

    @FXML
    void checkIsEscudo(ActionEvent event) {
    	if(checkEscudo.isSelected() == true) {
    		((Protecao) item).setEscudo(true);
    	}
    	else {
    		((Protecao) item).setEscudo(false);
    	}
    }

    @FXML
    void checkIsPesada(ActionEvent event) {
    	if(checkPesada.isSelected() == true) {
    		((Protecao) item).setPesada(true);
    	}
    	else {
    		((Protecao) item).setPesada(false);
    	}
    }

    @FXML
    void checkIsRigida(ActionEvent event) {
    	if(checkRigida.isSelected() == true) {
    		((Protecao) item).setRigida(true);
    	}
    	else {
    		((Protecao) item).setRigida(false);
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
    	((Arma) item).setTipoDano((String) tipoDano.getSelectionModel().getSelectedItem());
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
    	((Arma) item).setDistancia((String) tipoDistancia.getSelectionModel().getSelectedItem());
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

    @FXML
    void setTextCusto(ActionEvent event) {
    	item.setCusto(Integer.parseInt(textCusto.getText()));
    }

    @FXML
    void setTextDano(ActionEvent event) {
        ((Arma)item).setDano(Integer.parseInt(textDano.getText()));
    }

    @FXML
    void setTextDefesa(ActionEvent event) {
    	if(checkEscudo.isSelected() == true) {
    		((Protecao)item).setBloqueio(Integer.parseInt(textDefesa.getText()));
    		((Protecao)item).setEsquiva(0);
    	}
    	else {
    		((Protecao)item).setBloqueio(Integer.parseInt(textDefesa.getText()));
    		((Protecao)item).setEsquiva(Integer.parseInt(textDefesa.getText()));
    	}
    }

    @FXML
    void setTextDescricao(ActionEvent event) {
    	item.setDescricao(textDescricao.getText());
    }

    @FXML
    void setTextFN(ActionEvent event) {
    	item.setfN(Integer.parseInt(textFN.getText()));
    }

    @FXML
    void setTextNome(ActionEvent event) {
    	item.setNome(textNome.getText());
    }

    @FXML
    void setTextPeso(ActionEvent event) {
    	item.setPeso(Double.parseDouble(textPeso.getText()));
    }
    
    @FXML
    void initialize() {
    	carregarDanos();
    	carregarDistancias();
    	carregarItens();
    }

}
