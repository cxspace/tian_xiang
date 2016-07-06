package service.system.frontBean;

/**
 * Created by hjc on 16-7-6.
 */
public class AddGood {
    private String addGoodName;
    //添加商品的名称
    private String addGoodClassName;
    //添加商品的类别名称
    private int addGoodNumber;
    //添加商品的数量
    private float addGoodPrice;
    //添加商品的单价
    private float addGoodVipPrice;
    //添加商品的会员价
    private String addGoodPicture;
    //添加商品的图片
    private String addGoodDescribe;
    //添加商品的描述

    public String getAddGoodName() {
        return addGoodName;
    }

    public void setAddGoodName(String addGoodName) {
        this.addGoodName = addGoodName;
    }

    public String getAddGoodClassName() {
        return addGoodClassName;
    }

    public void setAddGoodClassName(String addGoodClassName) {
        this.addGoodClassName = addGoodClassName;
    }

    public int getAddGoodNumber() {
        return addGoodNumber;
    }

    public void setAddGoodNumber(int addGoodNumber) {
        this.addGoodNumber = addGoodNumber;
    }

    public float getAddGoodPrice() {
        return addGoodPrice;
    }

    public void setAddGoodPrice(float addGoodPrice) {
        this.addGoodPrice = addGoodPrice;
    }

    public float getAddGoodVipPrice() {
        return addGoodVipPrice;
    }

    public void setAddGoodVipPrice(float addGoodVipPrice) {
        this.addGoodVipPrice = addGoodVipPrice;
    }

    public String getAddGoodPicture() {
        return addGoodPicture;
    }

    public void setAddGoodPicture(String addGoodPicture) {
        this.addGoodPicture = addGoodPicture;
    }

    public String getAddGoodDescribe() {
        return addGoodDescribe;
    }

    public void setAddGoodDescribe(String addGoodDescribe) {
        this.addGoodDescribe = addGoodDescribe;
    }

    public AddGood() {
    }
}
