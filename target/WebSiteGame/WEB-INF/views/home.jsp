<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 28.03.18
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>Welcome to the home</title>
    <jsp:include page="../../head/head.jsp"/>
    <%--<jsp:include page="${pageContext.request.contextPath}/head/head.jsp"/>--%>
</head>
<body>
    <br>
    <br>
    <br>
    <br>
    <h1>IT IS YOUR HOME MEN ${sessionScope.nickname} your status ${sessionScope.status}</h1>
    <h3>${requestScope.allGame}.........${requestScope.sumVins}........ ${requestScope.sumLost}</h3>
    <c:forEach items="${requestScope.setGame}" var="game">
        <span>
            <p>${game.id_game}----${game.vin}------${game.lost}</p>
        </span>

    </c:forEach>
</body>
</html>
