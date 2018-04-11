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
    private UtilGame utilGame = new UtilGame();
    private Client client;
    private String [] splitArray;

    @OnMessage
    public void onMessage(String message, Session session) throws IOException,
            InterruptedException {
        System.out.println("User input: " + message);

        if(session != null && session.isOpen()){
            control(parseToString(message), session);
//            session.getBasicRemote().sendText("Hello world Mr. " + message);
        }
//        splitArray  = utilGame.getSplitMessage(message);
//        if(splitArray[splitArray.length - 2].equals("create")){
//            String[] s = message.split(":");
//            System.out.println(s[0] + " ++++ " + s[1] +" --" + s[2]);
//            client = new Client(s[0], session);
//            listPlayers.add(client);
//            System.out.println(client.getName() + " ++++ " + client.getSession().getId());
//        }else if(splitArray[splitArray.length - 2].equals("message")){
//            client = utilGame.getUserBySessionId(session.getId(), listPlayers);
//            if(utilGame.checkUserName(client.getName(), splitArray[0])){
//                client.getSessionOpponent().getBasicRemote().sendText("NAKONETSTO it is from " + client.getName()+ " "+ message);
//            }else{
//                client.getSession().getBasicRemote().sendText("NAKONETSTO it is from " + client.getNameOpponent() + " "+ message);
//            }
//        }else if(!splitArray[splitArray.length - 2].equals("create") &&
//                !splitArray[splitArray.length - 2].equals("message")){
//                System.out.println(listPlayers.size() + " AAAAAAAAAAAAAAAAAAAAAAAAAA");
//                String[] s = message.split(":");
//                System.out.println(s[0] + " add " + s[1] + s[2]);
//                client = utilGame.getAddPlayers(s[1], listPlayers);
//                client.setNameOpponent(s[0]);
//                client.setSessionOpponent(session);
//
//                System.out.println(client.getName() + " ffffff " + client.getSession().getId() + " ff " +
//                client.getNameOpponent() + " fff " + client.getSessionOpponent().getId());
//        }
//        session.getBasicRemote().sendText("Hello world Mr. " + message);
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
            if(utilGame.getUserBySessionId(session.getId(), listPlayers) != null) {
                client = utilGame.getUserBySessionId(session.getId(), listPlayers);
                if(utilGame.getFindSessionId(session.getId(), client)){
                    sendUserOut(client, true);
                }else{
                    sendUserOut(client, false);
                }
            }
        }
        System.out.println("Connection closed" + session.getId());
    }

    private void removeUser(String sesId){
        synchronized (listPlayers) {
            for (Client client : listPlayers) {
                if (client.getSessionId().equals(sesId)) {
                    listPlayers.remove(client);
                    System.out.println("DELETE USER");
                    return;
                }
            }
        }
    }

    private void sendUserOut(Client client, boolean flag){
        if(flag){
            try {
                if(client.getSessionOpponent().isOpen()) {
//                    client.getSessionOpponent().getBasicRemote().sendText("Your opponent " + client.getName() + "get out");
                    client.getSessionOpponent().getBasicRemote().sendText(toJson(client.getName(),"Your opponent get out"));
                    System.out.println(client.getName() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    client.getSessionOpponent().close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            try {
                if(client.getSessionOpponent().isOpen()) {
//                    client.getSession().getBasicRemote().sendText("Your opponent " + client.getNameOpponent() + "get out");
                    client.getSession().getBasicRemote().sendText(toJson(client.getNameOpponent(),"Your opponent get out"));
                    System.out.println(client.getNameOpponent() + "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    client.getSession().close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void sendOnlyUserMessage(Client client){
        try {
            client.getSession().getBasicRemote().sendText(toJson("SERVER", "You can not send messages without a second player."));
        } catch (IOException e) {
            System.out.println("BEDA V METODE sendOnlyUserMessage");
            e.printStackTrace();
        }
    }

    private String toJson(String name, String m){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("type", "message");
        jsonObject.put("message", m);
        System.out.println(" IN METHOD toJson " + jsonObject.toString());
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
//                    if(!utilGame.checkOnlyUser(client)) {
                        if (utilGame.checkUserName(client.getName(), (String) jsonObject.get("name"))) {
                            client.getSessionOpponent().getBasicRemote().sendText(toJson(client.getName(), (String) jsonObject.get("message")));
                        } else {
                            client.getSession().getBasicRemote().sendText(toJson(client.getNameOpponent(), (String) jsonObject.get("message")));
                        }
                    }else{
                        sendOnlyUserMessage(utilGame.getCreatorUserBySessionId(session.getId(),listPlayers));
                    }
                    break;
                case "create":
                    System.out.println("IN CREATE");
                    System.out.println(jsonObject.get("name"));
                    utilGame.createGame((String)jsonObject.get("name"), session);
                    break;
                case "add":
                    System.out.println("IN ADD");
                    System.out.println(listPlayers.size() + " AAAAAAAAAAAAAAAAAAAAAAAAAA");
                    System.out.println("ADD NAME " + jsonObject.get("add") + " --- MY NAME " + jsonObject.get("name"));
                    utilGame.addPlayer((String) jsonObject.get("add"), (String)jsonObject.get("name"), listPlayers, session);
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
}
