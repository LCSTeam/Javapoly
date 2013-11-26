package model;

import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class Case extends JButton {

	private static final String[] tabNom = { 	"", "Boulevard de Belleville", "Caisse de communauté", "Rue Lecourbe", "Impôt sur le revenu", 
												"Gare Montparnasse", "Rue de Vaugirard", "Chance", "Rue de Courcelles", "Avenue de la République",
												"", "Boulevard de la Vilette", "Compagnie d'électricité", "Avenue de Neuilly", "Rue de Paradis",
												"Gare de Lyon", "Avenue Mozart",  "Caisse de communauté", "Boulevard St Michel", "Place Pigalle",
												 "", "Avenue Matigon", "Chance", "Boulevard Malesherbes", "Avenue Henri-Martin",
												"Gare du Nord", "Faubourg St Honoré", "Place de la Bourse", "Compagnie des eaux", "Rue la Fayette",
												"", "Avenue de Breteuil", "Avenue Foch", "Caisse de communauté","Boulevard des Capucines",
												"Gare St Lazare", "Chance", "Avenue des Champs-Elysées", "Taxe de luxe", "Rue de la paix" };
	
	//0 --> Propriété  1 --> coins  2 --> gare  3 --> cdc 
	//4 --> chance  5 --> Impot  6 --> taxe  7 --> compagnie
	private static final int[] tabEtat = {	1,0,3,0,5,2,0,4,0,0,
											1,0,7,0,0,2,0,3,0,0,
											1,0,4,0,0,2,0,0,7,0,
											1,0,0,3,0,2,4,0,6,0
	};
	
	private static final int[] tabPrix = { 	0, 6000, 0, 6000, 20000, 20000, 10000, 0, 10000, 12000, 
											0, 14000, 15000, 14000, 16000, 20000, 18000, 0, 18000, 20000,
											0, 22000, 0, 22000, 24000, 20000, 26000, 26000, 15000, 28000,
											0, 30000, 30000, 0, 32000, 20000, 0, 35000, 10000, 40000 };
	
	private static final Color[] tabCouleur = { null, Color.PINK, null, Color.PINK, null, null, Color.CYAN, null, Color.CYAN, Color.CYAN,
												null, Color.MAGENTA, null, Color.MAGENTA, Color.MAGENTA, null, Color.ORANGE, null, Color.ORANGE, Color.ORANGE,
												null, Color.RED, null, Color.RED, Color.RED, null, Color.YELLOW, Color.YELLOW, null, Color.YELLOW,
												null, Color.GREEN, Color.GREEN, null, Color.GREEN, null, null, Color.BLUE, null, Color.BLUE };
	
	private static final int [][] tabLoyer = {	null, {200,1000,3000,9000,16000,25000}, null, {400,2000,6000,18000,32000,45000}, null,
												{2500,5000,10000,20000}, {600,3000,9000,27000,40000,55000}, null, {600,3000,9000,27000,40000,55000}, {800,4000,10000,30000,45000,60000},
												null, {1000,5000,15000,45000,62500,75000}, null, {1000,5000,15000,45000,62500,75000}, {1200,6000,18000,50000,70000,90000},
												{2500,5000,10000,20000}, {1400,7000,20000,55000,75000,95000}, null, {1400,7000,20000,55000,75000,95000}, {1600,8000,22000,60000,80000,100000},
												null, {1800,9000,25000,70000,87500,105000}, null, {1800,9000,25000,70000,87500,105000}, {2000,10000,30000,75000,92500,110000},
												{2500,5000,10000,20000}, {2200,11000,33000,80000,97500,115000}, {2200,11000,33000,80000,97500,115000}, null, {2400,12000,36000,85000,102500,120000},
												null, {2600,13000,39000,90000,110000,127500}, {2600,13000,39000,90000,110000,127500}, null, {2800,15000,45000,100000,120000,140000},
												{2500,5000,10000,20000}, null, {3500,17500,50000,110000,130000,150000}, null, {5000,20000,60000,140000,170000,200000}
											};

	private String nom;
	private int prix;
	private Color couleur;
	private int [] loyers;
	private int etat;

	// IHM --> affichage des attributs d'instance
	protected JPanel panelCouleur;
	protected JTextArea labelNom;
	protected JLabel labelPrix;
	protected ImageIcon [] logos;

	public Case(int i)
	{
		super();
		this.setNom(tabNom[i]);
		this.setPrix(tabPrix[i]);
		this.setCouleur(tabCouleur[i]);
		this.setLoyers(tabLoyer[i]);
		this.setEtat(tabEtat[i]);

		this.chargerLogos();
		
	}
	
	public void chargerLogos()
	{
		String [] nomsLogos = {"train","cdc","chance", "impot","taxe","eau","elec"};
		this.logos = new ImageIcon[7];
		for(int i=0;i<7;i++)
			this.logos[i] = new ImageIcon(ClassLoader.getSystemResource(nomsLogos[i]+"Petit.png"));
	}

	public Color getCouleur() {
		return this.couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public int [] getLoyers() {
		return loyers;
	}

	public void setLoyers(int [] loyers) {
		this.loyers = loyers;
	}

}
