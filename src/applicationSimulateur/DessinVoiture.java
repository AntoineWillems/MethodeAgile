package applicationSimulateur;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

public class DessinVoiture extends JPanel {

    private int xPixelVoiture;

    public DessinVoiture() {
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        dessinerVoiture(this.xPixelVoiture, g);
    }

    public void dessinerVoiture(int xPixelVoiture, Graphics graphics) {
        System.out.println("LOL");
        int nombreCoteTriangle = 3;

        int[] listePointsx= {xPixelVoiture-10, xPixelVoiture-10, xPixelVoiture+10};
        int[] listePointsy= {200, 220, 210};

        Polygon dessinTriangleVoiture = new Polygon(listePointsx,listePointsy, nombreCoteTriangle);

        graphics.setColor(Color.BLACK);
        graphics.fillPolygon(dessinTriangleVoiture);
    }

    public void setXPixelVoiture(int xPixelVoiture) {
        this.xPixelVoiture = xPixelVoiture;
    }
}
