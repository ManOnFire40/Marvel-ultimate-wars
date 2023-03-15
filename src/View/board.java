package View;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import model.world.Direction;

import java.awt.event.ActionListener;

public class board extends JFrame{

	
	JPanel grid =new JPanel();
	
	
	JPanel butto =new JPanel();
	
	JButton up=new JButton("up");
	JButton down=new JButton("down");
	JButton left=new JButton("left");
	JButton right=new JButton("right");
	
	
	JButton attack=new JButton("Attack");
	JButton end=new JButton("End turn");
	
	JButton cast=new JButton("Cast");
	JLabel l=new JLabel();

	JButton [][] buttGrid=new JButton [5][5];	
	
	
	
	
	
 ActionListener	listen;
	JPanel data =new JPanel();
	
	
	
	
	JPanel turn=new JPanel();
	JPanel ccdata=new JPanel();
	
	JLabel turnCh=new JLabel();
	JLabel current=new JLabel("");
	
	
	//add action listner as parameter but after finishing the design
	JButton a1=new JButton();
	JButton a2=new JButton();
	JButton a3=new JButton();
	
	JButton ua1=new JButton("Use Leader ability");
	
	JButton move=new JButton("move");
	
	
	
	public  board(ActionListener	listen) //
	{
		this.listen=listen;
		this.setSize(1600, 780);
		this.setLocation(0, 0);
		this.setTitle("Choose Leader");
		this.setVisible(false);//reverse visibility
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
     this.setLayout(null);    
     
     butto.setBackground(Color.gray);
     butto.setLayout(null);
     this.add(butto);
     butto.setBounds ( 1300,0 ,300,getHeight() );

     butto.add(a1);
     butto.add(a2);
     butto.add(a3);
     
     butto.add(ua1);
     
     ua1.setBounds(10,210,200,50);
     ua1.setBackground(Color.green);
     
     
     
     butto.add(a1);
     butto.add(a2);
     butto.add(a3);
      a1.setBounds(10,350,200,50);
     a2.setBounds(10,410,200,50);
     a3.setBounds(10,470,200,50);
     a1.setBackground(Color.green);
     a2.setBackground(Color.green);
     a3.setBackground(Color.green);
     
     butto.add(move);
//     butto.setBounds(move);
      
     attack.setBounds (10,20,200,50);
     butto .add(attack);

     end.setBounds(10 ,80, 200 ,50);
     butto .add(end);

     cast.setBounds(10,140 ,200,50);
     butto .add(cast);

     attack.setBackground(Color.green);
     cast.setBackground(Color.green);
     end.setBackground(Color.green);
     
     up.setBackground(Color.green);
     down.setBackground(Color.green);
     left.setBackground(Color.green);
     right.setBackground(Color.green);
     
     
     up.setBounds(80,675  ,75,25); 
     down.setBounds(80,700  ,75,25); 
     left.setBounds(10,700  ,75,25); 
     right.setBounds(150,700  ,75,25); 
     
     up.addActionListener(listen);
     down.addActionListener(listen);
     right.addActionListener(listen);
     left.addActionListener(listen);

    butto .add(up);
    butto .add(down);
    butto .add(right);
    butto .add(left);
    butto .add(move);
    move.setBounds(10,540,200,50);
    move.setBackground(Color.green);
    move.addActionListener(listen);
    this.add(data);
    data.setBounds(0,0,300,getHeight());
     data.setBackground(Color.gray);
data.setLayout(new GridLayout (2,1));
     data.add(turn);
     data.add(ccdata);
     turn.setBackground(Color.cyan);
     ccdata.setBackground(Color.gray);
     //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
     turn.setLayout(new GridLayout(1,1));
     ccdata.setLayout(new GridLayout(1,1));
     
     turn.add(turnCh);
     ccdata.add(current);
     attack.addActionListener(listen);
     ua1.addActionListener(listen);
     this.add(grid);
     grid.setBounds(300,0,1000 ,getHeight());
	grid.setLayout(new GridLayout (5,5));	
    grid.setBackground(Color.black);
    
    a1.addActionListener(listen);
    a2.addActionListener(listen);
    a3.addActionListener(listen);
    end.addActionListener(listen);
    cast.addActionListener(listen);
		
		
	for (int i = 0; i < 5; i++) {

		for (int j = 0; j < 5; j++) {

			JButton b = new JButton();
			grid.add(b);
			this.buttGrid[i][j] = b;

		}

	}
		
	}	

}
