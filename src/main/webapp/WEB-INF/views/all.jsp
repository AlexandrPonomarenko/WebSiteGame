<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 03.04.18
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>All</title>
    <jsp:include page="../../head/head.jsp"/>
</head>
<body>
    <br>
    <br>
    <br>
    <h1>Full user statistics about user ${requestScope.selectuser.nickname}</h1>
    <h3>${requestScope.selectuser.id}.......${requestScope.selectuser.nickname}.......${requestScope.selectuser.firstname}....
        ${requestScope.selectuser.lastname}...... ${requestScope.selectuser.password}${requestScope.selectuser.passwordTwo}
        ${requestScope.selectuser.status}......${requestScope.selectuser.key}...${requestScope.selectuser.roleName}
    </h3>

    <c:forEach items="${requestScope.list}" var="game">
        <p>${game.id_game}......${game.lost}......${game.vin}</p>
    </c:forEach>
</body>
</html>
