package servlet.util;

import java.util.*;

public class RoleMapping {
    private static final String ADMIN = "admin";
    private static final String MANAGER = "manager";
    private static final String USER = "user";
    private static final String NONE = "none";
    private static final Map<String,List<String>>map = new HashMap<>();
//    public RoleMapping(){
//        map = new HashMap<>();
//    }

    static {
        init();
    }

    private static void init(){
//        List<String>urlNone = new ArrayList<>();
//        urlNone.add("/jsp/author.jsp");
//        urlNone.add("/jsp/about.jsp");
//        urlNone.add("/main");
//        urlNone.add("/help");
//        urlNone.add("/logon");
//        urlNone.add("/login");
//        urlNone.add("/index.jsp");
//        map.put(NONE, urlNone);

        List<String> urlUser = new ArrayList<>();
//        urlUser.addAll(urlNone);
        urlUser.add("/home");
        urlUser.add("/games");
        urlUser.add("/play");
        urlUser.add("/achievements");
        map.put(USER, urlUser);

        List<String> urlManager = new ArrayList<>();
        urlManager.addAll(urlUser);
        urlManager.add("/reportUser");
        map.put(MANAGER, urlManager);

        List<String> urlAdmin = new ArrayList<>();
        urlAdmin.addAll(urlManager);
        urlAdmin.add("/fullreport");
        map.put(ADMIN, urlAdmin);
    }

    public static Set<String> getAllKeyRoles(){
        return map.keySet();
    }
    public static List<String> getUrlForRole(String role){
        return map.get(role);
    }
}
