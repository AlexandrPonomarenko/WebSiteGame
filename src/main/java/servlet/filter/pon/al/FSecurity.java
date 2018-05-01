package servlet.filter.pon.al;

import servlet.util.CheckURLRole;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FSecurity")
public class FSecurity implements Filter {
    private FilterConfig filterConfig;
    private CheckURLRole cur;
    public void destroy() {
        filterConfig = null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession(false);
        String url = request.getServletPath();
        if(cur.beforeCheckWay(url)) {
            if (session != null && session.getAttribute("role") != null) {
                if (cur.checkWay((String) session.getAttribute("role"), url)) {
                    chain.doFilter(req, resp);
                    return;
                } else {
                    response.sendRedirect(request.getContextPath() + "/jsp/warning.jsp");
                }
            }else{
                response.sendRedirect(request.getContextPath() + "/jsp/warning.jsp");
            }

        }else{
            chain.doFilter(req, resp);
            return;
        }
    }

    public void init(FilterConfig config) throws ServletException {
        filterConfig = config;
        cur = new CheckURLRole();
    }

}
