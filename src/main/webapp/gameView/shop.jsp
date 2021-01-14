<%--
  Created by IntelliJ IDEA.
  User: Faceless
  Date: 1/14/2021
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
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
<table border="1" cellpadding="5">
    <tr>
        <th>Icon</th>
        <th>Describes</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    <tr>
        <td><img src="/image/assets/egg.png" style="height: 50px; width: 50px"></td>
        <td style="height: 50px;width: 500px;">Use to open pet</td>
        <td style="width: 100px">1000</td>
        <td style="height: 50px;width: 50px;">
            <form method="post">
                <input type="submit" value="Buy" style="height: 40px;width: 80px;">
            </form>
        </td>
    </tr>
    <tr>
        <td><img src="/image/assets/heal%20Bottle.png" style="height: 50px; width: 50px"></td>
        <td style="height: 50px;width: 500px;">Regeneration pet's HP</td>
        <td style="width: 100px">500</td>
        <td style="height: 50px;width: 100px;">
            <form method="post">
                <input type="submit" disabled value="Out of Stock" style="height: 40px;width: 80px;">
            </form>
        </td>
    </tr>
</table>
</body>
</html>
