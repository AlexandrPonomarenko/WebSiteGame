
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css"/>
<header>

        <nav class="navbar navbar-light bg-dark">
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
                </c:if>
                <a class="nav-link active" href="${pageContext.request.contextPath}/create">Play</a>
            </nav>
        </nav>
</header>
