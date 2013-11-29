package vueController.cases;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import model.Case;

@SuppressWarnings("serial")
public class CaseGauche extends Case {


public CaseGauche(int i)
{
	super(i);
	this.dessinerLaCase();
}

public void dessinerLaCase()
{
	
	this.setBackground(new Color(214, 231, 212));
	this.setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.black));
	if(this.getPrix()!=0)
		this.setLayout(new GridLayout(1, 3));
	else
		this.setLayout(new GridLayout(1, 2));
	Font font = new Font("Arial", Font.BOLD, 9);
	
	this.panelCouleur = new JPanel();
	
	if(this.getCouleur() !=null)
	{
		this.panelCouleur.setBackground(this.getCouleur());
	}
	else
	{
		this.panelCouleur = new panelRetourne();
		this.panelCouleur.setOpaque(false);
		JLabel lab = new JLabel(this.logos[this.getEtat()-2]);
		if(this.getNom()=="Compagnie d'électricité")
		lab.setIcon(this.logos[this.getEtat()-1]);
		this.panelCouleur.add(lab);
	}

	this.labelNom = new areaRetourne(this.getNom());
	this.labelNom.setFont(font);
	this.labelNom.setEditable(false);
	this.labelNom.setLineWrap(true);
	this.labelNom.setWrapStyleWord(true);
	this.labelNom.setOpaque(false);
	//this.labelNom.setMargin(new Insets(-7,-7,-7,-7));
	
	if(this.getEtat()==2)
		this.labelNom.setMargin(new Insets(0, -4,-1, -1));
	
	if(this.getEtat()==4)
		this.labelNom.setMargin(new Insets(0, 4,-1, -1));
	
	if(this.getEtat()==3)
		this.labelNom.setMargin(new Insets(-10, 0, 0, 0));
	
	if(this.getPrix()!=0)
	{
		this.labelPrix = new labelRetourne(this.getPrix() + "€");
		this.labelPrix.setFont(font);
		this.labelPrix.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	if(this.getPrix()!=0)
		this.add(this.labelPrix);
	this.add(this.labelNom);
	this.add(this.panelCouleur);
	
}

}

@SuppressWarnings("serial")
class labelRetourne extends JLabel
{
	public labelRetourne(String lab)
	{
		super(lab);
		
	}
	
	public labelRetourne(ImageIcon icon)
	{
		super(icon);
		
	}

	@Override
    public void paintComponent(Graphics g) {
        Graphics2D gx = (Graphics2D) g;
        gx.rotate(Math.PI/2, getWidth() / 2,getHeight() / 2);
        super.paintComponent(g);
    }
}

@SuppressWarnings("serial")
class areaRetourne extends JTextArea
{
	public areaRetourne(String lab)
	{
		super(lab);
		
	}

	@Override
    public void paintComponent(Graphics g) {
        Graphics2D gx = (Graphics2D) g;
        gx.rotate(Math.PI/2, (getWidth()-15) / 2,(getHeight()-10) / 2);
        super.paintComponent(g);
    }
}

@SuppressWarnings("serial")
class panelRetourne extends JPanel
{
	public panelRetourne()
	{
		super();
		
	}

	@Override
    public void paintComponent(Graphics g) {
        Graphics2D gx = (Graphics2D) g;
        gx.rotate(Math.PI/2, (getWidth()-10) / 2,(getHeight()-10) / 2);
        super.paintComponent(g);
    }
}
