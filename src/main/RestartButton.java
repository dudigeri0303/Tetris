package main;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

//Az újraindítást megvalósító gomb
public class RestartButton extends JButton {
	//Konstruktor
	public RestartButton() {
		super();
		this.setBounds(125, 710, 75, 25);
		this.setText("Restart");
		this.setFont(new Font("Comic Sans", Font.BOLD, 10));
		this.setHorizontalTextPosition(JButton.LEFT);
		this.setForeground(Color.black);
		this.setBackground(Color.yellow);
	}
}
