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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjc on 16-7-5.
 */
@WebServlet(name = "CustomerFindFromName")
public class CustomerFindFromName extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        String name = request.getParameter("name");

        Customers customers = new Customers();
        //service
        List<Customer> customerList = new ArrayList<Customer>();
        try {
            customerList = customers.findFromName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();
        String key = "currentCustomer";
        session.setAttribute(key,customerList);
        request.getRequestDispatcher("/system/current_customers.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
