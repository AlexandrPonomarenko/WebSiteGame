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
    <title>Stat</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/fullStatUser.css">
    <jsp:include page="../../head/head.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxFullStatisticsUsersDelete.js"></script>
</head>
<body>
    <h1 class="head">FULL STATISTICS USERS</h1>

    <div class="container">
        <div class="block">User id</div>
        <div class="block">User Email</div>
        <div class="block">User Nick name</div>
        <div class="block">User First name</div>
        <div class="block">User Last name</div>
        <div class="block">User Status</div>
        <div class="block">User Key</div>
        <div class="block">User Password</div>
        <div class="block">User Password two</div>
        <div class="block">User Role</div>
        <div class="block">User Games</div>
    </div>

    <c:forEach items="${requestScope.allliset}" var="user">
        <%--<span class="info">${user.id}</span>--%>
        <%--<span class="info">${user.email}</span>--%>
        <%--<span class="info">${user.nickname}</span>--%>
        <%--<span class="info">${user.firstname}</span>--%>
        <%--<span class="info">${user.lastname}</span>--%>
        <%--<span class="info">${user.key}</span>--%>
        <%--<span class="info">${user.password}</span>--%>
        <%--<span class="info">${user.passwordTwo}</span>--%>
        <%--<span class="info">${user.status}</span>--%>
        <%--<span class="info"><c:out value="${user.roleName}"/></span>--%>
        <%--<span class="info"><c:out value="${user.sizeStatGame}"/></span>--%>

        <div data-user-id="${user.id}">
            <div>
                <span class="info">${user.id}</span>
                <span class="info">${user.email}</span>
                <span class="info">${user.nickname}</span>
                <span class="info">${user.firstname}</span>
                <span class="info">${user.lastname}</span>
                <span class="info">${user.key}</span>
                <span class="info">${user.password}</span>
                <span class="info">${user.passwordTwo}</span>
                <span class="info">${user.status}</span>
                <span class="info"><c:out value="${user.roleName}"/></span>
                <span class="info"><c:out value="${user.sizeStatGame}"/></span>
            </div>
            <button type="button" class="action" data-action="more">More</button>
            <button type="button" class="action" data-action="send">Send massage</button>
            <button type="button" class="action" data-action="delete">Delete user</button>
            <button type="button" class="action" data-action="block">Block user</button>
        </div>

        <%--<form user="">--%>
            <%--<button type="submit" name="bname" value="more" class="btn_more">More</button>--%>
            <%--<input type="hidden" name="id" value="${user.id}"/>--%>

            <%--<button type="submit" name="bname" value="send" class="btn_send">Send massage</button>--%>
            <%--<input type="hidden" name="nickname" value="${user.nickname}"/>--%>

            <%--<button type="button" data-user-id="${user.id}" name="bname" value="delete" class="btn_del">Delete user</button>--%>
            <%--<input type="hidden" id="${user.id}" name="id" value="${user.id}"/>--%>

            <%--<button type="button" name="bname" value="block" class="btn_block">Block user</button>--%>
            <%--<input type="hidden" id="bl" name="id" value="${user.id}"/>--%>
        <%--</form>--%>
    </c:forEach>

    <div class="modal fade bd-example-modal-sm" id="m" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content" id="open">
                ...
            </div>
        </div>
    </div>
</body>
</html>
