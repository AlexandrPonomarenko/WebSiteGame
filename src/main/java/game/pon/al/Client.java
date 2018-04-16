package game.pon.al;
import javax.websocket.Session;
import java.util.HashMap;
import java.util.Map;

public class Client {
    private String name;
    private String nameOpponent;
    private Session session;
    private Session sessionOpponent;
    private int steps;
    private Map<String, String> mapGame;

    public Client (String name, Session session) {
        this.name = name;
        this.session = session;
        steps = 0;
        mapGame = new HashMap<>();
        setKeyMap();
    }

    public String getNameOpponent() {
        return nameOpponent;
    }

    public void setNameOpponent(String nameOpponent) {
        this.nameOpponent = nameOpponent;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSessionOpponent() {
        return sessionOpponent;
    }

    public void setSessionOpponent(Session sessionOpponent) {
        this.sessionOpponent = sessionOpponent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSessionId(){
        return session.getId();
    }

    public String getOpponentSessionId(){
        return sessionOpponent.getId();
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getSteps() {
        return steps;
    }

    public Map<String, String> getMapGame() {
        return mapGame;
    }

    public void setMapGame(Map<String, String> mapGame) {
        this.mapGame = mapGame;
    }

    private void setKeyMap(){
        mapGame.put("lt","");
        mapGame.put("lm","");
        mapGame.put("lb","");
        mapGame.put("mt","");
        mapGame.put("mm","");
        mapGame.put("mb","");
        mapGame.put("rt","");
        mapGame.put("rm","");
        mapGame.put("rb","");
    }
}
