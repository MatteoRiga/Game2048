package gioco2048.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
 
public class ModelloGioco {
     
    private static final int SPAZIATURA_CASELLE = 6; 
    private static final int NUM_CASELLE = 4; 
     
    private boolean puoi_muovere;
     
    private int miglior_punteggio; 
    private int miglior_casella; 
    private int miglior_punteggio_corrente; 
    private int miglior_casella_corrente; 
     
    private Casella[][] griglia;
     
    private Random num_random;
    
    
     
    public ModelloGioco() {
        this.griglia = new Casella[NUM_CASELLE][NUM_CASELLE];
        this.num_random = new Random();
        this.miglior_punteggio = 0;
        this.miglior_casella = 0;
        this.miglior_punteggio_corrente = 0;
        this.miglior_casella_corrente = 0;
        this.puoi_muovere = false;
        inizializza_griglia();
    }
     
    public void inizializza_griglia() {
        int xx = SPAZIATURA_CASELLE;
        for (int x = 0; x < NUM_CASELLE; x++) {
            int yy = SPAZIATURA_CASELLE;
            for (int y = 0; y < NUM_CASELLE; y++) {
                Casella cell = new Casella(0);
                cell.set_posizione_casella(xx, yy);
                griglia[x][y] = cell;
                yy += SPAZIATURA_CASELLE + Casella.get_larghezza_casella();
            }
            xx += SPAZIATURA_CASELLE + Casella.get_larghezza_casella();
        }
    }
     
     
    public boolean game_over() {
        if(griglia_piena() == true && posso_muovere() == false)
            return true;
        else
            return false;
                
    }
     
    private boolean griglia_piena() {
        for (int x = 0; x < NUM_CASELLE; x++) {
            for (int y = 0; y < NUM_CASELLE; y++) {
                if (griglia[x][y].is_valore_zero()) {
                    return false;
                }
            }
        }
        return true;
    }
     
    private boolean posso_muovere() {
        for (int x = 0; x < NUM_CASELLE; x++) {
            for (int y = 0; y < (NUM_CASELLE - 1); y++) {
                int yy = y + 1;
                if (griglia[x][y].get_valore() == griglia[x][yy].get_valore()) {
                    return true;
                }
            }
        }
         
        for (int y = 0; y < NUM_CASELLE; y++) {
            for (int x = 0; x < (NUM_CASELLE - 1); x++) {
                int xx = x + 1;
                if (griglia[x][y].get_valore() == griglia[xx][y].get_valore()) {
                    return true;
                }
            }
        }
         
        return false;
    }
     
    public void aggiungi_casella() {
        int value = (num_random.nextInt(10) < 9) ?  2 : 4;
         
        boolean locationFound = false;
        while(!locationFound) {
            int x = num_random.nextInt(NUM_CASELLE);
            int y = num_random.nextInt(NUM_CASELLE);
            if (griglia[x][y].is_valore_zero()) {
                griglia[x][y].set_valore(value);
                locationFound = true;
            }
        }
         
        aggiorna_punteggio(0, value);
    }
     
    public boolean muovi_caselle_su() {
        boolean mosso = false;
         
        if (loop_su())  mosso = true;
         
        for (int x = 0; x < NUM_CASELLE; x++) {
            for (int y = 0; y < (NUM_CASELLE - 1); y++) {
                int yy = y + 1;
                mosso = combina_caselle(x, yy, x, y, mosso);
            }
        }
         
        if (loop_su())  mosso = true;
         
        return mosso;
    }
     
    private boolean loop_su() {
        boolean mosso = false;
         
        for (int x = 0; x < NUM_CASELLE; x++) {
            boolean continua = false;
            do {
                continua = false;
                for (int y = 0; y < (NUM_CASELLE - 1); y++) {
                    int yy = y + 1;
                    boolean casella_spostata = muovi_casella(x, yy, x, y);
                    if (casella_spostata==true) {
                        continua = true;
                        mosso = true;
                    }
                }
            } while (continua==true);      
        }
         
        return mosso;
    }
     
    public boolean muovi_caselle_giu() {
        boolean mosso = false;
         
        if (loop_giu())    mosso = true;
         
        for (int x = 0; x < NUM_CASELLE; x++) {
            for (int y = NUM_CASELLE - 1; y > 0; y--) {
                int yy = y - 1;
                mosso = combina_caselle(x, yy, x, y, mosso);
            }
        }
         
        if (loop_giu())    mosso = true;
         
        return mosso;
    }
     
    private boolean loop_giu() {
        boolean mosso = false;
         
        for (int x = 0; x < NUM_CASELLE; x++) {
            boolean continua = false;
            do {
                continua = false;
                for (int y = 0; y < NUM_CASELLE - 1; y++) {
                    int yy = y + 1;
                    boolean casella_spostata = muovi_casella(x, y, x, yy);
                    if (casella_spostata) {
                        continua = true;
                        mosso = true;
                    }
                }
            } while (continua==true);      
        }
         
        return mosso;
    }
     
    public boolean muovi_caselle_sx() {
        boolean mosso = false;
         
        if (loop_sx())    mosso = true;
         
        for (int y = 0; y < NUM_CASELLE; y++) {
            for (int x = 0; x < (NUM_CASELLE - 1); x++) { //faccio fino a (NUM_CASELLE-1) perchè sennò sfora sul combine
                int xx = x + 1; //per poter far bene il combine cell
                mosso = combina_caselle(xx, y, x, y, mosso);
            }
        }
         
        if (loop_sx())    mosso = true;
         
        return mosso;
    }
     
    private boolean loop_sx() { 
        boolean mosso = false;
         
        for (int y = 0; y < NUM_CASELLE; y++) {
            boolean continua = false;
            do {
                continua = false;
                for (int x = 0; x < (NUM_CASELLE - 1); x++) {
                    int xx = x + 1;
                    boolean casella_spostata = muovi_casella(xx, y, x, y);
                    if (casella_spostata) {
                        continua = true;
                        mosso = true;
                    }
                }
            } while (continua); //fintanto sposto qualcosa
        }
         
        return mosso;
    }
     
    public boolean muovi_caselle_dx() {
        boolean mosso = false;
         
        if (loop_dx())   mosso = true;
         
        for (int y = 0; y < NUM_CASELLE; y++) {
            for (int x = 0; x < (NUM_CASELLE - 1); x++) {
                int xx = x + 1;
                mosso = combina_caselle(x, y, xx, y, mosso);
            }
        }
         
        if (loop_dx())   mosso = true;
         
        return mosso;
    }
 
    private boolean loop_dx() {
        boolean mosso = false;
         
        for (int y = 0; y < NUM_CASELLE; y++) {
            boolean continua = false;
            do {
                continua = false;
                for (int x = 0; x < (NUM_CASELLE - 1); x++) {
                    int xx = x + 1;
                    boolean casella_spostata = muovi_casella(x, y, xx, y);
                    if (casella_spostata) {
                        continua = true;
                        mosso = true;
                    }
                }
            } while (continua);     
        }
         
        return mosso;
    }
     
    private boolean combina_caselle(int x1, int y1, int x2, int y2, boolean mosso) {
        if (!griglia[x1][y1].is_valore_zero()) {
            int value = griglia[x1][y1].get_valore();
            if (griglia[x2][y2].get_valore() == value) { //quindi posso unirle
                int nuovo_valore = value + value;
                griglia[x2][y2].set_valore(nuovo_valore);
                griglia[x1][y1].set_valore(0);
                aggiorna_punteggio(nuovo_valore, nuovo_valore);
                mosso = true;
            }
        }
        return mosso;
    }
     
    private boolean muovi_casella(int x1, int y1, int x2, int y2) {
        boolean muovi = false;
        if (griglia[x1][y1].is_valore_zero()==false && (griglia[x2][y2].is_valore_zero()==true)) {
            int value = griglia[x1][y1].get_valore();
            griglia[x2][y2].set_valore(value);
            griglia[x1][y1].set_valore(0);
            muovi = true;
        }
        return muovi;
    }
    
    public void imposta_punteggio() {
        if(miglior_punteggio_corrente > miglior_punteggio)
            miglior_punteggio = miglior_punteggio_corrente;

        if(miglior_casella_corrente > miglior_casella)
            miglior_casella = miglior_casella_corrente;

        miglior_punteggio_corrente = 0;
        miglior_casella_corrente = 0;
    }
     
    private void aggiorna_punteggio(int valore, int valore_casella) {
        miglior_punteggio_corrente += valore;
        miglior_casella_corrente = (valore_casella > miglior_casella_corrente) ? 
                valore_casella : miglior_casella_corrente;
    }
     
    public Casella get_casella(int x, int y) {
        return griglia[x][y];
    }
     
    public int get_miglior_punteggio() {
        return miglior_punteggio;
    }
 
    public void set_miglior_punteggio(int highScore) {
        this.miglior_punteggio = highScore;
    }
    
    public int get_miglior_casella() {
        return miglior_casella;
    }
 
    public void set_miglior_casella(int highCell) {
        this.miglior_casella = highCell;
    }
 
    public int get_miglior_punteggio_corrente() {
        return miglior_punteggio_corrente;
    }
 
    public int get_miglior_casella_corrente() {
        return miglior_casella_corrente;
    }
    
    public boolean puoi_muovere() {
        return puoi_muovere;
    }
 
    public void set_puoi_muovere(boolean puoi_muovere) {
        this.puoi_muovere = puoi_muovere;
    }
    
    public Dimension get_dimesione_griglia() {
        int width = NUM_CASELLE * Casella.get_larghezza_casella() + SPAZIATURA_CASELLE * 5;
        return new Dimension(width, width);
    }
     
    public void disegna_griglia(Graphics g) {
        g.setColor(new Color(ColorUtil.color_griglia));
        Dimension d = get_dimesione_griglia();
        g.fillRect(0, 0, d.width, d.height);

        for (int x = 0; x < NUM_CASELLE; x++) {
            for (int y = 0; y < NUM_CASELLE; y++) {
                griglia[x][y].disegna_casella(g); 
            }
        }
    }
 
}
