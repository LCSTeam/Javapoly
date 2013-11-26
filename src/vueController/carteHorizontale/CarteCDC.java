package vueController.carteHorizontale;


import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class CarteCDC extends CarteHorizontale {

	private static final String[] tabSentence = {
			"La vente de votre stock vous rapporte 5 000 �.", "Recevez votre revenu annuel de 10 000 �.",
			"Payez une amende de 1 000 � ou tirez une carte CHANCE.",
			"Allez en prison. Avancez tout droit en prison. Ne passer pas par la case \"D�part\". Ne recevez pas 20 000�",
			"Erreur de la banque en votre faveur, recevez 20 000 �.", "C'est votre anniversaire : chaque joueur doit vous donner 1 000 �.",
			"Vous avez gagn� le deuxi�me prix de beaut�, vous recevez 1 000 �.", "Payez votre police d'assurance s'�levant � 5 000 �.",
			"Les contributions vous remboursent la somme de 2 000 �.", "Placez - vous sur la case \"D�part\".",
			"Recevez votre int�r�t sur l'emprunt de 2 500 �.", "Retournez � Belleville.", "Vous h�ritez de 10 000 �.",
			"Vous �tes lib�r� de prison. Cette carte peut �tre conserv�e jusqu'� ce qu'elle soit utilis�e ou vendue.",
			"Payez � l'hopital 10 000 �.", "Payez la note du m�decin : 5 000 �."
	};
	
	private String sentence;

	public CarteCDC() {
		super();

		this.setTitle("Caisse de communaut�");
		this.getPanelCouleur().setBackground(Color.BLUE);
		int rand = (int) (Math.random() * (tabSentence.length)) + 0;
		this.sentence = tabSentence[rand];
		this.getIntitule().setText(this.sentence);
		this.setEtat(1);
		this.getLabelTitre().setText("Caisse de communaut�");
		this.getLabelTitre().setFont(new Font("Arial", Font.BOLD, 25));
		
	}
}
