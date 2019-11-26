package negocio;

import negocio.beans.*;

public class Testes {
	public static void main(String[] args) {
		Fachada f = Fachada.getInstance();
		
		Classe c = new Classe("Demon Slayer", 0, 1, 0, 1, f.buscarHabilidade("Mestre de Armas 1"), f.listarHabilidadePorClasse("Guerreiro"));
		Equipamento e = new Equipamento("Katana", 100, 2, "espada japonesa", false);
		
		String[] classes = {"Demon Slayer","Guerreiro"};
		String[] racas = {"-"};
		
		Habilidade h = new Habilidade("Hekireki Issen", "Ação", "Técnica", "-", 30, 0, classes, racas, "um corte em alta velocidade");
		Raca r = new Raca("Demonio", 4, 4, 1, 3, f.buscarHabilidade("Inflamar"), f.listarHabilidadePorClasse("Feiticeiro"));

		/*f.adicionarClasse(c);
		f.adicionarEquipamento(e);
		f.adicionarHabilidade(h);
		f.adicionarRaca(r);
		
		f.salvarTodosRepositórios();*/
		
		Classe cb = f.buscarClasse("Demon Slayer");
		Equipamento eb = f.buscarEquipamento("Katana");
		Habilidade hb = f.buscarHabilidade("Hekireki Issen");
		Raca rb = f.buscarRaca("Demonio");
		

		System.out.println(cb);
		System.out.println(eb.getNome());
		System.out.println(hb);
		System.out.println(rb);
	}
}
