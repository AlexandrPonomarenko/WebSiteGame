package servlet.util;

import javax.servlet.http.HttpServletRequest;

public class CheckSecurityGames {
    private SUtil util;

    public CheckSecurityGames(){
        util = new SUtil();
    }

    public boolean isStatus(HttpServletRequest request){
        if(util.getSession(request).getAttribute("status") != null &&
                util.getSession(request).getAttribute("status").equals("ON")){
            return true;
        }
        return false;
    }


}
