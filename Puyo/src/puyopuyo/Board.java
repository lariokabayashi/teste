package puyopuyo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JPanel;

public class Board extends JPanel{

	private static final long serialVersionUID = -7959998185653748852L;
	final static int widthTotal = 400;
	final static int widthWindow = 252;
	final static int heightWindow = 468;
	//private static final long serialVersionUID = 1278136335268310294L;
	String score;
	int s = 0;
	int layout = 0; //Layout 0 � quando !GameOver

	public void paintComponent(Graphics g2){
		super.paintComponent(g2);
		if (layout == 0) {
			g2.setColor(Color.BLACK);
			// creates a solid stroke with line width is 2
			Stroke stroke = new BasicStroke(4f);
			((Graphics2D) g2).setStroke(stroke);
			g2.drawLine(252, 0, 252, 700);
			g2.drawLine(252, 144, 400, 144);
			g2.setColor(Color.BLACK);
			g2.setFont(new Font("serif", Font.BOLD, 20));
				
			score = Integer.toString(s);
			g2.drawString("Score: " + score, 260, 400);
		}
		else {
			GameOver(g2);
		}
	}
	
	public void ChangePlacar(int score) {
		s += score;
		this.validate();
	}
	public void changeLayout(int i) {
		layout = i;
	}
	public void GameOver(Graphics g2) {
		super.paintComponent(g2);
		g2.setColor(Color.black);
		g2.fillRect(0, 0, widthTotal, heightWindow);
		g2.setColor(Color.white);
		g2.setFont(new Font("serif", Font.BOLD, 20));
		g2.drawString("GAME OVER", 125, heightWindow/2);
	}
 }
