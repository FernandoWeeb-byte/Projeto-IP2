package gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import negocio.beans.Arma;
import negocio.beans.Equipamento;
import negocio.beans.Habilidade;
import negocio.beans.Protecao;

public class ControllerTelaVisu {
	@FXML
    private TextArea descricao;
	Habilidade hab = Habilidade.habildade;
	Equipamento equip = Equipamento.equipamento;
	
	
	void carregarDescricao()
	{
		
		if(hab != null) {
			descricao.setText(hab.descricaoCompleta());
		}
		if(equip != null) {
			if(equip.getClass().equals(Protecao.class))
	    	{
	    		Protecao prot = (Protecao) equip;
	    		String str = String.format("%s\n"
						+ "Custo: %d\n"
						+ "Defesa: ", prot.getNome(), prot.getCusto());

	    		if(prot.isEscudo())
	    		{
	    			str += String.format("+%d\n", prot.getBloqueio());
	    		}
	    		else
	    		{
	    			str += String.format("%d\n", prot.getEsquiva());
	    		}

	    		str += String.format("FN: %d\n"
	    				+ "Peso: %.2f\n", prot.getfN(), prot.getPeso());
	    		descricao.setText(str);
	    		
	    	}else if(equip.getClass().equals(Arma.class))
	    	{
	    		Arma arma = (Arma) equip;
	    		String str = String.format("%s\n"
						+ "Custo: %d\n"
						+ "Dano: ", arma.getNome(), arma.getCusto());	

	    		if(arma.isCarregar())
	    		{
	    			str += String.format("%d\n", arma.getDano());
	    		}
	    		else
	    		{
	    			str += String.format("For+%d\n", arma.getDano());
	    		}

	    		str += String.format("Tipo: %s\n"
	    				+ "FN: %d\n"
	    				+ "Peso: %.2f\n"
	    				+ "Distância: %s\n",
	    				arma.getTipoDano(), arma.getfN(), arma.getPeso(), arma.getDistancia());
	    		descricao.setText(str);
	    	}
	    	else {
	    	String str = String.format("%s\n"
					+ "Custo: %d\n", equip.getNome(), equip.getCusto());

	    			if(equip.getfN() > 0)
	    			{
	    				str += String.format("FN: %d\n", equip.getfN());
	    			}

	    			str += String.format("Peso: %.2fkg\n"
	    					+ "Descrição: %s\n",
	    					equip.getPeso(), equip.getDescricao());
	    	
	    			descricao.setText(str);
	    	}
		}
	}
	
	@FXML
    void initialize() {
		carregarDescricao();
	}
}
