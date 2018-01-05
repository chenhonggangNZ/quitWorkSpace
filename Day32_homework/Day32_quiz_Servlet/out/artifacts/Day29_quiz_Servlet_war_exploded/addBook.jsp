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
    <meta name="keyword" content="#$*%$" >
    <title>增添书籍</title>
    <link rel="stylesheet" href="css/quiz_24Login.css" type="text/css">
</head>
<body>
<c:if test="${sessionScope.username != null}" var="result" scope="request">
<header>
    <logo>
        <img src="img/logo.png">
    </logo>
</header>
<main style="padding-top: 100px;">
    <simple style="width: 1300px;height: 800px; margin: 0px auto; display: block; background: white;">
        <register>
            <h1 style="padding-top: 30px;">我的书架</h1>
            <div style="display: inline-block;height: 34px;">
                <span style="background: url(img/ifyouneed.png) -20px -1px; width:18px;height: 23px;display: block; margin-top: 10px; float: left"></span>
                <a href="" style="display: block;margin-top: 13px; margin-left: 2px; float: left; color: black;" >查询书籍</a>
            </div>
            <div style="display: inline-block;">
                <span style="background: url(img/ifyouneed.png) -1px -21px; display:block; float: left; width:18px;height: 23px; margin-top: 10px; margin-left: 30px;"></span>
                <a href="" style="margin-left: 0px; float: left;display: block; margin-left:3px; margin-top: 13px; color: #377EE9;">增添书籍</a>
            </div>
            <form action="savebook" method="post" class="f_form">
                <label for="adress" class="sequence a"  >书名<span class="sect"></span></label>
                <input type="text" class="input" id="adress" name="bookname" placeholder="请输入书籍名称"><br>
                <label for="passworded" class="sequence p">作者<span class="sect"></span></label>
                <input type="text" class="input" id="passworded" name="writer" placeholder="请输入作者"><br>
                <label for="rePassword" class="sequence r">价格<span class="sect"></span></label>
                <input type="text" class="input" id="rePassword" name="price" placeholder="请输入书籍价格"><br>
                <input type="submit" value="确定" class="input" id="sublimet"><br>
            </form>
        </register>
    </simple>
</main>
<footer></footer>
</c:if>
<c:if test="${!requestScope.result}">
<a style="text-align: center;font-weight: bold;font-size: 45px;" href="login.jsp">请登录</a>
</c:if>
</body>
</html>