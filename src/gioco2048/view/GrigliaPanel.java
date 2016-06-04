package gioco2048.view;

import java.awt.Graphics;

import gioco2048.model.ModelloGioco;
 
import javax.swing.JPanel;

 
public class GrigliaPanel extends JPanel {
      
    private ModelloGioco modello_gioco;
     
    private ImmagineGameOver immagine_game_over;
     
    public GrigliaPanel(ModelloGioco model) {
        this.modello_gioco = model;
        this.setPreferredSize(model.get_dimesione_griglia());
        this.immagine_game_over = new ImmagineGameOver(model); 
    }
 
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        modello_gioco.disegna_griglia(g);

        if (modello_gioco.game_over()) {
            modello_gioco.set_puoi_muovere(false);
            g.drawImage(immagine_game_over.getImage(), 0, 0, null);
        }
    }
    
    
    
}