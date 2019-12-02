package negocio.controladores;

import negocio.beans.Classe;
import negocio.beans.Habilidade;
import negocio.beans.Raca;
import dados.interfaces.IRepoHabilidades;
import dados.repositorios.RepositorioHabilidades;

import java.util.List;

public class ControladorHabilidades {
	
	/// Constantes
	private static final String ACAO = "Ação";
	private static final String REACAO = "Reação";
	private static final String SUPORTE = "Suporte";
	
	private static final String NULA = "-";
	private static final String CARACTERISTICA = "Característica";
	private static final String MAGIA = "Magia";
	private static final String TECNICA = "Técnica";
	
	
	/// Atributos
	private IRepoHabilidades repHab;
	
	
	/// Construtor
	public ControladorHabilidades()
	{
		this.repHab = RepositorioHabilidades.getInstance();
	}

	
	/// Metodos
	public boolean adicionarHabilidade(Habilidade hab)
	{
		boolean ret = false;
		
		if(hab != null)
		{
			if(hab.getNome() != null &&
					(ACAO.equals(hab.getTipo()) || REACAO.equals(hab.getTipo()) || SUPORTE.equals(hab.getTipo())) &&
					(NULA.equals(hab.getCategoria()) || CARACTERISTICA.equals(hab.getCategoria()) || MAGIA.equals(hab.getCategoria()) || TECNICA.equals(hab.getCategoria())) &&
					hab.getRequisito() != null &&
					hab.getClasses() != null &&
					hab.getRacas() != null &&
					hab.getDescricao() != null)
			{
				ret = repHab.adicionarHabilidade(hab);
			}
		}
		
		return ret;
	}
	
	public boolean removerHabilidade(String nome)
	{
		boolean ret = false;
		
		if(nome != null)
		{
			ret = repHab.removerHabilidade(nome);
		}
		
		return ret;
	}
	
	public Habilidade buscarHabilidade(String nome)
	{
		Habilidade ret = null;
		
		if(nome != null)
		{
			ret = repHab.buscarHabilidade(nome);
		}
		
		return ret;
	}
	
	public boolean modificarHabilidade(Habilidade hab)
	{
		boolean ret = false;
		
		if(hab != null)
		{
			if(hab.getNome() != null &&
					(ACAO.equals(hab.getTipo()) || REACAO.equals(hab.getTipo()) || SUPORTE.equals(hab.getTipo())) &&
					(NULA.equals(hab.getCategoria()) || CARACTERISTICA.equals(hab.getCategoria()) || MAGIA.equals(hab.getCategoria()) || TECNICA.equals(hab.getCategoria())) &&
					hab.getRequisito() != null &&
					hab.getClasses() != null &&
					hab.getRacas() != null &&
					hab.getDescricao() != null)
			{
				ret = repHab.modificarHabilidade(hab);
			}
		}
		
		return ret;
	}
	
	
	/// Metodos delegate
	public List<Habilidade> listarTodasHabilidades() {
		return repHab.listarTodasHabilidades();
	}

	public List<Habilidade> listarHabilidadePorClasse(String nome) {
		return repHab.listarHabilidadePorClasse(nome);
	}

	public List<Habilidade> listarHabilidadesPorRaca(String nome) {
		return repHab.listarHabilidadesPorRaca(nome);
	}

	public List<Habilidade> listarHabilidadesPorTipo(String tipo) {
		return repHab.listarHabilidadesPorTipo(tipo);
	}

	public List<Habilidade> listarHabilidadesPorCategoria(String categoria) {
		return repHab.listarHabilidadesPorCategoria(categoria);
	}

	public List<Habilidade> listarHabilidadesComCustoManaMenorQue(int valor) {
		return repHab.listarHabilidadesComCustoManaMenorQue(valor);
	}


	public boolean salvarHabilidades() {
		return repHab.salvarHabilidades();
	}	

	
	public List<Habilidade> habilidadesBasicaAvancadaOuFinal(Classe classe, int level)
	{
		if (level>0 && classe !=null)
		{
			return repHab.habilidadesBasicaAvancadaOuFinal(classe, level);
		} 
		return null;
	}
	
	public List<Habilidade> listarHabilidadePorClasse(Classe classe)
	{
		return repHab.listarHabilidadePorClasse(classe);
	}
	
	public List<Habilidade> listarHabilidadesPorRaca(Raca raca)
	{
		return repHab.listarHabilidadesPorRaca(raca);
	}

}
