package negocio.beans;

import java.util.HashMap;

public class Raca {
	
	/// Atributos
	private String nome;
	private int forca;
	private int agilidade;
	private int inteligencia;
	private int vontade;
	private Habilidade habilidadeAutomatica;
	private HashMap<String, Habilidade> habilidades;


	/// Construtor
	public Raca(String nome, int forca, int agilidade, int inteligencia, int vontade,
			HashMap<String, Habilidade> habilidades) {

		this.nome = nome;
		this.forca = forca;
		this.agilidade = agilidade;
		this.inteligencia = inteligencia;
		this.vontade = vontade;
		this.habilidades = habilidades;
	}

	/// Instancias estaticas
	public final static Raca HUMANO = new Raca("Humano", 3, 3, 3, 3, null);
	public final static Raca ELFO = new Raca("Elfo", 2, 4, 3, 3, null);
	public final static Raca ANAO = new Raca("Anão", 4, 2, 3, 3, null);
	
	/// toString
	public String toString()
	{
		return this.nome;
	}


	/// Getters
	public String getNome() {
		return nome;
	}

	public int getForca() {
		return forca;
	}

	public int getAgilidade() {
		return agilidade;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public int getVontade() {
		return vontade;
	}

	public Habilidade getHabilidadeAutomatica() {
		return habilidadeAutomatica;
	}

	public HashMap<String, Habilidade> getHabilidades() {
		return habilidades;
	}
	
	
}
