package negocio;

import dados.RepositorioHabilidades;
import dados.RepositorioRacas;
import negocio.beans.*;

import java.util.List;

public class Testes {
	public static void main(String[] args) {
		RepositorioRacas repRc = RepositorioRacas.getInstance();
		
		RepositorioHabilidades repHab = RepositorioHabilidades.getInstance();
		
		Raca r = new Raca("Lefou", 3, 3, 3, 3, repHab.buscarHabilidade("Adaptabilidade"),
					repHab.listarHabilidadesPorRaca("Humano"));
		
		repRc.adicionarRaca(r);
		
		List<Raca> l = repRc.listarTodasRacas();
		
		for(Raca ra : l)
		{
			System.out.println(ra);
		}
	}
}
