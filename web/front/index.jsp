<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
	
	<!--前端代码尽量做到标签对其，多写注释，方便维护修改-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="keywords" content="Eatery Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 

Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design">
    
	<!-- 一个监听事件，用于触发url栏展示和影藏-->
	<script type="application/x-javascript">
      addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
    </script>
	
	<!--本地库的引用，需检查本地库是否齐全-->
    <link href="${pageContext.request.contextPath}/front/css/bootstrap.css" rel="stylesheet" type="text/css">

    <script src="${pageContext.request.contextPath}/front/js/jquery.min.js"></script>
    
    <link href="${pageContext.request.contextPath}/front/css/style.css" rel="stylesheet" type="text/css">
    
	<script src="${pageContext.request.contextPath}/front/bootstrap/js/bootstrap.min.js"></script>
	
</head>
  
  <body>
    <!--banner-->
    <div class="banner">
      <!--header-->
      <div class="headder">
        <div class="container">
          <nav class="navbar navbar-default">
            <div class="container-fluid">
			
			
              <!-- Brand and toggle get grouped for better mobile display -->
            
            <!--这几行代码是为了兼容手机显示，显示会自适应-->
			<div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp"> </a>
              </div>
              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                  <li>
                    <a href="${pageContext.request.contextPath}/front/index.jsp" class="active">主页</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/front/login.jsp">登录</a>
                  </li>
                  <li>
                    <a href="${pageContext.request.contextPath}/front/company_register.jsp">公司用户注册</a>
                  </li>
				  <li>
                    <a href="${pageContext.request.contextPath}/front/personal_register.jsp">个人用户注册</a>
                  </li>
                </ul>
              </div>
              <div class="clearfix"></div>
            </div>
          </nav>
        </div>
      </div>

      <p><font color="#dc143c">
        <%
           if ((String)session.getAttribute("userId")==null)
           {
        %>
           &nbsp;&nbsp; 未登录！
           <a href="${pageContext.request.contextPath}/front/login.jsp"> <font color="#f5f5dc">请您先登录</font> </a>
        <%
         }
           else
          {

        %>
          <h5>&nbsp;&nbsp;<%=(String)session.getAttribute("userId")%>您好！&nbsp;&nbsp; <a href="${pageContext.request.contextPath}/loginOut"><font color="#f0f8ff">点击退出登录</font></a>
          </h5>
          <%
          }
        %>
      </font></p>
      <div class="banner-title">
        <div id="top" class="callbacks_container">
          <div class="container">


			<!--网格布局，加入5大模块-->
        
                <div class="row">


                         <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                  <br/>
                  <br/>
    

		        <div class="col-md-3" >
			          <p>我的购物车</p>
					  <a class="hvr-bounce-to-top btn_1" href="${pageContext.request.contextPath}/front/order_list.jsp">进入</a>
	            </div>
	            <div class="col-md-2">
			    	  <p>产品介绍</p>
				      <a class="hvr-bounce-to-top btn_1" href="${pageContext.request.contextPath}/front/product.jsp">进入</a>
	            </div>
	            <div class="col-md-2">
				  <p>公司介绍</p>
				      <a class="hvr-bounce-to-top btn_1" href="${pageContext.request.contextPath}/front/company_introduction.jsp">进入</a>
	            </div>
	           <div class="col-md-2">
		    		  <p>用户登录</p>
				      <a class="hvr-bounce-to-top btn_1" href="${pageContext.request.contextPath}/front/login.jsp">进入</a>
    		    </div>
		     <div class="col-md-3">
       				<p>咨询</p>
				      <a class="hvr-bounce-to-top btn_1" href="${pageContext.request.contextPath}/front/consult.jsp">进入</a>
	       	   </div>
			   
				 
               </div>

             </div>
          </div>
        </div>
      </div>
 
    <!--//banner-->
    <div class="copyrights">护理专家工作室

    </div>
    <div class="grid_1">
	
	<!--调节md后的数值可以调整横向比例，具体可参考bootstarp网格布局-->
	  <div class="col-md-2"></div>
	  
	  <!--图片替换为天香出售产品-->
      <div class="col-md-4 image-container1">
        <img src="${pageContext.request.contextPath}/front/images/pic1.jpg" class="img-responsive" alt="">
      </div>
      <div class="col-md-6 content-wrap1">
        <h2>我们的主厨推荐</h2>
        <p>茄汁鱼是一道色香味俱全的汉族名肴，属于川菜系。以鲅鱼为制作主料，工艺为煮，制作难度中等。鲅鱼有补齐的功效，贫血、营养不良等人群应多食用。</p>
        <p>1.中医认为，鲅鱼有补气、平咳作用，对体弱咳喘有一定疗效； 2.鲅鱼还具有提神和防衰老等食疗功能，常食对治疗贫血、早衰、营养不良、产后虚弱和神经衰弱等症会有一定辅助疗效。</p>
        <a class="hvr-bounce-to-top" href="#">Check our Offer</a>
      </div>
      <!-- /.col-md-6 -->
      <div class="clearfix"></div>
    </div>
    <div class="grid_2">
      <div class="col-md-6 content-wrap">
        <h2>我们的主厨推荐</h2>
        <p>麻辣鸭锁骨为麻辣诱惑旗下产品之一，原材料来源经过多道把关、精挑细选，再融入楚湘传统美食烹饪技法，结合祖国传统药膳食谱，博采众长，积数年心血研制而成。</p>
        <p>“春江水暖鸭先知”，鸭是餐桌上的上乘肴馔，也是人们进补的优良食品。据《本草纲目》记载：鸭肉“主大补虚劳，最消毒热，利小便，除水肿，消胀满，利脏腑，退疮肿，定惊痫。”</p>
        <a class="hvr-bounce-to-top" href="#">Check our Offer</a>
      </div>
      <!-- /.col-md-6 -->
      <div class="col-md-6 image-container">
        <img src="${pageContext.request.contextPath}/front/images/pic2.jpg" class="img-responsive" alt="">
      </div>
      <div class="clearfix"></div>
    </div>
	
	
	<!--下面是多个图片组合滑动效果-->
    <div id="owl-demo3" class="owl-carousel owl-carousel2">
      <div class="item">
        <img class="lazyOwl" data-src="${pageContext.request.contextPath}/front/images/pic4.jpg" alt="Lazy Owl Image">
        <a href="${pageContext.request.contextPath}/front/images/pic4.jpg" class="swipebox" title="Image Title"><div class="portfolio_head">

           <h3><img src="${pageContext.request.contextPath}/front/mages/link.png" alt=""></h3>

          </div></a>
      </div>
      <div class="item">
        <img class="lazyOwl" data-src="${pageContext.request.contextPath}/front/images/pic3.jpg" alt="Lazy Owl Image">
        <a href="${pageContext.request.contextPath}/front/images/pic3.jpg" class="swipebox" title="Image Title"><div class="portfolio_head">

           <h3><img src="${pageContext.request.contextPath}/front/images/link.png" alt=""></h3>

          </div></a>
      </div>
      <div class="item">
        <img class="lazyOwl" data-src="${pageContext.request.contextPath}/front/images/pic2.jpg" alt="Lazy Owl Image">
        <a href="${pageContext.request.contextPath}/front/images/pic2.jpg" class="swipebox" title="Image Title"><div class="portfolio_head">

           <h3><img src="${pageContext.request.contextPath}/front/images/link.png" alt=""></h3>

          </div></a>
      </div>
      <div class="item">
        <img class="lazyOwl" data-src="${pageContext.request.contextPath}/front/images/pic5.jpg" alt="Lazy Owl Image">
        <a href="${pageContext.request.contextPath}/front/images/pic5.jpg" class="swipebox" title="Image Title"><div class="portfolio_head">

           <h3><img src="${pageContext.request.contextPath}/front/images/link.png" alt=""></h3>

          </div></a>
      </div>
      <div class="item">
        <img class="lazyOwl" data-src="${pageContext.request.contextPath}/front/images/pic6.jpg" alt="Lazy Owl Image">
        <a href="${pageContext.request.contextPath}/front/images/pic6.jpg" class="swipebox" title="Image Title"><div class="portfolio_head">

           <h3><img src="${pageContext.request.contextPath}/front/images/link.png" alt=""></h3>

          </div></a>
      </div>
      <div class="item">
        <img class="lazyOwl" data-src="${pageContext.request.contextPath}/front/images/pic7.jpg" alt="Lazy Owl Image">
        <a href="${pageContext.request.contextPath}/front/images/pic7.jpg" class="swipebox" title="Image Title"><div class="portfolio_head">

           <h3><img src="${pageContext.request.contextPath}/front/images/link.png" alt=""></h3>

          </div></a>
      </div>
      <div class="clearfix"></div>
    </div>
    <!------ Light Box ------>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/front/css/swipebox.css">
    <script src="${pageContext.request.contextPath}/front/js/jquery.swipebox.min.js"></script>
	
	<!--这里是jquery的特效控制语句，可参考jquery函数库，算法顺序执行，不难-->
    <script type="text/javascript">
      jQuery(function($) {
                            			$(".swipebox").swipebox();
                            		});
    </script>
    <!------ Eng Light Box ------>
    <!-- Prettify -->
    <link href="${pageContext.request.contextPath}/front/css/owl.carousel.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/front/js/owl.carousel.js"></script>
    <script>
      $(document).ready(function() {
                            		$("#owl-demo3").owlCarousel({
                            			items : 6,
                            			lazyLoad : true,
                            			autoPlay : true,
                            			navigation: false,
                            			pagination: false,
                                    });
      });
    </script>
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
</html>
