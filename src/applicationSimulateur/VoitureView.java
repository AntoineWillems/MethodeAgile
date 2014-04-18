package applicationSimulateur;

import domaineConduite.Voiture;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class VoitureView extends JFrame implements Observer {

    //Subviews
    private DessinVoiture VoitureRepresentation;
    public static final int TailleFenetreEnPixels = 500;
    
    //Controller
    private SimulateurVoitureController controller;

    public VoitureView(SimulateurVoitureController controller) {
        this.setSize(TailleFenetreEnPixels, TailleFenetreEnPixels);
        this.setTitle("Simulateur de Voiture");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        initComponents();
        
        this.controller = controller;
        this.setVisible(true);
    }

    //DEFAULT CONSTRUCTOR
    public VoitureView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // <editor-fold defaultstate="collapsed" desc="Initialisation des subviews">                          
    private void initComponents() {
        this.VoitureRepresentation = new DessinVoiture();
        this.add(this.VoitureRepresentation);
        
        //Key listening
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
                switch(e.getKeyCode())
                {
                    case KeyEvent.VK_RIGHT:
                            System.out.print("right");
                            controller.incrementVitesse();
                            break;
                    case KeyEvent.VK_LEFT:
                            System.out.print("left");
                            controller.decrementVitesse();
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
        
    }// </editor-fold> 

    public int transformerMetrePixel(int coordonneeXEnMetre) {

        int ratioDomaineFenetre = Voiture.largeurDomaine/TailleFenetreEnPixels;
        int coordonneeXEnPixels = coordonneeXEnMetre/ratioDomaineFenetre;
        return coordonneeXEnPixels;
    }

    @Override
    public void update(Observable sujetObservation, Object arg1) {
        Voiture v = (Voiture) sujetObservation;
        
        int xVoiture = v.getCoordXEnMetres();
        int xPixelVoiture = this.transformerMetrePixel(xVoiture);
        
        this.VoitureRepresentation.setXPixelVoiture(xPixelVoiture);
        this.VoitureRepresentation.repaint();
    }
}
