package main;

import javax.swing.JFrame;
//A Main osztály
public class Main extends JFrame{
	//Ezt futtatva indul el a játékrr
	public static void main (String[] args) {
		//Új JFrame objektum 
		JFrame window = new JFrame("Tetris");
		//ablak bezárása kilépéskor
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ablakot nem lehet átmáretezni
		window.setResizable(false);
		//ablak mérete
		window.setSize(350, 700);
		
		//Új panel objektum
		Panel gamePanel = new Panel();
		//Panel hozzáadása az ablakhoz
		window.add(gamePanel);
		window.pack();
		
		//ablak középen legyen
		window.setLocationRelativeTo(null);
		
		//ablak látható legyen
		window.setVisible(true);
		
		//A panel run metódusát meghívva elindítja a játékot
		gamePanel.startGame();
	}
}