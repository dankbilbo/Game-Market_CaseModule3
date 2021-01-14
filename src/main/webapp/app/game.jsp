<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/11/2021
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<a href="/app?action=search&id=${requestScope["game"].getId()}">
<img src="${requestScope["game"].getImgURL()}" ></a>
<table class="table table-striped table-dark">
    <caption>${requestScope["game"].getName()}</caption>
    <tr>
        <td>Game ID</td>
        <td>${requestScope["game"].getId()}</td>
    </tr>
    <tr>
        <td>App Type</td>
        <td>${requestScope["game"].getAppType()}</td>
    </tr>
    <tr>
        <td>Released Date</td>
        <td>${requestScope["game"].getReleasedDate()}</td>
    </tr>
    <tr>
        <td>Price</td>
        <td>${requestScope["game"].getPrice() - (requestScope["game"].getPrice() * requestScope["game"].getDiscount() / 100)}</td>
    </tr>
    <tr>
        <td>Díscount</td>
        <td>${requestScope["game"].getDiscount()}</td>
    </tr>
    <tr>
        <td>Developer</td>
        <td><a href="/app?action=search&dev=${requestScope["game"].getDeveloper().getId()}">${requestScope["game"].getDeveloper().getName()}</a></td>
    </tr>
    <tr>
        <td>Publisher</td>
        <td><a href="/app?action=search&dev=${requestScope["game"].getDeveloper().getId()}">${requestScope["game"].getPublisher().getName()}</a></td>
    </tr>
</table>
</body>
</html>
