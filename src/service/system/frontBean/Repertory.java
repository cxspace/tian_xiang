package service.system.frontBean;

/**
 * Created by hjc on 16-7-5.
 */
public class Repertory {
    private String commodityClassName;
    //商品类别名称
    private String commodityName;
    //商品名称
    private int scale;
    //规格
    private int number;
    //数量
    private String date;
    //变化时间
    private String status;
    //进出货情况
    private String chargePersonName;
    //进出货负责人


    public String getCommodityClassName() {
        return commodityClassName;
    }

    public void setCommodityClassName(String commodityClassName) {
        this.commodityClassName = commodityClassName;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getChargePersonName() {
        return chargePersonName;
    }

    public void setChargePersonName(String chargePersonName) {
        this.chargePersonName = chargePersonName;
    }

    public Repertory() {
    }
}
