<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/13/2021
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="background: url(https://wallpapercave.com/wp/wp5705473.png) no-repeat;background-size: 100%">
<div style="display: flex; justify-content: flex-end">
    <a href="/app" >HOMEPAGE</a>
</div>
<div>
    <form action="/app?action=search" method="post">
        <input type="text" name="namesearch">
        Search app by name: <input type="submit">
        <br>
        <select name="apptype" >
            <option value="">App Type</option>
            <c:forEach items="${requestScope['appTypes']}" var="type">
                <option value="${type}">${type}</option>
            </c:forEach>
        </select>
        <select name="dev" >
            <option value="">Publisher/Developer</option>
            <c:forEach var="company" items="${requestScope['listCompany']}">
                <option value="${company.getId()}">${company.getName()}</option>
            </c:forEach>
        </select>
        <select name="releaseddate" >
            <option value="0">Released Date</option>
            <option value="1">Upcoming</option>
            <option value="2"><= 1 month ago</option>
            <option value="3"><= 1 year ago</option>
            <option value="4">> 1 year ago</option>
        </select>
        <select name="discount" >
            <option >Discount</option>
            <option value="1">Under 25%</option>
            <option value="2">Over 25% and Under 50%</option>
            <option value="3">Over 50%</option>
        </select>
        <select name="price" >
            <option >Price</option>
            <option value="1">Free</option>
            <option value="2">Under 5$</option>
            <option value="3">Between 5$ and 10$</option>
            <option value="4">Over 10$</option>
        </select>
    </form>
</div>
<table class="table table-striped table-dark" align="center">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Released Date</th>
        <th>Price</th>
        <th>Discount</th>
    </tr>
<c:forEach items="${requestScope['listGame']}" var="game">
    <tr>
        <td><a href="/app?action=view&id=${game.getId()}">${game.getId()}</a></td>
        <td><a href="/app?action=view&id=${game.getId()}">${game.getName()}</a></td>
        <td>${game.getReleasedDate()}</td>
        <td>${game.getPrice() - game.getPrice() * game.getDiscount()/100}</td>
        <td>${game.getDiscount()}%</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
