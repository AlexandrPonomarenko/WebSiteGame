
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>Author</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/author.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/libJquery/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

    <div class="content-wrapper">
        <div class="content">
            <jsp:include page="../head/head.jsp"/>

            <h2 id="author">Author of the project Ponomarenko Alexandr</h2>
            <div class="textHad">
                <h3 id="vacancy">The project was created with the purpose of interest to Java web development and job search for a vacancy Java Junior Developer.</h3>
            </div>
            <div>
                <h3 id="list">List technologies:</h3>

                <ul class="styleNone">
                    <li><p class="m">Java SE: Core</p></li>
                    <li><p class="m">Java EE: Servlet, JSTL, JSP, WebSocket, JavaMail, JPA</p></li>
                    <li><p class="m">Data Base: JDBC Postgres</p></li>
                    <li><p class="m">JPA: Hibernate</p></li>
                    <li><p class="m">Web Server: Wild Fly</p></li>
                    <li><p class="m">Also: JSON</p></li>
                    <li><p class="m">Gradle: Maven</p></li>
                    <li><p class="m">JavaScript: core, JQuery(Ajax)</p></li>
                    <li><p class="m">HTML, CSS, little bit Bootstrap:)</p></li>
                    <li><a class="a" href="https://github.com/AlexandrPonomarenko/WebSiteGame">Link to project</a></li>
                    <li><a class="a" href="https://github.com/AlexandrPonomarenko?tab=repositories">Link to developer in GITHub</a></li>
                </ul>
            </div>

        </div>
        <footer class="page-footer font-small indigo pt-0">
            <jsp:include page="../footer/footer.jsp"/>
        </footer>
    </div>

</body>
</html>
