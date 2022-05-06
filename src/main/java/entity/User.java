package entity;

/**
 * Userクラス
 */
public class User {

    // フィールド
	public String userId;
	public String userName;
	public int age; 
    /**
     * コンストラクタ(引数なし)
     */
	public User() {
		
	}
	/**
     * コンストラクタ(引数3つ)
     */
	public User(String userID, String userName, int age) {
		this.userId = userID;
		this.userName = userName;
		this.age = age;
	}
    


    /**
     * ユーザー情報を取得するメソッド
     */
	public String returnUserInfo() {
		return "ユーザID:"+ this.userId + "、" +
				"ユーザ名:" + this.userName + "、" +
				"年齢:" + this.age;
	}
}
