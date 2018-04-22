<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 30.03.18
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>Author</title>
    <%--<jsp:include page="../head/head.jsp"/>--%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/author.css">
    <jsp:include page="../head/head.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
</head>
<body>
    <h2 id="author">Author of the project Ponomarenko Alexandr</h2>
    <div class="textHad">
        <h3 id="vacancy">The project was created with the purpose of interest to Java web development and job search for a vacancy Java Junior Developer.</h3>
    </div>
    <div>
        <h3 id="list">List technologies:</h3>

        <ul class="styleNone">
            <li><p class="m">Java SE: Core</p></li>
            <li><p class="m">Java EE: Servlet, JSTL, JSP, WebSocket, JavaMail, JPA</p></li>
            <li><p class="m">Data Base: JDBC Postgres</p></li>
            <li><p class="m">JPA: Hibernate</p></li>
            <li><p class="m">Web Server: Wild Fly</p></li>
            <li><p class="m">Also: JSON</p></li>
            <li><p class="m">Gradle: Maven</p></li>
            <li><p class="m">JavaScript: core, JQuery(Ajax)</p></li>
            <li><p class="m">HTML, CSS, little bit Bootstrap:)</p></li>
            <li><a class="a" href="https://github.com/AlexandrPonomarenko/WebSiteGame">Link to project</a></li>
            <li><a class="a" href="https://github.com/AlexandrPonomarenko?tab=repositories">Link to developer in GITHub</a></li>
        </ul>
    </div>
</body>
</html>
