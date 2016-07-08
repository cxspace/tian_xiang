package control;

import entity.Indent;
import service.IndentService;
import service.OrderService;

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
 * Created by cxspace on 16-7-5.
 */

public class settleAccount extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         request.setCharacterEncoding("utf-8");

         HttpSession session = request.getSession(true);

         String select = request.getParameter("select");

         String method = null;


         if (select.equals("zfb")){
             method="支付宝";
         }else if (select.equals("hdfk")){
             method="货到付款";
         }

         List<String> indentId = (List<String>) session.getAttribute("allIndentId");

    //     System.out.println(select);

      //   System.out.println(indentId);

        try {
            if (OrderService.setIntentMethod(indentId,method)&&OrderService.setIndentStauts(indentId)){
                System.out.println("提交成功");
            }else {
                //提交失败
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (select.equals("hdfk")){

             request.getRequestDispatcher("/front/hdfk.jsp").forward(request,response);
         }else if(select.equals("zfb")){

             request.getRequestDispatcher("/front/zfb.jsp").forward(request,response);
         }else {


             // 系统错误
         }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          doPost(request,response);
    }
}
