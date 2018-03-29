<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h2>Hello World MAN!</h2>
    <% response.sendRedirect(request.getContextPath() + "/main"); %>
</body>
</html>
