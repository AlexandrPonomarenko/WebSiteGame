package servlet.util;

import dao.pon.al.user.DaoUser;
import hibernate.pon.al.entity.UserE;
import util.pon.al.Email;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Help {
    private DaoUser daoUser;
    private UserE user;
    private Email email;

    public Help() {
        daoUser = new DaoUser();
        user = new UserE();
    }

    private UserE getUser(String nickname){
        return daoUser.findUserByNickName(nickname);
    }

    public void send(String nickName, String ms ){
        user = getUser(nickName);
        email = new Email(user, "help from " + user.getNickname(), ms);
        email.sendUserEmail();
    }

    public void sendNoName(String nickName, String resEmail, String ms){
        email = new Email(nickName, "noName " , ms, resEmail);
        email.sendNoNameUserEmail();
    }

}
