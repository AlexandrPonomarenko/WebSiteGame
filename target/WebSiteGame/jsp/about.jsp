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
    <title>About</title>
    <%--<jsp:include page="../head/head.jsp"/>--%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/about.css">
    <jsp:include page="../head/head.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
</head>
<body>
    <h2 class="head">We are young, hot, purposeful, interesting team.</h2>
    <h3 class="under_head">Our projects:</h3>
    <div class="proj">
        <a class="one" href="#">Warm star</a>
        <a class="two" href="#">Just play</a>
    </div>
</body>
</html>
