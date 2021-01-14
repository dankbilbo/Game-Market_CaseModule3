<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/13/2021
  Time: 8:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="background: url(https://wallpapercave.com/wp/wp5705473.png) no-repeat;background-size: 100%">
<div style="display: flex; justify-content: flex-end">
    <a href="/app" >HOMEPAGE</a>
</div>
<table class="table table-striped table-dark" align="center">
    <tr>
        <td colspan="2">${sessionScope["account"].getUsername()}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${sessionScope["account"].getEmail()}</td>
    </tr>
    <tr>
        <td>Country</td>
        <td>${sessionScope["account"].getCountry()}</td>
    </tr>
    <tr>
        <td>Bank account number</td>
        <td>${sessionScope["account"].getBankAccountNumber()}</td>
    </tr>
</table>
<a href="/account?action=updatepass">Change Info</a>
</body >
</html>
