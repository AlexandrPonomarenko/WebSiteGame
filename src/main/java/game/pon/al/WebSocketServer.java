package game.pon.al;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.*;

@ServerEndpoint("/play")
public class WebSocketServer {
    static List<Client> listPlayers = Collections.synchronizedList(new ArrayList<Client>());
    private final String  infoWarning = "You can not send messages without a second player.";
    private final String  infoConnect = "To you it was connected ";
    private final String  warningStep = "Now is not your move.";
    private final String  vin = "Congratulations! You won !!!";
    private final String  lose = "You lost .... again?";
    private final String  draw = "This is a draw, I hope in the next game someone of you will smile good luck.";
    private final String  cellTaken = ", this cell is already taken.";
    private UtilGame utilGame = new UtilGame();
    private Client client;
    private String [] splitArray;

    @OnMessage
    public void onMessage(String message, Session session) throws IOException,
            InterruptedException {
        System.out.println("User input: " + message);

        if(session != null && session.isOpen()){
            control(parseToString(message), session);
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client connected");
    }

    @OnClose
    public void onClose(Session session, CloseReason cr) {
        System.out.println("PRICHINA " + cr.toString() + " -- " + cr.getReasonPhrase() + " == " + cr.getCloseCode());
        if(utilGame.cleaning(session.getId(), listPlayers)){
            client = utilGame.getCreatorUserBySessionId(session.getId(), listPlayers);
            SinglCollectGame.getInstance().removeGameByNickName(client.getName());
            removeUser(session.getId());
        }else{
            System.out.println("IN THE METHOD VIHODA PERED BLOKOM IF");
            if(utilGame.getUserBySessionId(session.getId(), listPlayers) != null) {
                System.out.println("IN THE BLOC");
                client = utilGame.getUserBySessionId(session.getId(), listPlayers);
                if(utilGame.getFindSessionId(session.getId(), client)){
                    System.out.println("TRUE");
                    sendUserOut(client, true);
                    System.out.println("TRUE ++++++++++++++++++++++++++++++++++++++++++++++++");
                    if(utilGame.checkGetOutLast(client)){
                        System.out.println("2 FIRST CLOSE");
                        removeUser(session.getId());
                    }
                }else{
                    System.out.println("FALSE");
                    sendUserOut(client, false);
                    System.out.println("FALSE -----------------------------------------------");
                    if(utilGame.checkGetOutLast(client)){
                        System.out.println("2 SECOND CLOSE");
                        removeUser(session.getId());
                    }
                }
            }
        }
        System.out.println("Connection closed" + session.getId());
    }

    private void removeUser(String sesId){
        synchronized (listPlayers) {
            for (Client client : listPlayers) {
                if (client.getSessionId().equals(sesId) || client.getOpponentSessionId().equals(sesId)) {
                    listPlayers.remove(client);
                    System.out.println("DELETE USER " + listPlayers.size());
                    return;
                }
            }
        }
    }

    private void sendUserOut(Client client, boolean flag){
        if(flag){
            try {
                if(client.getSessionOpponent().isOpen()) {
                    System.out.println(client.getSession().isOpen() + " 11111TRUE");
//                    client.getSessionOpponent().getBasicRemote().sendText("Your opponent " + client.getName() + "get out");
                    client.getSessionOpponent().getBasicRemote().sendText(toJson(client.getName(),"Your opponent get out"));
                    System.out.println(client.getName() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                    client.getSessionOpponent().close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            try {
                if(client.getSession().isOpen()) {
                    System.out.println(client.getSessionOpponent().isOpen() + " 0000000000FALSE");
//                    client.getSession().getBasicRemote().sendText("Your opponent " + client.getNameOpponent() + "get out");
                    client.getSession().getBasicRemote().sendText(toJson(client.getNameOpponent(),"Your opponent get out"));
                    System.out.println(client.getNameOpponent() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//                    client.getSession().close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendOnlyUserMessage(Client client){
        try {
            client.getSession().getBasicRemote().sendText(toJson("SERVER", infoWarning));
        } catch (IOException e) {
            System.out.println("BEDA V METODE sendOnlyUserMessage");
            e.printStackTrace();
        }
    }

    private void sendInfoMessage(Client client, String message){
        try {
            client.getSession().getBasicRemote().sendText(toJsonSend("SERVER", message + client.getNameOpponent(),"-","x"));
            client.getSessionOpponent().getBasicRemote().sendText(toJsonSend("SERVER", message.substring(2,message.length()) + client.getName(),"-","o"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendWarningMove(Session session){
        try {
            session.getBasicRemote().sendText(toJson("SERVER",warningStep));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String toJson(String name, String mes){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("type", "message");
        jsonObject.put("message", mes);
        System.out.println(" IN METHOD toJson " + jsonObject.toString());
        return jsonObject.toJSONString();
    }

    private String toJsonSend(String name, String mes, String value, String step){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("type", "message");
        jsonObject.put("message", mes);
        jsonObject.put("value", value);
        jsonObject.put("step", step);
        System.out.println(" IN METHOD toJsonSend " + jsonObject.toString());
        return jsonObject.toJSONString();
    }



    private JSONObject parseToString(String s){
        JSONObject object;
        try{
            return object = (JSONObject) JSONValue.parseWithException(s);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    private void control(JSONObject jsonObject, Session session) throws IOException{
        if(jsonObject != null){
            switch ((String)jsonObject.get("type")){
                case "message":
                    System.out.println("IN MESSAGE");
                    if(!utilGame.cleaning(session.getId(),listPlayers)){
                        client = utilGame.getUserBySessionId(session.getId(), listPlayers);
                        if(utilGame.checkRoleSteps(client,(String) jsonObject.get("name"))) {
                            controlMessage(controlStep(client, (String) jsonObject.get("message"), (String)jsonObject.get("value")), (String) jsonObject.get("name"), (String) jsonObject.get("message"), (String)jsonObject.get("value"));
//                            if (utilGame.checkUserName(client.getName(), (String) jsonObject.get("name"))) {
//                                client.getSessionOpponent().getBasicRemote().sendText(toJson(client.getName(), (String) jsonObject.get("message")));
//                            } else {
//                                client.getSession().getBasicRemote().sendText(toJson(client.getNameOpponent(), (String) jsonObject.get("message")));
//                            }
                        }else{
                            sendWarningMove(session);
                            return;
                        }
                    }else{
                        sendOnlyUserMessage(utilGame.getCreatorUserBySessionId(session.getId(),listPlayers));
                    }
                    break;
                case "create":
                    System.out.println(" BEFORE ADD IN COLLECTION IN CREATE " + listPlayers.size());
                    System.out.println(jsonObject.get("name"));
                    utilGame.createGame((String)jsonObject.get("name"), session);
                    System.out.println(" AFTER ADD IN COLLECTION IN CREATE " + listPlayers.size());
                    break;
                case "add":
                    System.out.println("IN ADD");
                    System.out.println(listPlayers.size() + " AAAAAAAAAAAAAAAAAAAAAAAAAA");
                    System.out.println("ADD NAME " + jsonObject.get("add") + " --- MY NAME " + jsonObject.get("name"));
                    client = utilGame.addPlayer((String) jsonObject.get("add"), (String)jsonObject.get("name"), listPlayers, session);
                    sendInfoMessage(client, infoConnect);
                    break;
                case "out":
                    System.out.println("OUT");
                    break;
                case "error":
                    System.out.println("ERROR");
                    break;
            }
        }
    }
//1 аргумент примает контрольное слово, 2- Имя которое пришло от клиента, 3 - сообщение от клиента(ключ), 4 -от клиента значение ключа(х или о)
    private void controlMessage(String controlWord, String nameJsonObject, String jsonObjectMessage, String value){
        if(controlWord.equals("step")){
            sendStep(nameJsonObject, jsonObjectMessage, value);
        }else if(controlWord.equals("noStep")){
            sendNotificationMes(controlWord, nameJsonObject, jsonObjectMessage, value);
        }else if(controlWord.equals("between")){
            sendNotificationMes(controlWord, nameJsonObject, jsonObjectMessage, value);
        }else if(controlWord.equals("vin")){
            sendNotificationMes(controlWord, nameJsonObject, jsonObjectMessage, value);
        }
    }
    private String controlStep(Client client, String key, String value){
        if(!utilGame.checkAllMapGameIsEmpty(client)){
            if(utilGame.checkValueForKeyMapGame(client, key)){
                utilGame.setValueMapGame(client, key, value);
                if(!utilGame.checkAllMapGameIsEmpty(client)) {
                    if (!utilGame.checkAllStepLine(client, key, value)) {
                        return "step";
                    } else {
                        return "vin";
                    }
                }else{return "between";}
            }else{
                utilGame.incrementStep(client);
                return "noStep";
            }
        }else {
            return "between";
        }
    }

    private void sendStep(String nameJsonObject, String message, String value){
        if (utilGame.checkUserName(client.getName(), nameJsonObject)) {
            try {
                client.getSessionOpponent().getBasicRemote().sendText(toJsonSend("Answer Server: " + client.getName(),message,value,"-"));
                client.getSession().getBasicRemote().sendText(toJsonSend("SERVER", "step", "-","-"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                client.getSession().getBasicRemote().sendText(toJsonSend("Answer Server: " + client.getNameOpponent(),message,value,"-"));
                client.getSessionOpponent().getBasicRemote().sendText(toJsonSend("SERVER", "step", "-","-"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendNotificationMes(String control, String nameClient, String key, String value){
        try {
            if (control.equals("noStep")) {
                if (utilGame.checkUserName(client.getName(), nameClient)) {
                    client.getSession().getBasicRemote().sendText(toJsonSend("SERVER: " + client.getName(), cellTaken, "-", "-"));
                } else {
                    client.getSessionOpponent().getBasicRemote().sendText(toJsonSend("SERVER: " + client.getNameOpponent(), cellTaken, "-", "-"));
                }
            } else if (control.equals("between")) {
                client.getSession().getBasicRemote().sendText(toJsonSend("SERVER: ", draw, "between", "-"));
                client.getSessionOpponent().getBasicRemote().sendText(toJsonSend("SERVER: ", draw, "between", "-"));
                utilGame.setVinOrLost(client.getName(), 1,0);
                utilGame.setVinOrLost(client.getNameOpponent(), 1,0);
            } else if (control.equals("vin")) {
                if (utilGame.checkUserName(client.getName(), nameClient)) {
                    client.getSession().getBasicRemote().sendText(toJsonSend("SERVER: " + client.getName(), vin, "vin", "-"));
                    client.getSessionOpponent().getBasicRemote().sendText(toJsonSend("SERVER: " + client.getNameOpponent(), key, value, "-"));
                    client.getSessionOpponent().getBasicRemote().sendText(toJsonSend("SERVER: " + client.getNameOpponent(), lose, "lose", "-"));
                    utilGame.setVinOrLost(client.getName(), 1,0);
                    utilGame.setVinOrLost(client.getNameOpponent(), 0,1);
                } else {
                    client.getSession().getBasicRemote().sendText(toJsonSend("SERVER: " + client.getName(), key, value, "-"));
                    client.getSession().getBasicRemote().sendText(toJsonSend("SERVER: " + client.getName(), lose, "lose", "-"));
                    client.getSessionOpponent().getBasicRemote().sendText(toJsonSend("SERVER: " + client.getNameOpponent(), vin, "vin", "-"));
                    utilGame.setVinOrLost(client.getName(), 0,1);
                    utilGame.setVinOrLost(client.getNameOpponent(), 1,0);
                }
            }
        }catch (IOException e){
            e.getStackTrace();
        }
    }
}
