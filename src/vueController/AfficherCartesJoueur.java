package vueController;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JDialog;
import javax.swing.JLabel;



import model.Joueur;

public class AfficherCartesJoueur extends JDialog{
	
	private JLabel labelCartesJoueur;
	private Joueur joueur;
	
	public AfficherCartesJoueur(Joueur j) {
		
		super();
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(300, 400);
		this.setJoueur(j);
		this.creerFenetre();
		
	}
	
	public void creerFenetre(){
		
		
		Container contenu = this.getContentPane();
		this.labelCartesJoueur = new JLabel();
		contenu.add(labelCartesJoueur);
		labelCartesJoueur.setBackground(Color.red);
		labelCartesJoueur.setBounds(5, 5, 290, 390);
		
		if(joueur.getCartes().isEmpty()==false){
			joueur.afficherCartes();	
		}
		else
			System.out.println("Pas de cartes");
		
		
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

}
