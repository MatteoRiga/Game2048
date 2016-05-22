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
import java.text.NumberFormat;
 
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
import game2048.model.Game2048Model;
import java.awt.Color;
 
public class ScorePanel {
     
    private static final Insets margini   = 
            new Insets(10, 10, 10, 10);
     
    private static final NumberFormat nf =
            NumberFormat.getInstance();
     
    private Game2048Model model;
     
    private JPanel panel;
     
    //li dichiaro qui questi, perchè sono usati sia da 
    //createPartControl(), sia da updatePartControl();
    private JTextField highScoreField;
    private JTextField highCellField;
    private JTextField currentScoreField;
    private JTextField currentCellField;
    //----------------------------------
    
    
    public ScorePanel(Game2048Model model) {
        this.model = model;
        createPartControl();
        updatePartControl();
    }
     
    private void createPartControl() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.RED); //TOGLIEREEEE
        int gridy = 0;
         
        //HIGH_SCORE_LABEL
        //----------------------------------
        JLabel highScoreLabel = new JLabel("High Score:");       
        AggiungiComponente(panel, 
                           highScoreLabel, 
                           0, //posizione asse X
                           gridy, //posizione assy Y
                           1, 
                           1, 
                           margini, 
                           GridBagConstraints.CENTER, 
                           GridBagConstraints.NONE);
        
        highScoreField = new JTextField(6); // costruisce la field con una larghezza stabilita
        highScoreField.setEditable(false);
        highScoreField.setHorizontalAlignment(JTextField.RIGHT);       
        AggiungiComponente(panel, highScoreField, 1, gridy++, 1, 1, 
                margini, GridBagConstraints.CENTER, 
                GridBagConstraints.NONE);
        //----------------------------------
        
        //HIGH_CELL_LABEL
        //----------------------------------
        JLabel highCellLabel = new JLabel("High Cell:");       
        AggiungiComponente(panel, highCellLabel, 0, gridy, 1, 1, 
                margini, GridBagConstraints.CENTER, 
                GridBagConstraints.NONE);
         
        highCellField = new JTextField(6);
        highCellField.setEditable(false);
        highCellField.setHorizontalAlignment(JTextField.RIGHT);
       
        AggiungiComponente(panel, highCellField, 1, gridy++, 1, 1, 
                margini, GridBagConstraints.CENTER, 
                GridBagConstraints.NONE);
        //----------------------------------
         
        //CURRENT_SCORE_LABEL
        //----------------------------------
        JLabel currentScoreLabel = new JLabel("Current Score:");
        AggiungiComponente(panel, currentScoreLabel, 0, gridy, 1, 1, 
                margini, GridBagConstraints.CENTER, 
                GridBagConstraints.NONE);
         
        currentScoreField = new JTextField(6);
        currentScoreField.setEditable(false);
        currentScoreField.setHorizontalAlignment(JTextField.RIGHT);
        AggiungiComponente(panel, currentScoreField, 1, gridy++, 1, 1, 
                margini, GridBagConstraints.CENTER, 
                GridBagConstraints.NONE);
        //----------------------------------
         
        //CURRENT_CELL_LABEL
        //----------------------------------
        JLabel currentCellLabel = new JLabel("Current High Cell:");       
        AggiungiComponente(panel, currentCellLabel, 0, gridy, 1, 1, 
                margini, GridBagConstraints.CENTER, 
                GridBagConstraints.NONE);
         
        currentCellField = new JTextField(6);
        currentCellField.setEditable(false);
        currentCellField.setHorizontalAlignment(JTextField.RIGHT);       
        AggiungiComponente(panel, currentCellField, 1, gridy++, 1, 1, 
                margini, GridBagConstraints.CENTER, 
                GridBagConstraints.NONE);
        //----------------------------------
    }
 
    private void AggiungiComponente(Container container,  //è il mio jpanel
                              Component component, //la componente da aggiungere
                              int gridx, // posizione asse x
                              int gridy, // posizione asse y
                              int gridwidth, //numero celle per riga
                              int gridheight, //numero celle colonna
                              Insets insets, //margini esterni
                              int anchor, //
                              int fill) { 
        GridBagConstraints gbc = new GridBagConstraints(gridx, 
                                                        gridy,
                                                        gridwidth, 
                                                        gridheight, 
                                                        0, 
                                                        0, 
                                                        anchor, 
                                                        fill, 
                                                        insets,//external padding del component
                                                        0, //padding x field
                                                        0); //padding y field

        container.add(component, gbc);
    }
     
    
    
    public void updatePartControl() {
        highScoreField.setText(nf.format(model.getHighScore()));
        highCellField.setText(nf.format(model.getHighCell()));
        currentScoreField.setText(nf.format(model.getCurrentScore()));
        currentCellField.setText(nf.format(model.getCurrentCell()));
    }
 
    public JPanel getPanel() {
        return panel;
    }
}
