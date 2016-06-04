package gioco2048;

import javax.swing.SwingUtilities;


import gioco2048.view.SchermataBase;
import gioco2048.model.ModelloGioco;

public class Gioco2048 {
     
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
public class Gioco2048 implements Runnable {
 
    @Override
    public void run() {
        new Game2048Frame(new Game2048Model());
    }
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Gioco2048());
    }
 
}
*/