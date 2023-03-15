package View;

import java.awt.Font;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import engine.Game;
import engine.Player;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.world.Champion;
import model.world.Cover;
import model.world.Damageable;
import model.world.Direction;

public class controller implements ActionListener, KeyListener {
	Ability ability;
	Direction direction;
	int x;
	int y;
	private Intro view = new Intro(this);
	JFrame frame = new JFrame();
	
	Player p1;

	Player p2;

	boolean fl=true;

	public boolean checkfirst() {
		if (p1.getTeam().size() < 3)
			return true;
		else
			return false;
	}

	public boolean checksecond() {
		if (p2.getTeam().size() < 3)
			return true;
		else
			return false;
	}

	public controller() throws IOException {

		this.view = new Intro(this);
		p1 = new Player(view.getT1().getText());

		Player p2 = new Player(view.getT2().getText());
		;


		view.p1.Quicksilver.addActionListener(this);
		view.p1.Quicksilver2.addActionListener(this);

		view.p1.cap.addActionListener(this);
		view.p1.cap2.addActionListener(this);
		view.p1.Electro.addActionListener(this);
		view.p1.Electro2.addActionListener(this);
		view.p1.Hulk2.addActionListener(this);
		view.p1.Hulk.addActionListener(this);
		view.p1.Thor2.addActionListener(this);
		view.p1.Thor.addActionListener(this);
		view.p1.Yellow_Jacket.addActionListener(this);
		view.p1.Yellow_Jacket2.addActionListener(this);
		view.p1.Hela.addActionListener(this);
		view.p1.Hela2.addActionListener(this);
		view.p1.Ghost_Rider2.addActionListener(this);
		view.p1.Ghost_Rider.addActionListener(this);
		view.p1.Deadpool2.addActionListener(this);
		view.p1.Deadpool.addActionListener(this);
		view.p1.Iceman2.addActionListener(this);
		view.p1.Iceman.addActionListener(this);
		view.p1.Spiderman.addActionListener(this);
		view.p1.Spiderman2.addActionListener(this);
		view.p1.Venom.addActionListener(this);
		view.p1.Venom2.addActionListener(this);
		view.p1.Loki2.addActionListener(this);
		view.p1.Loki.addActionListener(this);
		view.p1.Ironman.addActionListener(this);
		view.p1.Ironman2.addActionListener(this);
	
		view.p1.Dr_Strange2.addActionListener(this);
		view.p1.Dr_Strange.addActionListener(this);

		// show description of hero ability need work
		view.p1.b100.addActionListener(this);
		view.p1.b200.addActionListener(this);
		view.p1.b300.addActionListener(this);
		view.p1.b400.addActionListener(this);
		view.p1.b500.addActionListener(this);

		view.p1.b600.addActionListener(this);
		view.p1.b700.addActionListener(this);
		view.p1.b800.addActionListener(this);
		view.p1.b900.addActionListener(this);
		view.p1.b1000.addActionListener(this);

		view.p1.b1100.addActionListener(this);
		view.p1.b1200.addActionListener(this);
		view.p1.b1300.addActionListener(this);
		view.p1.b1400.addActionListener(this);
		view.p1.b1500.addActionListener(this);

		// Choosing leaders
		view.p1.c.b1.addActionListener(this);
		view.p1.c.b2.addActionListener(this);
		view.p1.c.b3.addActionListener(this);
		view.p1.c.b4.addActionListener(this);
		view.p1.c.b5.addActionListener(this);
		view.p1.c.b6.addActionListener(this);
		view.p1.save.addActionListener(this);
		Game.loadAbilities("Abilities.csv");
		Game.loadChampions("Champions.csv");
		view.p1.c.grid.up.addActionListener(this);
		view.p1.c.grid.down.addActionListener(this);
		view.p1.c.grid.left.addActionListener(this);
		view.p1.c.grid.right.addActionListener(this);
		view.p1.c.grid.move.addActionListener(this);
		view.p1.c.grid.attack.addActionListener(this);
		view.p1.c.grid.ua1.addActionListener(this);
		view.p1.c.grid.end.addActionListener(this);
		view.p1.c.grid.a1.addActionListener(this);
		view.p1.c.grid.a2.addActionListener(this);
		view.p1.c.grid.a3.addActionListener(this);
		view.p1.c.grid.cast.addActionListener(this);
	}
		
	public String champ(int x) {
		String ret = "";

		ret = "Name :" + Game.getAvailableChampions().get(x).getName() + '\n' + "   ," + "mana cost :"
				+ Game.getAvailableChampions().get(x).getMana() + '\n' + "   ," + "attack damage :"
				+ Game.getAvailableChampions().get(x).getAttackDamage() + '\n' + "   ," + "attack Range :"
				+ Game.getAvailableChampions().get(x).getAttackRange() + '\n' + "   ," + "HP :"
				+ Game.getAvailableChampions().get(x).getCurrentHP() + '\n' + "   ," + "Abilites :" + '\n' + "   ";

		for (int i = 0; i < Game.getAvailableChampions().get(x).getAbilities().size(); i++) {
			ret += Game.getAvailableChampions().get(x).getAbilities().get(i).getName() + '\n' + "   ,";

		}

		return ret;
	}
	// problem with abilities

	@Override // note continue in rest of conditions
				// AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
	public void actionPerformed(ActionEvent e) {

		Champion temp = null;
// 

		// intro
		if (e.getSource() == view.b1 && view.t1.getText().length() != 0 && view.t2.getText().length() != 0) {

			String s1 = view.l1.getText() + view.t1.getText();
			String s2 = view.l2.getText() + view.t2.getText();
			view.p1.setVisible(true);
			view.setVisible(false);
			p1 = new Player(view.getT1().getText());
			p2 = new Player(view.getT2().getText());

		}

		if (e.getSource() == view.b1 && view.t1.getText().length() == 0 || view.t2.getText().length() == 0) {

			JOptionPane.showMessageDialog(view.b1, "you must enter names", "ERROR", JOptionPane.ERROR_MESSAGE);

		}

		if (e.getSource() == view.b2) {

			view.t1.setText("");
			view.t2.setText("");
		}

		// 0 cap
		// 1 deadpool
		// 2 Dr strange
		// 3 electro
		// 4 Ghost rider
		// 5 hela
		// 6 Hulk
		// 7 Iceman
		// 8 Iron Man
		// 9 loki
		// 10 Quicksilver
		// 11 Spider Man
		// 12 Thor
		// 13 Venom
		// 14 Yellow Jacket

		// show player
		if (e.getSource() == view.p1.b100) {

			view.p1.des.setText(champ(0));

		}

		if (e.getSource() == view.p1.b200) {
			view.p1.des.setText(champ((3)));

		}

		if (e.getSource() == view.p1.b300) {
			view.p1.des.setText(champ((6)));

		}

		if (e.getSource() == view.p1.b400) {
			view.p1.des.setText(champ((9)));

		}

		if (e.getSource() == view.p1.b500) {
			view.p1.des.setText(champ((12)));

		}

		if (e.getSource() == view.p1.b600) {
			view.p1.des.setText(champ((1)));

		}

		if (e.getSource() == view.p1.b700) {
			view.p1.des.setText(champ((4)));

		}

		if (e.getSource() == view.p1.b800) {
			view.p1.des.setText(champ((7)));

		}

		if (e.getSource() == view.p1.b900) {
			view.p1.des.setText(champ((10)));

		}
		if (e.getSource() == view.p1.b1000) {
			view.p1.des.setText(champ((13)));

		}
		if (e.getSource() == view.p1.b1100) {
			view.p1.des.setText(champ((2)));

		}
		if (e.getSource() == view.p1.b1200) {
			view.p1.des.setText(champ((5)));

		}
		if (e.getSource() == view.p1.b1300) {
			view.p1.des.setText(champ((8)));

		}
		if (e.getSource() == view.p1.b1400) {
			view.p1.des.setText(champ((11)));

		}
		if (e.getSource() == view.p1.b1500) {
			view.p1.des.setText(champ((14)));

		}

		if (e.getSource() == view.p1.cap && checkfirst()) {
			view.p1.cap2.setEnabled(false);
		}

		if (e.getSource() == view.p1.Electro && checkfirst()) {
			view.p1.Electro2.setEnabled(false);
		}
		if (e.getSource() == view.p1.Hulk && checkfirst()) {
			view.p1.Hulk2.setEnabled(false);
		}
		if (e.getSource() == view.p1.Loki && checkfirst()) {
			view.p1.Loki2.setEnabled(false);
		}
		if (e.getSource() == view.p1.Thor && checkfirst()) {
			view.p1.Thor2.setEnabled(false);
		}

		if (e.getSource() == view.p1.Deadpool && checkfirst()) {
			view.p1.Deadpool2.setEnabled(false);
		}
		if (e.getSource() == view.p1.Ghost_Rider && checkfirst()) {
			view.p1.Ghost_Rider2.setEnabled(false);
		}
		if (e.getSource() == view.p1.Iceman && checkfirst()) {
			view.p1.Iceman2.setEnabled(false);
		}
		if (e.getSource() == view.p1.Quicksilver && checkfirst()) {
			view.p1.Quicksilver2.setEnabled(false);
		}
		if (e.getSource() == view.p1.Venom && checkfirst()) {
			view.p1.Venom2.setEnabled(false);
		}
		if (e.getSource() == view.p1.Dr_Strange && checkfirst()) {
			view.p1.Dr_Strange2.setEnabled(false);
		}
		if (e.getSource() == view.p1.Hela && checkfirst()) {
			view.p1.Hela2.setEnabled(false);
		}
		if (e.getSource() == view.p1.Ironman && checkfirst()) {
			view.p1.Ironman2.setEnabled(false);
		}
		if (e.getSource() == view.p1.Spiderman && checkfirst()) {
			view.p1.Spiderman2.setEnabled(false);
		}
		if (e.getSource() == view.p1.Yellow_Jacket && checkfirst()) {
			view.p1.Yellow_Jacket2.setEnabled(false);
		}

		// second player

		if (e.getSource() == view.p1.cap2 && checksecond()) {
			view.p1.cap.setEnabled(false);
		}

		if (e.getSource() == view.p1.Electro2 && checksecond()) {
			view.p1.Electro.setEnabled(false);
		}
		if (e.getSource() == view.p1.Hulk2 && checksecond()) {
			view.p1.Hulk.setEnabled(false);
		}
		if (e.getSource() == view.p1.Loki2 && checksecond()) {
			view.p1.Loki.setEnabled(false);
		}
		if (e.getSource() == view.p1.Thor2 && checksecond()) {
			view.p1.Thor.setEnabled(false);
		}

		if (e.getSource() == view.p1.Deadpool2 && checksecond()) {
			view.p1.Deadpool.setEnabled(false);
		}
		if (e.getSource() == view.p1.Ghost_Rider2 && checksecond()) {
			view.p1.Ghost_Rider.setEnabled(false);
		}
		if (e.getSource() == view.p1.Iceman2 && checksecond()) {
			view.p1.Iceman.setEnabled(false);
		}
		if (e.getSource() == view.p1.Quicksilver2 && checksecond()) {
			view.p1.Quicksilver.setEnabled(false);
		}
		if (e.getSource() == view.p1.Venom2 && checksecond()) {
			view.p1.Venom.setEnabled(false);
		}
		if (e.getSource() == view.p1.Dr_Strange2 && checksecond()) {
			view.p1.Dr_Strange.setEnabled(false);
		}
		if (e.getSource() == view.p1.Hela2 && checksecond()) {
			view.p1.Hela.setEnabled(false);
		}
		if (e.getSource() == view.p1.Ironman2 && checksecond()) {
			view.p1.Ironman.setEnabled(false);
		}
		if (e.getSource() == view.p1.Spiderman2 && checksecond()) {
			view.p1.Spiderman.setEnabled(false);
		}
		if (e.getSource() == view.p1.Yellow_Jacket2 && checksecond()) {
			view.p1.Yellow_Jacket.setEnabled(false);
		}

		// picking players biggest problem in my code

		
		// b
		// e
		// g
		// i
		// n
		// beginingof

		// maxstart
		// s
		// ss
		// sss
		// ssss
		// sssss

		if (e.getSource() == view.p1.cap) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.cap, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == view.p1.Electro) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.Electro, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Hulk) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.Hulk, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == view.p1.Loki) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.Loki, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Thor) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.Thor, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == view.p1.Deadpool) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.Deadpool, "each player can have a maximum of 3 champions",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Ghost_Rider) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.Ghost_Rider, "each player can have a maximum of 3 champions",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Iceman) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.Iceman, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Quicksilver) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.Quicksilver, "each player can have a maximum of 3 champions",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Venom) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.Venom, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Dr_Strange && checkfirst()) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.Dr_Strange, "each player can have a maximum of 3 champions",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Hela) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.Hela, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Ironman) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.Ironman, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Spiderman) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.Spiderman, "each player can have a maximum of 3 champions",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Yellow_Jacket) {
			if (!(checkfirst())) {
				JOptionPane.showMessageDialog(view.p1.Yellow_Jacket, "each player can have a maximum of 3 champions",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}

		// second player

		if (e.getSource() == view.p1.cap2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.cap2, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == view.p1.Electro2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.Electro2, "each player can have a maximum of 3 champions",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Hulk2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.Hulk2, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Loki2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.Loki2, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Thor2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.Thor2, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == view.p1.Deadpool2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.Deadpool2, "each player can have a maximum of 3 champions",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Ghost_Rider2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "each player can have a maximum of 3 champions",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Iceman2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.Iceman2, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Quicksilver2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.Quicksilver2, "each player can have a maximum of 3 champions",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Venom2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.Venom2, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Dr_Strange2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.Dr_Strange2, "each player can have a maximum of 3 champions",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Hela2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.Hela2, "each player can have a maximum of 3 champions", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Ironman2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.Ironman2, "each player can have a maximum of 3 champions",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Spiderman2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.Spiderman2, "each player can have a maximum of 3 champions",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == view.p1.Yellow_Jacket2) {
			if (!(checksecond())) {
				JOptionPane.showMessageDialog(view.p1.Yellow_Jacket2, "each player can have a maximum of 3 champions",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}

		// maxend
		// s
		// ss
		// sss
		// ssss
		// sssss

		if (e.getSource() == view.getP1().getCap() && p1.getTeam().size() <= 3) {

			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(0)) {
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.cap.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.cap, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}

				}

			}

		}

		if (view.getP1().getCap2() == e.getSource() && p2.getTeam().size() <= 3) {
			boolean x = false;
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(0)) {
					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						JOptionPane.showMessageDialog(view.p1.cap2, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
						view.p1.cap2.setEnabled(false);

					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}

		}

		if (view.getP1().getElectro() == e.getSource() && p1.getTeam().size() <= 3) {
			boolean x = false;
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(3)) {
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Electro.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Electro, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);

					}
				}
			}
		}

		if (view.getP1().getElectro2() == e.getSource() && p2.getTeam().size() <= 3) {

			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(3)) {
					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Electro2.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Electro2, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}

				}
			}

		}

		if (view.getP1().getHulk() == e.getSource() && p1.getTeam().size() <= 3) {

			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(6)) {
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Electro.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Hulk, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}
		}

		if (view.getP1().getHulk2() == e.getSource() && p2.getTeam().size() <= 3) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(6)) {

					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Electro.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Hulk2, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}

				}
			}

		}

		if (view.getP1().getLoki() == e.getSource() && p1.getTeam().size() <= 3) {

			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(9)) {
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Loki.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Loki, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}

		}

		if (view.getP1().getLoki2() == e.getSource() && p2.getTeam().size() <= 3) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(9)) {
					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Loki2.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Loki2, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}

		}

		if (view.getP1().getThor() == e.getSource() && p1.getTeam().size() <= 3) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(12)) {
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Thor.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Thor, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}

				}
			}

		}

		if (view.getP1().getThor2() == e.getSource() && p2.getTeam().size() <= 3) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(12)) {
					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Thor2.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Thor2, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}

		}

		if (view.getP1().getDeadpool() == e.getSource() && p1.getTeam().size() <= 3) {

			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(1)) {
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Deadpool.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Deadpool, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}

		}

		if (view.getP1().getDeadpool2() == e.getSource() && p2.getTeam().size() <= 3) {

			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(1)) {
					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Deadpool2.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Deadpool2,
								"you can not  enter  champion more than 1 time", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}

		}

		if (view.getP1().getGhost_Rider() == e.getSource() && p1.getTeam().size() <= 3) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(4)) {
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Ghost_Rider.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Ghost_Rider,
								"you can not  enter  champion more than 1 time", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}

		}

		if (view.getP1().getGhost_Rider2() == e.getSource() && p2.getTeam().size() <= 3) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(4)) {
					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Ghost_Rider2.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Ghost_Rider2,
								"you can not  enter  champion more than 1 time", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}
		}

		if (view.getP1().getIceman() == e.getSource() && p1.getTeam().size() <= 3) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(7)) {
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Iceman.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Iceman, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}

		}

		if (view.getP1().getIceman2() == e.getSource() && p2.getTeam().size() <= 3) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(7))

				{
					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Iceman2.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Iceman2, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}

		}

		if (view.getP1().getQuicksilver() == e.getSource() && p1.getTeam().size() <= 3) {

			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(10)) {
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Quicksilver.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Quicksilver,
								"you can not  enter  champion more than 1 time", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}
		}

		if (view.getP1().getQuicksilver2() == e.getSource() && p2.getTeam().size() <= 3) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(10))

				{
					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Quicksilver2.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Quicksilver2,
								"you can not  enter  champion more than 1 time", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}

		}

		if (view.getP1().getVenom() == e.getSource() && p1.getTeam().size() <= 3) {

			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(13))

				{
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Venom.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Venom, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}

		}

		if (view.getP1().getVenom2() == e.getSource() && p2.getTeam().size() <= 3) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(13))

				{
					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Venom2.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Venom2, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}
		}

		if (view.getP1().getDr_Strange() == e.getSource() && p1.getTeam().size() <= 3) {

			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(2))

				{
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Dr_Strange.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Dr_Strange,
								"you can not  enter  champion more than 1 time", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}
		}

		if (view.getP1().getDr_Strange2() == e.getSource() && p2.getTeam().size() <= 3) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(2))

				{
					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Dr_Strange2.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Dr_Strange2,
								"you can not  enter  champion more than 1 time", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}
		}

		if (view.getP1().getHela() == e.getSource() && p1.getTeam().size() <= 3) {

			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(5)) {
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Hela.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Hela, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}
		}

		if (view.getP1().getHela2() == e.getSource() && p2.getTeam().size() <= 3) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(5))

				{
					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Hela2.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Hela2, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}
		}

		if (view.getP1().getIronman() == e.getSource() && p1.getTeam().size() <= 3) {

			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(8)) {
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Ironman.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Ironman, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}
		}

		if (view.getP1().getIronman2() == e.getSource() && p2.getTeam().size() <= 3) {

			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(8))

				{
					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Ironman2.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Ironman2, "you can not  enter  champion more than 1 time",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}

		}

		if (view.getP1().getSpiderman() == e.getSource() && p1.getTeam().size() <= 3) {

			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(11))

				{
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Spiderman.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Spiderman,
								"you can not  enter  champion more than 1 time", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}
		}

		if (view.getP1().getSpiderman2() == e.getSource() && p2.getTeam().size() <= 3) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(11))

				{
					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Spiderman2.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Spiderman2,
								"you can not  enter  champion more than 1 time", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}
		}

		if (view.getP1().getYellow_Jacket() == e.getSource() && p1.getTeam().size() <= 3) {
			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(14))

				{
					if (p1.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Yellow_Jacket.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Yellow_Jacket,
								"you can not  enter  champion more than 1 time", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p1.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}

			}

		}

		if (view.getP1().getYellow_Jacket2() == e.getSource() && p2.getTeam().size() <= 3) {

			for (int i = 0; i < Game.getAvailableChampions().size(); i++) {
				if (Game.getAvailableChampions().get(i) == Game.getAvailableChampions().get(14))

				{
					if (p2.getTeam().contains(Game.getAvailableChampions().get(i))) {
						view.p1.Yellow_Jacket2.setEnabled(false);
						JOptionPane.showMessageDialog(view.p1.Yellow_Jacket2,
								"you can not  enter  champion more than 1 time", "ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						p2.getTeam().add(Game.getAvailableChampions().get(i));
						temp = Game.getAvailableChampions().get(i);
					}
				}
			}
		}
		// sha8aleeennnn
		// ya rab
		// ya rab
		// endingof

		// leader handle Exceptions

		if (  e.getSource()== view.p1.save &&this.p1.getTeam().size() == 3 && this.p2.getTeam().size() == 3) {
			;
			view.p1.dispose();
			view.p1.c.setVisible(true);
			view.p1.c.b1.setText(p1.getTeam().get(0).getName());
			view.p1.c.b2.setText(p1.getTeam().get(1).getName());
			view.p1.c.b3.setText(p1.getTeam().get(2).getName());

			view.p1.c.b4.setText(p2.getTeam().get(0).getName());
			view.p1.c.b5.setText(p2.getTeam().get(1).getName());
			view.p1.c.b6.setText(p2.getTeam().get(2).getName());
		}
			if (e.getSource() == view.p1.c.b1) {
				
				p1.setLeader(p1.getTeam().get(0));

				view.p1.c.b2.setEnabled(false);
				view.p1.c.b3.setEnabled(false);
			}
			if (e.getSource() == view.p1.c.b2) {
				p1.setLeader(p1.getTeam().get(1));

				view.p1.c.b1.setEnabled(false);
				view.p1.c.b3.setEnabled(false);

			}

			if (e.getSource() == view.p1.c.b3) {
				p1.setLeader(p1.getTeam().get(2));

				view.p1.c.b1.setEnabled(false);
				view.p1.c.b2.setEnabled(false);

			}

			if (e.getSource() == view.p1.c.b4) {
				p2.setLeader(p2.getTeam().get(0));

				view.p1.c.b5.setEnabled(false);
				view.p1.c.b6.setEnabled(false);

			}
			if (e.getSource() == view.p1.c.b5) {
				p2.setLeader(p2.getTeam().get(1));

				view.p1.c.b4.setEnabled(false);
				view.p1.c.b6.setEnabled(false);

			}

			if (e.getSource() == view.p1.c.b6) {
				p2.setLeader(p2.getTeam().get(2));

				view.p1.c.b4.setEnabled(false);
				view.p1.c.b5.setEnabled(false);

			}

			if (p1.getLeader() != null && p2.getLeader() != null && this.fl) {
				this.fl = false;
				view.p1.c.dispose();
				view.p1.c.grid.setVisible(true);
				// population of a board

				try {
					view.game = new Game(p1, p2);
					view.p1.c.grid.turnCh.setText(convertToMultiline(view.game.printTurn()));
					view.p1.c.grid.current.setText(convertToMultiline(view.game.getCurrentChampion().toString()));
					view.p1.c.grid.a1.setText(view.game.getCurrentChampion().getAbilities().get(0).getName());
					view.p1.c.grid.a2.setText(view.game.getCurrentChampion().getAbilities().get(1).getName());
					view.p1.c.grid.a3.setText(view.game.getCurrentChampion().getAbilities().get(2).getName());

					for (int i = 0; i < Game.getBoardheight(); i++) {
						for (int j = 0; j < Game.getBoardwidth(); j++)
						// view.p1.c.grid.grid.add
						{

							if (view.game.getBoard()[i][j] instanceof Champion) {

						Champion m = (Champion) (view.game.getBoard()[i][j]);
						String k = convertToMultiline(m.toString());
						
						
						view.p1.c.grid.buttGrid[i][j].setText(k);
						view.p1.c.grid.buttGrid[i][j].setFont(new Font(k,Font.PLAIN,7));
					}
//			view.p1.c.grid.add((Damageable(this.engine.getBoard()[i][j]))  );				
					if (view.game.getBoard()[i][j] instanceof Cover) {
						Cover m = (Cover) (view.game.getBoard()[i][j]);
						String x = m.getCurrentHP() + "";
						view.p1.c.grid.buttGrid[i][j].setText(x);

					}

				}

			}
				
				
				

				
				
				if (e.getSource()== this.view.p1.c.grid.move) 
				{
					
				}
				
				
				}
				catch (IOException e1) {
					e1.getMessage();
				}
		
		
				// if (view.p1.c.grid)

				view.p1.c.grid.setVisible(true);

			}

			if (e.getSource()== view .p1.c.grid.up)
			{
				direction = Direction.DOWN;
			
				}
			else if (e.getSource()== view .p1.c.grid.down)
			{
				direction = Direction.UP;
			}
			else if (e.getSource()== view .p1.c.grid.left)
			{

				direction = Direction.LEFT;
			}
			else if (e.getSource()== view .p1.c.grid.right)
			{
				
			direction = Direction.RIGHT;
			}
			else if (e.getSource() == view.p1.c.grid.move) {
				try {
					view.game.move(direction);
				} catch (UnallowedMovementException e1) {
					JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "Una allowed Movement",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "not enough resources",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
				System.out.println("sdafgkjn");
				for (int i = 0; i < Game.getBoardheight(); i++) {
					for (int j = 0; j < Game.getBoardwidth(); j++)
					// view.p1.c.grid.grid.add
					{

						if (view.game.getBoard()[i][j] instanceof Champion) {

						
							Champion m = (Champion) (view.game.getBoard()[i][j]);
							String k = convertToMultiline(m.toString());
							
							
							view.p1.c.grid.buttGrid[i][j].setText(k);
							view.p1.c.grid.buttGrid[i][j].setFont(new Font(k,Font.PLAIN,7));
						}
//			view.p1.c.grid.add((Damageable(this.engine.getBoard()[i][j]))  );				
						else if (view.game.getBoard()[i][j] instanceof Cover) {
							Cover m=(Cover)(view.game.getBoard()[i][j]) ;
						String x= 	m.getCurrentHP()+"";
						view.p1.c.grid.buttGrid[i][j].setText(x);							
						
						
						}
						else {
							view.p1.c.grid.buttGrid[i][j].setText("");
						}
						
							
					}			

					}
				view.p1.c.grid.revalidate();
				view.p1.c.grid.repaint();
			}
			else if (e.getSource() == view.p1.c.grid.attack) {
				try {
					view.game.attack(direction);
				} catch (ChampionDisarmedException e1) {
					JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "You are disarmed",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "not enough resources",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "Invalid target",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
				for (int i = 0; i < Game.getBoardheight(); i++) {
					for (int j = 0; j < Game.getBoardwidth(); j++)
					// view.p1.c.grid.grid.add
					{

						if (view.game.getBoard()[i][j] instanceof Champion) {

							Champion m = (Champion) (view.game.getBoard()[i][j]);
							String k = convertToMultiline(m.toString());
							
							
							view.p1.c.grid.buttGrid[i][j].setText(k);
							view.p1.c.grid.buttGrid[i][j].setFont(new Font(k,Font.PLAIN,7));
						
						}
//			view.p1.c.grid.add((Damageable(this.engine.getBoard()[i][j]))  );				
						else if (view.game.getBoard()[i][j] instanceof Cover) {
							Cover m=(Cover)(view.game.getBoard()[i][j]) ;
						String x= 	m.getCurrentHP()+"";
						view.p1.c.grid.buttGrid[i][j].setText(x);							
						
						
						}
						else {
							view.p1.c.grid.buttGrid[i][j].setText("");
						}
						
							
					}			

					}
				view.p1.c.grid.revalidate();
				view.p1.c.grid.repaint();
			}
			else if (e.getSource() == view.p1.c.grid.ua1) {
				try {
					view.game.useLeaderAbility();
				} catch (LeaderAbilityAlreadyUsedException e1) {
					JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "Leader ability used",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				} catch (LeaderNotCurrentException e1) {
					JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "This is not the leader",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
				for (int i = 0; i < Game.getBoardheight(); i++) {
					for (int j = 0; j < Game.getBoardwidth(); j++)
					// view.p1.c.grid.grid.add
					{

						if (view.game.getBoard()[i][j] instanceof Champion) {

							Champion m = (Champion) (view.game.getBoard()[i][j]);
							String k = convertToMultiline(m.toString());
							
							
							view.p1.c.grid.buttGrid[i][j].setText(k);
							view.p1.c.grid.buttGrid[i][j].setFont(new Font(k,Font.PLAIN,7));
						
						}
//			view.p1.c.grid.add((Damageable(this.engine.getBoard()[i][j]))  );				
						else if (view.game.getBoard()[i][j] instanceof Cover) {
							Cover m=(Cover)(view.game.getBoard()[i][j]) ;
						String x= 	m.getCurrentHP()+"";
						view.p1.c.grid.buttGrid[i][j].setText(x);							
						
						
						}
						else {
							view.p1.c.grid.buttGrid[i][j].setText("");
						}
						
							
					}			

					}
				view.p1.c.grid.revalidate();
				view.p1.c.grid.repaint();
			}
			else if(e.getSource() == view.p1.c.grid.end) {
				view.game.endTurn();
				view.p1.c.grid.turnCh.setText(convertToMultiline(view.game.printTurn()));
				view.p1.c.grid.current.setText(convertToMultiline(view.game.getCurrentChampion().toString()));
				view.p1.c.grid.a1.setText(view.game.getCurrentChampion().getAbilities().get(0).getName());
				view.p1.c.grid.a2.setText(view.game.getCurrentChampion().getAbilities().get(1).getName());
				view.p1.c.grid.a3.setText(view.game.getCurrentChampion().getAbilities().get(2).getName());
				for (int i = 0; i < Game.getBoardheight(); i++) {
					for (int j = 0; j < Game.getBoardwidth(); j++)
					// view.p1.c.grid.grid.add
					{

						if (view.game.getBoard()[i][j] instanceof Champion) {

							Champion m = (Champion) (view.game.getBoard()[i][j]);
							String k = convertToMultiline(m.toString());
							
							
							view.p1.c.grid.buttGrid[i][j].setText(k);
							view.p1.c.grid.buttGrid[i][j].setFont(new Font(k,Font.PLAIN,7));

						}
//			view.p1.c.grid.add((Damageable(this.engine.getBoard()[i][j]))  );				
						else if (view.game.getBoard()[i][j] instanceof Cover) {
							Cover m=(Cover)(view.game.getBoard()[i][j]) ;
						String x= 	m.getCurrentHP()+"";
						view.p1.c.grid.buttGrid[i][j].setText(x);							
						
						
						}
						else {
							view.p1.c.grid.buttGrid[i][j].setText("");
						}
						
							
					}			

					}
				view.p1.c.grid.revalidate();
				view.p1.c.grid.repaint();
			}
			else if(e.getSource() == view.p1.c.grid.a1) {
				view.p1.c.grid.a1.setEnabled(false);
				view.p1.c.grid.a2.setEnabled(true);
				view.p1.c.grid.a3.setEnabled(true);
				ability = view.game.getCurrentChampion().getAbilities().get(0);
			}
			else if(e.getSource() == view.p1.c.grid.a2) {
				view.p1.c.grid.a1.setEnabled(true);
				view.p1.c.grid.a2.setEnabled(false);
				view.p1.c.grid.a3.setEnabled(true);
				ability = view.game.getCurrentChampion().getAbilities().get(1);
			}
			else if(e.getSource() == view.p1.c.grid.a3) {
				view.p1.c.grid.a1.setEnabled(true);
				view.p1.c.grid.a2.setEnabled(true);
				view.p1.c.grid.a3.setEnabled(false);
				ability = view.game.getCurrentChampion().getAbilities().get(2);
			}
			else if(e.getSource() == view.p1.c.grid.cast) {
				switch(ability.getCastArea()) {
					case DIRECTIONAL:
					try {
						view.game.castAbility(ability, direction);
					} catch (AbilityUseException e1) {
						JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "Ability use exception",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "Not enough resources",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
					case SINGLETARGET: 
						frame = new JFrame();
						JTextField xText = new JTextField();
						JTextField yText = new JTextField();
						frame.add(xText);
						frame.add(yText);
						JButton button = new JButton("Submit");
						frame.add(button);
						button.addActionListener(Action ->{
							x = Integer.parseInt(xText.getText());
							y = Integer.parseInt(xText.getText());
							frame = null;
					try {
						view.game.castAbility(ability, x, y);
					} catch (AbilityUseException e1) {
						JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "Ability use exception",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "Not enough resources",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (InvalidTargetException e1) {
						JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "Invalid Target",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						});
					break;
					default: try {
						view.game.castAbility(ability);
					} catch (AbilityUseException e1) {
						JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "Ability use exception",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (NotEnoughResourcesException e1) {
						JOptionPane.showMessageDialog(view.p1.Ghost_Rider2, "Not enough resources",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} catch (CloneNotSupportedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				for (int i = 0; i < Game.getBoardheight(); i++) {
					for (int j = 0; j < Game.getBoardwidth(); j++)
					// view.p1.c.grid.grid.add
					{

						if (view.game.getBoard()[i][j] instanceof Champion) {

							Champion m = (Champion) (view.game.getBoard()[i][j]);
							String k = convertToMultiline(m.toString());
							
							
							view.p1.c.grid.buttGrid[i][j].setText(k);
							view.p1.c.grid.buttGrid[i][j].setFont(new Font(k,Font.PLAIN,7));
						
						}
//			view.p1.c.grid.add((Damageable(this.engine.getBoard()[i][j]))  );				
						else if (view.game.getBoard()[i][j] instanceof Cover) {
							Cover m=(Cover)(view.game.getBoard()[i][j]) ;
						String x= 	m.getCurrentHP()+"";
						view.p1.c.grid.buttGrid[i][j].setText(x);							
						
						
						}
						else {
							view.p1.c.grid.buttGrid[i][j].setText("");
						}
						
							
					}			

					}
				view.p1.c.grid.revalidate();
				view.p1.c.grid.repaint();
			}
		}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public Intro getView() {
		return view;
	}


	public static void main(String[] args) throws IOException {
		controller m = new controller();

	}
	public static String convertToMultiline(String orig)
	{
	    return "<html>" + orig.replaceAll("\n", "<br>");
	}

}
