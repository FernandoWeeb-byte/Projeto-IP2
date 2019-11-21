package negocio;

import java.util.List;

import negocio.beans.*;
import negocio.controladores.*;

public class Fachada {
	
	/// Singleton
	private static Fachada INSTANCE;
	
	
	/// Atributos
	private ControladorClasses controlCls;
	private ControladorHabilidades controlHab;
	private ControladorRacas controlRc;
	
	
	/// Construturo
	private Fachada()
	{
		controlCls = new ControladorClasses();
		controlHab = new ControladorHabilidades();
		controlRc = new ControladorRacas();
	}
	
	
	/// Metodos
	public static Fachada getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new Fachada();
		}
		
		return INSTANCE;
	}
	
	
	/// Metodos delegate <ControladorClasses>
	public boolean adicionarClasse(Classe cls) {
		return controlCls.adicionarClasse(cls);
	}

	public boolean removerClasse(String nome) {
		return controlCls.removerClasse(nome);
	}

	public Classe buscarClasse(String nome) {
		return controlCls.buscarClasse(nome);
	}

	public boolean modificarClasse(Classe cls) {
		return controlCls.modificarClasse(cls);
	}

	public List<Classe> listarTodasClasses() {
		return controlCls.listarTodasClasses();
	}


	/// Metodos delegate <ControladorHabilidade>
	public boolean adicionarHabilidade(Habilidade hab) {
		return controlHab.adicionarHabilidade(hab);
	}

	public boolean removerHabilidade(String nome) {
		return controlHab.removerHabilidade(nome);
	}

	public Habilidade buscarHabilidade(String nome) {
		return controlHab.buscarHabilidade(nome);
	}

	public boolean modificarHabilidade(Habilidade hab) {
		return controlHab.modificarHabilidade(hab);
	}

	public List<Habilidade> listarTodasHabilidades() {
		return controlHab.listarTodasHabilidades();
	}

	public List<Habilidade> listarHabilidadePorClasse(String nome) {
		return controlHab.listarHabilidadePorClasse(nome);
	}

	public List<Habilidade> listarHabilidadesPorRaca(String nome) {
		return controlHab.listarHabilidadesPorRaca(nome);
	}

	public List<Habilidade> listarHabilidadesPorTipo(String tipo) {
		return controlHab.listarHabilidadesPorTipo(tipo);
	}

	public List<Habilidade> listarHabilidadesPorCategoria(String categoria) {
		return controlHab.listarHabilidadesPorCategoria(categoria);
	}

	public List<Habilidade> listarHabilidadesComCustoManaMenorQue(int valor) {
		return controlHab.listarHabilidadesComCustoManaMenorQue(valor);
	}


	/// Metodos delegate <ControladorRacas>
	public boolean adicionarRaca(Raca raca) {
		return controlRc.adicionarRaca(raca);
	}

	public boolean removerRaca(String nome) {
		return controlRc.removerRaca(nome);
	}

	public Raca buscarRaca(String nome) {
		return controlRc.buscarRaca(nome);
	}

	public boolean modificarRaca(Raca raca) {
		return controlRc.modificarRaca(raca);
	}

	public List<Raca> listarTodasRacas() {
		return controlRc.listarTodasRacas();
	}
}
