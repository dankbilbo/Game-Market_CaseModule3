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
</head>
<body>
<table width="100%" align="center">
    <tr>
        <td colspan="2">${sessionScope["account"].getUsername()}</td>
    </tr>
    <tr>
        <td>Account</td>
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
</body>
</html>
