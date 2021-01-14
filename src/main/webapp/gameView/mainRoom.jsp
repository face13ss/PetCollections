<%--
  Created by IntelliJ IDEA.
  User: Faceless
  Date: 1/11/2021
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pet Collections</title>
    <link rel="stylesheet" href="../css/body.css">

</head>
<body>
<div id="header">
    <p class="userInformation">Name: <c:out value="${user.getDisplayName()}"/></p>
    <p><a href="/game?action=changePassword">Change Password</a></p>
    <br>
    <p class="userInformation">Money: <c:out value="${user.getMoney()}"/></p>
    <a href="/game?action=logout"><p style="color: #000;">Logout</p></a>
</div>
<div class="item1">
    <a href="/game?action=house">
        <img src="../image/assets/house.png">
    </a>
</div>
<div class="item1">
    <a href="/game?action=dungeon">
        <img src="../image/assets/dungeon.png">
    </a>
</div>
<div class="item1">
    <a href="/game?action=forest">
        <img src="../image/assets/forest.png">
    </a>
</div>
<div class="item1">
    <a href="/game?action=shop">
        <img src="../image/assets/shop.png">
    </a>
</div>
<div class="item1">
    <a href="/game?action=email">
        <img src="../image/assets/email.png">
    </a>
</div>
<div class="item1">
    <a href="/game?action=friendList">
        <img src="../image/assets/friends.jpg">
    </a>
</div>
</body>
</html>