package vueController.carteHorizontale;

import java.awt.Color;

@SuppressWarnings("serial")
public class CarteChance extends CarteHorizontale {

	private static final String[] tabSentence = {
			"Reculez de trois cases.",
			"Faites des réparations dans toutes vos maisons : 2 500€/maison et 10 000€/hôtel.",
			"La banque vous verse un dividende de 5 000 €.",
			"Amende pour ivresse : 2 000 €.",
			"Avancez au Boulevard de la Villette. Si vous passez par la case \"Départ\" recevez 20 000 €.",
			"Vous êtes imposé pour les réparations de voirie à raison de : 4 000 €/maison et 11 500 €/hotel.",
			"Avancez jusqu'à la case \"Départ\".",
			"Votre immeuble et vos prêt rapportent. Touchez 15 000 €.",
			"Payez pour frais de scolarité : 15 000 €.",
			"Allez à la gare de Lyon. Si vous passez par la case \"Départ\" recevez 20 000 €.",
			"Vous êtes libéré de prison. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée ou vendue.",
			"Rendez - vous à l'Avenue Henri-Martin. Si vous passez par la case \"Départ\" recevez 20 000 €.",
			"Amende pour excès de vitesse : 1 500 €.",
			"Allez en prison, ne passez pas par la case départ",
			"Rendez - vous Rue de la paix",
			"C'est votre anniversaire, chaque joueurs vous doit 1000 €",
			"Vous gagnez le tournoi de mots-croisés, vous remportez 10 000 €."
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
