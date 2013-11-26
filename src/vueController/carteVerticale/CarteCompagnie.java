package vueController.carteVerticale;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import model.Case;

@SuppressWarnings("serial")
public class CarteCompagnie extends CarteVerticale
{
	private Case caseChoisie;
	private ImageIcon iconElec;
	private ImageIcon iconEau;
	
	private JTextArea regleUn;
	
	private JLabel labelHypotheque;
	private JLabel prixHypotheque;
	
	public CarteCompagnie(JFrame parent, Case laCase)
	{
		super();
		this.caseChoisie = laCase;
		this.setTitle(laCase.getNom());
		this.creeCase();
	}
	
	public void creeCase()
	{	
		this.iconElec = new ImageIcon(ClassLoader.getSystemResource("elec.png"));
		this.iconEau = new ImageIcon(ClassLoader.getSystemResource("eau.png"));
		
		//*******Panel couleur***********
		this.panelCouleur.setBounds(3,10,254,150);
		this.panelCouleur.setBackground(null);
		if(this.caseChoisie.getNom()=="Compagnie des eaux")
			this.labelType.setIcon(this.iconEau);
		else
			this.labelType.setIcon(this.iconElec);
		this.labelNom.setText(this.caseChoisie.getNom());
		
		//*******Panel loyer***********
		
		this.panelLoyer.setBounds(10,160,240,51);
		this.panelLoyer.setLayout(null);
		
		this.regleUn = new JTextArea("Si l'on possède UNE carte de compagnie de Service public, le loyer est 400 fois le montant des dés.");
		this.regleUn.setBounds(0,0,240,51);
		this.regleUn.setLineWrap(true);
		this.regleUn.setWrapStyleWord(true);
		this.regleUn.setOpaque(false);
		this.regleUn.setEditable(false);
		this.regleUn.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.darkGray));
		this.panelLoyer.add(this.regleUn);
		
		//*******Panel regle***********
		this.labelRegle.setBounds(10,210,240,51);
		this.labelRegle.setText("Si l'on possède les DEUX cartes de compagnie de Service public, le loyer est 1000 fois le montant des dés.");
		
		//*******Panel prix***********
		this.panelPrixBatiments.setBounds(10,270,240,49);
		this.panelPrixBatiments.setLayout(new GridLayout(2,1));
		this.labelHypotheque=new JLabel("Valeur de l'hypothèque", SwingConstants.CENTER);
		this.panelPrixBatiments.add(this.labelHypotheque);
		this.prixHypotheque=new JLabel("7 500 €", SwingConstants.CENTER);
		this.panelPrixBatiments.add(this.prixHypotheque);
		
	}
}
