package service;

import dao.impl.PersonalUserDao;
import dao.impl.UserDao;
import entity.PersonalUser;
import entity.User;
import frombean.PersonRegisterBean;
import utils.TransTimestamp;
import utils.WebUtils;

import javax.jnlp.PersistenceService;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by cxspace on 16-7-4.
 */
public class PersonalUserService {

    //验证用户输入
    public static boolean Verify(HttpServletRequest request){

        boolean flag0 = false;

        boolean flag1 = false;

        boolean flag2 = false;

        boolean flag3 = false;

        boolean flag4 = false;

        boolean flag5 = false;

        //用户名
        String userName = request.getParameter("username");
        //性别
        int gender = Integer.parseInt(request.getParameter("gender"));

        //生日
        String birthdayYear = request.getParameter("YYYY");

        String birthdayMonth = request.getParameter("MM");

        String birthdayDay = request.getParameter("DD");

        //主营业务
        String majorBusinesses = request.getParameter("major_businesses");

        String phone = request.getParameter("phone");

        String finalPhone = request.getParameter("final_phone");

        String weiXin = request.getParameter("weixin");

        String qq = request.getParameter("qq");

        //地址
        String province = request.getParameter("province");

        String city = request.getParameter("city");

        String area = request.getParameter("area");

        String detailAddress = request.getParameter("detail_address");

        String password = request.getParameter("password");

        String confirmPassword = request.getParameter("confirm_password");

        //用户名不能为空
        if (!userName.equals("")){
             flag0 = true;
        }else {
            System.out.println("密码输入为空");
        }

        //电话不能为空
        if (!phone.equals(""))
        {
            flag1 = true;
        }else {
            System.out.println("电话输入为空");
        }

        //详细地址不能为空
        if (!detailAddress.equals(""))
        {
            flag2 = true;
        }else {
            System.out.println("详细地址输入为空");
        }

        //两次输入密码不能为空

        if (!(password.equals("")||confirmPassword.equals("")))
        {
            flag3 = true;
        }else {
            System.out.println("两次输入为空");
        }

        //两次输入密码要相等
        if (password.equals(confirmPassword))
        {
            flag4 = true;
        }else {
            System.out.println("两次输入密码不相等");
        }

        if (phone.length()==11){
            flag5 = true;
        }


        System.out.println(userName+"-"+gender+"-"+majorBusinesses+"-"+phone+"-"+finalPhone+"-"+weiXin+"-"+qq);

        System.out.println(detailAddress+"-"+password+"-"+confirmPassword);

        System.out.println(province+"-"+city+"-"+area);

        System.out.println(birthdayYear+"-"+birthdayMonth+"-"+birthdayDay);


        return flag0&&flag1&&flag2&&flag3&&flag4&&flag5;
    }

    //添加到frombean
    public static PersonRegisterBean addToFormbean(HttpServletRequest request){

        //用户名
        String userName = request.getParameter("username");
        //性别
        int gender = Integer.parseInt(request.getParameter("gender"));

        //生日
        String birthdayYear = request.getParameter("YYYY");

        String birthdayMonth = request.getParameter("MM");

        String birthdayDay = request.getParameter("DD");

        //主营业务
        String majorBusinesses = request.getParameter("major_businesses");

        String phone = request.getParameter("phone");

        String finalPhone = request.getParameter("final_phone");

        String weiXin = request.getParameter("weixin");

        String qq = request.getParameter("qq");

        //地址
        String province = request.getParameter("province");

        String city = request.getParameter("city");

        String area = request.getParameter("area");

        String detailAddress = request.getParameter("detail_address");

        String password = request.getParameter("password");

        String confirmPassword = request.getParameter("confirm_password");

        PersonRegisterBean personRegisterBean = new PersonRegisterBean();

        personRegisterBean.setUserName(userName);
        personRegisterBean.setGender(gender);
        personRegisterBean.setBirthdayYear(birthdayYear);
        personRegisterBean.setBirthdayMonth(birthdayMonth);
        personRegisterBean.setBirthdayDay(birthdayDay);
        personRegisterBean.setMajorBusinesses(majorBusinesses);
        personRegisterBean.setPhone(phone);
        personRegisterBean.setFinalPhone(finalPhone);
        personRegisterBean.setWeixin(weiXin);
        personRegisterBean.setQq(qq);
        personRegisterBean.setProvince(province);
        personRegisterBean.setCity(city);
        personRegisterBean.setArea(area);
        personRegisterBean.setDetailAddress(detailAddress);
        personRegisterBean.setPassword(password);
        personRegisterBean.setConfirmPassword(confirmPassword);

        return personRegisterBean;
    }

    //注入数据库
    public static boolean addPersnalUser(PersonRegisterBean personRegisterBean){

        boolean flag0 = false;

        boolean flag1 = false;


        String userId = WebUtils.getRandomId(12);

        //总用户表dao
        UserDao userDao = new UserDao();

        User user = new User();

        //设置总用户表的id
        user.setUser_id(userId);
        user.setUser_phone(personRegisterBean.getPhone());
        user.setUser_password(personRegisterBean.getPassword());
        //个人用户，0标志
        user.setFlag(0);

        //注入是否成功
        flag0 = userDao.add(user);

        //个人用户表dao
        PersonalUserDao personalUserDao = new PersonalUserDao();

        PersonalUser personalUser = new PersonalUser();

        personalUser.setPerson_id(userId);
        personalUser.setUser_user_id(userId);
        personalUser.setMajor_businesses(personRegisterBean.getMajorBusinesses());
        personalUser.setReceiver_address(personRegisterBean.getProvince()+"-"+personRegisterBean.getCity()+"-"+personRegisterBean.getArea()+"-"+personRegisterBean.getDetailAddress());
        personalUser.setPerson_name(personRegisterBean.getUserName());
        personalUser.setGender(personRegisterBean.getGender());

        Timestamp timestamp = TransTimestamp.YMDToTimestamp(Integer.parseInt(personRegisterBean.getBirthdayYear()),Integer.parseInt(personRegisterBean.getBirthdayMonth()),Integer.parseInt(personRegisterBean.getBirthdayDay()));
        personalUser.setBirthday(timestamp);
        personalUser.setPhone_number(personRegisterBean.getPhone());
        personalUser.setQq(personRegisterBean.getQq());
        personalUser.setWeixin(personRegisterBean.getWeixin());

        //注入是否成功
        flag1 = personalUserDao.add(personalUser);

        return flag0&&flag1;
    }

    public static PersonalUser findById(String user_id) throws SQLException {

        PersonalUserDao personalUserDao = new PersonalUserDao();

        PersonalUser personalUser = personalUserDao.findFromId(user_id);

        return personalUser;
    }
}
