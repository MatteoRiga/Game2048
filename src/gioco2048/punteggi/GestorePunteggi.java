package gioco2048.punteggi;

import gioco2048.model.ModelloGioco;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class GestorePunteggi {

	private int miglior_punteggio;
	private int miglior_casella;

	// File
	private String path_file;
	private String temp;

        private ModelloGioco modello_gioco;
        
	public GestorePunteggi(ModelloGioco model) {
            
		try {
			path_file = new File("").getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		temp = "TEMP.tmp";

		this.modello_gioco = model;
	}
         
	private void crea_file() {
		FileWriter output = null;
		try {
			File f = new File(path_file, temp);
			output = new FileWriter(f);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write("" + 0);
			writer.newLine();
			writer.write("" + 0);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void salva_gioco() {
		FileWriter output = null;
		try {
			File f = new File(path_file, temp);
			output = new FileWriter(f);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write("" + Integer.toString(modello_gioco.get_miglior_punteggio()));
			writer.newLine();
			writer.write("" + Integer.toString(modello_gioco.get_miglior_casella()));
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
                
	}

	public void carica_gioco() {
		try {
			File f = new File(path_file, temp);

			if (!f.isFile()) {
				crea_file();
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			miglior_punteggio = Integer.parseInt(reader.readLine());
			miglior_casella = Integer.parseInt(reader.readLine());
                        modello_gioco.set_miglior_punteggio(miglior_punteggio);
                        modello_gioco.set_miglior_casella(miglior_casella);
			reader.close();
		} catch (IOException | NumberFormatException e) {
		}
	}

	public int getCurrentHighScore() {
		return miglior_punteggio;
	}

	public void setCurrentHighScore(int currentScore) {
		this.miglior_punteggio = currentScore;
	}

	public int getCurrentHighCell() {
		return miglior_casella;
	}

	public void setCurrentHighCell(int currentTopScore) {
		this.miglior_casella = currentTopScore;
	}


}