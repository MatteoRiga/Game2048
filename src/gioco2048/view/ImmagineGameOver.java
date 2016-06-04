package gioco2048.view;

import gioco2048.model.ModelloGioco;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import gioco2048.model.ModelloGioco;

 
public class ImmagineGameOver {
     
    private BufferedImage immagine;
 
    private ModelloGioco modello_gioco;
     
    public ImmagineGameOver(ModelloGioco model) {
        this.modello_gioco = model;
        disegna_game_over();
    }
 
    private void disegna_game_over(){
    String s = "Game Over";
        Dimension d = modello_gioco.get_dimesione_griglia();
        immagine = new BufferedImage(d.width, d.height, 
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = immagine.createGraphics();
 
        g.setComposite(AlphaComposite.getInstance(
                AlphaComposite.CLEAR));
         
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, d.width, d.height);
         
        g.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER));
         
        g.setColor(Color.DARK_GRAY);
        //Font font = g.getFont();
        Font font = new Font("Bebas Neue Regular", Font.PLAIN, 28);
        Font largeFont = font.deriveFont(58.0F);
        FontRenderContext frc = 
                new FontRenderContext(null, true, true);
        Rectangle2D r = largeFont.getStringBounds(s, frc);
        int rWidth = (int) Math.round(r.getWidth());
        int rHeight = (int) Math.round(r.getHeight());
        int rX = (int) Math.round(r.getX());
        int rY = (int) Math.round(r.getY());
         
        int x = (d.width / 2) - (rWidth / 2) - rX;
        int y = (d.height / 2) - (rHeight / 2) - rY;
         
        g.setFont(largeFont);
        g.drawString(s, x, y);
         
        g.dispose();
    }
 
    public BufferedImage getImage() {
        return immagine;
    }
 
}
