package puyopuyo;

import java.util.Random;

public class Maker {
	//private static final long serialVersionUID = 1278136335268310294L;
	int i,j;
	private Puyo puyos[][] = new Puyo[MAX_PUYOS][2];
	
	public static String DIRETORIO =
	         "/C:/Users/edusi/eclipse-workspace/Puyo/bin/puyopuyo/";
	
	final static int MAX_PUYOS = 7*13;
		
	//puyo colors
	final static int PURPLE   = 0;
	final static int RED    = 1;
	final static int YELLOW = 2;
	final static int GREEN  = 3;
	    
	final static int widthWindow = 252;
	final static int heightWindow = 468;
	final static int WIDTH = widthWindow/7;
	final static int HEIGHT = widthWindow/7;
	final static int Celula = widthWindow/7;
		
	public Puyo[][] makePuyos() {
		Random rand = new Random();
		for(i=0; i<MAX_PUYOS/2; i++) {
			for(j=0; j<2; j++) {
				int color = java.lang.Math.abs(rand.nextInt()%4);
				switch(color)  {
					case Puyo.PURPLE:
					    puyos[i][j] = new Puyo(DIRETORIO+"assets/purple.png");
					    puyos[i][j].setColor(Puyo.PURPLE);
					    break;
					case Puyo.RED:
						puyos[i][j] = new Puyo(DIRETORIO+"assets/red.png");
					    puyos[i][j].setColor(Puyo.RED);
					    break;
					case Puyo.YELLOW:
						puyos[i][j] = new Puyo(DIRETORIO+"assets/yellow.png");
					    puyos[i][j].setColor(Puyo.YELLOW);
					    break;
					case Puyo.GREEN:
						puyos[i][j] = new Puyo(DIRETORIO+"assets/green.png");
					    puyos[i][j].setColor(Puyo.GREEN);
					    break;
				}
			}
			
		}
		return puyos;
	}
}
