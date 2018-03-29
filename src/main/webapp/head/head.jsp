<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 27.03.18
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css"/>
</head>
<body>
<header>
    <div id="nav-curtain"></div>
    <div class="nav-content">
        <%--<a class="logo" href="#"><img src="${pageContext.request.contextPath}/images/star-electronics-120x120.png"></a>--%>
        <nav id="nav">
            <ul>
                <li><a href="#">Author</a></li>
                <li><a href="#">About</a></li>

                <li><a href="#">Help</a></li>
                <li><a href="${pageContext.request.contextPath}/home">home</a></li>
                <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                <li><a href="${pageContext.request.contextPath}/logon">Logon</a></li>
                    <%--<li><a href="${pageContext.request.contextPath}/logOut">Log out</a></li>--%>
            </ul>
        </nav>
        <%--<a class="garage" href="${pageContext.request.contextPath}/yourOffice"><span class="icon-home"></span></a>--%>
    </div>
</header>
</body>
</html>
