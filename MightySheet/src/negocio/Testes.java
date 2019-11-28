package negocio;

import negocio.beans.*;

public class Testes {
	public static void main(String[] args) {
		Fachada f = Fachada.getInstance();
		f.listarTodasClasses();
		
		System.out.println(f.buscarClasse("hunter").getHabilidades());
		
	}
}
