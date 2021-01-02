<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<head>
    <title>sql:query Tag</title>
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost/casestudymodule3"
                   user="root" password="1234"/>


<sql:query dataSource="${db}" var="newReleasedGames">
    SELECT * FROM games;
</sql:query>

<table border="2" width="100%">
    <tr>
        <th>GameID</th>
        <th>Name</th>
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