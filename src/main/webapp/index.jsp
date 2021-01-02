<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/28/2020
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<%--/////////////////////////////////////////--%>
<c:if test='${requestScope["message"] != null}'>
<p>${requestScope["message"]}</p>
</c:if>
<form action="/app" method="post" id="loginForm">
  <label for="user">Username</label>
  <input type="text" name="user" id="user" placeholder="username">
  <label for="password"></label>
  <input type="password" name="password" id="password" placeholder="password">
  <button type="submit" id="login">login</button>
</form>
    <a href="signup/signup.jsp">signup</a>
<%--/////////////////////////////////////////////--%>
<script>
  let username = document.getElementById("username");
  let password = document.getElementById("password");
  let loginForm = document.getElementById("loginForm");
  loginForm.addEventListener("submit", (e) => {
    if (username.value.length < 0) {
      e.preventDefault();
      alert("nhap lai");
    }
  });
</script>
</body>
</html>
