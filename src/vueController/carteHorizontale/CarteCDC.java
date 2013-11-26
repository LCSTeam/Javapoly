package vueController.carteHorizontale;


import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class CarteCDC extends CarteHorizontale {

	private static final String[] tabSentence = {
			"La vente de votre stock vous rapporte 5 000 €.", "Recevez votre revenu annuel de 10 000 €.",
			"Payez une amende de 1 000 € ou tirez une carte CHANCE.",
			"Allez en prison. Avancez tout droit en prison. Ne passer pas par la case \"Départ\". Ne recevez pas 20 000€",
			"Erreur de la banque en votre faveur, recevez 20 000 €.", "C'est votre anniversaire : chaque joueur doit vous donner 1 000 €.",
			"Vous avez gagné le deuxième prix de beauté, vous recevez 1 000 €.", "Payez votre police d'assurance s'élevant à 5 000 €.",
			"Les contributions vous remboursent la somme de 2 000 €.", "Placez - vous sur la case \"Départ\".",
			"Recevez votre intérêt sur l'emprunt de 2 500 €.", "Retournez à Belleville.", "Vous héritez de 10 000 €.",
			"Vous êtes libéré de prison. Cette carte peut être conservée jusqu'à ce qu'elle soit utilisée ou vendue.",
			"Payez à l'hopital 10 000 €.", "Payez la note du médecin : 5 000 €."
	};
	
	private String sentence;

	public CarteCDC() {
		super();

		this.setTitle("Caisse de communauté");
		this.getPanelCouleur().setBackground(Color.BLUE);
		int rand = (int) (Math.random() * (tabSentence.length)) + 0;
		this.sentence = tabSentence[rand];
		this.getIntitule().setText(this.sentence);
		this.setEtat(1);
		this.getLabelTitre().setText("Caisse de communauté");
		this.getLabelTitre().setFont(new Font("Arial", Font.BOLD, 25));
		
	}
}
