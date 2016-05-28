package game2048;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.swing.SwingUtilities;


import view.SchermataBase;
import model.ModelloGioco;

public class Game2048 {
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                SchermataBase game = new SchermataBase(new ModelloGioco());
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