<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
  </head><body>
    <div class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><span>返回主页</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="active">
              <a href="${pageContext.request.contextPath}/system/manager_login.jsp">已有账号</a>
            </li>
            <li>
              <a href="${pageContext.request.contextPath}/system/manager_login.jsp">立即登录</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <div class="col-md-6 text-center">
              <img src="${pageContext.request.contextPath}/system/cha.png">
            </div>
            <div class="col-md-6 text-center">
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <br>
              <div class="col-md-12 text-center">
                <h3><%=session.getAttribute("tip")%></h3>
              </div>
              <div class="col-md-12 text-center">&nbsp;</div>
              <div class="col-md-5 text-center">&nbsp;</div>
              <div class="col-md-12 text-center">
                <a href="${pageContext.request.contextPath}/system/manager_login.jsp" class="btn btn-block btn-info btn-lg">重新登录</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  

</body></html>