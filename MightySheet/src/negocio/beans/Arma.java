package negocio.beans;

public class Arma extends Equipamento {
	
	/// Atributos
	private int dano;
	private String tipoDano;
	private String tipoArma;
	private int fN;
	private String distancia;
	private boolean duasMaos;
	
	//Métodos
	public boolean isDuasMaos() {
		if(this.duasMaos == true) {
			return true;
		}
		else {
			return false;
		}
	}
}
