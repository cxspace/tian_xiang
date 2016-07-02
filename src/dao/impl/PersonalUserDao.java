package dao.impl;

import dao.IPersonalUserDao;
import entity.PersonalUser;
import utils.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by cxspace on 16-7-2.
 */
public class PersonalUserDao implements IPersonalUserDao{

    private  String strSql;

    @Override
    public boolean add(PersonalUser personalUser) {


        strSql = "insert into personal_user ";
        strSql += "( person_id ,";
        strSql += "  user_user_id,";
        strSql += "major_businesses,";
        strSql += "receiver_address,";
        strSql += "person_name,";
        strSql += "gender,";
        strSql += "birthday,";
        strSql += "phone_number,";
        strSql += "qq,";
        strSql += "weixin ) values (";

        strSql += "'"+personalUser.getPerson_id()+"',";
        strSql += "'"+personalUser.getUser_user_id()+"',";
        strSql += "'"+personalUser.getMajor_businesses()+"',";
        strSql += "'"+personalUser.getReceiver_address()+"',";
        strSql += "'"+personalUser.getPerson_name()+"',";
        strSql += "'"+personalUser.getGender()+"',";
        strSql += "'"+personalUser.getBirthday()+"',";
        strSql += "'"+personalUser.getPhone_number()+"',";
        strSql += "'"+personalUser.getQq()+"',";
        strSql += "'"+personalUser.getWeixin()+"');";

        return JdbcUtils.exeSql(strSql);

    }

    @Override

    public PersonalUser findFromId(String id) throws SQLException {

        PersonalUser personalUser = new PersonalUser();


        strSql = "select * from personal_user where person_id = '"+id+"';";

        ResultSet rs = JdbcUtils.exeSqlQuery(strSql);


        if (rs.next()) {

            personalUser.setPerson_id(rs.getString("person_id"));

            personalUser.setUser_user_id(rs.getString("user_user_id"));

            personalUser.setMajor_businesses(rs.getString("major_businesses"));

            personalUser.setReceiver_address(rs.getString("receiver_address"));

            personalUser.setPerson_name(rs.getString("person_name"));

            personalUser.setGender(rs.getInt("gender"));

            personalUser.setBirthday(rs.getTimestamp("birthday"));

            personalUser.setPhone_number(rs.getString("phone_number"));

            personalUser.setQq(rs.getString("qq"));

            personalUser.setWeixin(rs.getString("weixin"));

        }else {
            return null;
        }


        return personalUser;
    }

    @Override
    public PersonalUser findFromPhone(String phone) throws SQLException{

        ResultSet rs = null;

        strSql = "select * from personal_user where phone_number = '"+phone+"';";

        rs = JdbcUtils.exeSqlQuery(strSql);

        PersonalUser personalUser = new PersonalUser();

        if (rs.next()) {

            personalUser.setPerson_id(rs.getString("person_id"));

            personalUser.setUser_user_id(rs.getString("user_user_id"));

            personalUser.setMajor_businesses(rs.getString("major_businesses"));

            personalUser.setReceiver_address(rs.getString("receiver_address"));

            personalUser.setPerson_name(rs.getString("person_name"));

            personalUser.setGender(rs.getInt("gender"));

            personalUser.setBirthday(rs.getTimestamp("birthday"));

            personalUser.setPhone_number(rs.getString("phone_number"));

            personalUser.setQq(rs.getString("qq"));

            personalUser.setWeixin(rs.getString("weixin"));

        }
        return personalUser;
    }
}
