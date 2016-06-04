package gioco2048.view;


import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
 
import javax.swing.JButton;
import javax.swing.JPanel;
 
import gioco2048.controller.StartGame;
import gioco2048.model.ModelloGioco;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
 
public class StartPanel {
    
    //stabilisce lo spazio del che ci deve essere tra i lati del pannello dei punteggi
    //private static final Insets margini   = new Insets(20,20, 0, 20);
     
    private SchermataBase schermata_base;
     
    private ModelloGioco modello_gioco;
     
    private JPanel panel;
 
    //per la creazione del pulsante start
    public StartPanel(SchermataBase frame, ModelloGioco model) {
        this.schermata_base = frame;
        this.modello_gioco = model;
        inizializza_start_panel();
    }
     
    private void inizializza_start_panel() {
        StartGame start_game = new StartGame(schermata_base, modello_gioco);
        
        panel = new JPanel();
        panel.setLayout(new FlowLayout()); //new GridBagLayout()
        panel.setBackground(Color.BLACK); ///TOGLIEREEEEEEEE
        JButton startGameButton = new JButton("Start");
        startGameButton.addActionListener(start_game);
        startGameButton.setPreferredSize(new Dimension(140, 40));
        //GridBagConstraints gbc = new GridBagConstraints();
        panel.add(startGameButton); //, gbc
    }
 

    public JPanel getPanel() {
        return panel;
    }
}