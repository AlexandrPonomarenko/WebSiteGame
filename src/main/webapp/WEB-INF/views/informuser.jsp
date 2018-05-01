
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>INFO</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/info.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/libJquery/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

<div class="content-wrapper">
    <div class="content">
        <jsp:include page="../../head/head.jsp"/>

        <div class="form">
            <form method="post" action="info">
                <div class="inside">
                    <label for="name">Your name:</label>
                    <input type="text" name="name" id="name" value="${requestScope.name}" class="validate">
                </div>
                <div class="inside">
                    <textarea name="texthelp" id="textarea" cols="140" rows="10" class="validate"></textarea>
                </div>
                <input class="submit-button" type="submit" value="Send">
            </form>
        </div>

    </div>
    <footer class="page-footer font-small indigo pt-0">
        <jsp:include page="../../footer/footer.jsp"/>
    </footer>
</div>

</body>
</html>
