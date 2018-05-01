package servlet.util;

import dao.pon.al.user.DaoUser;
import hibernate.pon.al.entity.GameStatE;
import hibernate.pon.al.entity.UserE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

public class ReportUser {
    private DaoUser daoUser;
    private UserE user;
    private SUtil util;
    private HttpSession session;
    private List<UserE> users;

    public ReportUser(){
        daoUser = new DaoUser();
        util = new SUtil();
    }

    public List<UserE> getAllUsers(HttpServletRequest request){
        session = util.getSession(request);
        users = daoUser.getAll();
        return users;
    }

    public int getNumUsers(){
        if(users != null)
        return users.size();
        return 0;
    }

    public Set<GameStatE> getAllGames(String id){
        Set<GameStatE> games;
        user = daoUser.getEntityById(Integer.parseInt(id));
        games = user.getStatgame();
        return  games;
    }

    public UserE getSelectUser(){
        return user;
    }

}
