package dados.repositorios;

import negocio.beans.Equipamento;
import negocio.beans.Habilidade;
import negocio.beans.Arma;
import negocio.beans.Protecao;
import dados.interfaces.IRepoEquipamentos;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class RepositorioEquipamentos implements IRepoEquipamentos {
	
	/// Singleton
	private static IRepoEquipamentos INSTANCE;
	
	
	/// Atributos
	private final Map<String, Equipamento> equipamentosPE;
	private Map<String, Equipamento> equipamentosC;
	
	
	/// Construtor
	private RepositorioEquipamentos()
	{
		equipamentosPE = new HashMap<String, Equipamento>();
		equipamentosC = new HashMap<String, Equipamento>();
	}
	
	
	/// Metodos
	public static IRepoEquipamentos getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new RepositorioEquipamentos();
		}
		return INSTANCE;
	}
	
	public String toString()
	{
		String str = "";
		
		for(Equipamento equip : equipamentosPE.values())
		{
			str += equip.toString();
			str += "\n";
		}
		
		for(Equipamento equip : equipamentosC.values())
		{
			str += equip.toString();
			str += "\n";
		}
		
		return str;
	}
	
	@Override
	public boolean adicionarEquipamento(Equipamento novo)
	{
		boolean ret = false;
		
		if(!equipamentosPE.containsKey(novo.getNome()) &&
				!equipamentosC.containsKey(novo.getNome()))
		{
			equipamentosC.put(novo.getNome(), novo);
			ret = true;
		}
		
		return ret;
	}
	
	@Override
	public boolean removerEquipamento(String nome)
	{
		boolean ret = false;
		
		if(equipamentosC.containsKey(nome))
		{
			equipamentosC.remove(nome);
		}
		
		return ret;
	}
	
	@Override
	public Equipamento buscarEquipamento(String nome)
	{
		Equipamento buscado = null;
		
		if(equipamentosPE.containsKey(nome))
		{
			buscado = equipamentosPE.get(nome);
		}
		
		if(equipamentosC.containsKey(nome))
		{
			buscado = equipamentosC.get(nome);
		}
			
		return buscado;
	}
	
	@Override
	public boolean modificarEquipamento(Equipamento novo)
	{
		boolean ret = false;
		
		if(equipamentosC.containsKey(novo.getNome()))
		{
			equipamentosC.replace(novo.getNome(), novo);
		}
		
		return ret;
	}
	
	@Override
	public List<Equipamento> listarTodosItens()
	{
		List<Equipamento> ret = new ArrayList<Equipamento>();
		
		ret.addAll(equipamentosPE.values());
		ret.addAll(equipamentosC.values());
		
		return ret;
	}
	
	@Override
	public List<Equipamento> listarItensComuns()
	{
		List<Equipamento> ret = new ArrayList<Equipamento>();
		
		for(Equipamento equip : equipamentosPE.values())
		{
			if(!equip.isCanalizador() &&
					!equip.getClass().equals(Arma.class) &&
					!equip.getClass().equals(Protecao.class))
			{
				ret.add(equip);
			}
		}
		
		for(Equipamento equip : equipamentosC.values())
		{
			if(!equip.isCanalizador() &&
					!equip.getClass().equals(Arma.class) &&
					!equip.getClass().equals(Protecao.class))
			{
				ret.add(equip);
			}
		}
		
		return ret;
	}
	
	@Override
	public List<Equipamento> listarTodosCanalizadores()
	{
		List<Equipamento> ret = new ArrayList<Equipamento>();
		
		for(Equipamento equip : equipamentosPE.values())
		{
			if(equip.isCanalizador() == true)
			{
				ret.add(equip);
			}
		}
		
		for(Equipamento equip : equipamentosC.values())
		{
			if(equip.isCanalizador() == true)
			{
				ret.add(equip);
			}
		}
		
		return ret;
	}
	
	@Override
	public List<Arma> listarTodasArmas()
	{
		List<Arma> ret = new ArrayList<Arma>();
		
		for(Equipamento equip : equipamentosPE.values())
		{
			if(equip.getClass().equals(Arma.class))
			{
				ret.add((Arma)equip);
			}
		}
		
		for(Equipamento equip : equipamentosC.values())
		{
			if(equip.getClass().equals(Arma.class))
			{
				ret.add((Arma)equip);
			}
		}
		
		return ret;
	}
	
	@Override
	public List<Protecao> listarTodasArmaduras()
	{
		List<Protecao> ret = new ArrayList<Protecao>();
		
		for(Equipamento equip : equipamentosPE.values())
		{
			if(equip.getClass().equals(Protecao.class))
			{
				ret.add((Protecao)equip);
			}
		}
		
		for(Equipamento equip : equipamentosC.values())
		{
			if(equip.getClass().equals(Protecao.class))
			{
				ret.add((Protecao)equip);
			}
		}
		
		return ret;
	}
}
