package puyopuyo;

public class Placar {
	int score;
	
	public Placar() {
		this.score = 0;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = getScore() + score;
	}
}
