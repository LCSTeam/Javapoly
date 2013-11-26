package vueController.carteHorizontale;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class CarteHorizontale extends JDialog implements ActionListener {

	private JTextArea intitule;
	private JButton ok;
	private JPanel panelCouleur;
	private JPanel imageCase;
	private JLabel labelTitre;
	private int etat;
	private JPanel carte;

	public CarteHorizontale() {

		super();

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setEtat(etat);
		this.dessineCaseBonus();
	}

	public void dessineCaseBonus() {

		this.panelCouleur = new JPanel();
		this.intitule = new JTextArea();
		this.ok = new JButton("OK");
		this.imageCase = new JPanel();
		this.labelTitre = new JLabel();

		this.labelTitre.setFont(new Font("Arial", Font.BOLD, 14));

		Container contenu = this.getContentPane();
		contenu.setLayout(null);

		this.ok.setBounds(150, 180, 60, 30);
		this.panelCouleur.setBounds(1, 1, 358, 100);
		this.intitule.setBounds(20, 130, 340, 40);
		this.intitule.setLineWrap(true);
		this.intitule.setWrapStyleWord(true);
		this.intitule.setOpaque(false);
		this.intitule.setEditable(false);
		this.labelTitre.setLayout(null);
		this.labelTitre.setBounds(0,40,358,30);
		this.labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelTitre.setFont(new Font("Arial", Font.BOLD, 30));

		TitledBorder contour = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
				"CARON SIMONIN LETOURNEUR ©", TitledBorder.CENTER, TitledBorder.BOTTOM);

		this.carte = new JPanel();
		this.carte.setBounds(10, 10, 360, 240);

		this.carte.setLayout(null);
		this.panelCouleur.setLayout(null);
		this.panelCouleur.add(this.labelTitre);
		this.carte.add(this.panelCouleur);
		this.carte.add(this.ok);
		this.carte.add(this.intitule);
		

		this.carte.setBorder(contour);

		contenu.add(this.carte);

		this.ok.addActionListener(this);

	}

	public JLabel getLabelTitre() {
		return labelTitre;
	}

	public void setLabelTitre(JLabel labelTitre) {
		this.labelTitre = labelTitre;
	}

	public JLabel getTitre() {
		return labelTitre;
	}

	public void setTitre(JLabel titre) {
		this.labelTitre = titre;
	}

	public JTextArea getIntitule() {
		return this.intitule;
	}

	public void setIntitule(JTextArea intitule) {
		this.intitule = intitule;
	}

	public JButton getOk() {
		return this.ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

	public JPanel getPanelCouleur() {
		return this.panelCouleur;
	}

	public void setPanelCouleur(JPanel panelCouleur) {
		this.panelCouleur = panelCouleur;
	}

	public JPanel getImageCase() {
		return this.imageCase;
	}

	public void setImageCase(JPanel imageCase) {
		this.imageCase = imageCase;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.ok) {

			this.dispose();
		}
	}

}
