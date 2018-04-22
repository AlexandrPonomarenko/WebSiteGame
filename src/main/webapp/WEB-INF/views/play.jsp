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
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/game.css">
    <jsp:include page="../../head/head.jsp"/>
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/libJquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/game.js"></script>
</head>
<body>
    <%--<jsp:include page="../../head/head.jsp"/>--%>
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
        <input type="text" id="userinput" value="" /> <br>
        <input type="submit" value="Send Message to Server" onclick="start()" />
    </div>
    <div id="messages"></div>
    <div id="game"></div>
    <script type="text/javascript">
        $(document).ready(function () {
            var webSocket = new WebSocket(
                'ws://localhost:8080/WebSiteGame/play');

            var name = $("#userName").val();
            var flag = document.getElementById("flag").value;
            var typeStep = "";
            var timer = 0;
            var id = null;
            setStartDisable();
            // setTimer();

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
                    setValueStep(data.step);

                    Game.setButtonValue(data.message, data.value);
                    setStepOpponent(data.step, data.value, data.message);
                    console.log("---- " + data.step, data.value, data.message);
                    // controlStep(data.message);
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
                Game.setDisableAll();
                setTimer(Game.getMark());
            }

            function onError(event) {
                alert(event.data);
            }

            window.start = function () {
                // var text = document.getElementById("userinput").value;
                // var text = document.getElementById("userName").value + ":" +"message:"+ document.getElementById("userinput").value;
                // var text = buildJsonObjectMessage(document.getElementById("userName").value, "message", document.getElementById("userinput").value);
                var text = createData("message", document.getElementById("userinput").value);
                webSocket.send(text);
                return false;
            }

            window.starton = function (message) {
                var text = createData("message", message);
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

            function createData (type, message) {
                if (!type) { type = null; }
                if (!message) { message = null; }
                if (!typeStep) { message = null; }

                return JSON.stringify({
                    "name": name,
                    "type": type,
                    "message": message,
                    "value":typeStep,
                    "add": flag
                });
            }

            function setValueStep(type) {
                if (type != null && type !== "-") {
                    typeStep = type;
                    console.log(typeStep);
                    Game.setMark(typeStep);
                }
            }


            $(Game).on('button-event', function (e, data) {
                console.log(data.attr);
                starton(data.attr)
            });

            Game.appendToContainer('#game');

            function setStepOpponent(step, value, message){
                console.log("Tttt " , step, value, message, step === "x" || step === "o" || message !=="step" && value !== "-");
                // if(step === "x" || step === "o" || message !=="step" && value !== "-"){
                //     console.log("TYYYTT " + step, value, message);
                //     Game.setEnableAll();
                // }else if(value === "vin" || value === "lose"){
                //     Game.setDisableAll();
                // }

                // if(value === "vin" || value === "lose" || value === "between"){
                //     console.log("qqqq " + step, value, message);
                //     Game.setDisableAll();
                // }else if(step === "x"|| message !=="step" && value !== "-"){
                //     console.log("Step: -" + step + " Value: -" + value + " Message -" +  message);
                //     Game.setEnableAll();
                // }else if(message.substr(0,4) === "Your"){
                //     console.log("JUST " + " Message -" +  message);
                //     Game.setDisableAll();
                // }

                if(value === "vin" || value === "lose" || value === "between"){
                    console.log("qqqq " + step, value, message);
                    Game.setDisableAll();
                }else if(message.substr(0,4) === "Your"){
                    console.log("JUST " + " Message -" +  message);
                    Game.setDisableAll();
                }else if(step === "x"|| message !=="step" && value !== "-"){
                    console.log("Step: -" + step + " Value: -" + value + " Message -" +  message);
                    Game.setEnableAll();
                }
            }

            function setStartDisable() {
                var mark = Game.getMark();
                console.log(mark);
                if(mark !== "x" || mark !== "o"){
                    console.log("DISAAAAAAAAAAAAAABBBBBBLLLLLLLEEEEEEEEEEEEE");
                    Game.setDisableAll();
                }
            }

            function setTimer(mark) {
                if (mark === "&") {
                    console.log("-----TIMER " + timer + "- " + mark);
                    timer++;
                    id = setTimeout(function () {
                        id = null;
                        setTimer(Game.mark);
                    }, 1000);
                }
            }

        });
    </script>
</body>
</html>
