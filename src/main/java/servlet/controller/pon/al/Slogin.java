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
//    private GeneratorKeys gk;

    @Override
    public void init() throws ServletException {
        super.init();
        ur = new UserRegistration();
        cef = new CheckErrorFilds();
        System.out.println("INITTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
//        gk = new GeneratorKeys();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        UserE userE = new UserE();
//        Email email;
//        if(cef.validAuth(request.getParameter("login"), request.getParameter("LName"),
//                request.getParameter("FName"), request.getParameter("password"),
//                request.getParameter("password2"),request.getParameter("email"))) {
//
//            userE.setNickname(request.getParameter("login"));
//            userE.setEmail(request.getParameter("email"));
//            userE.setFirstname(request.getParameter("FName"));
//            userE.setLastname(request.getParameter("LName"));
//            userE.setPassword(request.getParameter("password"));
//            userE.setPasswordTwo(request.getParameter("password2"));
//            userE.setStatus("ON");
//
//                if (!ur.checkLoginUser(userE.getNickname())) {
//                    System.out.println("ZASHOL");
//                    userE = ur.registrationUser(userE);
//                    email = new Email(userE, "Confirm registration", "If you want ended registration you need confirm account" + ur.getLink());
//                    email.sendEmail();
//                    System.out.println(" Success ---- " + userE.toString() + " ------ ");
////            response.sendRedirect(request.getContextPath() + "/home");
//                    request.getRequestDispatcher("WEB-INF/views/regInformat.jsp").forward(request, response);
//                } else {
//                    request.setAttribute("warning", SystemMessage.getUserExist());
//                    request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
//                }
//        }else {
//            System.out.println("NEPROSHOL VALIDATOIN");
//            request.setAttribute("error", cef.getError());
//            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
//        }

        UserE userE = new UserE();
        Email email;
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println(" --------- " + request.getParameter("login")+ " - " + request.getParameter("LName")+ " - " +
                request.getParameter("FName")+ " - " + request.getParameter("password")+ " - " +
                request.getParameter("password2")+ " - " +request.getParameter("email"));
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
                System.out.println("ZASHOL");
                userE = ur.registrationUser(userE);
                email = new Email(userE, "Confirm registration", "If you want ended registration you need confirm account" + ur.getLink());
                email.sendEmail();
                System.out.println(" Success ---- " + userE.toString() + " ------ ");
//            response.sendRedirect(request.getContextPath() + "/home");
                out.print("redirect");
                out.close();
//                request.getRequestDispatcher("WEB-INF/views/regInformat.jsp").forward(request, response);
            } else {
//                request.setAttribute("warning", SystemMessage.getUserExist());
                System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHUYYYYYYYYY" + SystemMessage.getUserExist());
                out.print(SystemMessage.getUserExist());
                out.close();
//                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
//                out.close();
            }
        }else {
            System.out.println("NEPROSHOL VALIDATOIN");
            out.print(cef.getJsonObj());
            out.close();
//            request.setAttribute("error", cef.getError());
//            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
}
