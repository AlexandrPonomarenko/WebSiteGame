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

        var name = document.getElementById("userName").value;
        var flag = document.getElementById("flag").value;

        webSocket.onerror = function(event) {
            console.log(event.data);
            onError(event)
        };

        webSocket.onopen = function(event) {
            onOpen(event);
            startSendMes()
            // startSendName();

        };

        webSocket.onmessage = function(event) {
            onMessage(event)
        };

        function onMessage(event) {
            var container,
                nameNode,
                messageNode,
                data = event.data;

            try {
                data = JSON.parse(data);
            } catch (e) {
                data = {"name": name, "message": "Dad data" };
            }

            console.log(data);

            container = document.createElement('div');
            nameNode = document.createElement('span');
            messageNode = document.createElement('span');

            nameNode.innerHTML = data.name + ": ";
            messageNode.innerHTML = data.message;

            container.appendChild(nameNode);
            container.appendChild(messageNode);

            document.getElementById('messages').appendChild(container);

            // console.log(event.data);
            // document.getElementById('messages').innerHTML += '<br />'
            //     + event.data;
        }

        function onOpen(event) {
            document.getElementById('messages').innerHTML = 'Now Connection established';
        }

        function onError(event) {
            alert(event.data);
        }

        function start() {
            // var text = document.getElementById("userinput").value;
            // var text = document.getElementById("userName").value + ":" +"message:"+ document.getElementById("userinput").value;
            // var text = buildJsonObjectMessage(document.getElementById("userName").value, "message", document.getElementById("userinput").value);
            var text = createData("message", document.getElementById("userinput").value);
            webSocket.send(text);
            return false;
        }

        function startSendName() {
            var text = document.getElementById("userName").value;
            text += ":" + document.getElementById("flag").value;
            text += ": dru";
            webSocket.send(text);
            return false;
        }

        function startSendMes() {
            var text;
            if(document.getElementById("flag").value === "create"){
                // text = buildJsonObjectCreate(document.getElementById("userName").value, "create");
                text = createData("create");
            }else{
                // text = buildJsonObjectAdd(document.getElementById("userName").value, "add", document.getElementById("flag").value, "-");
                text = createData("add", "-");
            }
            // var text = buildJsonObjectAdd(document.getElementById("userName").value, "add", document.getElementById("flag").value, "-");
            webSocket.send(text);
        }

        // function buildJsonObjectAdd(name, type, flag, message) {
        //     var obj = {"name":name,
        //                 "type":type,
        //                 "add":flag,
        //                 "message": message};
        //     return JSON.stringify(obj);
        // }
        //
        // function buildJsonObjectCreate(name, type) {
        //     var obj = {"name":name,
        //                 "type":type
        //                 };
        //     return JSON.stringify(obj);
        // }
        //
        // function buildJsonObjectMessage(name, type, message) {
        //     var obj = {"name":name,
        //                 "type":type,
        //                 "message":message
        //     };
        //     return JSON.stringify(obj);
        // }

        function createData (type, message) {
            if (!type) { type = null; }
            if (!message) { message = null; }

            return JSON.stringify({
                "name": name,
                "type": type,
                "message": message,
                "add": flag
            });
        }
    </script>
</body>
</html>
