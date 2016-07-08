<%--
  Created by IntelliJ IDEA.
  User: cxspace
  Date: 16-7-6
  Time: 上午11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<form name="frm_test" action="${pageContext.request.contextPath }/fileServlet?method=upload" method="post" enctype="multipart/form-data">
    <%--<input type="hidden" name="method" value="upload">--%>

    用户名：<input type="text" name="userName">  <br/>
    文件：   <input type="file" name="file_img">   <br/>

    <input type="submit" value="提交">
</form>
</body>

</html>
