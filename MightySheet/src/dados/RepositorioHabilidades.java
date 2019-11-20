package dados;

import negocio.beans.Habilidade;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RepositorioHabilidades {
	
	/// Singleton
	private static RepositorioHabilidades INSTANCE;
	
	
	/// Atributos
	Map<String, Habilidade> habilidades;

	
	/// Construtor
	private RepositorioHabilidades()
	{
		habilidades = RepositorioHabilidades.listarHabilidade("ListaDeHabilidades.tsv");
	}
	
	
	/// Metodos
	public static RepositorioHabilidades getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new RepositorioHabilidades();
		}
		
		return INSTANCE;
	}
	
	public static Map<String, Habilidade> listarHabilidade(String path)
	{
		Map<String, Habilidade> ret = new HashMap<String, Habilidade>();
		
		try
		{
			File arquivo = new File(path);
			Scanner sc = new Scanner(arquivo);
			sc.useDelimiter(";");
			while (sc.hasNext())
			{
				try
				{
					String hb = sc.nextLine();
					String[] tipos = hb.split("\t");
					
					int mana = Integer.parseInt(tipos[4]);
					int dificuldade = Integer.parseInt(tipos[5]);
					
					String[] classes = tipos[6].split(",");
					String[] racas = tipos[7].split(",");
					
					Habilidade habilidade = new Habilidade(tipos[0], tipos[1], tipos[2], tipos[3], mana, dificuldade,
							classes, racas, tipos[8]);
					
					System.out.println(habilidade.getNome());
					
					ret.put(habilidade.getNome(), habilidade);
				}
				catch (Exception e)
				{
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

	public Habilidade buscarPorNome(String nome)
	{
		Habilidade buscada = null;
		
		if(this.habilidades.containsKey(nome))
		{
			buscada = habilidades.get(nome);
		}
		
		return buscada;
	}

	public List<Habilidade> habilidadePorClasse(String nome)
	{
		List<Habilidade> hClasse = new ArrayList<Habilidade>();
		
		for(Habilidade hab : habilidades.values())
		{
			if(hab.containsClasse(nome))
			{
				hClasse.add(hab);
			}
		}
		
		return hClasse;
	}

	public String toString() {
		String str = "";
		
		for(Habilidade hab : habilidades.values())
		{
			str += hab.toString();
		}
		
		return str;
	}
}
