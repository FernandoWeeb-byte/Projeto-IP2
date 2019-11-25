package dados.interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import negocio.beans.Arma;
import negocio.beans.Classe;
import negocio.beans.Equipamento;
import negocio.beans.Habilidade;
import negocio.beans.Personagem;
import negocio.beans.Raca;

public interface IRepoPersonagens {

	List<Personagem> todas();

	void AdicionarFicha(Personagem novo);

	void removerFicha(Personagem remover);

	List<Personagem> listarPorClasse(Classe classe);

	List<Personagem> listarPorRaca(Raca raca);

	List<Personagem> listarPorJogador(String nome);

	Personagem buscaPorPers(String nome);

	void editarFicha(String nomePer, int nivel, int experiencia, int inteligencia, int forca, int vontade, int vida,
			int mana, HashMap<String, Integer> pericias, Habilidade[] habilidadesAutomaticas,
			ArrayList<Habilidade> habilidades, int quantHabilidades, ArrayList<Arma> ataques,
			ArrayList<Equipamento> equipamentos, int ouro);

	boolean guardar();

}