<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 04.04.18
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>INFO</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/info.css">
    <jsp:include page="../../head/head.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <%--<jsp:include page="../../head/head.jsp"/>--%>
</head>
<body>

<div class="form">
    <form method="post" action="info">
        <div class="inside">
            <label for="name">Your name:</label>
            <input type="text" name="name" id="name" value="${requestScope.name}" class="validate">
            <%--<c:out value="${requestScope.errorHelp['name']}"></c:out>--%>
            <%--<span class="empty-message">Empty</span>--%>
            <%--<span class="small-length-message">Small length</span>--%>
            <%--<span class="bad-words-message">Bad words</span>--%>
        </div>
        <%--<div class="inside">--%>
            <%--<label for="email">Your Email address:</label>--%>
            <%--<input type="email" name="email" id="email" value="" class="validate">--%>
            <%--&lt;%&ndash;<c:out value="${requestScope.errorHelp['email']}"></c:out>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<span class="empty-message">Empty</span>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<span class="small-length-message">Small length</span>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<span class="bad-words-message">Bad words</span>&ndash;%&gt;--%>
        <%--</div>--%>
        <div class="inside">
            <textarea name="texthelp" id="textarea" cols="140" rows="10" class="validate"></textarea>
            <%--<c:out value="${requestScope.errorHelp['texthelp']}"></c:out>--%>
            <%--<span class="empty-message">Empty</span>--%>
            <%--<span class="small-length-message">Small length</span>--%>
            <%--<span class="bad-words-message">Bad words</span>--%>
        </div>
        <input class="submit-button" type="submit" value="Send">
        <%--<c:out value="${requestScope.ok}"></c:out>--%>
    </form>
</div>
</body>
</html>
