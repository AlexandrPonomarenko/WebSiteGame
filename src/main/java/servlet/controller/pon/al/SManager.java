package servlet.controller.pon.al;

import servlet.util.ReportUser;
import servlet.util.SUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "SManager", urlPatterns = "/reportUser")
public class SManager extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SUtil sUtil = new SUtil();
        HttpSession session = sUtil.getSession(request);
        if(request.getParameter("bname") != null && request.getParameter("bname").equals("more")){
            ReportUser ru = new ReportUser();
            session.setAttribute("more",ru.getAllGames(request.getParameter("id")));
            session.setAttribute("selectuser",ru.getSelectUser());
            response.sendRedirect(request.getRequestURI() +  "/more");
        }else{
            session.setAttribute("send",request.getParameter("nickname"));
            response.sendRedirect(request.getContextPath() + "/info");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReportUser ru = new ReportUser();
        request.setAttribute("statuser",ru.getAllUsers(request));
        request.setAttribute("numofuser",ru.getNumUsers());
        request.getRequestDispatcher("WEB-INF/views/userstat.jsp").forward(request,response);
    }
}
