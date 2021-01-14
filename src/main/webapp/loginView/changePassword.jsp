<%--
  Created by IntelliJ IDEA.
  User: Faceless
  Date: 1/14/2021
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pet Collection</title>
    <link rel="stylesheet" href="../css/body.css">

</head>
<body>
<div id="header">
    <p class="userInformation">Name: <c:out value="${user.getDisplayName()}"/></p><br>
    <p class="userMoney">Money: <c:out value="${user.getMoney()}"/></p>
    <a href="/game"><p style="color: #000;font-size: 20px">Back to Hall</p></a>
</div>
    <fieldset>
        <legend>Change Password</legend>
        <c:if test='${requestScope["messagesPassword"]!=null}'>
            <p style="color: red">${requestScope["messagesPassword"]}</p>
        </c:if>
        <form method="post">
            <table>
                <tr>
                    <td>Old Password:</td>
                    <td><input type="password" name="oldPassword" placeholder="Old Password"></td>
                </tr>
                <tr></tr>
                <tr>
                    <td>New Password:</td>
                    <td><input type="password" name="newPassword" placeholder="New Password"></td>
                </tr>
                <tr>
                    <td>Repeat Password:</td>
                    <td><input type="password" name="repeatPassword" placeholder="New Password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Change"></td>
                </tr>
            </table>
        </form>
    </fieldset>
</body>
</html>
