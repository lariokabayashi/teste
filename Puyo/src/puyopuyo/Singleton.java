package puyopuyo;

public class Singleton {
	 private static final Notifier instance = new Notifier(1000, 10);
	 private Singleton(){
		 
	 }
	 public static Notifier getInstance(){
	        return instance;
	 }
}
