package negocio;

import negocio.beans.*;

public class Testes {
	public static void main(String[] args) {
		Fachada f = Fachada.getInstance();
		String[] str = {"humano", "Anão"};
		String[] str2 = {"Feiticerio", "Guerreiro"};
		Habilidade hab = new Habilidade("olosdasdasdco","Suporte" ,"Magia" , "-", 10, 30, str, str2, "uma habildade apelona");
		//f.adicionarHabilidade(hab);
		
		
		System.out.println(f.adicionarHabilidade(hab));
		System.out.println(f.buscarHabilidade("olosdasdasdco"));
	}
}
