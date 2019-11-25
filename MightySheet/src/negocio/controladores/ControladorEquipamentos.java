package negocio.controladores;

import negocio.beans.Arma;
import negocio.beans.Equipamento;
import negocio.beans.Protecao;
import dados.interfaces.IRepoEquipamentos;
import dados.repositorios.RepositorioEquipamentos;

import java.util.List;

public class ControladorEquipamentos {
	
	/// Constantes
	private static final String CONTUSAO = "Contusão";
	private static final String CORTEPERF = "Corte e Perf";
	private static final String CORTE = "Corte";
	private static final String PERFURACAO = "Perfuração";
	private static final String CONTPERF = "Cont e Perf";
	
	private static final String CORPOACORPO = "Corpo-a-corpo";
	private static final String HASTE = "Haste";
	private static final String CURTO = "Curto";
	private static final String MEDIO = "Médio";
	private static final String LONGO = "Longo";
	
	
	/// Atributos
	private IRepoEquipamentos equips;
	
	
	/// Construtor
	public ControladorEquipamentos()
	{
		this.equips = RepositorioEquipamentos.getInstance();
	}
	
	
	/// Métodos
	public boolean adicionarEquipamento(Equipamento novo) {
		boolean ret = false;

		if(novo != null)
		{
			if(novo.getNome() != null &&
					novo.getCusto() >= 0 &&
					novo.getPeso() >= 0 &&
					novo.getDescricao() != null)
			{
				if(novo.getClass().equals(Arma.class))
				{
					if(((Arma) novo).getDano() >= 0 &&
							
							(CONTUSAO.equals(((Arma)novo).getTipoDano()) || CORTEPERF.equals(((Arma)novo).getTipoDano()) ||
							CORTE.equals(((Arma)novo).getTipoDano()) || PERFURACAO.equals(((Arma)novo).getTipoDano()) ||
							CONTPERF.equals(((Arma)novo).getTipoDano())) &&
							
							((Arma)novo).getfN() >= 1 &&
							
							(CORPOACORPO.equals(((Arma)novo).getDistancia()) || HASTE.equals(((Arma)novo).getDistancia()) ||
							CURTO.equals(((Arma)novo).getDistancia()) || MEDIO.equals(((Arma)novo).getDistancia()) ||
							LONGO.equals(((Arma)novo).getDistancia())))
					{
						ret = true;
					}
				}
				
				if(novo.getClass().equals(Protecao.class))
				{
					if(((Protecao)novo).getBloqueio() >= 0 &&
							((Protecao)novo).getEsquiva() >= 0 &&
							((Protecao)novo).getfN() >= 0)
					{
						ret = true;
					}
				}
				
				if(ret)
				{
					ret = equips.adicionarEquipamento(novo);
				}
			}
		}
		
		return ret;
	}

	public boolean removerEquipamento(String nome) {
		boolean ret = false;
		
		if(nome != null)
		{
			ret = equips.removerEquipamento(nome);
		}
		
		return ret;
	}

	public Equipamento buscarEquipamento(String nome) {
		Equipamento ret = null;
		
		if(nome != null)
		{
			ret = equips.buscarEquipamento(nome);
		}
		
		return ret;
	}

	public boolean modificarEquipamento(Equipamento novo) {
		boolean ret = false;

		if(novo != null)
		{
			if(novo.getNome() != null &&
					novo.getCusto() >= 0 &&
					novo.getPeso() >= 0 &&
					novo.getDescricao() != null)
			{
				if(novo.getClass().equals(Arma.class))
				{
					if(((Arma) novo).getDano() >= 0 &&
							
							(CONTUSAO.equals(((Arma)novo).getTipoDano()) || CORTEPERF.equals(((Arma)novo).getTipoDano()) ||
							CORTE.equals(((Arma)novo).getTipoDano()) || PERFURACAO.equals(((Arma)novo).getTipoDano()) ||
							CONTPERF.equals(((Arma)novo).getTipoDano())) &&
							
							((Arma)novo).getfN() >= 1 &&
							
							(CORPOACORPO.equals(((Arma)novo).getDistancia()) || HASTE.equals(((Arma)novo).getDistancia()) ||
							CURTO.equals(((Arma)novo).getDistancia()) || MEDIO.equals(((Arma)novo).getDistancia()) ||
							LONGO.equals(((Arma)novo).getDistancia())))
					{
						ret = true;
					}
				}
				
				if(novo.getClass().equals(Protecao.class))
				{
					if(((Protecao)novo).getBloqueio() >= 0 &&
							((Protecao)novo).getEsquiva() >= 0 &&
							((Protecao)novo).getfN() >= 0)
					{
						ret = true;
					}
				}
				
				if(ret)
				{
					ret = equips.modificarEquipamento(novo);
				}
			}
		}
		
		return ret;
	}


	/// Métodos - delegate
	public List<Equipamento> listarTodosItens() {
		return equips.listarTodosItens();
	}

	public List<Equipamento> listarItensComuns() {
		return equips.listarItensComuns();
	}

	public List<Equipamento> listarTodosCanalizadores() {
		return equips.listarTodosCanalizadores();
	}

	public List<Arma> listarTodasArmas() {
		return equips.listarTodasArmas();
	}

	public List<Protecao> listarTodasArmaduras() {
		return equips.listarTodasArmaduras();
	}
}
