package entity;

/**
 * Created by hjc on 16-7-1.
 */
public class Commodity {
    //具体商品类

    private int c_id;
    //商品id

    private String c_name;
    //商品名

    private int commodity_class_cc_id;
    //该商品的类别id

    private int c_number;
    //该商品的剩余数量

    private String c_picture;
    //该商品的图片

    private float c_price;
    //该商品的单价（普通价）

    private float c_vip_price;
    //该商品的会员价

    private String c_describe;
    //该商品的描述

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getCommodity_class_cc_id() {
        return commodity_class_cc_id;
    }

    public void setCommodity_class_cc_id(int commodity_class_cc_id) {
        this.commodity_class_cc_id = commodity_class_cc_id;
    }

    public int getC_number() {
        return c_number;
    }

    public void setC_number(int c_number) {
        this.c_number = c_number;
    }

    public String getC_picture() {
        return c_picture;
    }

    public void setC_picture(String c_picture) {
        this.c_picture = c_picture;
    }

    public float getC_price() {
        return c_price;
    }

    public void setC_price(float c_price) {
        this.c_price = c_price;
    }

    public float getC_vip_price() {
        return c_vip_price;
    }

    public void setC_vip_price(float c_vip_price) {
        this.c_vip_price = c_vip_price;
    }

    public String getC_describe() {
        return c_describe;
    }

    public void setC_describe(String c_describe) {
        this.c_describe = c_describe;
    }

    public Commodity() {
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "c_id=" + c_id +
                ", c_name='" + c_name + '\'' +
                ", commodity_class_cc_id=" + commodity_class_cc_id +
                ", c_number=" + c_number +
                ", c_picture='" + c_picture + '\'' +
                ", c_price=" + c_price +
                ", c_vip_price=" + c_vip_price +
                ", c_describe='" + c_describe + '\'' +
                '}';
    }
}
