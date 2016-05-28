/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
 
import javax.swing.JButton;
import javax.swing.JPanel;
 
import controller.StartGame;
import model.ModelloGioco;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
 
public class StartPanel {
    
    //stabilisce lo spazio del che ci deve essere tra i lati del pannello dei punteggi
    private static final Insets regularInsets   = 
            new Insets(10, 10, 0, 10);
     
    private SchermataBase frame;
     
    private ModelloGioco model;
     
    private JPanel panel;
 
    //per la creazione del pulsante start
    public StartPanel(SchermataBase frame, ModelloGioco model) {
        this.frame = frame;
        this.model = model;
        inizializza();
    }
     
    private void inizializza() {
        StartGame listener = new StartGame(frame, model);
        
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.BLACK); ///TOGLIEREEEEEEEE
        JButton startGameButton = new JButton("Start");
        startGameButton.addActionListener(listener);
        startGameButton.setPreferredSize(new Dimension(140, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        panel.add(startGameButton, gbc);
    }
 

    public JPanel getPanel() {
        return panel;
    }
}