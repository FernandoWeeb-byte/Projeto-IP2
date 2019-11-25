package dados.repositorios;

import negocio.beans.Habilidade;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dados.interfaces.IRepoHabilidades;

public class RepositorioHabilidades implements IRepoHabilidades {
	
	/// Singleton
	private static IRepoHabilidades INSTANCE;
	
	
	/// Atributos
	private final Map<String, Habilidade> habilidadesPreExistentes;
	private Map<String, Habilidade> habilidadesCriadas;

	
	/// Construtor
	private RepositorioHabilidades()
	{
		habilidadesPreExistentes = RepositorioHabilidades.carregarHabilidades("Habilidades - Habilidades.tsv");
		habilidadesCriadas = new HashMap<String, Habilidade>();
	}
	
	
	/// Metodos
	public String toString() {
		String str = "";
		
		for(Habilidade hab : habilidadesPreExistentes.values())
		{
			str += hab.toString();
			str += "\n";
		}
		
		for(Habilidade hab : habilidadesCriadas.values())
		{
			str += hab.toString();
			str += "\n";
		}
		
		return str;
	}
	
	public static IRepoHabilidades getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new RepositorioHabilidades();
		}
		
		return INSTANCE;
	}
	
	public static Map<String, Habilidade> carregarHabilidades(String path)
	{
		Map<String, Habilidade> ret = new HashMap<String, Habilidade>();
		
		try
		{
			File arquivo = new File(path);
			Scanner sc = new Scanner(arquivo);
			
			sc.nextLine(); // Pula a linha do cabecalho
			
			while (sc.hasNext())
			{
				String hb = sc.nextLine();
				try
				{
					String[] tipos = hb.split("\t");
					
					int mana = Integer.parseInt(tipos[4]);
					int dificuldade = Integer.parseInt(tipos[5]);
					
					String[] classes = tipos[6].split(",");
					String[] racas = tipos[7].split(",");
					
					Habilidade habilidade = new Habilidade(tipos[0], tipos[1], tipos[2], tipos[3], mana, dificuldade,
							classes, racas, tipos[8]);
					
					ret.put(habilidade.getNome(), habilidade);
				}
				catch (Exception e)
				{
					System.out.println(hb);
					e.printStackTrace();
				}
			}
			sc.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		return ret;
	}
	
	@Override
	public boolean adicionarHabilidade(Habilidade hab)
	{
		boolean ret = false;
		
		if(!habilidadesPreExistentes.containsKey(hab.getNome()) &&
				!habilidadesCriadas.containsKey(hab.getNome()))
		{
			habilidadesCriadas.put(hab.getNome(), hab);
			ret = true;
		}
		
		return ret;
	}
	
	@Override
	public boolean removerHabilidade(String nome)
	{
		boolean ret = false;
		
		if(habilidadesCriadas.containsKey(nome))
		{
			habilidadesCriadas.remove(nome);
			ret = true;
		}
		
		return ret;
	}
	
	@Override
	public boolean modificarHabilidade(Habilidade hab)
	{
		boolean ret = false;
		
		if(habilidadesCriadas.containsKey(hab.getNome()))
		{
			habilidadesCriadas.replace(hab.getNome(), hab);
			ret = true;
		}
		
		return ret;
	}

	@Override
	public Habilidade buscarHabilidade(String nome)
	{
		Habilidade buscada = null;
		
		if(this.habilidadesPreExistentes.containsKey(nome))
		{
			buscada = habilidadesPreExistentes.get(nome);
		}
		
		if(this.habilidadesCriadas.containsKey(nome))
		{
			buscada = habilidadesCriadas.get(nome);
		}
		
		return buscada;
	}
	
	@Override
	public List<Habilidade> listarTodasHabilidades()
	{
		List<Habilidade> habs = new ArrayList<Habilidade>();
		
		habs.addAll(habilidadesPreExistentes.values());
		habs.addAll(habilidadesCriadas.values());
		
		return habs;
	}
	
	@Override
	public List<Habilidade> listarHabilidadePorClasse(String nome)
	{
		List<Habilidade> hClasse = new ArrayList<Habilidade>();
		
		for(Habilidade hab : habilidadesPreExistentes.values())
		{
			if(hab.containsClasse(nome))
			{
				hClasse.add(hab);
			}
		}
		
		for(Habilidade hab : habilidadesCriadas.values())
		{
			if(hab.containsClasse(nome))
			{
				hClasse.add(hab);
			}
		}
		
		return hClasse;
	}
	
	@Override
	public List<Habilidade> listarHabilidadesPorRaca(String nome)
	{
		List<Habilidade> hRaca = new ArrayList<Habilidade>();
		
		for(Habilidade hab : habilidadesPreExistentes.values())
		{
			if(hab.containsRaca(nome))
			{
				hRaca.add(hab);
			}
		}
		
		for(Habilidade hab : habilidadesCriadas.values())
		{
			if(hab.containsRaca(nome))
			{
				hRaca.add(hab);
			}
		}
		
		return hRaca;
	}
	
	@Override
	public List<Habilidade> listarHabilidadesPorTipo(String tipo)
	{
		List<Habilidade> hTipo = new ArrayList<Habilidade>();
		
		for(Habilidade hab : habilidadesPreExistentes.values())
		{
			if(hab.getTipo().equals(tipo))
			{
				hTipo.add(hab);
			}
		}
		
		for(Habilidade hab : habilidadesCriadas.values())
		{
			if(hab.getTipo().equals(tipo))
			{
				hTipo.add(hab);
			}
		}
		
		return hTipo;
	}
	
	@Override
	public List<Habilidade> listarHabilidadesPorCategoria(String categoria)
	{
		List<Habilidade> hCategoria = new ArrayList<Habilidade>();
		
		for(Habilidade hab : habilidadesPreExistentes.values())
		{
			if(hab.getCategoria().equals(categoria))
			{
				hCategoria.add(hab);
			}
		}
		
		for(Habilidade hab : habilidadesCriadas.values())
		{
			if(hab.getCategoria().equals(categoria))
			{
				hCategoria.add(hab);
			}
		}
		
		return hCategoria;
	}
	
	@Override
	public List<Habilidade> listarHabilidadesComCustoManaMenorQue(int valor)
	{
		List<Habilidade> ret = new ArrayList<Habilidade>();
		
		for(Habilidade hab : habilidadesPreExistentes.values())
		{
			if(hab.getMana() <= valor)
			{
				ret.add(hab);
			}
		}
		
		for(Habilidade hab : habilidadesCriadas.values())
		{
			if(hab.getMana() <= valor)
			{
				ret.add(hab);
			}
		}
		
		return ret;
	}
}
