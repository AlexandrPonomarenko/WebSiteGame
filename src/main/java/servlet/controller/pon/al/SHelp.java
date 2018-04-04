package servlet.controller.pon.al;

import servlet.util.Help;
import servlet.util.HelpAdMg;
import servlet.util.SUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SHelp", urlPatterns = "/help")
public class SHelp extends HttpServlet {
    private SUtil util;
    private Help hp;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hp = new Help();
        util = new SUtil();
        HttpSession session = util.getSession(request);
        if(session.getAttribute("nickname") != null) {
            hp.send(request.getParameter("name"), request.getParameter("texthelp"));
        }else{
            System.out.println(request.getParameter("name")+ "==="+ request.getParameter("email")+ "====" + request.getParameter("texthelp"));
            hp.sendNoName(request.getParameter("name"), request.getParameter("email"), request.getParameter("texthelp"));
        }
        request.getRequestDispatcher("WEB-INF/views/help.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        util = new SUtil();
        HttpSession session = util.getSession(request);
        if(session.getAttribute("nickname") != null){
            request.setAttribute("name",session.getAttribute("nickname"));
        }
        request.getRequestDispatcher("WEB-INF/views/help.jsp").forward(request,response);
    }
}
