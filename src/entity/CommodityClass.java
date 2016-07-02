package entity;

/**
 * Created by hjc on 16-7-1.
 */
public class CommodityClass {
    //商品类别类

    private String cc_id;
    //商品类别id
    private String cc_name;
    //商品类别名

    public String getCc_name() {
        return cc_name;
    }

    public void setCc_name(String cc_name) {
        this.cc_name = cc_name;
    }

    public String getCc_id() {
        return cc_id;
    }

    public void setCc_id(String cc_id) {
        this.cc_id = cc_id;
    }

    public CommodityClass(String cc_id, String cc_name) {
        this.cc_id = cc_id;
        this.cc_name = cc_name;
    }

    public CommodityClass() {
    }
}
