package control;

import dao.impl.CommodityDao;
import dao.impl.UserDao;
import entity.Commodity;
import entity.CompanyUser;
import entity.PersonalUser;
import entity.User;
import service.CommodityService;
import service.CompanyUserService;
import service.PersonalUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by cxspace on 16-7-5.
 */

public class getOrderUserMessage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession(true);

        //如果未登录购买,到登录页面
        if (session.getAttribute("userId")==null){
            request.getRequestDispatcher("/front/filter.jsp").forward(request,response);
        }

        //拿到选择商品的id
        String commodityId = request.getParameter("CommodityId");

        session.setAttribute("commodityId",commodityId);

        //拿到下单数量
        String commodityNumber = request.getParameter("number");



        session.setAttribute("commodityNumber",commodityNumber);


        try {
            int number = Integer.parseInt(commodityNumber);

            // 用户下单数量减少的逻辑
            int crruentNumber = (int)session.getAttribute("lastNumber")-number;

            System.out.println(crruentNumber);

            CommodityDao commodityDao = new CommodityDao();

            commodityDao.updateComodityNumber(crruentNumber);

        }catch (NumberFormatException e)
        {
            request.getRequestDispatcher("/front/input_error.jsp").forward(request,response);
         //   System.out.println("异常");
        }finally {
        }

        //拿到当前用户id
        String userId = (String) session.getAttribute("userId");

        //拿到当前用户在用户总表中的信息
        UserDao userDao = new UserDao();
        User user = new User();

        PersonalUser personalUser = new PersonalUser();
        CompanyUser companyUser = new CompanyUser();

        try {
            user = userDao.findFromId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //拿到当前用户在其对应用户表中的信息
        if (user.getFlag()==0){
            //如果是普通用户
            try {
                 personalUser = PersonalUserService.findById(userId);

          //      System.out.println(personalUser);

                session.setAttribute("personalUser",personalUser);
            } catch (SQLException e) {

                //出错
                e.printStackTrace();
            }

        }else if (user.getFlag()==1)
        {
            //如果是公司用户
            try {
                companyUser = CompanyUserService.findById(userId);
                session.setAttribute("companyUser",companyUser);

            } catch (SQLException e) {
                //出错
                e.printStackTrace();
            }

        }else{
            //系统错误
        }


        System.out.println(user);



        request.getRequestDispatcher("/front/verify_order.jsp").forward(request,response);



      //  System.out.println(commodityId+"-"+commodityNumber);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
