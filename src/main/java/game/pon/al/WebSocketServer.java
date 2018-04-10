package game.pon.al;

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
        splitArray  = utilGame.getSplitMessage(message);
        if(splitArray[splitArray.length - 2].equals("create")){
            String[] s = message.split(":");
            System.out.println(s[0] + " ++++ " + s[1] +" --" + s[2]);
            client = new Client(s[0], session);
            listPlayers.add(client);
            System.out.println(client.getName() + " ++++ " + client.getSession().getId());
        }else if(splitArray[splitArray.length - 2].equals("message")){
            client = utilGame.getUserBySessionId(session.getId(), listPlayers);
            if(utilGame.checkUserName(client.getName(), splitArray[0])){
                client.getSessionOpponent().getBasicRemote().sendText("NAKONETSTO it is from " + client.getName()+ " "+ message);
            }else{
                client.getSession().getBasicRemote().sendText("NAKONETSTO it is from " + client.getNameOpponent() + " "+ message);
            }
        }else if(!splitArray[splitArray.length - 2].equals("create") &&
                !splitArray[splitArray.length - 2].equals("message")){
                System.out.println(listPlayers.size() + " AAAAAAAAAAAAAAAAAAAAAAAAAA");
                String[] s = message.split(":");
                System.out.println(s[0] + " add " + s[1] + s[2]);
                client = utilGame.getAddPlayers(s[1], listPlayers);
                client.setNameOpponent(s[0]);
                client.setSessionOpponent(session);

                System.out.println(client.getName() + " ffffff " + client.getSession().getId() + " ff " +
                client.getNameOpponent() + " fff " + client.getSessionOpponent().getId());
        }
        session.getBasicRemote().sendText("Hello world Mr. " + message);
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client connected");
    }

    @OnClose
    public void onClose(Session session) {
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
                    client.getSessionOpponent().getBasicRemote().sendText("Your opponent " + client.getName() + "get out");
                    client.getSessionOpponent().close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            try {
                if(client.getSessionOpponent().isOpen()) {
                    client.getSession().getBasicRemote().sendText("Your opponent " + client.getNameOpponent() + "get out");
                    client.getSession().close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
