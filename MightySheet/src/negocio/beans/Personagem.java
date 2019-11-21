package negocio.beans;

import java.util.ArrayList;
import java.util.HashMap;



public class Personagem {
	
	/// Atributos
	// Informacoes
	private String nomePersonagem;
	private String nomeJogador;
	private Raca raca;
	private Classe classe;
	private int nivel;
	private int experiencia;
	private int deslocamento;
	private int corrida;
	
	
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
  
  
	public Personagem(String nome, Raca raca, Classe classe, int nivel, int forca, int inteligencia, int von,
			int pv, int pm, int desl, int corr, int bloq, int esq, int det) {
		this.nomePersonagem = nome;
		this.raca = raca;
		this.classe = classe;
		this.nivel = nivel;
		this.forca = forca;
		this.inteligencia = inteligencia;
		this.vontade = von;
		this.vida = pv;
		this.mana = pm;
		this.deslocamento = desl;
		this.corrida = corr;
		this.bloqueio = bloq;
		this.esquiva = esq;
		this.determinacao = det;
	}

	/// Metodos
	public void alterarVida(int quant) {
		this.vida += quant;
	}

	public void alterarMana(int quant) {
		this.mana += quant;
	}

	public void alterarOuro(int quant) {
		this.ouro += quant;
	}
	
	/// Getters
	
	public String getNomeJogador() {return this.nomeJogador;}
	public String getNomePersonagem() {return this.nomePersonagem;}
	public Raca getRaca() {return this.raca;}
	public Classe getClasse() {return this.classe;}
	public int getNivel() {return this.nivel;}
	public int getExperiencia() {return experiencia;}
	public int getForca() {	return forca;}
	public int getAgilidade() {	return agilidade;}
	public int getInteligencia() {return inteligencia;}
	public int getVontade() {return vontade;}
	public int getVida() {return vida;}	
	public int getMana() {return mana;}	
	public HashMap<String, Integer> getPericias() {return pericias;}	
	public int getEsquiva() {return esquiva;}	
	public int getBloqueio() {return bloqueio;}
	public int getDeterminacao() {return determinacao;}
	public Habilidade[] getHabilidadesAutomaticas() {return habilidadesAutomaticas;}
	public ArrayList<Habilidade> getHabilidades() {return habilidades;}
	public int getQuantHabilidades() {return quantHabilidades;}
	public ArrayList<Arma> getAtaques() {return ataques;}
	public ArrayList<Equipamento> getEquipamentos() {return equipamentos;}
	public int getOuro() {return ouro;}

	

	
	
}

