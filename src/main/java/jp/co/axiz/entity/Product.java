package jp.co.axiz.entity;

/**
 *
 * 商品用クラス
 *
 */
public class Product {

	// 商品分類（今回の演習では画面表示していないが、今後使用する可能性があるため定義している）
	private String productClassification;

	// 商品名
    private String productName;

    // 金額
    private int price;


    //コンストラクタ
    public Product() {

    }

    public Product(String productClassification, String productName, int price) {
        setProductClassification(productClassification);
        setProductName(productName);
        setPrice(price);
    }


    //各フィールドのセレクター
    public String getProductClassification() {
        return productClassification;
    }

    public void setProductClassification(String productClassification) {
        this.productClassification = productClassification;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName =  productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
