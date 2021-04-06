package spaceWar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Model.Fase;

public class Container extends JFrame {

	public Container() {
		add(new Fase());
		setTitle("SPACE WAR");
		ImageIcon icone = new ImageIcon("res\\FUNDO");
		this.setIconImage(icone.getImage());

		setSize(1024, 728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);

	}// constructor

	public static void main(String[] args) {
		new Container();
	}// main

}// class Container
