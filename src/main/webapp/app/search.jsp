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
</head>
<body>
<div>
    <form action="/app?action=search" method="post">
        <input type="text" name="namesearch">
        Search app by name: <input type="submit">
        <br>
        <select name="apptype" >
            <c:forEach items="${}" var="type">
                <option value="${}"></option>
            </c:forEach>
        </select>
        <select name="dev" >
            <option value="">Publisher/Developer</option>
            <c:forEach var="company" items="${requestScope['listCompany']}">
                <option value="${company.getName()}">${company.getName()}</option>
            </c:forEach>
        </select>
        <select name="releaseddate" >
            <option value="">Released Date</option>
            <option value="">Less than 1 Month ago</option>
            <option value="">Less than 6 Months ago</option>
            <option value="">Less than 1 year ago</option>
        </select>
        <select name="discount" >
            <option value="">Discount</option>
            <option value="25">Under 25%</option>
            <option value="50">Over 25% and Under 50%</option>
            <option value="">Over 75%</option>
        </select>
        <select name="price" >
            <option value="">Price</option>
            <option value="0">Free</option>
            <option value="10">Under 10$</option>
            <option value="">Over 10$</option>
        </select>
    </form>
</div>
<table>
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
        <td>${game.getPrice() - game.getPrice() * game.getPrice()/100}</td>
        <td>${game.getDiscount()}%</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
