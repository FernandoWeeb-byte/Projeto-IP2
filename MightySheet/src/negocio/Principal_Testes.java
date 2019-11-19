package negocio;

import negocio.beans.*;

import java.util.ArrayList;
import java.util.Collection;

public class Principal_Testes {
	public static void main(String[] args) {
		RepositorioHabilidades rep = new RepositorioHabilidades();
		ArrayList<Habilidade> lista = new ArrayList<>();
		lista = rep.listarHabilidade();
		System.out.println(rep.habilidadePorClasse("Guerreiro"));

		System.out.println(rep.buscarPorNome("Bençao de Lathellanis "));

		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getNome());
		}
		
	}
}
