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
	private String categoria;
	
	
	/// Construtor
	public Equipamento(String nome, int custo, int fN, double peso, String descricao, boolean canalizador, String categoria)
	{
		this.nome = nome;
		this.custo = custo;
		this.fN = fN;
		this.peso = peso;
		this.descricao = descricao;
		this.canalizador = canalizador;
		this.categoria = categoria;
	}
	
	
	/// Métodos
	public String toString()
	{
		String str = String.format("%s\n" + "Custo: %d\n", this.nome, this.custo);
		
		if(fN > 0)
		{
			str += String.format("FN: %d\n", this.fN);
		}
		
		str += String.format("Peso: %.2fkg\n"
							+"Descrição: %s\n", 
							this.peso, this.descricao);
		return str;
	}
	
	
	/// Gets e sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCusto() {
		return custo;
	}
	
	public void setCusto(int custo) {
		this.custo = custo;
	}

	public int getfN()
	{
		return fN;
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isCanalizador() {
		return canalizador;
	}
	
	public void setCanalizador(boolean is) {
		this.canalizador = is;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
