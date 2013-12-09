package vueController;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.swing.*;

import model.Case;
import model.Joueur;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import vueController.achatCarte.AchatCarteCompagnie;
import vueController.achatCarte.AchatCarteGare;
import vueController.achatCarte.AchatCartePropriete;
import vueController.carteHorizontale.CarteCDC;
import vueController.carteHorizontale.CarteChance;
import vueController.carteHorizontale.CarteImpot;
import vueController.carteHorizontale.CarteTaxe;
import vueController.carteVerticale.CarteCompagnie;
import vueController.carteVerticale.CarteGare;
import vueController.carteVerticale.CartePropriete;
import vueController.cases.CaseBas;
import vueController.cases.CaseDroite;
import vueController.cases.CaseGauche;
import vueController.cases.CaseHaut;


@SuppressWarnings("serial")
public class IHMMonopoly extends JFrame implements ActionListener {

	private JPanel panelPlateau;

	private JButton[] cases;
	private JButton buttonLancerDes;
	
	private JPanel panelHaut;
	private JPanel panelBas;
	private JPanel panelGauche;
	private JPanel panelDroit;
	private JPanel panelInfoJeu;
	private JPanel panelCartesJoueurs;
	private JPanel panelDes;
	private JPanelJoueurs [] panelUnJoueur;
	
	private ImageIcon depart;
	private ImageIcon simpleVisite;
	private ImageIcon parc;
	private ImageIcon prison;
	private ImageIcon [] tabDes;
	
	private JLabel centre;
	private JLabel carteCDC;
	private JLabel carteChance;
	
	private JLabel labelDe1;
	private JLabel labelDe2;
	private JLabel deplacement;
	
	private int nbJoueurs = 2;

	private JLabel unPion;
	
	private Joueur [] joueurs;
	private Audio i;
		
	/////Eléments du menu///////////////////
	
	private JMenuBar barreMenu;
	private JMenu menuJeu;
	private JMenuItem menuItemQuitter;
	private JMenuItem menuItemNouveau;
	private JMenuItem menuItemRegles;
	private JMenuItem menuItemRetourMenu;	
	private JMenu menuAide;
	private JMenuItem menuItemAPropos;
	private JMenu menuMusique;
	private JMenuItem menuItemActiverMusique;
	private JMenuItem menuItemDesactiverMusique;
	private JMenu menuItemChoixTheme;
	
	private JRadioButtonMenuItem theme1;
	private JRadioButtonMenuItem theme2;
	private ButtonGroup boutonGroup;

	public IHMMonopoly() {
		super("Monopoly");
		i = new Audio("sons/theme.wav");
		i.start();
		this.createMenu();
		this.chargeLesImages();
		this.creePanels();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 750);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(new Color(214, 231, 212));

		this.setResizable(false);
	}
	
	public void createMenu() {
		// création de la barre de menu
		barreMenu = new JMenuBar();
		// ajout de la barre à la fenêtre
		this.setJMenuBar(barreMenu);
		// création des menus
		menuJeu = new JMenu("Jeu");
		menuMusique= new JMenu("Musique");
		menuAide = new JMenu("?");

		// ajout des menus à la barre
		barreMenu.add(menuJeu);
		barreMenu.add(menuMusique);
		barreMenu.add(menuAide);

		// création des sous menus
		menuItemQuitter = new JMenuItem("Quitter");
		menuItemNouveau = new JMenuItem("Nouveau");
		menuItemRegles = new JMenuItem("Règles");
		menuItemRetourMenu = new JMenuItem("Retour au menu");	
		menuItemAPropos = new JMenuItem("à propos");
		menuItemActiverMusique =new JMenuItem("Activer la musique");
		menuItemDesactiverMusique =new JMenuItem("Désactiver la musique");
		this.menuItemChoixTheme =new JMenu("Choix de la musique");
		theme1 = new JRadioButtonMenuItem("Theme 1");
		theme2 = new JRadioButtonMenuItem("Theme 2");
		boutonGroup = new ButtonGroup();
		boutonGroup.add(theme1);
		boutonGroup.add(theme2);

		// ajout des sous-menus aux menus
		menuJeu.add(menuItemNouveau);
		menuJeu.add(menuItemRegles);		
		menuJeu.add(menuItemRetourMenu);
		menuJeu.add(menuItemQuitter);
		
		menuMusique.add(this.menuItemChoixTheme);
		menuItemChoixTheme.add(theme1);
		menuItemChoixTheme.add(theme2);
		menuMusique.add(menuItemActiverMusique);
		menuMusique.add(menuItemDesactiverMusique);
		
		theme1.setSelected(true);
		
		menuAide.add(menuItemAPropos);

		// Ecouteur
		menuItemNouveau.addActionListener(this);
		menuItemRegles.addActionListener(this);
		menuItemRetourMenu.addActionListener(this);
		menuItemQuitter.addActionListener(this);
		menuItemActiverMusique.addActionListener(this);
		menuItemDesactiverMusique.addActionListener(this);
		menuItemAPropos.addActionListener(this);
		theme1.addActionListener(this);
		theme2.addActionListener(this);
	}

	public void chargeLesImages() {
		
		this.depart = new ImageIcon(ClassLoader.getSystemResource("depart.png"));
		this.simpleVisite = new ImageIcon(ClassLoader.getSystemResource("simpleVisite.png"));
		this.parc = new ImageIcon(ClassLoader.getSystemResource("parcGratuit.png"));
		this.prison = new ImageIcon(ClassLoader.getSystemResource("enPrison.png"));
		
		tabDes = new ImageIcon[6];
		for(int i=0;i<6;i++)
			tabDes[i] = new ImageIcon(ClassLoader.getSystemResource("de/de"+(i+1)+".png"));
	}

	private void creePanels() {

		this.creePanelPlateau();
		this.creePanelInfos();
		
		this.unPion = new JLabel();
		this.unPion.setIcon(new ImageIcon(ClassLoader.getSystemResource("pions/bateau.png")));
		this.unPion.setName("0");
		this.unPion.setBounds(this.cases[0].getBounds().x, this.cases[0].getBounds().y, 50, 50);
		
		Container contenu = this.getContentPane();
		contenu.setLayout(null);
		contenu.add(panelPlateau);
		contenu.add(panelInfoJeu);
		panelPlateau.add(unPion, 1);
		

	}

	public void creePanelInfos()
	{
		//panel des informations joueurs
		this.panelInfoJeu = new JPanel();
		this.panelInfoJeu.setLayout(null);
		this.panelInfoJeu.setBounds(710, 25, 270, 650);
		this.panelInfoJeu.setBackground(new Color(214, 231, 212));
		
		this.panelCartesJoueurs = new JPanel();
		this.panelCartesJoueurs.setLayout(new GridLayout(4,3));
		this.panelCartesJoueurs.setBounds(10, 15, 250, 440);
		this.panelCartesJoueurs.setBackground(new Color(214, 231, 212));
		
		
		this.panelUnJoueur = new JPanelJoueurs[nbJoueurs];
		this.joueurs = new Joueur[nbJoueurs];
		for(int i=0;i<nbJoueurs;i++)
		{
			this.joueurs[i] = new Joueur();
			

			this.panelUnJoueur[i] = new JPanelJoueurs(joueurs[i]);
			this.panelCartesJoueurs.add(this.panelUnJoueur[i]);

		}	
		
		
		//Panel des dés
		this.panelDes= new JPanel();
		this.panelDes.setBounds(10,460,250,180);
		this.panelDes.setBackground(new Color(214, 231, 212));
		this.panelDes.setLayout(null);
		
		this.labelDe1 = new JLabel();
		this.labelDe1.setBounds(30,0,100,100);
		this.labelDe1.setIcon(tabDes[0]);
		
		this.labelDe2 = new JLabel();
		this.labelDe2.setBounds(130,0,100,100);	
		this.labelDe2.setIcon(tabDes[0]);
		
		this.deplacement = new JLabel("Chat");
		this.deplacement.setBounds(30,150,200,30);
		this.deplacement.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 2,Color.black));
		
		this.buttonLancerDes = new JButton("Lancer les dés !");
		this.buttonLancerDes.setBounds(55, 105, 150, 40);
		this.buttonLancerDes.addActionListener(this);
		
		this.panelDes.add(this.labelDe1);
		this.panelDes.add(this.labelDe2);
		this.panelDes.add(this.deplacement);
		this.panelDes.add(this.buttonLancerDes);
		
		this.panelInfoJeu.add(this.panelCartesJoueurs);
		this.panelInfoJeu.add(this.panelDes);
	}
	
	public void creePanelPlateau()
	{
		this.panelPlateau = new JPanel();
		this.panelPlateau.setLayout(null);
		this.panelPlateau.setBounds(50, 25, 650, 750);
		this.panelPlateau.setBackground(new Color(214, 231, 212));
		
		this.panelHaut = new JPanel();
		this.panelBas = new JPanel();
		this.panelGauche = new JPanel();
		this.panelDroit = new JPanel();
		
		this.carteCDC= new JLabel(new ImageIcon("images/cdc.png"));
		this.carteChance = new JLabel(new ImageIcon("images/chance.png"));
		this.centre = new JLabel(new ImageIcon("images/monopoly_plateau.png"));
		
		this.panelHaut.setBounds(100, 0, 450, 100);
		this.panelBas.setBounds(100, 550, 450, 100);
		this.panelGauche.setBounds(0,100,100,450);
		this.panelDroit.setBounds(550,100,100, 450);
		
		this.centre.setBounds(100, 100, 450, 450);
		this.carteCDC.setBounds(100, 100, 200, 200);
		this.carteChance.setBounds(360, 350, 190, 200);
		
	
		this.cases = new JButton[40];

		// Case départ
		this.cases[0] = new JButton(this.depart);
		this.cases[0].setBounds(550, 550, 100, 100);
		this.cases[0].setBorder(BorderFactory.createMatteBorder(1, 1, 2, 2,Color.black));
		//this.cases[0].addActionListener(this);

		// Simple visite ou prison
		this.cases[10] = new JButton(this.simpleVisite);
		this.cases[10].setBounds(0, 550, 100, 100);
		this.cases[10].setBorder(BorderFactory.createMatteBorder(1, 2, 2, 1,Color.black));
		//this.cases[10].addActionListener(this);

		// Parc gratuit
		this.cases[20] = new JButton(this.parc);
		this.cases[20].setBounds(0, 0, 100, 100);
		this.cases[20].setBorder(BorderFactory.createMatteBorder(2, 2, 1, 1,Color.black));
		//this.cases[20].addActionListener(this);

		// Allez en prison
		this.cases[30] = new JButton(this.prison);
		this.cases[30].setBounds(550, 0, 100, 100);
		this.cases[30].setBorder(BorderFactory.createMatteBorder(2, 1, 1, 2,Color.black));
		//this.cases[30].addActionListener(this);

		this.panelPlateau.add(this.cases[0]);
		this.panelPlateau.add(this.cases[10]);
		this.panelPlateau.add(this.cases[20]);
		this.panelPlateau.add(this.cases[30]);

		this.panelBas.setLayout(new GridLayout(1, 9));
		for (int i = 9; i >= 1; i--) {
			this.cases[i] = new CaseBas(i);
			this.cases[i].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.black));
			this.panelBas.add(this.cases[i]);
			this.cases[i].addActionListener(this);
		}

		this.panelGauche.setLayout(new GridLayout(9, 1));
		for (int i = 19; i >= 11; i--) {
			this.cases[i] = new CaseGauche(i);
			this.cases[i].setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.black));
			this.panelGauche.add(this.cases[i]);
			this.cases[i].addActionListener(this);
		}
		

		this.panelHaut.setLayout(new GridLayout(1, 9));
		for (int i = 21; i <= 29; i++) {
			this.cases[i] = new CaseHaut(i);
			this.cases[i].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.black));
			this.panelHaut.add(this.cases[i]);
			this.cases[i].addActionListener(this);
		}

		this.panelDroit.setLayout(new GridLayout(9, 1));
		for (int i = 31; i <= 39; i++) {
			this.cases[i] = new CaseDroite(i);
			this.cases[i].setBorder(BorderFactory.createMatteBorder(1, 2, 1, 2, Color.black));
			this.panelDroit.add(this.cases[i]);
			this.cases[i].addActionListener(this);
		}
		
		this.panelPlateau.add(this.panelHaut);
		this.panelPlateau.add(this.panelBas);
		this.panelPlateau.add(this.panelGauche);
		this.panelPlateau.add(this.panelDroit);
		this.panelPlateau.add(this.centre);
		this.panelPlateau.add(this.carteCDC);
		this.panelPlateau.add(this.carteChance);
	
	}
	
	public int calculDeplacement(){
		
		int resultat= (Integer.parseInt(this.labelDe1.getName()) + Integer.parseInt(this.labelDe2.getName()));
		this.deplacement.setText("Vous avez fait "+resultat);
		
		return resultat;
	}
	
	public void lancerLesDes(){

			int j = (int) (Math.random() * (7-1)) + 1;
			int k = (int) (Math.random() * (7-1)) + 1;
			
				this.labelDe1.setIcon(tabDes[j-1]);
				this.labelDe1.setName(j+"");
				this.labelDe2.setIcon(tabDes[k-1]);
				this.labelDe2.setName(k+"");
				
				this.calculDeplacement();
		
	}
	
	public void saveComponentAsJPEG(Component myComponent, String filename) {
	    Dimension size = myComponent.getSize();
	    BufferedImage myImage = new BufferedImage(size.width-10, size.height-8, BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2 = myImage.createGraphics();
	    myComponent.paint(g2);
	    try {
	        OutputStream out = new FileOutputStream(filename);
	        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	        encoder.encode(myImage);
	        out.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	
	public JLabel getLabelDe1() {
		return labelDe1;
	}

	public void setLabelDe1(JLabel labelDe1) {
		this.labelDe1 = labelDe1;
	}

	public JLabel getLabelDe2() {
		return labelDe2;
	}

	public void setLabelDe2(JLabel labelDe2) {
		this.labelDe2 = labelDe2;
	}

	public JLabel getScore() {
		return deplacement;
	}

	public void setScore(JLabel score) {
		this.deplacement = score;
	}

	

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		///////Actions du menu///////////////////////////////////
		
		if(e.getSource()==menuItemNouveau){
			i.stop();
			this.dispose();
			IHMMonopoly m = new IHMMonopoly();
			m.setVisible(true);
			}
		if(e.getSource()==menuItemQuitter){
			int rep = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment quitter ?","Quitter le jeu",JOptionPane.YES_NO_OPTION);
			switch(rep){
			case(0):
				this.dispose();	
				i.stop();
							
			}
		}
		if(e.getSource()==menuItemRetourMenu){
			i.stop();
			this.dispose();
			IHMMenu m = new IHMMenu();
			m.setVisible(true);
		}
		if(e.getSource()==this.menuItemRegles){
			Regles r;
			r = new Regles();
			r.setVisible(true);
			r.setModal(true);
		
		}
		
		if(e.getSource()==theme1){
			i.stop();
			i= new Audio("sons/theme.wav");
			i.start();	
			
			
		}
		
		if(e.getSource()==theme2){
			i.stop();
			i= new Audio("sons/theme2.wav");
			i.start();
			
		}
		
		if(e.getSource()==this.menuItemAPropos){
			
			JOptionPane
			.showMessageDialog(
					this,
					"Ce jeu a  été réalisé par\n\nCyril CARON,\nLéo LETOURNEUR\net Alexandre SIMONIN\n\nNous sommes de jeunes développeurs et nous avons "
							+ "voulu mettre en pratique nos connaissances en Java en créant ce jeu !\n\nAmusez vous bien !\n\nMonopoly est une propriété de Hasbro");
		}
		
		if(e.getSource()==menuItemActiverMusique){
					
					if(i.isAlive()==false){
					i= new Audio("sons/theme.wav");
					i.start();
					}else
					{
						
					}
					
				}
		if(e.getSource()==menuItemDesactiverMusique){
			i.stop();
			
		}
		
		///////Actions des boutons//////////////////////////////////////

		if (e.getSource() == this.buttonLancerDes) {
			
			this.lancerLesDes();
						
		}

		for (int i = 0; i <= 39; i++) {

			if (e.getSource() == this.cases[i]) {
				
				if (((Case) this.cases[i]).getEtat()==3)// cdc
				{
					CarteCDC c = new CarteCDC();
					c.setModal(true);
					c.setVisible(true);
				}

				else if (((Case) this.cases[i]).getEtat()==4)// chance
				{
					CarteChance c = new CarteChance();
					c.setModal(true);
					c.setVisible(true);
				}
				
				else if (((Case) this.cases[i]).getEtat()==5)// impot
				{
					CarteImpot c = new CarteImpot();
					c.setModal(true);
					c.setVisible(true);
				}
				
				else if (((Case) this.cases[i]).getEtat()==6)// taxe
				{
					CarteTaxe c = new CarteTaxe();
					c.setModal(true);
					c.setVisible(true);
					
				}
				
				else if (((Case) this.cases[i]).getEtat()==2)// Gare
				{
					CarteGare c = new CarteGare(this,(Case) this.cases[i]);
					c.setModal(true);
					c.setVisible(true);
					AchatCarteGare a = new AchatCarteGare(this,(Case) this.cases[i]);
					a.setVisible(true);
					this.joueurs[1].getCartes().put(((Case) this.cases[i]).getNumero(), (Case) this.cases[i]);
					//a.setModal(true);
				}
				
				else if (((Case) this.cases[i]).getEtat()==7)// Compagnie
				{
					CarteCompagnie c = new CarteCompagnie(this,(Case) this.cases[i]);
					c.setModal(true);
					c.setVisible(true);
					AchatCarteCompagnie a = new AchatCarteCompagnie(this,(Case) this.cases[i]);
					a.setVisible(true);
					this.joueurs[1].getCartes().put(((Case) this.cases[i]).getNumero(), (Case) this.cases[i]);
				//	a.setModal(true);
				}

				else {
					CartePropriete c = new CartePropriete(this,(Case) this.cases[i]);
					c.setModal(true);
					c.setVisible(true);
					if(((Case) this.cases[i]).getPrix()>this.joueurs[1].getBourse()){
						JOptionPane.showMessageDialog(null, "Vous ne pouvez pas acheter cette propriété ! Vous êtes trop pauvre");
					}
					else{
						AchatCartePropriete a = new AchatCartePropriete(this,(Case) this.cases[i], this.joueurs[1]);
					a.setVisible(true);
					this.joueurs[1].getCartes().put(((Case) this.cases[i]).getNumero(), (Case) this.cases[i]);
					//a.setModal(true);
					}
					
				}
			}

		}
		
		

	}

		
	public static void main(String[] args) {
		IHMMonopoly m = new IHMMonopoly();
		m.setVisible(true);
	
	}

}
