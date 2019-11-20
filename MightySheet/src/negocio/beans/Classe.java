package negocio.beans;

import java.util.HashMap;

public class Classe {
	
	/// Atributos
	private String nome;
	private int bonusForca;
	private int bonusAgilidade;
	private int bonusInteligencia;
	private int bonusVontade;
	private Habilidade habilidadeAutomatica;
	private HashMap<String, Habilidade> habilidadesBasicas;
	private HashMap<String, Habilidade> habilidadesAvancadas;
	private Habilidade habilidadeFinal;
  
  
	/// Construtor
	public Classe(String nome, int bonusForca, int bonusAgilidade, int bonusInteligencia, int bonusVontade,
			 HashMap<String, Habilidade> habilidadesBasicas) {
		this.nome = nome;
		this.bonusForca = bonusForca;
		this.bonusAgilidade = bonusAgilidade;
		this.bonusInteligencia = bonusInteligencia;
		this.bonusVontade = bonusVontade;
		this.habilidadesBasicas = habilidadesBasicas;
	}

	/// Instancias estaticas
	public final static Classe GUERREIRO = new Classe("Guerreiro", 1, 1, 0, 0, null);
	public final static Classe FEITICEIRO = new Classe("Feiticeiro", 0, 0, 1, 1, null);


	
	
	/// Getters
	
	public String getNome() {
		return nome;
	}
	public int getBonusForca() {
		return bonusForca;
	}
	public int getBonusAgilidade() {
		return bonusAgilidade;
	}
	public int getBonusInteligencia() {
		return bonusInteligencia;
	}
	public int getBonusVontade() {
		return bonusVontade;
	}
	public Habilidade getHabilidadeAutomatica() {
		return habilidadeAutomatica;
	}
	public HashMap<String, Habilidade> getHabilidadesBasicas() {
		return habilidadesBasicas;
	}
	public HashMap<String, Habilidade> getHabilidadesAvancadas() {
		return habilidadesAvancadas;
	}
	public Habilidade getHabilidadeFinal() {
		return habilidadeFinal;
	}
	
	

}
