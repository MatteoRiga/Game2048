/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2048.properties;

import game2048.model.Game2048Model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScoreManager {

	// CURRENT SCORES
	private int highScore;
	private int highCell;

	// File
	private String filePath;
	private String temp;

        private Game2048Model model;
        
	public ScoreManager(Game2048Model model) {
            
		try {
			filePath = new File("").getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		temp = "TEMP.tmp";

		this.model = model;
	}
         
       //posso togliere
	public void reset() {
		File f = new File(filePath, temp);
		if (f.isFile()) {
			f.delete();
		}
		highScore = 0;
                highCell = 0;

	}

	private void createFile() {
		FileWriter output = null;
		try {
			File f = new File(filePath, temp);
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
			File f = new File(filePath, temp);
			output = new FileWriter(f);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write("" + Integer.toString(model.getHighScore()));
			writer.newLine();
			writer.write("" + Integer.toString(model.getHighCell()));
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
                
	}

	public void loadGame() {
		try {
			File f = new File(filePath, temp);

			if (!f.isFile()) {
				createFile();
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
			highScore = Integer.parseInt(reader.readLine());
			highCell = Integer.parseInt(reader.readLine());
                        model.setHighScore(highScore);
                        model.setHighCell(highCell);
			reader.close();
		} catch (IOException | NumberFormatException e) {
		}
	}

	public int getCurrentHighScore() {
		return highScore;
	}

	public void setCurrentHighScore(int currentScore) {
		this.highScore = currentScore;
	}

	public int getCurrentHighCell() {
		return highCell;
	}

	public void setCurrentHighCell(int currentTopScore) {
		this.highCell = currentTopScore;
	}


}