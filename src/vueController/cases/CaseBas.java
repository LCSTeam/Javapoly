package vueController.cases;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import model.Case;

@SuppressWarnings("serial")
public class CaseBas extends Case{

	public CaseBas(int i)
	{
		super(i);
		this.dessinerLaCase();
	}
	
	
	public void dessinerLaCase() {
		if(this.getPrix()!=0)
			this.setLayout(new GridLayout(3, 1));
		else
			this.setLayout(new GridLayout(2, 1));
		Font font = new Font("Arial", Font.BOLD, 9);

		this.panelCouleur = new JPanel();
		
		if(this.getCouleur() !=null)
			this.panelCouleur.setBackground(this.getCouleur());
		else
		{
			this.panelCouleur.setOpaque(false);
			JLabel lab = new JLabel(this.logos[this.getEtat()-2]);
			if(this.getNom()=="Compagnie d'électricité")
				lab.setIcon(this.logos[this.getEtat()-1]);
			this.panelCouleur.add(lab);
		}

		this.labelNom = new JTextArea(this.getNom());
		this.labelNom.setFont(font);

		this.labelPrix = new JLabel(this.getPrix() + "€");
		this.labelPrix.setFont(font);

		this.add(this.panelCouleur);
		this.add(this.labelNom);
		if(this.getPrix()!=0)
			this.add(this.labelPrix);

		Insets emptyInsets = new Insets(-1, -1, -1, -1);
		this.setMargin(emptyInsets);	
		this.labelPrix.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelNom.setEditable(false);
		this.labelNom.setLineWrap(true);
		this.labelNom.setWrapStyleWord(true);
		this.labelNom.setOpaque(false);
		
		this.setBackground(new Color(214, 231, 212));
		this.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.black));
		
	}
}
