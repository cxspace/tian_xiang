<%@ page import="service.system.frontBean.Repertory" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/front/js/bootstrap.min.js"></script>
  <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/system/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/system/css/Untitled.css" rel="stylesheet" type="text/css">
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
          <a class="navbar-brand" href="#"><span>库存管理</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="active">
              <form class="navbar-form navbar-left" role="search" method="post" action="${pageContext.request.contextPath}/RepertoryFindFromCommodityName">
                <div class="form-group">
                  <input type="text" class="form-control" name="commodityName">
                </div>
                <button type="submit" class="btn btn-default">品名搜索</button>
              </form>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <table class="table">
              <thead>
                <tr>
                  <th>序号</th>
                  <th>品类</th>
                  <th>品名</th>
                  <th>规格</th>
                  <th>件数</th>
                  <th>库存变化日期</th>
                  <th>变化情况</th>
                  <th>入库人员</th>
                </tr>
              </thead>
              <tbody>
              <%
                List<Repertory> repertoryList = (List<Repertory>) session.getAttribute("repertoryList");
                int k=1;
                for(int i=repertoryList.size()-1;i>=0;--i){
                  Repertory repertory = repertoryList.get(i);
              %>

                <tr>
                  <td><%=k%></td>
                  <td><%=repertory.getCommodityClassName()%></td>
                  <td><%=repertory.getCommodityName()%></td>
                  <td><%=repertory.getScale()%></td>
                  <td><%=repertory.getNumber()%></td>
                  <td><%=repertory.getDate()%></td>
                  <td><%=repertory.getStatus()%></td>
                  <td><%=repertory.getChargePersonName()%></td>
                </tr>

              <%
                  ++k;
                }
              %>

              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  

</body></html>