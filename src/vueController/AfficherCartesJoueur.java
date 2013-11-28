package vueController;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vueController.cases.CaseBas;
import model.Joueur;

public class AfficherCartesJoueur extends JDialog {

	private Joueur joueur;
	private CaseBas[] c;
	private JPanel panel;
	private JLabel labelPasDeCartes;

	public AfficherCartesJoueur(Joueur j) {

		super();
		this.setJoueur(j);
		this.setTitle("Propriétés de " + joueur.getPseudo());
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(300, 500);
		this.setResizable(false);

		this.creerFenetre();

	}

	public void creerFenetre() {

		Container contenu = this.getContentPane();
		this.setLayout(null);
		panel = new JPanel();
		labelPasDeCartes = new JLabel(joueur.getPseudo()
				+ " ne possède pas encore de propriétés !");
		labelPasDeCartes.setBounds(30, 50, 200, 30);
		panel.setBounds(5, 5, 280, 400);
		panel.setLayout(new GridLayout(3, 3, 20, 20));
		c = new CaseBas[39];

		contenu.add(panel);

		if (joueur.getCartes().isEmpty() == false)
			this.displayCartes();
		else
			panel.add(labelPasDeCartes);

	}

	public void displayCartes() {

		Set<Integer> listKeys = this.joueur.getCartes().keySet();

		Iterator<Integer> i = listKeys.iterator();
		while (i.hasNext()) {

			Object key = i.next();
			c[(Integer) key] = new CaseBas((Integer) key);
			panel.add(c[(Integer) key]);

		}

	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

}
