package gioco2048.view;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import gioco2048.controller.AzioneFrecciaSu;
import gioco2048.controller.AzioneFrecciaGiu;
import gioco2048.controller.AzioneFrecciaSx;
import gioco2048.controller.AzioneFrecciaDx;
import gioco2048.model.ModelloGioco;

import gioco2048.punteggi.GestorePunteggi;
import java.awt.Color;



import java.awt.Dimension;


//rappresenta l'intera finestra di gioco
public class SchermataBase {
    
    private ModelloGioco modello_gioco;
    
    private GrigliaPanel griglia_panel;
    
    private PunteggioPanel punteggio_panel;
    
    private GestorePunteggi gestore_punteggi;
    
    private StartPanel start_panel;
        
           
    private JFrame frame;
     
    

     
    public SchermataBase(ModelloGioco model) {
        this.modello_gioco = model;
        this.gestore_punteggi = new GestorePunteggi(model);
        this.gestore_punteggi.carica_gioco();
        
        inizializza_schermata_base();
    }
 
    private void inizializza_schermata_base() {
        griglia_panel = new GrigliaPanel(modello_gioco);
        punteggio_panel = new PunteggioPanel(modello_gioco);
        start_panel = new StartPanel(this, modello_gioco);
         
        frame = new JFrame();
        frame.setTitle("2048");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setPreferredSize(new Dimension(630, 370)); //dimensioni finestra
        
        frame.setResizable(false); //non modificabili
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                esci();
            }
        });
         
        inizializza_pulsanti();
 
        JPanel panel_principale = new JPanel();
        panel_principale.setLayout(new FlowLayout());
        panel_principale.add(griglia_panel);   
        panel_principale.add(crea_panel_laterale());
        //mainPanel.add(start_panel.getPanel());// aggiunto qui per mettere sotto
        
        frame.add(panel_principale);
        frame.setLocationByPlatform(true);
        frame.pack();//prende la dimensione in base ai sottocomponenti
        frame.setVisible(true);
    }
 
    private JPanel crea_panel_laterale() {
        JPanel panel_laterale = new JPanel();
        panel_laterale.setLayout(new BoxLayout(panel_laterale, BoxLayout.PAGE_AXIS));
        panel_laterale.add(punteggio_panel.getPanel());
        panel_laterale.add(Box.createVerticalStrut(30));//dimensione dell'arancione, spazio tra i componenti
        panel_laterale.add(start_panel.getPanel()); // tolto da qui per mettere sotto
        panel_laterale.setBackground(Color.ORANGE);//TOGLIEREEEE 
        return panel_laterale;
    }
     
    private void inizializza_pulsanti() { 
        //permette di fare un Bind tra un evento di input e un oggetto
        InputMap inputMap = griglia_panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        //prima faccio con WHEN_IN_FOCUSED_WINDOW che ha id=2, quindi reperibile da WASD
        
        inputMap.put(KeyStroke.getKeyStroke("W"), "FRECCIA_SU");
        inputMap.put(KeyStroke.getKeyStroke("S"), "FRECCIA_GIU");
        inputMap.put(KeyStroke.getKeyStroke("A"), "FRECCIA_SX");
        inputMap.put(KeyStroke.getKeyStroke("D"), "FRECCIA_DX");
         
        inputMap.put(KeyStroke.getKeyStroke("UP"), "FRECCIA_SU");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "FRECCIA_GIU");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "FRECCIA_SX");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "FRECCIA_DX");
         
        inputMap = griglia_panel.getInputMap(JPanel.WHEN_FOCUSED);
        //poi faccio con WHEN_FOCUSED che ha id=0, quindi reperibile da UP,DW,SX,DX

        inputMap.put(KeyStroke.getKeyStroke("UP"), "FRECCIA_UP");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "FRECCIA_GIU");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "FRECCIA_SX");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "FRECCIA_DX");
 
        
        griglia_panel.getActionMap().put("FRECCIA_SU",new AzioneFrecciaSu(this, modello_gioco));
        griglia_panel.getActionMap().put("FRECCIA_GIU", new AzioneFrecciaGiu(this, modello_gioco));
        griglia_panel.getActionMap().put("FRECCIA_SX", new AzioneFrecciaSx(this, modello_gioco));
        griglia_panel.getActionMap().put("FRECCIA_DX", new AzioneFrecciaDx(this, modello_gioco));
    }
    
    public void esci() {
        modello_gioco.imposta_punteggio();
        gestore_punteggi.salva_gioco();
        frame.dispose();
        System.exit(0);
    }
     
    public void repaint_griglia_panel() {
        griglia_panel.repaint();
    }
    
 
    public void aggiorna_punteggio_panel() {
        punteggio_panel.aggiorna_punteggio_panel();
    }
    
}

