package applicationSimulateur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class DessinVoiture extends JFrame {

	public static final int TailleFenetreEnPixels = 500;
	
	private int xPixelVoiture;
	private int yPixelVoiture;

	public DessinVoiture() {
		super();
		this.setTitle("Simulateur de Voiture");
		this.setSize(TailleFenetreEnPixels, TailleFenetreEnPixels);
		this.setVisible(true);
		this.xPixelVoiture = 0;
		this.yPixelVoiture = 0;
		
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode())
				{
					case KeyEvent.VK_RIGHT:
						System.out.print("right");
						break;
					case KeyEvent.VK_LEFT:
						System.out.print("left");
						break;
					case KeyEvent.VK_DOWN:
						System.out.print("down");
						break;
					case KeyEvent.VK_UP:
						System.out.print("up");
						break;
				}
				
			}
		});
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		dessinerVoiture(this.xPixelVoiture, this.yPixelVoiture, graphics);
		
	}

	public void dessinerVoiture(int xPixelVoiture, int yPixelVoiture, Graphics graphics) {
		int nombreCoteTriangle = 3;
	
		int[] listePointsx={xPixelVoiture-10, xPixelVoiture-10, xPixelVoiture+10};
		int[] listePointsy={yPixelVoiture-10, yPixelVoiture+10, yPixelVoiture};
		
		Polygon dessinTriangleVoiture = new Polygon(listePointsx,listePointsy, nombreCoteTriangle);
		
		graphics.setColor(Color.BLACK);
		graphics.fillPolygon(dessinTriangleVoiture);
		
	}

	public void setXPixelVoiture(int xPixelVoiture) {
		this.xPixelVoiture = xPixelVoiture;
	}
	
	public void setYPixelVoiture(int yPixelVoiture) {
		this.yPixelVoiture = yPixelVoiture;
	}
	
	

}
