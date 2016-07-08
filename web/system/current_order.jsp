<%@ page import="service.system.frontBean.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/front/js/bootstrap.min.js"></script>
  <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/system/css/bootstrap.min.css" rel="stylesheet" type="text/css">
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
          <a class="navbar-brand"><span>未发货订单</span></a>
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


              <!--

              <div class="form-group">
              <div class="col-sm-4">
                <select class="form-control" name="year" onchange="YYYYMM(this.value)">
                  <option>年</option>
                </select>
              </div>
              <div class="col-sm-4">
                <select class="form-control"name="month" onchange="MMDD(this.value)">
                  <option value="">月</option>
                </select>
              </div>
              <div class="col-sm-4">
                <select class="form-control" name="day">
                  <option value="">日</option>
                </select>
              </div>

              </div>

              -->
              <button type="submit" class="btn btn-default">日期查询</button>
            </form>
            <li class="active">
              <form class="navbar-form navbar-left" role="search" method="post" action="${pageContext.request.contextPath}/OrderFindFromName">
                <div class="form-group">
                  <input type="text" class="form-control"  name="name"/>
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
                  <th>编号</th>
                  <th>下单日期</th>
                  <th>客户名称</th>
                  <th>联系人</th>
                  <th>联系方式</th>
                  <th>品名%单价×数量</th>
                  <th>总价</th>
                  <th>结算情况</th>
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
          </div>
        </div>
      </div>
    </div>
  

</body>

<script language="JavaScript">

  //年月日联动实现算法
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