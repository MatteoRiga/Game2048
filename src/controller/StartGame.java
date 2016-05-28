/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ModelloGioco;
import view.SchermataBase;

public class StartGame implements ActionListener {
     
    private SchermataBase finestra;
     
    private ModelloGioco modello;
     
    public StartGame(SchermataBase frame, 
            ModelloGioco model) {
        this.finestra = frame;
        this.modello = model;
    }
 
    //quando implemento l'interfaccia -ActionListener- il metodo che immplementà 
    //l'interfaccia, richiamerà in automatico il meotodo -actionPerformed-
    //infatti il costruttore si preoccuperà di istanziare le classi necessarie ovvero
    //Game2048Frame e Game2048Model e l'azione del metodo actionPerformed
    //permetterà di eseguire i metodi ad esse collegate, necessari per inizializzare 
    //il gioco
    @Override
    public void actionPerformed(ActionEvent event) {
        modello.imposta_punteggio();
        modello.inizializza_griglia();
        modello.set_puoi_muovere(true); // va a true appena clicco start
        modello.aggiungi_casella();
        modello.aggiungi_casella();
         
        finestra.repaintGrigliaPanel();
        finestra.aggiornaPunteggioPanel();
    }
 
}
