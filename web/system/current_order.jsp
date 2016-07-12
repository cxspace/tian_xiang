<%@ page import="service.system.frontBean.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
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
                        <li>
                            <a href="${pageContext.request.contextPath}/CustomerControl?day=-1">客户管理</a>
                        </li>
                        <li class="active">
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
                    <li>
                        <a href="${pageContext.request.contextPath}/CustomerControl?day=-1"><i class="icon-folder-open"></i> 所有用户</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/CustomerControl?day=0"><i class="icon-folder-open"></i>当前下单用户</a>
                    </li>

                    <li class="nav-header">
                        订单管理
                    </li>
                    <li class="active">
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
                当前订单
            </h1>


            <!--
            <form class="navbar-search pull-left" action="" role="form">

                <div class="form-group">
                    <div class="col-sm-10">
                        <div class="col-sm-4">
                            <select class="form-control" name=YYYY onchange="YYYYMM(this.value)">
                                <option >年</option>
                            </select>
                        </div>
                        <div class="col-sm-4">
                            <select class="form-control"name=MM onchange="MMDD(this.value)">
                                <option value="">月</option>
                            </select>
                        </div>
                        <div class="col-sm-4">
                            <select class="form-control" name=DD>
                                <option value="">日</option>
                            </select>

                            <input class="btn-small" type="submit" value="日期查询">
                        </div>
                    </div>

                </div>



            </form>

            -->


            <form id="edit-profile" class="form-horizontal" name="form1" method="post" action="${pageContext.request.contextPath}/OrderFindFromYMD">
                    <div class="control-group">
                        <label class="control-label" for="input01">年</label>
                        <div class="controls">
                            <select class="form-control" name=YYYY onchange="YYYYMM(this.value)">
                                <option >年</option>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="input01">月</label>
                        <div class="controls">
                            <select class="form-control"name=MM onchange="MMDD(this.value)">
                                <option value="">月</option>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="input01">日</label>
                        <div class="controls">
                            <select class="form-control" name=DD>
                                <option value="">1</option>
                            </select>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="fileInput"></label>
                        <div class="controls">
                            <input class="btn" id="fileInput" type="submit" value="日期查询" />
                        </div>
                    </div>
            </form>

            <form id="edit-profile" class="form-horizontal" name="form" method="post" action="${pageContext.request.contextPath}/OrderFindFromName">

                <div class="control-group">
                    <label class="control-label" for="input01"></label>
                    <div class="controls">
                        <input type="text" name="name" class="input-xlarge" id="input01" placeholder="请输入客户名" />
                    </div>
                </div>


            <div class="control-group">
                        <label class="control-label" for="fileInput"></label>
                        <div class="controls">
                            <input class="btn" id="fileInput" type="submit" value="客户名查询"/>
                        </div>
            </div>


            </form>

            <!--
            <form>

                <input type="text" class="form-inline" placeholder="输入客户名" />
                  <br>
                 <br>
                <input class="btn-small" type="submit" value="客户名查询">
                <br>
            </form>
            -->

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
                        下单日期
                    </th>
                    <th>
                        客户名
                    </th>
                    <th>
                        联系人名
                    </th>
                    <th>
                        联系电话
                    </th>
                    <th>
                        品名%单价×数量
                    </th>

                    <th>
                        总价
                    </th>

                    <th>
                        结算情况
                    </th>

                </tr>
                </thead>
                <tbody>
                <%
                    List<Order> currentOrder = (List<Order>) session.getAttribute("currentOrder");
                    DecimalFormat df = new DecimalFormat("#.00");

                    if (currentOrder!=null)
                    {
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
                    <td><%=df.format(order.getTotalPrice())%></td>
                    <td><%=order.getStatus()%></td>
                </tr>
                <%
                        }
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

<script language="JavaScript">
    //定义年、月、日方法函数
    window.onload = function(){
        strYYYY = document.form1.YYYY.outerHTML;
        strMM = document.form1.MM.outerHTML;
        strDD = document.form1.DD.outerHTML;
        MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

        //先给年下拉框赋内容
        var y = new Date().getFullYear();
        var str = strYYYY.substring(0, strYYYY.length - 9);
        for (var i = (y-30); i < (y+30); i++) //以今年为准，前30年，后30年
        {
            str += "<option value='" + i + "'> " + i + "</option>\r\n";
        }
        document.form1.YYYY.outerHTML = str +"</select>";

        //赋月份的下拉框
        var str = strMM.substring(0, strMM.length - 9);
        for (var i = 1; i < 13; i++)
        {
            str += "<option value='" + i + "'> " + i + "</option>\r\n";
        }
        document.form1.MM.outerHTML = str +"</select>";

        document.form1.YYYY.value = y;
        document.form1.MM.value = new Date().getMonth() + 1;
        var n = MonHead[new Date().getMonth()];
        if (new Date().getMonth() ==1 && IsPinYear(YYYYvalue)) n++;
        writeDay(n); //赋日期下拉框
        document.form1.DD.value = new Date().getDate();
    }
    function YYYYMM(str) //年发生变化时日期发生变化(主要是判断闰平年)
    {
        var MMvalue = document.form1.MM.options[document.form1.MM.selectedIndex].value;
        if (MMvalue == ""){DD.outerHTML = strDD; return;}
        var n = MonHead[MMvalue - 1];
        if (MMvalue ==2 && IsPinYear(str)) n++;
        writeDay(n)
    }
    //月发生变化时日期联动
    function MMDD(str) {
        var YYYYvalue = document.form1.YYYY.options[document.form1.YYYY.selectedIndex].value;
        if (str == ""){DD.outerHTML = strDD; return;}
        var n = MonHead[str - 1];
        if (str ==2 && IsPinYear(YYYYvalue)) n++;
        writeDay(n)
    }
    //据条件写日期的下拉框
    function writeDay(n) {
        var s = strDD.substring(0, strDD.length - 9);
        for (var i=1; i<(n+1); i++)
            s += "<option value='" + i + "'> " + i + "</option>\r\n";
        document.form1.DD.outerHTML = s +"</select>";
    }
    //判断是否闰平年
    function IsPinYear(year){
        return(0 == year%4 && (year%100 !=0 || year%400 == 0))

    }
</script>

</html>