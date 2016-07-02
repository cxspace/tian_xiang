package dao;

import entity.CompanyUser;

import java.sql.SQLException;


/**
 * Created by cxspace on 16-7-2.
 */
public interface ICompanyUserDao {
    /*
    *
    * 注册逻辑
    * */


    //添加用户
    public boolean add(CompanyUser companyUser);

    /*
        查找公司用户逻辑
     */

    public CompanyUser findFromId(String id) throws SQLException;

    public CompanyUser findFromPhone(String phone) throws SQLException;


}
