/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048.view;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import game2048.controller.UpArrowAction;
import game2048.controller.DownArrowAction;
import game2048.controller.LeftArrowAction;
import game2048.controller.RightArrowAction;
import game2048.model.Game2048Model;

import game2048.properties.ScoreManager;
import java.awt.Color;

import java.awt.Dimension;


//rappresenta l'intera finestra di gioco
public class Game2048Frame {
     
    private ControlPanel controlPanel;
     
    private Game2048Model model;
     
    private GridPanel gridPanel;
         
    private ScoreManager scoreManager;
     
    private JFrame frame;
     
    private ScorePanel scorePanel;
    

     
    public Game2048Frame(Game2048Model model) {
        this.model = model;
        this.scoreManager = new ScoreManager(model);
        this.scoreManager.loadGame();
        
        createPartControl();
    }
 
    private void createPartControl() {
        gridPanel = new GridPanel(model);
        scorePanel = new ScorePanel(model);
        controlPanel = new ControlPanel(this, model);
         
        frame = new JFrame();
        frame.setTitle("2048");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600, 370)); //dimensioni finestra
        //frame.setResizable(false); //non modificabili
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });
         
        setKeyBindings();
 
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(gridPanel);   
        mainPanel.add(createSidePanel());
 
        frame.add(mainPanel);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }
 
    private JPanel createSidePanel() {
        JPanel sidePanel = new JPanel();
        
        sidePanel.setLayout(new BoxLayout(sidePanel, 
                BoxLayout.PAGE_AXIS));
        sidePanel.add(scorePanel.getPanel());
        sidePanel.add(Box.createVerticalStrut(30));
        sidePanel.add(controlPanel.getPanel());
        sidePanel.setBackground(Color.ORANGE);//TOGLIEREEEE
        return sidePanel;
    }
     
    private void setKeyBindings() { 
        //permette di fare un Bind tra un evento di input e un oggetto
        InputMap inputMap = gridPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        //prima faccio con WHEN_IN_FOCUSED_WINDOW che ha id=2, quindi reperibile da WASD
        
        inputMap.put(KeyStroke.getKeyStroke("W"), "FRECCIA_UP");
        inputMap.put(KeyStroke.getKeyStroke("S"), "FRECCIA_DW");
        inputMap.put(KeyStroke.getKeyStroke("A"), "FRECCIA_SX");
        inputMap.put(KeyStroke.getKeyStroke("D"), "FRECCIA_DX");
         
        inputMap.put(KeyStroke.getKeyStroke("UP"), "FRECCIA_UP");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "FRECCIA_DW");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "FRECCIA_SX");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "FRECCIA_DX");
         
        inputMap = gridPanel.getInputMap(JPanel.WHEN_FOCUSED);
        //poi faccio con WHEN_FOCUSED che ha id=0, quindi reperibile da UP,DW,SX,DX

        inputMap.put(KeyStroke.getKeyStroke("UP"), "FRECCIA_UP");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "FRECCIA_DW");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "FRECCIA_SX");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "FRECCIA_DX");
 
        
        gridPanel.getActionMap().put("FRECCIA_UP",new UpArrowAction(this, model));
        gridPanel.getActionMap().put("FRECCIA_DW", new DownArrowAction(this, model));
        gridPanel.getActionMap().put("FRECCIA_SX", new LeftArrowAction(this, model));
        gridPanel.getActionMap().put("FRECCIA_DX", new RightArrowAction(this, model));
    }
    
    public void exitProcedure() {
        model.setHighScores();
        scoreManager.saveGame();
        frame.dispose();
        System.exit(0);
    }
     
    public void repaintGridPanel() {
        gridPanel.repaint();
    }
    
 
    public void updateScorePanel() {
        scorePanel.updatePartControl();
    }
    
}

