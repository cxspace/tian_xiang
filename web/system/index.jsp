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
							<li>
								<a href="${pageContext.request.contextPath}/CustomerControl?day=-1"><i class="icon-folder-open"></i> 所有用户</a>
							</li>
							<li>
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
						天香后台管理系统
					</h1>
					<div class="hero-unit">
						<h1>
							欢迎您!
						</h1>
						<p>
							让你的管理更高效！
 						</p>

					</div>
					<div class="well summary">
						<ul>

							<!--多少个用户-->
							<li>
								<a href="${pageContext.request.contextPath}/system/all_customers.jsp"><span class="count"></span> 用户</a>
							</li>

							<!--多少比单子-->
							<li>
								<a href="${pageContext.request.contextPath}/system/current_order.jsp"><span class="count"></span> 订单</a>
							</li>

							<!--发布了多少件商品-->
							<li>
								<a href="${pageContext.request.contextPath}/system/add_goods.jsp"><span class="count"></span> 商品</a>
							</li>

						</ul>
					</div>


					<!--
					<h2>
						Recent Activity
					</h2>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>
									Project
								</th>
								<th>
									Client
								</th>
								<th>
									Type
								</th>
								<th>
									Date
								</th>
								<th>
									View
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									Nike.com Redesign
								</td>
								<td>
									Monsters Inc
								</td>
								<td>
									New Task
								</td>
								<td>
									4 days ago
								</td>
								<td>
									<a href="#" class="view-link">View</a>
								</td>
							</tr>
							<tr>
								<td>
									Nike.com Redesign
								</td>
								<td>
									Monsters Inc
								</td>
								<td>
									New Message
								</td>
								<td>
									5 days ago
								</td>
								<td>
									<a href="#" class="view-link">View</a>
								</td>
							</tr>
							<tr>
								<td>
									Nike.com Redesign
								</td>
								<td>
									Monsters Inc
								</td>
								<td>
									New Project
								</td>
								<td>
									5 days ago
								</td>
								<td>
									<a href="#" class="view-link">View</a>
								</td>
							</tr>
							<tr>
								<td>
									Twitter Server Consulting
								</td>
								<td>
									Bad Robot
								</td>
								<td>
									New Task
								</td>
								<td>
									6 days ago
								</td>
								<td>
									<a href="#" class="view-link">View</a>
								</td>
							</tr>
							<tr>
								<td>
									Childrens Book Illustration
								</td>
								<td>
									Evil Genius
								</td>
								<td>
									New Message
								</td>
								<td>
									9 days ago
								</td>
								<td>
									<a href="#" class="view-link">View</a>
								</td>
							</tr>
							<tr>
								<td>
									Twitter Server Consulting
								</td>
								<td>
									Bad Robot
								</td>
								<td>
									New Task
								</td>
								<td>
									16 days ago
								</td>
								<td>
									<a href="#" class="view-link">View</a>
								</td>
							</tr>
							<tr>
								<td>
									Twitter Server Consulting
								</td>
								<td>
									Bad Robot
								</td>
								<td>
									New Project
								</td>
								<td>
									16 days ago
								</td>
								<td>
									<a href="#" class="view-link">View</a>
								</td>
							</tr>
							<tr>
								<td>
									Twitter Server Proposal
								</td>
								<td>
									Bad Robot
								</td>
								<td>
									Completed Project
								</td>
								<td>
									20 days ago
								</td>
								<td>
									<a href="#" class="view-link">View</a>
								</td>
							</tr>
						</tbody>
					</table>

					-->

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