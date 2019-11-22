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

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public void setVontade(int vontade) {
		this.vontade = vontade;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public void setPericias(HashMap<String, Integer> pericias) {
		this.pericias = pericias;
	}

	public void setEsquiva(int esquiva) {
		this.esquiva = esquiva;
	}

	public void setBloqueio(int bloqueio) {
		this.bloqueio = bloqueio;
	}

	public void setDeterminacao(int determinacao) {
		this.determinacao = determinacao;
	}

	public void setHabilidadesAutomaticas(Habilidade[] habilidadesAutomaticas) {
		this.habilidadesAutomaticas = habilidadesAutomaticas;
	}

	public void setHabilidades(ArrayList<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}

	public void setQuantHabilidades(int quantHabilidades) {
		this.quantHabilidades = quantHabilidades;
	}

	public void setAtaques(ArrayList<Arma> ataques) {
		this.ataques = ataques;
	}

	public void setEquipamentos(ArrayList<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	public void setOuro(int ouro) {
		this.ouro = ouro;
	}

	

	
	
}

