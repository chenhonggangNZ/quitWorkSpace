<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<head>
    <meta name="keyword" content="大幅度降水" >
    <title>注册</title>
    <link rel="stylesheet" href="quiz_24Login.css" type="text/css">
</head>
<body>
<header>
    <div id="logo">
        <img src="logo.png">
    </div>
</header>
<main style="padding-top: 100px;">
    <div id="simple" style="width: 1300px;height: 800px; margin: 0px auto; display: block; background: white;">
        <div id="register">
            <h1 style="padding-top: 30px;">注册网易云账号</h1>
            <div style="display: inline-block;height: 34px;">
                <span style="background: url(ifyouneed.png) -20px -1px; width:18px;height: 23px;display: block; margin-top: 10px; float: left"></span>
                <a href="" style="display: block;margin-top: 13px; margin-left: 2px; float: left; color: black;" >手机号注册</a>
            </div>
            <div style="display: inline-block;">
                <span style="background: url(ifyouneed.png) -1px -21px; display:block; float: left; width:18px;height: 23px; margin-top: 10px; margin-left: 30px;"></span>
                <a href="" style="margin-left: 0px; float: left;display: block; margin-left:3px; margin-top: 13px; color: #377EE9;">邮箱号注册</a>
            </div>
            <form action="register.action" method="post" class="f_form">
                <input type="hidden" name="method" value="register">
                <label for="username" class="sequence a"  >用户名：<span class="sect"></span></label>
                <input type="text" class="input" id="username" name="user.username" placeholder="请输入用户名"><br>
                <div id="diva"><s:fielderror fieldName="username"/></div>
                <label for="password" class="sequence p">设置密码<span class="sect"></span></label>
                <input type="password" class="input" id="password" name="user.password" placeholder="请输入密码"><br>
                <div id="divp"><s:fielderror fieldName="password"/> </div>
                <label for="rePassword" class="sequence r">确认密码<span class="sect"></span></label>
                <input type="password" class="input" id="rePassword" name="user.repassword" placeholder="请再次填写密码"><br>
                <div id="divt"><s:fielderror fieldName="repassword"/> </div>
                <label for="tel_number" class="sequence t">手机号<span class="sect"></span></label>
                <input type="tel" class="input" id="tel_number"  name="user.telphone" placeholder="请输入手机号"><br>
                <div id="divtl"><s:fielderror fieldName="telphone"/></div>
                <label for="focs" class="sequence f">邮箱<span class="sect"></span></label>
                <input type="text" class="input" id="focs" name="user.email" placeholder="请输入邮箱账号"><br>
                <div id="divtp"><s:fielderror fieldName="email"/> </div>
                <label for="message" class="sequence m">图片验证码<span class="sect"></span></label>
                <input type="text" class="input" id="message" name="user.focs" placeholder="请输入图片验证码"><br>
                <img src="http://localhost:8080/codeImg">${pageContext.request.contextPath}
                <input type="hidden" value="${requestScope.focs}" name="refocs">
                <div id="divm"><s:fielderror fieldName="focs" /></div>
                <%--<span></span><input type="checkbox" class="ifuse"><span style="margin-left: 2px;margin-top: 10px; display: inline-block;position: absolute;left: 95px;">同意并遵守</span>--%>
                <%--<a href="" style="display: inline-block;margin-left: 2px;position: absolute;left: 175px; margin-top: 10px; color: #377EE9;">&lt;&lt;服务条款&gt;&gt;</a>--%>
                <input type="submit" value="注册" class="input" id="sublimet"><br>
                <a href="login.jsp" style="display: inline-block; float: right; margin-right: 74px; margin-top: 10px;color: #377EE9; font-weight: bold;">去登陆</a>
            </form>

        </div>
    </div>

</main>

<footer></footer>

</body>
<%--<script type="text/javascript">--%>
    <%--function onfocuss(ele) {--%>
        <%--var element = document.getElementById(ele);--%>
        <%--element.style.display="block";onfocus="onfocuss('divp')" onblur="onblurs('divp')"--%>
    <%--}--%>
    <%--function onblurs(ele) {--%>
        <%--var elementById = document.getElementById(ele);--%>
        <%--elementById.style.display="none";--%>
    <%--}--%>
<%--</script>--%>
</html>