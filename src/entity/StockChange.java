package entity;

import java.sql.Timestamp;

/**
 * Created by cxspace on 16-7-1.
 */
public class StockChange {

    private long stock_change_id;

    private String commodity_class;

    private String commodity_name;

    private int commodity_standard;

    private int package_number;

    private Timestamp change_date;

    private int change_flag;

    private String charge_person;

    public long getStock_change_id() {
        return stock_change_id;
    }

    public void setStock_change_id(long stock_change_id) {
        this.stock_change_id = stock_change_id;
    }

    public String getCommodity_class() {
        return commodity_class;
    }

    public void setCommodity_class(String commodity_class) {
        this.commodity_class = commodity_class;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public int getCommodity_standard() {
        return commodity_standard;
    }

    public void setCommodity_standard(int commodity_standard) {
        this.commodity_standard = commodity_standard;
    }

    public int getPackage_number() {
        return package_number;
    }

    public void setPackage_number(int package_number) {
        this.package_number = package_number;
    }

    public Timestamp getChange_date() {
        return change_date;
    }

    public void setChange_date(Timestamp change_date) {
        this.change_date = change_date;
    }

    public int getChange_flag() {
        return change_flag;
    }

    public void setChange_flag(int change_flag) {
        this.change_flag = change_flag;
    }

    public String getCharge_person() {
        return charge_person;
    }

    public void setCharge_person(String charge_person) {
        this.charge_person = charge_person;
    }

    @Override
    public String toString() {
        return "StockChange{" +
                "stock_change_id=" + stock_change_id +
                ", commodity_class='" + commodity_class + '\'' +
                ", commodity_name='" + commodity_name + '\'' +
                ", commodity_standard=" + commodity_standard +
                ", package_number=" + package_number +
                ", change_date=" + change_date +
                ", change_flag=" + change_flag +
                ", charge_person='" + charge_person + '\'' +
                '}';
    }
}
