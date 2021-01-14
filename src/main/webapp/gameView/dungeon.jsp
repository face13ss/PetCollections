<%--
  Created by IntelliJ IDEA.
  User: Faceless
  Date: 1/11/2021
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/body.css">
</head>
<body>
<div id="header">
    <p class="userInformation">Name: <c:out value="${user.getDisplayName()}"/></p><br>
    <p class="userMoney">Money: <c:out value="${user.getMoney()}"/></p>
    <a href="/game"><p style="color: #000;font-size: 20px">Back to Hall</p></a>
</div>
    <h1>Tính năng này đang bảo trì, vui lòng quay lại sau</h1>
</body>
</html>
