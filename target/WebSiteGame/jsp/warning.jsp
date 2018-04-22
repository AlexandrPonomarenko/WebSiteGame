<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 30.03.18
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>Warning</title>
    <%--<jsp:include page="../head/head.jsp"/>--%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <jsp:include page="../head/head.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
</head>
<body>
    <h1>Uuupps.... You do not have permission to access this page.</h1>
    <a href="${pageContext.request.contextPath}/main">go main page</a>
</body>
</html>
