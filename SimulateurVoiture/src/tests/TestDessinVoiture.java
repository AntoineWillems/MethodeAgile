package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import applicationSimulateur.DessinVoiture;

public class TestDessinVoiture {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testDessinerVoiture() {
		DessinVoiture monDessin = new DessinVoiture();
		monDessin.dessinerVoiture(0, monDessin.getGraphics());
	}
	
	@Test
	public void testDessinerTriangle() {
		DessinVoiture monDessin = new DessinVoiture();
	}

}
