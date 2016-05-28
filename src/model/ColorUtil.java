/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;

/**
 *
 * @author Matteo
 */
public class ColorUtil {
    
    public final static int color_griglia = 0xbbada0;
    
    public final static int color_vuota = 0xcdc1b4;
    private final static int color_2 = 0xeee4da;
    private final static int color_4 = 0xede0c8;
    private final static int color_8 = 0xf2b179;
    private final static int color_16 = 0xf59563;
    private final static int color_32 = 0xf67c5f;
    private final static int color_64 = 0xf65e3b;
    private final static int color_128 = 0xedcf72;
    private final static int color_256 = 0xedcc61;
    private final static int color_512 = 0xedc850;
    private final static int color_1024 = 0xedc53f;
    private final static int color_2048 = 0xedc22e;
    private final static int color_oltre = 0x00000;
    
    public final static Color get_colore_casella(int valore) {
     Color color = Color.WHITE;

     switch (valore) {
         case 2:     color = new Color(ColorUtil.color_2);
                     break;
         case 4:     color = new Color(ColorUtil.color_4);
                     break;
         case 8:     color = new Color(ColorUtil.color_8);
                     break;
         case 16:    color = new Color(ColorUtil.color_16);
                     break;
         case 32:    color = new Color(ColorUtil.color_32);
                     break;
         case 64:    color = new Color(ColorUtil.color_64);
                     break;
         case 128:   color = new Color(ColorUtil.color_128);
                     break;
         case 256:   color = new Color(ColorUtil.color_256);
                     break;
         case 512:   color = new Color(ColorUtil.color_512);
                     break;
         case 1024:  color = new Color(ColorUtil.color_1024);
                     break;
         case 2048:  color = new Color(ColorUtil.color_2048);
                     break;
         default:    color = new Color(ColorUtil.color_oltre);
                     break;
     }

     return color;
     }
     
    //PER COLORE VALORE DELLA CELLA
    public final static Color get_colore_testo(int valore) {
        if (valore > 4)
            return Color.WHITE;
        return Color.DARK_GRAY;
    }
    
}
