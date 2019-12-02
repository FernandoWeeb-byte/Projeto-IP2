package gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import dados.interfaces.IRepoPersonagens;
import dados.repositorios.RepositorioPersonagens;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.Fachada;
import negocio.beans.Arma;
import negocio.beans.Classe;
import negocio.beans.Equipamento;
import negocio.beans.Habilidade;
import negocio.beans.Personagem;
import negocio.beans.Protecao;
import negocio.beans.Raca;

public class ControllerEditarFicha {
	/// Fachada
		private Fachada fachada = Fachada.getInstance();
		
		@FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;
	    
	    @FXML
	    private TextField classe;

	    @FXML
	    private TextField raca;

	    @FXML
	    private TextField forca;

	    @FXML
	    private TextField agilidade;

	    @FXML
	    private TextField inteligencia;

	    @FXML
	    private TextField vontade;

	    @FXML
	    private ComboBox<?> vestimenta;

	    @FXML
	    private ComboBox<Arma> maoDireita;

	    @FXML
	    private ComboBox<Protecao> maoEsquerda;

	    @FXML
	    private Button adcForca;

	    @FXML
	    private Button adcAgilidade;

	    @FXML
	    private Button adcInteligencia;

	    @FXML
	    private Button adcVontade;

	    @FXML
	    private TextField nome;

	    @FXML
	    private ComboBox<Integer> nivel;

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
	    private TextField deslocamento;

	    @FXML
	    private TextField corrida;
	    
	    @FXML
	    private ListView<Habilidade> skilList;
	    
	    @FXML
	    private ListView<Equipamento> skillListC;


	    @FXML
	    private Button salvar;
	    
	    @FXML
	    private TextField pV;

	    @FXML
	    private TextField pM;
	    
	    @FXML
	    private Label erro;
	    
	    @FXML
	    private Label qtdHab;

	    @FXML
	    private Label ptsAtributos;
	    
	    @FXML
	    private TextField ouro;
	    
	    Personagem person = new Personagem(null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, null, null, null, 0);
	    Personagem novoPerson = Personagem.visuPerson;
	    Personagem lojaPerson = Personagem.novoPerson;
	     
	    

	    
	    
	    @FXML
	    void escolherNivel(ActionEvent event) {
	    	person.setPtsAtributo(0);
	    	person.setNivel((int)nivel.getValue());
	    	person.calculoPtsAtributo(person.getNivel());
	    	person.calcularVida();
	    	person.calcularMana();
	    	person.setDeslocamento();
	    	ptsAtributos.setText(String.format("%d", person.getPtsAtributo()));
	    	pV.setText(String.format("%d", person.getVida()));
	    	pM.setText(String.format("%d", person.getMana()));
	    	deslocamento.setText(String.format("%d", person.getDeslocamento()));
	    	person.setQuantHabilidades();
	    	qtdHab.setText(String.format("%d", person.getQuantHabilidades()));
	    	String[] str = {null, null, null, null};
	    	if(!(novoPerson.getClasse() == null || novoPerson.getRaca() == null)) {
	    		str[0] = String.format("%d",novoPerson.getRaca().getForca() + novoPerson.getClasse().getBonusForca());
	    		forca.setText(str[0]);
	    		person.setForca(Integer.parseInt(forca.getText()));
	    		str[1] = String.format("%d",novoPerson.getRaca().getAgilidade() + novoPerson.getClasse().getBonusAgilidade());
	    		agilidade.setText(str[1]);
	    		person.setAgilidade(Integer.parseInt(agilidade.getText()));
	    		str[2] = String.format("%d",novoPerson.getRaca().getInteligencia() + novoPerson.getClasse().getBonusInteligencia());
	    		inteligencia.setText(str[2]);
	    		person.setInteligencia(Integer.parseInt(inteligencia.getText()));
	    		str[3] = String.format("%d",novoPerson.getRaca().getVontade() + novoPerson.getClasse().getBonusVontade());
	    		vontade.setText(str[3]);
	    		person.setVontade(Integer.parseInt(vontade.getText()));
	    	}
	    	
	    }
	    
	    void carregarNiveis()
	    {
	    	ObservableList<Integer> obLista;
	    	Integer[] niveis = {1,2,3,4,5,6,7,8,9,10};
	    	obLista = FXCollections.observableArrayList(niveis);
	    	nivel.setItems(obLista);
	    }
	    
	    @FXML
	    void escolherH(ActionEvent event) throws IOException {

	    	if(!(novoPerson.getClasse() == null && novoPerson.getRaca() == null && nivel.getValue() == null)) {
	    	lojaPerson.setClasse(novoPerson.getClasse());
	    	lojaPerson.setRaca(novoPerson.getRaca());
	    	lojaPerson.setNivel(nivel.getValue());
	    	lojaPerson.setHabilidades(novoPerson.getHabilidades());
	    	Stage stage = new Stage();
	    	FXMLLoader FxmlLoader = new FXMLLoader();
	    	Parent loja_parent = FxmlLoader.load(getClass().getResource("/gui/fxmls/Habilidades.fxml").openStream());
	    	Scene loja_Scene = new Scene(loja_parent);
	        stage.setScene(loja_Scene);
	        stage.setTitle("Loja");
	        stage.setResizable(false);
	        stage.showAndWait();
	    	}
	    	else {
	    		erro.setText("selecione a classe, a raça e o nivel");
	    	}
	    }
	    
	    @FXML
	    void removerH(ActionEvent event) {
	    	skilList.getItems().remove(skilList.getSelectionModel().getSelectedItem());
	    	
	    }
	    
	    @FXML
	    void carregarH(ActionEvent event) {
	    	ObservableList obLista;
	    	List<Habilidade> lista = lojaPerson.getHabilidades();
	    	person.setHabilidades(lojaPerson.getHabilidades());
	    	lojaPerson.setHabilidades(null);
	    	obLista = FXCollections.observableArrayList(lista);
	    	skilList.getItems().addAll(obLista);
	    }
	    
	    void calcularValores()
	    {
	    	String[] str = {null, null, null,null, null}; 
	    	
	    	//Carga basica
	    	person.setCargaBasica(Integer.parseInt(forca.getText()));
	    	str[0] = String.format("%d", person.getCargaBasica());
	    	cargaBasica.setText(str[0]);
	    	//carga Pesada
	    	person.setCargaPesada(person.getCargaBasica());
	    	str[1] = String.format("%d", person.getCargaPesada());
	    	cargaPesada.setText(str[1]);
	    	//carga Maxima
	    	person.setCargaMaxima(person.getCargaBasica());
	    	str[2] = String.format("%d", person.getCargaMaxima());
	    	cargaMaxima.setText(str[2]);
	    	//deslocamento
	    	person.setDeslocamento();
	    	str[3] = String.format("%d", person.getDeslocamento());
	    	deslocamento.setText(str[3]);
	    	//Determinação
	    	person.setDeterminacao();
	    	str[4] = String.format("%d", person.getDeterminacao());
	    	determinacao.setText(str[4]);
	    	
	    }
	    
	    void carregarPersonagem()
	    {
	    	nome.setText(novoPerson.getNomePersonagem());
	    	raca.setText(novoPerson.getRaca().getNome());
	    	classe.setText(novoPerson.getClasse().getNome());
	    	nivel.setValue(novoPerson.getNivel());
	    	ouro.setText(String.format("%d", novoPerson.getOuro()));
	    	forca.setText(String.format("%d", novoPerson.getForca()));
	    	agilidade.setText(String.format("%d", novoPerson.getAgilidade()));
	    	inteligencia.setText(String.format("%d", novoPerson.getInteligencia()));
	    	vontade.setText(String.format("%d", novoPerson.getVontade()));
	    	pV.setText(String.format("%d", novoPerson.getVida()));
	    	pM.setText(String.format("%d", novoPerson.getMana()));
	    	corrida.setText(String.format("%d", novoPerson.getCorrida()));
	    	deslocamento.setText(String.format("%d", novoPerson.getDeslocamento()));
	    	bloqueio.setText(String.format("%d", novoPerson.getBloqueio()));
	    	esquiva.setText(String.format("%d", novoPerson.getEsquiva()));
	    	determinacao.setText(String.format("%d", novoPerson.getDeterminacao()));
	    	cargaBasica.setText(String.format("%d", novoPerson.getCargaBasica()));
	    	cargaMaxima.setText(String.format("%d", novoPerson.getCargaMaxima()));
	    	cargaPesada.setText(String.format("%d", novoPerson.getCargaPesada()));
	    	ObservableList<Habilidade> obLista = FXCollections.observableArrayList(novoPerson.getHabilidades());
	    	ObservableList<Equipamento> obLista2 = FXCollections.observableArrayList(novoPerson.getEquipamentos());
	    	person.setEquipamentos(novoPerson.getEquipamentos());
	    	skilList.setItems(obLista);
	    	skillListC.setItems(obLista2);
	    	person = novoPerson;
	    }
	    
	    @FXML
	    void upAtributo(ActionEvent event) {
	    	if(person.getPtsAtributo() > 0) {
	    	if(adcForca.isArmed())
	    	{
	    		person.forUp(1);
	    		person.setPtsAtributo(person.getPtsAtributo()-1);
	    		ptsAtributos.setText(String.format("%d", person.getPtsAtributo()));
	    		forca.setText(String.format("%d",person.getForca()));
	    		calcularValores();
	    	}
	    	if(adcAgilidade.isArmed())
	    	{
	    		person.agiUp(1);
	    		person.setPtsAtributo(person.getPtsAtributo()-1);
	    		ptsAtributos.setText(String.format("%d", person.getPtsAtributo()));
	    		agilidade.setText(String.format("%d",person.getAgilidade()));
	    		person.setDeslocamento();
	    		calcularValores();
	    		
	    	}
	    	if(adcInteligencia.isArmed())
	    	{
	    		person.intUp(1);
	    		person.setPtsAtributo(person.getPtsAtributo()-1);
	    		ptsAtributos.setText(String.format("%d", person.getPtsAtributo()));
	    		inteligencia.setText(String.format("%d",person.getInteligencia()));
	    		calcularValores();
	    	}
	    	if(adcVontade.isArmed())
	    	{
	    		person.vonUp(1);
	    		person.setPtsAtributo(person.getPtsAtributo()-1);
	    		ptsAtributos.setText(String.format("%d", person.getPtsAtributo()));
	    		vontade.setText(String.format("%d",person.getVontade()));
	    		calcularValores();
	    	}
	    	}
	    }
	    
	    @FXML
	    void Loja(ActionEvent event) throws IOException {
	    	lojaPerson.setOuro(Integer.parseInt(ouro.getText()));
	    	
	    	Stage stage = new Stage();
	    	FXMLLoader FxmlLoader = new FXMLLoader();
	    	Parent loja_parent = FxmlLoader.load(getClass().getResource("/gui/fxmls/Loja.fxml").openStream());
	    	Scene loja_Scene = new Scene(loja_parent);
	        stage.setScene(loja_Scene);
	        stage.setTitle("Loja");
	        stage.setResizable(false);
	        stage.showAndWait();
	        
	    	
	    }
	    
	    @FXML
	    void entrega(ActionEvent event) {
	    	ObservableList obLista;
	    	person.setEquipamentos(lojaPerson.getEquipamentos());
	    	List<Equipamento> lista = person.getEquipamentos();
	    	lojaPerson.setEquipamentos(null);
	    	person.setOuro(lojaPerson.getOuro());
	    	ouro.setText(String.format("%d", person.getOuro()));
	    	obLista = FXCollections.observableArrayList(lista);
	    	skillListC.getItems().addAll(obLista);
	    	carregarItens();
	    	
	    }
	    
	    void soNumeros() {
	    	ouro.textProperty().addListener(new ChangeListener<String>() {
	    	    @Override
	    	    public void changed(ObservableValue<? extends String> observable, String oldValue, 
	    	        String newValue) {
	    	        if (!newValue.matches("\\d*")) {
	    	            ouro.setText(newValue.replaceAll("[^\\d]", ""));
	    	        }
	    	    }
	    	});
	    }
	    
	    void carregarItens()
	    {
	    	List<Protecao> protecoes = new ArrayList<>();
	    	List<Protecao> armadura = new ArrayList<>();
	    	List<Protecao> escudos = new ArrayList<>();
	    	List<Arma> armas = new ArrayList<>();
	    	for(Equipamento equip : person.getEquipamentos())
	    	{
	    		if(equip.getClass().equals(Protecao.class))
	    		{
	    			protecoes.add((Protecao) equip);
	    			
	    		}
	    	}
	    	
	    	for(Protecao prot : protecoes)
	    	{
	    		if(!prot.isEscudo())
	    		{
	    			armadura.add(prot);
	    		}
	    		else {
	    			escudos.add(prot);
	    		}
	    	}
	    	
	    	for(Equipamento equip : person.getEquipamentos())
	    	{
	    		if(equip.getClass().equals(Arma.class))
	    		{
	    			armas.add((Arma) equip);
	    		}
	    	}
	    	
	    	
	    	ObservableList obLista;
	    	ObservableList obLista2;
	    	ObservableList obLista3;
	    	obLista = FXCollections.observableArrayList(armadura);
	    	obLista2 = FXCollections.observableArrayList(escudos);
	    	obLista3 = FXCollections.observableArrayList(armas);
	    	vestimenta.getItems().addAll(obLista);
	    	maoEsquerda.getItems().addAll(obLista2);
	    	maoDireita.getItems().addAll(obLista3);
	    	
	    	
	    	
	    }
	    
	    @FXML
	    void escolherEscudo(ActionEvent event) {
	    	person.setMaoEsquerda(maoEsquerda.getValue());
	    	person.setBloqueio();
	    	bloqueio.setText(String.format("%d", person.getBloqueio()));
	    	
	    	
	    	
	    }
	    
	    @FXML
	    void escolherVestimenta(ActionEvent event) {
	    	
	    	person.setVestimenta((Protecao) vestimenta.getValue());
	    	person.setCorrida();
	    	corrida.setText(String.format("%d", person.getCorrida()));
	    	person.setEsquiva();
	    	esquiva.setText(String.format("%d", person.getEsquiva()));
	    }
	    
	    @FXML
	    void vender(ActionEvent event) {
	    	if(skillListC.getSelectionModel().getSelectedItem().getClass().equals(Protecao.class)) {
	    		Protecao prot = (Protecao) skillListC.getSelectionModel().getSelectedItem();
	    		if(!prot.isEscudo()) {
	    			vestimenta.getItems().remove(skillListC.getSelectionModel().getSelectedItem());
	    		}
	    		else {
	    			maoEsquerda.getItems().remove(skillListC.getSelectionModel().getSelectedItem());
	    		}
	    	}
	    	else if(skillListC.getSelectionModel().getSelectedItem().getClass().equals(Arma.class)) {
	    		maoDireita.getItems().remove(skillListC.getSelectionModel().getSelectedItem());
	    	}
	    	skillListC.getItems().remove(skillListC.getSelectionModel().getSelectedItem());
	    	person.setOuro(person.getOuro()+skillListC.getSelectionModel().getSelectedItem().getCusto());
	    	ouro.setText(String.format("%d", person.getOuro()));
	    	
	    	
	    }
	    
	    
	    @FXML
	    void salvar(ActionEvent event) throws IOException {
	    	if(!(nome.getText()==null || nivel.getValue()==null || skilList.getItems()==null || vestimenta.getValue()==null
	    			|| maoDireita.getValue()==null || maoEsquerda.getValue()==null)) {
	    	person.setNomePersonagem(nome.getText());
	    	person.setVida(Integer.parseInt(pV.getText()));
	    	person.setMana(Integer.parseInt(pM.getText()));
	    	person.setMaoDireita(maoDireita.getValue());
	    	person.setOuro(Integer.parseInt(ouro.getText()));
	    	ArrayList<Habilidade> hab = new ArrayList<>();
	    	hab.addAll((Collection<? extends Habilidade>) skilList.getItems());
	    	person.setHabilidades(hab);
	    	ArrayList<Equipamento> equip = new ArrayList<>();
	    	equip.addAll(skillListC.getItems());
	    	person.setEquipamentos(equip);
	    	IRepoPersonagens lista = RepositorioPersonagens.getInstance();
	    	lista.AdicionarFicha(person);
	    	fachada.salvar(person);
	    	Parent parent_voltar = FXMLLoader.load(getClass().getResource("/gui/fxmls/TelaInicial.fxml"));
	    	Scene Tela_Inicial_Scene = new Scene(parent_voltar);
	    	Stage appStage = (Stage) (((Node) event.getSource()).getScene().getWindow());
	    	appStage.setScene(Tela_Inicial_Scene);
	    	appStage.show();
	    	fachada.salvarTodosRepositórios();
	    	}
	    }
	    
	    @FXML
	    void initialize() {
	    	carregarPersonagem();
	    	carregarNiveis();
	    	carregarItens();
	    	soNumeros();
	    	
	    	
	    }
		
}
