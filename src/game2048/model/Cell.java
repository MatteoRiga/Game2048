/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;


 
public class Cell {
     
    //larghezza grafica celle
    private static final int CELL_WIDTH = 75; //prima era 120
     
    //valore della cella
    private int value;
     
    private Point cellLocation;
     
    public Cell(int value) {
        setValue(value);
    }
 
    public static int getCellWidth() {
        return CELL_WIDTH;
    }
     
    public int getValue() {
        return value;
    }
 
    public void setValue(int value) {
        this.value = value;
    }
     
    //controllo se la cella corrente ha valore 0
    public boolean isZeroValue() {
        if(value==0)
            return true;
        else
            return false;
        //le righe sopra possono essere scritte anche nella forma contratta
        //return (value == 0);
    }
     
    public void setCellLocation(int x, int y) {
        setCellLocation(new Point(x, y));
    }
 
    public void setCellLocation(Point cellLocation) {
        this.cellLocation = cellLocation;
    }
 
    public void draw(Graphics g) {
        if (value == 0) {
            g.setColor(new Color(0xcdc1b4)); //prima era Color.DARK_GREY
            g.fillRect( //draw the outline of the specific rectangle
                    cellLocation.x, cellLocation.y, 
                    CELL_WIDTH, CELL_WIDTH);
        } else {   

            Font font = g.getFont();
            FontRenderContext frc = 
                    new FontRenderContext(null, true, true);
     
            String s = Integer.toString(value);
            BufferedImage image = 
                    createImage(font, frc, CELL_WIDTH, s);
             
            g.drawImage(image, cellLocation.x, cellLocation.y, null);
        }
    }
     
    private BufferedImage createImage(Font font, FontRenderContext frc,
            int width, String s) {
 
        Font largeFont = font.deriveFont((float) (width / 4));
        Rectangle2D r = largeFont.getStringBounds(s, frc);
        int rWidth = (int) Math.round(r.getWidth());
        int rHeight = (int) Math.round(r.getHeight());
        int rX = (int) Math.round(r.getX());
        int rY = (int) Math.round(r.getY());
 
        BufferedImage image = new BufferedImage(width, width,
                BufferedImage.TYPE_INT_RGB);
         
        Graphics gg = image.getGraphics();
        gg.setColor(getTileColor());
        gg.fillRect(0, 0, image.getWidth(), image.getHeight());
 
        int x = (width / 2) - (rWidth / 2) - rX;
        int y = (width / 2) - (rHeight / 2) - rY;
         
        gg.setFont(largeFont);
        gg.setColor(getTextColor());
        gg.drawString(s, x, y);
        gg.dispose();
        return image;
    }
     
    private Color getTileColor() {
        Color color = Color.WHITE;
         
        switch (value) {
            case 2:     color = new Color(0xeee4da);
                        break;
            case 4:     color = new Color(0xede0c8);
                        break;
            case 8:     color = new Color(0xf2b179);
                        break;
            case 16:    color = new Color(0xf59563);
                        break;
            case 32:    color = new Color(0xf67c5f);
                        break;
            case 64:    color = new Color(0xf65e3b);
                        break;
            case 128:   color = new Color(0xedcf72);
                        break;
            case 256:   color = new Color(0xedcc61);
                        break;
            case 512:   color = new Color(0xedc850);
                        break;
            case 1024:  color = new Color(0xedc53f);
                        break;
            case 2048:  color = new Color(0xedc22e);
                        break;
            default:    color = new Color(0xcdc1b4);
                        break;
        }
         
        return color;
    }
     
    //PER COLORE VALORE DELLA CELLA
    //condizione_booleana ? condizione_vera : condizione_falsa;
    private Color getTextColor() {
        return (value > 4) ? Color.WHITE : Color.DARK_GRAY;
    }
}