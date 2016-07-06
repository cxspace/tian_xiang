package control.system;

import entity.Manager;
import service.system.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by hjc on 16-7-4.
 */

public class ManagerLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String managerName = request.getParameter("managerName");
        String managerPassword = request.getParameter("managerPassword");
        RequestDispatcher rd ;
        Manager findedManager = null;
        try {
            findedManager = new Login().findManagerFromName(managerName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String tip = null;
        if(findedManager == null){
            tip = "用户名错误";
            rd = request.getRequestDispatcher("/system/login_fail.jsp");
        }else if(!findedManager.getManager_password().equals(managerPassword)){
            tip = "密码错误";
            rd = request.getRequestDispatcher("/system/login_fail.jsp");
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("managerId",findedManager.getManager_id());
            rd = request.getRequestDispatcher("/system/manager_system.jsp");
        }
        if(tip!=null){
            HttpSession session = request.getSession();
            session.setAttribute("tip",tip);
        }
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
