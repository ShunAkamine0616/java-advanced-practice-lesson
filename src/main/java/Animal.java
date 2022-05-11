
/**
 * 動物を表す抽象クラス
 */
public abstract class Animal {

    public String name; // 名前
    public int age; // 年齢

    public Animal() {

    }

    public Animal(String name,int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * その動物の紹介用メッセージを返却するメソッド
     */
    public String introduce() {
        // 返却用メッセージ
        String result = "";
        result += "名前は" + name + "です。年齢は" + age + "歳です。";
        result += introduceAge();

        // メッセージを返却
        return result;
    }

    /**
     * その動物の年齢についての紹介用メッセージを返却するメソッド
     */
    public abstract String introduceAge();

    /**
     * その動物の取り込むファイル名を返却するメソッド
     */
    public abstract String getFilePath();
}
