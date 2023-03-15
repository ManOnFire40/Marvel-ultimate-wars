package View;

import javax.swing.*;

import engine.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.lang.ModuleLayer.Controller;

public class Intro extends JFrame    {
	ActionListener controller;
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JLabel l1 = new JLabel("First Player :");
	JLabel l2 = new JLabel("Second Player :");
	JPanel p = new JPanel();
	JButton b1 = new JButton("Save");
	JButton b2 = new JButton("remove");
	picking_players p1 =new picking_players(controller) ;
	Game game;

	public picking_players getP1() {
		return p1;
	}

	public Intro(ActionListener controller) {
		this.controller = controller;
		this.setTitle("Enter names");
		this.setSize(500, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(100, 50);
		this.setLayout(new GridLayout(1, 1));

		this.add(p);
		p.setBackground(Color.black);
		p.setLayout(null);

		p.add(t1);
		p.add(t2);
		p.add(l1);
		p.add(l2);
		p.add(b1);
		p.add(b2);

		l1.setForeground(Color.cyan);
		l2.setForeground(Color.cyan);
		b1.setBackground(Color.cyan);
		b2.setBackground(Color.cyan);

		l1.setBounds(50, 50, 100, 25);
		l2.setBounds(50, 80, 100, 25);

		t1.setBounds(160, 50, 200, 25);
		t2.setBounds(160, 80, 200, 25);

		b1.setBounds(160, 100, 100, 25);
		b2.setBounds(260, 100, 100, 25);

		b1.addActionListener(controller);
		b2.addActionListener(controller);

	}

	public JTextField getT1() {
		return t1;
	}

	public JTextField getT2() {
		return t2;
	}

	public static void main(String[] args) {

	}

//why not working 


}
