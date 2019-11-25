package negocio.controladores;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dados.interfaces.IRepoPersonagens;
import dados.repositorios.RepositorioPersonagens;
import negocio.beans.Arma;
import negocio.beans.Classe;
import negocio.beans.Equipamento;
import negocio.beans.Habilidade;
import negocio.beans.Personagem;
import negocio.beans.Raca;

public class ControladorPersonagens {
	
	private IRepoPersonagens repoPer;
	
	public ControladorPersonagens()
	{
		repoPer = RepositorioPersonagens.getInstance();
	}
	
	
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
		repoPer.guardar();
		return true;
	}
	
	public List<Personagem> todas()
	{
		return repoPer.todas();
	}
	
	public void adicionarFicha(Personagem novo)
	{
		if(novo != null)
		{
			repoPer.AdicionarFicha(novo);
		}
	}
	
	public void removerFicha(String nomePersonagem)
	{
		Personagem remover = repoPer.buscaPorPers(nomePersonagem);
		if(remover !=null)
		{
			repoPer.removerFicha(remover);
		}
	}
	
	
	public List<Personagem> listaDaClasse(Classe classe)
	{
		if(classe != null)
		{
			return repoPer.listarPorClasse(classe);
		}
		return null;
	}
	
	public List<Personagem> listaDaRaca(Raca raca)
	{
		if(raca != null)
		{
			return repoPer.listarPorRaca(raca);
		}
		return null;
	}
	
	public List<Personagem> listaDoJogador(String nomeJogador)
	{
		if(nomeJogador != null)
		{
			return repoPer.listarPorJogador(nomeJogador);
		}
		return null;
	}
	
	public Personagem buscaPorPers(String nome)
	{
		if(nome != null)
		{
			return repoPer.buscaPorPers(nome);
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
			repoPer.editarFicha(nomePer, nivel, experiencia, inteligencia, 
					forca, vontade, vida, mana, pericias, habilidadesAutomaticas, habilidades,
					quantHabilidades, ataques, equipamentos, ouro);
		}
				
	}
	
	

}
