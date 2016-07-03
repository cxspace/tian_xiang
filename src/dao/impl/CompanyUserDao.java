package dao.impl;

import dao.ICompanyUserDao;
import entity.CompanyUser;
import utils.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cxspace on 16-7-2.
 */
public class CompanyUserDao implements ICompanyUserDao {

    private String strSql;

    /*
    *  传入一个公司用户对象，注入数据
    *
    * */


    @Override
    public boolean add(CompanyUser companyUser) {

        strSql = "insert into company_user ";
        strSql += "( company_id ,";
        strSql += "  user_user_id,";
        strSql += "company_name,";
        strSql += "major_businesses,";
        strSql += "receiver_address,";
        strSql += "cp_name,";
        strSql += "gender,";
        strSql += "cp_birthday,";
        strSql += "cp_phone_number,";
        strSql += "company_phone_number,";
        strSql += "cp_qq,";
        strSql += "cp_weixin ) values (";
        strSql += "'"+companyUser.getCompany_id()+"',";
        strSql += "'"+companyUser.getUser_user_id()+"',";
        strSql += "'"+companyUser.getCompany_name()+"',";
        strSql += "'"+companyUser.getMajor_businesses()+"',";
        strSql += "'"+companyUser.getReceiver_address()+"',";
        strSql += "'"+companyUser.getCp_name()+"',";
        strSql += "'"+companyUser.getGender()+"',";
        strSql += "'"+companyUser.getCp_birthday()+"',";
        strSql += "'"+companyUser.getCp_phone_number()+"',";
        strSql += "'"+companyUser.getCompany_phone_number()+"',";
        strSql += "'"+companyUser.getCp_qq()+"',";
        strSql += "'"+companyUser.getCp_weixin()+"');";

        return JdbcUtils.exeSql(strSql);

    }

    @Override
    public CompanyUser findFromId(String id) throws SQLException {

        strSql ="select * from company_user where company_id = '"+id+"';";
        ResultSet rs = JdbcUtils.exeSqlQuery(strSql);

        CompanyUser companyUser = new CompanyUser();

        if (rs.next())

        {
            companyUser.setCompany_id(rs.getString("company_id"));
            companyUser.setUser_user_id(rs.getString("user_user_id"));
            companyUser.setCompany_name(rs.getString("company_name"));
            companyUser.setMajor_businesses(rs.getString("major_businesses"));
            companyUser.setReceiver_address(rs.getString("receiver_address"));
            companyUser.setCp_name(rs.getString("cp_name"));
            companyUser.setGender(rs.getInt("gender"));
            companyUser.setCp_birthday(rs.getTimestamp("cp_birthday"));
            companyUser.setCp_phone_number(rs.getString("cp_phone_number"));
            companyUser.setCompany_phone_number(rs.getString("company_phone_number"));
            companyUser.setCp_qq(rs.getString("cp_qq"));
            companyUser.setCp_weixin(rs.getString("cp_weixin"));

        }else {
            return null;
        }

        return companyUser;
    }

    @Override
    public CompanyUser findFromPhone(String phone) throws SQLException {

        ResultSet rs = null;
        strSql ="select * from company_user where cp_phone_number = '"+phone+"';";
        rs = JdbcUtils.exeSqlQuery(strSql);

        CompanyUser companyUser = new CompanyUser();

        if (rs.next()) {
            companyUser.setCompany_id(rs.getString("company_id"));
            companyUser.setUser_user_id(rs.getString("user_user_id"));
            companyUser.setCompany_name(rs.getString("company_name"));
            companyUser.setMajor_businesses(rs.getString("major_businesses"));
            companyUser.setReceiver_address(rs.getString("receiver_address"));
            companyUser.setCp_name(rs.getString("cp_name"));
            companyUser.setGender(rs.getInt("gender"));
            companyUser.setCp_birthday(rs.getTimestamp("cp_birthday"));
            companyUser.setCp_phone_number(rs.getString("cp_phone_number"));
            companyUser.setCompany_phone_number(rs.getString("company_phone_number"));
            companyUser.setCp_qq(rs.getString("cp_qq"));
            companyUser.setCp_weixin(rs.getString("cp_weixin"));
        }else {
            return null;
        }
        return companyUser;
    }

    @Override
    public List<CompanyUser> findAll() throws SQLException {

        ResultSet rs;

        List<CompanyUser> allCompanyUsers = new ArrayList<CompanyUser>();

        strSql = "select * from company_user";

        rs = JdbcUtils.exeSqlQuery(strSql);

        if (rs.next()){

            CompanyUser companyUser = new CompanyUser();

            companyUser.setCompany_id(rs.getString("company_id"));
            companyUser.setUser_user_id(rs.getString("user_user_id"));
            companyUser.setCompany_name(rs.getString("company_name"));
            companyUser.setMajor_businesses(rs.getString("major_businesses"));
            companyUser.setReceiver_address(rs.getString("receiver_address"));
            companyUser.setCp_name(rs.getString("cp_name"));
            companyUser.setGender(rs.getInt("gender"));
            companyUser.setCp_birthday(rs.getTimestamp("cp_birthday"));
            companyUser.setCp_phone_number(rs.getString("cp_phone_number"));
            companyUser.setCompany_phone_number(rs.getString("company_phone_number"));
            companyUser.setCp_qq(rs.getString("cp_qq"));
            companyUser.setCp_weixin(rs.getString("cp_weixin"));

            allCompanyUsers.add(companyUser);

        }else {
            return null;
        }

        return allCompanyUsers;
    }
}
