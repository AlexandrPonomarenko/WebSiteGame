package game.pon.al;

import javax.websocket.Session;
import java.io.IOException;
import java.util.List;

public class UtilGame {
    private String [] tempArray = new String[3];



    public  String splitCommandWords(String comWor){
        tempArray = comWor.split(":");
        System.out.println("+++++++++++++++++++++++++++++ " + tempArray.length);
//        System.out.println(tempArray[0] + " -- " + tempArray[1] + " - " + tempArray[2]);
        System.out.println(tempArray[0] + " -- " + tempArray[1]);
        if(tempArray[tempArray.length - 1].equals("create")){
            return "create";
        }else if(tempArray[tempArray.length - 1].equals("message")){
            return "message";
        }
        return tempArray[tempArray.length - 1];
    }


    public Client getAddPlayers(String name, List<Client> list){
        synchronized (list) {
            System.out.println(list.size() + " weqweqweqweqwe");
            for (Client client : list) {
                System.out.println(client.getName() + " cccccccc " + name);
                if (client.getName().equals(name)) {
                    System.out.println("ZASHJOL " + client.getName());
                    return client;
                }
            }
            return null;
        }
    }

    public String[] getSplitMessage(String msg){
        return msg.split(":");
    }

    public Client getUserBySessionId(String id, List<Client> list){
        System.out.println(list.size() + " weqweqweqweqwe");
        for (Client client : list) {
            System.out.println(client.getSessionId() + " cccccccc " + client.getOpponentSessionId());
            if (client.getSessionId().equals(id) || client.getOpponentSessionId().equals(id)) {
                System.out.println(client.getSessionId() + " TYTY " + client.getOpponentSessionId());
                return client;
            }
        }
        return null;
    }

    public boolean checkUserName(String name, String nameTwo){
        if (name.equals(nameTwo)){
            return true;
        }
        return false;
    }

    public boolean cleaning(String id, List<Client> list){
        if(getCreatorUserBySessionId(id, list) != null){
            Client client = getCreatorUserBySessionId(id, list);
            if(checkUserByNull(client)){
                return true;
            }
        }
        return false;
    }

    public Client getCreatorUserBySessionId(String id, List<Client> list){
        for (Client client : list) {
            System.out.println(client.getSessionId() + " CREATOR");
            if (client.getSessionId().equals(id)) {
                System.out.println(client.getSessionId() + " FIND CREATOR");
                return client;
            }
        }
        return null;
    }

    private boolean checkUserByNull(Client client){
        if(client.getNameOpponent() == null){
            System.out.println("NAMEOPPONENT = NULL");
            return true;
        }
        return false;
    }

    public boolean checkOnlyUser(Client client){
        if(checkUserByNull(client)){
            return true;
        }
        return false;
    }

    public boolean getFindSessionId(String id, Client client){
        if(client.getSessionId().equals(id)){
            return true;
        }
        return false;
    }

    public void createGame(String name, Session session){
        Client client = new Client(name, session);
        WebSocketServer.listPlayers.add(client);
    }

    public void addPlayer(String nameCreatorPlayer, String nameAddPlayer, List<Client> list, Session session){
        Client client;
        client = getAddPlayers(nameCreatorPlayer, list);
        client.setNameOpponent(nameAddPlayer);
        client.setSessionOpponent(session);
    }

    public void fromSomebodyUser(String sessionId, List<Client> list, String player, String message){
        Client client;
        boolean flag;
        client = getUserBySessionId(sessionId, list);
        if(checkUserName(client.getName(), player)){
//
//            try {
//                client.getSessionOpponent().getBasicRemote().sendText("NAKONETSTO it is from " + client.getName()+ " "+ message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }else{
//            try {
//                client.getSession().getBasicRemote().sendText("NAKONETSTO it is from " + client.getNameOpponent() + " "+ message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

    }

}
