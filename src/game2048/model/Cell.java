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

 
public final class Cell {
     
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
 
    //disegna una singola cella
    public void draw(Graphics g) {
        if (value == 0) {
            g.setColor(new Color(ColorUtil.color_vuota)); //prima era Color.DARK_GREY
            /*g.fillRect( //draw the outline of the specific rectangle
                    cellLocation.x, cellLocation.y, 
                    CELL_WIDTH, CELL_WIDTH);
            */
            g.fillRoundRect(cellLocation.x, cellLocation.y, CELL_WIDTH, CELL_WIDTH, 15, 15); // per contenitori celle stondate
        } else {   
            //Font font = g.getFont();
            Font font = new Font("Bebas Neue Regular", Font.PLAIN, 28);
            FontRenderContext frc = new FontRenderContext(null, true, true);

            String s = Integer.toString(value);
            BufferedImage image = createImage(font, frc, CELL_WIDTH, s);
            g.drawImage(image, cellLocation.x, cellLocation.y, null);
        }
    }
    
    //crea una cella
    private BufferedImage createImage(Font font, FontRenderContext frc, int width, String s) { 
 
        Font largeFont = font.deriveFont((float) (width / 4));
        
        Rectangle2D r = largeFont.getStringBounds(s, frc); //
        
        int rWidth = (int) Math.round(r.getWidth());    //larghezza of rectangle
        int rHeight = (int) Math.round(r.getHeight());  //altezza of rectangle
        int rX = (int) Math.round(r.getX()); //coordinate of upper X coordinate of rectangle
        int rY = (int) Math.round(r.getY()); //coordinate of upper Y coordinate of rectangle
        
        
        BufferedImage image = new BufferedImage(width, width, BufferedImage.TYPE_INT_RGB);
         
        Graphics gg = image.getGraphics();
        gg.setColor(new Color(ColorUtil.colore_griglia));
        gg.fillRect(0, 0, image.getWidth(), image.getHeight());
        
        gg.setColor(ColorUtil.getTileColor(value));
        //la disegna stondata
        gg.fillRoundRect(0, 0, image.getWidth(), image.getHeight(), 25, 25); 

        
        int x = (width / 2) - (rWidth / 2) - rX;
        int y = (width / 2) - (rHeight / 2) - rY;
        
        gg.setFont(largeFont);
        
        gg.setColor(ColorUtil.getTextColor(value));
        gg.drawString(s, x, y);
        gg.dispose();
        return image;
    } 
 
}