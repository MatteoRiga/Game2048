/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048.controller;


import java.awt.event.ActionEvent;
 
import javax.swing.AbstractAction;
 
import game2048.view.Game2048Frame;
import game2048.model.Game2048Model;
 
public class UpArrowAction extends AbstractAction {
 
    private static final long serialVersionUID = -2851527479086591525L;
     
    private Game2048Frame frame;
     
    private Game2048Model model;
 
    public UpArrowAction(Game2048Frame frame, Game2048Model model) {
        this.frame = frame;
        this.model = model;
    }
 
    @Override
    public void actionPerformed(ActionEvent event) {        
        if (model.puoiMuovere()) {
            if (model.moveCellsUp()) {
                if (model.isGameOver()) {
                    model.setPuoiMuovere(false); // va false solo in questo caso, quando è gameOver
                } else {
                    addNewCell();
                }
            }
        }
    }
 
    private void addNewCell() {
        model.addNewCell();
         
        frame.repaintGridPanel();
        frame.updateScorePanel();
    }
 
 
 
}