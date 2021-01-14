<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/14/2021
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game Owned</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="background: url(https://wallpapercave.com/wp/wp5705473.png) no-repeat;background-size: 100%">
<div style="display: flex; justify-content: flex-end">
    <a href="/app" >HOMEPAGE</a>
</div>
<table class="table table-striped table-dark" align="center">
    <tr>
        <th></th>
        <th>Game</th>
        <th>Order ID</th>
    </tr>
    <c:forEach items="${requestScope['gamesOwned'].keySet()}" var="game">
        <tr>
            <td><a href="/app?action=view&id=${game.getId()}" ><img src="${game.getLogoURL()}"></a></td>
            <td><a href="/app?action=view&id=${game.getId()}" >${game.getName()}</a></td>
            <td align="center">${requestScope['gamesOwned'].get(game)}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
