package control;

import service.IndentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cxspace on 16-7-5.
 */

public class deleteOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.setCharacterEncoding("utf-8");

          String indentId = request.getParameter("indentId");

        //  System.out.println(indentId);
          if (IndentService.deleteIndent(indentId)){
          //    System.out.println("删除成功！");
              request.getRequestDispatcher("/front/order_list.jsp").forward(request,response);
          }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
