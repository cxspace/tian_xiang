package control.system;

import service.FileUpUtils;
import service.system.AddGoods;
import service.system.frontBean.AddGood;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by hjc on 16-7-6.
 */
@WebServlet(name = "AddGoodControl")
public class AddGoodControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        //123456789012
        String id = WebUtils.getRandomId(12);

        List<String> params = FileUpUtils.fileUpload(request,id);



        String goodName = params.get(0);
        String goodClassName = params.get(1);
        String goodNumberString = params.get(2);
        String goodPriceString = params.get(3);
        String goodVipPriceString = params.get(4);
        String goodPicture = params.get(5);
        String goodDescribe = params.get(6);

        System.out.print(goodName);
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
