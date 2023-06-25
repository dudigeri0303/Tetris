package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

//A T alakazatot leíró osztály
public class Tshape extends Shapes{
	//Konstruktor
	public Tshape(){
		super(Color.RED, new Vektor(4, 0) , new Vektor(-1, 0), new Vektor(1, 0), new Vektor(0, 1), true);
		this.isRotateableVektorList = new ArrayList<Vektor>(Arrays.asList(new Vektor(-1, 0), new Vektor(0, 1), new Vektor(1, 0), new Vektor(0, -1)));	
	}
}
	
