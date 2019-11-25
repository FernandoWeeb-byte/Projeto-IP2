package negocio.controladores;

import negocio.beans.Classe;
import dados.interfaces.IRepoClasses;
import dados.repositorios.RepositorioClasses;

import java.io.IOException;
import java.util.List;

public class ControladorClasses {
	
	/// Atributos
	private IRepoClasses repCls;
	
	
	/// Construtor
	public ControladorClasses()
	{
		repCls = RepositorioClasses.getInstance();
	}
	
	
	/// Metodos
	public boolean adicionarClasse(Classe cls)
	{
		boolean ret = false;
		
		if(cls != null)
		{
			if(cls.getNome() != null &&
					cls.getHabilidadeAutomatica() != null &&
					cls.getHabilidades() != null)
			{
				ret = repCls.adicionarClasse(cls);
			}
		}
		
		return ret;
	}

	public boolean removerClasse(String nome) {
		boolean ret = false;
		
		if(nome != null)
		{
			ret = repCls.removerClasse(nome);
		}
		
		return ret;
	}

	public Classe buscarClasse(String nome) {
		Classe ret = null;
		
		if(nome != null)
		{
			ret = repCls.buscarClasse(nome);
		}
		
		return ret;
	}
	
	public boolean modificarClasse(Classe cls)
	{
		boolean ret = false;
		
		if(cls != null)
		{
			if(cls.getNome() != null &&
					cls.getHabilidadeAutomatica() != null &&
					cls.getHabilidades() != null)
			{
				ret = repCls.modificarClasse(cls);
			}
		}
		
		return ret;
	}
	
	/// Metodos delegate
	public List<Classe> listarTodasClasses() {
		return repCls.listarTodasClasses();
	}


	
	public boolean salvarClasses() {
		return repCls.salvarClasses();
	}
}
