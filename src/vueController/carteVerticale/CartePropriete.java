package vueController.carteVerticale;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Case;

@SuppressWarnings("serial")
public class CartePropriete extends CarteVerticale
{
	private Case caseChoisie;
	
	private JLabel labelMaison;
	private JLabel prixMaison;
	private JLabel labelHotel;
	private JLabel prixHotel;
	private JLabel labelHypotheque;
	private JLabel prixHypotheque;
	
	public CartePropriete(JFrame parent, Case laCase)
	{
		super();
		this.caseChoisie = laCase;
		this.setTitle(laCase.getNom());
		creeCase();
	}
	
	public void creeCase()
	{		
		//*******Panel couleur***********
		this.panelCouleur.setBackground(this.caseChoisie.getCouleur());
		this.labelType.setText("Titre de propriété");
		this.labelNom.setText(this.caseChoisie.getNom());
		
		//*******Panel loyer***********
		String [] tableauxLabelLoyer = {"loyer terrain nu","loyer 1 maison","loyer 2 maisons","loyer 3 maisons","loyer 4 maisons","loyer 1 hotel"};
		
		this.panelLoyer.setLayout(new GridLayout(6,2));
		this.labelLoyer = new JLabel[6];
		this.prixLoyer = new JLabel[6];
		for(int i=0;i<6;i++)
		{
				this.labelLoyer[i]=new JLabel(tableauxLabelLoyer[i]);
				this.panelLoyer.add(this.labelLoyer[i]);
				this.prixLoyer[i]=new JLabel(this.caseChoisie.getLoyers()[i]+"");
				this.prixLoyer[i].setHorizontalAlignment(SwingConstants.RIGHT);
				this.panelLoyer.add(this.prixLoyer[i]);
			
		}
		
		//*******Panel regle***********
		this.labelRegle.setText("Si un joueur possède TOUS les terrains d'un groupe de couleur"
				+ "quelconque, le loyer des terrains nus de ce groupe est doublé.");
		
		//*******Panel prix***********
		
		
		JPanel panelPrixGauche = new JPanel();
		panelPrixGauche.setBounds(0,0,160,79);
		panelPrixGauche.setLayout(new GridLayout(3,1));
		panelPrixGauche.setBackground(Color.white);
		this.labelMaison=new JLabel("Prix d'une maison");
		this.labelHotel=new JLabel("Prix d'un hotel");
		this.labelHypotheque=new JLabel("Valeur de l'hypothèque");
		panelPrixGauche.add(this.labelMaison);
		panelPrixGauche.add(this.labelHotel);
		panelPrixGauche.add(this.labelHypotheque);
		
		JPanel panelPrixDroit = new JPanel();
		panelPrixDroit.setBounds(160,0,80,79);
		panelPrixDroit.setLayout(new GridLayout(3,1));
		panelPrixDroit.setBackground(Color.white);
		this.prixMaison=new JLabel("");
		this.prixHotel=new JLabel("");
		this.prixHypotheque=new JLabel("");
		panelPrixDroit.add(this.prixMaison);
		panelPrixDroit.add(this.prixHotel);
		panelPrixDroit.add(this.prixHypotheque);
		
		this.panelPrixBatiments.add(panelPrixGauche);
		this.panelPrixBatiments.add(panelPrixDroit);
	}
}
