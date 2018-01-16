<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/15
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>欢迎登陆！</title>
  </head>
  <body>
  <c:if test="${sessionScope.user != null}" var="result">
  <h1>欢迎登陆！${sessionScope.user.getUsername()}</h1>
  </c:if>
  <c:if test="${!result}">
      <h1>请登录！</h1>
  </c:if>
  </body>
</html>
