 package negocio.beans;

import java.util.HashMap;

public class Habilidade {
	
	/// Atributos
	private String nome;
	private String tipo;
	private String categoria;
	private String requisito;
	private int mana;
	private int dificuldade;
	private String descricao;
	private String classe;
	private String raca;
	
	
	/// Construtores
	public Habilidade(String nome, String tipo, String categoria, String requisito,
					int mana, int dificuldade,String classe, String raca, String descricao)
	{
		this.nome = nome;
		this.tipo = tipo;
		this.categoria = categoria;
		this.requisito = requisito;
		this.mana = mana;
		this.dificuldade = dificuldade;
		this.classe = classe;
		this.raca = raca;
		this.descricao = descricao;
	}
	
	
	/// Métodos
	public String toString()
	{
		String str = String.format("%s\n"
								   + "Habilidade ",
								   this.nome);
		
		if(categoria != null)
		{
			str += String.format("(%s) ", this.categoria);
		}

		str += String.format("- %s\n", this.tipo);
		
		if(requisito != null)
		{
			str += String.format("Requisito: %s\n", this.requisito);
		}
		
		if(mana >= 0)
		{
			if(mana == 0)
			{
				str += "Mana: Varia\n";
			}
			else
			{
				str += String.format("Mana: %d\n", this.mana);	
			}
		}
		
		if(dificuldade >= 0)
		{
			str += String.format("Dificuldade da Magia: %d\n", this.dificuldade);
		}

		
		str += String.format("Descricao: %s\n", this.descricao);
		
		return str;
	}
	
	
	/// Gets e sets
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
	
	public String getClasse()
	{
		return this.classe;
	}
	
	public void setClasse(String classe)
	{
		this.classe = classe;
	}
	
	public String getRaca()
	{
		return this.raca;
	}
	public void setRaca(String raca)
	{
		this.raca = raca;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getRequisito() {
		return requisito;
	}


	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}


	public int getMana() {
		return mana;
	}


	public void setMana(int mana) {
		this.mana = mana;
	}


	public int getDificuldade() {
		return dificuldade;
	}


	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	}

	
		