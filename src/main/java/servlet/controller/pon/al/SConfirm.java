package servlet.controller.pon.al;

import servlet.util.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SConfirm", urlPatterns = "/activate/access")
public class SConfirm extends HttpServlet {
    private UserValidator uv;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        uv = new UserValidator();
        if(uv.confirmKey(request.getParameter("key"))){
            request.getRequestDispatcher("/WEB-INF/views/activate/confirm.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("/WEB-INF/views/activate/error.jsp").forward(request, response);
        }

    }


}
