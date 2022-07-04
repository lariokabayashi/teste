package puyopuyo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DescePuyo implements ActionListener {
	final static int MAX_PUYOS = 7*13;
	final static int widthWindow = 252;
	final static int heightWindow = 375;
	
	final static int Celula = widthWindow/7;
	Puyo p[][];
	public DescePuyo(Puyo p[][], Notifier metro) {
		this.p = p;
		metro.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				if (p[i][j].getStatus() == "P" &&  p[i][j].getY() <= heightWindow && p[i][j].checkPuyos(p[i][j].getX(), p[i][j].getY() + Celula) == false) {
					System.out.println("cor: " + p[i][j].getColor() + " I: " + p[i][j].getCelula().getI() + " J: " + p[i][j].getCelula().getJ());
					p[i][j].setY(p[i][j].getY() + Celula);
					p[i][j].setLocation(p[i][j].getX(), p[i][j].getY());
				}
			}
		}
	}

}
