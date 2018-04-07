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
    <jsp:include page="../../head/head.jsp"/>
    <%--<jsp:include page="${pageContext.request.contextPath}/head/head.jsp"/>--%>
</head>
<body>
    <h3>HELLO THIS IS LOGIN</h3>
    <br>
    <br>
    <br>
    <br>
    <br>
    <c:if test="${requestScope.warning != null}">
        <h2>${requestScope.warning}</h2>
    </c:if>
    <div class="form">
        <div class="one">
            <form method="POST" action="login">
                <div class="inside">
                    <label for="login" class="Login">Nick name*</label>
                    <input type="text" name="login" id="login" class="validate"/>
                    <c:out value = "${requestScope.error['nickName']}"/>

                </div>
                <div class="inside">
                    <label for="email" class="Email">E-Mail*</label>
                    <input type="email" name="email" id="email" class="validate"/>
                    <c:out value = "${requestScope.error['email']}"/>
                </div>
                <div class="inside">
                    <label for="FName" class="FName">First name*</label>
                    <input type="text" name="FName" id="fName" class="validate"/>
                    <c:out value = "${requestScope.error['name']}"/>
                </div>

                <div class="inside">
                    <label for="LName" class="LName">Last name*</label>
                    <input type="text" name="LName" id="LName" class="validate"/>
                    <c:out value = "${requestScope.error['name']}"/>
                </div>

                <div class="inside">
                    <label for="password" class="Password">Password*</label>
                    <input type="password" name="password" id="password" class="validate"/>
                    <c:out value = "${requestScope.error['password']}"/>
                </div>
                <div class="inside">
                    <label for="password2" class="Password2">Repeat password*</label>
                    <input type="password" name="password2" id="password2" class="validate"/>
                    <c:out value = "${requestScope.error['password']}"/>
                    <c:out value = "${requestScope.error['pas']}"/>
                </div>
                <p>
                    <button class="submit-button" type="submit">LogIn</button>
                </p>
            </form>
        </div>
    </div>
    </body>
</html>
