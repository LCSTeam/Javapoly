package model;



public class Joueur
{
	private String pseudo;
	private int bourse;
	private int pion;
	private Case [] cartes;
	
	
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
	public Case [] getCartes() {
		return cartes;
	}
	public void setCartes(Case [] cartes) {
		this.cartes = cartes;
	}
	
}
