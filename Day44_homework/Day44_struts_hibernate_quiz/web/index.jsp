<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
 <table border="1px">
     <tr>
         <th>员工姓名</th>
         <th>员工年龄</th>
         <th>所属部门</th>
         <th>入职时间</th>
         <th>家庭地址</th>
         <th>手机号</th>
         <th>操作</th>
     </tr>
     <s:if test="%{#request.employees != null}" >
         <c:set var="asdey" value="0.0"/>
         <s:iterator value="%{#request.employees}" var="employeea">
             <tr>
                 <td>${employeea.getEname()}</td>
                 <td>${employeea.getAge()}</td>
                 <td>${employeea.getDepartment()}</td>
                 <td>${employeea.getHiredate()}</td>
                 <td>${employeea.getAddress()}</td>
                 <td>${employeea.getTelnumber()}</td>
                 <td>
                     <form action="employee.action" method="post" id="wr${(asdey=(asdey+1))}">
                         <input type="hidden" name="eid" value="${employeea.getEid()}">
                         <a href="javascript:document.getElementById('wr${asdey}').submit()"> 编辑</a>
                     </form>
                 </td>
             </tr>
         </s:iterator>

     </s:if>
 </table>
  <form action="add.action" method="post">
      员工姓名：<input name="employee.ename" type="text"><br>
      员工年龄：<input type="text" name="employee.age"><br>
      所属部门：<input type="text" name="employee.department"><br>
      入职时间：<input type="date" name="employee.hiredate"><br>
      家庭地址：<input type="text" name="employee.address"><br>
      手机号码：<input type="text" name="employee.telnumber"><br>
      <input type="submit" value="添加"><br>
  </form>
  </body>
</html>
