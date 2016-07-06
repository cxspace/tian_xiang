package service.system.frontBean;

/**
 * Created by hjc on 16-7-5.
 */
public class Good {
    private String goodClassName;
    //品类
    private String goodName;
    //品名
    private double goodPrice;
    //价格
    private String goodId;
    //商品id

    public String getGoodClassName() {
        return goodClassName;
    }

    public void setGoodClassName(String goodClassName) {
        this.goodClassName = goodClassName;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public Good() {
    }
}
