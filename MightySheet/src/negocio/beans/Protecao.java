package negocio.beans;

public class Protecao extends Equipamento {
	
	/// Atributos
		private int bloqueio;
		private int esquiva;
		private int fN;
		private boolean escudo;
		private boolean pesada;
		private boolean rigida;
		
		//Construtor
		public Protecao(int bloqueio, int esquiva, int fN, boolean escudo, boolean pesada, boolean rigida) {
			super();
			this.bloqueio = bloqueio;
			this.esquiva = esquiva;
			this.fN = fN;
			this.escudo = escudo;
			this.pesada = pesada;
			this.rigida = rigida;
			this.setProtecao(true);
		}
		
		//Gets e Sets
		public int getBloqueio() {
			return bloqueio;
		}
		public void setBloqueio(int bloqueio) {
			this.bloqueio = bloqueio;
		}
		public int getEsquiva() {
			return esquiva;
		}
		public void setEsquiva(int esquiva) {
			this.esquiva = esquiva;
		}
		public int getfN() {
			return fN;
		}
		public void setfN(int fN) {
			this.fN = fN;
		}
		public boolean isEscudo() {
			return escudo;
		}
		public void setEscudo(boolean escudo) {
			this.escudo = escudo;
		}
		public boolean isPesada() {
			return pesada;
		}
		public void setPesada(boolean pesada) {
			this.pesada = pesada;
		}
		public boolean isRigida() {
			return rigida;
		}
		public void setRigida(boolean rigida) {
			this.rigida = rigida;
		}
		
}
