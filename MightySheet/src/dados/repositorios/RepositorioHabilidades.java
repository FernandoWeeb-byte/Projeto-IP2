package dados.repositorios;

import negocio.beans.Classe;
import negocio.beans.Habilidade;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

		habilidadesPreExistentes = carregarHabilidadesPE();
		habilidadesCriadas = carregarHabilidadesCriadas();

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
	
	private Map<String, Habilidade> carregarHabilidadesPE()
	{
		Map<String, Habilidade> ret = new HashMap<String, Habilidade>();
		
		try
		{
			File arquivo = new File("ListaDeHabilidades.tsv");
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
	

	private Map<String, Habilidade> carregarHabilidadesCriadas()
	{
		File f = new File("Habilidades.rep");
		
		Map<String, Habilidade> ret = null;
		
		try
		{
			if(!f.exists())
			{
				f.createNewFile();
				ret = new HashMap<String, Habilidade>();
				return ret;
			}
			
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);

			try
			{
				if((ret = (Map<String, Habilidade>)ois.readObject()) == null)
				{
					ret = new HashMap<String, Habilidade>();
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
			ret = new HashMap<String, Habilidade>();
		}
		
		return ret;
	}
	
	public boolean salvarHabilidades()
	{
		boolean ret = false;
		
		File f = new File("Habilidades.rep");
		
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
				oos.writeObject(this.habilidadesCriadas);
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
	public List<Habilidade> habilidadesBasicaAvancadaOuFinal(Classe classe, int level)
	{
		List<Habilidade> saida = new ArrayList<Habilidade>();
		String classesDeCada[] = null;
		for(Map.Entry<String, Habilidade> entry: this.habilidadesPreExistentes.entrySet())
		{
			classesDeCada = entry.getValue().getClasses();
			Habilidade valor = entry.getValue();
			String req = entry.getValue().getRequisito();
			if(level<5)
			{
				for(int i=0; i<classesDeCada.length; i++)
				{
					if(classesDeCada[i].equals(classe.getNome()) && !req.contains("Nível 5") && !req.contains("Nível 10") && !saida.contains(valor))
					{
						saida.add(valor);
					}
				}	
			} else if( level < 10)
			{
				for(int i=0; i<classesDeCada.length; i++)
				{
					if(classesDeCada[i].equals(classe.getNome()) && req.contains("Nível 10") && !saida.contains(valor))
					{
						saida.add(valor);
					}
				}	
			} else if( level >=10)
			{
				for(int i=0; i<classesDeCada.length; i++)
				{
					if(classesDeCada[i].equals(classe.getNome()) && req.contains("Nível 10") && !saida.contains(valor))
					{
						saida.add(valor);
					}
				}
				
			}	
		}
		return saida;

	}
}
