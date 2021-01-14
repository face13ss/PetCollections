<%--
  Created by IntelliJ IDEA.
  User: Faceless
  Date: 1/13/2021
  Time: 4:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pet Collections</title>
</head>
<body>
    <fieldset>
        <legend>Create Account</legend>
        <c:if test='${requestScope["message"]!=null}'>
            <p style="color: red">${requestScope["message"]}</p>
        </c:if>
        <form method="post">
            <table>
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="username" placeholder="User Name"></td>
                </tr>
                <tr>
                    <td>Display Name: </td>
                    <td><input type="text" name="displayName" placeholder="Display Name"></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password" placeholder="Password"></td>
                </tr>
                <tr>
                    <td>Email: </td>
                    <td><input type="text" name="email" placeholder="exam@email.com"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Sign In"></td>
                </tr>
            </table>
        </form>
    </fieldset>
</body>
</html>
