package main;

import java.awt.Color;
import java.awt.Graphics2D;

//A számlálót megvalósító ozstály
public class Counter {
	//Attribútumok
	private int value;
	
	//Konstruktor
	public Counter() {
		this.value = 0;
	}
	
	//Value attribútum gettere
	public int getValue() {
		return this.value;
	}
	
	//Pont hozzáadása a számláló értékéhez
	public void addScore() {
		this.value += 100;
	}
	
	//Számláló megrajzolása
	public void drawScore(Graphics2D g) {
		g.setColor(Color.yellow);
		g.drawString("Score: " + Integer.toString(this.getValue()), 25, 750);
	}
}
