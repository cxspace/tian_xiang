package dao;

import entity.PersonalUser;

import java.sql.SQLException;

/**
 * Created by cxspace on 16-7-2.
 */
public interface IPersonalUserDao {

    /*
        注册逻辑
     */

    //添加用户
    public boolean add(PersonalUser personalUser);


    /*
        查找个人用户逻辑
     */

    //通过id查询个人用户
    public PersonalUser findFromId(String id) throws SQLException;


    //通过phone查询个人用户
    public PersonalUser findFromPhone(String phone) throws SQLException;


}
