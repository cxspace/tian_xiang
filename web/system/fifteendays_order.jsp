<%@ page import="service.system.frontBean.Order" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/system/css/Untitled.css" rel="stylesheet" type="text/css">
  </head><body>
    <div class="navbar navbar-default navbar-static-top as">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand"><span>15天订单</span></a>
        </div>
        <br>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
          <ul class="nav navbar-nav navbar-right">
            <form class="navbar-form navbar-left text-center" role="search" method="post" action="${pageContext.request.contextPath}/OrderFindFromYMD">
              <div class="form-group">
                <input type="text" class="form-control" name="year">年</div>
              <div class="form-group">
                <input type="text" class="form-control" name="month">月</div>
              <div class="form-group">
                <input type="text" class="form-control" name="day">日</div>
              <button type="submit" class="btn btn-default">日期查询</button>
            </form>
            <li class="active">
              <form class="navbar-form navbar-left" role="search" method="post" action="${pageContext.request.contextPath}/OrderFindFromName">
                <div class="form-group">
                  <input type="text" class="form-control" name="name">
                </div>
                <button type="submit" class="btn btn-default">客户名查询</button>
              </form>
            </li>
            <li class="active">
              <form class="navbar-form navbar-left" role="search" method="post" action="${pageContext.request.contextPath}/OrderFindUnStatus">
                <button type="submit" class="btn btn-default">未付款订单</button>
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
                  <th>订单编号</th>
                  <th>下单日期</th>
                  <th>客户名称</th>
                  <th>联系人</th>
                  <th>联系方式</th>
                  <th>订购产品清单</th>
                  <th>总结</th>
                  <th>结算情况</th>
                </tr>
              </thead>
              <tbody>
              <%
                List<Order> currentOrder = (List<Order>) session.getAttribute("nearly15Order");
                for(int i=0;i<currentOrder.size();++i){
                  Order order = currentOrder.get(i);
              %>

              <tr>
                <td><%=i+1%></td>
                <td><%=order.getOrderDate()%></td>
                <td><%=order.getCustomerName()%></td>
                <td><%=order.getCpName()%></td>
                <td><%=order.getPhone()%></td>
                <td><%=order.getOrdered()%></td>
                <td><%=order.getTotalPrice()%></td>
                <td><%=order.getStatus()%></td>
              </tr>
              <%
                }
              %>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  

</body></html>