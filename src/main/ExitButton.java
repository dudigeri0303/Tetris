package main;

import java.awt.Color;

import java.awt.Font;

import javax.swing.JButton;

//A kilépést megvalósító gomb
public class ExitButton extends JButton {
	//Konstruktor
	public ExitButton() {
		super();
		this.setBounds(125, 740, 75, 25);
		this.setText("Exit");
		this.setFont(new Font("Comic Sans", Font.BOLD, 10));
		this.setHorizontalTextPosition(JButton.LEFT);
		this.setForeground(Color.black);
		this.setBackground(Color.yellow);
	}
}
