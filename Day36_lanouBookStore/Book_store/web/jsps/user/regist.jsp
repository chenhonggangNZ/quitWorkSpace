<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<script src="../../js/jquery-3.2.1.min.js" type="application/javascript"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>注册</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="javascript:sub()" method="post" id="submits"><%--http://localhost:8080/user;--%>
	<input type="hidden" value="register" name="method">
	<input type="hidden" name="method" value="regist"/>
	用户名：<input type="text" name="username" id="username" value=""/><br/>
	密　码：<input type="password" id="password" name="password"/><br/>
	邮　箱：<input type="text" name="email" id="email" value=""/><br/>
	<input type="submit" value="注册"/>
</form>
  </body>
      <script type="text/javascript">
          function sub() {
              $.ajax({
                  cache: true,
                  type: "POST",
                  url:"http://localhost:8080/user",
                  data:$('#submits').serialize(),// 你的formid  
                  async: true,
                  error: function(request) {
					  $.each(request,function (index,data) {
                          $("#username").attr({"value":data["username"]});
                          $("#password").attr({"value":data["password"]});
                          $("#email").attr({"value":data["email"]});
                          alert(data["error"]);
                      })
                  },
                  success: function(data,status) {
                      if (data.indexOf("<head>")){
                          $(window).attr('location',"http://localhost:8080/jsps/msg.jsp");
                      } else {
                   $.each(data,function (index,data) {
                      $("#username").attr({"value":data["username"]});
                      $("#password").attr({"value":data["password"]});
                      $("#email").attr({"value":data["email"]});
                  })}
                  }
              });
          }
  </script>
</html>
