<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>天香后台管理登录</title>
    <link href="${pageContext.request.contextPath}/system/tianxiang/style_log.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/system/tianxiang/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/system/tianxiang/userpanel.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/system/tianxiang/jquery.ui.all.css">
  </head><body class="login" mycollectionplug="bind">

<form method="post" action="${pageContext.request.contextPath}/ManagerLogin">
    <div class="login_m">
      <div class="login_logo">
        <span width="196" height="46">天香食品后台管理系统登录</span>
      </div>



      <div class="login_boder">
        <div class="login_padding" id="login_model">
          <h2>用户名：</h2>
          <label>
            <!--如果当前内容为空，显示请输入用户名。如果当期显示为请输入用户名，聚焦到输入框后为空-->
            <input type="text" id="username" name="managerName" class="txt_input txt_input2" onfocus="if (value =='请输入用户名'){value =''}" onblur="if (value ==''){value='请输入用户名'}" value="">
          </label>
          <h2>密码：</h2>
          <label>
            <input type="password" name="managerPassword" id="userpwd" class="txt_input" onfocus="if (value =='******'){value =''}" onblur="if (value ==''){value='******'}" value="">
          </label>
          <p class="forgot">
              <h6>

           </h6>
          </p>
          <div class="rem_sub">

            <label>
              <input type="submit" class="sub_button" name="button" id="button" value="登录" style="opacity: 0.7;">
            </label>
          </div>
        </div>
        <div class="copyrights"></div>
        <div id="forget_model" class="login_padding" style="display:none">
          <br>
          <h1>
            <a>忘记密码？</a>
          </h1>
          <br>
          <div class="forget_model_h2">(Please enter your registered email below and the system will automatically
            reset users’ password and send it to user’s registered email address.)</div>
          <label>
            <input type="text" id="usrmail" class="txt_input txt_input2">
          </label>
          <div class="rem_sub">
            <div class="rem_sub_l"></div>
            <label>
              <input type="submit" class="sub_buttons" name="button" id="Retrievenow" value="Retrieve now" style="opacity: 0.7;">　　　
              <input type="submit" class="sub_button" name="button" id="denglou" value="Return" style="opacity: 0.7;">　　</label>
          </div>
        </div>
        <!--login_padding Sign up end-->
      </div>


      <!--login_boder end-->
    </div>
    </form>
    <!--login_m end-->
    <br>
    <br>
    <p align="center">关于我们-
      <a href="#" target="_blank" title="">护理专家</a>-2016-
      <a href="#" title="" target="_blank">护理专家工作室制作</a>
    </p>
  

</body></html>