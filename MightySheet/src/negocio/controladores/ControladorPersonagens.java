package negocio.controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import dados.RepositorioPersonagens;
import negocio.beans.Personagem;

public class ControladorPersonagens {
	
	public boolean salvar(Personagem personagem) {
		try {
			FileOutputStream fos = new FileOutputStream("Personagem.arq");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			// Escreve o objeto no arquivo
			oos.writeObject(personagem);
			oos.flush();

			oos.close();
			fos.close();
			
			return true;
		} catch(IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public void Carregar() {
		try {
			FileInputStream fis = new FileInputStream("Personagem.arq");
			ObjectInputStream ois = new ObjectInputStream(fis);

			// L� um objeto do arquivo
			RepositorioPersonagens repo = new RepositorioPersonagens();
			Personagem person = (Personagem)ois.readObject();
			repo.AdicionarFicha(person);
			
			 

			ois.close();
			fis.close();
			
			
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
	}

}
