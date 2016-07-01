package entity;

import java.sql.Timestamp;

/**
 * Created by cxspace on 16-7-1.
 */
public class PersonalUser {
    private long person_id;

    private long user_user_id;

    private String major_businesses;

    private String receiver_address;

    private String person_name;

    private int gender;

    private Timestamp birthday;

    private String phone_number;

    private String qq;

    private String weixin;

    public long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(long person_id) {
        this.person_id = person_id;
    }

    public long getUser_user_id() {
        return user_user_id;
    }

    public void setUser_user_id(long user_user_id) {
        this.user_user_id = user_user_id;
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

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    @Override
    public String toString() {
        return "PersonalUser{" +
                "person_id=" + person_id +
                ", user_user_id=" + user_user_id +
                ", major_businesses='" + major_businesses + '\'' +
                ", receiver_address='" + receiver_address + '\'' +
                ", person_name='" + person_name + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", phone_number='" + phone_number + '\'' +
                ", qq='" + qq + '\'' +
                ", weixin='" + weixin + '\'' +
                '}';
    }
}
