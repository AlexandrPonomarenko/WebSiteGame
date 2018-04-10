package game.pon.al;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SinglCollectGame {
    private static SinglCollectGame inst = null;
    private List<Game> listGame;
    private SinglCollectGame(){
        listGame = Collections.synchronizedList(new ArrayList<Game>());
    }

    public static synchronized  SinglCollectGame getInstance(){
        if(inst == null){
            inst = new SinglCollectGame();
        }
        return inst;
    }

    public List<Game> getGames(){
        return listGame;
    }

    public Game getByNickName(String nickNameOpponent){
        synchronized (listGame) {
            for (Game game : listGame) {
                if (game.getName().equals(nickNameOpponent)) {
                    return game;
                }
            }
            return null;
        }
    }

    public void removeGameByNickName(String nickname){
        synchronized (listGame) {
            for (Game game : listGame) {
                if (game.getName().equals(nickname)) {
                    listGame.remove(game);
                    return;
                }
            }
        }
    }
}
