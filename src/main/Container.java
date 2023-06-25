package main;

import java.util.ArrayList;
import java.util.Random;

//A formákar tároló objektum. Minden lehetséges formából egy van benne;
public class Container {
	//Attribútumok
	private ArrayList<Shapes> shapeList;
	private int containerSize;
	
	//Konstruktor
	public Container() {
		this.shapeList = new ArrayList<Shapes>();
		this.containerSize = 7;
		
		this.shapeList.add(new Ishape());
		this.shapeList.add(new Lshape());
		this.shapeList.add(new Lshape2());
		this.shapeList.add(new Square());
		this.shapeList.add(new Tshape());
		this.shapeList.add(new Zshape());
		this.shapeList.add(new Zshape2());	
	}
	
	//Egy random elemet választ ki a tárolóból
	public Shapes newElement() {
		Random random = new Random();
		int randind = random.nextInt(this.containerSize);
		return this.shapeList.get(randind);
	}
}
