<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html lang="en" class="ie6 ielt7 ielt8 ielt9"><![endif]--><!--[if IE 7 ]><html lang="en" class="ie7 ielt8 ielt9"><![endif]--><!--[if IE 8 ]><html lang="en" class="ie8 ielt9"><![endif]--><!--[if IE 9 ]><html lang="en" class="ie9"> <![endif]--><!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en"><!--<![endif]-->
<head>
  <meta charset="utf-8">
  <title>Dashboard - Akira</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="${pageContext.request.contextPath}/system/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/system/css/bootstrap-responsive.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/system/css/site.css" rel="stylesheet">

  <!--ie9的兼容性问题-->
  <!--[if lt IE 9]><script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
<div class="container">
  <div class="navbar">
    <div class="navbar-inner">
      <div class="container">

        <div class="row">
          <div class="span12">
            <h1>登录成功,<span id="settime">2</span>秒回主页...</h1>
            <%response.setHeader("refresh","2;url="+request.getContextPath()+"/front/index.jsp");%>
          </div>

          <ul class="pager">
            <li class="next">
              <a>copyright@hlzjrjz</a>
            </li>
          </ul>
          <ul class="pager">
            <li class="next">

              <a href="#" target="_blank" title="护理专家">护理专家工作室</a>
            </li>
          </ul>
        </div>


      </div>
    </div>

  </div>

</div>

</body>
<script src="${pageContext.request.contextPath}/system/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/system/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/system/js/site.js"></script>
<script language="javascript">
  var i=2;

  /*1S钟执行一次settime*/
  window.setInterval("settime()",1000);
  function settime()
  { var divinner=document.getElementById("settime"); divinner.innerText=i; i--; }

</script>

</html>



