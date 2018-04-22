<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 28.03.18
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>Info</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <jsp:include page="../../head/head.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <%--<jsp:include page="../../head/head.jsp"/>--%>
    <%--<jsp:include page="${pageContext.request.contextPath}/head/head.jsp"/>--%>
</head>
<body>
    <h1> Thank you for registration on ours site! We are send you email and you have to confirm registration for ended.</h1>
    <a href="${pageContext.request.contextPath}/main">in the main page</a>
</body>
</html>
