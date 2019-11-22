package negocio.controladores;


import dados.RepositorioPersonagens;
import negocio.beans.Personagem;

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
	
	

}
