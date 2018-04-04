package servlet.controller.pon.al;

import servlet.util.OutHome;
import servlet.util.SUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Sout", urlPatterns = "/logout")
public class Sout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OutHome outHome = new OutHome();
        SUtil util = new SUtil();
        outHome.out(util.getSession(request));
        response.sendRedirect(request.getContextPath() + "/main");
    }
}
