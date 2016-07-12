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
                        <li class="active">
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
                    <li class="active">
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
                添加商品
            </h1>
            <form id="edit-profile" class="form-horizontal"  method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/AddGoodControl">
                <fieldset>

                    <div class="control-group">
                        <label class="control-label" for="input01">商品名</label>
                        <div class="controls">
                            <input type="text" class="input-xlarge" id="input01" value="" placeholder="请输入商品名" name="goodName"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="input01">商品类别</label>
                        <div class="controls">
                            <input type="text" class="input-xlarge" id="input01" value="" placeholder="请输入商品类别" name="goodClassName" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="input01" name="goodNumber">商品数量</label>
                        <div class="controls">
                                <select class="form-control" name="goodNumber">

                                    <%
                                        for(int i = 1 ; i < 1000 ; i ++)
                                        {
                                    %>
                                    <option value="<%=i%>">
                                        <%=i%>
                                    </option>
                                    <%
                                        }
                                    %>

                                </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="input01">商品单价</label>
                        <div class="controls">
                            <input type="text" class="input-xlarge" id="input01" value="" placeholder="请输入商品单价" name="goodPrice"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="input01">商品vip单价</label>
                        <div class="controls">
                            <input type="text" class="input-xlarge" id="input01" value="" placeholder="请输入商品VIP单价"  name="goodVipPrice"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="fileInput">图片<font color="#dc143c">（图片的大小小于1M，否则前台卡顿）</font></label>
                        <div class="controls">
                            <input class="input-file" id="fileInput" name="picture" type="file" />
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="textarea">描述</label>
                        <div class="controls">
                            <textarea class="input-xlarge" id="textarea" rows="4" name="goodDescribe">

                            </textarea>
                        </div>
                    </div>



                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">提交</button>
                    </div>
                </fieldset>
            </form>
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