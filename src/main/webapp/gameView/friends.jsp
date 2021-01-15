<%--
  Created by IntelliJ IDEA.
  User: Faceless
  Date: 1/14/2021
  Time: 1:45 PM
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
    <p class="userInformation">Name: <c:out value="${user.getDisplayName()}"/></p><br>
    <p class="userMoney">Money: <c:out value="${user.getMoney()}"/></p>
    <a href="/game"><p style="color: #000;font-size: 20px">Back to Hall</p></a>
</div>
<form method="post">
    <input type="hidden" name="friendList" value="search">
    <input type="text" size="100" name="searchName" placeholder="Search Player Name">
    <input type="submit" value="Search">
</form>
    <c:if test="${peopleList!=null}">
        <table border="1" cellpadding="5">
            <tr>
                <td style="width: 100px"><h3>Display Name</h3></td>
                <td style="width: 100px"><h3>Action</h3></td>
            </tr>
            <c:forEach items="${peopleList}" var="people">
                <tr>
                    <td>${people.getDisplayName()}</td>
                    <td>
                        <form method="post">
                            <input type="hidden" name="friendList" value="addFriend">
                            <input type="hidden" name="peopleId" value="${people.getId()}">
                            <input type="submit" value="Add Friend">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
