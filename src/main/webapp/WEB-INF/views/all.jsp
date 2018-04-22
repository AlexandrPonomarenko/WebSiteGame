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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/allInfo.css">
    <jsp:include page="../../head/head.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
</head>
<body>

    <h1 class="head">Full user statistics about user <span class="name">${requestScope.selectuser.nickname}</span></h1>

    <div class="container">
        <div class="block">User id: ${requestScope.selectuser.id}</div>
        <div class="block">User Nick name: ${requestScope.selectuser.nickname}</div>
        <div class="block">User First name:${requestScope.selectuser.firstname}</div>
        <div class="block">User Last name: ${requestScope.selectuser.lastname}</div>
        <div class="block">User Password: ${requestScope.selectuser.password}</div>
        <div class="block">User Password two: ${requestScope.selectuser.passwordTwo}</div>
        <div class="block">User Status: ${requestScope.selectuser.status}</div>
        <div class="block">User Key: ${requestScope.selectuser.key}</div>
        <div class="block">User Role: ${requestScope.selectuser.roleName}</div>
    </div>

    <c:if test="${requestScope.emptySet == null}">
        <p class="list">List Games</p>
    </c:if>

    <div class="container_games">
        <c:forEach items="${requestScope.list}" var="game">
            <div class="block_games">
                <span class="game">Game id: ${game.id_game}</span><span class="game">Lost: ${game.lost}</span><span class="game">Vin: ${game.vin}</span>
            </div>
        </c:forEach>
    </div>
    <c:if test="${requestScope.emptySet != null}">
        <p class="empty">${requestScope.emptySet}</p>
    </c:if>
</body>
</html>
