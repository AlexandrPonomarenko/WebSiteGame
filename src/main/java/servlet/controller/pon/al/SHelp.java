package servlet.controller.pon.al;

import servlet.error.CheckErrorFilds;
import servlet.util.Help;
import servlet.util.HelpAdMg;
import servlet.util.SUtil;
import util.pon.al.SystemMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SHelp", urlPatterns = "/help")
public class SHelp extends HttpServlet {
    private SUtil util;
    private Help hp;
    private CheckErrorFilds cef;
    private PrintWriter out;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hp = new Help();
        util = new SUtil();
        cef = new CheckErrorFilds();
        out = response.getWriter();
        HttpSession session = util.getSession(request);
        if(session.getAttribute("nickname") != null) {
            hp.send(request.getParameter("name"), request.getParameter("texthelp"));
        }else{
            if(cef.validHelp(request.getParameter("name"), request.getParameter("texthelp"), request.getParameter("email"))) {
                hp.sendNoName(request.getParameter("name"), request.getParameter("email"), request.getParameter("texthelp"));
            }else{
                out.print(cef.getJsonObj());
                out.close();
                return;
            }
        }
        out.print(SystemMessage.getSendMessage());
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        util = new SUtil();
        HttpSession session = util.getSession(request);
        if(session.getAttribute("nickname") != null){
            request.setAttribute("name",session.getAttribute("nickname"));
            request.setAttribute("email",session.getAttribute("email"));
        }
        request.getRequestDispatcher("WEB-INF/views/help.jsp").forward(request,response);
    }
}
