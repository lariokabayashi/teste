package puyopuyo;


public class Celula {
	final static int widthWindow = 252;
	final static int heightWindow = 468;
	final static int WIDTH = widthWindow/7;
	final static int HEIGHT = widthWindow/7;
	final static int Celula = widthWindow/7;
	   
	private int i, j;
	
	public Celula(int i, int j) {
		this.i = i/Celula;
		this.j = j/Celula;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i/Celula;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j/Celula;
	}
}
