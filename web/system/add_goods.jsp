<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  </head><body>
    <form class="form-horizontal" role="form" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/AddGoodControl">
      <div class="form-group">
        <label for="firstname" class="col-sm-2 control-label">
          <br>
          <h4>商品名</h4>
        </label>
        <br>
        <div class="col-sm-3">
          <input type="text" class="form-control" placeholder="请输入商品名" name="goodName">
        </div>
      </div>
      <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">
          <h4>商品类别</h4>
        </label>
        <div class="col-sm-3">
          <input type="text" class="form-control" placeholder="请输入商品类别" name="goodClassName">
        </div>
      </div>
      <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">
          <h4>商品数量</h4>
        </label>
        <div class="col-sm-3">
          <input type="text" class="form-control" placeholder="请输入商品数量" name="goodNumber">
        </div>
      </div>
      <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">
          <h4>商品单价</h4>
        </label>
        <div class="col-sm-3">
          <input type="text" class="form-control" placeholder="请输入商品单价" name="goodPrice">
        </div>
      </div>
      <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">
          <h4>商品vip单价</h4>
        </label>
        <div class="col-sm-3">
          <input type="text" class="form-control" placeholder="请输入商品vip单价" name="goodVipPrice">
        </div>
      </div>
      <div class="col-sm-1"></div>
      <div class="form-group">
        <label class="sr-only" for="inputfile">食品图片上传</label>
        <input type="file" id="inputfile" name="picture">
      </div>
      <div class="col-sm-1"></div>
      <div class="col-sm-3">
        <div class="form-group">
          <label for="name">商品描述</label>
          <textarea class="form-control" rows="3" name="goodDescribe"></textarea>
          <div class="section">
            <div class="row">
              <div class="col-md-6">
                  <input class="btn btn-primary" type="submit" value="确定"/>
              </div>
              <!--<div class="col-md-6">
                <a href="system/class="btn btn-primary">取消</a>
              </div>-->
            </div>
          </div>
        </div>
      </div>
    </form>
  

</body></html>