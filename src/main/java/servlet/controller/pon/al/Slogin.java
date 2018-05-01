package servlet.controller.pon.al;

import dao.pon.al.role.DAORole;

import dao.pon.al.statgame.DAOGameStat;
import dao.pon.al.user.DaoUser;
import hibernate.pon.al.entity.GameStatE;
import hibernate.pon.al.entity.RoleE;
import hibernate.pon.al.entity.UserE;
import servlet.error.CheckErrorFilds;
import servlet.util.GeneratorKeys;
import servlet.util.UserRegistration;
import util.pon.al.Email;
import util.pon.al.SystemMessage;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", urlPatterns = "/login")
public class Slogin extends HttpServlet {

    private UserRegistration ur;
    private CheckErrorFilds cef;

    @Override
    public void init() throws ServletException {
        super.init();
        ur = new UserRegistration();
        cef = new CheckErrorFilds();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserE userE = new UserE();
        Email email;
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        if(cef.validAuth(request.getParameter("login"), request.getParameter("LName"),
                request.getParameter("FName"), request.getParameter("password"),
                request.getParameter("password2"),request.getParameter("email"))) {

            userE.setNickname(request.getParameter("login"));
            userE.setEmail(request.getParameter("email"));
            userE.setFirstname(request.getParameter("FName"));
            userE.setLastname(request.getParameter("LName"));
            userE.setPassword(request.getParameter("password"));
            userE.setPasswordTwo(request.getParameter("password2"));
            userE.setStatus("ON");

            if (!ur.checkLoginUser(userE.getNickname())) {
                userE = ur.registrationUser(userE);
                email = new Email(userE, "Confirm registration", "If you want ended registration you need confirm account" + ur.getLink());
                email.sendEmail();
                out.print("redirect");
                out.close();
            } else {
                out.print(SystemMessage.getUserExist());
                out.close();
            }
        }else {
            out.print(cef.getJsonObj());
            out.close();
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
}
