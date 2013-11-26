package vueController.carteHorizontale;

import java.awt.Color;

@SuppressWarnings("serial")
public class CarteImpot extends CarteHorizontale {
	
	public CarteImpot() {
		super();
		
		this.setTitle("Impôt");
		this.getPanelCouleur().setBackground(Color.gray);
		this.getIntitule().setText("Vous perdez 20 000 €.");
		this.setEtat(3);
		this.getLabelTitre().setText("Impôt sur le revenu");
	}
}
