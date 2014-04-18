package applicationSimulateur;

import domaineConduite.Voiture;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class SimulateurVoitureController {
    public static final int dureeUneSecondeEnMilliSecondes = 1000;
    private Voiture model;
    
    public SimulateurVoitureController(Voiture dataModel) {
        this.model = dataModel;
        
        Timer updateView = new Timer(60, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.avancerEnFonctionDeLaVitesse();
            }
        });
        
        updateView.start();
    }
    
    public void incrementVitesse(){
        this.model.incrementVitesse();
    }
    
    public void decrementVitesse(){
        this.model.decrementVitesse();
    }
    
    public static void main(String args[]){
        //Création du modèle
        Voiture model = new Voiture(0, 0);
        //Création du controller
        SimulateurVoitureController controller = new SimulateurVoitureController(model);
        //Création de la vue
        VoitureView view = new VoitureView(controller);
        model.addObserver(view);
    }
}
