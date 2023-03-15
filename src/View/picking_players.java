package View;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class picking_players extends JFrame  {
ActionListener controller;
	JPanel p = new JPanel();
	Choose_Leader c=new Choose_Leader(controller);
	JButton cap = new JButton("Captain America");

	JButton Electro = new JButton("Electro");
	JButton Hulk = new JButton("Hulk");// Iceman
	JButton Loki = new JButton("Loki");
	JButton Thor = new JButton("Thor");
	JButton Deadpool = new JButton("Deadpool");
	JButton Ghost_Rider = new JButton("Ghost Rider");
	JButton Iceman = new JButton("Iceman");
	JButton Quicksilver = new JButton("Quicksilver");
	JButton Venom = new JButton("Venom");
	JButton Dr_Strange = new JButton("Dr Strange");
	JButton Hela = new JButton("Hela");
	JButton Ironman = new JButton("Ironman");
	JButton Spiderman = new JButton("Spiderman");
	JButton Yellow_Jacket = new JButton("Yellow Jacket");

	JButton cap2 = new JButton("Captain America");
	JButton Electro2 = new JButton("Electro");
	JButton Hulk2 = new JButton("Hulk");// Iceman
	JButton Loki2 = new JButton("Loki");
	JButton Thor2 = new JButton("Thor");
	JButton Deadpool2 = new JButton("Deadpool");
	JButton Ghost_Rider2 = new JButton("Ghost Rider");
	JButton Iceman2 = new JButton("Iceman");
	JButton Quicksilver2 = new JButton("Quicksilver");
	JButton Venom2 = new JButton("Venom");
	JButton Dr_Strange2 = new JButton("Dr Strange");
	JButton Hela2 = new JButton("Hela");
	JButton Ironman2 = new JButton("Ironman");
	JButton Spiderman2 = new JButton("Spiderman");
	JButton Yellow_Jacket2 = new JButton("Yellow Jacket");

	JLabel first = new JLabel("First Player pick team");
	JLabel Second = new JLabel("second Player pick team");
JLabel des=new  JLabel("");
	JPanel data=new  JPanel();
	ActionListener Listener;

	
	JButton b100=new JButton("Show cap");
	JButton b200 = new JButton("Show Electro");
	JButton b300 = new JButton("Show Hulk");// Iceman
	JButton b400 = new JButton("Show Loki");
	JButton b500 = new JButton("Show Thor");
	JButton b600 = new JButton("Show Deadpool");
	JButton b700 = new JButton("Show Ghost Rider");
	JButton b800 = new JButton("Show Iceman");
	JButton b900 = new JButton("Show Quicksilver");
	JButton b1000 = new JButton("Show Venom");
	JButton b1100 = new JButton("Show Dr Strange");
	JButton b1200 = new JButton("Show Hela");
	JButton b1300 = new JButton("Show Ironman");
	JButton b1400 = new JButton("Show Spiderman");
	JButton b1500 = new JButton("Show Yellow Jacket");
	JButton save = new JButton("Save");

	
	
	public picking_players(ActionListener controller)
	{
		this.controller = controller;
		this.setSize(1600, 780);
		this.setLocation(0, 0);
		this.setTitle("Pick Champions");
		this.setVisible(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(1, 1));
		p.setBackground(Color.black);
		this.add(p);
		p.setLayout(null);

p.add(data);

		p.add(cap);
		p.add(Electro);
		p.add(Hulk);
		p.add(Loki);
		p.add(Thor);
		p.add(Deadpool);
		p.add(Ghost_Rider);
		p.add(Iceman);
		p.add(Quicksilver);
		p.add(Venom);
		p.add(Dr_Strange);
		p.add(Hela);
		p.add(Ironman);
		p.add(Spiderman);
		p.add(Yellow_Jacket);

		p.add(cap2);
		p.add(Electro2);
		p.add(Hulk2);
		p.add(Loki2);
		p.add(Thor2);
		p.add(Deadpool2);
		p.add(Ghost_Rider2);
		p.add(Iceman2);
		p.add(Quicksilver2);
		p.add(Venom2);
		p.add(Dr_Strange2);
		p.add(Hela2);
		p.add(Ironman2);
		p.add(Spiderman2);
		p.add(Yellow_Jacket2);

		p.add(first);
		p.add(Second);
		first.setForeground(Color.cyan);
		Second.setForeground(Color.cyan);
		first.setBounds(50, 20, 200, 30);

		Second.setBounds(1335, 20, 200, 30);

		cap.setBackground(Color.cyan);
		Electro.setBackground(Color.cyan);
		Hulk.setBackground(Color.cyan);
		Loki.setBackground(Color.cyan);
		Thor.setBackground(Color.cyan);
		Deadpool.setBackground(Color.cyan);
		Ghost_Rider.setBackground(Color.cyan);
		Iceman.setBackground(Color.cyan);
		Quicksilver.setBackground(Color.cyan);
		Venom.setBackground(Color.cyan);
		Dr_Strange.setBackground(Color.cyan);
		Hela.setBackground(Color.cyan);
		Ironman.setBackground(Color.cyan);
		Spiderman.setBackground(Color.cyan);
		Yellow_Jacket.setBackground(Color.cyan);

		
		
		
		
		
		cap2.setBackground(Color.cyan);
		Electro2.setBackground(Color.cyan);
		Hulk2.setBackground(Color.cyan);
		Loki2.setBackground(Color.cyan);
		Thor2.setBackground(Color.cyan);
		Deadpool2.setBackground(Color.cyan);
		Ghost_Rider2.setBackground(Color.cyan);
		Iceman2.setBackground(Color.cyan);
		Quicksilver2.setBackground(Color.cyan);
		Venom2.setBackground(Color.cyan);
		Dr_Strange2.setBackground(Color.cyan);
		Hela2.setBackground(Color.cyan);
		Ironman2.setBackground(Color.cyan);
		Spiderman2.setBackground(Color.cyan);
		Yellow_Jacket2.setBackground(Color.cyan);

		
		b100.setBackground(Color.green);
		b200.setBackground(Color.green);
		b300.setBackground(Color.green);
		b400.setBackground(Color.green);
		b500.setBackground(Color.green);
		b600.setBackground(Color.green);
		b700.setBackground(Color.green);
		b800.setBackground(Color.green);
		b900.setBackground(Color.green);
		b1000.setBackground(Color.green);
		b1100.setBackground(Color.green);
		b1200.setBackground(Color.green);
		b1300.setBackground(Color.green);
		b1400.setBackground(Color.green);
		b1500.setBackground(Color.green);

		
		
		
		cap.setBounds(10, 50, 200, 25);
		Electro.setBounds(10, 85, 200, 25);
		Hulk.setBounds(10, 120, 200, 25);
		Loki.setBounds(10, 155, 200, 25);
		Thor.setBounds(10, 190, 200, 25);
		Deadpool.setBounds(10, 225, 200, 25);
		Ghost_Rider.setBounds(10, 260, 200, 25);
		Iceman.setBounds(10, 295, 200, 25);
		Quicksilver.setBounds(10, 330, 200, 25);
		Venom.setBounds(10, 365, 200, 25);
		Dr_Strange.setBounds(10, 400, 200, 25);
		Hela.setBounds(10, 435, 200, 25);
		Ironman.setBounds(10, 470, 200, 25);
		Spiderman.setBounds(10, 505, 200, 25);
		Yellow_Jacket.setBounds(10, 540, 200, 25);

		b100.setBounds(220 ,50,200 ,25);
		p.add(b100);
		
		b200.setBounds(220 ,85,200 ,25);
		p.add(b200);
		
		b300.setBounds(220 ,120,200 ,25);
		p.add(b300);
		
		b400.setBounds(220 ,155,200 ,25);
		p.add(b400);
		
		b500.setBounds(220 ,190,200 ,25);
		p.add(b500);
		
		b600.setBounds(220 ,225,200 ,25);
		p.add(b600);
		
		b700.setBounds(220 ,260,200 ,25);
		p.add(b700);
		
		b800.setBounds(220 ,295,200 ,25);
		p.add(b800);
		
		b900.setBounds(220 ,330,200 ,25);
		p.add(b900);
		
		b1000.setBounds(220 ,365,200 ,25);
		p.add(b1000);
		
		b1100.setBounds(220 ,400,200 ,25);
		p.add(b1100);
		
		b1200.setBounds(220 ,435,200 ,25);
		p.add(b1200);
		
		b1300.setBounds(220 ,470,200 ,25);
		p.add(b1300);
		
		b1400.setBounds(220 ,505,200 ,25);
		p.add(b1400);
	
		b1500.setBounds(220 ,540,200 ,25);
		p.add(b1500);
		
		
		b100.addActionListener(controller);
		b200.addActionListener(controller);
		b300.addActionListener(controller);
		b400.addActionListener(controller);
		b500.addActionListener(controller);
		b600.addActionListener(controller);
		b700.addActionListener(controller);
		b800.addActionListener(controller);
		b900.addActionListener(controller);
		b1000.addActionListener(controller);
		b1100.addActionListener(controller);
		b1200.addActionListener(controller);
		b1300.addActionListener(controller);
		b1400.addActionListener(controller);
		
		
		
		
		data.setBounds(430,50    ,850, 600   );
		data.setBackground(Color.cyan);
		data.setForeground(Color.black);
		data.setLayout(new GridLayout(1,1) );
		des.setForeground(Color.black);
	
		des.setBounds(50, 60, 800 ,550);
		data.add(des);	
	
	//continue des
		p.add(data);
		
		
		
		
		
		
		
		
		cap2.setBounds(1300, 50, 200, 25);
		Electro2.setBounds(1300, 85, 200, 25);
		Hulk2.setBounds(1300, 120, 200, 25);
		Loki2.setBounds(1300, 155, 200, 25);
		Thor2.setBounds(1300, 190, 200, 25);
		Deadpool2.setBounds(1300, 225, 200, 25);
		Ghost_Rider2.setBounds(1300, 260, 200, 25);
		Iceman2.setBounds(1300, 295, 200, 25);
		Quicksilver2.setBounds(1300, 330, 200, 25);
		Venom2.setBounds(1300, 365, 200, 25);
		Dr_Strange2.setBounds(1300, 400, 200, 25);
		Hela2.setBounds(1300, 435, 200, 25);
		Ironman2.setBounds(1300, 470, 200, 25);
		Spiderman2.setBounds(1300, 505, 200, 25);
		Yellow_Jacket2.setBounds(1300, 540, 200, 25);
		
		
		
		
		Quicksilver.addActionListener(controller);
		Quicksilver2.addActionListener(controller);
		
		cap.addActionListener(controller);
		cap2.addActionListener(controller);
		Electro.addActionListener(controller);
		Electro2.addActionListener(controller);
		Hulk2.addActionListener(controller);
		Hulk.addActionListener(controller);
		Thor2.addActionListener(controller);
		Thor.addActionListener(controller);
		Yellow_Jacket.addActionListener(controller);
		Yellow_Jacket2.addActionListener(controller);
		Hela.addActionListener(controller);
		Hela2.addActionListener(controller);
		Ghost_Rider2.addActionListener(controller);
		Ghost_Rider.addActionListener(controller);
		Deadpool2.addActionListener(controller);
		Deadpool.addActionListener(controller);
		Iceman2.addActionListener(controller);
		Iceman.addActionListener(controller);
		Spiderman.addActionListener(controller);
		Spiderman2.addActionListener(controller);

		Venom.addActionListener(controller);
		Venom2.addActionListener(controller);
		Loki2.addActionListener(controller);
		Loki.addActionListener(controller);
		Ironman.addActionListener(controller);
		Ironman2.addActionListener(controller);
		
		Dr_Strange2.addActionListener(controller);
		Dr_Strange.addActionListener(controller);

		p.add(save);
		save.setBounds(   700 ,680,200,50);
		save.setBackground(Color.cyan);
		save.addActionListener(controller);

		
		Choose_Leader c=new Choose_Leader(controller);

		
		
	}

	
	public JPanel getP() {
		return p;
	}

	public JButton getCap() {
		return cap;
	}

	public JButton getElectro() {
		return Electro;
	}

	public JButton getHulk() {
		return Hulk;
	}

	public JButton getLoki() {
		return Loki;
	}

	public JButton getThor() {
		return Thor;
	}

	public JButton getDeadpool() {
		return Deadpool;
	}

	public JButton getGhost_Rider() {
		return Ghost_Rider;
	}

	public JButton getIceman() {
		return Iceman;
	}

	public JButton getQuicksilver() {
		return Quicksilver;
	}

	public JButton getVenom() {
		return Venom;
	}

	public JButton getDr_Strange() {
		return Dr_Strange;
	}

	public JButton getHela() {
		return Hela;
	}

	public JButton getIronman() {
		return Ironman;
	}

	public JButton getSpiderman() {
		return Spiderman;
	}

	public JButton getYellow_Jacket() {
		return Yellow_Jacket;
	}

	public JButton getCap2() {
		return cap2;
	}

	public JButton getElectro2() {
		return Electro2;
	}

	public JButton getHulk2() {
		return Hulk2;
	}

	public JButton getLoki2() {
		return Loki2;
	}

	public JButton getThor2() {
		return Thor2;
	}

	public JButton getDeadpool2() {
		return Deadpool2;
	}

	public JButton getGhost_Rider2() {
		return Ghost_Rider2;
	}

	public JButton getIceman2() {
		return Iceman2;
	}

	public JButton getQuicksilver2() {
		return Quicksilver2;
	}

	public JButton getVenom2() {
		return Venom2;
	}

	public JButton getDr_Strange2() {
		return Dr_Strange2;
	}

	public JButton getHela2() {
		return Hela2;
	}

	public JButton getIronman2() {
		return Ironman2;
	}

	public JButton getSpiderman2() {
		return Spiderman2;
	}

	public JButton getYellow_Jacket2() {
		return Yellow_Jacket2;
	}

	public JLabel getFirst() {
		return first;
	}

	public JLabel getSecond() {
		return Second;
	}

	public static void main(String[] args) {

	}

}
