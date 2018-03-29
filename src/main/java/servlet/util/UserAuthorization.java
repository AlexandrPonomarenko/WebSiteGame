package servlet.util;

import dao.pon.al.user.DaoUser;
import hibernate.pon.al.entity.UserE;

public class UserAuthorization {
    private UserE userE;
    private DaoUser daoUser;

    public UserAuthorization(){
        daoUser = new DaoUser();
        userE = new UserE();
    }

    public boolean AuthorizationUser(String nickname, String password){
        userE = daoUser.findUserByNickName(nickname);
        if(userE != null && userE.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public UserE getUser(){
        return userE;
    }

}
