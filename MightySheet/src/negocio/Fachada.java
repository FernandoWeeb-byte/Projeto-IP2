package negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import negocio.beans.*;
import negocio.controladores.*;

public class Fachada {
	
	/// Singleton
	private static Fachada INSTANCE;
	
	
	/// Atributos
	private ControladorClasses controlCls;
	private ControladorHabilidades controlHab;
	private ControladorRacas controlRc;
	private ControladorPersonagens controlPer;
	private ControladorEquipamentos controlEquips;
	
	
	/// Construturo
	private Fachada()
	{
		controlCls = new ControladorClasses();
		controlHab = new ControladorHabilidades();
		controlRc = new ControladorRacas();
		controlPer = new ControladorPersonagens();
		controlEquips = new ControladorEquipamentos();
	}
	
	
	/// Metodos
	public static Fachada getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new Fachada();
		}
		
		return INSTANCE;
	}
	
	public void salvarTodosRepositórios()
	{
		salvarClasses();
		salvarHabilidades();
		salvarEquipamentos();
		salvarRacas();
		salvarPersonagens();
	}
	
	
	/// Metodos delegate <ControladorClasses>
	public boolean adicionarClasse(Classe cls) {
		return controlCls.adicionarClasse(cls);
	}

	public boolean removerClasse(String nome) {
		return controlCls.removerClasse(nome);
	}

	public Classe buscarClasse(String nome) {
		return controlCls.buscarClasse(nome);
	}

	public boolean modificarClasse(Classe cls) {
		return controlCls.modificarClasse(cls);
	}

	public List<Classe> listarTodasClasses() {
		return controlCls.listarTodasClasses();
	}
	
	public boolean salvarClasses() {
		return controlCls.salvarClasses();
	}


	/// Metodos delegate <ControladorHabilidade>
	public boolean adicionarHabilidade(Habilidade hab) {
		return controlHab.adicionarHabilidade(hab);
	}

	public boolean removerHabilidade(String nome) {
		return controlHab.removerHabilidade(nome);
	}

	public Habilidade buscarHabilidade(String nome) {
		return controlHab.buscarHabilidade(nome);
	}

	public boolean modificarHabilidade(Habilidade hab) {
		return controlHab.modificarHabilidade(hab);
	}

	public List<Habilidade> listarTodasHabilidades() {
		return controlHab.listarTodasHabilidades();
	}

	public List<Habilidade> listarHabilidadePorClasse(String nome) {
		return controlHab.listarHabilidadePorClasse(nome);
	}

	public List<Habilidade> listarHabilidadesPorRaca(String nome) {
		return controlHab.listarHabilidadesPorRaca(nome);
	}

	public List<Habilidade> listarHabilidadesPorTipo(String tipo) {
		return controlHab.listarHabilidadesPorTipo(tipo);
	}

	public List<Habilidade> listarHabilidadesPorCategoria(String categoria) {
		return controlHab.listarHabilidadesPorCategoria(categoria);
	}

	public List<Habilidade> listarHabilidadesComCustoManaMenorQue(int valor) {
		return controlHab.listarHabilidadesComCustoManaMenorQue(valor);
	}

	public boolean salvarHabilidades() {
		return controlHab.salvarHabilidades();
	}
	
	public List<Habilidade> habilidadesBasicaAvancadaOuFinal(Classe classe, int level)
	{
		return controlHab.habilidadesBasicaAvancadaOuFinal(classe, level);
	}
	
	public List<Habilidade> listarHabilidadePorClasse(Classe classe)
	{
		return controlHab.listarHabilidadePorClasse(classe);
	}
	
	public List<Habilidade> listarHabilidadesPorRaca(Raca raca)
	{
		return controlHab.listarHabilidadesPorRaca(raca);
	}

	/// Metodos delegate <ControladorRacas>
	public boolean adicionarRaca(Raca raca) {
		return controlRc.adicionarRaca(raca);
	}

	public boolean removerRaca(String nome) {
		return controlRc.removerRaca(nome);
	}

	public Raca buscarRaca(String nome) {
		return controlRc.buscarRaca(nome);
	}

	public boolean modificarRaca(Raca raca) {
		return controlRc.modificarRaca(raca);
	}

	public List<Raca> listarTodasRacas() {
		return controlRc.listarTodasRacas();
	}
	
	public boolean salvarRacas() {
		return controlRc.salvarRacas();
	}


	/// Metodos delegate <ControladorPersonagem>
	public boolean salvar(Personagem p) {
		return controlPer.salvar(p);
	}

	public List<Personagem> todas() {
		return controlPer.todas();
	}

	public void adicionarFicha(Personagem novo) {
		controlPer.adicionarFicha(novo);
	}

	public void removerFicha(String nomePersonagem) {
		controlPer.removerFicha(nomePersonagem);
	}

	public List<Personagem> listaDaClasse(Classe classe) {
		return controlPer.listaDaClasse(classe);
	}

	public List<Personagem> listaDaRaca(Raca raca) {
		return controlPer.listaDaRaca(raca);
	}

	public List<Personagem> listaDoJogador(String nomeJogador) {
		return controlPer.listaDoJogador(nomeJogador);
	}

	public Personagem buscaPorPers(String nome) {
		return controlPer.buscaPorPers(nome);
	}

	public void editarFicha(String nomePer, int nivel, int experiencia, int inteligencia, int forca, int vontade,
			int vida, int mana, HashMap<String, Integer> pericias, Habilidade[] habilidadesAutomaticas,
			ArrayList<Habilidade> habilidades, int quantHabilidades, ArrayList<Arma> ataques,
			ArrayList<Equipamento> equipamentos, int ouro) {
		controlPer.editarFicha(nomePer, nivel, experiencia, inteligencia, forca, vontade, vida, mana, pericias,
				habilidadesAutomaticas, habilidades, quantHabilidades, ataques, equipamentos, ouro);
	}
	
	public void salvarPersonagens()
	{
		this.controlPer.salvarPersonagens();
	}

	
	/// Metodos delegate <ControladorEquipamentos>
	public boolean adicionarEquipamento(Equipamento novo) {
		return controlEquips.adicionarEquipamento(novo);
	}

	public boolean removerEquipamento(String nome) {
		return controlEquips.removerEquipamento(nome);
	}

	public Equipamento buscarEquipamento(String nome) {
		return controlEquips.buscarEquipamento(nome);
	}

	public boolean modificarEquipamento(Equipamento novo) {
		return controlEquips.modificarEquipamento(novo);
	}

	public List<Equipamento> listarTodosItens() {
		return controlEquips.listarTodosItens();
	}

	public List<Equipamento> listarItensComuns() {
		return controlEquips.listarItensComuns();
	}

	public List<Equipamento> listarTodosCanalizadores() {
		return controlEquips.listarTodosCanalizadores();
	}

	public List<Arma> listarTodasArmas() {
		return controlEquips.listarTodasArmas();
	}

	public List<Protecao> listarTodasArmaduras() {
		return controlEquips.listarTodasArmaduras();
	}

	public boolean salvarEquipamentos() {
		return controlEquips.salvarEquipamentos();
	}
}
