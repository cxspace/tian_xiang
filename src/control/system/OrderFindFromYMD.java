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
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjc on 16-7-5.
 */
@WebServlet(name = "OrderFindFromYMD")
public class OrderFindFromYMD extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        HttpSession session = request.getSession();
        String dayString = request.getParameter("DD");
        String monthString = request.getParameter("MM");
        String yearString = request.getParameter("YYYY");
        int day = Integer.parseInt(dayString);
        int month = Integer.parseInt(monthString);
        int year = Integer.parseInt(yearString);

        Orders orders = new Orders();

        List<Order> orderList = new ArrayList<Order>();

        try {
            orderList = orders.findOneDay(day,month,year);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String key = "currentOrder";
        session.setAttribute(key,orderList);
        request.getRequestDispatcher("/system/current_order.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
