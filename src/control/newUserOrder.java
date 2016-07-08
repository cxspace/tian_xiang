package control;

import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by cxspace on 16-7-4.
 */

public class newUserOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession(true);

        //记录下单商品id
        String commodityId = (String)session.getAttribute("commodityId");
        //记录下单商品数量
        String commodityNumber = (String) session.getAttribute("commodityNumber");
        //记录购买者id
        String buyerId = (String) session.getAttribute("userId");


        if (request.getParameter("YYYY").equals("")||request.getParameter("MM").equals("")||request.getParameter("DD").equals(""))
        {
            //
        }

        try {

           if (OrderService.AddOrder(commodityId,buyerId,request,commodityNumber,response))
           {
               request.getRequestDispatcher("/front/order_list.jsp").forward(request,response);
           }else {
               //跳到错误页面
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
