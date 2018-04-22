package servlet.controller.pon.al;

import servlet.error.CheckErrorFilds;
import servlet.util.SUtil;
import servlet.util.UserAuthorization;
import util.pon.al.SystemMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Slogon", urlPatterns = "/logon")
public class Slogon extends HttpServlet {
    private UserAuthorization ua;
    private CheckErrorFilds cef;
    private SUtil su;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        ua = new UserAuthorization();
        su = new SUtil();
        cef = new CheckErrorFilds();
        PrintWriter out = response.getWriter();
        HttpSession session;
        if(cef.validAunt(request.getParameter("login"), request.getParameter("password"))) {
            if(ua.preAuthorizationUser(request.getParameter("login"), request.getParameter("password"))) {
                if (ua.authorizationUser(request.getParameter("login"), request.getParameter("password"))) {
                    session = su.getCreatedSession(request);
                    session.setAttribute("nickname", ua.getUser().getNickname());
                    session.setAttribute("email", ua.getUser().getEmail());
                    session.setAttribute("id", ua.getUser().getId());
                    session.setAttribute("role", ua.getUser().getRoleE().getRole());
                    session.setAttribute("status", ua.getUser().getStatus());
                    out.print("redirect");
                    out.close();
//                    response.sendRedirect(request.getContextPath() + "/home");
                } else {
                    System.out.println("TYTYTYTYTYTYTYTYTYTYTYTYTTYYTTYTYTYTYYT");
                    out.print(SystemMessage.getIncorrect());
                    out.close();
//                    request.setAttribute("warning", SystemMessage.getIncorrect());
//                    request.getRequestDispatcher("/WEB-INF/views/logon.jsp").forward(request, response);
                }
            }else{
                System.out.println("poppppppppppppppppppppppppppppppppppppppooopo");
                out.print(request.getParameter("login") + SystemMessage.getConfirmAccount());
                out.close();
//                request.setAttribute("confirm", request.getParameter("login") + SystemMessage.getConfirmAccount());
//                request.getRequestDispatcher("/WEB-INF/views/logon.jsp").forward(request, response);
            }
        }else{
            System.out.println("____________--------------------------------------------------");
            out.print(cef.getJsonObj());
//            request.setAttribute("error", cef.getError());
//            request.getRequestDispatcher("/WEB-INF/views/logon.jsp").forward(request, response);
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/logon.jsp").forward(request,response);
    }
}
