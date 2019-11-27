package dados.repositorios;

import negocio.beans.Classe;
import negocio.beans.Raca;

import java.util.Map;

import dados.interfaces.IRepoHabilidades;
import dados.interfaces.IRepoRacas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositorioRacas implements IRepoRacas {
	
	/// Singleton
	private static IRepoRacas INSTANCE;
	
	
	/// Atributos
	private final Map<String, Raca> racasPreExistentes;
	private Map<String, Raca> racasCriadas;
	
	
	/// Construtor
	private RepositorioRacas()
	{
		racasPreExistentes = gerarRacasPreExistentes();
		racasCriadas = carregarRacasCriadas();
	}
	
	
	/// Metodos
	public String toString()
	{
		String str = "";
		
		for(Raca rc : racasPreExistentes.values())
		{
			str += rc.toString();
			str += "\n";
		}
		
		for(Raca rc : racasCriadas.values())
		{
			str += rc.toString();
			str += "\n";
		}
		
		return str;
	}
	
	public static IRepoRacas getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new RepositorioRacas();
		}
		
		return INSTANCE;
	}
	
	private Map<String, Raca> gerarRacasPreExistentes()
	{
		IRepoHabilidades repHab = RepositorioHabilidades.getInstance();
		
		Map<String, Raca> ret = new HashMap<String, Raca>();
		
		ret.put("Anão", new Raca("Anão", 4, 2, 3, 3, repHab.buscarHabilidade("Coração da Montanha"),
							repHab.listarHabilidadesPorRaca("Anão")));
		ret.put("Elfo", new Raca("Elfo", 2, 4, 3, 3, repHab.buscarHabilidade("Benção de Lathellanis"),
							repHab.listarHabilidadesPorRaca("Elfo")));
		ret.put("Humano", new Raca("Humano", 3, 3, 3, 3, repHab.buscarHabilidade("Adaptabilidade"),
								repHab.listarHabilidadesPorRaca("Humano")));
		ret.put("Metadílio", new Raca("Metadílio", 2, 4, 3, 3, repHab.buscarHabilidade("Tamanho Pequeno"),
								repHab.listarHabilidadesPorRaca("Metadílio")));
		
		return ret;
	}
	
	@Override
	public boolean adicionarRaca(Raca raca)
	{
		boolean ret = false;
		
		if(!racasPreExistentes.containsKey(raca.getNome()) &&
				!racasCriadas.containsKey(raca.getNome()))
		{
			racasCriadas.put(raca.getNome(), raca);
			ret = true;
		}

		return ret;
	}
	
	@Override
	public boolean removerRaca(String nome)
	{
		boolean ret = false;

		if(racasCriadas.containsKey(nome))
		{
			racasCriadas.remove(nome);
			ret = true;
		}
		
		return ret;
	}
	
	@Override
	public Raca buscarRaca(String nome)
	{
		Raca ret = null;
		
		if(racasPreExistentes.containsKey(nome))
		{
			ret = racasPreExistentes.get(nome);
		}
		
		if(racasCriadas.containsKey(nome))
		{
			ret = racasCriadas.get(nome);
		}
		
		return ret;
	}
	
	@Override
	public boolean modificarRaca(Raca raca)
	{
		boolean ret = false;

		if(racasCriadas.containsKey(raca.getNome()))
		{
			racasCriadas.replace(raca.getNome(), raca);
			ret = true;
		}
		
		return ret;
	}
	
	@Override
	public List<Raca> listarTodasRacas()
	{
		List<Raca> ret = new ArrayList<Raca>();
		
		ret.addAll(racasPreExistentes.values());
		ret.addAll(racasCriadas.values());
		
		return ret;
	}
	
	private Map<String, Raca> carregarRacasCriadas()
	{
		File f = new File("Racas.rep");
		
		Map<String, Raca> ret = null;
		
		try
		{
			if(!f.exists())
			{
				f.createNewFile();
				ret = new HashMap<String, Raca>();
				return ret;
			}
			
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);

			try
			{
				if((ret = (Map<String, Raca>)ois.readObject()) == null)
				{
					ret = new HashMap<String, Raca>();
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
			ret = new HashMap<String, Raca>();
		}
		
		return ret;
	}
	
	public boolean salvarRacas()
	{
		boolean ret = false;
		
		File f = new File("Racas.rep");
		
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
				oos.writeObject(this.racasCriadas);
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
