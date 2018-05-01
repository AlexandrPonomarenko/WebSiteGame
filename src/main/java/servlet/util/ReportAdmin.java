package servlet.util;

import dao.pon.al.user.DaoUser;
import hibernate.pon.al.entity.GameStatE;
import hibernate.pon.al.entity.UserE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

public class ReportAdmin {
    private DaoUser daoUser;
    private UserE user;
    private SUtil util;
    private HttpSession session;
    private List<UserE> users;


    public ReportAdmin(){
        daoUser = new DaoUser();
        util = new SUtil();
    }

    public List<UserE> getAllUsers(HttpServletRequest request){
        session = util.getSession(request);
        users = daoUser.getAll();
        return users;
    }

    public Set<GameStatE> getAllGames(String id){
        Set<GameStatE> games;
        user = daoUser.getEntityById(Integer.parseInt(id));
        games = user.getStatgame();
        return  games;
    }

    private String getUser(String id){
        user = daoUser.getEntityById(Integer.parseInt(id));
        return user.getNickname();
    }

    public UserE getSelectUser(){
        return user;
    }

    public String checkButton(HttpServletRequest request){
        if(request.getParameter("bname") != null && request.getParameter("bname").equals("more")){
            session = util.getSession(request);
            session.setAttribute("more", getAllGames(request.getParameter("id")));
            session.setAttribute("selectuser", getSelectUser());
            return "more";
        }else if (request.getParameter("bname") != null && request.getParameter("bname").equals("send")){
            session = util.getSession(request);
            session.setAttribute("send", getUser(request.getParameter("id")));
            return "send";
        }else if (request.getParameter("bname") != null && request.getParameter("bname").equals("delete")){
            session = util.getSession(request);
            deleteUser(request.getParameter("id"));
            return "delete";
        }else if (request.getParameter("bname") != null && request.getParameter("bname").equals("block")){
            session = util.getSession(request);
            blockUser(request.getParameter("id"));
            return "block";
        }
        return "none";
    }

    private void deleteUser(String id){
        daoUser.delete(Integer.parseInt(id));
    }

    private void blockUser(String id){
        UserE userE = daoUser.getEntityById(Integer.parseInt(id));
        userE.setStatus("OFF");
        daoUser.update(userE);
    }
}
