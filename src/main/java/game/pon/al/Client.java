package game.pon.al;
import javax.websocket.Session;

public class Client {
    private String name;
    private String nameOpponent;
    private Session session;
    private Session sessionOpponent;

    public Client (String name, Session session) {
        this.name = name;
        this.session = session;
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


}
