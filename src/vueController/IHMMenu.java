package vueController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IHMMenu extends JFrame implements ActionListener {

	private JPanel panelBoutons;
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
	private JLabel[] lesPions;
	private JRadioButton deuxPlayer;
	private JRadioButton troisPlayer;
	private JRadioButton quatrePlayer;
	private JRadioButton unPlayer;
	private JRadioButton[] choixPion;
	private ButtonGroup bg;

	private ImageIcon bateau;
	private ImageIcon brouette;
	private ImageIcon chapeau;
	private ImageIcon chaussure;
	private ImageIcon chien;
	private ImageIcon coudre;
	private ImageIcon repasser;
	private ImageIcon voiture;

	public IHMMenu() {

		super("Monopoly");
		this.chargerImage();
		this.creePanels();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 750);
		this.setLocationRelativeTo(null);

		this.setResizable(false);
	}

	private void chargerImage() {
		this.imageMenu = new ImageIcon(
				ClassLoader.getSystemResource("monopoly.jpg"));
		this.bateau = new ImageIcon(
				ClassLoader.getSystemResource("pions/bateau.png"));
		this.brouette = new ImageIcon(
				ClassLoader.getSystemResource("pions/brouette.png"));
		this.chapeau = new ImageIcon(
				ClassLoader.getSystemResource("pions/chapeau.png"));
		this.chaussure = new ImageIcon(
				ClassLoader.getSystemResource("pions/chaussure.png"));
		this.chien = new ImageIcon(
				ClassLoader.getSystemResource("pions/chien.png"));
		this.coudre = new ImageIcon(
				ClassLoader.getSystemResource("pions/coudre.png"));
		this.repasser = new ImageIcon(
				ClassLoader.getSystemResource("pions/repasser.png"));
		this.voiture = new ImageIcon(
				ClassLoader.getSystemResource("pions/voiture.png"));
	}

	private void creePanels() {

		this.creePanelBoutons();

		Container contenu = this.getContentPane();
		contenu.setLayout(null);
		contenu.add(panelBoutons);

	}

	public void creePanelBoutons() {
		this.lesPions = new JLabel[8];
		this.choixPion = new JRadioButton[8];

		this.lesPions[0] = new JLabel(this.bateau);
		this.lesPions[0].setBounds(50, 350, 100, 60);
		this.lesPions[1] = new JLabel(this.brouette);
		this.lesPions[1].setBounds(200, 350, 100, 60);
		this.lesPions[2] = new JLabel(this.chapeau);
		this.lesPions[2].setBounds(350, 350, 100, 60);
		this.lesPions[3] = new JLabel(this.chaussure);
		this.lesPions[3].setBounds(500, 350, 100, 60);
		this.lesPions[4] = new JLabel(this.chien);
		this.lesPions[4].setBounds(50, 450, 100, 60);
		this.lesPions[5] = new JLabel(this.coudre);
		this.lesPions[5].setBounds(200, 450, 100, 60);
		this.lesPions[6] = new JLabel(this.repasser);
		this.lesPions[6].setBounds(350, 450, 100, 60);
		this.lesPions[7] = new JLabel(this.voiture);
		this.lesPions[7].setBounds(500, 450, 100, 60);

		for (int i = 0; i < 8; i++) {

		}

		this.panelBoutons = new JPanel();
		this.panelBoutons.setLayout(null);
		this.panelBoutons.setBounds(50, 50, 700, 650);

		this.nbJoueurs = new JLabel("Choisissez le nombre de joueurs");
		this.nbJoueurs.setBounds(250, 450, 250, 60);

		this.deuxPlayer = new JRadioButton("Deux");
		this.deuxPlayer.setBounds(200, 500, 100, 40);
		this.troisPlayer = new JRadioButton("Trois");
		this.troisPlayer.setBounds(300, 500, 100, 40);
		this.quatrePlayer = new JRadioButton("Quatre");
		this.quatrePlayer.setBounds(400, 500, 100, 40);
		this.image = new JLabel(this.imageMenu);
		this.image.setBounds(0, 0, 700, 341);
		this.jouer = new JButton("Jouer");
		this.jouer.setBounds(400, 550, 100, 60);
		this.suivant = new JButton("Suivant");
		this.suivant.setBounds(400, 550, 100, 60);
		this.precedent = new JButton("Précédent");
		this.precedent.setBounds(200, 550, 100, 60);
		this.precedent2 = new JButton("Précédent");
		this.precedent2.setBounds(200, 550, 100, 60);
		this.bg = new ButtonGroup();
		this.start = new JButton("Nouvelle partie");
		this.start.setBounds(100, 450, 200, 60);
		this.quitter = new JButton("Quitter");
		this.quitter.setBounds(400, 450, 200, 60);
		this.regles = new JButton("Règles");
		this.regles.setBounds(100, 550, 200, 60);
		this.aPropos = new JButton("A propos");
		this.aPropos.setBounds(400, 550, 200, 60);
		this.image = new JLabel(this.imageMenu);
		this.image.setBounds(0, 0, 700, 341);

		this.bg.add(this.deuxPlayer);
		this.bg.add(this.troisPlayer);
		this.bg.add(this.quatrePlayer);
		this.panelBoutons.add(this.jouer);
		this.panelBoutons.add(this.suivant);
		this.panelBoutons.add(this.precedent);
		this.panelBoutons.add(this.precedent2);
		this.panelBoutons.add(this.quitter);
		this.panelBoutons.add(this.image);
		this.panelBoutons.add(this.regles);
		this.panelBoutons.add(this.aPropos);
		this.panelBoutons.add(this.nbJoueurs);
		this.panelBoutons.add(this.deuxPlayer);
		this.panelBoutons.add(this.troisPlayer);
		this.panelBoutons.add(this.quatrePlayer);
		this.panelBoutons.add(this.start);
		this.panelBoutons.add(this.quitter);
		this.panelBoutons.add(this.image);
		this.panelBoutons.add(this.regles);
		this.panelBoutons.add(this.aPropos);
		this.panelBoutons.add(this.lesPions[0]);
		this.panelBoutons.add(this.lesPions[1]);
		this.panelBoutons.add(this.lesPions[2]);
		this.panelBoutons.add(this.lesPions[3]);
		this.panelBoutons.add(this.lesPions[4]);
		this.panelBoutons.add(this.lesPions[5]);
		this.panelBoutons.add(this.lesPions[6]);
		this.panelBoutons.add(this.lesPions[7]);

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

		suivant.setVisible(false);
		jouer.setVisible(false);
		precedent.setVisible(false);
		precedent2.setVisible(false);
		deuxPlayer.setVisible(false);
		troisPlayer.setVisible(false);
		quatrePlayer.setVisible(false);
		nbJoueurs.setVisible(false);
		lesPions[0].setVisible(false);
		lesPions[1].setVisible(false);
		lesPions[2].setVisible(false);
		lesPions[3].setVisible(false);
		lesPions[4].setVisible(false);
		lesPions[5].setVisible(false);
		lesPions[6].setVisible(false);
		lesPions[7].setVisible(false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IHMMenu menu = new IHMMenu();
		menu.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == quitter) {
			System.exit(0);
		}

		if (e.getSource() == aPropos) {
			JOptionPane
					.showMessageDialog(
							this,
							"Ce jeu à été réalisé par\n\nCyril CARON,\nLéo LETOURNEUR\net Alexandre SIMONIN\n\nNous sommes de jeunes développeurs et nous avons "
									+ "voulus mettre en pratique nos connaissances en Java en créant ce jeu !\n\nAmusez vous bien !");
		}

		if (e.getSource() == regles) {
			Regles r = new Regles();
			r.setVisible(true);
			r.setModal(true);
		}

		if (e.getSource() == start) {
			start.setVisible(false);
			quitter.setVisible(false);
			regles.setVisible(false);
			aPropos.setVisible(false);
			jouer.setVisible(false);
			lesPions[0].setVisible(false);
			lesPions[1].setVisible(false);
			lesPions[2].setVisible(false);
			lesPions[3].setVisible(false);
			lesPions[4].setVisible(false);
			lesPions[5].setVisible(false);
			lesPions[6].setVisible(false);
			lesPions[7].setVisible(false);

			suivant.setVisible(true);
			precedent.setVisible(true);
			deuxPlayer.setVisible(true);
			troisPlayer.setVisible(true);
			quatrePlayer.setVisible(true);
			nbJoueurs.setVisible(true);
		}

		if (e.getSource() == precedent) {
			jouer.setVisible(false);
			precedent.setVisible(false);
			deuxPlayer.setVisible(false);
			troisPlayer.setVisible(false);
			quatrePlayer.setVisible(false);
			nbJoueurs.setVisible(false);
			suivant.setVisible(false);
			precedent2.setVisible(false);
			lesPions[0].setVisible(false);
			lesPions[1].setVisible(false);
			lesPions[2].setVisible(false);
			lesPions[3].setVisible(false);
			lesPions[4].setVisible(false);
			lesPions[5].setVisible(false);
			lesPions[6].setVisible(false);
			lesPions[7].setVisible(false);

			start.setVisible(true);
			quitter.setVisible(true);
			regles.setVisible(true);
			aPropos.setVisible(true);

		}

		if (e.getSource() == precedent2) {
			jouer.setVisible(false);
			precedent.setVisible(false);
			lesPions[0].setVisible(false);
			lesPions[1].setVisible(false);
			lesPions[2].setVisible(false);
			lesPions[3].setVisible(false);
			lesPions[4].setVisible(false);
			lesPions[5].setVisible(false);
			lesPions[6].setVisible(false);
			lesPions[7].setVisible(false);

			jouer.setVisible(true);
			precedent.setVisible(true);
			deuxPlayer.setVisible(true);
			troisPlayer.setVisible(true);
			quatrePlayer.setVisible(true);
			nbJoueurs.setVisible(true);
			suivant.setVisible(true);

		}

		if (e.getSource() == suivant) {
			start.setVisible(false);
			quitter.setVisible(false);
			regles.setVisible(false);
			aPropos.setVisible(false);
			deuxPlayer.setVisible(false);
			troisPlayer.setVisible(false);
			quatrePlayer.setVisible(false);
			nbJoueurs.setVisible(false);
			precedent.setVisible(false);

			jouer.setVisible(true);
			precedent2.setVisible(true);
			lesPions[0].setVisible(true);
			lesPions[1].setVisible(true);
			lesPions[2].setVisible(true);
			lesPions[3].setVisible(true);
			lesPions[4].setVisible(true);
			lesPions[5].setVisible(true);
			lesPions[6].setVisible(true);
			lesPions[7].setVisible(true);

		}

		if (e.getSource() == jouer) {
			this.dispose();
			IHMMonopoly m = new IHMMonopoly();
			m.setVisible(true);
		}
	}

}
