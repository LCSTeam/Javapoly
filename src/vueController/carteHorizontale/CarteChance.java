package vueController.carteHorizontale;

import java.awt.Color;

@SuppressWarnings("serial")
public class CarteChance extends CarteHorizontale {

	private static final String[] tabSentence = {
			"Reculez de trois cases.",
			"Faites des r�parations dans toutes vos maisons : 2 500�/maison et 10 000�/h�tel.",
			"La banque vous verse un dividende de 5 000 �.",
			"Amende pour ivresse : 2 000 �.",
			"Avancez au Boulevard de la Villette. Si vous passez par la case \"D�part\" recevez 20 000 �.",
			"Vous �tes impos� pour les r�parations de voirie � raison de : 4 000 �/maison et 11 500 �/hotel.",
			"Avancez jusqu'� la case \"D�part\".",
			"Votre immeuble et vos pr�t rapportent. Touchez 15 000 �.",
			"Payez pour frais de scolarit� : 15 000 �.",
			"Allez � la gare de Lyon. Si vous passez par la case \"D�part\" recevez 20 000 �.",
			"Vous �tes lib�r� de prison. Cette carte peut �tre conserv�e jusqu'� ce qu'elle soit utilis�e ou vendue.",
			"Rendez - vous � l'Avenue Henri-Martin. Si vous passez par la case \"D�part\" recevez 20 000 �.",
			"Amende pour exc�s de vitesse : 1 500 �.",
			"Allez en prison, ne passez pas par la case d�part",
			"Rendez - vous Rue de la paix",
			"C'est votre anniversaire, chaque joueurs vous doit 1000 �",
			"Vous gagnez le tournoi de mots-crois�s, vous remportez 10 000 �."
		};
	
	private String sentence;

	public CarteChance() {
		super();
		
		this.setTitle("Chance");
		this.getPanelCouleur().setBackground(Color.RED);
		int i = (int) (Math.random() * (tabSentence.length)) + 0;
		this.sentence = tabSentence[i];
		this.getIntitule().setText(this.sentence);
		this.setEtat(2);
		this.getLabelTitre().setText("Chance");
	}
}
