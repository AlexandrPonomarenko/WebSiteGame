package servlet.util;

import dao.pon.al.user.DaoUser;
import hibernate.pon.al.entity.GameStatE;
import hibernate.pon.al.entity.UserE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class HistoryGame {
    private DaoUser daoUser;
    private UserE user;
    private SUtil util;
    private HttpSession session;
    private int sunGame;
    private Set<GameStatE> set;


    public HistoryGame(){
        daoUser = new DaoUser();
        util = new SUtil();
    }

    public Set<GameStatE> getList(HttpServletRequest request){
        session = util.getSession(request);
        user = daoUser.getEntityById((Integer)session.getAttribute("id"));
        sunGame = user.getStatgame().size();
        return user.getStatgame();
    }

    public int getAllVin(){
        int sumVins = 0;
        for(GameStatE game : user.getStatgame()){
            if(game.getVin() > 0)
            sumVins += 1;
        }
        return sumVins;
    }

    public int getSunGame(){
        return sunGame;
    }

}
