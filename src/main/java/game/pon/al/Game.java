package game.pon.al;

public class Game {
    private String name;
    private String nameOpponent;
    private boolean status;

    public Game(){}
    public Game(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNameOpponent() {
        return nameOpponent;
    }

    public void setNameOpponent(String nameOpponent) {
        this.nameOpponent = nameOpponent;
    }
}
