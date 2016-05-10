/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048;


import javax.swing.SwingUtilities;

import game2048.view.Game2048Frame;
import game2048.model.Game2048Model;
import game2048.model.Game2048Model;
 
public class Game20482 {
 
    private static void createAndShowGUI(){
        Game2048Frame game = new Game2048Frame(new Game2048Model());
    }

     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                createAndShowGUI();
            }
        });
    }
 
}

/*sennò usa questa che è uguale*/
/*
public class Game2048 implements Runnable {
 
    @Override
    public void run() {
        new Game2048Frame(new Game2048Model());
    }
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game2048());
    }
 
}
*/