<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 30.03.18
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>Help</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/help.css">
    <jsp:include page="../../head/head.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ajaxHelp.js"></script>
</head>
<body>

    <h1 class="head">Do you have questions or do you need help? Just write to us.</h1>

    <div class="help">
        <form class="form">
            <div class="col">
                <div class="row">
                    <div class="col">
                        <input type="text" class="form-control" id="nam" name="name" value="${requestScope.name}" placeholder="Nickname">
                        <span id="nickName"></span>
                    </div>
                    <div class="col">
                        <input type="email" class="form-control" id="ema" name="email" value="${requestScope.email}" placeholder="Email">
                        <span id="email"></span>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <textarea class="form-control" name="texthelp" rows="5" cols="140" id="comment"></textarea>
                        <span id="txms"></span>
                    </div>
                </div>
            </div>
            <div class="but">
                <button class="btn btn-outline-danger btn-lg" type="button">Send</button>
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
