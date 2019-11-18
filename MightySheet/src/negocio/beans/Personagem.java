package negocio.beans;

import java.util.ArrayList;
import java.util.HashMap;

public class Personagem {
	
	/// Atributos
	// Informações
	private String nomePersonagem;
	private String nomeJogador;
	private Raca raca;
	private Classe classe;
	private int nivel;
	private int experiencia;
	
	// Atributos
	private int forca;
	private int agilidade;
	private int inteligencia;
	private int vontade;
	private int vida;
	private int mana;
	private HashMap<String, Integer> pericias;
	
	// Defesas
	private int esquiva;
	private int bloqueio;
	private int determinacao;
	
	// Habilidades
	private Habilidade[] habilidadesAutomaticas;
	private ArrayList<Habilidade> habilidades;
	private int quantHabilidades;
	
	// Equipamentos
	private ArrayList<Arma> ataques;
	private ArrayList<Equipamento> equipamentos;
	private int ouro;
	
	
	/// Metodos
	public void alterarVida(int quant)
	{
		this.vida += quant;
	}

	public void alterarMana(int quant)
	{
		this.mana += quant;
	}

	public void alterarOuro(int quant)
	{
		this.ouro += quant;
	}
}
