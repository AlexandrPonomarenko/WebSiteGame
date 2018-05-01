
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>All</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/allInfo.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/libJquery/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

<div class="content-wrapper">
    <div class="content">
        <jsp:include page="../../head/head.jsp"/>

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

    </div>
    <footer class="page-footer font-small indigo pt-0">
        <jsp:include page="../../footer/footer.jsp"/>
    </footer>
</div>
</body>
</html>
