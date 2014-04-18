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
        
        Timer updateView = new Timer(dureeUneSecondeEnMilliSecondes, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.avancerEnFonctionDeLaVitesse();
            }
        });
        
        //updateView.start();
    }
    
    public static void main(String args[]){
        //Création du modèle
        Voiture model = new Voiture(100, 50);
        //Création du controller
        SimulateurVoitureController controller = new SimulateurVoitureController(model);
        //Création de la vue
        VoitureView view = new VoitureView(controller);
        model.addObserver(view);
    }
}


/*public static final int dureeUneSecondeEnMilliSecondes = 1000;

public static void main(String[] args) {

        DessinVoiture dessinVoiture = new DessinVoiture();
        final Voiture voiture = new Voiture(100,50);
        final VueVoiture triangle = new VueVoiture(voiture, dessinVoiture);

        Timer timerAvancer = new Timer(dureeUneSecondeEnMilliSecondes, new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent arg0) {
                        voiture.avancerEnFonctionDeLaVitesse();

                }
        });

        timerAvancer.start();

        while(true){
        }
}*/
