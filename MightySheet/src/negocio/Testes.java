package negocio;

import negocio.beans.*;

public class Testes {
	public static void main(String[] args) {
		Fachada f = Fachada.getInstance();
		
		Equipamento e = f.buscarEquipamento("Frasco de Vidro");
		
		System.out.println("Pegando");
		System.out.println(e);
	}
}
