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
    private ReportAdmin ra;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ra = new ReportAdmin();
        if(ra.checkButton(request).equals("more")){
            System.out.println("doPost more");
            response.sendRedirect(request.getRequestURI() +  "/all");
        }else if(ra.checkButton(request).equals("send")){
            System.out.println("doPost send");
            response.sendRedirect(request.getContextPath() + "/info");
        }else if(ra.checkButton(request).equals("delete")){
            System.out.println("doPost delete");
//            response.sendRedirect(request.getContextPath() + "/fullreport/all");
        }else if(ra.checkButton(request).equals("block")){
            System.out.println("doPost block");
//            response.sendRedirect(request.getContextPath() + "/fullreport/all");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         ra = new ReportAdmin();
        request.setAttribute("allliset", ra.getAllUsers(request));
        request.getRequestDispatcher("WEB-INF/views/fulluserstat.jsp").forward(request,response);
    }
}
