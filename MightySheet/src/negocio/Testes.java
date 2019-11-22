package negocio;

import dados.RepositorioHabilidades;
import dados.RepositorioPersonagens;
import dados.RepositorioRacas;
import negocio.beans.*;
import negocio.controladores.ControladorClasses;
import negocio.controladores.ControladorPersonagens;

import java.util.List;

public class Testes {
	public static void main(String[] args) {
		Fachada fachada = Fachada.getInstance();
		RepositorioPersonagens repo = new RepositorioPersonagens();
		//System.out.println(fachada.buscarClasse("Guerreiro"));
		ControladorPersonagens cP = new ControladorPersonagens();
		//Personagem person = new Personagem("hawkboy", fachada.buscarRaca("Humano"), fachada.buscarClasse("Guerreiro"),1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		//cP.salvar(person);
		repo.carregarPersonagens();
		System.out.println(repo.getFichas().size());
	}
}
