<%@ page import="entity.Commodity" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Indent" %>
<%@ page import="service.IndentService" %>
<%@ page import="service.CommodityService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  if (session.getAttribute("userId")==null)
  {
    request.getRequestDispatcher("/front/filter.jsp").forward(request,response);
  }
%>

<html><head>
    <title>订购</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="keywords" content="Eatery Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 

Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design">
    <script type="application/x-javascript">
      addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
    </script>
    <link href="${pageContext.request.contextPath}/front/css/bootstrap.css" rel="stylesheet" type="text/css">
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/front/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="${pageContext.request.contextPath}/front/css/style.css" rel="stylesheet" type="text/css">
    <!-- Custom Theme files -->
  </head>
<body>
    <!--banner-->
    <div class="about_banner">
      <!--header-->
      <div class="headder">
        <div class="container">
          <nav class="navbar navbar-default">
            <div class="container-fluid">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/front/index.jsp"> </a>
              </div>
              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                  <li>
                    <a href="${pageContext.request.contextPath}/front/index.jsp">主页</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/front/order_list.jsp" class="active">购物车</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/front/product.jsp">产品介绍</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/front/company_introduction.jsp">公司介绍</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/front/login.jsp">登录</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/front/consult.jsp">咨询</a>
                  </li>

                </ul>
              </div>
              <div class="clearfix"></div>
            </div>
          </nav>
        </div>
      </div>
    </div>
    <!--导航栏-->
    <br>
    <br>
    <br>
    <!---->
    <div class="section">
      <div class="container">

        <%

             List<Indent> allIndents = new ArrayList<Indent>();

             allIndents = IndentService.findByUserId((String) session.getAttribute("userId"));

             //算出总帐
             Double totalPrice = 0.0;

             //拿到所有未结帐订单
             List<String> allIndentId = new ArrayList<String>();

             for (int i = 0 ; i < allIndents.size() ; i++)
             {
               //算出未提交总价
               if (allIndents.get(i).getClearing_status()==2) {
                 totalPrice += allIndents.get(i).getTotal_price();
               }
               allIndentId.add(allIndents.get(i).getIndent_id());
             }


             session.setAttribute("allIndentId",allIndentId);

        %>


        <table class="table table-bordered table-striped">


          <thead>
          <tr>
              <th>图片</th>

              <th>品名</th>
              <th>商品id%批发价*订购数量</th>
              <th>总价</th>
              <th colspan="2">订单状态</th>
          </tr>
          </thead>
          <tbody>

          <%

            if(allIndents!=null){
            for(int i = 0 ; i < allIndents.size() ; i++){
          %>
            <tr>
            <%

              Commodity commodity = CommodityService.findCommodityById(allIndents.get(i).getRemark());

            %>
              <td>
                <%if(commodity!=null)
                 {

                %>

                <img src="${pageContext.request.contextPath}/upload/<%=commodity.getC_picture()%>" style="width: 100px;height: 100px">


              </td>
              <td>
              <%=commodity.getC_name()%>

                <%

                  }
                %>
              </td>
              <td>
              <%=allIndents.get(i).getGoods()%>
              </td>
              <td>
                <%=allIndents.get(i).getTotal_price()%>
              </td>

              <% if (allIndents.get(i).getClearing_status()==2)
              {
              %>
              <td>
                <a class="btn btn-default" href="${pageContext.request.contextPath}/deleteOrder?indentId=<%=allIndents.get(i).getIndent_id()%>">删除订单</a>
              </td>
              <%
                }
              %>

              <td>

                <%
                   if (allIndents.get(i).getClearing_status()==2)
                   {
                %>
                <%="未提交"%>

                <%
                  }else if (allIndents.get(i).getClearing_status()==0){
                %>

                <td>


                <%="已提交"%>

                </td>
                <%
                  }
                  else

                  {
                %>
                  <%="已结清"%>
                <%
                  }
                %>

              </td>
            </tr>
          <%
             }
            }
          %>
          </tbody>
        </table>
        <br>
        <br>
        <div class="section">
          <div class="container">
            <div class="row">
              <div class="col-md-2 text-center">
                <h1>总价:
                  <br>
                  <%=totalPrice%></h1>
              </div>
              <div class="col-md-6 text-center">

              </div>
              <div class="col-md-2 text-center">
                <button type="button" class="btn btn-info btn-lg dropdown-toggle" data-toggle="dropdown">
                  提交订单并结算
                  <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                  <li>
                    <a href="${pageContext.request.contextPath}/settleAccount?select=hdfk">货到付款</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/settleAccount?select=zfb">支付宝</a>
                  </li>
                </ul>
              </div>
              <div class="col-md-2 text-center">
                 <a class="btn btn-default" href="${pageContext.request.contextPath}/front/product.jsp">继续添加商品</a>
              </div>
            </div>
          </div>
        </div>
        <br>
        <br>
      </div>
    </div>
    <br>
    <br>
    <br>
    <!--//banner-->
   <div class="footer">
      <div class="container">
        <div class="col-md-6 col_2">
          <ul>
            <li>
              <h5>天香食品</h5>
              <p>老板电话
                <span>12345678910</span>
              </p>
              <p>天香地址
                <span>$$$-$$$-$$$</span>
              </p>
            </li>
            <li>
              <h5>营业时间</h5>
              <p>工作日-礼拜一~礼拜五
                <span>11pm – 05pm</span>
              </p>
              <p>周末
                <span>04pm – 11pm</span>
              </p>
            </li>
          </ul>
        </div>
        <div class="col-md-6 col_3">
          <div class="col_3">
            <ul class="menu">
              <li>
                <a href="#">Home</a>
              </li>|
              <li>
                <a href="#">About</a>
              </li>|
              <li>
                <a href="#">Services</a>
              </li>|
              <li>
                <a href="#">Gallery</a>
              </li>|
              <li>
                <a href="#">Contact</a>
              </li>
            </ul>
            <p>Copyright © 2016.护理专家工作室
              <a href="#" target="_blank" title="">护理专家主页</a>- Collect from
              <a href="#" title="" target="_blank">护理专家工作室主页</a>
            </p>
          </div>
        </div>
        <div class="clearfix"></div>
      </div>
</div>


    <script src="${pageContext.request.contextPath}/front/js/bootstrap.min.js"></script>



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