<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'bookdesc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		font-size: 10pt;
		background: rgb(254,238,189);
	}
	div {
		margin:20px;
		border: solid 2px gray;
		width: 150px;
		height: 150px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
</style>
  </head>
  
  <body>
  <div>
    <img src="<c:url value='/book_img/20029394-1_l.jpg'/>" border="0"/>
  </div>
  <form style="margin:20px;" id="form" action="../../../adminBook" method="post">
	  <input type="hidden" name="bid" value="${requestScope.book.getBid()}">
  	图书名称：<input type="text" name="bname" value="${requestScope.book.getBname()}"/><br/>
  	图书单价：<input type="text" name="price" value="${requestScope.book.getPrice()}元"/><br/>
  	图书作者：<input type="text" name="author" value="${requestScope.book.getAuthor()}"/><br/>
	  		  <input type="hidden" value="${requestScope.book.getImage()}" name="image">
  	图书分类：<select style="width: 150px; height: 20px;" name="cid">
	  <c:forEach items="${requestScope.allCategory}" var="category">
		  <c:if test="${category.getCid().equals(requestScope.book.getCid())}" var="result" scope="page">
			  <option value="${category.getCid()}" selected="selected">${category.getCname()}</option>
		  </c:if>
		  <c:if test="${!result}">
			  <option value="${category.getCid()}">${category.getCname()}</option>
		  </c:if>
	  </c:forEach>
    	</select><br/>
	  <select style="width: 150px; height: 20px;" name="method">
		  <option value="del">删除</option>
		  <option value="edit">修改</option>
	  </select>
  	<input type="submit" onclick="return confirm('确定更改该图书？');"/>
  </form>
  </body>
</html>
