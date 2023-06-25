package main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

//L alakú elem 2
public class Lshape2 extends Shapes{
	//Konstuktor
	public Lshape2(){
		super(Color.GRAY, new Vektor(4, 1) , new Vektor(0, -1), new Vektor(0, 1), new Vektor(-1, 1), true);
		this.isRotateableVektorList = new ArrayList<Vektor>(Arrays.asList(new Vektor(-1, 0), new Vektor(-1, 1), new Vektor(0, 1), new Vektor(1, 1), new Vektor(1, 0), new Vektor(1, -1), new Vektor(0, -1), new Vektor(-1, -1)));		
	}
}