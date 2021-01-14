<%--
  Created by IntelliJ IDEA.
  User: Faceless
  Date: 1/8/2021
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pet Collection</title>
</head>
<body>
<fieldset>
    <legend>Login</legend>
    <form method="post">
        <table>
            <tr>
                <td>Username</td>
                <td><input type="text" name="username" id="username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" id="password"></td>
            </tr>
            <tr>
                <td><a href="/createAccount">Sign Up</a></td>
                <td><input type="submit" value="Sign In"></td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>
