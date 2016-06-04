package gioco2048.controller;


import java.awt.event.ActionEvent;
 
import javax.swing.AbstractAction;
 
import gioco2048.view.SchermataBase;
import gioco2048.model.ModelloGioco;
 
public class AzioneFrecciaSu extends AbstractAction {
      
    private SchermataBase schermata_base;
     
    private ModelloGioco modello_gioco;
 
    public AzioneFrecciaSu(SchermataBase frame, ModelloGioco model) {
        this.schermata_base = frame;
        this.modello_gioco = model;
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {        
        if (modello_gioco.puoi_muovere()) {
            if (modello_gioco.muovi_caselle_su()) {
                if (modello_gioco.game_over()) {
                    modello_gioco.set_puoi_muovere(false);
                    System.out.println("CIAO");
                } else {
                    aggiungiCasella();
                }
            }
        }
    }
 
    private void aggiungiCasella() {
        modello_gioco.aggiungi_casella();
         
        schermata_base.repaint_griglia_panel();
        schermata_base.aggiorna_punteggio_panel();
    }
 
 
 
}