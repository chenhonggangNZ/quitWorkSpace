<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/2
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
</head>
<body>
<%
  if(request.getSession().getAttribute("username") != null){

%>
<div>
  <button id="btn" onload="btnClicked()">点击</button>
  <table id="info" border="2px">
    <tr id="infoO">
      <th>书名：</th>
      <th>ID</th>
      <%--<th>性别：</th>--%>
      <%--<th>年龄：</th>--%>
      <%--<th>职业：</th>--%>
    </tr>
  </table>
</div>
<a href="addBook.jsp">添加书籍</a>
<form action="exit" method="get">
  <input type="submit" value="退出登录">
</form>
<%
  } else {

%>
<a style="text-align: center;font-weight: bold;font-size: 45px;" href="login.jsp">请登录</a>
<%
  }
%>
</body>
<script type="text/javascript">
    function btnClicked() {
        $.getJSON("http://localhost:8080/getbooks",
            function (data, status) {
                console.log(data);
                $.each(data,function (i,data) {
                    $('#info').append($('<tr>').append($('<td>').append($('<a>').text(data['bookname']).attr("href","book.jsp?id="+i).attr("id",i))));//.append($('<td>').text(i))
                })
            }
        )
    }
    $('#btn').click(btnClicked);
    btnClicked();
</script>
</html>
