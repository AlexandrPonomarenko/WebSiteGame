
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta content="text/html" charset="UTF-8">
    <title>Play</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/game.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/play.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/libJquery/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/game.js"></script>
</head>
<body>

<div class="content-wrapper">
    <div class="content">
        <jsp:include page="../../head/head.jsp"/>
     <div>
        <input type="hidden" id="userName" value="${sessionScope.nickname}" />
        <input type="hidden" id="flag" value="${requestScope.flag}" />
    </div>
    <div class="timer">
        <span id="numbers"></span>
    </div>
    <%--<div>--%>
        <%--<input type="text" id="userinput" value="" /> <br>--%>
        <%--<input type="submit" value="Send Message to Server" onclick="start()" />--%>
    <%--</div>--%>
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
            }

            function onOpen(event) {
                // document.getElementById('messages').innerHTML = 'Now Connection established';
                Game.setDisableAll();
                setTimer(Game.getMark());
            }

            function onError(event) {
                alert(event.data);
            }

            window.start = function () {
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
                    text = createData("create");
                }else{
                    text = createData("add", "-");
                }
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
                    $('#numbers').html(timer);
                    timer++;
                    id = setTimeout(function () {
                        id = null;
                        setTimer(Game.mark);
                    }, 1000);
                }
            }

        });
    </script>

    <div id="messages"></div>
    </div>
        <footer class="page-footer font-small indigo pt-0">
            <jsp:include page="../../footer/footer.jsp"/>
        </footer>
    </div>
</body>
</html>
