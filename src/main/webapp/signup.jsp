<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/28/2020
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signup</title>
</head>
<body>
<form action="/signup" method="post" id="signupForm">
    <label for="username">username</label>
    <input type="text" name="username" id="username" placeholder="username">
    <br>
    <label for="password">password</label>
    <input type="text" name="password" id="password" placeholder="password">
    <br>
    <label for="confirmedPassword">confirmed password</label>
    <input type="text" name="" id="confirmedPassword" placeholder="confirmedPassword">
    <br>
    <label for="email">email</label>
    <input type="text" name="email" id="email" placeholder="email">
    <br>
    <label for="bankAccountID">BankAccount Number</label>
    <input type="text" name="bankAccountID" id="bankAccountID" placeholder="bankaccount number">
    <br>
    <label for="country">country</label>
    <input type="text" name="country" id="country" placeholder="country">
    <button type="submit">signup</button>
</form>
<script>
    let username = document.getElementById("username");
    let password = document.getElementById("password");
    let signupForm = document.getElementById("signupForm");
    signupForm.addEventListener("submit", (e) => {
        if (username.value.length < 4) {
            e.preventDefault();
            alert("nhap lai");
        }
    });
</script>
</body>
</html>
