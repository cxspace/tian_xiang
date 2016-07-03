package entity;

import java.sql.Timestamp;

/**
 * Created by cxspace on 16-7-1.
 */

public class CompanyUser {

    private String company_id;
    private String user_user_id;

    private String company_name;
    private String major_businesses;
    private String receiver_address;

    //联系人名字
    private String cp_name;

    private int gender;

    private Timestamp cp_birthday;

    private String cp_phone_number;

    private String company_phone_number;

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getUser_user_id() {
        return user_user_id;
    }

    public void setUser_user_id(String user_user_id) {
        this.user_user_id = user_user_id;
    }

    private String cp_qq;

    private String cp_weixin;

    public String getCompany_phone_number() {
        return company_phone_number;
    }

    public void setCompany_phone_number(String company_phone_number) {
        this.company_phone_number = company_phone_number;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getMajor_businesses() {
        return major_businesses;
    }

    public void setMajor_businesses(String major_businesses) {
        this.major_businesses = major_businesses;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public String getCp_name() {
        return cp_name;
    }

    public void setCp_name(String cp_name) {
        this.cp_name = cp_name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Timestamp getCp_birthday() {
        return cp_birthday;
    }

    public void setCp_birthday(Timestamp cp_birthday) {
        this.cp_birthday = cp_birthday;
    }

    public String getCp_phone_number() {
        return cp_phone_number;
    }

    public void setCp_phone_number(String cp_phone_number) {
        this.cp_phone_number = cp_phone_number;
    }

    public String getCp_qq() {
        return cp_qq;
    }

    public void setCp_qq(String cp_qq) {
        this.cp_qq = cp_qq;
    }

    public String getCp_weixin() {
        return cp_weixin;
    }

    public void setCp_weixin(String cp_weixin) {
        this.cp_weixin = cp_weixin;
    }

    @Override
    public String toString() {
        return "CompanyUser{" +
                "company_id='" + company_id + '\'' +
                ", user_user_id='" + user_user_id + '\'' +
                ", company_name='" + company_name + '\'' +
                ", major_businesses='" + major_businesses + '\'' +
                ", receiver_address='" + receiver_address + '\'' +
                ", cp_name='" + cp_name + '\'' +
                ", gender=" + gender +
                ", cp_birthday=" + cp_birthday +
                ", cp_phone_number='" + cp_phone_number + '\'' +
                ", company_phone_number='" + company_phone_number + '\'' +
                ", cp_qq='" + cp_qq + '\'' +
                ", cp_weixin='" + cp_weixin + '\'' +
                '}';
    }
}
