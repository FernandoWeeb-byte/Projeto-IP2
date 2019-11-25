package negocio.beans;

import java.io.Serializable;

public class Protecao extends Equipamento implements Serializable{
	
	/// Atributos
	private int bloqueio;
	private int esquiva;
	private int fN;
	private boolean escudo;
	private boolean pesada;
	private boolean rigida;

	
	/// Construtor
	public Protecao(String nome, int custo, double peso, String descricao, boolean canalizador,
					int bloqueio, int esquiva, int fN, boolean escudo, boolean pesada, boolean rigida) {
		super(nome, custo, peso, descricao, canalizador);

		this.bloqueio = bloqueio;
		this.esquiva = esquiva;
		this.fN = fN;
		this.escudo = escudo;
		this.pesada = pesada;
		this.rigida = rigida;
	}
	
	
	/// Métodos
	@Override
	public String toString()
	{
		String str = String.format("%s\n"
									+ "Custo: %d\n"
									+ "Defesa: ", this.getNome(), this.getCusto());
		
		if(escudo)
		{
			str += String.format("+%d\n", this.bloqueio);
		}
		else
		{
			str += String.format("%d\n", this.esquiva);
		}
		
		str += String.format("FN: %d\n"
							+ "Peso: %.2f\n", this.fN, this.getPeso());
		
		return str;
	}


	/// Getters
	public int getBloqueio() {
		return bloqueio;
	}

	public int getEsquiva() {
		return esquiva;
	}

	public int getfN() {
		return fN;
	}

	public boolean isEscudo() {
		return escudo;
	}

	public boolean isPesada() {
		return pesada;
	}
	
	public boolean isRigida() {
		return rigida;
	}
}
