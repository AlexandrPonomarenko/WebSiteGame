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
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpSession session = request.getSession(false);
        String url = request.getServletPath();
        System.out.println("WEY + -- " + url);
        if(cur.beforeCheckWay(url)) {
            if (session != null && session.getAttribute("role") != null) {
                System.out.println("USER NICKNAME " + session.getAttribute("role") + "WEY + -- " + url);
                if (cur.checkWay((String) session.getAttribute("role"), url)) {
                    System.out.println("WEY + -- " + url);
                    chain.doFilter(req, resp);
                    return;
                } else {
                    System.out.println("ИМЯ ЕСТЬ ЭТО ПЕРЕД ОТПРАВКОЙ");
                    response.sendRedirect(request.getContextPath() + "/jsp/warning.jsp");
                }
//                return;
            }else{
                System.out.println("ИМЕНИ НЕТ ВЫШЕЛ НА СТАДИИ ПРОВЕРКИ РОЛИ");
                response.sendRedirect(request.getContextPath() + "/jsp/warning.jsp");
            }
//            else {
////            if((String)session.getAttribute("nickname") == null)
//                System.out.println("nickname == null -- " + url);
//                if (cur.checkWay("none", url)) {
//                    System.out.println("ROLE NONE");
//                    chain.doFilter(req, resp);
//                } else {
//                    System.out.println("ИМЕНИ НЕТ ЕСТЬ ЭТО ПЕРЕД ОТПРАВКОЙ");
//                    response.sendRedirect(request.getContextPath() + "/WEB-INF/views/warning.jsp");
////                    return;
//                }
////                return;
//            }
        }else{
            chain.doFilter(req, resp);
//            return;
        }
//        if(cur.checkWay())
//        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("START SECURITY FILTER");
        filterConfig = config;
        cur = new CheckURLRole();
    }

}
