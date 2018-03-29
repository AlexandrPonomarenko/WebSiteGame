package servlet.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SUtil {

    public SUtil(){}

    public HttpSession getSession(HttpServletRequest request){
        return request.getSession(false);
    }

    public HttpSession getCreatedSession(HttpServletRequest request){
        return request.getSession(true);
    }

    public Object getAttributeServletContext(String nameAttribute , ServletContext context){
        return context.getAttribute(nameAttribute);
    }


}
