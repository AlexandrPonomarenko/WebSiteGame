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
}
