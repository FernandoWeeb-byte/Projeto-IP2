package negocio.beans;

import java.io.Serializable;

public class Equipamento implements Serializable{
	
	/// Atributos
	private String nome;
	private int custo;
	private double peso;
	private String descricao;
	private boolean canalizador;
	
	
	/// Construtor
	public Equipamento(String nome, int custo, double peso,
						String descricao, boolean canalizador)
	{
		this.nome = nome;
		this.custo = custo;
		this.peso = peso;
		this.descricao = descricao;
		this.canalizador = canalizador;
	}
	
	
	/// Métodos
	public String toString()
	{
		String str = String.format("%s\n"
									+ "Custo: %d\n"
									+ "Peso: %.2fkg\n"
									+ "Descrição: %s\n",
									this.nome, this.custo, this.peso, this.descricao);
		
		return str;
	}
	
	
	/// Gets e sets
	public String getNome() {
		return nome;
	}

	public int getCusto() {
		return custo;
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
