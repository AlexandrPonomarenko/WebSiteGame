package servlet.filter.pon.al;

import servlet.util.CheckSecurityGames;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FSecurityGame")
public class FSecurityGame implements Filter {
    private FilterConfig fc;
    private CheckSecurityGames csg;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;

        String url = request.getServletPath();

        if(url.equals("/create")){
            if(!csg.isStatus(request)){
                response.sendRedirect(request.getContextPath() + "/main");
            }else{
                chain.doFilter(req, resp);
                return;
            }
        }else if(url.equals("/play")){
            chain.doFilter(req, resp);
            return;
        }

//        else if(url.equals("/ready")){
//            chain.doFilter(req, resp);
//            return;
//        }
    }

    public void init(FilterConfig config) throws ServletException {
        fc = config;
        csg = new CheckSecurityGames();
    }

}
