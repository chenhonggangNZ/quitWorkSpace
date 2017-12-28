<%--
  Created by IntelliJ IDEA.
  User: lanou3g
  Date: 2017/12/28
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
</head>
<body>
<div>
    <button id="btn">点击</button>
    <table id="info" border="2px">
        <tr id="infoO">
            <th>姓名：</th>
            <th>性别：</th>
            <th>年龄：</th>
            <th>职业：</th>
        </tr>
    </table>
</div>
</body>
<script type="text/javascript">
    function btnClicked() {
        $.getJSON("http://localhost:8080/info",
            function (data, status) {
            console.log(data);
                $.each(data,function (i,data) {
                    $('#info').append($('<tr>').append($('<td>').text(data['name'])).append($('<td>').text(data['gender']))
                        .append($('<td>').text(data['age'])).append($('<td>').text(data['job'])));
                })
            }
        )
    }
    $('#btn').click(btnClicked);
</script>
</html>
