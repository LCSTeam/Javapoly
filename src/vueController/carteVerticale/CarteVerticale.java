package vueController.carteVerticale;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class CarteVerticale extends JDialog
{
	public Container contenu;
	public JPanel carte;
	public JPanel panelCouleur;
	public JLabel labelType;
	public JLabel labelNom;
	
	public JPanel panelLoyer;
	public JLabel [] labelLoyer;
	public JLabel [] prixLoyer;
	
	public JTextArea labelRegle;
	
	public JPanel panelPrixBatiments;
	
	public CarteVerticale()
	{
		super();
		
		this.creeCarte();
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(300, 400);
		this.setLocationRelativeTo(null);
	}
	
	public void creeCarte()
	{
		this.panelCouleur = new JPanel();
		this.panelCouleur.setBounds(3,3,254,79);
		this.panelCouleur.setLayout(new GridLayout(2,1));
		
		this.labelType = new JLabel();
		this.labelType.setFont(new Font("Arial",Font.BOLD,12));
		this.labelType.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.labelNom = new JLabel();
		this.labelNom.setFont(new Font("Arial",Font.BOLD,14));
		this.labelNom.setHorizontalAlignment(SwingConstants.CENTER);
		this.panelCouleur.add(this.labelType);
		this.panelCouleur.add(this.labelNom);
		
		this.panelLoyer = new JPanel();
		this.panelLoyer.setBounds(30,79,190,120);
		this.panelLoyer.setBackground(Color.white);
		
		this.labelRegle = new JTextArea();
		this.labelRegle.setMargin(new Insets(2,0,0,0));
		this.labelRegle.setBounds(10,199,240,51);
		this.labelRegle.setLineWrap(true);
		this.labelRegle.setWrapStyleWord(true);
		this.labelRegle.setOpaque(false);
		this.labelRegle.setEditable(false);
		this.labelRegle.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.darkGray));
		
		this.panelPrixBatiments = new JPanel();
		this.panelPrixBatiments.setBounds(10,250,240,79);
		this.panelPrixBatiments.setBackground(Color.white);
		this.panelPrixBatiments.setLayout(null);
		
		TitledBorder contour = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
				"CARON SIMONIN LETOURNEUR ©", TitledBorder.CENTER, TitledBorder.BOTTOM);
		contour.setTitleFont(new Font("Arial",Font.BOLD,9));
		
		this.carte = new JPanel();
		this.carte.setBounds(10,10,260,350);
		this.carte.setBorder(contour);
		this.carte.setLayout(null);
		this.carte.setBackground(Color.white);
		this.carte.add(this.panelCouleur);
		this.carte.add(this.panelLoyer);
		this.carte.add(this.labelRegle);
		this.carte.add(this.panelPrixBatiments);
		
		
		this.contenu = new Container();
		this.setContentPane(this.contenu);
		this.contenu.add(this.carte);
	}
	
}
