<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2017/12/28
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/setInfo" method="post">
    <lable>用户名：</lable>
    <input type="text" id="usernname" name="username">
    <lable>密码：</lable>
    <input type="password" id="password" name="password">
    <lable>昵称：</lable>
    <input type="text" id="nickname" name="nickname">
    <lable>姓名：</lable>
    <input type="text" id="personname" name="personname">
    <lable>性别：</lable>
    <input type="text" id="gender" name="gender">
    <lable>年龄：</lable>
    <input type="text" id="age" name="age">
    <lable>职业：</lable>
    <input type="text" id="job" name="job">
    <input type="submit">
  </form>
  </body>
</html>
