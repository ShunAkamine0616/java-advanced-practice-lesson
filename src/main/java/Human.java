
/**
 * Humanクラス
 */
public class Human {
    // フィールド
    public String name; // 名前
    public String language; // 言語

    /**
     * コンストラクタ(引数なし)
     */
    public Human() {
        // 初期値をセット
        name = "名無し";
        language = "不明";
    }

    /**
     * コンストラクタ (受け取った引数を元に初期値をセット)
     */
    public Human(String name, String language) {
        // フィールドを初期化
        this();

        if (!Utility.isNullOrEmpty(name)) {
            this.name = name;
        }

        if (!Utility.isNullOrEmpty(language)) {
            this.language = language;
        }
    }

    /**
     * その人物の情報を返却するメソッド
     */
    public String returnHumanInfo() {
        // フィールドの値を元にその人の情報を作成
        String msg = "";
        msg += "名前:" + name;
        msg += "、" + "言語:" + language;

        // 出身地の情報はreturnBirthPlaceInfoメソッドにて取得
        msg += "、" + returnBirthPlaceInfo();

        // 作成した文字列を返却
        return msg;
    }

    /**
     * 出身地の情報を返却するメソッド
     */
    public String returnBirthPlaceInfo() {
        // 出身地用の文字列
        String msg = "出身地:不明";

        // 作成した文字列を返却
        return msg;
    }

}
