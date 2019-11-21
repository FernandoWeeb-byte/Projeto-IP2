package negocio.beans;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Raca {
	
	/// Atributos
	private String nome;
	private int forca;
	private int agilidade;
	private int inteligencia;
	private int vontade;
	private Habilidade habilidadeAutomatica;
	private Map<String, Habilidade> habilidades;


	/// Construtor
	public Raca(String nome, int forca, int agilidade, int inteligencia, int vontade,
			Habilidade habilidadeAutomatica, List<Habilidade> habilidades) {

		this.nome = nome;
		this.forca = forca;
		this.agilidade = agilidade;
		this.inteligencia = inteligencia;
		this.vontade = vontade;
		this.habilidadeAutomatica = habilidadeAutomatica;
		this.habilidades = new HashMap<String, Habilidade>();
		
		for(Habilidade hab : habilidades)
		{
			this.habilidades.put(hab.getNome(), hab);
		}
	}
	
	
	/// Metodos
	public boolean equals(Raca another)
	{
		boolean ret = false;
		
		if(this.nome.equals(another.nome))
		{
			ret = true;
		}
		
		return ret;
	}
	
	public String toString()
	{
		String str = String.format("%s\n"
								+ "Atributos Iniciais:\n"
								+ "Força %d\n"
								+ "Agilidade %d\n"
								+ "Inteligencia %d\n"
								+ "Vontade %d\n"
								+ "Habilidade Automática:\n"
								+ "%s", this.nome, this.forca, this.agilidade, this.inteligencia, this.vontade,
								this.habilidadeAutomatica);
		
		return str;
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

	public Map<String, Habilidade> getHabilidades() {
		return habilidades;
	}
}
