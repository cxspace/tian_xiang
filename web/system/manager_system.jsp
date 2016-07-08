<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html><head>
  <%
    if(session.getAttribute("managerId")==null){
      request.getRequestDispatcher("/system/manager_login.jsp").forward(request,response);
    }
  %>

    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 



Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design">
    <script type="application/x-javascript">
      addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
    </script>
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/system/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/system/css/style.css" rel="stylesheet" type="text/css">
    <!-- Graph CSS -->
    <link href="${pageContext.request.contextPath}/system/css/lines.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/system/css/font-awesome.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/system/js/jquery.min.js"></script>
    <!----webfonts--->
    <link href="http://fonts.useso.com/css?family=Roboto:400,100,300,500,700,900" rel="stylesheet" type="text/css">
    <!---//webfonts--->
    <!-- Nav CSS -->
    <link href="${pageContext.request.contextPath}/system/css/custom.css" rel="stylesheet">
    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/system/js/metisMenu.min.js"></script>
    <script src="${pageContext.request.contextPath}/system/js/custom.js"></script>
    <!-- Graph JavaScript -->
    <script src="${pageContext.request.contextPath}/system/js/d3.v3.js"></script>
    <script src="${pageContext.request.contextPath}/system/js/rickshaw.js"></script>
  </head><body>
    <div id="wrapper">
      <!-- Navigation -->
      <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand">天香食品管理系统</a>
        </div>
        <!-- /.navbar-header -->
        <ul class="nav navbar-nav navbar-right"></ul>
        <div class="navbar-default sidebar" role="navigation">
          <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
              <li>
                <a href="#" target="frame"><i class="fa fa-laptop nav_icon"></i>客户管理<span class="fa arrow"></span></a>
                <!-- /.nav-second-level -->
                <ul class="nav nav-second-level">
                  <li>
                    <a href="${pageContext.request.contextPath}/CustomerControl?day=-1" target="frame">所有客户</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/CustomerControl?day=0" target="frame">当前下单客户</a>
                  </li>

                  <!--
                  <li>
                    <a href="/CustomerControl?day=7" target="frame">近7天下单客户</a>
                  </li>
                  <li>
                    <a href="/CustomerControl?day=15" target="frame">近15天下单客户</a>
                  </li>
                  <li>
                    <a href="/CustomerControl?day=30" target="frame">近30天下单客户</a>
                   </li>
                   -->
                </ul>
              </li>
              <li>
                <a href="#" target="frame"><i class="fa fa-indent nav_icon"></i>订单管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                  <li>
                    <a href="${pageContext.request.contextPath}/OrderControl?day=0" target="frame">未发货订单</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/OrderControl?day=7" target="frame">近7天订单</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/OrderControl?day=15" target="frame">近15天订单</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/OrderControl?day=30" target="frame">近1个月订单</a>
                  </li>
                </ul>
                <!-- /.nav-second-level -->
              </li>
              <li>
                <a href="${pageContext.request.contextPath}/RepertoryControl" target="frame"><i class="fa fa-envelope nav_icon"></i>库存管理<span class="fa arrow"></span></a>
                <!-- /.nav-second-level -->
              </li>
              <li>
                <a href="#" target="frame"><i class="fa fa-laptop nav_icon"></i>商品管理<span class="fa arrow"></span></a>
                <!-- /.nav-second-level -->
                <ul class="nav nav-second-level">
                  <li>
                    <a href="${pageContext.request.contextPath}/system/add_goods.jsp" target="frame">添加商品</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/GoodDelete1" target="frame">删除商品</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/GoodChangePrice1" target="frame">改变商品价格</a>
                  </li>
                </ul>
              </li>
              <li>
                <a href="${pageContext.request.contextPath}/system/staft_information.html" target="frame"><i class="fa fa-envelope nav_icon"></i>员工信息管理<span class="fa arrow"></span></a>
                <!-- /.nav-second-level -->
              </li>
            </ul>
          </div>
          <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
      </nav>
      <div id="page-wrapper">
        <iframe name="frame" width="100%" height="100%"></iframe>
      </div>
    </div>
    <script src="${pageContext.request.contextPath}/system/js/bootstrap.min.js"></script>
  

</body></html>