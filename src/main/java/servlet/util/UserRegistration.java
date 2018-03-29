package servlet.util;

import dao.pon.al.role.DAORole;
import dao.pon.al.user.DaoUser;
import hibernate.pon.al.entity.RoleE;
import hibernate.pon.al.entity.UserE;

public class UserRegistration {

    private boolean valid;
    private DaoUser daoUser;
    private DAORole daoRole;
    private GeneratorKeys gk;
    private String key;
    private final char ch = (char)34;


    public UserRegistration(){
        valid = true;
        daoRole = new DAORole();
        daoUser = new DaoUser();
        gk = new GeneratorKeys();
    }

    public boolean checkLoginUser(String loginUser){
        UserE user = daoUser.findUserByNickName(loginUser);
        if(user != null){
            valid = true;
        }else {valid = false;}

        return valid;
    }

    public UserE registrationUser(UserE userE){
        setKey(gk.randomGen());
        RoleE role = daoRole.getRoleByName("user");
        userE.setRoleE(role);
        userE.setKey(key);
        role.getUsers().add(userE);
        daoRole.update(role);

        userE = daoUser.findUserByNickName(userE.getNickname());
        System.out.println("METHOD registrationUser work NORMALNO");
        return userE;
    }

    public String getKey() {
        return key;
    }

    private void setKey(String key) {
        this.key = key;
    }

    public String getLink(){
        return "<a href="  + ch + "http://localhost:8080/WebSiteGame/activate/access?key=" + key + ch + ">confirm account</a>";
    }
}
