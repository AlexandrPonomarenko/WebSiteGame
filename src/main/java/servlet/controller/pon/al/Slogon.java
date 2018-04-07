package servlet.controller.pon.al;

import servlet.error.CheckErrorFilds;
import servlet.util.SUtil;
import servlet.util.UserAuthorization;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Slogon", urlPatterns = "/logon")
public class Slogon extends HttpServlet {
    private UserAuthorization ua;
    private CheckErrorFilds cef;
    private SUtil su;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ua = new UserAuthorization();
        su = new SUtil();
        cef = new CheckErrorFilds();
        HttpSession session;
        if(cef.validAunt(request.getParameter("login"), request.getParameter("password"))) {
            if (ua.authorizationUser(request.getParameter("login"), request.getParameter("password"))) {
                session = su.getCreatedSession(request);
                session.setAttribute("nickname", ua.getUser().getNickname());
                session.setAttribute("email", ua.getUser().getEmail()) ;
                session.setAttribute("id", ua.getUser().getId());
                session.setAttribute("role", ua.getUser().getRoleE().getRole());
                session.setAttribute("status", ua.getUser().getStatus());
//            session.setAttribute("lastURL", );
                response.sendRedirect(request.getContextPath() + "/home");
            } else {
                request.setAttribute("warning", "Ooopss... Incorrect login or password");
                request.getRequestDispatcher("/WEB-INF/views/logon.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("error", cef.getError());
            request.getRequestDispatcher("/WEB-INF/views/logon.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/logon.jsp").forward(request,response);
    }
}
