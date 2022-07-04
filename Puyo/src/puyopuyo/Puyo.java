package puyopuyo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Puyo extends JLabel implements ActionListener{ //,Runnable {

	private static final long serialVersionUID = 4735320831576421354L;
	private int x, y, angulo, color, event, id;
    private String status;
    private Puyo PuyosProx[];
    Puyo P[][] ;
    Notifier metro;
    private Celula celula;
    private Boolean gameOver;
   
   final static int MAX_PUYOS = 7*13;
	
   //Puyo colors
   final static int PURPLE   = 0;
   final static int RED    = 1;
   final static int YELLOW = 2;
   final static int GREEN  = 3;
   
   final static int widthWindow = 252;
   final static int heightWindow = 375;
   final static int WIDTH = widthWindow/7;
   final static int HEIGHT = widthWindow/7;
   final static int Celula = widthWindow/7;
   
   public Puyo(String arquivoImagem) {
      super(new ImageIcon(arquivoImagem));
      setSize(WIDTH, HEIGHT);
      this.id = 0;
      this.x = 295;
      this.y = 0;
      this.angulo = 0;
      this.color = -1;
      this.PuyosProx = new Puyo[20];
      this.P = null;
      this.status = "D";
      this.event = 0;
      this.metro = new Notifier(1000, 10);
      this.celula = new Celula(this.getX(), this.getY());
      this.gameOver = false;
   }


   public String getStatus() {
	return status;
}
   public void setStatus(String status) {
	   this.status = status;
}


   public int getId() {
	   return id;
   }

   public void setId(int id) {
	   this.id = id;
   }

   public int getAngulo() {
	   return angulo;
   }

   public void setAngulo(int angulo) {
	   this.angulo = angulo;
   }
   
   public int getX() {
	   return x;
   }

   public void setX(int x) {
	   this.x = x;
	   this.celula.setI(x);
   }

   public int getY() {
	   return y;
   }

   public void setY(int y) {
	   this.y = y;
	   this.celula.setJ(y);
   }
   
   public Puyo[] getPuyosProx() {
		return PuyosProx;
   }

   public void setPuyosProx(Puyo[] puyosProx) {
		this.PuyosProx = puyosProx;
   }
   
   public int getColor() {
    	return this.color;
   }
   
   public void setColor(int color) {
    	this.color = color;
   }
   
   public int getEvent() {
		return event;
   }

   public void setEvent(int event) {
		this.event = event;
   }
   
   public Celula getCelula() {
	   return celula;
   }

   public void setCelula(Celula celula) {
	   this.celula = celula;
   }
   
   public boolean getGameOver() {
	   return this.gameOver;
   }
   public void setGameOver() {
	   this.gameOver = true;
	   
   }
   public void link (Puyo puyos[][]) {
	   this.P = puyos;
   }
   
   public boolean checkPuyos(int X, int Y) {
	   int J = this.getId()%10;
	   int I = (this.getId() - J)/10;
	   for (int i=0; i < MAX_PUYOS/2; i++) {
		   for(int j=0; j<2; j++) {
			   if (J == 1 && P[I][0].getStatus() == "P")
				   return true;
			   else {
				   if (i != I && P[i][j].getStatus() != "D" && P[i][j].getStatus() != "E" && P[i][j].getCelula().getI() == X/Celula && P[i][j].getCelula().getJ() == Y/Celula )
					   return true; //há um puyo diferente de this no ponto (x, y)
			   }
		   }
		}
	   return false;
	}

	public void actionPerformed(ActionEvent evento) {
		if (this.getStatus() == "A") {
			if (this.getY() <= heightWindow && checkPuyos(this.getX(), this.getY() + Celula) == false) {
				this.setY(this.getY() + Celula);
				setLocation(this.getX(), this.getY());
			}
			else {
				this.setStatus("P");
				this.metro.stop();
				if (this.getY() == 0)
					this.setGameOver();
			}
		}
	}
}

