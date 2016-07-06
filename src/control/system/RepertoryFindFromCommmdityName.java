package control.system;

import service.system.Repertorys;
import service.system.frontBean.Repertory;

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
 * Created by hjc on 16-7-5.
 */

public class RepertoryFindFromCommmdityName extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        String commodityName = request.getParameter("commodityName");

        Repertorys repertorys = new Repertorys();
        //service
        List<Repertory> repertoryList = new ArrayList<Repertory>();
        try {
            repertoryList = repertorys.findFromName(commodityName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        session.setAttribute("repertoryList",repertoryList);
        request.getRequestDispatcher("/system/stock_manage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
