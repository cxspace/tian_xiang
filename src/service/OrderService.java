package service;

import dao.impl.CommodityClassDao;
import dao.impl.CommodityDao;
import dao.impl.IndentDao;
import entity.Commodity;
import entity.CommodityClass;
import entity.Indent;
import utils.TransTimestamp;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by cxspace on 16-7-4.
 */
public class OrderService {

  /*
    拿到了商品id,下单的件数

    拿商品对象
    */
    public static Commodity findCommodityById(String commodityId) throws SQLException {

        Commodity commodity = new Commodity();

        CommodityDao commodityDao = new CommodityDao();

        commodity = commodityDao.findFromC_Id(commodityId);

        return commodity;
    }

    /*
      通过商品id拿到

      商品类对象

     */
    public static CommodityClass findCommodityClassById(String commodityId) throws SQLException {

        Commodity commodity = findCommodityById(commodityId);

        String commodityClassId = commodity.getCommodity_class_cc_id();

        CommodityClassDao commodityClassDao = new CommodityClassDao();

        CommodityClass commodityClass = new CommodityClass();

        commodityClass = commodityClassDao.findFromId(commodityClassId);

        return commodityClass;

    }

    //注入数据库
    public static boolean AddOrder(String commodityId , String buyerId , HttpServletRequest request , String commodityNumber , HttpServletResponse response) throws SQLException, ServletException, IOException {

        boolean flag = false;

        //随机16位订单id号
        String orderId = WebUtils.getRandomId(16);
        CommodityDao commodityDao = new CommodityDao();

        //拿到商品对象
        Commodity commodity = commodityDao.findFromC_Id(commodityId);
        CommodityClassDao commodityClassDao = new CommodityClassDao();
        //拿到商品类别对象
        CommodityClass commodityClass = commodityClassDao.findFromId(commodity.getCommodity_class_cc_id());
        Indent indent = new Indent();

        //设置订单id
        indent.setIndent_id(orderId);

        //设置购买者id
        indent.setBuyer_id(buyerId);

        //拿到当前时间,下单时间
        Date date = new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
        Timestamp orderTime = TransTimestamp.stringToTimestamp(time);

        //设置下单时间
        indent.setOrder_time(orderTime);





        //拿到用户要求的收货时间

        int year = Integer.parseInt(request.getParameter("YYYY"));

        int month = Integer.parseInt(request.getParameter("MM"));

        int day = 0;

        try {
            day = Integer.parseInt(request.getParameter("DD"));
        }catch (NumberFormatException e)
        {
            request.getRequestDispatcher("/front/input_error.jsp").forward(request,response);
        }

        Timestamp deadline = TransTimestamp.YMDToTimestamp(year,month,day);
        //设置要求送达时间
        indent.setDeadline(deadline);


        System.out.println(year+"-"+month+"-"+day);

        String goods = commodity.getC_name()+"%"+commodity.getC_price()+"*"+commodityNumber;

        indent.setGoods(goods);

        double total_price = Integer.parseInt(commodityNumber)*commodity.getC_price();

        indent.setTotal_price(total_price);

        indent.setRemark(commodity.getC_id());

        indent.setClearing_form("default");

        // 2未提交的订单

        indent.setClearing_status(2);

        IndentDao indentDao = new IndentDao();

        flag = indentDao.add(indent);

    //    System.out.println(time);

        /*

        订单表
indent

    订单id(随机产生16位数)                 not null

    下单者的id                            not null

    下单的时间                       not null

    要求送达时间                      not null

    购买的商品(/商品id%单价×数量/)          not null

    订单总价                           not null

    订单备注                       default ''

    结算方式                           not null

    结算情况( 0未结清 1已结清)         default '0'

  */




        return flag;

    }

    public static boolean setIndentStauts(List list) throws SQLException {

        boolean flag = false;

        IndentDao indentDao = new IndentDao();

        for(int i = 0 ; i < list.size(); i++)
        {

            Indent indent = indentDao.findFromIndent_id((String)list.get(i));

            //保证只有没提交状态的提交状态改变
            if (indent.getClearing_status()==2) {
                flag = indentDao.changeStatus((String) list.get(i), 0);
            }
        }

        return flag;
    }

    public static boolean setIntentMethod(List list, String method) throws SQLException {

        boolean flag = false;

        IndentDao indentDao = new IndentDao();

        for (int i = 0 ; i < list.size() ; i++){

            Indent indent = indentDao.findFromIndent_id((String) list.get(i));

            //如果未提交
            if (indent.getClearing_status()==2) {
                flag = indentDao.changeMethod((String) list.get(i), method);
            }
        }

        return flag;
    }

}
