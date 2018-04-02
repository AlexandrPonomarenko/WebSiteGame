package servlet.filter.pon.al;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FAuthorization",urlPatterns = "/*")
public class FAuthorization implements Filter {
    private FilterConfig filterC;
    public void destroy() {
        filterC = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession(false);
        String url = request.getServletPath();
        System.out.println("COME IN FAuthorization ++++ " + url + "-------- " + request.getPathInfo());
        if(url.equals("/home") || url.equals("/play") || url.equals("/gameStatistics")) {
            if (session != null && session.getAttribute("nickname") != null) {
                chain.doFilter(req,resp);
                return;
            }else{
                response.sendRedirect(request.getContextPath()+ "/logon");
//                return;
            }
        }else{
            chain.doFilter(req, resp);
//            return;
        }
//        return;
//        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        filterC = config;
        System.out.println("START FAuthorization ");
    }

}
