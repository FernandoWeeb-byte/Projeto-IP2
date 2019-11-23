package dados;

import java.util.List;

import negocio.beans.Raca;

public interface IRepoRacas {

	boolean adicionarRaca(Raca raca);

	boolean removerRaca(String nome);

	Raca buscarRaca(String nome);

	boolean modificarRaca(Raca raca);

	List<Raca> listarTodasRacas();

}