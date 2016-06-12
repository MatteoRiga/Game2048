package gioco2048;

import javax.swing.SwingUtilities;


import gioco2048.view.SchermataBase;
import gioco2048.model.ModelloGioco;

public class Gioco2048{
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                SchermataBase schermataBase = new SchermataBase(new ModelloGioco());
            }
        });
    }
 
}
