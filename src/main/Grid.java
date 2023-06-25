package main;

import java.awt.Color;
import java.awt.Graphics2D;

//Egy cellát leíró osztály
public class Grid {
	//Attribútumok
	private final int size; 
	private Color colr;
	private Vektor vektor;
	private boolean free;
	
	//Konstruktor
	public Grid(Vektor vektor, Color colr, boolean free){
		this.size = 35;
		this.colr = colr;
		this.vektor = vektor;
		this.free = free;
	}
	
	//Létrehoz egy, a pályát alkotó cellát
	public String toString() {
		String leiras = " "; //(Integer.toString(this.height) + "-" + Integer.toString(this.width) + "-" + Integer.toString(this.indy) + "-" + Integer.toString(this.indx) + "-" + this.free );
		return leiras;
	}
	
	//Getterek
	public Vektor getVektor() {
		return this.vektor;
	}
	
	public Color getColor() {
		return this.colr;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public boolean getFree() {
		return this.free;
	}
	
	//Setterek
	public void setColor(Color c) {
		this.colr = c;
	}
	
	public void setVektor(Vektor v) {
		this.vektor = v;
	}
	
	//Felszabadít vagy foglaltá tesz egy mezőt a pályán
	public void setFree(boolean b) {
		this.free = b;
	}
	
	//Megrajzol egy négyzetet
	public void drawGrid(Graphics2D g) {
		//g.setColor(this.colr);
		g.fillRect(this.vektor.getX() * this.size, this.vektor.getY() * this.size, this.size -1, this.size -1);
	}
}