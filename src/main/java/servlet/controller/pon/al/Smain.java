package servlet.controller.pon.al;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Smain", urlPatterns = "/main")
public class Smain extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getContextPath --- " + request.getContextPath());
        System.out.println("getPathInfo() --- " + request.getPathInfo());
        System.out.println("getRemoteUser() --- " + request.getRemoteUser());
        System.out.println("getRequestURI() --- " + request.getRequestURI());
        System.out.println("getServletPath() --- " + request.getServletPath());
        System.out.println("getRemoteAddr() --- " + request.getRemoteAddr());
        System.out.println("getLocalName() --- " + request.getLocalName());
        System.out.println("getRemoteHost() --- " + request.getRemoteHost());
        System.out.println("getProtocol() --- " + request.getProtocol());
        System.out.println("getLocale() --- " + request.getLocale());
        request.getRequestDispatcher("WEB-INF/views/main.jsp").forward(request,response);
    }
}
