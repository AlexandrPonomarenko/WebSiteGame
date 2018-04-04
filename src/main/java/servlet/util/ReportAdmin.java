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

    public String checkButton(HttpServletRequest request){
        if(request.getParameter("bname") != null && request.getParameter("bname").equals("more")){
            System.out.println("---" + "more " + "---");
            session = util.getSession(request);
            session.setAttribute("more", getAllGames(request.getParameter("id")));
            session.setAttribute("selectuser", getSelectUser());
            return "more";
        }else if (request.getParameter("bname") != null && request.getParameter("bname").equals("send")){
            System.out.println("---" + "send " + "---");
            session = util.getSession(request);
            session.setAttribute("send", request.getParameter("nickname"));
            return "send";
        }else if (request.getParameter("bname") != null && request.getParameter("bname").equals("delete")){
            System.out.println("---" + "delete " + "---");
//            session = util.getSession(request);
            session.setAttribute("delete", request.getParameter("id"));
            return "delete";
        }else if (request.getParameter("bname") != null && request.getParameter("bname").equals("block")){
            System.out.println("---" + "block " + "---");
//            session = util.getSession(request);
            session.setAttribute("block", request.getParameter("id"));
            return "block";
        }
        System.out.println("---" + "none " + "---");
        return "none";
    }

//    public void setSessionAtribute(String attribute){
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
