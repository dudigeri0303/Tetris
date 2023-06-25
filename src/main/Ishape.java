package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

//Shapes leszármazottja, egy I alakot ír le
public class Ishape extends Shapes {
	//Konstruktor
	public Ishape(){
		super(Color.BLUE, new Vektor(4, 0) , new Vektor(-1, 0), new Vektor(1, 0), new Vektor(2, 0), true);	
		this.isRotateableVektorList = new ArrayList<Vektor>(Arrays.asList(new Vektor(-2, 0), new Vektor(-1, 0), new Vektor(0, 1), new Vektor(0, 2), new Vektor(1, 0), new Vektor(2, 0), new Vektor(0, -1), new Vektor(0, -2)));
	}	
}
