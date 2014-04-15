package applicationSimulateur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JFrame;

public class DessinVoiture extends JFrame {

	public static final int TailleFenetreEnPixels = 500;
	
	private int xPixelVoiture;

	public DessinVoiture() {
		super();
		this.setTitle("Simulateur de Voiture");
		this.setSize(TailleFenetreEnPixels, TailleFenetreEnPixels);
		this.setVisible(true);
		this.xPixelVoiture = 0;
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		dessinerVoiture(this.xPixelVoiture, graphics);

	}

	public void dessinerVoiture(int xPixelVoiture, Graphics graphics) {
		int nombreCoteTriangle = 3;
	
		int[] listePointsx={xPixelVoiture-10, xPixelVoiture-10, xPixelVoiture+10};
		int[] listePointsy={200, 220, 210};
		
		Polygon dessinTriangleVoiture = new Polygon(listePointsx,listePointsy, nombreCoteTriangle);
		
		graphics.setColor(Color.BLACK);
		graphics.fillPolygon(dessinTriangleVoiture);
		
	}

	public void setXPixelVoiture(int xPixelVoiture) {
		this.xPixelVoiture = xPixelVoiture;
	}
	
	

}
