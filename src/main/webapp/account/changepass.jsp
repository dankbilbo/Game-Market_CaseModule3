<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 1/13/2021
  Time: 8:29 AM
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
<c:if test="${requestScope['message'] != null}">
    <p>${requestScope['message']}</p>
</c:if>
<form action="/account" method="post" id="1">
    <div>
        Username : <input type="text" name="username" >
    </div>
    <div>
        Password : <input type="password" name="password" >
    </div>
    <div>
        Email : <input type="text" name="email" >
    </div>
    <div>
        Country : <input type="text" name="country" >
    </div>
    <div>
        BankAccount : <input type="text" name="bankaccount">
    </div>
    <div>
        <input type="submit">
    </div>
</form>
</body>
<script>
</script>
</html>
