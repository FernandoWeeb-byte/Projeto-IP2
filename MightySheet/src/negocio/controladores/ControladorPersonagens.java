package negocio.controladores;


import dados.RepositorioPersonagens;
import negocio.beans.Personagem;

public class ControladorPersonagens {
	
	private RepositorioPersonagens repoPer;
	
	public boolean salvar(Personagem p)
	{
		for(int i=0; i< repoPer.getFichas().size(); i++)
		{
			if(repoPer.getFichas().get(i).equals(p))
			{
				return false;
			}
		}
		repoPer.getFichas().add(p);
		return true;
	}
	
	

}
