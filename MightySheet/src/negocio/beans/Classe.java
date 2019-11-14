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
	public Classe(String nome, int bonusForca, int bonusAgilidade, int bonusInteligencia, int bonusVontade, Habilidade habilidadeAutomatica,
			HashMap<String, Habilidade> habilidadesBasicas, HashMap<String, Habilidade> habilidadesAvancadas, Habilidade habilidadeFinal)
	{
		this.nome = nome;
		this.bonusForca = bonusForca;
		this.bonusAgilidade = bonusAgilidade;
		this.bonusInteligencia = bonusInteligencia;
		this.bonusVontade = bonusVontade;
		this.habilidadeAutomatica = habilidadeAutomatica;
		this.habilidadesBasicas = habilidadesBasicas;
		this.habilidadesAvancadas = habilidadesAvancadas;
		this.habilidadeFinal = habilidadeFinal;
	}
	
	
	/// Instancias estáticas
	public final static Classe GUERREIRO = new Classe("Guerreiro", 1, 1, 0, 0, Habilidade.MESTRE_DE_ARMAS_1, Habilidade.habilidadesBasicasGuerreiro(),
														Habilidade.habilidadesAvancadasGuerreiro(), Habilidade.MESTRE_DE_ARMAS_3);
}
