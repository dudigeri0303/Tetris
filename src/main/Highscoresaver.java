package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

//A io műveleteket megvalósító osztály (legmagasabb elért pont)
public class Highscoresaver{
	//Attrinútumok
	private int highscore;
	private String fileName;
	
	//Konstruktor
	public Highscoresaver(String fileName) {
		this.fileName = fileName;
		this.readFile();
	}
	
	//Getter
	public int getHighscore() {
		return this.highscore;
	}
	
	//Fájlolvasás
	public void readFile() {
		try {
			FileReader fileReader = new FileReader(this.fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while (true) {
				String lineValue = bufferedReader.readLine();
				if (lineValue != null) {
					this.highscore = Integer.parseInt(lineValue);
				}
				else {
					break;
				}
			}
			fileReader.close();
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Fájlírás
	public void writeFile(int newscore) {
		try {
			FileWriter fileWriter = new FileWriter(this.fileName, false);
			fileWriter.write(Integer.toString(newscore));
			fileWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	//Rekord megjelenítése
	public void drawHighScore(Graphics2D g) {
		g.setColor(Color.yellow);
		g.drawString("HighScore: " + Integer.toString(this.getHighscore()), 225, 750);
	}
}
