package servlet.util;

import java.util.*;

public class RoleMapping {
    private static final String ADMIN = "admin";
    private static final String MANAGER = "manager";
    private static final String USER = "user";
    private static final String NONE = "none";
    private static final Map<String,List<String>>map = new HashMap<>();

    static {
        init();
    }

    private static void init(){
        List<String> urlUser = new ArrayList<>();
        urlUser.add("/home");
        urlUser.add("/create");
        urlUser.add("/ready");
        urlUser.add("/play");
        urlUser.add("/achievements");
        map.put(USER, urlUser);

        List<String> urlManager = new ArrayList<>();
        urlManager.addAll(urlUser);
        urlManager.add("/reportUser");
        urlManager.add("/info");
        urlManager.add("/reportUser/more");
        map.put(MANAGER, urlManager);

        List<String> urlAdmin = new ArrayList<>();
        urlAdmin.addAll(urlManager);
        urlAdmin.add("/fullreport");
        urlAdmin.add("/fullreport/all");
        map.put(ADMIN, urlAdmin);
    }

    public static Set<String> getAllKeyRoles(){
        return map.keySet();
    }

    public static List<String> getUrlForRole(String role){
        return map.get(role);
    }
}
