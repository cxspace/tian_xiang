<%@ page import="java.util.List" %>
<%@ page import="service.system.frontBean.Good" %>
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
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <table class="table">
              <thead>
                <tr>
                  <th>序号</th>
                  <th>品名</th>
                  <th>品类</th>
                  <th>价格(￥)</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>

              <%
                List<Good> goodList = (List<Good>) session.getAttribute("goodList");
                DecimalFormat df = new DecimalFormat("#.00");
                int k=1;
                for(Good good : goodList){
              %>

                <tr>
                  <td><%=k%></td>
                  <td><%=good.getGoodName()%></td>
                  <td><%=good.getGoodClassName()%></td>
                  <td><%=df.format(good.getGoodPrice())%></td>
                  <td>
                    <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/GoodDelete2?goodId=<%=good.getGoodId()%>">
                      <div class="col-md-12 text-center">
                        <div class="col-md-2 text-center">

                        </div>
                        <div class="col-md-2 text-left">
                          <button type="submit" class="btn btn-info btn-ls">删除</button>
                        </div>
                      </div>
                    </form>
                  </td>
                  <td></td>
                  <td></td>
                </tr>

                <%
                    ++k;
                  }
                %>

                <tr>
                  <td>2</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td>3</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td>4</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td>5</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td>6</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td>7</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td>8</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td>9</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td>10</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td>11</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td>12</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  

</body></html>