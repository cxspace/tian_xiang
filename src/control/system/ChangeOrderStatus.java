package control.system;

import dao.impl.IndentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cxspace on 16-7-12.
 */
@WebServlet(name = "ChangeOrderStatus")
public class ChangeOrderStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request.getParameter("OrderId"));

        String orderId = request.getParameter("OrderId");

        String day = request.getParameter("day");

        System.out.println(day);

        IndentDao indentDao = new IndentDao();

        indentDao.changeStatus(orderId,1);

        response.setContentType("text/html; charset=utf-8");

        if (day.equals("7")) {
            response.sendRedirect(request.getServletContext().getContextPath() + "/OrderControl?day=7");

        }else if (day.equals("15"))
        {
            response.sendRedirect(request.getServletContext().getContextPath() + "/OrderControl?day=15");

        }else if (day.equals("30"))
        {
            response.sendRedirect(request.getServletContext().getContextPath() + "/OrderControl?day=30");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
