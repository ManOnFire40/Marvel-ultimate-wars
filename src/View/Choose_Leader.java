package View;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

public class Choose_Leader extends JFrame{

	ActionListener l;
//ActionListener controller
	JPanel p=new JPanel();
	JButton b1=new JButton();
	JButton b2=new JButton();
	JButton b3=new JButton();
	JButton b4=new JButton();
	JButton b5=new JButton();
	JButton b6=new JButton();
	board grid=new board(l);
	
	public Choose_Leader(ActionListener controller) 
	{
	this.l=controller;
	
	this.setSize(1600, 780);
	this.setLocation(0, 0);
	this.setTitle("Choose Leader");

	this.setVisible(false);
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	this.setLayout(new GridLayout(1, 1));
    this.add(p);
	p.setBackground(Color.black);
		
	p.setLayout(new GridLayout(2,3));	
		
p.add(b1);p.add(b2);p.add(b3);	
p.add(b4);p.add(b5);p.add(b6);	



b1.addActionListener(controller);
b2.addActionListener(controller);
b3.addActionListener(controller);
b4.addActionListener(controller);
b5.addActionListener(controller);
b6.addActionListener(controller);
board grid=new board(l);

	}
	
	
	
	
	
	public static void main(String[] args) {
	}

}
