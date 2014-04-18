package applicationSimulateur;

import domaineConduite.Voiture;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

public class VoitureView extends JFrame implements Observer {

    //Subviews
    private JFrame container;
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
        //this.setContentPane(container);
        this.setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Initialisation des subviews">                          
    private void initComponents() {
        this.container = new JFrame();
        this.VoitureRepresentation = new DessinVoiture();
        this.add(this.VoitureRepresentation);
        
        //Key listening
        this.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
            }

            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
            }

            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode())
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
        
    }// </editor-fold> 
    
    /*public VoitureView(Voiture voiture) {
        this.voiture = voiture;
        this.voiture.addObserver(this);
    }*/

    /*public VoitureView(Voiture voiture, DessinVoiture ihm) {
        this.voiture = voiture;
        this.voiture.addObserver(this);
        this.ihm = ihm;
    }*/

    public int transformerMetrePixel(int coordonneeXEnMetre) {

        int ratioDomaineFenetre = Voiture.largeurDomaine/TailleFenetreEnPixels;
        int coordonneeXEnPixels = coordonneeXEnMetre/ratioDomaineFenetre;
        return coordonneeXEnPixels;
    }

    public void update(Observable sujetObservation, Object arg1) {
        Voiture v = (Voiture) sujetObservation;
        
        int xVoiture = v.getCoordXEnMetres();
        //int yVoiture = v.getCoordYEnMetres();
        int xPixelVoiture = this.transformerMetrePixel(xVoiture);
        //int yPixelVoiture = this.transformerMetrePixel(yVoiture);
        
        this.VoitureRepresentation.setXPixelVoiture(xPixelVoiture);
        //ihm.setYPixelVoiture(yPixelVoiture);
        this.VoitureRepresentation.repaint();
    }
}
