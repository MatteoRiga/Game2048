/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.awt.event.ActionEvent;
 
import javax.swing.AbstractAction;
 
import view.SchermataBase;
import model.ModelloGioco;
 
public class AzioneFrecciaDx extends AbstractAction {
  
    private SchermataBase finestra;
     
    private ModelloGioco modello;
    
 
    public AzioneFrecciaDx(SchermataBase frame, ModelloGioco model) {
        this.finestra = frame;
        this.modello = model;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (modello.puoi_muovere()) {
            if (modello.muovi_caselle_dx()) {
                if (modello.game_over()) {
                    modello.set_puoi_muovere(false);
                    System.out.println("CIAO");
                } else {
                    aggiungiCasella();

                }
            }
        }
    }
    
     private void aggiungiCasella() {
        modello.aggiungi_casella();
         
        finestra.repaintGrigliaPanel();
        finestra.aggiornaPunteggioPanel();
    }
 
}