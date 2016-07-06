package control.system;

import service.system.AddGoods;
import service.system.frontBean.AddGood;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by hjc on 16-7-6.
 */
@WebServlet(name = "AddGoodControl")
public class AddGoodControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String goodName = request.getParameter("goodName");
        String goodClassName = request.getParameter("goodClassName");
        String goodNumberString = request.getParameter("goodNumber");
        String goodPriceString = request.getParameter("goodPrice");
        String goodVipPriceString = request.getParameter("goodVipPrice");
        String goodDescribe = request.getParameter("goodDescribe");

        String goodPicture = "D:/123";

        AddGood good = new AddGood();
        good.setAddGoodName(goodName);
        good.setAddGoodClassName(goodClassName);
        good.setAddGoodNumber(Integer.parseInt(goodNumberString));
        good.setAddGoodPrice(Float.parseFloat(goodPriceString));
        good.setAddGoodVipPrice(Float.parseFloat(goodVipPriceString));
        good.setAddGoodPicture(goodPicture);
        good.setAddGoodDescribe(goodDescribe);

        AddGoods addGoods = new AddGoods();
        try {
            addGoods.upDate(good);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/system/add_goods.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
