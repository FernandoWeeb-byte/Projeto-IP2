package negocio.beans;

public class Equipamento {
	
	/// Atributos
		private String nome;
		private int custo;
		private double peso;
		private String descricao;
		private boolean canalizador; //Verifica se é canalizador
		private boolean arma;  //Verifica se é arma
		private boolean protecao; //Verifica se é protecao
		
		
		//Gets e Sets
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public int getCusto() {
			return custo;
		}
		public void setCusto(int custo) {
			this.custo = custo;
		}
		public double getPeso() {
			return peso;
		}
		public void setPeso(double peso) {
			this.peso = peso;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public boolean isCanalizador() {
			return canalizador;
		}
		public void setCanalizador(boolean canalizador) {
			this.canalizador = canalizador;
		}
		public boolean isArma() {
			return arma;
		}
		public void setArma(boolean arma) {
			this.arma = arma;
		}
		public boolean isProtecao() {
			return protecao;
		}
		public void setProtecao(boolean protecao) {
			this.protecao = protecao;
		}
}
