package jp.co.axiz.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.axiz.app.CardGameApp;
import jp.co.axiz.app.ClockApp;
import jp.co.axiz.app.DartsGameApp;
import jp.co.axiz.util.AppUtil;

class AppUtilTest {

	@Test
	public void ゲームアプリの認識() {
		CardGameApp card = new CardGameApp();
		DartsGameApp darts = new DartsGameApp();
		ClockApp clock = new ClockApp();
		
		assertEquals(true, AppUtil.isGameApp(card));
		assertEquals(true, AppUtil.isGameApp(darts)); 
		assertEquals(false, AppUtil.isGameApp(clock)); 
	}
	
	@Test
	public void カードゲームの認識() {
		CardGameApp card = new CardGameApp();
		DartsGameApp darts = new DartsGameApp();
		ClockApp clock = new ClockApp();
			
		assertEquals(true, AppUtil.isCardGameApp(card)); 
		assertEquals(false, AppUtil.isCardGameApp(darts)); 
		assertEquals(false, AppUtil.isCardGameApp(clock)); 
	}
	
	@Test
	public void ダーツアプリの認識() {
		CardGameApp card = new CardGameApp();
		DartsGameApp darts = new DartsGameApp();
		ClockApp clock = new ClockApp();
			
		assertEquals(false, AppUtil.isDartsGameApp(card)); 
		assertEquals(true, AppUtil.isDartsGameApp(darts)); 
		assertEquals(false, AppUtil.isDartsGameApp(clock)); 
	}
	
	@Test
	public void 時計アプリの認識() {
		CardGameApp card = new CardGameApp();
		DartsGameApp darts = new DartsGameApp();
		ClockApp clock = new ClockApp();
			
		assertEquals(false, AppUtil.isClockApp(card)); 
		assertEquals(false, AppUtil.isClockApp(darts)); 
		assertEquals(true, AppUtil.isClockApp(clock)); 
	}
	
	@Test
	public void アプリ名() {
		CardGameApp card = new CardGameApp("カード");
		DartsGameApp darts = new DartsGameApp("ダーツ");
		ClockApp clock = new ClockApp();
			
		assertEquals("ゲーム:カード", AppUtil.getAppName(card)); 
		assertEquals("ゲーム:ダーツ", AppUtil.getAppName(darts)); 
		assertEquals("時計", AppUtil.getAppName(clock)); 
	}
	
}
