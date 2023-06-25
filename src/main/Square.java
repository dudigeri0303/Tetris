package main;

import java.awt.Color;

//A négyzet alakzatot leíró osztály
public class Square extends Shapes{
	//Konstruktor
	public Square(){
		super(Color.GREEN, new Vektor(4, 0) , new Vektor(1, 0), new Vektor(0, 1), new Vektor(1, 1), false);
	}
}
	

