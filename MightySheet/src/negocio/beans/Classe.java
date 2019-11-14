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
	
	
	/// Construtor
	public Classe(String nome, int bonusForca, int bonusAgilidade, int bonusInteligencia, int bonusVontade,
					Habilidade habilidadeAutomatica, HashMap<String, Habilidade> habilidadesBasicas, HashMap<String, Habilidade> habilidadesAvancadas)
	{
		this.nome = nome;
		this.bonusForca = bonusForca;
		this.bonusAgilidade = bonusAgilidade;
		this.bonusInteligencia = bonusInteligencia;
		this.bonusVontade = bonusVontade;
		this.habilidadeAutomatica = habilidadeAutomatica;
		this.habilidadesBasicas = habilidadesBasicas;
		this.habilidadesAvancadas = habilidadesAvancadas;
	}
	
	
	/// Instancias estáticas
}
