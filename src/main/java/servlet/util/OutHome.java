package servlet.util;

import javax.servlet.http.HttpSession;

public class OutHome {

    public OutHome(){
    }

    public void out(HttpSession session){
        session.removeAttribute("nickname");
        session.removeAttribute("id");
        session.removeAttribute("role");
        session.removeAttribute("status");
        session.invalidate();
    }

}
