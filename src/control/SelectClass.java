package control;

import entity.Commodity;
import service.CommodityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by cxspace on 16-7-4.
 */

public class SelectClass extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");

         String classId = request.getParameter("classId");

        try {

            List<Commodity> allCommodities = CommodityService.findAllCommodity(classId);

            request.setAttribute("allCommodities",allCommodities);

            request.getRequestDispatcher("/front/product.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }
}
