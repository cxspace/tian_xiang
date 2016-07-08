<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%
  if (session.getAttribute("userId")!=null){
    request.getRequestDispatcher("/front/login_error.jsp").forward(request,response);
  }
%>
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="keywords" content="Eatery Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
       Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design">
    <script type="application/x-javascript">
       addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
    </script>
    <link href="${pageContext.request.contextPath}/front/css/bootstrap.css" rel="stylesheet" type="text/css">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/front/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="${pageContext.request.contextPath}/front/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Theme files -->
  </head><body>
    <!--banner-->
    <div class="about_banner">
      <!--header-->
      <div class="headder">
        <div class="container">
          <nav class="navbar navbar-default">
            <div class="container-fluid">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/front/index.jsp">  </a>
              </div>
              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                  <li>
                    <a href="${pageContext.request.contextPath}/front/index.jsp">主页</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/front/company_register.jsp">公司用户注册</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/front/personal_register.jsp">个人用户注册</a>
                  </li>
                </ul>
              </div>
              <div class="clearfix"></div>
            </div>
          </nav>
        </div>
      </div>
    </div>
    <!--//banner-->
    <div class="about_top">
      <div class="container">
        <div class="contact-form">
          <div class="col-md-4">
            <h3>用户登录</h3>
            <form method="post" action="${pageContext.request.contextPath}/userLogin">
              <div class="form-group">
                <label for="name">用户名（手机号）：</label>
                <input type="text" class="form-control" name="phone">
              </div>
              <div class="form-group">
                <label for="name">密码</label>
                <input type="password" class="form-control" name="password" id="#" placeholder="请输入您的密码">
              </div>
              <br>
              <br>
              <div class="send">
                <input type="submit" value="登录">
              </div>
            </form>
          </div>
          <div class="col-md-2"></div>
          <div class="col-md-6 contact-in">
            <h3>新货推荐</h3>
            <p class="sed-para">有什么新货，有什么特点</p>
            <p class="para1">新货一
              <br>
              <br>新货二
              <br>
            </p>
            <div class="more-address">
              <div class="address-more">
                <p></p>
                <p></p>
                <p></p>
              </div>
              <div class="address-left">
                <p></p>
                <p></p>
                <p>
                  <a href="malito:mail@demolink.org">88888888@qq.com</a>
                </p>
              </div>
              <div class="clearfix"></div>
            </div>
          </div>
          <div class="clearfix"></div>
        </div>
      </div>
    </div>
    <div class="box_3"></div>
   <div class="footer">
      <div class="container">
        <div class="col-md-6 col_2">
          <ul>
            <li>
              <h5>天香食品</h5>
              <p>老板电话
                <span>12345678910</span>
              </p>
              <p>天香地址
                <span>$$$-$$$-$$$</span>
              </p>
            </li>
            <li>
              <h5>营业时间</h5>
              <p>工作日-礼拜一~礼拜五
                <span>11pm – 05pm</span>
              </p>
              <p>周末
                <span>04pm – 11pm</span>
              </p>
            </li>
          </ul>
        </div>
        <div class="col-md-6 col_3">
          <div class="col_3">
            <ul class="menu">
              <li>
                <a href="#">Home</a>
              </li>|
              <li>
                <a href="#">About</a>
              </li>|
              <li>
                <a href="#">Services</a>
              </li>|
              <li>
                <a href="#">Gallery</a>
              </li>|
              <li>
                <a href="#">Contact</a>
              </li>
            </ul>
            <p>Copyright © 2016.护理专家工作室
              <a href="#" target="_blank" title="">护理专家主页</a>- Collect from
              <a href="#" title="" target="_blank">护理专家工作室主页</a>
            </p>
          </div>
        </div>
        <div class="clearfix"></div>
      </div>
    </div>
    <script src="${pageContext.request.contextPath}/front/js/bootstrap.min.js"></script>
</body>
</html>