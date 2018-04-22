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
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css"/>
    <%--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/libJquery/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<header>
    <%--<div id="nav-curtain"></div>--%>
    <%--<div class="nav-content">--%>
        <%--<nav id="nav">--%>
            <%--<ul>--%>
                <%--<li><a href="${pageContext.request.contextPath}/jsp/author.jsp">Author</a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/jsp/about.jsp">About</a></li>--%>

                <%--<li><a href="${pageContext.request.contextPath}/help">Help</a></li>--%>
                <%--<li><a href="${pageContext.request.contextPath}/home">home</a></li>--%>
                <%--<c:if test="${sessionScope.nickname == null}">--%>
                    <%--<li><a href="${pageContext.request.contextPath}/login">Login</a></li>--%>
                    <%--<li><a href="${pageContext.request.contextPath}/logon">Logon</a></li>--%>
                <%--</c:if>--%>
                <%--<c:if test="${sessionScope.nickname != null}">--%>
                    <%--<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>--%>
                <%--</c:if>--%>

                                                <%--&lt;%&ndash;part manager&ndash;%&gt;--%>

                <%--<c:if test="${sessionScope.role == 'manager'}">--%>
                    <%--<li><a href="${pageContext.request.contextPath}/reportUser">Report</a></li>--%>
                <%--</c:if>--%>

                                                <%--&lt;%&ndash;part admin&ndash;%&gt;--%>
                <%--<c:if test="${sessionScope.role == 'admin'}">--%>
                    <%--<li><a href="${pageContext.request.contextPath}/reportUser">Report</a></li>--%>
                    <%--<li><a href="${pageContext.request.contextPath}/fullreport">FullReport</a></li>--%>
                <%--</c:if>--%>
                <%--<li><a href="${pageContext.request.contextPath}/create">Play</a></li>--%>
            <%--</ul>--%>
        <%--</nav>--%>
    <%--</div>--%>

        <nav class="navbar navbar-light bg--danger">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/main">
                <img src="${pageContext.request.contextPath}/image/iconslogo.png" width="40" height="40" class="d-inline-block align-top" alt="">
                Main
            </a>
            <nav class="nav nav-pills nav-justified">
                <a class="nav-link" href="${pageContext.request.contextPath}/jsp/author.jsp">Author</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/jsp/about.jsp">About</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/help">Help</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
                <c:if test="${sessionScope.nickname == null}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login">Sing in</a>
                    <a class="nav-link" href="${pageContext.request.contextPath}/logon">Sing on</a>
                </c:if>
                <c:if test="${sessionScope.nickname != null}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout">Sing out</a>
                </c:if>
                <c:if test="${sessionScope.role == 'manager'}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/reportUser">Report</a>
                </c:if>
                <c:if test="${sessionScope.role == 'admin'}">
                    <a class="nav-link" href="${pageContext.request.contextPath}/reportUser">Report</a>
                    <a class="nav-link" href="${pageContext.request.contextPath}/fullreport">Full report</a>
                    <%--<a class="nav-link disabled" href="${pageContext.request.contextPath}/fullreport">Disabled</a>--%>
                </c:if>
                <a class="nav-link active" href="${pageContext.request.contextPath}/create">Play</a>
            </nav>
        </nav>

        <%--<nav class="navbar navbar-light bg-light">--%>
            <%--&lt;%&ndash;<a class="navbar-brand" href="${pageContext.request.contextPath}/main">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<img src="${pageContext.request.contextPath}/image/iconslogo.png" width="40" height="40" class="d-inline-block align-top" alt="">&ndash;%&gt;--%>
                <%--&lt;%&ndash;Main&ndash;%&gt;--%>
            <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
            <%--<ul class="nav nav-pills nav-justified">--%>

                <%--<li class="nav-item">--%>
                    <%--<a class="navbar-brand" href="${pageContext.request.contextPath}/main">--%>
                        <%--<img src="${pageContext.request.contextPath}/image/iconslogo.png" width="40" height="40" class="d-inline-block align-top" alt="">--%>
                        <%--Main--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="${pageContext.request.contextPath}/jsp/author.jsp">Author</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="${pageContext.request.contextPath}/jsp/about.jsp">About</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="${pageContext.request.contextPath}/help">Help</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>--%>
                <%--</li>--%>
                <%--<c:if test="${sessionScope.nickname == null}">--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="${pageContext.request.contextPath}/login">Sing in</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="${pageContext.request.contextPath}/logon">Sing on</a>--%>
                <%--</li>--%>
                <%--</c:if>--%>
                <%--<c:if test="${sessionScope.nickname != null}">--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="${pageContext.request.contextPath}/logout">Sing out</a>--%>
                <%--</li>--%>
                <%--</c:if>--%>
                <%--<c:if test="${sessionScope.role == 'manager'}">--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="${pageContext.request.contextPath}/reportUser">Report</a>--%>
                <%--</li>--%>
                <%--</c:if>--%>
                <%--<c:if test="${sessionScope.role == 'admin'}">--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="${pageContext.request.contextPath}/reportUser">Report</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link" href="${pageContext.request.contextPath}/fullreport">Full report</a>--%>
                <%--</li>--%>
                <%--</c:if>--%>
                <%--<li class="nav-item">--%>
                <%--<a class="nav-link active" href="${pageContext.request.contextPath}/create">Play</a>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</nav>--%>
</header>
</body>
</html>
