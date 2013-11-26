package vueController;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import vueController.carteVerticale.CartePropriete;
import model.Case;

@SuppressWarnings("serial")
public class AchatCartePropriete extends CartePropriete implements ActionListener {

	private JLabel labelConfirmAchat;
	private JButton boutonOui;
	private JButton boutonNon;
	private JPanel panelBoutons;
	private Case laCase;

	public AchatCartePropriete(JFrame parent, Case laCase) {
		super(parent, laCase);
		this.setTitle("Achat de propriété");
		this.setSize(400,500);
		this.carte.setLocation(60,40);
		this.setLaCase(laCase);
		this.creer();
	}
	
	
	public void creer() {

		Container contenu = this.getContentPane();
		contenu.setLayout(null);
		
		this.labelConfirmAchat = new JLabel(
				"Voulez-vous acheter cette propriété pour "+this.laCase.getPrix()+" € ?");
				
		this.boutonOui = new JButton("Oui");
		this.boutonNon = new JButton("Non");

		this.panelBoutons = new JPanel();
		this.panelBoutons.setLayout(new GridLayout(1, 2, 50, 50));
		this.panelBoutons.setBounds(50, 420, 300, 30);
		this.panelBoutons.add(this.boutonOui);
		this.panelBoutons.add(this.boutonNon);
	
		this.labelConfirmAchat.setBounds(50, 15, 300, 20);
		contenu.add(this.labelConfirmAchat);	
		contenu.add(this.panelBoutons);
		
		this.boutonOui.addActionListener(this);
		this.boutonNon.addActionListener(this);

	}

	public Case getLaCase() {
		return laCase;
	}


	public void setLaCase(Case laCase) {
		this.laCase = laCase;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.boutonOui){
			JOptionPane.showMessageDialog(null, "Félicitations ! cette propriété est désormais la vôtre !");
			this.dispose();
		}
		if(e.getSource()==this.boutonNon){
			this.dispose();
		}

	}
	
	
}
