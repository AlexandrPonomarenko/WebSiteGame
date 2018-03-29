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
        System.out.println("---------- " + key + " ----------------");
        userE = daoUser.findConfirmKey(key);
        if(userE != null && !userE.getKey().equals("confirm")){
            System.out.println("------ confirnKey - " + userE.toString());
            userE.setKey("confirm");
            daoUser.update(userE);
            return true;
        }
        return false;
    }
}
