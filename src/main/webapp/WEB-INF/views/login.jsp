<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 15.03.18
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>Login</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <jsp:include page="../../head/head.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/systemMessageAjax.js"></script>
</head>
<body>
    <h1 class="head">Registration page</h1>

    <div class="control">
        <form class="form">
            <div class="col">
                <div class="row">
                    <div class="col">
                        <input type="text" class="form-control" id="n" name="login" placeholder="Nickname">
                        <span id="nickName"></span>
                    </div>
                    <div class="col">
                        <input type="email" class="form-control" id="e" name="email" placeholder="Email">
                        <span id="email"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <input type="text" class="form-control" id="f" name="FName" placeholder="First name">
                        <span id="fName"></span>
                    </div>
                    <div class="col">
                        <input type="text" class="form-control" id="l" name="LName" placeholder="Last name">
                        <span id="lName"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <input type="password" class="form-control" id="p" name="password" placeholder="Password">
                        <span id="password"></span>
                    </div>
                    <div class="col">
                        <input type="password" class="form-control" id="pt" name="password2" placeholder="Repeat Password">
                        <span id="passwordTwo"></span>
                    </div>
                </div>
            </div>
            <div class="but">
                <button class="btn btn-outline-danger btn-lg" type="button">Submit</button>
            </div>
        </form>
    </div>

    <div class="modal fade bd-example-modal-sm" id="m" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content" id="open"></div>
        </div>
    </div>
</body>
</html>
