<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 30.03.18
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>GAMES</title>
    <jsp:include page="../../head/head.jsp"/>
</head>
<body>
    <br>
    <br>
    <br>
    <br>

    <h1>CREATED GAMES</h1>
    <div id="main">
        <div id="game">
            <form action="create" method="post">
                <input type="hidden" name="create" value="create"/>
                <input type="submit" value="Create game">
            </form>
        </div>

        <div id="list_game">
            <form action="create", method="post">
                <c:forEach items="${requestScope.list}" var="item">
                    <p>${item.name}</p>

                </c:forEach>
            </form>
        </div>
    </div>


</body>
</html>
