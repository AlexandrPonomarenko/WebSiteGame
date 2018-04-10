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
    <title>Play</title>
    <jsp:include page="../../head/head.jsp"/>
</head>
<body>
    <br>
    <br>
    <br>
    <br>
    <h1>PLAYYYYYYYYYYYYY</h1>
    <div>
        <input type="hidden" id="userName" value="${sessionScope.nickname}" />
        <input type="hidden" id="flag" value="${requestScope.flag}" />
    </div>
    <div>
        <input type="text" id="userinput" value="" /> <br> <input type="submit"
                                                         value="Send Message to Server" onclick="start()" />
    </div>
    <div id="messages"></div>

    <script type="text/javascript">
        var webSocket = new WebSocket(
            'ws://localhost:8080/WebSiteGame/play');

        webSocket.onerror = function(event) {
            onError(event)
        };

        webSocket.onopen = function(event) {
            onOpen(event)
            startSendName();

        };

        webSocket.onmessage = function(event) {
            onMessage(event)
        };

        function onMessage(event) {
            console.log(event.data);
            document.getElementById('messages').innerHTML += '<br />'
                + event.data;
        }

        function onOpen(event) {
            document.getElementById('messages').innerHTML = 'Now Connection established';
        }

        function onError(event) {
            alert(event.data);
        }

        function start() {
            // var text = document.getElementById("userinput").value;
            var text = document.getElementById("userName").value + ":" +"message:"+ document.getElementById("userinput").value;
            webSocket.send(text);
            return false;
        }

        function startSendName() {
            var text = document.getElementById("userName").value;
            text += ":" + document.getElementById("flag").value;
            text += ": dru"
            webSocket.send(text);
            return false;
        }
    </script>
</body>
</html>
