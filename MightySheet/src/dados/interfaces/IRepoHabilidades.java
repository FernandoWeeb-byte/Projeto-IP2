package dados.interfaces;

import java.util.List;

import negocio.beans.Classe;
import negocio.beans.Habilidade;
import negocio.beans.Raca;

public interface IRepoHabilidades {

	boolean adicionarHabilidade(Habilidade hab);

	boolean removerHabilidade(String nome);

	boolean modificarHabilidade(Habilidade hab);

	Habilidade buscarHabilidade(String nome);

	List<Habilidade> listarTodasHabilidades();

	List<Habilidade> listarHabilidadePorClasse(String nome);
	
	List<Habilidade> listarHabilidadePorClasse(Classe classe);

	List<Habilidade> listarHabilidadesPorRaca(String nome);
	
	List<Habilidade> listarHabilidadesPorRaca(Raca raca);

	List<Habilidade> listarHabilidadesPorTipo(String tipo);

	List<Habilidade> listarHabilidadesPorCategoria(String categoria);

	List<Habilidade> listarHabilidadesComCustoManaMenorQue(int valor);
	
	List<Habilidade> habilidadesBasicaAvancadaOuFinal(Classe classe, int level);

	boolean salvarHabilidades();
}