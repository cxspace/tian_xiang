<%@ page import="service.system.frontBean.Customer" %>
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
    <div class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-ex-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"><span>当前下单客户</span></a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-ex-collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="active">
              <form class="navbar-form navbar-left" role="search" method="post" action="${pageContext.request.contextPath}/CustomerFindFromName">
                <div class="form-group">
                  <input type="text" class="form-control" name="name">
                </div>
                <button type="submit" class="btn btn-default">客户名搜索</button>
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
                  <th>客户序号</th>
                  <th>客户名称</th>
                  <th>联系人</th>
                  <th>联系方式</th>
                  <th>收货地址</th>
                  <th>未结算数量</th>
                </tr>
              </thead>
              <tbody>

              <%List<Customer> underHandCustomer = (List<Customer>) session.getAttribute("currentCustomer");
                int rank=1;
              for(int i=underHandCustomer.size()-1;i>=0;--i){
                Customer customer = underHandCustomer.get(i);
              %>
                <tr>
                  <td><%=rank%></td>
                  <td><%=customer.getCustomerName()%></td>
                  <td><%=customer.getCpName()%></td>
                  <td><%=customer.getPhone()%></td>
                  <td><%=customer.getAddress()%></td>
                  <td><%=customer.getStatus()%></td>
                  <td></td>
                </tr>
              <%
                  ++rank;
                }
              %>


              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  

</body></html>