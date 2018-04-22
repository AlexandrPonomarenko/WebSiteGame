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
    <%--<jsp:include page="../../head/head.jsp"/>--%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <jsp:include page="../../head/head.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/checkStatus.js"></script>
</head>
<body>

<h1 class="head">Welcome to the home, <span class="name">${sessionScope.nickname}</span></h1>
    <p class="s">Your status: <span class="status">${sessionScope.status}</span></p>
    <div class="text">
        <span class="allGame">Games</span>
        <span class="win">Wins</span>
        <span class="lost">Lost</span>
    </div>
    <div class="num">
        <span class="a">${requestScope.allGame}</span>
        <span class="w">${requestScope.sumVins}</span>
        <span class="l">${requestScope.sumLost}</span>
    </div>
    <%--<p class="s">your status <span class="status">${sessionScope.status}</span></p>--%>
        <%--<h3>${requestScope.allGame}.........${requestScope.sumVins}........ ${requestScope.sumLost}</h3>--%>
    <%--<c:forEach items="${requestScope.setGame}" var="game">--%>
        <%--<span>--%>
            <%--<p>${game.id_game}----${game.vin}------${game.lost}</p>--%>
        <%--</span>--%>

    <%--</c:forEach>--%>
</body>
</html>
