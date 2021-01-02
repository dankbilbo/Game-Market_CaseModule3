<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<head>
    <title>sql:query Tag</title>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expire", 0);
%>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/casestudymodule3"
                   user="root" password="1234"/>

<sql:query dataSource="${db}" var="listAccounts">
    SELECT * FROM accounts;
</sql:query>

<sql:query dataSource="${db}" var="newReleasedGames">
    SELECT * FROM games ORDER BY releaseddate DESC LIMIT 10;
</sql:query>

<a href="/app/profile.jsp">Profile</a>
<a href="http://localhost:8080/">Log out</a>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<table border="2" width="100%">
    <tr>
        <th>AccountID</th>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
    </tr>
    <c:forEach var="account" items="${listAccounts.rows}">
        <tr>
            <td><c:out value="${account.id}"/></td>
            <td><c:out value="${account.username}"/></td>
            <td><c:out value="${account.password}"/></td>
            <td><c:out value="${account.email}"/></td>
        </tr>
    </c:forEach>
</table>
<table border="2" width="100%">
    <tr>
        <th>GameID</th>
        <th>Name</th>
        <th>Released Date</th>
    </tr>
    <c:forEach var="game" items="${newReleasedGames.rows}">
        <tr>
            <td><c:out value="${game.id}"/></td>
            <td><c:out value="${game.name}"/></td>
            <td><c:out value="${game.releasedDate}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>