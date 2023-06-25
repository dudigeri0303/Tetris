package main;

//Egy vektort leíró osztály
public class Vektor {
	//Attribútumok
	private int x;
	private int y;
	
	//Konstruktor
	public Vektor(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//Setterek
	public void setX(int value) {
		this.x += value;
	}
	
	public void setY(int value) {
		this.y += value;
	}
	
	//Getterek
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	//Vektor összeadás
	public Vektor addVektor(Vektor v) {
		Vektor returnVektor = new Vektor(this.x + v.x, this.y + v.y);
		return returnVektor;
	}
	
	//Vektor forgatása 90 fokkal
	public void rotateVektor() {
		int temp = this.y;
		this.y = this.x;
		this.x = temp*(-1);
	}
}
