package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

//Z alakzatot leíró osztály
public class Zshape extends Shapes{
	//Létrehoz egy négyzet alakú elemet
	public Zshape(){
		super(Color.ORANGE, new Vektor(4, 0) , new Vektor(1, 0), new Vektor(0, 1), new Vektor(-1, 1), true);
		this.isRotateableVektorList = new ArrayList<Vektor>(Arrays.asList(new Vektor(-1, 0), new Vektor(-1, 1), new Vektor(0, 1), new Vektor(1, 1), new Vektor(1, 0), new Vektor(1, -1), new Vektor(0, -1), new Vektor(-1, -1)));
	}
}
