package negocio.beans;

import java.util.ArrayList;
import java.util.HashMap;



public class Personagem {
	
	/// Atributos
	// Informacoes
	private String nomePersonagem;
	private String nomeJogador;
	private Raca raca;
	private Classe classe;
	private int nivel;
	private int experiencia;
	private int deslocamento;
	private int corrida;
	private int cargaBasica;
	private int cargaPesada;
	private int cargaMaxima;
	
	// Atributos
	private int forca;
	private int agilidade;
	private int inteligencia;
	private int vontade;
	private int vida;
	private int mana;
	private HashMap<String, Integer> pericias;
	
	// Defesas
	private int esquiva;
	private int bloqueio;
	private int determinacao;
	
	// Habilidades
	private Habilidade[] habilidadesAutomaticas;
	private ArrayList<Habilidade> habilidades;
	private int quantHabilidades;
	
	// Equipamentos
	private Protecao vestimenta;
	private Arma maoDireita;
	private Equipamento maoEsquerda;
	private ArrayList<Equipamento> equipamentos;
	private int ouro;
	
	/*Gets e Sets 
	 * 	A maioria dos Sets calcula os valores automaticamente, 
	 * 	mas se quisere um que permita inserir o valor manualmente avise-me,
	 * 	ou crie-o você mesmo.
	 */
	public String getNomePersonagem() {
		return nomePersonagem;
	}
	public void setNomePersonagem(String nomePersonagem) {
		this.nomePersonagem = nomePersonagem;
	}
	public String getNomeJogador() {
		return nomeJogador;
	}
	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}
	public Raca getRaca() {
		return raca;
	}
	public void setRaca(Raca raca) {
		this.raca = raca;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public int getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
	public int getDeslocamento() {
		return deslocamento;
	}
	public void setDeslocamento() {
		this.deslocamento = (this.agilidade/2) + 5;
	}
	public int getCorrida() {
		return corrida;
	}
	public void setCorrida() {
		if(((Protecao) this.vestimenta).isPesada() == false) {
			this.corrida = this.deslocamento * 4;
		}
		else if(((Protecao) this.vestimenta).isRigida() == false){
			this.corrida = this.deslocamento * 3;
		}
		else {
			this.corrida = this.deslocamento * 2;
		}
	}
	public int getCargaBasica() {
		return cargaBasica;
	}
	public void setCargaBasica(int forca) {
		this.cargaBasica = forca * 7;
	}
	public int getCargaPesada() {
		return cargaPesada;
	}
	public void setCargaPesada(int cargaBasica) {
		this.cargaPesada = cargaBasica * 5;
	}
	public int getCargaMaxima() {
		return cargaMaxima;
	}
	public void setCargaMaxima(int cargaBasica) {
		this.cargaMaxima = cargaBasica * 10;
	}
	public int getForca() {
		return forca;
	}
	public void setForca(int forca) {
		this.forca = forca;
	}
	public int getAgilidade() {
		return agilidade;
	}
	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}
	public int getInteligencia() {
		return inteligencia;
	}
	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	public int getVontade() {
		return vontade;
	}
	public void setVontade(int vontade) {
		this.vontade = vontade;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public HashMap<String, Integer> getPericias() {
		return pericias;
	}
	public void setPericias(HashMap<String, Integer> pericias) {
		this.pericias = pericias;
	}
	public int getEsquiva() {
		return esquiva;
	}
	public void setEsquiva() {
		this.esquiva = 5 + this.agilidade + ((Protecao) this.vestimenta).getEsquiva();
	}
	public int getBloqueio() {
		return bloqueio;
	}
	public void setBloqueio() {
		if(this.maoEsquerda.isProtecao() == true) {
			this.bloqueio = 5 + this.forca + ((Protecao) this.vestimenta).getBloqueio() + ((Protecao) this.maoEsquerda).getBloqueio();
		}
		else {
			this.bloqueio = 5 + this.forca + ((Protecao) this.vestimenta).getBloqueio();
		}
	}
	public int getDeterminacao() {
		return determinacao;
	}
	public void setDeterminacao() {
		if(this.inteligencia > vontade) {
			this.determinacao = 8 + this.inteligencia;
		}
		else {
			this.determinacao = 8 + this.vontade;
		}
	}
	public Habilidade[] getHabilidadesAutomaticas() {
		return habilidadesAutomaticas;
	}
	public void setHabilidadesAutomaticas(Habilidade[] habilidadesAutomaticas) {
		this.habilidadesAutomaticas = habilidadesAutomaticas;
	}
	public ArrayList<Habilidade> getHabilidades() {
		return habilidades;
	}
	public void setHabilidades(ArrayList<Habilidade> habilidades) {
		this.habilidades = habilidades;
	}
	public int getQuantHabilidades() {
		return quantHabilidades;
	}
	public void setQuantHabilidades() {
		this.quantHabilidades = 2 + this.nivel;
	}
	public Protecao getVestimenta() {
		return vestimenta;
	}
	public void setVestimenta(Protecao vestimenta) {
		if(this.equipamentos.contains(vestimenta) && ((Protecao) vestimenta).isEscudo() == false) {
			this.vestimenta = vestimenta;
		}
		else {
			this.vestimenta = null;
		}
	}
	public Arma getMaoDireita() {
		return maoDireita;
	}
	public void setMaoDireita(Arma maoDireita) {
		this.maoDireita = maoDireita;
	}
	public Equipamento getMaoEsquerda() {
		return maoEsquerda;
	}
	public void setMaoEsquerda(Equipamento maoEsquerda) {
		if(((Arma) this.maoDireita).isDuasMaos() == false) {
			this.maoEsquerda = maoEsquerda;
		}
		else {
			this.maoEsquerda = null;
		}
	}
	public ArrayList<Equipamento> getEquipamentos() {
		return equipamentos;
	}
	public void setEquipamentos(ArrayList<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}
	public int getOuro() {
		return ouro;
	}
	public void setOuro(int ouro) {
		this.ouro = ouro;
	}
	

	//Métodos Extras (adicionadores de coisa)
	public void levelUp(int up) {
		this.nivel += up;
	}
	public void xpUp(int up) {
		this.experiencia += up;
	}
	public void speedUp(int up) {
		this.deslocamento += up;
	}
	public void bulkUp(int up) {
		this.cargaBasica += up;
	}
	public void forUp(int up) {
		this.forca += up;
	}
	public void agiUp(int up) {
		this.agilidade += up;
	}
	public void intUp(int up) {
		this.inteligencia += up;
	}
	public void vonUp(int up) {
		this.vontade += up;
	}
	public void lifeUp(int up) {
		this.vida += up;
	}
	public void manaUp(int up) {
		this.mana += up;
	}
	public void blqUp(int up) {
		this.bloqueio += up;
	}
	public void sqvUp(int up) {
		this.esquiva += up;
	}
	public void dtrUp(int up) {
		this.determinacao += up;
	}	

	
	//Construtor
		public Personagem(String nomePersonagem, String nomeJogador, Raca raca, Classe classe, int nivel, int experiencia, int corrida, int cargaBasica, int cargaPesada, int cargaMaxima, int forca, int agilidade,
				int inteligencia, int vontade, int vida, int mana, HashMap<String, Integer> pericias, Habilidade[] habilidadesAutomaticas, ArrayList<Habilidade> habilidades, Protecao vestimenta, Arma maoDireita, Equipamento maoEsquerda,
				ArrayList<Equipamento> equipamentos, int ouro) {
			super();
			this.nomePersonagem = nomePersonagem;
			this.nomeJogador = nomeJogador;
			this.raca = raca;
			this.classe = classe;
			this.nivel = nivel;
			this.experiencia = experiencia;
			this.forca = forca;
			this.agilidade = agilidade;
			this.inteligencia = inteligencia;
			this.vontade = vontade;
			this.vida = vida;
			this.mana = mana;
			this.pericias = pericias;
			this.habilidadesAutomaticas = habilidadesAutomaticas;
			this.habilidades = habilidades;
			this.vestimenta = vestimenta;
			this.maoDireita = maoDireita;
			this.maoEsquerda = maoEsquerda;
			this.equipamentos = equipamentos;
			this.ouro = ouro;
		}
}