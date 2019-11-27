package dados.interfaces;

import negocio.beans.Classe;

import java.util.List;

public interface IRepoClasses {

	boolean adicionarClasse(Classe classe);

	boolean removerClasse(String nome);

	Classe buscarClasse(String nome);

	boolean modificarClasse(Classe classe);

	List<Classe> listarTodasClasses();
	
	boolean salvarClasses();
}