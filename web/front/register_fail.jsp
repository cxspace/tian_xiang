<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/front/js/bootstrap.min.js"></script>
  <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
  </head><body>

    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">
            <div class="col-md-6 text-center">
              <img src="${pageContext.request.contextPath}/front/images/cha.png">
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
                <h1>注册失败,输入信息有误,<span id="settime">2</span>秒回到注册页面...</h1>

                <%response.setHeader("refresh","2;url="+request.getContextPath()+"/front/company_register.jsp");%>

              </div>
              <div class="col-md-12 text-center">&nbsp;</div>
              <div class="col-md-5 text-center">&nbsp;</div>
            </div>
          </div>
        </div>
      </div>
    </div>
</body>
<script language="javascript">
  var i=2;

  /*1S钟执行一次settime*/
  window.setInterval("settime()",1000);
  function settime()
  { var divinner=document.getElementById("settime"); divinner.innerText=i; i--; }

</script>
</html>