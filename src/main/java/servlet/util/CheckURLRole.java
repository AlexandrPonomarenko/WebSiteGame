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
//        if(role != null) {
            url = RoleMapping.getUrlForRole(role);
//        }else
        for(String url : url){
//            System.out.println("checkWay JUST OUT COLLECTION ===== " + url);
            if(url.equals(way)){
//                System.out.println(" checkWay TRUE + ----------" + url + " ============= " + way);
                return true;
            }
        }
//        System.out.println("checkWay FALSE");
        return false;
    }

    public boolean beforeCheckWay(String way){
        for(String role : roles){
//            System.out.println(" beforeCheckWay ROLE " + role);
            url = RoleMapping.getUrlForRole(role);
            for(String wayrole : url){
                if(wayrole.equals(way)){
//                    System.out.println(" beforeCheckWay SELECT WAY " + wayrole + " --- " + role + " ARGUMENT WAY " + way);
                    return true;
                }
            }
        }
//        System.out.println(" beforeCheckWay FALSE");
        return false;
    }
}
