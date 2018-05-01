package servlet.util;

import java.util.List;
import java.util.Set;

public class CheckURLRole {
    private Set<String> roles;
    private List<String> url;

    public CheckURLRole(){
        roles = RoleMapping.getAllKeyRoles();
    }

    public boolean checkWay(String role, String way){
        url = RoleMapping.getUrlForRole(role);
        for(String url : url){
            if(url.equals(way)){
                return true;
            }
        }
        return false;
    }

    public boolean beforeCheckWay(String way){
        for(String role : roles){
            url = RoleMapping.getUrlForRole(role);
            for(String wayrole : url){
                if(wayrole.equals(way)){
                    return true;
                }
            }
        }
        return false;
    }
}
