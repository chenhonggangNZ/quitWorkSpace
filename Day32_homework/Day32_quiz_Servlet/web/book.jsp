<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/2
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>详细资料</title>
    <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
</head>
<body>
<c:if test="${sessionScope.username != null}" var="result" scope="request">
<div>
    <button id="btn" onload="btnClicked()">点击</button>
    <table id="info" border="2px">
        <tr id="infoO">
            <th>书名：</th>
            <th>作者：</th>
            <th>价格：</th>
            <!--<th>职业：</th>-->
        </tr>
    </table>
</div>
<form action="exit" method="get">
    <input type="submit" value="退出登录">
</form>
</c:if>
<c:if test="${!requestScope.result}">
<a style="text-align: center;font-weight: bold;font-size: 45px;" href="login.jsp">请登录</a>
</c:if>
</body>
<script type="text/javascript">
    function btnClicked() {
        $.getJSON("http://localhost:8080/getbooks",
            function (data, status) {
                console.log(data);
                $.each(data,function (i,data) {
                    var str=location.href;
                    var num=str.indexOf("=")
                    str=str.substr(num+1);
                   str = parseInt(str)
                    if(i === str){
                    $('#info').append($('<tr>').append($('<td>').text(data['bookname'])).append($('<td>').text(data['writer']))
                        .append($('<td>').text(data['price'])));
                    }
                })
            }
        )
    }
    $('#btn').click(btnClicked);
    btnClicked();
</script>
</html>