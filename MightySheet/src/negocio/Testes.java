package negocio;

import dados.RepositorioHabilidades;
import dados.RepositorioRacas;
import negocio.beans.*;

import java.util.List;

public class Testes {
	public static void main(String[] args) {
		Fachada fachada = Fachada.getInstance();
		
		System.out.println(fachada.buscarClasse("Guerreiro"));
	}
}
