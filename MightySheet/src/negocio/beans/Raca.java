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
}
