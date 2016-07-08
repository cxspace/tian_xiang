
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html><head>
    <title>订购</title>
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
</head>
<body>
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
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/front/index.jsp"> </a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="${pageContext.request.contextPath}/front/index.jsp">主页</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/front/order_list.jsp" class="active">购物车</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/front/product.jsp">产品介绍</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/front/company_introduction.jsp">公司介绍</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/front/login.jsp">登录</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/front/consult.jsp">咨询</a>
                            </li>

                        </ul>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </nav>
        </div>
    </div>
</div>
<!--导航栏-->
<br>
<br>
<br>
<!---->
<div class="section">
        <div class="container">
            <div class="col-md-4"></div>
            <div class="row">
                <div class="col-md-6">
                    <img src="${pageContext.request.contextPath}/front/images/pay.jpg" class="img-responsive">
                </div>
            </div>
        </div>
    </div>
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-6"></div>
                <div class="col-md-6">
                    <div class="col-md-6"></div>
                    <div class="col-md-6">
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/front/index.jsp">返回主页</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

<!--//banner-->
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
