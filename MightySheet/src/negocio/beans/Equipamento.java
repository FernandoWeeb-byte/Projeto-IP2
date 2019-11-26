package negocio.beans;

public class Equipamento {
	
	/// Atributos
	private String nome;
	private int custo;
	private double peso;
	private String descricao;
	private boolean canalizador;
	private String categoria;
	
	
	/// Construtor
	public Equipamento(String nome, int custo, double peso,
						String descricao, boolean canalizador, String categoria)
	{
		this.nome = nome;
		this.custo = custo;
		this.peso = peso;
		this.descricao = descricao;
		this.canalizador = canalizador;
		this.categoria = categoria;
	}
	
	
	/// Métodos
	public String toString()
	{
		String str = String.format("%s\n"
									+ "Custo: %d\n"
									+ "Peso: %.2fkg\n"
									+ "Descrição: %s\n"
									+ "Categoria: %s\n",
									this.nome, this.custo, this.peso, this.descricao, this.categoria);
		
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
