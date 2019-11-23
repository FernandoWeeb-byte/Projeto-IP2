package negocio.controladores;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dados.RepositorioPersonagens;
import negocio.beans.Arma;
import negocio.beans.Classe;
import negocio.beans.Equipamento;
import negocio.beans.Habilidade;
import negocio.beans.Personagem;
import negocio.beans.Raca;

public class ControladorPersonagens {
	
	private RepositorioPersonagens repoPer;
	
	public boolean salvar(Personagem p)
	{
		for(int i=0; i< repoPer.todas().size(); i++)
		{
			if(repoPer.todas().get(i).equals(p))
			{
				return false;
			}
		}
		repoPer.todas().add(p);
		return true;
	}
	
	public List<Personagem> todas()
	{
		return RepositorioPersonagens.getInstance().todas();
	}
	
	public void adicionarFicha(Personagem novo)
	{
		if(novo != null)
		{
			RepositorioPersonagens.getInstance().AdicionarFicha(novo);
		}
	}
	
	public void removerFicha(String nomePersonagem)
	{
		Personagem remover = RepositorioPersonagens.getInstance().buscaPorPers(nomePersonagem);
		if(remover !=null)
		{
			RepositorioPersonagens.getInstance().removerFicha(remover);
		}
	}
	
	
	public List<Personagem> listaDaClasse(Classe classe)
	{
		if(classe != null)
		{
			return RepositorioPersonagens.getInstance().listarPorClasse(classe);
		}
		return null;
	}
	
	public List<Personagem> listaDaRaca(Raca raca)
	{
		if(raca != null)
		{
			return RepositorioPersonagens.getInstance().listarPorRaca(raca);
		}
		return null;
	}
	
	public List<Personagem> listaDoJogador(String nomeJogador)
	{
		if(nomeJogador != null)
		{
			return RepositorioPersonagens.getInstance().listarPorJogador(nomeJogador);
		}
		return null;
	}
	
	public Personagem buscaPorPers(String nome)
	{
		if(nome != null)
		{
			return RepositorioPersonagens.getInstance().buscaPorPers(nome);
		}
		return null;
	}
	
	public void editarFicha(String nomePer, int nivel, int experiencia, int inteligencia, 
			int forca, int vontade, int vida, int mana, HashMap<String, Integer> pericias, 
			Habilidade[] habilidadesAutomaticas,ArrayList<Habilidade> habilidades,  int quantHabilidades,
			ArrayList<Arma> ataques, ArrayList<Equipamento> equipamentos, int ouro)
	{
		if(nomePer !=null && nivel != 0 && experiencia != 0 && inteligencia != 0 && forca != 0 && 
				vontade !=0 && vida != 0 && mana != 0 && pericias != null && habilidadesAutomaticas != null
				&& habilidades != null && quantHabilidades != 0 && ataques != null && equipamentos != null
				&& ouro >= 0)
		{
			RepositorioPersonagens.getInstance().editarFicha(nomePer, nivel, experiencia, inteligencia, 
					forca, vontade, vida, mana, pericias, habilidadesAutomaticas, habilidades,
					quantHabilidades, ataques, equipamentos, ouro);
		}
				
	}
	
	

}
