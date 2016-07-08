package control;

import frombean.CompanyRegisterBean;
import service.CompanyUserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cxspace on 16-7-4.
 */

public class companyUserRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        //验证输入
        if(!CompanyUserService.Verify(request)){
            request.getRequestDispatcher("/front/register_fail.jsp").forward(request,response);
        }

        else {

            //把前端输入设置到form表单
            CompanyRegisterBean companyRegisterBean = CompanyUserService.addToFrombean(request);

            if (!CompanyUserService.addCompanyUser(companyRegisterBean)) {
                request.getRequestDispatcher("/front/register_fail.jsp").forward(request, response);
                // request.getRequestDispatcher("/front/systemError.jsp").forward(request,response);
            } else {
                request.getRequestDispatcher("/front/register_success.jsp").forward(request, response);
                // request.getRequestDispatcher("/front/index.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
