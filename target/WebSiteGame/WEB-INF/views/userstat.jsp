<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 30.03.18
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>User statistics</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/reportUsers.css">
    <jsp:include page="../../head/head.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
</head>
<body>

    <h1 class="head">USER STATISTICS</h1>

    <div class="container">
        <div class="block">User id</div>
        <div class="block">User Email</div>
        <div class="block">User Nick name</div>
        <div class="block">User First name</div>
        <div class="block">User Last name</div>
        <div class="block">User Status</div>
        <div class="block">User Key</div>
        <div class="block">User Role</div>
        <div class="block">User Games</div>
    </div>

    <div class="container_users">
        <c:forEach items="${requestScope.statuser}" var="user">
            <div class="block_users">
                <div class="info">${user.id}</div>
                <div class="info">${user.email}</div>
                <div class="info">${user.nickname}</div>
                <div class="info">${user.firstname}</div>
                <div class="info">${user.lastname}</div>
                <div class="info">${user.key}</div>
                <div class="info">${user.status}</div>
                <div class="info"><c:out value="${user.roleName}"/></div>
                <div class="info"><c:out value="${user.sizeStatGame}"/></div>
            <form action="reportUser" method="post">
                <div class="but">
                    <button type="submit" name="bname" value="more" class="btn_more">More</button>
                    <input type="hidden" name="id" value="${user.id}"/>
                    <button type="submit" name="bname" value="send" class="btn_send">Send massage</button>
                    <input type="hidden" name="nickname" value="${user.nickname}"/>
                </div>
            </form>
            </div>
        </c:forEach>
    </div>
</body>
</html>
