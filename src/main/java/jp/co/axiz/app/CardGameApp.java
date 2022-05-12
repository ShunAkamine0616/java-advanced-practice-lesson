package jp.co.axiz.app;

public class CardGameApp extends GameApp {
	
	public CardGameApp() {
		super();
	}
	public CardGameApp(String item) {
		super(item);
		setPlayTime(5);
	}
	
	
//	@Override
//	public String start(String name) {
//		if(super.item.equals("トランプ")) {
//			return name + "さんと" + super.item + 
//					"でゲームを開始します。ババ抜きを行います。";
//		} else if(super.item.equals("ゲーム")) {
//			return name + "さんと何かでゲームを開始します";
//		}
//		return name + "さんと" + super.item + 
//				"でゲームを開始します";
//		
//	}
	
	protected String play() {
		return "ババ抜きを行います。";
	}
}
