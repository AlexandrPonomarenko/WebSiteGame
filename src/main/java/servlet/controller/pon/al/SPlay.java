package servlet.controller.pon.al;

import servlet.util.SUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SPlay", urlPatterns = "/play")
public class SPlay extends HttpServlet {
    private SUtil su;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        su = new SUtil();
        if(su.getSession(request).getAttribute("connect") != null){
            request.setAttribute("flag",su.getSession(request).getAttribute("connect"));
        }else{
            request.setAttribute("flag", "create");
        }
        request.getRequestDispatcher("WEB-INF/views/play.jsp").forward(request, response);
    }
}
