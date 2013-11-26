package vueController.carteHorizontale;

import java.awt.Color;

@SuppressWarnings("serial")
public class CarteTaxe extends CarteHorizontale {
	
	public CarteTaxe() {
		super();
		
		this.setTitle("Taxe");
		this.getPanelCouleur().setBackground(Color.gray);
		this.getIntitule().setText("Vous perdez 10 000 €.");
		this.setEtat(4);
		this.getLabelTitre().setText("Taxe de luxe");
	}

}
