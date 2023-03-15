package View;

import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import engine.Game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Popup;
import javax.swing.PopupFactory;

public class View extends JFrame {
	private static ActionListener listener;
	private JPanel board;

	public View(ActionListener l) throws IOException {

		Intro i = new Intro(l);

		this.setTitle("Marvel ultimate wars");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(50, 50, 800, 600);
		setVisible(true);
		this.board = new JPanel();
		this.add(this.board);

		
	}

	public void error(Exception e) {
		JOptionPane.showMessageDialog(this, e.getMessage());
	}

	public static void main(String[] args) throws IOException {
		View e = new View(listener);
	}
}