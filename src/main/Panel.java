package main;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable, ActionListener {
	//Attrinútumok
	private Thread gamehThread;
	
	private Container container;
	private Shapes element;
	
	private Gridmap gridMap;
	
	private Keyinput input;
	
	private RestartButton restartButton;
	private ExitButton exitButton;

	//private final int cellsize = 35;
	private final int mapwidth = 350;
	private final int mapheight = 780;
	
	//Panel objektum konstruktora
	public Panel() {
		this.container = new Container();
		this.element = container.newElement();
		this.gridMap = new Gridmap();
		this.input= new Keyinput();
		this.restartButton = new RestartButton();
		this.exitButton = new ExitButton();
		
		this.setPreferredSize(new Dimension(this.mapwidth, this.mapheight));
		this.setBackground(Color.black);
		this.addKeyListener(input);
		this.setFocusable(true);
		this.setLayout(null);
		
		this.add(this.restartButton);
		this.restartButton.addActionListener(this);
		
		this.add(this.exitButton);
		this.exitButton.addActionListener(this);
	}
	
	//Játék elindítása
	public void startGame() {
		this.gamehThread = new Thread(this);
		this.gamehThread.start();
	}
	//Játék újraindítása
	public void restartGame() {
		this.container = new Container();
		this.element = this.container.newElement();
		
		this.gridMap = new Gridmap();
		this.gridMap.setCounter(new Counter());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.restartButton) {
			this.restartGame();
		}
		else if (e.getSource() == this.exitButton) {
			System.exit(0);
		}
		this.restartButton.setFocusable(false);
		this.exitButton.setFocusable(false);
	}
	
	//Kezeli az aktuális alakzatot, aszerint, hogy épp lefele mozog e vagy helyre került
	public void shapeHandle() {
		if(gridMap.gameOver() == true) {
			if (gridMap.getCounter().getValue() > gridMap.getHighscoresaver().getHighscore()) {
				gridMap.getHighscoresaver().writeFile(gridMap.getCounter().getValue());
			}
		}
		if (element.checkBottom() == false & element.isStacked(gridMap.grids) == false){
			element.fall();
		}
		else {
			element.lock(gridMap.grids);
			input.setWait(300);
			container = new Container();
			element = container.newElement();	
		}
	}

	//Késleltetést megvalósító függvény
	public void sleepThread() {
		try {
			if (input.getWait() < 0) {
				input.setWait(0);
			}
			Thread.sleep((long)input.getWait());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//A gameloop
	@Override
	public void run() {
		while (gamehThread != null) {
			update();
			repaint();
			sleepThread();
		}
	}
	
	//Frissíti a pályán lévő elemek adatait
	public void update() {
		element.map = gridMap.getGrids();
		shapeHandle();
		input.eventHandler(element);
		gridMap.rowCounterAndRepairer();
		element.updateList();
	}
	
	@Override
	//Megrajzolja a pályát, az aktuáls lefele eső elemet és a pontszámlálót.
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
	
		this.gridMap.drawMap(g2);
		this.element.drawShape(g2);
		
		//g2.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		this.gridMap.getCounter().drawScore(g2);
		this.gridMap.getHighscoresaver().drawHighScore(g2);
		
		//Gameover szövegek kiírása, ha vége a játéknak
		if (this.gridMap.getGameover() == true) {
			g2.setColor(Color.black);
			g2.setFont(new Font("Comic Sans", Font.BOLD, 50));
			g2.drawString("Game Over!", 50, 100);
			
			g2.setColor(Color.black);
			g2.setFont(new Font("Comic Sans", Font.BOLD, 20));
			g2.drawString("Press the Restart or Exit button!", 25, 150);
		}
	}
}