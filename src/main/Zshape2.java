package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

//Z alkazat 2
public class Zshape2 extends Shapes{
	//konstruktor
	public Zshape2(){
		super(Color.MAGENTA, new Vektor(5, 0) , new Vektor(-1, 0), new Vektor(0, 1), new Vektor(1, 1), true);
		this.isRotateableVektorList = new ArrayList<Vektor>(Arrays.asList(new Vektor(-1, 0), new Vektor(-1, 1), new Vektor(0, 1), new Vektor(1, 1), new Vektor(1, 0), new Vektor(1, -1), new Vektor(0, -1), new Vektor(-1, -1)));
	}
}
