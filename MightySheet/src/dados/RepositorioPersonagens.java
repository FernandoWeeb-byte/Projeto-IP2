package dados;

import java.util.ArrayList;
import java.util.List;
import negocio.beans.Classe;
import negocio.beans.Raca;
import negocio.beans.Personagem;

public class RepositorioPersonagens {
	private ArrayList<Personagem> fichas;
	
	public RepositorioPersonagens()
	{
		this.fichas = new ArrayList<Personagem>();
	}
	
	public ArrayList<Personagem> getFichas()
	{
		return this.fichas;
	}
	
	public void AdicionarFicha(Personagem novo)
	{
		this.fichas.add(novo);
	}
	
	public void RemoverFicha(String nomeJogador, String nomePersonagem)
	{
		int freioDeMao = -1;
		for(int i=0; i<this.fichas.size() && freioDeMao < 0; i++)
		{
			if(this.fichas.get(i).getNomeJogador().equalsIgnoreCase(nomeJogador) && 
					this.fichas.get(i).getNomePersonagem().equalsIgnoreCase(nomePersonagem))
			{
				this.fichas.remove(i);
				freioDeMao = 42;
			}
		}	
	}
	
	public List<Personagem> listarPorClasse(Classe classe)
	{
		String buscado = classe.getNome();
		List<Personagem> saida = new ArrayList<Personagem>();
		for(Personagem p: this.fichas)
		{
			if(p.getClasse().getNome().equals(buscado))
			{
				
				saida.add(p);
			}
		}
		return saida;
	}
	
	
	public List<Personagem> listarPorRaca(Raca raca)
	{
		List<Personagem> saida = new ArrayList<Personagem>();
		for(Personagem p: this.fichas)
		{
			if(p.getRaca().getNome().equals(raca.getNome()))
			{
				saida.add(p);
			}
		}
		return saida;
	}
	
	
	public List<Personagem> listarPorJogador(String nome)
	{
		List<Personagem> saida = new ArrayList<Personagem>();
		for(Personagem p: this.fichas)
		{
			if(p.getNomeJogador().equals(nome))
			{
				saida.add(p);
			}
		}
		return saida;
	}
	
	
	
	

}
