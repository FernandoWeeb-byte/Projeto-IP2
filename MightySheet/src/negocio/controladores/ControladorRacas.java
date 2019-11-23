package negocio.controladores;

import negocio.beans.Raca;
import dados.IRepoRacas;
import dados.RepositorioRacas;

import java.util.List;

public class ControladorRacas {
	
	/// Atributos
	private IRepoRacas repRc;
	
	
	/// Construtores
	public ControladorRacas()
	{
		repRc = RepositorioRacas.getInstance();
	}
	
	
	/// M�todos
	public boolean adicionarRaca(Raca raca)
	{
		boolean ret = false;
		
		if(raca != null)
		{
			if(raca.getNome() != null &&
					raca.getHabilidadeAutomatica() != null &&
					raca.getHabilidades() != null)
			{
				ret = repRc.adicionarRaca(raca);
			}
		}
		
		return ret;
	}
	
	public boolean removerRaca(String nome)
	{
		boolean ret = false;
		
		if(nome != null)
		{
			ret = repRc.removerRaca(nome);
		}
		
		return ret;
	}
	
	public Raca buscarRaca(String nome)
	{
		Raca ret = null;
		
		if(nome != null)
		{
			ret = repRc.buscarRaca(nome);
		}
		
		return ret;
	}
	
	public boolean modificarRaca(Raca raca)
	{
		boolean ret = false;
		
		if(raca != null)
		{
			if(raca.getNome() != null &&
					raca.getHabilidadeAutomatica() != null &&
					raca.getHabilidades() != null)
			{
				ret = repRc.modificarRaca(raca);
			}
		}
		
		return ret;
	}
	
	
	/// Metodos delegate
	public List<Raca> listarTodasRacas()
	{
		return repRc.listarTodasRacas();
	}
}
