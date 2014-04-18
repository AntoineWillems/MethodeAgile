package domaineConduite;

import java.util.Observable;

public class Voiture extends Observable {

	private int coordXEnMetres;
	private int vitesseMetreParSecondes;
	private int angleDirectionVoiture;
	private int coordYEnMetres;

	public static final int largeurDomaine = 1000;

	public Voiture(int coordXEnMetres) {
		this.coordXEnMetres = coordXEnMetres;
		this.vitesseMetreParSecondes = 0;
	}

	public Voiture(int coordXEnMetres, int vitesseMetreParSecondes) {
		this.coordXEnMetres = coordXEnMetres;
		this.vitesseMetreParSecondes = vitesseMetreParSecondes;
	}
	
	public Voiture(int coordXEnMetres, int angleDirectionVoiture, int vitesseMetreParSecondes) {
		this.coordXEnMetres = coordXEnMetres;
		coordYEnMetres=coordXEnMetres;
		this.angleDirectionVoiture = angleDirectionVoiture;
		this.vitesseMetreParSecondes = vitesseMetreParSecondes;
	}

	public int getCoordXEnMetres() {
		return coordXEnMetres;
	}
	
	public int getCoordYEnMetres(){
		return coordYEnMetres;
	}

	public int getVitesseMetreParSecondes() {
		return vitesseMetreParSecondes;
	}

	public void avancerEnFonctionDeLaVitesse() {
		coordXEnMetres += vitesseMetreParSecondes;
		notificationObservateurs();
	}

	private void notificationObservateurs() {
		this.setChanged();
		this.notifyObservers();
	}

	public void avanceEnFonctionDeLaVitesseAngle() {
		coordXEnMetres += vitesseMetreParSecondes;
		coordYEnMetres = (int) (coordXEnMetres/Math.cos(angleDirectionVoiture));
		notificationObservateurs();
		
	}
}
