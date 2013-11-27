package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Joueur
{
	private String pseudo;
	private int bourse = 20000;
	private int pion;
	
	private Map<Integer, Case> cartes ;
	
	public Joueur()
	{
		this.cartes = new HashMap<Integer, Case>();

	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public int getBourse() {
		return bourse;
	}
	public void setBourse(int bourse) {
		this.bourse = bourse;
	}
	public int getPion() {
		return pion;
	}
	public void setPion(int pion) {
		this.pion = pion;
	}
	
	
	public Map<Integer, Case> getCartes() {
		return cartes;
	}
	
	public void setCartes(Map<Integer, Case> cartes) {
		this.cartes = cartes;
	}
	
	public void afficherCartes(){
	
		Iterator<Integer> it = cartes.keySet().iterator();
		while (it.hasNext()){
			Integer cle = (Integer)it.next();
		   	Case valeur = (Case)cartes.get(cle);
		System.out.println( cle.toString() + " "+valeur.toString() + "");
		
		}
		
	}
	
	
}
