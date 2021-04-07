package spaceWar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import Model.Fase;

public class Container extends JFrame {

	public Container() {
		JMenuBar barraMenu = new JMenuBar();

		JMenu menu = new JMenu("Menu");
		JMenuItem sobre = new JMenuItem("Sobre");
		sobre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Wellington Bezerra 2021", "Informações",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		JMenuItem sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener() {

			@Override  
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menu.add(sobre);
		menu.add(new JSeparator());
		menu.add(sair);
		
		barraMenu.add(menu);
		
		setJMenuBar(barraMenu);
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
