package servlet.controller.pon.al;

import servlet.util.ReportAdmin;
import util.pon.al.SystemMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SAdmin", urlPatterns = "/fullreport")
public class SAdmin extends HttpServlet {
    private ReportAdmin ra;
    private PrintWriter out;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ra = new ReportAdmin();
        out = response.getWriter();
        if(ra.checkButton(request).equals("more")){
            out.print("more");
        }else if(ra.checkButton(request).equals("send")){
            out.print("send");
        }else if(ra.checkButton(request).equals("delete")){
            out.print(SystemMessage.getUserDelete());
        }else if(ra.checkButton(request).equals("block")){
            out.print(SystemMessage.getUserBlock());
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         ra = new ReportAdmin();
        request.setAttribute("allliset", ra.getAllUsers(request));
        request.getRequestDispatcher("WEB-INF/views/fulluserstat.jsp").forward(request,response);
    }
}
