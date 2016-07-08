<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
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
                <a class="navbar-brand" href="index.html">  </a>
              </div>
              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"></div>
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
          <div class="col-md-4 ">
            <h3>管理员登录</h3>
            <form method="post" action="${pageContext.request.contextPath}/ManagerLogin">
              <!--解决火狐显示问题-->

              <div class="form-group">
                <label for="name">用户名</label>
                <input type="text" class="form-control" id="inputName" name="managerName">
              </div>

              <div class="form-group">
                <label for="password">密码</label>
                <input type="password" class="form-control" id="inputPassword" placeholder="请输入密码" name="managerPassword">
              </div>
              <br>
              <br>

              <div class="send">
                <input type="submit" value="登录">
              </div>
            </form>
          </div>
          <div class="col-md-2"></div>
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
            <p>Copyright © 2016.天香食品
              <a href="#" target="_blank" title="">天香食品主页</a>- Collect from
              <a href="#" title="" target="_blank">天香食品主页</a>
            </p>
          </div>
        </div>
        <div class="clearfix"></div>
      </div>
    </div>
    <script src="${pageContext.request.contextPath}/front/js/bootstrap.min.js"></script>
  

</body></html>