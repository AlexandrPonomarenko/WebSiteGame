<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 29.03.18
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>Logon</title>
    <jsp:include page="../../head/head.jsp"/>
    <%--<jsp:include page="${pageContext.request.contextPath}/head/head.jsp"/>--%>
</head>
<body>

<br>
<br>
<br>
<br>
    <c:if test="${requestScope.warning != null}">
        <h2>${warning}</h2>
    </c:if>
<div class="parent">
    <div class="child1">
        <span id="one">Choose your dream</span>
        <span id="two">Just do it</span>
    </div>
    <div class="child2">
        <form method="POST" action="logon">
            <div class="one">
                <label for="login">Nick name</label>
                <input type="text" name="login" id="login" class="validate" value="Alexxxx"/>
                <%--<span class="empty-message">Empty</span>--%>
                <%--<span class="small-length-message">Small length</span>--%>
                <%--<span class="bad-words-message">Bad words</span>--%>
                <c:out value = "${requestScope.error['nickName']}"/>
            </div>
            <div class="one">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" class="validate" value="23ATDHFkz$"/>
                <%--<span class="empty-message">Empty</span>--%>
                <%--<span class="small-length-message">Small length</span>--%>
                <%--<span class="bad-words-message">Bad words</span>--%>
                <c:out value = "${requestScope.error['password']}"/>
            </div>
            <div class="but">
                <button class="submit-button" type="submit"> GO home</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
