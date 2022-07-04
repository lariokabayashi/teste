package puyopuyo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Remove implements ActionListener {
	final static int MAX_PUYOS = 7*13;
	final static int widthWindow = 252;
	final static int heightWindow = 468;
	final static int WIDTH = widthWindow/7;
	final static int HEIGHT = widthWindow/7;
	final static int Celula = widthWindow/7;
	
	Puyo p[][];
	Puyo visitados[], CoresIguais[];
	Placar placar;
	Sound sound;
	JanelaImagem janela;
	int n = 1;
	
	public Remove(Puyo p[][], Notifier metro, Placar placar, JanelaImagem janela, Sound sound) {
		this.p = p;
		this.placar = placar;
		this.janela = janela;
		this.sound = sound;
		metro.addActionListener(this);
	}
	
	public boolean PuyoInList(Puyo p, Puyo puyos[]){
		for(int i=0; puyos[i] != null; i++) {
			if (puyos[i].getStatus() != "D" && puyos[i].getStatus() != "E")
				if (puyos[i].getId() == p.getId())
					return true;
		}
		return false;
	}
	public void add(Puyo lista[], Puyo p[]) {
		int v, w = tam(lista);
		for (v = 0; p[v] != null; v++) {
			if (!PuyoInList(p[v], lista)) {
				lista[w] = p[v];
				w++;
			}
		}
	}
	
	public void add(Puyo lista[], Puyo p) {
		int w = tam(lista);
		lista[w] = p;
	}
	
	public int tam(Puyo lista[]) {
		int w;
		for (w = 0; lista[w] != null; w++);
		return w;
	}

	public void findPuyos(Puyo p[][], int I, int J, int color) {
		for(int i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				if (p[i][j].getStatus() == "P") {
					if (p[i][j].getCelula().getJ() == p[I][J].getCelula().getJ() && (p[i][j].getCelula().getI() == p[I][J].getCelula().getI()-1 || p[i][j].getCelula().getI()== p[I][J].getCelula().getI()+1) &&  p[i][j].getColor() == color && !PuyoInList(p[i][j], p[I][J].getPuyosProx())) {
						add(p[I][J].getPuyosProx(), p[i][j]);
					}
					if (p[i][j].getCelula().getI() == p[I][J].getCelula().getI() && (p[i][j].getCelula().getJ() == p[I][J].getCelula().getJ()-1 || p[i][j].getCelula().getJ()== p[I][J].getCelula().getJ()+1) && p[i][j].getColor() == color  && !PuyoInList(p[i][j], p[I][J].getPuyosProx())) {
						add(p[I][J].getPuyosProx(), p[i][j]);
					}
				}
			}
		}
	}
	public void SearchSameColor(Puyo P, Puyo CoresIguais[]) {
		add(visitados, P);
		add(CoresIguais,P.getPuyosProx());
		for (int w = 0; P.getPuyosProx()[w] != null; w++) { //Acessando a lista de PuyosProx do puyo
			if (P.getPuyosProx()[w].getPuyosProx()[0] != null && (P.getStatus() == "P") && !PuyoInList(P.getPuyosProx()[w], visitados))//Acessando a lista de PuyosProx do puyo que estava dentro da lista do primeiro
				SearchSameColor(P.getPuyosProx()[w], CoresIguais);	
		}
	}
	
	public void EliminaPuyos(Puyo eliminados[], Puyo p[][]) {
		for (int i = 0; eliminados[i] != null; i++) {
			eliminados[i].setStatus("E");
			sound.ComboSound();
			janela.panel.remove(eliminados[i]);
			janela.panel.validate();
			janela.panel.validate();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				if (p[i][j].getStatus() == "A" || p[i][j].getStatus() == "P") {
					findPuyos(p, i, j, p[i][j].getColor());
				}
			}
		}
		for(int i=0; i<MAX_PUYOS/2; i++) {
			for(int j=0; j<2; j++) {
				CoresIguais = new Puyo [20];
				visitados = new Puyo [20];
				if ((p[i][j].getStatus() == "P") && p[i][j].getPuyosProx()[0] != null)
					SearchSameColor(p[i][j], CoresIguais);
				if (tam(CoresIguais) >= 4) {
					EliminaPuyos(CoresIguais, p);
					placar.setScore(tam(CoresIguais)*5);
					janela.panel.ChangePlacar(placar.getScore());
				}
			}
		}
	}
}