<%@ page import="service.system.frontBean.Customer" %>
<%@ page import="java.util.List" %>
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
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                    <span class="icon-bar"></span> <span class="icon-bar"></span>

                    <span class="icon-bar"></span>
                </a> <a class="brand" href="#"></a>
                <div class="nav-collapse">
                    <ul class="nav">
                        <li class="active">
                            <a href="${pageContext.request.contextPath}/CustomerControl?day=-1">客户管理</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/OrderControl?day=0">订单管理</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/system/add_goods.jsp">商品管理</a>
                        </li>
                    </ul>

                    <ul class="nav pull-right">
                        <li>
                            <a href="#">技术支持</a>
                        </li>
                        <li>
                            <a href="#">登出</a>
                        </li>
                    </ul>

                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="span3">
            <div class="well" style="padding: 8px 0;">
                <ul class="nav nav-list">
                    <li class="nav-header">
                        用户管理
                    </li>
                    <li >
                        <a href="${pageContext.request.contextPath}/CustomerControl?day=-1"><i class="icon-folder-open"></i> 所有用户</a>
                    </li>
                    <li class="active">
                        <a href="${pageContext.request.contextPath}/CustomerControl?day=0"><i class="icon-folder-open"></i>当前下单用户</a>
                    </li>


                    <li class="nav-header">
                        订单管理
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/OrderControl?day=0"><i class="icon-folder-open"></i>未发货订单</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/OrderControl?day=7"><i class="icon-folder-open"></i>近七天订单</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/OrderControl?day=15"><i class="icon-folder-open"></i>近十五天订单</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/OrderControl?day=30"><i class="icon-folder-open"></i>近一个月订单</a>
                    </li>

                    <li class="nav-header">
                        商品管理
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/system/add_goods.jsp"><i class="icon-folder-open"></i>添加商品</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/GoodDelete1"><i class="icon-folder-open"></i>删除商品</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/GoodChangePrice1"><i class="icon-folder-open"></i>改变商品价格</a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="span9">
            <h1>
                当前下单客户
            </h1>

            <form class="navbar-search pull-left" role="form" method="post" action="${pageContext.request.contextPath}/CustomerFindFromName">

                <div class="control-group">
                    <label class="control-label" for="fileInput"></label>
                    <div class="controls">
                        <input id="fileInput" type="text" name="name" placeholder="输入客户名查询" />
                    </div>
                </div>


                <div class="control-group">
                    <label class="control-label" for="fileInput"></label>
                    <div class="controls">
                        <input class="btn" id="fileInput" type="submit" value="客户名查询" />
                    </div>
                </div>

            </form>

            <br>
            <br>
            <br>
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>
                        序号
                    </th>
                    <th>
                        客户名
                    </th>
                    <th>
                        联系人
                    </th>
                    <th>
                        联系电话
                    </th>
                    <th>
                        收货地址
                    </th>

                    <th>
                        未结算订单数量
                    </th>

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
                </tr>
                <%
                        ++rank;
                    }
                %>

                </tbody>
            </table>


            <!--   分页
             <div class="pagination">
                <ul>
                    <li class="disabled">
                        <a href="#">&laquo;</a>
                    </li>
                    <li class="active">
                        <a href="#">1</a>
                    </li>
                    <li>
                        <a href="#">2</a>
                    </li>
                    <li>
                        <a href="#">3</a>
                    </li>
                    <li>
                        <a href="#">4</a>
                    </li>
                    <li>
                        <a href="#">&raquo;</a>
                    </li>
                </ul>
            </div>
            -->
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

<script src="${pageContext.request.contextPath}/system/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/system/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/system/js/site.js"></script>
</body>
</html>