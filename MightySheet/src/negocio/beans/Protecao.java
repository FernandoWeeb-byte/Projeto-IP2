package negocio.beans;

import java.io.Serializable;

public class Protecao extends Equipamento implements Serializable{
	
	/// Atributos
	private int bloqueio;
	private int esquiva;
	private boolean escudo;
	private boolean pesada;
	private boolean rigida;

	
	/// Construtor
	public Protecao(String nome, int custo, int fN, double peso, String descricao, boolean canalizador,
					int bloqueio, int esquiva, boolean escudo, boolean pesada, boolean rigida) {
		super(nome, custo, fN, peso, descricao, canalizador);

		this.bloqueio = bloqueio;
		this.esquiva = esquiva;
		this.escudo = escudo;
		this.pesada = pesada;
		this.rigida = rigida;
	}
	
	
	/// Métodos
	@Override
	public String toString()
	{
		/*String str = String.format("%s\n"
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
							+ "Peso: %.2f\n", this.getfN(), this.getPeso());*/
		
		return this.getNome();
	}


	/// Getters
	public int getBloqueio() {
		return bloqueio;
	}
	
	public void setBloqueio(int bloqueio) {
		this.bloqueio = bloqueio;
	}

	public int getEsquiva() {
		return esquiva;
	}
	
	public void setEsquiva(int esquiva) {
		this.esquiva = esquiva;
	}
	
	public boolean isEscudo() {
		return escudo;
	}
	
	public void setEscudo(boolean escudo) {
		this.escudo = escudo;
	}

	public boolean isPesada() {
		return pesada;
	}
	
	public void setPesada(boolean pesada) {
		this.pesada = pesada;
	}
	
	public boolean isRigida() {
		return rigida;
	}
	
	public void setRigida(boolean rigida) {
		this.rigida = rigida;
	}
}
