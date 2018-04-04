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
    <jsp:include page="../../head/head.jsp"/>
</head>
<body>

    <br>
    <br>
    <br>
    <br>

    <h1>USER STATISTICS</h1>
    <h3>User id... Email.....Log...Fn...Ln...Key...St...R...Game</h3>

    <c:forEach items="${requestScope.statuser}" var="user">
        <p>${user.id}...${user.email}...${user.nickname}...${user.firstname}...${user.lastname}...${user.key}...${user.status}...<c:out value="${user.roleName}"/>...<c:out value="${user.sizeStatGame}"/></p>

        <form action="reportUser" method="post">
            <button type="submit" name="bname" value="more" class="btn_more">More</button>
            <input type="hidden" name="id" value="${user.id}"/>
            <button type="submit" name="bname" value="send" class="btn_send">Send massage</button>
            <input type="hidden" name="nickname" value="${user.nickname}"/>
        </form>
    </c:forEach>
</body>
</html>
