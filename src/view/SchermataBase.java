/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import controller.AzioneFrecciaSu;
import controller.AzioneFrecciaGiu;
import controller.AzioneFrecciaSx;
import controller.AzioneFrecciaDx;
import model.ModelloGioco;

import scores.ScoreManager;
import java.awt.Color;

import java.awt.Dimension;


//rappresenta l'intera finestra di gioco
public class SchermataBase {
     
    private StartPanel startPanel;
     
    private ModelloGioco modello;
     
    private GrigliaPanel grigliaPanel;
         
    private ScoreManager scoreManager;
     
    private JFrame frame;
     
    private PunteggioPanel punteggioPanel;
    

     
    public SchermataBase(ModelloGioco model) {
        this.modello = model;
        this.scoreManager = new ScoreManager(model);
        this.scoreManager.loadGame();
        
        inizializza();
    }
 
    private void inizializza() {
        grigliaPanel = new GrigliaPanel(modello);
        punteggioPanel = new PunteggioPanel(modello);
        startPanel = new StartPanel(this, modello);
         
        frame = new JFrame();
        frame.setTitle("2048");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 370)); //dimensioni finestra
        frame.setResizable(false); //non modificabili
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                esci();
            }
        });
         
        inizializza_bind_pulsanti();
 
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(grigliaPanel);   
        mainPanel.add(createSidePanel());
 
        frame.add(mainPanel);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }
 
    private JPanel createSidePanel() {
        JPanel sidePanel = new JPanel();
        
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.PAGE_AXIS));
        sidePanel.add(punteggioPanel.getPanel());
        sidePanel.add(Box.createVerticalStrut(30));
        sidePanel.add(startPanel.getPanel());
        sidePanel.setBackground(Color.ORANGE);//TOGLIEREEEE
        return sidePanel;
    }
     
    private void inizializza_bind_pulsanti() { 
        //permette di fare un Bind tra un evento di input e un oggetto
        InputMap inputMap = grigliaPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        //prima faccio con WHEN_IN_FOCUSED_WINDOW che ha id=2, quindi reperibile da WASD
        
        inputMap.put(KeyStroke.getKeyStroke("W"), "FRECCIA_SU");
        inputMap.put(KeyStroke.getKeyStroke("S"), "FRECCIA_GIU");
        inputMap.put(KeyStroke.getKeyStroke("A"), "FRECCIA_SX");
        inputMap.put(KeyStroke.getKeyStroke("D"), "FRECCIA_DX");
         
        inputMap.put(KeyStroke.getKeyStroke("UP"), "FRECCIA_SU");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "FRECCIA_GIU");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "FRECCIA_SX");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "FRECCIA_DX");
         
        inputMap = grigliaPanel.getInputMap(JPanel.WHEN_FOCUSED);
        //poi faccio con WHEN_FOCUSED che ha id=0, quindi reperibile da UP,DW,SX,DX

        inputMap.put(KeyStroke.getKeyStroke("UP"), "FRECCIA_UP");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "FRECCIA_GIU");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "FRECCIA_SX");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "FRECCIA_DX");
 
        
        grigliaPanel.getActionMap().put("FRECCIA_SU",new AzioneFrecciaSu(this, modello));
        grigliaPanel.getActionMap().put("FRECCIA_GIU", new AzioneFrecciaGiu(this, modello));
        grigliaPanel.getActionMap().put("FRECCIA_SX", new AzioneFrecciaSx(this, modello));
        grigliaPanel.getActionMap().put("FRECCIA_DX", new AzioneFrecciaDx(this, modello));
    }
    
    public void esci() {
        modello.imposta_punteggio();
        scoreManager.saveGame();
        frame.dispose();
        System.exit(0);
    }
     
    public void repaintGrigliaPanel() {
        grigliaPanel.repaint();
    }
    
 
    public void aggiornaPunteggioPanel() {
        punteggioPanel.aggiornaPanel();
    }
    
}

