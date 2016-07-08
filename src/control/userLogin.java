package control;

import entity.User;
import service.UserLoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by cxspace on 16-7-4.
 */

public class userLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession(true);
        try {

              User user = UserLoginService.isExist(request);

        //    System.out.println(user);


            //登录成功逻辑

            if (user!=null&&(user.getUser_phone().length()==11)){

                //记录用户手机号和id号
                session.setAttribute("userPhone",user.getUser_phone());
                session.setAttribute("userId",user.getUser_id());

                request.getRequestDispatcher("/front/login_success.jsp").forward(request,response);
            }else {
                //登录失败
                request.getRequestDispatcher("/front/login_fail.jsp").forward(request,response);
            }


        } catch (SQLException e) {

            request.getRequestDispatcher("/front/systemError.jsp").forward(request,response);

            e.printStackTrace();

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
