package Model;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fase extends JPanel implements ActionListener {
	private Image fundo;
	private Image nebulosa;
	private Player player;
	private Timer timer;
	private List<Inimigo1> inimigo1;
	private List<Inimigo2> inimigo2;
	private List<Inimigo3> inimigo3;
	private List<Nebula> nebulas;
	private List<Stars> star;
	private List<Vida> vida;
	private boolean emJogo;
	private int contInim1 = 0;
	private int contInim2 = 0;
	private int contInim3 = 0;
	private int ini1 = 20;
	private int ini2 = 0;
	private int ini3 = 0;
	int contadora = 0;
	static final int SCREEN_WIDTH = 900;
	static final int SCREEN_HEIGHT = 650;

	public Fase() {

		if (emJogo = true) {
			setFocusable(true);// melhoria de desempenho
			setDoubleBuffered(true);// melhoria de desempenho

			ImageIcon referencia2 = new ImageIcon("res\\principal.jpg");
			fundo = referencia2.getImage();

			ImageIcon iiNebulosa = new ImageIcon("res\\Nebula2.png");
			nebulosa = iiNebulosa.getImage();

			player = new Player();
			player.load();

			addKeyListener(new TecladoAdapter());

			timer = new Timer(4, this);// velocidade do jogo
			timer.start();

			inicializaInimigos();
			inicializaNebulas();
			inicializaStars();
			inicializaVida();
			inicializaInimigos();
			inicializaInimigos2();
			inicializaInimigos3();
			emJogo = true;
		}
	}// constructor

	public void inicializaInimigos() {
		int coordenadas[] = new int[ini1];// numero maximos de inimigo(ajustar dificuldades dps)
		inimigo1 = new ArrayList<Inimigo1>();

		for (int i = 0; i < coordenadas.length; i++) {
			int x = (int) (Math.random() * 8000 + 1024);
			int y = (int) (Math.random() * 650 + 30);
			inimigo1.add(new Inimigo1(x, y));
		} // for

	}// inicializaInimigos

	public void inicializaInimigos2() {
		int coordenadas[] = new int[ini2];
		inimigo2 = new ArrayList<Inimigo2>();

		for (int a = 0; a < coordenadas.length; a++) {
			int x = (int) (Math.random() * 8000 + 1024);
			int y = (int) (Math.random() * 650 + 30);
			inimigo2.add(new Inimigo2(x, y));
		} // for

	}

	public void inicializaInimigos3() {

		int coordenadas[] = new int[ini3];
		inimigo3 = new ArrayList<Inimigo3>();

		for (int a = 0; a < coordenadas.length; a++) {
			int x = (int) (Math.random() * 8000 + 1024);
			int y = (int) (Math.random() * 650 + 30);
			inimigo3.add(new Inimigo3(x, y));
		} // for

	}

	public void inicializaNebulas() {
		int coordenadas[] = new int[1];
		nebulas = new ArrayList<Nebula>();

		for (int i = 0; i < coordenadas.length; i++) {
			int x = (int) (Math.random() * 1050 + 1024);
			int y = (int) ((Math.random() * 768) - (Math.random() * 768));
			nebulas.add(new Nebula(x, y));
		} // for
	}// inicializaNebulas

	public void inicializaStars() {
		int coordenadas[] = new int[50];
		star = new ArrayList<Stars>();

		for (int i = 0; i < coordenadas.length; i++) {
			int x = (int) (Math.random() * 1050 + 1024);
			int y = (int) ((Math.random() * 768) - (Math.random() * 768));
			star.add(new Stars(x, y));
		}
	}

	public void inicializaVida() {
		int coordenadas[] = new int[10];
		vida = new ArrayList<Vida>();

		for (int i = 0; i < coordenadas.length; i++) {
			int x = (int) (Math.random() * 1050 + 1024);
			int y = (int) ((Math.random() * 768) - (Math.random() * 768));
			vida.add(new Vida(x, y));
		}
	}

	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		if (emJogo == true) {

			graficos.drawImage(fundo, 0, 0, null);
			for (int q = 0; q < star.size(); q++) {
				Stars nf = star.get(q);
				nf.load();
				graficos.drawImage(nf.getImagem(), nf.getX(), nf.getY(), this);
			}

			if (player.getVida() != 0) {
				graficos.setColor(Color.WHITE);

				graficos.setFont(new Font("Ink Free", Font.BOLD, 20));
				FontMetrics metric = getFontMetrics(graficos.getFont());
				graficos.drawString("Naves destruidas: " + contInim1,
						(SCREEN_WIDTH - metric.stringWidth("Naves destruidas: " + contInim1)) / 6,
						graficos.getFont().getSize());

				graficos.setColor(Color.GREEN);
				graficos.setFont(new Font("Ink Free", Font.BOLD, 40));
				FontMetrics metric1 = getFontMetrics(graficos.getFont());
				graficos.drawString("Vidas: " + player.getVida(),
						(SCREEN_WIDTH + metric1.stringWidth("Vidas: " + player.getVida())) / 2,
						graficos.getFont().getSize());
			}

			if (player.getVida() == 0) {
				graficos.setColor(Color.RED);
				graficos.setFont(new Font("Ink Free", Font.BOLD, 40));
				FontMetrics metric2 = getFontMetrics(graficos.getFont());
				graficos.drawString("CUIDADO A PROXIMA VOCE MORRE",
						(SCREEN_WIDTH - metric2.stringWidth("CUIDADO A PROXIMA VOCE MORRE")) / 9,
						graficos.getFont().getSize());

			}

			if (player.getTurboLiberar() == 0) {
				graficos.setColor(Color.RED);
				graficos.setFont(new Font("Ink Free", Font.BOLD, 40));
				FontMetrics metric2 = getFontMetrics(graficos.getFont());
				graficos.drawString("SEU COMBUSTIVEL ACABOU",
						(SCREEN_WIDTH - metric2.stringWidth("SEU COMBUSTIVEL ACABOU")) / 9,
						graficos.getFont().getSize());

			}

			for (int z = 0; z < vida.size(); z++) {
				Vida on = vida.get(z);
				on.load();
				graficos.drawImage(on.getImagem(), on.getX(), on.getY(), this);
			}

			for (int j = 0; j < nebulas.size(); j++) {
				Nebula n = nebulas.get(j);
				n.load();
				graficos.drawImage(n.getImagem(), n.getX(), n.getY(), this);
			} // for

			graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);// Nave fica acima do
																						// tiro,visualmente fica mais
																						// bonito
			List<Tiro> tiros = player.getTiros();
			for (int i = 0; i < tiros.size(); i++) {
				Tiro m = tiros.get(i);
				m.load();
				graficos.drawImage(m.getImagem(), m.getX(), m.getY(), this);
			} // for

			for (int o = 0; o < inimigo1.size(); o++) {
				Inimigo1 in = inimigo1.get(o);
				in.load();
				graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
			} // for

			for (int y = 0; y < inimigo2.size(); y++) {
				Inimigo2 pn = inimigo2.get(y);
				pn.load();
				graficos.drawImage(pn.getImagem(), pn.getX(), pn.getY(), this);
			}
			for (int t = 0; t < inimigo3.size(); t++) {
				Inimigo3 kn = inimigo3.get(t);
				kn.load();
				graficos.drawImage(kn.getImagem(), kn.getX(), kn.getY(), this);
			}
		} // if
		else {
			ImageIcon fimJogo = new ImageIcon("res\\fimdejogo.png");
			graficos.drawImage(fimJogo.getImage(), 0, 0, 1024, 728, null);
		} // else

		g.dispose();

	}// paint

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();

		if (player.isTurbo()) {
			timer.setDelay(1);
			player.setTurboLiberar(player.getTurboLiberar() - 1);
		}

		if (player.isTurbo() == false) {
			timer.setDelay(20);
		}

		if (contInim1 == 2) { // nivel 2

			// Inimigo1.setVELOCIDADE(Inimigo1.getVELOCIDADE() + 1);
		}

		for (int j = 0; j < star.size(); j++) {
			Stars on = star.get(j);
			if (on.isVisivel()) {
				on.update();
			} else {
				star.remove(j);
			}
		}

		for (int p = 0; p < nebulas.size(); p++) {
			Nebula on = nebulas.get(p);
			if (on.isVisivel()) {
				on.update();
			} else {
				nebulas.remove(p);
			}
		}

		List<Tiro> tiros = player.getTiros();
		for (int i = 0; i < tiros.size(); i++) {
			Tiro m = tiros.get(i);
			if (m.isVisivel()) {
				m.update();
				if (player.isTurbo()) {
					tiros.get(i).setVELOCIDADE(1);
				}
				if (player.isTurbo() == false) {
					tiros.get(i).setVELOCIDADE(10);
				}

			} else {
				tiros.remove(i);
			}
		}

		for (int o = 0; o < inimigo1.size(); o++) {
			Inimigo1 in = inimigo1.get(o);
			if (in.isVisivel()) {
				in.update();
			} else {
				inimigo1.remove(o);
			}
		}
		for (int b = 0; b < inimigo2.size(); b++) {
			Inimigo2 an = inimigo2.get(b);
			if (an.isVisivel()) {
				an.update();
			} else {
				inimigo2.remove(b);
			}
		}

		for (int b = 0; b < inimigo3.size(); b++) {
			Inimigo3 bn = inimigo3.get(b);
			if (bn.isVisivel()) {
				bn.update();
			} else {
				inimigo3.remove(b);
			}
		}

		for (int s = 0; s < vida.size(); s++) {
			Vida up = vida.get(s);
			if (up.isVisivel()) {
				up.update();
			} else {
				vida.remove(s);
			}
		}

		checarColisoes();

		repaint();// sempre que a gente se mover ele reprinta(atualiza a imagem)

	}// actionPerformed

	public void checarColisoes() {
		Rectangle formaNave = player.getBounds();
		Rectangle formaInimigo1;
		Rectangle formaInimigo2;
		Rectangle formaInimigo3;
		Rectangle formaTiro1;
		Rectangle formaTiro2;
		Rectangle formaTiro3;
		Rectangle vi;

		for (int i = 0; i < inimigo1.size(); i++) {
			Inimigo1 tempInimigo1 = inimigo1.get(i);
			formaInimigo1 = tempInimigo1.getBounds();
			if (formaNave.intersects(formaInimigo1)) {

				if (player.isTurbo()) {
					tempInimigo1.setVisivel(false);
					contInim1++;
				} else if (player.getVida() != 0) {
					player.setVisivel(false);
					tempInimigo1.setVisivel(false);
					player.setVida(player.getVida() - 1);
				} else {
					player.setVisivel(false);
					tempInimigo1.setVisivel(false);
					emJogo = false;
				}
			}
		}

		for (int f = 0; f < inimigo2.size(); f++) {
			Inimigo2 tempInimigo2 = inimigo2.get(f);
			formaInimigo2 = tempInimigo2.getBounds();
			if (formaNave.intersects(formaInimigo2)) {

				if (player.isTurbo()) {
					tempInimigo2.setVisivel(false);
					contInim2++;
				} else if (player.getVida() != 0) {
					player.setVisivel(false);
					tempInimigo2.setVisivel(false);
					player.setVida(player.getVida() - 1);
				} else {
					player.setVisivel(false);
					tempInimigo2.setVisivel(false);
					emJogo = false;
				}
			}
		}

		for (int f = 0; f < inimigo3.size(); f++) {
			Inimigo3 tempInimigo3 = inimigo3.get(f);
			formaInimigo3 = tempInimigo3.getBounds();
			if (formaNave.intersects(formaInimigo3)) {

				if (player.isTurbo()) {
					tempInimigo3.setVisivel(false);
					contInim3++;
				} else if (player.getVida() != 0) {
					player.setVisivel(false);
					tempInimigo3.setVisivel(false);
					player.setVida(player.getVida() - 1);
				} else {
					player.setVisivel(false);
					tempInimigo3.setVisivel(false);
					emJogo = false;
				}
			}
		}

		for (int w = 0; w < vida.size(); w++) {
			Vida vipa = vida.get(w);
			vi = vipa.getBounds();
			if (formaNave.intersects(vi)) {
				player.setVisivel(false);
				vipa.setVisivel(false);
				player.setVida(player.getVida() + 1);
				player.setTiroDuplo(true);

			}
		}

		List<Tiro> tiro1 = player.getTiros();
		for (int j = 0; j < tiro1.size(); j++) {
			Tiro tempTiro1 = tiro1.get(j);
			formaTiro1 = tempTiro1.getBounds();
			for (int k = 0; k < inimigo1.size(); k++) {
				Inimigo1 tempInimigo1 = inimigo1.get(k);
				formaInimigo1 = tempInimigo1.getBounds();
				if (formaTiro1.intersects(formaInimigo1)) {
					tempInimigo1.setVisivel(false);
					tempTiro1.setVisivel(false);
					contInim1++;
				}
			}
		}

		List<Tiro> tiro2 = player.getTiros();
		for (int j = 0; j < tiro2.size(); j++) {
			Tiro tempTiro2 = tiro2.get(j);
			formaTiro2 = tempTiro2.getBounds();
			for (int k = 0; k < inimigo2.size(); k++) {
				Inimigo2 tempInimigo2 = inimigo2.get(k);
				formaInimigo2 = tempInimigo2.getBounds();
				if (formaTiro2.intersects(formaInimigo2)) {
					tempInimigo2.setVisivel(false);
					tempTiro2.setVisivel(false);
					contInim2++;
				}
			}
		}

		List<Tiro> tiro3 = player.getTiros();
		for (int j = 0; j < tiro3.size(); j++) {
			Tiro tempTiro3 = tiro3.get(j);
			formaTiro3 = tempTiro3.getBounds();
			for (int k = 0; k < inimigo3.size(); k++) {
				Inimigo3 tempInimigo3 = inimigo3.get(k);
				formaInimigo3 = tempInimigo3.getBounds();
				if (formaTiro3.intersects(formaInimigo3)) {
					tempInimigo3.setVisivel(false);
					tempTiro3.setVisivel(false);
					contInim3++;
				}
			}
		}

	}// checarColisoes

	private class TecladoAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				emJogo = true;
				player.setVida(player.getVida() + 5);

			}
			player.keypressed(e);
		}// keyPressed

		@Override
		public void keyReleased(KeyEvent e) {
			player.keyRelease(e);
		}// keyRelease

	}// class TecladoAdapter

}// class
