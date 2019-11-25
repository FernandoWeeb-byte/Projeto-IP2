package negocio;

import negocio.beans.*;
import dados.interfaces.IRepoEquipamentos;
import dados.repositorios.RepositorioEquipamentos;
import java.util.List;

public class Testes {
	public static void main(String[] args) {
		Equipamento e1 = new Equipamento("Batata", 1, 0.5F, "uma batata", false);
		Equipamento e2 = new Equipamento("Barra de Ouro", 200, 10, "uma barra de ouro", false);
		Equipamento e3 = new Equipamento("Cajado", 30, 1, "um cajado usado por magos", true);
		Equipamento e4 = new Equipamento("Varinha", 30, 0.5F, "nunca viu Harry Potter n?", true);
		Arma a1 = new Arma("Espada", 15, 2, "uma espada longa", false, 4, "Corte", 4, "Corpo-a-corpo", false, false);
		Arma a2 = new Arma("Besta", 40, 1, "uma besta pequena", false, 4, "Perfuração", 4, "Curto", true, true);
		Protecao p1 = new Protecao("Escudo", 25, 4, "um escudo pequeno", false, 1, 0, 2, true, false, false);
		Protecao p2 = new Protecao("Armadura de Placas", 1500, 30, "uma full plate", false, 0, 5, 6, false, true, true);
		
		IRepoEquipamentos rep = RepositorioEquipamentos.getInstance();
		
		rep.adicionarEquipamento(e1);
		rep.adicionarEquipamento(e2);
		rep.adicionarEquipamento(e3);
		rep.adicionarEquipamento(e4);
		rep.adicionarEquipamento(a1);
		rep.adicionarEquipamento(a2);
		rep.adicionarEquipamento(p1);
		rep.adicionarEquipamento(p2);

		Arma a3 = new Arma("Espada", 15, 2, "uma espada longa", false, 40, "Corte", 4, "Corpo-a-corpo", false, false);
		
		rep.modificarEquipamento(a3);
		
		Equipamento b = rep.buscarEquipamento("Espada");
		
		System.out.println(b);
	}
}
