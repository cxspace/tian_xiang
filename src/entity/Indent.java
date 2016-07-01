package entity;

import java.sql.Timestamp;

/**
 * Created by hjc on 16-7-1.
 */
public class Indent {
    //订单类

    private String indent_id;
    //订单id（使用随机生成的字符串）

    private long buyer_id;
    //购买者的id

    private Timestamp order_time;
    //下单时间

    private Timestamp deadline;
    //收货时间

    private String goods;
    //订单中包含的商品

    private double total_price;
    //订单总价

    private String remark;
    //买方附加说明

    private String clearing_form;
    //结算方式

    private int clearing_status;
    //是否结清（0未结清，1已结清）


    public String getIndent_id() {
        return indent_id;
    }

    public void setIndent_id(String indent_id) {
        this.indent_id = indent_id;
    }

    public long getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(long buyer_id) {
        this.buyer_id = buyer_id;
    }

    public Timestamp getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Timestamp order_time) {
        this.order_time = order_time;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getClearing_form() {
        return clearing_form;
    }

    public void setClearing_form(String clearing_form) {
        this.clearing_form = clearing_form;
    }

    public int getClearing_status() {
        return clearing_status;
    }

    public void setClearing_status(int clearing_status) {
        this.clearing_status = clearing_status;
    }

    public Indent() {
    }

    @Override
    public String toString() {
        return "Indent{" +
                "indent_id='" + indent_id + '\'' +
                ", buyer_id=" + buyer_id +
                ", order_time=" + order_time +
                ", deadline=" + deadline +
                ", goods='" + goods + '\'' +
                ", total_price=" + total_price +
                ", remark='" + remark + '\'' +
                ", clearing_form='" + clearing_form + '\'' +
                ", clearing_status=" + clearing_status +
                '}';
    }
}
