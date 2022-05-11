package app;
public class CardGameApp extends GameApp {
	public CardGameApp() {
		
	}
	
	public CardGameApp(String item) {
		super(item);
	}
	
	public String play() {
		return "ババ抜きを行います。";
	}
	
}
