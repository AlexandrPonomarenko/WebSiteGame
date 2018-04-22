package game.pon.al;

import dao.pon.al.statgame.DAOGameStat;
import dao.pon.al.user.DaoUser;
import hibernate.pon.al.entity.GameStatE;
import hibernate.pon.al.entity.UserE;

import javax.websocket.Session;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class UtilGame {
//    private String [] tempArray = new String[3];
    private DAOGameStat daoGameStat;
    private DaoUser daoUser;
    private GameStatE gameStatE;

    public UtilGame(){
        daoGameStat = new DAOGameStat();
        daoUser = new DaoUser();
    }

    public void setVinOrLost(String name, int vin, int lost){
        UserE user = daoUser.findUserByNickName(name);
        if(user != null) {
            gameStatE = new GameStatE();
            gameStatE.setVin(vin);
            gameStatE.setLost(lost);
            gameStatE.setUserE(user);
            user.getStatgame().add(gameStatE);
            daoUser.update(user);
        }
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
            System.out.println("VERNULL NULL IN THE METHOD getAddPlayers");
            return null;
        }
    }

    public Client getUserBySessionId(String id, List<Client> list){
        System.out.println(list.size() + " IN METHOD getUserBySessionId SIZE COLLECTION");
        for (Client client : list) {
            System.out.println(client.getName() + " == " +client.getSessionId() + " ----- " + client.getNameOpponent() + client.getOpponentSessionId());
            if (client.getSessionId().equals(id) || client.getOpponentSessionId().equals(id)) {
                System.out.println(client.getSessionId() + " FAUND SES ID " + client.getOpponentSessionId());
                return client;
            }
        }
        System.out.println(list.size() + " IN METHOD getUserBySessionId VOZVRAT NULL");
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

    public Client addPlayer(String nameCreatorPlayer, String nameAddPlayer, List<Client> list, Session session){
        Client client;
        client = getAddPlayers(nameCreatorPlayer, list);
        client.setNameOpponent(nameAddPlayer);
        client.setSessionOpponent(session);
        return client;
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

    public boolean checkGetOutLast(Client client){
        if(!client.getSession().isOpen() &&  !client.getSessionOpponent().isOpen()){
            System.out.println("SESSION CREATOR " + client.getName() + " -- " + client.getSession().isOpen() +
            "SESSION OPPONENT " + client.getNameOpponent() + " -- " + client.getSessionOpponent().isOpen());
            return true;
        }
        return false;
    }

    public boolean checkRoleSteps(Client client, String name){
        System.out.println("BEFORE STATE STEPS " + client.getSteps());
        if((client.getSteps() + 1) % 2 != 0 && client.getName().equals(name)){
            client.setSteps(client.getSteps() + 1);
            System.out.println("CREATER STATE STEPS " + client.getSteps());
            return true;
        }else if((client.getSteps() + 1) % 2 == 0 && client.getNameOpponent().equals(name)){
            client.setSteps(client.getSteps() + 1);
            System.out.println("ADD STATE STEPS " + client.getSteps());
            return true;
        }
        System.out.println("AFTER NO COME IN, STATE STEPS " + client.getSteps());
        return false;
    }

//    public boolean checkCountStep(Client client){
//        if(client.getSteps() + 1 <= 9){
//            return true;
//        }
//        return false;
//    }

    public void incrementStep(Client client){
        System.out.println("METHOD  incrementStep SET STEPS BEFORE" + client.getSteps());
        client.setSteps(client.getSteps() - 1);
    }

    public boolean ckeckValueMapGame(Client client, String key, String value){
//        if(client.getMapGame().get(key) != null){
            if(client.getMapGame().get(key).isEmpty()){
                client.getMapGame().put(key, client.getMapGame().get(key) + value);
                return true;
            }
//        }
        return false;
    }

    public void setValueMapGame(Client client, String key , String value){
        client.getMapGame().put(key, client.getMapGame().get(key) + value);
        System.out.println("SET VALUE " + key + " == " + value);
    }

    public boolean checkValueForKeyMapGame(Client client, String key){
        if(client.getMapGame().get(key) != null){
            if(client.getMapGame().get(key).isEmpty()){
                System.out.println("COME IN METHOD checkValueForKeyMapGame STRING PUSTA");
                return true;
            }
        }
        return false;
    }

    //Если возвращаяет ФЭЛСЕ то есть ходы если ТРУ то ходы кончились
    public boolean checkAllMapGameIsEmpty(Client client){
        for (String s : client.getMapGame().values()){
            if(s.isEmpty()){
                //зайдет потому что строка пустая, а это значит что еще есть ходы
                System.out.println("COME IN METHOD checkAllMapGameIsEmpty RETURN FALSE");
                return false;
            }
        }
        return true;
    }

    public boolean checkAllStepLine(Client client, String key, String valueStep){
        switch (key){
            //lefttop
            case "lt":
                if(checkTopHorLinePlusReverse(client,valueStep) ||
                        checkLeftVerLinePlusReverse(client,valueStep) ||
                        checkLeftRightLine(client,valueStep)){
                    System.out.println("COME IN LT");
                    return true;
                }
                break;
                //righttop
            case "rt":
                if(checkTopHorLinePlusReverse(client,valueStep) ||
                        checkRightVerLinePlusReverse(client,valueStep) ||
                        checkRightLeftLine(client,valueStep)){
                    System.out.println("COME IN RT");
                    return true;
                }
                break;
                //rightbot
            case "rb":
                if(checkBottomHorLinePlusReverse(client,valueStep) ||
                        checkRightVerLinePlusReverse(client,valueStep) ||
                        checkLeftRightLine(client,valueStep)){
                    System.out.println("COME IN RB");
                    return true;
                }
                break;
                //leftbot
            case "lb":
                if(checkBottomHorLinePlusReverse(client,valueStep) ||
                        checkLeftVerLinePlusReverse(client,valueStep) ||
                        checkRightLeftLine(client,valueStep)){
                    System.out.println("COME IN LB");
                    return true;
                }
                break;
            case "mm":
                if(checkCenterPointLine(client,valueStep)){
                    System.out.println("COME IN MM");
                    return true;
                }
                break;
            case "mt":
                if(checkTopHorLinePlusReverse(client,valueStep) ||
                        checkMiddleVerLinePlusReverse(client, valueStep)){
                    System.out.println("COME IN MT");
                    return true;
                }
                break;
            case "rm":
                if(checkRightVerLinePlusReverse(client,valueStep) ||
                        checkMiddleHorLinePlusReverse(client, valueStep)){
                    System.out.println("COME IN RM");
                    return true;
                }
                break;
            case "mb":
                if(checkMiddleVerLinePlusReverse(client,valueStep) ||
                        checkBottomHorLinePlusReverse(client, valueStep)){
                    System.out.println("COME IN MB");
                    return true;
                }
                break;
            case "lm":
                if(checkLeftVerLinePlusReverse(client,valueStep) ||
                        checkMiddleHorLinePlusReverse(client, valueStep)){
                    System.out.println("COME IN LM");
                    return true;
                }
                break;
        }
        return false;
    }

    private boolean checkTopHorLinePlusReverse(Client client, String valueStep){
        if(client.getMapGame().get("lt").equals(valueStep) &&
                client.getMapGame().get("mt").equals(valueStep) &&
                client.getMapGame().get("rt").equals(valueStep) ||
                client.getMapGame().get("rt").equals(valueStep) &&
                client.getMapGame().get("mt").equals(valueStep)&&
                client.getMapGame().get("lt").equals(valueStep) ||
                client.getMapGame().get("mt").equals(valueStep)&&
                client.getMapGame().get("lt").equals(valueStep) &&
                client.getMapGame().get("rt").equals(valueStep)){
            System.out.println("IN METHOD checkTopHorLinePlusReverse");
            return true;
        }
        return false;
    }

    private boolean checkMiddleHorLinePlusReverse(Client client, String valueStep){
        if(client.getMapGame().get("lm").equals(valueStep) &&
                client.getMapGame().get("mm").equals(valueStep) &&
                client.getMapGame().get("rm").equals(valueStep) ||
                client.getMapGame().get("rm").equals(valueStep) &&
                        client.getMapGame().get("mm").equals(valueStep)&&
                        client.getMapGame().get("lm").equals(valueStep) ||
                client.getMapGame().get("mm").equals(valueStep)&&
                        client.getMapGame().get("lm").equals(valueStep) &&
                        client.getMapGame().get("rm").equals(valueStep)){
            System.out.println("IN METHOD checkMiddleHorLinePlusReverse");
            return true;
        }
        return false;
    }

    private boolean checkBottomHorLinePlusReverse(Client client, String valueStep){
        if(client.getMapGame().get("lb").equals(valueStep) &&
                client.getMapGame().get("mb").equals(valueStep) &&
                client.getMapGame().get("rb").equals(valueStep) ||
                client.getMapGame().get("rb").equals(valueStep) &&
                        client.getMapGame().get("mb").equals(valueStep)&&
                        client.getMapGame().get("lb").equals(valueStep) ||
                client.getMapGame().get("mb").equals(valueStep)&&
                        client.getMapGame().get("lb").equals(valueStep) &&
                        client.getMapGame().get("rb").equals(valueStep)){
            System.out.println("IN METHOD checkBottomHorLinePlusReverse");
            return true;
        }
        return false;
    }

    private boolean checkLeftVerLinePlusReverse(Client client, String valueStep){
        if(client.getMapGame().get("lt").equals(valueStep) &&
                client.getMapGame().get("lm").equals(valueStep) &&
                client.getMapGame().get("lb").equals(valueStep) ||
                client.getMapGame().get("lb").equals(valueStep) &&
                        client.getMapGame().get("lm").equals(valueStep)&&
                        client.getMapGame().get("lt").equals(valueStep) ||
                client.getMapGame().get("lm").equals(valueStep)&&
                        client.getMapGame().get("lt").equals(valueStep) &&
                        client.getMapGame().get("lb").equals(valueStep)){
            System.out.println("IN METHOD checkLeftVerLinePlusReverse");
            return true;
        }
        return false;
    }

    private boolean checkMiddleVerLinePlusReverse(Client client, String valueStep){
        if(client.getMapGame().get("mt").equals(valueStep) &&
                client.getMapGame().get("mm").equals(valueStep) &&
                client.getMapGame().get("mb").equals(valueStep) ||
                client.getMapGame().get("mb").equals(valueStep) &&
                        client.getMapGame().get("mm").equals(valueStep)&&
                        client.getMapGame().get("mt").equals(valueStep) ||
                client.getMapGame().get("mm").equals(valueStep)&&
                        client.getMapGame().get("mt").equals(valueStep) &&
                        client.getMapGame().get("mb").equals(valueStep)){
            System.out.println("IN METHOD checkMiddleVerLinePlusReverse");
            return true;
        }
        return false;
    }

    private boolean checkRightVerLinePlusReverse(Client client, String valueStep){
        if(client.getMapGame().get("rt").equals(valueStep) &&
                client.getMapGame().get("rm").equals(valueStep) &&
                client.getMapGame().get("rb").equals(valueStep) ||
                client.getMapGame().get("rb").equals(valueStep) &&
                        client.getMapGame().get("rm").equals(valueStep)&&
                        client.getMapGame().get("rt").equals(valueStep) ||
                client.getMapGame().get("rm").equals(valueStep)&&
                        client.getMapGame().get("rt").equals(valueStep) &&
                        client.getMapGame().get("rb").equals(valueStep)){
            System.out.println("IN METHOD checkRightVerLinePlusReverse");
            return true;
        }
        return false;
    }

    private boolean checkLeftRightLine(Client client, String valueStep){
        if(client.getMapGame().get("lt").equals(valueStep) &&
                client.getMapGame().get("mm").equals(valueStep) &&
                client.getMapGame().get("rb").equals(valueStep) ||
                client.getMapGame().get("rb").equals(valueStep) &&
                        client.getMapGame().get("mm").equals(valueStep)&&
                        client.getMapGame().get("lt").equals(valueStep) ||
                client.getMapGame().get("mm").equals(valueStep)&&
                        client.getMapGame().get("lt").equals(valueStep) &&
                        client.getMapGame().get("rb").equals(valueStep)){
            System.out.println("IN METHOD checkLeftRightLine");
            return true;
        }
        return false;
    }

    private boolean checkRightLeftLine(Client client, String valueStep){
        if(client.getMapGame().get("rt").equals(valueStep) &&
                client.getMapGame().get("mm").equals(valueStep) &&
                client.getMapGame().get("lb").equals(valueStep) ||
                client.getMapGame().get("lb").equals(valueStep) &&
                        client.getMapGame().get("mm").equals(valueStep)&&
                        client.getMapGame().get("rt").equals(valueStep) ||
                client.getMapGame().get("mm").equals(valueStep)&&
                        client.getMapGame().get("rt").equals(valueStep) &&
                        client.getMapGame().get("lb").equals(valueStep)){
            System.out.println("IN METHOD checkRightLeftLine");
            return true;
        }
        return false;
    }

    private boolean checkCenterPointLine(Client client, String valueStep){
        if(client.getMapGame().get("lm").equals(valueStep) &&
                client.getMapGame().get("mm").equals(valueStep) &&
                client.getMapGame().get("rm").equals(valueStep) ||
                client.getMapGame().get("mt").equals(valueStep) &&
                client.getMapGame().get("mm").equals(valueStep) &&
                client.getMapGame().get("mb").equals(valueStep) ||
                client.getMapGame().get("lt").equals(valueStep) &&
                client.getMapGame().get("mm").equals(valueStep) &&
                client.getMapGame().get("rb").equals(valueStep) ||
                client.getMapGame().get("rt").equals(valueStep) &&
                client.getMapGame().get("mm").equals(valueStep) &&
                client.getMapGame().get("lb").equals(valueStep)){
            System.out.println("IN METHOD checkCenterPointLine");
            return true;
        }
        return false;
    }

}
