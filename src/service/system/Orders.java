package service.system;

import dao.impl.CompanyUserDao;
import dao.impl.IndentDao;
import dao.impl.PersonalUserDao;
import dao.impl.UserDao;
import entity.CompanyUser;
import entity.Indent;
import entity.PersonalUser;
import entity.User;
import service.system.frontBean.Order;
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
public class Orders {
    private Order findFromIndent(Indent indent) throws SQLException {
        //通过Indent查找Order信息

        UserDao userDao = new UserDao();
        CompanyUserDao companyUserDao = new CompanyUserDao();
        PersonalUserDao personalUserDao = new PersonalUserDao();

        Order order = new Order();

        String status = "";

        if (indent.getClearing_status()==0){

             status = "未确认付款";

        }else if (indent.getClearing_status()==1)
        {
            status ="已结清";

        }else if (indent.getClearing_status()==2)
        {
            status="未提交";
        }

        double totalPrice = indent.getTotal_price();
        String ordered = indent.getGoods();
        String orderDate = TransTimestamp.timestampToSecString(indent.getOrder_time());
        String orderId = indent.getIndent_id();

        String buyerId = indent.getBuyer_id();
        //通过购买者的id查找顾客名称，联系人，联系方式

        User user = userDao.findFromId(buyerId);

        String phone = user.getUser_phone();
        String customerName = null;
        String contactPersonName = null;

        if(user.getFlag()==0){
            //如果为个人顾客
            PersonalUser personalUser = personalUserDao.findFromId(user.getUser_id());
            contactPersonName = personalUser.getPerson_name();
            customerName = personalUser.getPerson_name();
        }else{
            //如果为公司顾客
            CompanyUser companyUser = companyUserDao.findFromId(user.getUser_id());
            contactPersonName = companyUser.getCp_name();
            customerName = companyUser.getCompany_name();
        }

        order.setOrderId(orderId);
        order.setStatus(status);
        order.setTotalPrice(totalPrice);
        order.setPhone(phone);
        order.setCpName(contactPersonName);
        order.setCustomerName(customerName);
        order.setOrdered(ordered);
        order.setOrderDate(orderDate);


        return order;
    }

    public List<Order> underHandOrder() throws SQLException {
        //查询所有未发货的订单
        IndentDao indentDao = new IndentDao();

        List<Order> underHandOrder = new ArrayList<Order>();
        //未发货订单列表

        List<Indent> allIndent = indentDao.findAllIndent();
        //所有订单列表

        for(Indent indent : allIndent){
            String deadLine = TransTimestamp.timestampToDayString(indent.getDeadline());
            String doDay = TransTimestamp.timestampToDayString(new Timestamp(System.currentTimeMillis()));
            if(deadLine.compareTo(doDay)>=0){
                //如果截止日期还没到,应该加入underHandOrder
                Order order = findFromIndent(indent);
                underHandOrder.add(order);
            }
        }
        return underHandOrder;
    }

    public List<Order> findNearlyOrder(int day) throws SQLException {
        //查询最近day天的订单
        Date toDay = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String someDay = df.format(new Date(toDay.getTime() - day * 24 * 60 * 60 * 1000));

        UserDao userDao = new UserDao();
        IndentDao indentDao = new IndentDao();
        CompanyUserDao companyUserDao = new CompanyUserDao();
        PersonalUserDao personalUserDao = new PersonalUserDao();

        List<Order> nearlyOrder = new ArrayList<Order>();
        //未发货订单列表

        List<Indent> allIndent = indentDao.findAllIndent();
        //所有订单列表

        for(Indent indent : allIndent){
            Timestamp orderTimestamp = indent.getOrder_time();
            String dayOrderTime = TransTimestamp.timestampToDayString(orderTimestamp);
            if(dayOrderTime.compareTo(someDay)>=0){
                //如果在最近日期中
                Order order = findFromIndent(indent);
                nearlyOrder.add(order);
            }
        }
        return nearlyOrder;
    }

    public List<Order> findOneDay(int day,int month,int year) throws SQLException {
        //查询某一天的订单
        Timestamp oneDayTimestamp = TransTimestamp.YMDToTimestamp(year,month,day);
        String oneDayString = TransTimestamp.timestampToDayString(oneDayTimestamp);

        IndentDao indentDao = new IndentDao();
        List<Indent> allIndent = indentDao.findAllIndent();
        int tag = 0;

        List<Order> oneDayOrder = new ArrayList<Order>();

        for(Indent indent : allIndent){
            String indentDayTime = TransTimestamp.timestampToDayString(indent.getOrder_time());
            if(indentDayTime.equals(oneDayString)){
                tag = 1;
                Order order = findFromIndent(indent);
                oneDayOrder.add(order);
            }
            if(tag==1&&!indentDayTime.equals(oneDayString)){
                break;
            }
        }
        return oneDayOrder;
    }

    public List<Order> findFromCustomerName(String customerName) throws SQLException {
        //跟据用户名查询订单
        IndentDao indentDao = new IndentDao();
        List<Indent> allIndent = indentDao.findAllIndent();

        List<Order> someOneOrder = new ArrayList<Order>();

        for(Indent indent : allIndent){
            Order order = findFromIndent(indent);
            if(order.getCustomerName().equals(customerName)){
                someOneOrder.add(order);
            }
        }

        return someOneOrder;
    }

    public List<Order> findUnStatus() throws SQLException {
        //查询未结算订单

        IndentDao indentDao = new IndentDao();
        List<Indent> unStatusIndent = indentDao.findFromStatus(0);

        List<Order> unStatusOrder = new ArrayList<Order>();

        for(Indent indent : unStatusIndent){
            Order order = findFromIndent(indent);
            unStatusOrder.add(order);
        }
        return unStatusOrder;
    }
}
