<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公司用户注册</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jsAddress.js"></script>
 
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
                    <a href="${pageContext.request.contextPath}/front/company_register.jsp">公司用户注册</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/front/personal_register.jsp">个人用户注册</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/front/login.jsp">登录</a>
                  </li>
                </ul>
              </div>
              <div class="clearfix"></div>
            </div>
          </nav>
        </div>
      </div>
    </div>
    <!--//banner-->
    <div class="about_top">
      <div class="container">
        <div class="contact-form">
          <div class="col-md-6 contact-grid">
            <h3>公司用户注册</h3>

            <!--公司用户信息录入表单-->
            <form name=form1 method="post" action="${pageContext.request.contextPath}/companyUserRegister">
              <p class="your-para">公司名称：</p>
              <input type="text" value="" placeholder="请输入公司名称" name="company_name" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
              <p class="your-para">负责人姓名：</p>
              <input type="text" value="" placeholder="请输入负责人姓名" name="cp_name" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
              <p class="your-para">负责人性性别：</p>
              <br>
              <div>
                <label class="checkbox-inline">
                  <input type="radio" name="gender" id="optionsRadios3" value="1" checked="">男</label>
                <label class="checkbox-inline">
                  <input type="radio" name="gender" id="optionsRadios4" value="0">女</label>
              </div>
              <br>
              <p class="your-para">负责人生日：</p>
            <!--年月日三级联动-->  
            <br>
              <div class="form-group">
                <div class="col-sm-10">
                  <div class="col-sm-4">
                    <select class="form-control" name=YYYY onchange="YYYYMM(this.value)">
                      <option>年</option>
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
                  </div>
                </div>
              </div>
              <br>
          <!---->
              <br>
              <p class="your-para">主营业务：</p>
              <input type="text" value="" placeholder="请输入主营业务" name="major_businesses" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
              <br>
              <p class="your-para">手机号码：</p>
              <input type="text" value="" placeholder="请输入手机号码，11位" name="phone" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
              <br>
              <p class="your-para">固定号码：</p>
              <input type="text" value="" placeholder="请输入固定号码" name="final_phone" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
              <br>
              <p class="your-para">微信帐号</p>
              <input type="text" value="" placeholder="请输入微信帐号" name="weixin" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
              <br>
              <p class="your-para">QQ号：</p>
              <input type="text" value="" placeholder="请输入QQ号" name="qq" onfocus="this.value='';" onblur="if (this.value == '') {this.value ='';}">
              <br>
              <p class="your-para">收货地址：</p>


<!--收货地址全国三级联动-->

            <div class="form-group">
                <div class="col-sm-10">
               
                  <div class="col-sm-4">
                      <p class="your-para">省：</p>

                     <select class="form-control" id="cmbProvince" name="province">
                    
                     </select>
                  </div>
                  <div class="col-sm-4">
                        <p class="your-para">市：</p>

                    <select class="form-control" id="cmbCity" name="city">
                      
                    </select>
                  </div>
                  <div  class="col-sm-4">
                         <p class="your-para">区：</p>

                    <select class="form-control" id="cmbArea" name="area">
                      
                    </select>
                  </div>
                </div>
           </div>
<!---->

              <script type="text/javascript">
	addressInit('cmbProvince', 'cmbCity', 'cmbArea', '江西', '南昌市', '新建县');
	addressInit('Select1', 'Select2', 'Select3');
       </script>
            <br>
           <br>
              <p class="your-para">详细地址:</p>
              <textarea cols="77" rows="6" value="" name="detail_address" placeholder="请输入详细地址" onfocus="this.value='';" onblur="if (this.value == '') {this.value = '';}"></textarea>
              <div class="form-group">
                <label for="name">密码</label>
                <input type="password" class="form-control" name="password" id="#" placeholder="请输入密码，8-16位">
              </div>
              <div class="form-group">
                <label for="name">确认密码</label>
                <input type="password" class="form-control" name="confirm_password" id="#" placeholder="请确认密码，8-16位">
              </div>
              <br>
              <div class="send">
                <input type="submit" value="立即注册">
              </div>
            </form>
          </div>
          <div class="col-md-6 contact-in">
            <h3>新货推荐</h3>
            <p class="sed-para">有什么新货，有什么特点</p>
            <p class="para1">新货一
              <br>
              <br>新货二
              <br>
            </p>
            <div class="more-address">
              <div class="address-more">
                <p></p>
                <p></p>
                <p></p>
              </div>
              <div class="address-left">
                <p></p>
                <p></p>
                <p>
                  <a href="malito:mail@demolink.org">88888888@qq.com</a>
                </p>
              </div>
              <div class="clearfix"></div>
            </div>
          </div>
          <div class="clearfix"></div>
        </div>
      </div>
    </div>
    <div class="box_3"></div>
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
