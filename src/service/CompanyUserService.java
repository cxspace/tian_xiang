package service;

import dao.impl.CompanyUserDao;
import dao.impl.UserDao;
import entity.CompanyUser;
import entity.User;
import frombean.CompanyRegisterBean;
import utils.TransTimestamp;
import utils.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by cxspace on 16-7-4.
 */
public class CompanyUserService {

    //验证用户输入
    public static boolean Verify(HttpServletRequest request){

        boolean flag0 = false;

        boolean flag1 = false;

        boolean flag2 = false;

        boolean flag3 = false;

        boolean flag4 = false;

        boolean flag5 = false;

        String companyName = request.getParameter("company_name");

        //负责人名字
        String userName = request.getParameter("cp_name");
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
        if (!(userName.equals("")&&companyName.equals(""))){
            flag0 = true;
        }else {
            System.out.println("用户名输入为空");
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

        //电话号码一定是11位
        if (phone.length()==11){
            flag5 = true;
        }


        System.out.println(companyName+"-"+userName+"-"+gender+"-"+majorBusinesses+"-"+phone+"-"+finalPhone+"-"+weiXin+"-"+qq);

        System.out.println(detailAddress+"-"+password+"-"+confirmPassword);

        System.out.println(province+"-"+city+"-"+area);

        System.out.println(birthdayYear+"-"+birthdayMonth+"-"+birthdayDay);


        return flag0&&flag1&&flag2&&flag3&&flag4&&flag5;
    }

    //添加到表单bean
    public static CompanyRegisterBean addToFrombean(HttpServletRequest request){

        String companyName = request.getParameter("company_name");

        //负责人名字
        String userName = request.getParameter("cp_name");
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

        CompanyRegisterBean companyRegisterBean = new CompanyRegisterBean();

        companyRegisterBean.setCompanyName(companyName);
        companyRegisterBean.setCpName(userName);
        companyRegisterBean.setGender(gender);
        companyRegisterBean.setBirthdayYear(birthdayYear);
        companyRegisterBean.setBirthdayMonth(birthdayMonth);
        companyRegisterBean.setBirthdayDay(birthdayDay);
        companyRegisterBean.setMajorBusinesses(majorBusinesses);
        companyRegisterBean.setPhone(phone);
        companyRegisterBean.setFinalPhone(finalPhone);
        companyRegisterBean.setQq(qq);
        companyRegisterBean.setWeixin(weiXin);
        companyRegisterBean.setProvince(province);
        companyRegisterBean.setCity(city);
        companyRegisterBean.setArea(area);
        companyRegisterBean.setDetailAddress(detailAddress);
        companyRegisterBean.setPassword(password);
        companyRegisterBean.setConfirmPassword(confirmPassword);

        return companyRegisterBean;
    }

    //注入数据到数据库
    public static boolean addCompanyUser(CompanyRegisterBean companyRegisterBean){

        boolean flag0 = false;
        boolean flag1 = false;
        String userId = WebUtils.getRandomId(12);

        UserDao userDao = new UserDao();
        User user = new User();
        user.setUser_id(userId);
        user.setUser_phone(companyRegisterBean.getPhone());
        user.setUser_password(companyRegisterBean.getPassword());
        //公司用户1标志
        user.setFlag(1);
        flag0 = userDao.add(user);

        CompanyUserDao companyUserDao = new CompanyUserDao();

        CompanyUser companyUser = new CompanyUser();
        companyUser.setCompany_id(userId);
        companyUser.setUser_user_id(userId);
        companyUser.setCompany_name(companyRegisterBean.getCompanyName());
        companyUser.setMajor_businesses(companyRegisterBean.getMajorBusinesses());
        companyUser.setReceiver_address(companyRegisterBean.getProvince()+"-"+companyRegisterBean.getCity()+"-"+companyRegisterBean.getArea()+"-"+companyRegisterBean.getDetailAddress());
        companyUser.setCp_name(companyRegisterBean.getCpName());
        companyUser.setGender(companyRegisterBean.getGender());

        Timestamp timestamp = TransTimestamp.YMDToTimestamp(Integer.parseInt(companyRegisterBean.getBirthdayYear()),Integer.parseInt(companyRegisterBean.getBirthdayMonth()),Integer.parseInt(companyRegisterBean.getBirthdayDay()));
        companyUser.setCp_birthday(timestamp);
        companyUser.setCp_phone_number(companyRegisterBean.getPhone());
        companyUser.setCompany_phone_number(companyRegisterBean.getFinalPhone());

        companyUser.setCp_qq(companyRegisterBean.getQq());
        companyUser.setCp_weixin(companyRegisterBean.getWeixin());

        flag1 = companyUserDao.add(companyUser);

        return flag0&&flag1;
    }

    public static CompanyUser findById(String user_id) throws SQLException {
        CompanyUserDao companyUserDao = new CompanyUserDao();

        CompanyUser companyUser = companyUserDao.findFromId(user_id);

        return companyUser;
    }
}
