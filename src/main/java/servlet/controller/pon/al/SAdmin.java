package servlet.controller.pon.al;

import servlet.util.ReportAdmin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SAdmin", urlPatterns = "/fullreport")
public class SAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReportAdmin rp = new ReportAdmin();
        request.setAttribute("allliset", rp.getAllUsers(request));
        request.getRequestDispatcher("WEB-INF/views/fulluserstat.jsp").forward(request,response);
    }
}
