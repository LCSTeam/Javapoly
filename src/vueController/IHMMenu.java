package vueController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class IHMMenu extends JFrame implements ActionListener{
	
	private JPanel panelBoutons;
	private JPanel panelPage1;
	private JPanel panelPage2;
	private JPanel panelNbJoueurs;
	private JPanel panelPions;
	private JButton start;
	private JButton suivant;
	private JButton jouer;
	private JButton quitter;
	private JButton precedent;
	private JButton precedent2;
	private JButton regles;
	private JButton aPropos;
	private JLabel image;
	private JLabel nbJoueurs;
	private ImageIcon imageMenu;
	private JLabel [] lesPions;
	private JRadioButton [] choixPion;
	private JRadioButton deuxPlayer;
	private JRadioButton troisPlayer;
	private JRadioButton quatrePlayer;
	private ImageIcon [] imagePion;
	private ButtonGroup bg;

	
	private String [] pions={"bateau","brouette","voiture","chapeau","chaussure","chien","coudre","repasser"};
	private Audio i;
	
	public IHMMenu() {
		
		super("Monopoly");
		i =new Audio("sons/menu.wav");
		i.start();
		this.chargerImage();
		this.creePanels();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,750);
		this.setLocationRelativeTo(null);
		
		this.setResizable(false);
	}
	
	private void chargerImage() {
		this.imageMenu = new ImageIcon(ClassLoader.getSystemResource("monopoly.jpg"));
		this.imagePion = new ImageIcon[8];
		for(int i=0 ; i<8 ; i++) {
			
			this.imagePion[i] = new ImageIcon(ClassLoader.getSystemResource("pions/"+pions[i]+".png"));
			
		}
		
	}
	
	private void creePanels() {
		
		this.creePanelBoutons();

		Container contenu = this.getContentPane();
		contenu.setLayout(null);
		contenu.add(panelBoutons);
		
		
	}
	

	public void creePanelBoutons()
	{
		
		
		// Panel général
		this.panelBoutons = new JPanel();
		this.panelBoutons.setLayout(null);
		this.panelBoutons.setBounds(50,50,700,650);
		
		this.image = new JLabel(this.imageMenu);
		this.image.setBounds(0,0,700,341);
		this.panelBoutons.add(this.image);
		
		// Panel page 1
		this.panelPage1 = new JPanel();
		this.panelPage1.setLayout(new GridLayout(2, 2,70,50));
		this.panelPage1.setBounds(0,400,700,200);
		this.start = new JButton("Nouvelle partie");
		this.quitter = new JButton("Quitter");
		this.regles = new JButton("RÃ¨gles");
		this.aPropos = new JButton("A propos");
		this.panelPage1.add(this.start);
		this.panelPage1.add(this.quitter);
		this.panelPage1.add(this.regles);
		this.panelPage1.add(this.aPropos);
		this.panelBoutons.add(this.panelPage1);
		
		// Panel page 2
		this.panelPage2 = new JPanel();
		this.panelPage2.setLayout(null);
		this.panelPage2.setBounds(0,400,700,200);
		//this.panelPage2.setVisible(false);
		
		this.nbJoueurs = new JLabel("Choisissez le nombre de joueurs");
		this.nbJoueurs.setBounds(100,30,250,30);
		
		this.suivant = new JButton("Suivant");
		this.suivant.setBounds(400, 140, 100, 60);
		
		this.precedent = new JButton("Précédent");
		this.precedent.setBounds(200, 140, 100, 60);
		
		this.panelNbJoueurs = new JPanel();
		this.panelNbJoueurs.setLayout(new GridLayout(1,3));
		this.panelNbJoueurs.setBounds(200,60,400,50);
		
		this.deuxPlayer = new JRadioButton("Deux");
		this.troisPlayer = new JRadioButton("Trois");
		this.quatrePlayer = new JRadioButton("Quatre");
		
		this.panelNbJoueurs.add(this.deuxPlayer);
		this.panelNbJoueurs.add(this.troisPlayer);
		this.panelNbJoueurs.add(this.quatrePlayer);
		
		this.bg = new ButtonGroup();
		this.bg.add(this.deuxPlayer);
		this.bg.add(this.troisPlayer);
		this.bg.add(this.quatrePlayer);		
		
		this.panelPage2.add(this.nbJoueurs);
		this.panelPage2.add(this.suivant);
		this.panelPage2.add(this.precedent);
		this.panelPage2.add(this.panelNbJoueurs);
		
		this.panelBoutons.add(this.panelPage2);
		
		
		// Panel pion
		this.panelPions = new JPanel();
		this.panelBoutons.add(this.panelPions);
		this.lesPions = new JLabel[8];
		this.choixPion = new JRadioButton[8];
		this.panelPions.setLayout(new GridLayout(2, 8));
		this.panelPions.setBounds(0,350,700,200);
		
		for(int i=0 ; i<8 ; i++) {
			
			this.lesPions[i] = new JLabel(this.imagePion[i]);
			this.panelPions.add(this.lesPions[i]);
			this.choixPion[i] = new JRadioButton();
			this.panelPions.add(this.choixPion[i]);
			
		}
		

		this.jouer = new JButton("Jouer");
		this.jouer.setBounds(400, 550, 100, 60);
		
		this.precedent2 = new JButton("Précédent");
		this.precedent2.setBounds(200, 550, 100, 60);
		
		this.panelBoutons.add(this.jouer);
		this.panelBoutons.add(this.precedent2);
		
		
		jouer.addActionListener(this);
		suivant.addActionListener(this);
		precedent.addActionListener(this);
		precedent2.addActionListener(this);
		quitter.addActionListener(this); 
		deuxPlayer.addActionListener(this);
		troisPlayer.addActionListener(this);
		quatrePlayer.addActionListener(this);
		start.addActionListener(this);
		quitter.addActionListener(this); 
		regles.addActionListener(this); 
		aPropos.addActionListener(this);
		suivant.addActionListener(this);
		
		
		jouer.setVisible(false);
		precedent2.setVisible(false);
		panelPions.setVisible(false);
	}
	
	
	public static void main(String[] args) {
		IHMMenu menu =  new IHMMenu();  
		menu.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() ==quitter) {
			System.exit(0);
		}
		
		if (e.getSource() ==aPropos) {
			JOptionPane.showMessageDialog(this, "Ce jeu a été réalisé par\n\nCyril CARON,\nLéo LETOURNEUR\net Alexandre SIMONIN\n\nNous sommes de jeunes développeurs et nous avons "
					+ "voulu mettre en pratique nos connaissances en Java en créant ce jeu !\n\nAmusez vous bien !");
		}
		
		if (e.getSource() ==regles) {
			JOptionPane.showMessageDialog(this, "La rÃ¨gle du Monopoly\n\n"
											  + "Le jeu en bref\n\n"
											  + "PAS ENCORE DISPONIBLE !!!!!!!!!\n\n"
											  + "J'ESPERE QUE TU SAIS JOUER ..........!!!!!!");
		}
		
		if (e.getSource() == start){	
			panelPage1.setVisible(false);
			panelPage2.setVisible(true);
			
			
		}
		
		if (e.getSource() ==precedent) {
			
			panelPage1.setVisible(true);
			panelPage2.setVisible(false);
		}
		
		if (e.getSource() ==precedent2) {
			
			panelPage2.setVisible(true);
			jouer.setVisible(false);
			precedent2.setVisible(false);
			panelPions.setVisible(false);
			
		}
		
		if (e.getSource() ==suivant) {
			
			panelPage2.setVisible(false);
			jouer.setVisible(true);
			precedent2.setVisible(true);
			panelPions.setVisible(true);
			
		}
		
		if (e.getSource() ==jouer) {
			this.dispose();
			IHMMonopoly m =  new IHMMonopoly();  
			m.setVisible(true);
		}
	}

}
