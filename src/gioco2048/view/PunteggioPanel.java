package gioco2048.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.NumberFormat;
 
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
import java.awt.Color;

import gioco2048.model.ModelloGioco;

public class PunteggioPanel {
     
    private static final Insets margini   = new Insets(20, 20, 20, 20); 
     
    private static final NumberFormat number_format = NumberFormat.getInstance();
     
    private ModelloGioco modello_gioco;
     
    private JPanel panel;
    
    private JTextField miglior_punteggio_field;
    private JTextField miglior_casella_field;
    private JTextField miglior_punteggio_corrente_field;
    private JTextField miglior_casella_corrente_field;
    //----------------------------------
    
    public PunteggioPanel(ModelloGioco model) {
        this.modello_gioco = model;
        crea_punteggio_panel();
        aggiorna_punteggio_panel();
    }
     
    private void crea_punteggio_panel() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
         
        //MIGLIOR_PUNTEGGIO_LABEL
        //----------------------------------
        JLabel miglior_punteggio_label = new JLabel("Miglior Punteggio:");       
        AggiungiComponente(panel, 
                           miglior_punteggio_label, 
                           0, //[0][0]
                           0, 
                           1, 
                           1, 
                           margini, 
                           GridBagConstraints.CENTER, 
                           GridBagConstraints.NONE);
        
        miglior_punteggio_field = new JTextField(6); // costruisce la field con una larghezza stabilita
        miglior_punteggio_field.setEditable(false);
        miglior_punteggio_field.setHorizontalAlignment(JTextField.RIGHT);       
        AggiungiComponente(panel, 
                           miglior_punteggio_field, 
                           1, //[1][0]
                           0, 
                           1, 
                           1, 
                           margini, 
                           GridBagConstraints.CENTER, 
                           GridBagConstraints.NONE);
        //----------------------------------
        
        //MIGLIOR_CELLA_LABEL
        //----------------------------------
        JLabel miglior_casella_label = new JLabel("Miglior Casella:");       
        AggiungiComponente(panel, 
                           miglior_casella_label, 
                           0, //[0][1]
                           1, 
                           1, 
                           1, 
                           margini, 
                           GridBagConstraints.CENTER, 
                           GridBagConstraints.NONE);
         
        miglior_casella_field = new JTextField(6);
        miglior_casella_field.setEditable(false);
        miglior_casella_field.setHorizontalAlignment(JTextField.RIGHT);
       
        AggiungiComponente(panel, 
                           miglior_casella_field, 
                           1, //[1][1]
                           1, 
                           1, 
                           1, 
                           margini, 
                           GridBagConstraints.CENTER, 
                           GridBagConstraints.NONE);
        //----------------------------------
         
        //MIGLIOR_PUNTEGGIO_CORRENTE_LABEL
        //----------------------------------
        JLabel miglior_punteggio_corrente_label = new JLabel("Punteggio Corrente:");
        AggiungiComponente(panel, 
                           miglior_punteggio_corrente_label, 
                           0, //[0][2]
                           2, 
                           1, 
                           1, 
                           margini, 
                           GridBagConstraints.CENTER, 
                           GridBagConstraints.NONE);
         
        miglior_punteggio_corrente_field = new JTextField(6);
        miglior_punteggio_corrente_field.setEditable(true);
        miglior_punteggio_corrente_field.setHorizontalAlignment(JTextField.RIGHT);
        AggiungiComponente(panel, 
                           miglior_punteggio_corrente_field, 
                           1, //[1][2]
                           2, 
                           1, 
                           1, 
                           margini, 
                           GridBagConstraints.CENTER, 
                GridBagConstraints.NONE);
        //----------------------------------
         
        //MIGLIOR_CASELLA_CORRENTE_LABEL
        //----------------------------------
        JLabel miglior_casella_corrente = new JLabel("Miglior Casella:");       
        AggiungiComponente(panel, 
                           miglior_casella_corrente, 
                           0, //[0][3]
                           3, 
                           1, 
                           1, 
                           margini, 
                           GridBagConstraints.CENTER, 
                           GridBagConstraints.NONE);
         
        miglior_casella_corrente_field = new JTextField(6);
        miglior_casella_corrente_field.setEditable(false);
        miglior_casella_corrente_field.setHorizontalAlignment(JTextField.RIGHT);       
        AggiungiComponente(panel, 
                           miglior_casella_corrente_field, 
                           1, //[1][3]
                           3, 
                           1, 
                           1, 
                           margini, 
                           GridBagConstraints.CENTER, 
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
     
    
    
    public void aggiorna_punteggio_panel() {
        miglior_punteggio_field.setText(number_format.format(modello_gioco.get_miglior_punteggio()));
        miglior_casella_field.setText(number_format.format(modello_gioco.get_miglior_casella()));
        miglior_punteggio_corrente_field.setText(number_format.format(modello_gioco.get_miglior_punteggio_corrente()));
        miglior_casella_corrente_field.setText(number_format.format(modello_gioco.get_miglior_casella_corrente()));
    }
 
    public JPanel getPanel() {
        return panel;
    }
}
