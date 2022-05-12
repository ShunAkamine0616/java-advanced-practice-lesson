package jp.co.axiz.app;

public class DartsGameApp extends GameApp{
	public DartsGameApp() {
		
	}
	
	public DartsGameApp(String item) {
		super(item);
		setPlayTime(10);
	}
	
	protected String play() {
		return "10回投げて合計点を競います。";
	}
}
