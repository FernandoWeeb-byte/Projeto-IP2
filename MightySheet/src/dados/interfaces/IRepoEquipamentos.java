package dados.interfaces;

import java.util.List;

import negocio.beans.Arma;
import negocio.beans.Equipamento;
import negocio.beans.Protecao;

public interface IRepoEquipamentos {

	/// Metodos
	boolean adicionarEquipamento(Equipamento novo);

	boolean removerEquipamento(String nome);

	Equipamento buscarEquipamento(String nome);

	boolean modificarEquipamento(Equipamento novo);

	List<Equipamento> listarTodosItens();

	List<Equipamento> listarItensComuns();

	List<Equipamento> listarTodosCanalizadores();

	List<Arma> listarTodasArmas();

	List<Protecao> listarTodasArmaduras();
	
	List<String> listarCategorias();

	List<String> listarAlcances();

}