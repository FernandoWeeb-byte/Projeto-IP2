package dados;

import java.util.List;

import negocio.beans.Classe;

public interface IRepoClasses {

	boolean adicionarClasse(Classe classe);

	boolean removerClasse(String nome);

	Classe buscarClasse(String nome);

	boolean modificarClasse(Classe classe);

	List<Classe> listarTodasClasses();

}