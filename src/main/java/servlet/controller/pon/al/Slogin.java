package servlet.controller.pon.al;

import dao.pon.al.role.DAORole;

import dao.pon.al.statgame.DAOGameStat;
import dao.pon.al.user.DaoUser;
import hibernate.pon.al.entity.GameStatE;
import hibernate.pon.al.entity.RoleE;
import hibernate.pon.al.entity.UserE;
import servlet.util.GeneratorKeys;
import servlet.util.UserRegistration;
import util.pon.al.Email;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login")
public class Slogin extends HttpServlet {

    private UserRegistration ur;
//    private GeneratorKeys gk;

    @Override
    public void init() throws ServletException {
        super.init();
        ur = new UserRegistration();
//        gk = new GeneratorKeys();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserE userE = new UserE();
        Email email;
        userE.setNickname(request.getParameter("login"));
        userE.setEmail(request.getParameter("email"));
        userE.setFirstname(request.getParameter("FName"));
        userE.setLastname(request.getParameter("LName"));
        userE.setPassword(request.getParameter("password"));
        userE.setPasswordTwo(request.getParameter("password2"));
        userE.setStatus("ON");

        if(!ur.checkLoginUser(userE.getNickname())){
            System.out.println("ZASHOL");
            userE = ur.registrationUser(userE);
            email = new Email(userE, "Confirm registration", "If you want ended registration you need confirm account" + ur.getLink());
            email.sendEmail();
            System.out.println(" Success ---- " + userE.toString() + " ------ ");
//            response.sendRedirect(request.getContextPath() + "/home");
            request.getRequestDispatcher("WEB-INF/views/regInformat.jsp").forward(request, response);
        }else{
            request.setAttribute("warning", "Ooops User with nickname already exist");
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
        }
//        userE = daoUser.findUserByNickName(userE.getNickname());
//        System.out.println("---- " + userE.toString() + " ------ ");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
}
