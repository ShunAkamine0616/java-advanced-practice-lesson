package jp.co.axiz.util;

import jp.co.axiz.app.App;
import jp.co.axiz.app.CardGameApp;
import jp.co.axiz.app.ClockApp;
import jp.co.axiz.app.DartsGameApp;
import jp.co.axiz.app.GameApp;

public class AppUtil {
	
	public static boolean isGameApp(App a) {
		if(a instanceof CardGameApp || a instanceof DartsGameApp) {
			return true;
		}
		return false;
	}
	
	public static boolean isCardGameApp(App a) {
		if(a instanceof CardGameApp) {
			return true;
		}
		return false;
	}
	
	public static boolean isDartsGameApp(App a) {
		if(a instanceof DartsGameApp) {
			return true;
		} 
		return false;
	}
	
	public static boolean isClockApp(App a) {
		if(a instanceof ClockApp) {
			return true;
		} 
		return false;
	}
	
	public static String getAppName(App a) {
		if(a instanceof GameApp) {
			GameApp game_a = (GameApp) a;
			return "ゲーム:" + game_a.getItem();
		} else if(a instanceof ClockApp) {
			return "時計";
		}
		return "";
	}
}
