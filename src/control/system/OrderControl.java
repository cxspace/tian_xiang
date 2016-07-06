package control.system;

import service.system.Orders;
import service.system.frontBean.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by hjc on 16-7-5.
 */

public class OrderControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        String dayString = request.getParameter("day");
        int day = Integer.parseInt(dayString);
        //初始化request数据

        HttpSession session = request.getSession();

        Orders orders = new Orders();

        List<Order> orderList = null;
        String key = null;

        switch (day){
            case 0:
                try {
                    orderList = orders.underHandOrder();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                key = "currentOrder";
                session.setAttribute(key,orderList);
                request.getRequestDispatcher("/system/current_order.jsp").forward(request,response);
                break;
            case 7:
                try {
                    orderList = orders.findNearlyOrder(7);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                key = "nearly7Order";
                session.setAttribute(key,orderList);
                request.getRequestDispatcher("/system/sevendays_order.jsp").forward(request,response);
                break;
            case 15:
                try {
                    orderList = orders.findNearlyOrder(15);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                key = "nearly15Order";
                session.setAttribute(key,orderList);
                request.getRequestDispatcher("/system/fifteendays_order.jsp").forward(request,response);
                break;
            default:
                try {
                    orderList = orders.findNearlyOrder(7);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                key = "nearly30Order";
                session.setAttribute(key,orderList);
                request.getRequestDispatcher("/system/onemonth_order.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
