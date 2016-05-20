/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048.model;

import java.awt.Color;

/**
 *
 * @author Matteo
 */
public class CellColor {
    
    public final static int color_2 = 0xeee4da;
    public final static int color_4 = 0xede0c8;
    public final static int color_8 = 0xf2b179;
    public final static int color_16 = 0xf59563;
    public final static int color_32 = 0xf67c5f;
    public final static int color_64 = 0xf65e3b;
    public final static int color_128 = 0xedcf72;
    public final static int color_256 = 0xedcc61;
    public final static int color_512 = 0xedc850;
    public final static int color_1024 = 0xedc53f;
    public final static int color_2048 = 0xedc22e;
    public final static int color_vuota = 0xcdc1b4;
    
       public final static Color getTileColor(int valore) {
        Color color = Color.WHITE;
         
        switch (valore) {
            case 2:     color = new Color(CellColor.color_2);
                        break;
            case 4:     color = new Color(CellColor.color_4);
                        break;
            case 8:     color = new Color(CellColor.color_8);
                        break;
            case 16:    color = new Color(CellColor.color_16);
                        break;
            case 32:    color = new Color(CellColor.color_32);
                        break;
            case 64:    color = new Color(CellColor.color_64);
                        break;
            case 128:   color = new Color(CellColor.color_128);
                        break;
            case 256:   color = new Color(CellColor.color_256);
                        break;
            case 512:   color = new Color(CellColor.color_512);
                        break;
            case 1024:  color = new Color(CellColor.color_1024);
                        break;
            case 2048:  color = new Color(CellColor.color_2048);
                        break;
            default:    color = new Color(CellColor.color_vuota);
                        break;
        }
         
        return color;
    }
     
    //PER COLORE VALORE DELLA CELLA
    //condizione_booleana ? condizione_vera : condizione_falsa;
    public final static Color getTextColor(int valore) {
        if (valore > 4)
            return Color.WHITE;
        return Color.DARK_GRAY;
    }
    
}
