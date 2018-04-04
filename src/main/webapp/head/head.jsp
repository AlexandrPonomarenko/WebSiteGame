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
                <li><a href="${pageContext.request.contextPath}/jsp/author.jsp">Author</a></li>
                <li><a href="${pageContext.request.contextPath}/jsp/about.jsp">About</a></li>

                <li><a href="${pageContext.request.contextPath}/help">Help</a></li>
                <li><a href="${pageContext.request.contextPath}/home">home</a></li>
                <c:if test="${sessionScope.nickname == null}">
                    <li><a href="${pageContext.request.contextPath}/login">Login</a></li>
                    <li><a href="${pageContext.request.contextPath}/logon">Logon</a></li>
                </c:if>
                <c:if test="${sessionScope.nickname != null}">
                    <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                </c:if>

                                                <%--part manager--%>

                <c:if test="${sessionScope.role == 'manager'}">
                    <li><a href="${pageContext.request.contextPath}/reportUser">Report</a></li>
                </c:if>

                                                <%--part admin--%>
                <c:if test="${sessionScope.role == 'admin'}">
                    <li><a href="${pageContext.request.contextPath}/reportUser">Report</a></li>
                    <li><a href="${pageContext.request.contextPath}/fullreport">FullReport</a></li>
                </c:if>
            </ul>
        </nav>
        <%--<a class="garage" href="${pageContext.request.contextPath}/yourOffice"><span class="icon-home"></span></a>--%>
    </div>
</header>
</body>
</html>
