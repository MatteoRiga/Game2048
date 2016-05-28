/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;

import model.ModelloGioco;
 
import javax.swing.JPanel;

 
public class GrigliaPanel extends JPanel {
 
    private static final long serialVersionUID = 4019841629547494495L;
     
    private ModelloGioco model;
     
    private GameOverImage image;
     
    public GrigliaPanel(ModelloGioco model) {
        this.model = model;
        this.setPreferredSize(model.get_dimesione_griglia());
        //istanzio gia la scritta gameover , ma compare solo quando
        //non posso più muovere caselle e la griglia è piena
        this.image = new GameOverImage(model); 
        
        this.image.run();
    }
 
    @Override
    public void paint(Graphics g) { //prima era paintComponent
        super.paint(g);
        model.disegna_griglia(g);//disegna la griglia
         
        //se la griglia è piena e non posso più muovere caselle
        //disegno il gameOver
        if (model.game_over()) {
            model.set_puoi_muovere(false);
            g.drawImage(image.getImage(), 0, 0, null);
        }
    }
    
    
    
}