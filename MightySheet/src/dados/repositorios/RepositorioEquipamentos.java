package dados.repositorios;

import negocio.beans.Equipamento;
import negocio.beans.Habilidade;
import negocio.beans.Arma;
import negocio.beans.Protecao;

import dados.interfaces.IRepoEquipamentos;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RepositorioEquipamentos implements IRepoEquipamentos {
	
	/// Singleton
	private static IRepoEquipamentos INSTANCE;
	
	
	/// Atributos
	private final Map<String, Equipamento> equipamentosPE;
	private Map<String, Equipamento> equipamentosC;
	
	
	/// Construtor
	private RepositorioEquipamentos()
	{
		equipamentosPE = carregarEquipamentosPE();
		equipamentosC = carregarEquipamentos();
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
		
	public List<String> listarCategorias() {
		List<String> lista = new ArrayList<String>();
		lista.add("Arma Corporal 1M");
		lista.add("Arma Corporal 2M");
		lista.add("Arco/Funda 1M");
		lista.add("Arco/Funda 2M");
		lista.add("Besta/Prodd 1M");
		lista.add("Besta/Prodd 2M");
		lista.add("Armadura");
		lista.add("Armadura Pesada");
		lista.add("Armadura Rígida");
		lista.add("Escudo");
		lista.add("Item");
		return lista;
	}
	
	public List<String> listarAlcances() {
		List<String> lista = new ArrayList<String>();
		lista.add("Corpo-a-corpo");
		lista.add("Haste");
		lista.add("Curto");
		lista.add("Médio");
		lista.add("Longo");
		return lista;
	}

	private Map<String, Equipamento> carregarEquipamentosPE()
	{
		Map <String, Equipamento> ret = new HashMap<String, Equipamento>();
		
		// Equipamentos
		try
		{
			File f = new File("ListaDeEquipamentos.tsv");
			Scanner sc = new Scanner(f);
			
			sc.nextLine(); // Pula a linha do cabeçalho
			
			while(sc.hasNext())
			{
				String equip = sc.nextLine();
				
				try
				{
					String[] tipos = equip.split("\t");
					
					int custo = Integer.parseInt(tipos[1]);
					
					int fN = 0;
					if(!tipos[2].equals("-"))
					{
						fN = Integer.parseInt(tipos[2]);
					}
					
					double peso = Double.parseDouble(tipos[3]);
					
					boolean canalizador = false;
					
					if(!tipos[4].equals("-"))
					{
						canalizador = true;
					}
					
					Equipamento e = new Equipamento(tipos[0], custo, fN, peso, tipos[5], canalizador, "");
					
					ret.put(e.getNome(), e);
				}
				catch(Exception e)
				{
					System.out.println(equip);
					e.printStackTrace();
				}
			}
			
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		// Armas
		try
		{
			File f = new File("ListaDeArmas.tsv");
			Scanner sc = new Scanner(f);
			
			sc.nextLine(); // Pula a linha do cabeçalho
			
			while(sc.hasNext())
			{
				String arma = sc.nextLine();
				
				try
				{
					String[] tipos = arma.split("\t");
					
					int custo = Integer.parseInt(tipos[1]);
					
					int dano = Integer.parseInt(tipos[2]);
					
					int fN = 0;
					if(!tipos[4].equals("-"))
					{
						fN = Integer.parseInt(tipos[4]);
					}
					
					double peso = Double.parseDouble(tipos[5]);
					
					boolean canalizador = false;
					if(!tipos[7].equals("-"))
					{
						canalizador = true;
					}
					
					boolean duasMaos = false;
					if(!tipos[8].equals("-"))
					{
						duasMaos = true;
					}
					
					boolean carregar = false;
					if(!tipos[9].equals("-"))
					{
						carregar = true;
					}
					
					Arma a = new Arma(tipos[0], custo, fN, peso, "", canalizador, "", dano,
										tipos[3], tipos[6], carregar, duasMaos);
					
					ret.put(a.getNome(), a);
				}
				catch(Exception e)
				{
					System.out.println(arma);
					e.printStackTrace();
				}
			}
			
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		// Armaduras
		try
		{
			File f = new File("ListaDeArmaduras.tsv");
			Scanner sc = new Scanner(f);
			
			sc.nextLine(); // Pula a linha do cabeçalho
			
			while(sc.hasNext())
			{
				String armadura = sc.nextLine();
				
				try
				{
					String[] tipos = armadura.split("\t");
					
					int custo = Integer.parseInt(tipos[1]);
					int bloqueio = Integer.parseInt(tipos[2]);
					int esquiva = Integer.parseInt(tipos[3]);
					
					int fN = 0;
					if(!tipos[4].equals("-"))
					{
						fN = Integer.parseInt(tipos[4]);
					}
					
					double peso = Double.parseDouble(tipos[5]);
					
					boolean escudo = false;
					if(!tipos[6].equals("-"))
					{
						escudo = true;
					}
					
					boolean pesada = false;
					if(!tipos[7].equals("-"))
					{
						pesada = true;
					}
					
					boolean rigida = false;
					if(!tipos[8].equals("-"))
					{
						rigida = true;
					}
					
					Protecao p = new Protecao(tipos[0], custo, fN, peso, "", false, "",
												bloqueio, esquiva, escudo, pesada, rigida);
					
					ret.put(p.getNome(), p);
				}
				catch(Exception e)
				{
					System.out.println(armadura);
					e.printStackTrace();
				}
			}
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return ret;
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
	
	private Map<String, Equipamento> carregarEquipamentos()
	{
		File f = new File("Equipamentos.rep");
		
		Map<String, Equipamento> ret = null;
		
		try
		{
			if(!f.exists())
			{
				f.createNewFile();
				ret = new HashMap<String, Equipamento>();
				return ret;
			}
			
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);

			try
			{
				if((ret = (Map<String, Equipamento>)ois.readObject()) == null)
				{
					ret = new HashMap<String, Equipamento>();
				}
			}
			catch(ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			ois.close();
		}
		catch(IOException e)
		{
			ret = new HashMap<String, Equipamento>();
		}
		
		return ret;
	}
	
	public boolean salvarEquipamentos()
	{
		boolean ret = false;
		
		File f = new File("Equipamentos.rep");
		
		try
		{
			if(!f.exists())
			{
				f.createNewFile();
			}
			
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			try
			{
				oos.writeObject(this.equipamentosC);
				ret = true;
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			oos.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		return ret;
	}
}
