package servlet.controller.pon.al;

import hibernate.pon.al.entity.GameStatE;
import hibernate.pon.al.entity.UserE;
import servlet.util.SUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "SMore", urlPatterns = "/reportUser/more")
public class SMore extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SUtil sUtil = new SUtil();
        HttpSession session = sUtil.getSession(request);
        Set<GameStatE> users = (Set<GameStatE>)session.getAttribute("more");
        if(users.size() > 0) {
            request.setAttribute("list", session.getAttribute("more"));
        }else {
            request.setAttribute("emptySet", "At the moment there are no games.");
        }
        request.setAttribute("selectuser", session.getAttribute("selectuser"));
        request.getRequestDispatcher( "../WEB-INF/views/more.jsp").forward(request,response);
    }
}
