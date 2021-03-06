package vueController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import model.Joueur;

@SuppressWarnings("serial")
public class JPanelJoueurs extends JPanel implements ActionListener{
	
	private JButton voirCasesJoueur;
	private JLabel banque;
	private Joueur joueur;
	
	public JPanelJoueurs(Joueur j) {
		
		this.setBounds(10,0,230,100);
		TitledBorder contour = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
				"Joueur", TitledBorder.CENTER, TitledBorder.LEFT);
		this.setBorder(contour);
		this.joueur =j;
		this.setBackground(new Color(214, 231, 212));
		this.dessinerPanel();
		
		
	}
	
	public void dessinerPanel(){
		this.setLayout(null);
		this.voirCasesJoueur = new JButton("Voir les propriétés");
		this.banque = new JLabel("Banque : "+this.joueur.getBourse());

		this.voirCasesJoueur.setBounds(40,65,150,30);
		this.banque.setBounds(10,25,150,20);
		this.add(this.voirCasesJoueur);
		this.add(this.banque);
		this.voirCasesJoueur.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.voirCasesJoueur){
			
			AfficherCartesJoueur a = new AfficherCartesJoueur(this.joueur);
			a.setVisible(true);
			a.setModal(true);
			
		}
	
		
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

}
