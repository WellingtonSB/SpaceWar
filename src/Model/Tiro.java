package Model;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Tiro {
	
	private Image imagem;
	private int x, y;
	private int largura, altura;
	private boolean isVisivel;
	
	private static final int LARGURA = 938;
	private static int VELOCIDADE = 2;
	
	public Tiro (int x, int y) {//x e y> a possição de onde saira o tiro é o local onde a nave esta.
		this.x = x;
		this.y = y;
		isVisivel = true;//quando o tiro sair ele ficará visivel
	}//constructor
	
	public void load() {
		ImageIcon referencia = new ImageIcon("res\\tiroSimples.png");//instanciando a imagem do tiro.
		imagem = referencia.getImage();
		
		this.largura = imagem.getWidth(null);
		this.altura = imagem.getHeight(null);
	}//load
	
	public void update() {
		this.x += VELOCIDADE;
		if (this.x > LARGURA) {
			isVisivel = false;
		}//if
	}//update
	

	public Rectangle getBounds() {
		return new Rectangle(x, y, largura, altura);
	}
	
	public boolean isVisivel() {
		return isVisivel;
	}

	public void setVisivel(boolean isVisivel) {
		this.isVisivel = isVisivel;
	}

	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
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
	
	
	
}//class
