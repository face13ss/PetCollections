<%--
  Created by IntelliJ IDEA.
  User: Faceless
  Date: 1/11/2021
  Time: 3:46 PM
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
<div>
    <fieldset>
        <legend>Inventory</legend>
        <h3>You have ${user.getEggs()} Eggs(s)</h3>
        <form method="post">
            <input type="hidden" name="trigger" value="eggOpen">
            <input type="submit" value="Open All">
        </form>
    </fieldset>
</div>
    <table border="1" cellpadding="5">
        <c:forEach var="pet" items="${petList}" >
            <tr>
                    <td style="height: 100px;width: 100px">icon</td>
                    <td style="height: 100px;width: 500px">
                        Name: <c:out value="${pet.getPetName()}"/><br>
                        HP: <c:out value="${pet.getHealth()}"/><br>
                        Hunger: <c:out value="${pet.getHunger()}"/><br>
                        Attack: <c:out value="${pet.getAttack()}"/><br>
                        Dodge: <c:out value="${pet.getDodge()}"/><br>
                        Exp: <c:out value="${pet.getExp()}"/><br>
                    </td>
                    <td style="height: 100px;width: 100px">
                        <form method="post">
                            <input type="hidden" name="trigger" value="healer">
                            <input type="hidden" name="idHealer" value="${pet.getId()}">
                            <input type="submit" value="Heal" style="height: 90px;width: 90px">
                        </form>
                    </td>
                    <td style="height: 100px;width: 100px;left: 30px">
                        <form method="post">
                            <input type="hidden" name="trigger" value="delete">
                            <input type="hidden" name="idDelete" value="${pet.getId()}">
                            <input type="submit" value="Sell" style="height: 30px;width: 30px">
                        </form>
                    </td>
                </tr>
        </c:forEach>
    </table>
</body>
</html>
