/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048.view;

import java.awt.Graphics;

import game2048.model.Game2048Model;
 
import javax.swing.JPanel;

 
public class GridPanel extends JPanel {
 
    private static final long serialVersionUID = 4019841629547494495L;
     
    private Game2048Model model;
     
    private GameOverImage image;
     
    public GridPanel(Game2048Model model) {
        this.model = model;
        this.setPreferredSize(model.getPreferredSize());
        //istanzio gia la scritta gameover , ma compare solo quando
        //non posso più muovere caselle e la griglia è piena
        this.image = new GameOverImage(model); 
        
        this.image.run();
    }
 
    @Override
    public void paint(Graphics g) { //prima era paintComponent
        super.paint(g);
        model.draw(g);//disegna la griglia
         
        //se la griglia è piena e non posso più muovere caselle
        //disegno il gameOver
        if (model.isGameOver()) {
            model.setPuoiMuovere(false);
            g.drawImage(image.getImage(), 0, 0, null);
        }
    }
    
    
    
}