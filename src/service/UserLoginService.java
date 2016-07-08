package service;

import dao.impl.UserDao;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by cxspace on 16-7-4.
 */
public class UserLoginService {

    public static User isExist(HttpServletRequest request) throws SQLException {

        User user = new User();

        //System.out.println(request.getParameter("username")+request.getParameter("password"));

        String phone = request.getParameter("phone");

        String password = request.getParameter("password");

        UserDao userDao = new UserDao();

        user = userDao.find(phone , password);

        return user;
    }
}
