package servlet.controller.pon.al;

import servlet.util.HelpAdMg;
import servlet.util.SUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SFromAdMg",urlPatterns = "/info")
public class SFromAdMg extends HttpServlet {
    private SUtil util;
    private HelpAdMg ham;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ham = new HelpAdMg();
        util = new SUtil();
        HttpSession session = util.getSession(request);
            ham.send(request.getParameter("name"), (String) session.getAttribute("role"), request.getParameter("texthelp"));

        request.getRequestDispatcher("WEB-INF/views/informuser.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        util = new SUtil();
        HttpSession session = util.getSession(request);
        if(session.getAttribute("send") != null){
            request.setAttribute("name",session.getAttribute("send"));
        }

        request.getRequestDispatcher("WEB-INF/views/informuser.jsp").forward(request,response);
    }
}
