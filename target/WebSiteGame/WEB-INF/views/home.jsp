
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>Welcome to the home</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Alfa+Slab+One" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/libJquery/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/checkStatus.js"></script>
</head>
<body>
<div class="content-wrapper">
    <div class="content">
        <jsp:include page="../../head/head.jsp"/>
<h1 class="head">Welcome to the home, <span class="name">${sessionScope.nickname}</span></h1>
    <p class="s">Your status: <span class="status" id="r">${sessionScope.status}</span></p>
    <div class="text">
        <span class="allGame">Games</span>
        <span class="win">Wins</span>
        <span class="lost">Lost</span>
    </div>
    <div class="num">
        <span class="a">${requestScope.allGame}</span>
        <span class="w">${requestScope.sumVins}</span>
        <span class="l">${requestScope.sumLost}</span>
    </div>

    </div>
    <footer class="page-footer font-small indigo pt-0">
        <jsp:include page="../../footer/footer.jsp"/>
    </footer>
</div>
</body>
</html>
