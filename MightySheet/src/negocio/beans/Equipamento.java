package negocio.beans;

import java.io.Serializable;

import javafx.scene.control.Button;

public class Equipamento implements Serializable {
	
	/// Atributos
	private String nome;
	private int custo;
	private int fN;
	private double peso;
	private String descricao;
	private boolean canalizador;
	private Button button;
	
	
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
		this.button = new Button("Comprar");
	}
	


	/// Métodos
	public String toString()
	{
		/*String str = String.format("%s\n"
									+ "Custo: %d\n", this.nome, this.custo);
		
		if(fN > 0)
		{
			str += String.format("FN: %d\n", this.fN);
		}
		
		str += String.format("Peso: %.2fkg\n"
							+ "Descrição: %s\n",
							this.peso, this.descricao);*/
		
		return this.getNome();
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
	
	public void setfN(int fN) {
		this.fN = fN;
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
	
	public void setCanalizador(boolean canalizador) {
		this.canalizador = canalizador;
	}
	
	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}
}
