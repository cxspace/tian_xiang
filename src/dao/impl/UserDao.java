package dao.impl;

import dao.IUserDao;
import entity.User;
import utils.JdbcUtils;
import utils.WebUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cxspace on 16-7-1.
 */

public class UserDao implements IUserDao {

    //sql语句

    private String strSql;

    /*
        添加用户信息

        id随机12数



     */

    @Override
    public boolean add(User user) {

        strSql = "insert into user(user_id ,user_phone , user_password , user_flag ) values (";
        strSql += "'"+ user.getUser_id()+"',";
        strSql += "'"+ user.getUser_phone() +"',";
        strSql += "'"+ user.getUser_password()+"',";
        strSql += "'"+user.getFlag()+"');";

        return JdbcUtils.exeSql(strSql);

    }

    /*
         根据电话和密码查询用户
     */

    @Override
    public User find(String phone, String password) throws SQLException {

        ResultSet rs = null;

        //select* from user where user_phone = '13037239781' and user_password = '123456';


        strSql = "select * from user where user_phone = '"+phone+" ' "+" and user_password = '"+password+"';";

        rs = JdbcUtils.exeSqlQuery(strSql);

        User user = new User();

        if (rs.next()) {

            user.setUser_id(rs.getString("user_id"));
            user.setUser_phone(rs.getString("user_phone"));
            user.setUser_password(rs.getString("user_password"));
            user.setFlag(rs.getInt("user_flag"));

        }else {
            return null;
        }

        return user;
    }
}
