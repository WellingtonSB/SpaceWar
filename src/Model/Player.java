package Model;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Player implements ActionListener {

	private int x, y;
	private int dx, dy;
	private Image imagem;
	private int altura, largura;
	private List<Tiro> tiros;
	private boolean isVisivel, isTurbo;
	private Timer timer;
	private int vida,turboLiberar;
	

	public Player() {
		this.x = 100;
		this.y = 728 / 2;

		vida = 5;
		turboLiberar = 3;
		isVisivel = true;
		isTurbo = false;
		tiros = new ArrayList<Tiro>();

		timer = new Timer(5000, this);// cronometro 7 segundos
		timer.start();

	}// constructor

	@Override
	public void actionPerformed(ActionEvent e) {

		if (isTurbo == true) {
			turbo();
			isTurbo = false;

		}
		// gambiarra provisoria
		if (isTurbo == false) {
			load();
		}

	}

	public void turbo() {

		isTurbo = true;
		ImageIcon referencia = new ImageIcon("res\\naveTurbo.gif");
		imagem = referencia.getImage();

	}

	public void load() {
		ImageIcon referencia = new ImageIcon("res\\naveMAE.gif");
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);
		largura = imagem.getWidth(null);
	}// load

	public void update() {
		x += dx;
		y += dy;
	}// update

	public void tiroSimples() {
		this.tiros.add(new Tiro(x + (largura / 2), y + (altura / 2)));
	}// tirosimples

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}

	public void keypressed(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();
		// quando pressionar a tecla dx e dy irão virar tres (ira se mexer)

		if (codigo == KeyEvent.VK_CONTROL) {
			turbo();

		}

		if (codigo == KeyEvent.VK_SPACE) {
			if (isTurbo() == false) {
				tiroSimples();
			}

		} // if

		if (codigo == KeyEvent.VK_UP) {
			dy = -3;
		} // if
		if (codigo == KeyEvent.VK_DOWN) {
			dy = 3;
		} // if
		if (codigo == KeyEvent.VK_LEFT) {
			dx = -3;
		} // if
		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 3;
		} // if

	}// Keypressed

	public void keyRelease(KeyEvent tecla) {
		int codigo = tecla.getKeyCode();

		// quando parar de pressionar a tecla dx e dy irão virar zero(ira parar de se
		// mexer)

		if (codigo == KeyEvent.VK_UP) {
			dy = 0;
		} // if
		if (codigo == KeyEvent.VK_DOWN) {
			dy = 0;
		} // if
		if (codigo == KeyEvent.VK_LEFT) {
			dx = 0;
		} // if
		if (codigo == KeyEvent.VK_RIGHT) {
			dx = 0;
		} // if

	}// KeyRelease

	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public boolean isTurbo() {
		return isTurbo;
	}

	public void setTurbo(boolean isTurbo) {
		this.isTurbo = isTurbo;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImagem() {
		return imagem;
	}

	public List<Tiro> getTiros() {
		return tiros;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getTurboLiberar() {
		return turboLiberar;
	}

	public void setTurboLiberar(int turboLiberar) {
		this.turboLiberar = turboLiberar;
	}

}// class
