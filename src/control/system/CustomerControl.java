package control.system;

import service.system.Customers;
import service.system.frontBean.Customer;

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
 * Created by hjc on 16-7-5.
 */

public class CustomerControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        String dayString = request.getParameter("day");
        int day = Integer.parseInt(dayString);
        //初始化request数据

        Customers customers = new Customers();
        //service

        HttpSession session = request.getSession();

        if(day==-1){
            //所有客户
            List<Customer> allCustomer = null;
            try {
                allCustomer = customers.findAll();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(allCustomer!=null){
                session.setAttribute("allCustomer",allCustomer);
            }
            request.getRequestDispatcher("/system/all_customers.jsp").forward(request,response);
        }else if(day==0){
            //未到货Customer
            List<Customer> underHandCustomer = null;
            try {
                underHandCustomer = customers.findUnderHandCustomer();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(underHandCustomer!=null){
                session.setAttribute("currentCustomer",underHandCustomer);
            }
            request.getRequestDispatcher("/system/current_customers.jsp").forward(request,response);
        }else{
            //最近day天定过单的Customer
            List<Customer> nearlyCustomer = null;
            String key = "nearly"+day+"Customer";
            //session中输入的键值

            try {
                nearlyCustomer = customers.findNearlyCustomer(day);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(nearlyCustomer!=null){
                session.setAttribute(key,nearlyCustomer);
            }

            switch (day){
                case 7:
                    request.getRequestDispatcher("/system/sevendays_customers.jsp").forward(request,response);
                    break;
                case 15:
                    request.getRequestDispatcher("/system/fifteendays_customers.jsp").forward(request,response);
                    break;
                default:
                    request.getRequestDispatcher("/system/onemonths_customers.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
