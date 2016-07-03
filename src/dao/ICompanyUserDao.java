package dao;

import entity.CompanyUser;

import java.sql.SQLException;
import java.util.List;


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

    //查找所有公司用户

    public List<CompanyUser> findAll() throws SQLException;

}
