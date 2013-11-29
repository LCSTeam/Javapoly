package vueController;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Regles extends JDialog{

	private JLabel regles;
	private JScrollPane scroll;
	private JPanel panelRegles;
	
	public Regles() {
		
		super();
		this.setTitle("Règles du jeu");
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.creerRegles();
		this.setModal(true);
	
	}
	
	public void creerRegles(){
		
		Container contenu = this.getContentPane();
		
		this.panelRegles =new JPanel();
		this.regles = new JLabel();
		this.scroll =new JScrollPane(regles);
		
		this.regles.setBounds(5,5,390,600);
		this.regles.setOpaque(false);
		

		this.panelRegles.setLayout(new BorderLayout());
		
		this.panelRegles.add(this.scroll);
		contenu.add(this.panelRegles);
		
		String chaine="";
		String fichier ="regles.txt";

		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				chaine+=ligne+"\n";
				
			}
			this.regles.setText(chaine);
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
		
	public static void main(String[] args) {
		Regles m = new Regles();
		m.setVisible(true);
	
	}


}
