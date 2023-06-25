package main;

import java.awt.Color;

import java.awt.Graphics2D;
import java.util.ArrayList;

//A cellákból álló pálya
public class Gridmap {
	//Attribútumok
	ArrayList<ArrayList<Grid>> grids;
	private int width;
	private int height;
	private Counter counter;
	private Highscoresaver highscore;
	
	//Létrehozza a pályát alkotó gridek tömbjét
	public Gridmap() {
		this.grids = new ArrayList<ArrayList<Grid>>();
		this.width = 10;
		this.height = 21;
		this.counter = new Counter();
		this.highscore = new Highscoresaver("highscore.txt");
				
		for (int i = 0; i < this.height; i++) {
			this.grids.add(new ArrayList<Grid>());
			for (int k = 0; k < this.width ; k++) {
				Vektor vektor = new Vektor(k, i);
				this.grids.get(i).add(new Grid(vektor,  Color.white, true));
			}
		}
	}
	
	//Visszaadja, hog hány grid van a pályán széltiben
	public int getWidth() {
		return this.width;
	}
	
	//Visszaadja, hogy hány grid van a pályán magasságban
	public int getHeight() {
		return this.height;
	}
	//Getterek
	public ArrayList<ArrayList<Grid>> getGrids(){
		return this.grids;
	}
	
	public Counter getCounter() {
		return this.counter;
	}
	
	public Highscoresaver getHighscoresaver() {
		return this.highscore;
	}
	
	public boolean getGameover() {
		return this.gameOver();
	}
	
	//Setter
	public void setCounter(Counter c) {
		this.counter = c;
	}
	//A pálya kirajzolása
	public void drawMap(Graphics2D g) {
		for (int i = 0; i < this.getHeight(); i++) {
			for (int k = 0; k < this.getWidth() ; k++) {	
				if (i == this.getHeight()-1) {
					g.setColor(Color.BLACK);
				}
				else {
					g.setColor(this.grids.get(i).get(k).getColor());
				}
				this.grids.get(i).get(k).drawGrid(g);
			}
		}
	}
	
	//A sorok helyreállítása egy teljes sor után
	private void repairRow(int i) {
		for (int j = 0; j < this.width; j++ ) {
			this.grids.get(i).get(j).setFree(true);
			this.grids.get(i).get(j).setColor(Color.white);
			for (int l = i; l > 2; l--) {
				if (this.grids.get(l-1).get(j).getFree() == false) {
					this.grids.get(l).get(j).setFree(false);
					this.grids.get(l).get(j).setColor(this.grids.get(l-1).get(j).getColor());
					this.grids.get(l-1).get(j).setFree(true);
					this.grids.get(l-1).get(j).setColor(Color.white);
				}
			}	
		}
	}
	
	//Sorban lévő elemek megszámolása és 10 esetén a sorok helyreállítása
	public void rowCounterAndRepairer() {
		int counter = 0;
		for (int i = 0; i < this.height; i++) {
			for(int k = 0; k < this.width; k++ ) {
				if (this.grids.get(i).get(k).getFree() == false){
					counter += 1;
				}
			}
			if (counter == 10) {
				this.repairRow(i);
				this.counter.addScore();
			}
			counter = 0;	
		}
	}
	
	//A játék vége, ha a legfelső sorba kerül egy celle (free == false)
	public boolean gameOver() {
		boolean check = false;
		for (int i = 0; i<10; i++) {
			if (this.grids.get(0).get(i).getFree() == false) {
				check = true;
			}
		}
		return check;
	}
}