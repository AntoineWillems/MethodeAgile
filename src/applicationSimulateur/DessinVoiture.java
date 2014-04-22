package applicationSimulateur;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import javax.swing.JPanel;

public class DessinVoiture extends JPanel {

    private int xPixelVoiture;
    private static int INITIAL_XP1 = 10;
    private static int INITIAL_XP3 = 30;

    public DessinVoiture() {
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        dessinerVoiture(this.xPixelVoiture, g);
    }

    public void dessinerVoiture(int xPixelVoiture, Graphics graphics) {
        int nombreCoteTriangle = 3;

        int[] listePointsx= {xPixelVoiture+INITIAL_XP1, xPixelVoiture+INITIAL_XP1, xPixelVoiture+INITIAL_XP3};
        int[] listePointsy= {200, 220, 210};

        Polygon dessinTriangleVoiture = new Polygon(listePointsx,listePointsy, nombreCoteTriangle);

        graphics.setColor(Color.BLACK);
        graphics.fillPolygon(dessinTriangleVoiture);
    }

    public void setXPixelVoiture(int xPixelVoiture) {
        this.xPixelVoiture = xPixelVoiture;
    }
    
    public int getXPixelVoiture() {
        return this.xPixelVoiture;
    }
    
    public void updateLocation(int px) {
        Point locationX = this.getLocation();
        locationX.x += px;
        this.setLocation(locationX);
    }
}
