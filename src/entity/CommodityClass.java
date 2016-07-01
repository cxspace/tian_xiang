package entity;

/**
 * Created by hjc on 16-7-1.
 */
public class CommodityClass {
    //商品类别对象

    private int cc_id;
    //商品类别id
    private String cc_name;
    //商品类别名

    public String getCc_name() {
        return cc_name;
    }

    public void setCc_name(String cc_name) {
        this.cc_name = cc_name;
    }

    public int getCc_id() {
        return cc_id;
    }

    public void setCc_id(int cc_id) {
        this.cc_id = cc_id;
    }

    public CommodityClass(int cc_id, String cc_name) {
        this.cc_id = cc_id;
        this.cc_name = cc_name;
    }

    public CommodityClass() {
    }
}
