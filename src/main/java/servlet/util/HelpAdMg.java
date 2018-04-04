package servlet.util;

import dao.pon.al.user.DaoUser;
import hibernate.pon.al.entity.UserE;
import util.pon.al.Email;

public class HelpAdMg {
    private DaoUser daoUser;
    private UserE user;
    private Email email;

    public HelpAdMg() {
        daoUser = new DaoUser();
    }

    private UserE getUser(String nickname){
        return daoUser.findUserByNickName(nickname);
    }

    public void send(String nickName, String sub, String ms ){
        user = getUser(nickName);
        email = new Email(user, sub, ms);
        email.sendEmail();
    }
}
