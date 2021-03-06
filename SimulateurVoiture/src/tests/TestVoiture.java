package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domaineConduite.Voiture;



public class TestVoiture {
	
	@Test
	public void testGetX(){
		Voiture voiture = new Voiture(20) ;
		
		int xVoiture = voiture.getCoordXEnMetres() ;
		
		assertEquals(20, xVoiture);
		
	}
	
	@Test
	public void testVitesseX() {
		Voiture voiture = new Voiture(20,150);
		
		assertEquals(150,voiture.getVitesseMetreParSecondes());
	}
	
	
	@Test
	public void testMiseAjourPositionEnFonctionVitesse() {
		Voiture voiture = new Voiture(20,100);
		voiture.avancerEnFonctionDeLaVitesse();
		assertEquals(120, voiture.getCoordXEnMetres());
	}
	
	@Test
	public void testMiseAjourPositionEnFonctionVitesseAngle(){
		Voiture voiture = new Voiture(20,45, 100);
		voiture.avanceEnFonctionDeLaVitesseAngle();
		assertEquals((int) (120/Math.cos(45)),voiture.getCoordYEnMetres());
	}
	
}
