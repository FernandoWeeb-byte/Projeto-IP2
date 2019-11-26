package negocio.beans;

public class Arma extends Equipamento {
	
	/// Atributos
	private int dano;
	private String tipoDano;
	private int fN;
	private String distancia;
	private boolean carregar;
	private boolean duasMaos;
	
	
	/// Construtor
	public Arma(String nome, int custo, double peso, String descricao, boolean canalizador, String categoria,
				int dano, String tipoDano, int fN, String distancia, boolean carregar, boolean duasMaos)
	{
		super(nome, custo, peso, descricao, canalizador, categoria);

		this.dano = dano;
		this.tipoDano = tipoDano;
		this.fN = fN;
		this.distancia = distancia;
		this.carregar = carregar;
		this.duasMaos = duasMaos;
	}
	
	
	/// Métodos
	@Override
	public String toString()
	{
		String str = String.format("%s\n"
									+ "Custo: %d\n"
									+ "Dano: ", this.getNome(), this.getCusto());	
		
		if(carregar)
		{
			str += String.format("%d\n", this.dano);
		}
		else
		{
			str += String.format("For+%d\n", this.dano);
		}
		
		str += String.format("Tipo: %s\n"
							+ "FN: %d\n"
							+ "Peso: %.2f\n"
							+ "Distância: %s\n",
							this.tipoDano, this.fN, this.getPeso(), this.distancia);
			
		return str;
	}

	//Gets e Sets
	public int getDano() {
		return dano;
	}


	public void setDano(int dano) {
		this.dano = dano;
	}


	public String getTipoDano() {
		return tipoDano;
	}


	public void setTipoDano(String tipoDano) {
		this.tipoDano = tipoDano;
	}


	public int getfN() {
		return fN;
	}


	public void setfN(int fN) {
		this.fN = fN;
	}


	public String getDistancia() {
		return distancia;
	}


	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}


	public boolean isCarregar() {
		return carregar;
	}


	public void setCarregar(boolean carregar) {
		this.carregar = carregar;
	}


	public boolean isDuasMaos() {
		return duasMaos;
	}


	public void setDuasMaos(boolean duasMaos) {
		this.duasMaos = duasMaos;
	}
}
