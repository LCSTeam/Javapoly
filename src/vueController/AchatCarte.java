package vueController;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Case;

@SuppressWarnings("serial")
public class AchatCarte extends JDialog implements ActionListener {

	private JLabel labelConfirmAchat;
	private JLabel labelMiniaturePropriete;
	private JButton boutonOui;
	private JButton boutonNon;
	private JPanel panelBoutons;
		
	private Case caseChoisie;

	public AchatCarte(JFrame parent, Case laCase) {
		super();
		this.setTitle("Achat de propriété");
		this.caseChoisie = laCase;
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.creer();
	}
	
	
	public void creer() {

		Container contenu = this.getContentPane();
		contenu.setLayout(null);

		this.labelConfirmAchat = new JLabel(
				"Voulez-vous acheter cette propriété :");
		this.labelConfirmAchat.setBackground(Color.white);
		this.labelMiniaturePropriete = new JLabel();
		this.labelMiniaturePropriete.setBackground(Color.red);
		this.labelMiniaturePropriete.setIcon(new ImageIcon(ClassLoader.getSystemResource("Blabla.jpg")));

		this.boutonOui = new JButton("Oui");
		this.boutonNon = new JButton("Non");

		this.panelBoutons = new JPanel();
		this.panelBoutons.setLayout(new GridLayout(1, 2, 50, 50));
		this.panelBoutons.setBounds(50, 420, 300, 30);
		this.panelBoutons.add(this.boutonOui);
		this.panelBoutons.add(this.boutonNon);
	
		this.labelConfirmAchat.setBounds(40, 20, 300, 20);
		this.labelMiniaturePropriete.setBounds(40,50,300,400);
		contenu.add(this.labelConfirmAchat);	
		contenu.add(this.labelMiniaturePropriete);
		contenu.add(this.panelBoutons);
		
		this.boutonOui.addActionListener(this);
		this.boutonNon.addActionListener(this);

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
