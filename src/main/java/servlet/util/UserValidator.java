package servlet.util;

import dao.pon.al.user.DaoUser;
import hibernate.pon.al.entity.UserE;

public class UserValidator {
    private UserE userE;
    private DaoUser daoUser;
    public UserValidator(){
        daoUser = new DaoUser();
    }

    public boolean confirmKey(String key){
        userE = daoUser.findConfirmKey(key);
        if(userE != null && !userE.getKey().equals("confirm")){
            userE.setKey("confirm");
            daoUser.update(userE);
            return true;
        }
        return false;
    }
}
