package dados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import negocio.beans.Classe;
import negocio.beans.Raca;
import negocio.beans.Personagem;
import negocio.beans.Habilidade;
import negocio.beans.Arma;
import negocio.beans.Equipamento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class RepositorioPersonagens {
	
	///Singleton
	private static RepositorioPersonagens INSTANCE;
	
	
	///Atributos
	private List<Personagem> fichas;
	
	///Contrutor
	public RepositorioPersonagens()
	{
		this.fichas = new ArrayList<Personagem>();
	}
	
	
	
	
	
	
	
	
	
	
	
	///Metodos
	
	

public List<Personagem> todas()
	{
		 List<Personagem> saida = new ArrayList<Personagem>();
		 saida.addAll(fichas);
		 return saida;
	}
	
	public static RepositorioPersonagens getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new RepositorioPersonagens();
		}
		return INSTANCE;
	}
	
	public void AdicionarFicha(Personagem novo)
	{
		this.fichas.add(novo);
	}
	
	public void RemoverFicha(String nomeJogador, String nomePersonagem)
	{
		int freioDeMao = -1;
		for(int i=0; i<this.fichas.size() && freioDeMao < 0; i++)
		{
			if(this.fichas.get(i).getNomeJogador().equalsIgnoreCase(nomeJogador) && 
					this.fichas.get(i).getNomePersonagem().equalsIgnoreCase(nomePersonagem))
			{
				this.fichas.remove(i);
				freioDeMao = 42;
			}
		}	
	}
	
	public List<Personagem> listarPorClasse(Classe classe)
	{
		String buscado = classe.getNome();
		List<Personagem> saida = new ArrayList<Personagem>();
		for(Personagem p: this.fichas)
		{
			if(p.getClasse().getNome().equals(buscado))
			{
				
				saida.add(p);
			}
		}
		return saida;
	}
	
	
	public List<Personagem> listarPorRaca(Raca raca)
	{
		List<Personagem> saida = new ArrayList<Personagem>();
		for(Personagem p: this.fichas)
		{
			if(p.getRaca().getNome().equals(raca.getNome()))
			{
				saida.add(p);
			}
		}
		return saida;
	}
	
	
	public List<Personagem> listarPorJogador(String nome)
	{
		List<Personagem> saida = new ArrayList<Personagem>();
		for(Personagem p: this.fichas)
		{
			if(p.getNomeJogador().equals(nome))
			{
				saida.add(p);
			}
		}
		return saida;
	}
	
	public Personagem buscaPorPers(String nome)
	{
		Personagem saida;
		for(Personagem p: this.fichas)
		{
			if(p.getNomePersonagem().equals(nome))
			{
				saida = p;
				return saida;
			}
		}
		return null;
	}
	
	public void editarFicha(String nomePer, int nivel, int experiencia, int inteligencia, 
			int forca, int vontade, int vida, int mana, HashMap<String, Integer> pericias, 
			Habilidade[] habilidadesAutomaticas,ArrayList<Habilidade> habilidades,  int quantHabilidades,
			ArrayList<Arma> ataques, ArrayList<Equipamento> equipamentos, int ouro)
	{
		Personagem editado = this.buscaPorPers(nomePer);
		editado.setNivel(nivel);
		editado.setExperiencia(experiencia);
		editado.setInteligencia(inteligencia);
		editado.setForca(forca);
		editado.setVontade(vontade);
		editado.setVida(vida);
		editado.setMana(mana);
		editado.setPericias(pericias);
		editado.setHabilidadesAutomaticas(habilidadesAutomaticas);
		editado.setHabilidades(habilidades);
		editado.setQuantHabilidades(quantHabilidades);
		editado.setAtaques(ataques);
		editado.setEquipamentos(equipamentos);
		editado.setOuro(ouro);
		this.RemoverFicha(editado.getNomeJogador(), editado.getNomePersonagem());
		this.AdicionarFicha(editado);
	}
	

	
	
	/// Metodos de Arquivo
	
	public void carregarPersonagens() {
		try {
			FileInputStream fis = new FileInputStream("Personagem.arq");
			ObjectInputStream ois = new ObjectInputStream(fis);

			// Le um objeto do arquivo
			RepositorioPersonagens repo = RepositorioPersonagens.getInstance();
			List<Personagem> fichas = (List<Personagem>)ois.readObject();
			repo.fichas = fichas;
			

			ois.close();
			fis.close();
			
			
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
	}
	
	public boolean guardar()
	{
		try {
			FileOutputStream fos = new FileOutputStream("Personagem.arq");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// Escreve o objeto no arquivo
			oos.writeObject(this.fichas);
			oos.flush();

			oos.close();
			fos.close();
			
			return true;
		} catch(IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	

}
