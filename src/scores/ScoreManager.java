/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scores;

import model.ModelloGioco;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScoreManager {

	// CURRENT SCORES
	private int miglior_punteggio;
	private int miglior_casella;

	// File
	private String path_file;
	private String temp;

        private ModelloGioco model;
        
	public ScoreManager(ModelloGioco model) {
            
		try {
			path_file = new File("").getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		temp = "TEMP.tmp";

		this.model = model;
	}
         
       //posso togliere
	public void reset() {
		File f = new File(path_file, temp);
		if (f.isFile()) {
			f.delete();
		}
		miglior_punteggio = 0;
                miglior_casella = 0;

	}

	private void createFile() {
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

	public void saveGame() {
		FileWriter output = null;
		try {
			File f = new File(path_file, temp);
			output = new FileWriter(f);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write("" + Integer.toString(model.get_miglior_punteggio()));
			writer.newLine();
			writer.write("" + Integer.toString(model.get_miglior_casella()));
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
                
	}

	public void loadGame() {
		try {
			File f = new File(path_file, temp);

			if (!f.isFile()) {
				createFile();
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			miglior_punteggio = Integer.parseInt(reader.readLine());
			miglior_casella = Integer.parseInt(reader.readLine());
                        model.set_miglior_punteggio(miglior_punteggio);
                        model.set_miglior_casella(miglior_casella);
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