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

//    public String checkButton(HttpServletRequest request){
//        if(request.getParameter("bname") != null && request.getParameter("bname").equals("more")){
//            return "more";
//        }else if (request.getParameter("bname") != null && request.getParameter("bname").equals("send")){
//            return "more";
//        }else if (request.getParameter("bname") != null && request.getParameter("bname").equals("delete")){
//            return "more";
//        }else if (request.getParameter("bname") != null && request.getParameter("bname").equals("block")){
//            return "more";
//        }
//        return "none";
//    }
//
//    public void setSessionAtribute(String atribute){
//        if(){
//
//        }else if(){
//
//        }else if(){
//
//        }else if(){
//
//        }
//    }
    private void vievList(Set<GameStatE> set){
        for (GameStatE g : set){
            System.out.println(g.toString());
        }
    }


}
