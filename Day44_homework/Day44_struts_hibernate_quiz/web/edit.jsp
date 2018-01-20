<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2018/1/19
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<s:form action="add" method="POST">
    员工姓名：<s:textfield name="employee.ename" value="%{#request.employee.getEname()}"/>
    员工年龄：<s:textfield name="employee.age" value="%{#request.employee.getAge()}"/>
    所属部门：<s:textfield name="employee.department" value="%{#request.employee.getDepartment()}"/>
    入职时间：<s:textfield name="employee.hiredate" value="%{#request.employee.getHiredate()}"/>
    家庭地址：<s:textfield name="employee.address" value="%{#request.employee.getAddress()}"/>
    手机号码：<s:textfield name="employee.telnumber" value="%{#request.employee.getTelnumber()}"/>
              <s:submit/>
</s:form>
</body>
</html>
