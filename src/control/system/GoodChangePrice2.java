package control.system;

import service.system.Goods;
import service.system.frontBean.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjc on 16-7-6.
 */
@WebServlet(name = "GoodChangePrice2")
public class GoodChangePrice2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        String goodPriceString = request.getParameter("goodPrice");
        String goodId = request.getParameter("goodId");

        double goodPrice = Double.parseDouble(goodPriceString);

        Goods goods = new Goods();
        //service

        try {
            goods.changePrice(goodId,goodPrice);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Good> goodList = new ArrayList<>();
        try {
            goodList = goods.allGood();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        session.setAttribute("goodList",goodList);
        request.getRequestDispatcher("/system/change_goodsprice.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
