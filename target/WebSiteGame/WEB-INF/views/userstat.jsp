
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>User statistics</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/reportUsers.css">
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

    </div>
    <footer class="page-footer font-small indigo pt-0">
        <jsp:include page="../../footer/footer.jsp"/>
    </footer>
</div>

</body>
</html>
