package negocio.beans;

import java.io.Serializable;

public class Equipamento implements Serializable{
	
	/// Atributos
	private String nome;
	private int custo;
	private int fN;
	private double peso;
	private String descricao;
	private boolean canalizador;
	
	
	/// Construtor
	public Equipamento(String nome, int custo, int fN, double peso,
						String descricao, boolean canalizador)
	{
		this.nome = nome;
		this.custo = custo;
		this.fN = fN;
		this.peso = peso;
		this.descricao = descricao;
		this.canalizador = canalizador;
	}
	
	
	/// Métodos
	public String toString()
	{
		String str = String.format("%s\n"
									+ "Custo: %d\n", this.nome, this.custo);
		
		if(fN > 0)
		{
			str += String.format("FN: %d\n", this.fN);
		}
		
		str += String.format("Peso: %.2fkg\n"
							+ "Descrição: %s\n",
							this.peso, this.descricao);
		
		return str;
	}
	
	
	/// Gets e sets
	public String getNome() {
		return nome;
	}

	public int getCusto() {
		return custo;
	}

	public int getfN()
	{
		return fN;
	}
	
	public double getPeso() {
		return peso;
	}

	public String getDescricao() {
		return descricao;
	}

	public boolean isCanalizador() {
		return canalizador;
	}
}
