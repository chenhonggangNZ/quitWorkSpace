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
    <meta name="keyword" content="#$%#">
    <title>登录本网站</title>
    <link rel="stylesheet" href="css/quiz_24Login.css" type="text/css">

</head>
<body>
<header>
    <logo>
        <img src="img/logo.png" >
    </logo>
    <ul>
        <li class="borderLeft floatRight"><a href="">帮助与文档</a></li>
        <li class="floatRight"><a href="">网易云首页</a></li>
    </ul>
    <span style="color: black; float: right;" id="times"></span>
</header>
<main>
    <simple>
        <img src="img/20171223154524.jpg">
        <login>
            <h1>登录</h1>
            <form action="login" method="post">
                <div id="users"></div>
                <input type="text" placeholder="网易云账号/网易邮箱账号" value="<%=request.getSession().getAttribute("before")%>" id="user" name="username">
                <br>
                <input type="password" placeholder="登录密码" name="password" id="password">
                <span id="passwords"></span>
                <br>
                <input type="checkbox" name="service" id="service">
                <label for="service" class="service">同意并遵守<a href="" style="color: #377EE9;">服务条款</a></label>
                <input type="checkbox" name="AvoidLanding" id="AvoidLanding">
                <label for="AvoidLanding" class="service">15天内免登陆</label>
                <br style="clear: both;">
                <input type="submit" value="登录" id="login">
            </form>
            <span class="floatLeft" style="margin-left:50px;">还没有账号？<a href="Register.html" style="color: #377EE9;">免费注册</a> </span>
            <a href="" class="floatLeft" style="margin-left: 110px; color: #377EE9;">忘记密码？</a>
        </login>
    </simple>

</main>
<footer></footer>
</body>
<script type="text/javascript">
    function show() {
        var now = new Date();
        var year = now.getFullYear();
        var month = now.getMonth() + 1;
        var day = now.getDate();
        var hours = now.getHours();
        var minutes = now.getMinutes();
        var seconds = now.getSeconds();
        var timess= "" + year + "年" + month + "月" + day + "日 " + hours + ":" + minutes + ":" + seconds + "";
        return timess;
    }
    function times() {
        var times = document.getElementById("times");
        setInterval(function () {
            times.innerText= show();
        },1000);
    }
    times();
</script>
</html>