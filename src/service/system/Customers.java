package service.system;

import dao.impl.CompanyUserDao;
import dao.impl.IndentDao;
import dao.impl.PersonalUserDao;
import dao.impl.UserDao;
import entity.CompanyUser;
import entity.Indent;
import entity.PersonalUser;
import service.system.frontBean.Customer;
import utils.TransTimestamp;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hjc on 16-7-5.
 */
public class Customers {
    public List<Customer> findAll() throws SQLException {
        //查询所有Customer
        PersonalUserDao personalUserDao = new PersonalUserDao();
        CompanyUserDao companyUserDao = new CompanyUserDao();
        IndentDao indentDao = new IndentDao();

        List<PersonalUser> personalUserList = personalUserDao.findAll();
        List<CompanyUser> companyUserList = companyUserDao.findAll();
        List<Indent> unStatusIndentList = indentDao.findFromStatus(0);
        //未结算清单表

        List<Customer> AllCustomer = new ArrayList<Customer>();

        for(PersonalUser personalUser : personalUserList){
            int unStatus = 0;
            for(Indent indent : unStatusIndentList){
                if(indent.getBuyer_id().equals(personalUser.getUser_user_id())){
                    //记录个人的未清算订单量
                    ++unStatus;
                }
            }
            Customer customer = new Customer();
            customer.setAddress(personalUser.getReceiver_address());
            customer.setCpName(personalUser.getPerson_name());
            customer.setCustomerName(personalUser.getPerson_name());
            customer.setPhone(personalUser.getPhone_number());
            customer.setStatus(unStatus);
            AllCustomer.add(customer);
        }

        for(CompanyUser companyUser : companyUserList){
            int unStatus = 0;
            for(Indent indent : unStatusIndentList){
                if(indent.getBuyer_id().equals(companyUser.getUser_user_id())){
                    //记录公司的未清算订单量
                    ++unStatus;
                }
            }
            Customer customer = new Customer();
            customer.setAddress(companyUser.getReceiver_address());
            customer.setCpName(companyUser.getCp_name());
            customer.setCustomerName(companyUser.getCompany_name());
            customer.setPhone(companyUser.getCp_phone_number());
            customer.setStatus(unStatus);
            AllCustomer.add(customer);
        }

        return AllCustomer;
    }

    public List<Customer> findUnderHandCustomer() throws SQLException {
        //查询当前下单Customer

        PersonalUserDao personalUserDao = new PersonalUserDao();
        CompanyUserDao companyUserDao = new CompanyUserDao();
        IndentDao indentDao = new IndentDao();

        List<PersonalUser> personalUserList = personalUserDao.findAll();
        List<CompanyUser> companyUserList = companyUserDao.findAll();

        List<Indent> allIndentList = indentDao.findAllIndent();

        String toDay = TransTimestamp.timestampToDayString(new Timestamp(System.currentTimeMillis()));


        List<Customer> underHandCustomer = new ArrayList<Customer>();
        //未到货Customer列表

        for(PersonalUser personalUser : personalUserList){
            int unStatus = 0;
            boolean unGot = false;
            //未到货订单量
            for(Indent indent : allIndentList){
                if(indent.getBuyer_id().equals(personalUser.getUser_user_id())){
                    //记录个人订单
                    if(indent.getClearing_status()==0){
                        ++unStatus;
                        //记录未结算订单数量
                    }
                    if(unGot == false) {
                        if (TransTimestamp.timestampToDayString(indent.getDeadline()).compareTo(toDay) > 0) {
                            //如果存在未到货订单
                            unGot = true;
                        }
                    }
                }
            }
            if(unGot == true) {
                Customer customer = new Customer();
                customer.setAddress(personalUser.getReceiver_address());
                customer.setCpName(personalUser.getPerson_name());
                customer.setCustomerName(personalUser.getPerson_name());
                customer.setPhone(personalUser.getPhone_number());
                customer.setStatus(unStatus);
                underHandCustomer.add(customer);
            }
        }

        for(CompanyUser companyUser : companyUserList){
            int unStatus = 0;
            boolean unGot = false;
            //未到货订单量
            for(Indent indent : allIndentList){
                if(indent.getBuyer_id().equals(companyUser.getUser_user_id())){
                    //记录个人订单
                    if(indent.getClearing_status()==0){
                        ++unStatus;
                        //记录未结算订单数量
                    }
                    if(unGot == false) {
                        if (TransTimestamp.timestampToDayString(indent.getDeadline()).compareTo(toDay) > 0) {
                            //如果存在未到货订单
                            unGot = true;
                        }
                    }
                }
            }
            if(unGot == true) {
                Customer customer = new Customer();
                customer.setAddress(companyUser.getReceiver_address());
                customer.setCpName(companyUser.getCp_name());
                customer.setCustomerName(companyUser.getCompany_name());
                customer.setPhone(companyUser.getCp_phone_number());
                customer.setStatus(unStatus);
                underHandCustomer.add(customer);
            }
        }

        return underHandCustomer;

    }

    public List<Customer> findNearlyCustomer(int day) throws SQLException{
        //查询前几天下单的用户

        Date toDay = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String someDay = df.format(new Date(toDay.getTime() - day * 24 * 60 * 60 * 1000));

        UserDao userDao = new UserDao();
        PersonalUserDao personalUserDao = new PersonalUserDao();
        CompanyUserDao companyUserDao = new CompanyUserDao();
        IndentDao indentDao = new IndentDao();

        List<PersonalUser> personalUserList = personalUserDao.findAll();
        List<CompanyUser> companyUserList = companyUserDao.findAll();
        List<Indent> IndentList = indentDao.findAllIndent();

        List<Customer> resultList = new ArrayList<Customer>();

        for(PersonalUser personalUser : personalUserList){
            int unStatus = 0;
            String nearestTime = null;
            for(Indent indent : IndentList){
                if(indent.getBuyer_id().equals(personalUser.getUser_user_id())){
                    //如果此人有订单
                    if(indent.getClearing_status()==0){
                        //如果还未结清
                        ++unStatus;
                    }
                    if(nearestTime==null|| TransTimestamp.timestampToDayString(indent.getOrder_time()).compareTo(nearestTime)>0){
                        //保证nearestTime为最近一次的购买时间
                        nearestTime = TransTimestamp.timestampToDayString(indent.getOrder_time());
                    }
                }
            }
            if(nearestTime.compareTo(someDay)>0){
                //是在指定时间内的订单
                Customer customer = new Customer();
                customer.setAddress(personalUser.getReceiver_address());
                customer.setCpName(personalUser.getPerson_name());
                customer.setCustomerName(personalUser.getPerson_name());
                customer.setPhone(personalUser.getPhone_number());
                customer.setStatus(unStatus);
                resultList.add(customer);
            }
        }
        for(CompanyUser companyUser : companyUserList){
            int unStatus = 0;
            String nearestTime = null;
            for(Indent indent : IndentList){
                if(indent.getBuyer_id().equals(companyUser.getUser_user_id())){
                    //如果此人有订单
                    if(indent.getClearing_status()==0){
                        //如果还未结清
                        ++unStatus;
                    }
                    if(nearestTime==null|| TransTimestamp.timestampToDayString(indent.getOrder_time()).compareTo(nearestTime)>0){
                        //保证nearestTime为最近一次的购买时间
                        nearestTime = TransTimestamp.timestampToDayString(indent.getOrder_time());
                    }
                }
            }
            if(nearestTime.compareTo(someDay)>0){
                //是在指定时间内的订单
                Customer customer = new Customer();
                customer.setAddress(companyUser.getReceiver_address());
                customer.setCpName(companyUser.getCp_name());
                customer.setCustomerName(companyUser.getCompany_name());
                customer.setPhone(companyUser.getCp_phone_number());
                customer.setStatus(unStatus);
                resultList.add(customer);
            }
        }
        return resultList;
    }

    public List<Customer> findFromName(String name) throws SQLException {
        List<Customer> customerList = findAll();
        List<Customer> resultList = new ArrayList<Customer>();
        for(Customer customer : customerList){
            if(name.equals(customer.getCustomerName())){
                resultList.add(customer);
            }
        }
        return resultList;
    }
}
