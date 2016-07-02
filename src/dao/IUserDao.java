package dao;

import entity.User;

import java.sql.SQLException;

/**
 * Created by cxspace on 16-7-1.
 */
public interface IUserDao {
    /*
    *     注册逻辑
    * */

    /*
          添加用户数据
     */

    public boolean add(User user);


    /*
          登录逻辑

          功能：根据手机号,密码查询用户

          返回一个用户对象
     */

    public User find(String phone , String password) throws SQLException;




}
