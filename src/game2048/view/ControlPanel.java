/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048.view;


import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
 
import javax.swing.JButton;
import javax.swing.JPanel;
 
import game2048.controller.StartGameActionListener;
import game2048.model.Game2048Model;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
 
public class ControlPanel {
    
    //stabilisce lo spazio del che ci deve essere tra i lati del pannello dei punteggi
    private static final Insets regularInsets   = 
            new Insets(10, 10, 0, 10);
     
    private Game2048Frame frame;
     
    private Game2048Model model;
     
    private JPanel panel;
 
    //per la creazione del pulsante start
    public ControlPanel(Game2048Frame frame, Game2048Model model) {
        this.frame = frame;
        this.model = model;
        createPartControl();
    }
     
    private void createPartControl() {
        StartGameActionListener listener = new StartGameActionListener(frame, model);
        
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