package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

//Az alakzatotak leíró absztrakt osztály
public abstract class Shapes {
	//Attribútumok
	protected Color color;
	protected Grid centerGrid;
	protected Vektor baseVektor, edgeVektor1, edgeVektor2, edgeVektor3;
	protected Grid[] elementList;
	protected ArrayList<Vektor> isRotateableVektorList;
	protected ArrayList<ArrayList<Grid>> map;
	protected final int shapeSize;
	protected boolean rotateable, moveable;

	//Konstruktor
	public Shapes(Color color,  Vektor baseVektor, Vektor edgeVektor1, Vektor edgeVektor2, Vektor edgeVektor3, boolean rotateable){
		this.baseVektor = baseVektor;
		this.edgeVektor1 = edgeVektor1;
		this.edgeVektor2 = edgeVektor2;
		this.edgeVektor3 = edgeVektor3;

		this.color = color;
		this.elementList = new Grid[3];
		
		this.shapeSize = 4;
		this.rotateable = rotateable;
		this.moveable = true;
			
		this.centerGrid = new Grid(baseVektor, this.color, false);
	
		this.elementList[0] = new Grid(this.centerGrid.getVektor().addVektor(this.edgeVektor1), this.color, false);
		this.elementList[1] = new Grid(this.centerGrid.getVektor().addVektor(this.edgeVektor2), this.color, false);
		this.elementList[2] = new Grid(this.centerGrid.getVektor().addVektor(this.edgeVektor3), this.color, false);
	}
	
	//Visszatér a Grid-eket tartalmazó listával
	public Grid[] getElementlist() {
		return this.elementList;
	}
	
	////Visszatér a Grid-eket tartalmazó listával
	public Grid getElement(int index) {
		return this.elementList[index];
	}
	
	public Grid getCenter() {
		return this.centerGrid;
	}
	
	public void setMap(ArrayList<ArrayList<Grid>> map) {
		this.map = map;
	}
	
	//Az elemet mozgatja lefele, a Gidek y indexének növelésével
	public void fall() {
		this.centerGrid.setVektor(this.centerGrid.getVektor().addVektor(new Vektor(0, 1)));
	}
	
	public void updateList() {
		this.elementList[0] = new Grid(this.centerGrid.getVektor().addVektor(this.edgeVektor1), this.color, false);
		this.elementList[1] = new Grid(this.centerGrid.getVektor().addVektor(this.edgeVektor2), this.color, false);
		this.elementList[2] = new Grid(this.centerGrid.getVektor().addVektor(this.edgeVektor3), this.color, false);
		
	}
	
	//Jobbra mozgatja az elemet
	public void moveRight() {
		if (this.moveable == true){
			this.centerGrid.setVektor(this.centerGrid.getVektor().addVektor(new Vektor(1, 0)));
		}	
	}
	
	//Balra mozgatja az elemet
	public void moveLeft() {
		if (this.moveable == true) {
			this.centerGrid.setVektor(this.centerGrid.getVektor().addVektor(new Vektor(-1, 0)));
		} 
	}
	
	//A forgathatóságot tesztelő algo.
	public boolean isRotateable() {
		boolean check = true;
		for (int i = 0; i < this.isRotateableVektorList.size(); i++ ) {
			Vektor checkVektor = this.isRotateableVektorList.get(i);
			checkVektor = this.centerGrid.getVektor().addVektor(checkVektor);
			if (checkVektor.getX() > 9 | checkVektor.getX() < 0 | checkVektor.getY() < 0 | checkVektor.getY() > 19) {
				check = false;
			}
			else if(this.map.get(checkVektor.getY()).get(checkVektor.getX()).getFree() == false) {
				check = false;	
			}
		}
		return check;
	}
	
	//Alakzat forgatása
	public void rotateShape() {
		this.moveable = false;
		if (this.rotateable == true && this.isRotateable() == true ) {
			this.edgeVektor1.rotateVektor();
			this.edgeVektor2.rotateVektor();
			this.edgeVektor3.rotateVektor();
		}
		this.moveable = true;
	}
	
	//Megrajzolja az alakzatot, minden elemre meghívva a drawGrid fv-t.
	public void drawShape(Graphics2D g) {
		g.setColor(this.color);
		this.centerGrid.drawGrid(g);
		
		for (int i = 0; i < this.shapeSize-1; i++) {
			this.elementList[i].drawGrid(g);
		}
	}
	
	//Leellenőrzi, hogy az elem a pálya aljára ért e.
	public boolean checkBottom() {
		boolean check = false;
		if (this.centerGrid.getVektor().getY() >= 19) {
			check = true;
		}
		
		for (int i = 0; i < this.shapeSize-1; i++) {
			if (this.elementList[i].getVektor().getY() >= 19 ) {
				check = true;
			}
		}
		return check;
	}
	
	//Ellenőrzi, hogy jobbra a pálya széle van e.
	public boolean checkRightEdged() {
		boolean check = false;
		if (this.centerGrid.getVektor().getX() >= 9) {
			check = true;
		}
		else if (this.map.get(centerGrid.getVektor().getY()).get(centerGrid.getVektor().getX()+1).getFree() == false) {
			check = true;
		}
		
		for (int i = 0; i < this.shapeSize-1; i++) {
			if (this.elementList[i].getVektor().getX() >= 9 ) {
				check = true;
			}
			else if (this.map.get(this.elementList[i].getVektor().getY()).get(this.elementList[i].getVektor().getX()+1).getFree() == false) {
				check = true;
			}
		}
		return check;
	}
	
	//Ellenőrzi, hogy balra a pálya széle van e.
	public boolean checkLeftEdged() {
		boolean check = false;
		if (this.centerGrid.getVektor().getX() <= 0) {
			check = true;
		}
		else if (this.map.get(centerGrid.getVektor().getY()).get(centerGrid.getVektor().getX()-1).getFree() == false) {
			check = true;
		}
		
		for (int i = 0; i < this.shapeSize-1; i++) {
			if (this.elementList[i].getVektor().getX() <= 0 ) {
				check = true;
			}
			else if (this.map.get(this.elementList[i].getVektor().getY()).get(this.elementList[i].getVektor().getX()-1).getFree() == false) {
				check = true;
			}
		}
		return check;
	}
	
	//Leellenőrzi, hogy az elem allatt van e olyan cella,ami már "helyre került"
	public boolean isStacked(ArrayList<ArrayList<Grid>> list) {
		boolean check = false;
		if (list.get(this.centerGrid.getVektor().getY()+1).get(this.centerGrid.getVektor().getX()).getFree() == false & this.centerGrid.getVektor().getY() + 1 <= 19 ) {
			check = true;
		}
		for (int i = 0; i < this.shapeSize-1; i++) {	
			if (list.get(this.elementList[i].getVektor().getY()+1).get(this.elementList[i].getVektor().getX()).getFree() == false & this.elementList[i].getVektor().getY() + 1 <= 19 ) {
					check = true;
			}
		}
		return check;
	}
	
	//Lefoglalja az elem helyét a pályán
	public void lock(ArrayList<ArrayList<Grid>> list) {
		this.moveable = false;
		this.rotateable = false;
		list.get(this.centerGrid.getVektor().getY()).get(this.centerGrid.getVektor().getX()).setFree(false);
		list.get(this.centerGrid.getVektor().getY()).get(this.centerGrid.getVektor().getX()).setColor(this.centerGrid.getColor());
		for (int i = 0; i < this.shapeSize-1; i++) {
			list.get(this.elementList[i].getVektor().getY()).get(this.elementList[i].getVektor().getX()).setFree(false);
			list.get(this.elementList[i].getVektor().getY()).get(this.elementList[i].getVektor().getX()).setColor(this.elementList[i].getColor());
		}
	}
}

