package vueController;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Regles extends JDialog{

	private JEditorPane regles;
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
		this.regles = new JEditorPane();
		this.scroll =new JScrollPane(regles);
		
		this.regles.setBounds(5,5,390,600);
//		this.regles.setLineWrap(true);
//		this.regles.setWrapStyleWord(true);
		this.regles.setOpaque(false);
		this.regles.setEditable(false);

		

		this.panelRegles.setLayout(new BorderLayout());
		
		this.panelRegles.add(this.scroll);
		contenu.add(this.panelRegles);
		
		String chaine="";
		String fichier ="regles.txt";
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				chaine+=ligne+"\n";
				
			}
			this.regles.setText(chaine);
			this.regles.setCaretPosition(0);
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
		


}
