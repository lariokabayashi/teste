package puyopuyo;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	Clip clipBackground;
	Clip clipGameOver;
	public void BackgroundSound() {
		try {
	        AudioInputStream audioInputStream = 
	        		AudioSystem.getAudioInputStream(AppPuyo.class.getResource("assets/backgroundMusic.wav"));
	        clipBackground = AudioSystem.getClip();
	        clipBackground.open(audioInputStream);
	        clipBackground.start();
	        clipBackground.loop(Clip.LOOP_CONTINUOUSLY);
	        // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY); 
	        // If you want to stop the sound, then use clip.stop();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	public void GameOverSound() {
		clipBackground.stop();
		try {
	        AudioInputStream gameOverAudio = AudioSystem.getAudioInputStream(AppPuyo.class.getResource("assets/gameOver.wav"));
	        clipGameOver = AudioSystem.getClip();
	        clipGameOver.open(gameOverAudio);
	        clipGameOver.start();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
	}
	public void ComboSound() {
		try {
	        AudioInputStream ComboAudio = AudioSystem.getAudioInputStream(AppPuyo.class.getResource("assets/explode.wav"));
	        clipGameOver = AudioSystem.getClip();
	        clipGameOver.open(ComboAudio);
	        clipGameOver.start();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }
		clipBackground.start();
	}
}
