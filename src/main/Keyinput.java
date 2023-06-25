package main;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

public class Keyinput implements KeyListener {
	
	private boolean up, left, right, space;
	private int wait;
	
	public void keyTyped(KeyEvent e) {	
	}
	
	public Keyinput() {
		this.wait = 300;
	}
	
	public void setWait(int wait) {
		this.wait = wait;
	}
	
	public int getWait() {
		return this.wait;
	}
    
	//Billentyű lenyomásra történő események
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_UP) {
			up = true;
		}
		else if (code == KeyEvent.VK_LEFT) {
			left = true;
		}
		
		else if (code == KeyEvent.VK_RIGHT) {
			right = true;
		}
		
		else if (code == KeyEvent.VK_SPACE) {
			space = true;
		}
	}
	
	//Billentyű felengedésre történő események
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_UP) {
			up = false;
		}
		else if (code == KeyEvent.VK_LEFT) {
			left = false;
		}
		else if (code == KeyEvent.VK_RIGHT) {
			right = false;
		}
		else if (code == KeyEvent.VK_SPACE) {
			space = false;
		}
	}
	
	//Billenytü event handler metódus (alakzatok mozgatásához)
	public void eventHandler(Shapes s){
		if (s.map != null) {
			if (this.left == true & s.checkLeftEdged() == false) {
				s.moveLeft();
			}
			if (this.right == true & s.checkRightEdged() == false) {
				s.moveRight();	
			}
			if (this.up == true) {
				s.rotateShape();	
			}
			if (this.space == true) {
				this.wait = 30;
			}
		}
	}
}
