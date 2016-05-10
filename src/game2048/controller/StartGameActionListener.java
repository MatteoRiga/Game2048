/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game2048.model.Game2048Model;
import game2048.view.Game2048Frame;

public class StartGameActionListener implements ActionListener {
     
    private Game2048Frame frame;
     
    private Game2048Model model;
     
    public StartGameActionListener(Game2048Frame frame, 
            Game2048Model model) {
        this.frame = frame;
        this.model = model;
    }
 
    //quando implemento l'interfaccia -ActionListener- il metodo che immplementà 
    //l'interfaccia, richiamerà in automatico il meotodo -actionPerformed-
    //infatti il costruttore si preoccuperà di istanziare le classi necessarie ovvero
    //Game2048Frame e Game2048Model e l'azione del metodo actionPerformed
    //permetterà di eseguire i metodi ad esse collegate, necessari per inizializzare 
    //il gioco
    @Override
    public void actionPerformed(ActionEvent event) {
        model.setHighScores();
        model.initializeGrid();
        model.setArrowActive(true);
        model.addNewCell();
        model.addNewCell();
         
        frame.repaintGridPanel();
        frame.updateScorePanel();
    }
 
}
