
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>Stat</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/fullStatUser.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/libJquery/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxFullStatisticsUsersDelete.js"></script>
</head>
<body>

<div class="content-wrapper">
    <div class="content">
        <jsp:include page="../../head/head.jsp"/>

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
    </c:forEach>

    <div class="modal fade bd-example-modal-sm" id="m" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content" id="open"></div>
        </div>
    </div>

    </div>
    <footer class="page-footer font-small indigo pt-0">
        <jsp:include page="../../footer/footer.jsp"/>
    </footer>
</div>

</body>
</html>
