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
    <jsp:include page="../../head/head.jsp"/>
</head>
<body>
    <br>
    <br>
    <br>
    <br>
    <h1>HELP</h1>

    <div class="form">
        <form method="post" action="help">
            <div class="inside">
                <label for="name">Your name:</label>
                <input type="text" name="name" id="name" value="${requestScope.name}" class="validate">
                <%--<c:out value="${requestScope.errorHelp['name']}"></c:out>--%>
                <%--<span class="empty-message">Empty</span>--%>
                <%--<span class="small-length-message">Small length</span>--%>
                <%--<span class="bad-words-message">Bad words</span>--%>
            </div>
            <div class="inside">
                <label for="email">Your Email address:</label>
                <input type="email" name="email" id="email" value="" class="validate">
                <%--<c:out value="${requestScope.errorHelp['email']}"></c:out>--%>
                <%--<span class="empty-message">Empty</span>--%>
                <%--<span class="small-length-message">Small length</span>--%>
                <%--<span class="bad-words-message">Bad words</span>--%>
            </div>
            <div class="inside">
                <textarea name="texthelp" id="textarea" cols="140" rows="10" class="validate"></textarea>
                <%--<c:out value="${requestScope.errorHelp['texthelp']}"></c:out>--%>
                <%--<span class="empty-message">Empty</span>--%>
                <%--<span class="small-length-message">Small length</span>--%>
                <%--<span class="bad-words-message">Bad words</span>--%>
            </div>
            <input class="submit-button" type="submit" value="Send">
            <%--<c:out value="${requestScope.ok}"></c:out>--%>
        </form>
    </div>

</body>
</html>
