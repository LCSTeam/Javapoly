package vueController.carteVerticale;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.Case;

@SuppressWarnings("serial")
public class CarteGare extends CarteVerticale {
	
	private Case caseChoisie;
	private ImageIcon iconGare;
	private JLabel labelHypotheque;
	private JLabel prixHypotheque;
	
	public CarteGare(JFrame parent, Case laCase)
	{
		super();
		this.caseChoisie = laCase;
		this.setTitle(laCase.getNom());
		this.creeCase();
	}
	
	public void creeCase()
	{	
		this.iconGare = new ImageIcon(ClassLoader.getSystemResource("train.jpg"));
		//*******Panel couleur***********
		this.panelCouleur.setBounds(3,10,254,160);
		this.panelCouleur.setBackground(null);
		this.labelType.setIcon(this.iconGare);
		this.labelNom.setText(this.caseChoisie.getNom());
		
		//*******Panel loyer***********
		String [] tableauxLabelLoyerGares = {"Loyer 1 gare","Loyer 2 gares","Loyer 3 gares","Loyer 4 gares"};
		
		this.panelLoyer.setBounds(30,170,190,90);
		this.panelLoyer.setLayout(new GridLayout(4,2));
		this.labelLoyer = new JLabel[4];
		this.prixLoyer = new JLabel[4];
		for(int i=0;i<4;i++)
		{
			this.labelLoyer[i]=new JLabel(tableauxLabelLoyerGares[i]);		
			this.panelLoyer.add(this.labelLoyer[i]);
			this.prixLoyer[i]=new JLabel(this.caseChoisie.getLoyers()[i]+"");
			this.prixLoyer[i].setHorizontalAlignment(SwingConstants.RIGHT);
			this.panelLoyer.add(this.prixLoyer[i]);
		}
		
		//*******Panel regle***********
		this.labelRegle.setVisible(false);
		
		//*******Panel prix***********
		this.panelPrixBatiments.setBounds(10,270,240,49);
		this.panelPrixBatiments.setLayout(new GridLayout(2,1));
		this.labelHypotheque=new JLabel("Valeur de l'hypothèque", SwingConstants.CENTER);
		this.panelPrixBatiments.add(this.labelHypotheque);
		this.prixHypotheque=new JLabel("10 000 €", SwingConstants.CENTER);
		this.panelPrixBatiments.add(this.prixHypotheque);
		
	}
}
