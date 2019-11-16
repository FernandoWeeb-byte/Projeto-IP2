package negocio.beans;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class RepositorioHabilidades {
	ArrayList<Habilidade> habilidade = new ArrayList<>();
	
	public ArrayList<Habilidade> listarHabilidade()
	{
		
		try {
			
			File arquivo = new File("HabilidadesAtualizado1.txt");
			Scanner sc = new Scanner(arquivo);
			while(sc.hasNext()) {
			String hb = sc.nextLine();
			//System.out.println(hb);
			String[] tipos = hb.split("/");
			int mana = Integer.parseInt(tipos[4]);
			int dificuldade = Integer.parseInt(tipos[5]);
			Habilidade habilidade = new Habilidade(tipos[0],tipos[1],tipos[2], tipos[3],mana,dificuldade,tipos[6],tipos[7],tipos[8]);
			this.habilidade.add(habilidade);
			
			}
			sc.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return this.habilidade;
	}
	public Habilidade buscarPorNome(String nome)
	{
		Habilidade buscada = null;
		for(int i=0;i<this.habilidade.size();i++)
		{
			if(this.habilidade.get(i).getNome().contains(nome))
			{
				 buscada = this.habilidade.get(i);
			}
		}
		return buscada;
	}
	
	public ArrayList<Habilidade> habilidadePorClasse(String nome)
	{
		ArrayList<Habilidade> hClasse = new ArrayList<>();
		for(int i=0;i<habilidade.size();i++)
		{
			if(habilidade.get(i).getClasse().contains(nome))
			{
				hClasse.add(habilidade.get(i));
			}
		}
		return hClasse;
	}
	
	public String toString()
	{
		String str = null;
		for(Habilidade hab : habilidade )
		{	
			 str = String.format("%s\n"
					   + "Habilidade ",
					   hab.getNome());

			if(hab.getCategoria() != null)
			{
				str += String.format("(%s) ", hab.getCategoria());
			}

			str += String.format("- %s\n", hab.getTipo());

			if(hab.getRequisito() != null)
			{
				str += String.format("Requisito: %s\n", hab.getRequisito());
			}

			if(hab.getMana() >= 0)
			{
				if(hab.getMana() == 0)
				{
					str += "Mana: Varia\n";
				}
				else
				{
					str += String.format("Mana: %d\n", hab.getMana());	
				}
			}

			if(hab.getDificuldade() >= 0)
			{
				str += String.format("Dificuldade da Magia: %d\n", hab.getDificuldade());
			}


			str += String.format("Descricao: %s\n", hab.getDescricao());

			return str;
			
		}
		return str;
		
		
	}
	
}
