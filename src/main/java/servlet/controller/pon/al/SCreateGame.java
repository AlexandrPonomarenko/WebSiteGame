package servlet.controller.pon.al;

import game.pon.al.Game;
import game.pon.al.SinglCollectGame;
import servlet.util.SUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SCreateGame", urlPatterns = "/create")
public class SCreateGame extends HttpServlet {
    private SUtil util;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        util = new SUtil();
        Game game;
        System.out.println("CREATEEEEEEEEE " + request.getParameter("create"));
        if(request.getParameter("create").equals("create")){
            game = new Game((String) util.getSession(request).getAttribute("nickname"));
            game.setStatus(true);
            SinglCollectGame.getInstance().getGames().add(game);
            System.out.println("TU TU TU TU TU T UT UTU TU UT UT UT UTU TU");
            response.sendRedirect(request.getContextPath() + "/play");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",SinglCollectGame.getInstance().getGames());
        request.getRequestDispatcher("WEB-INF/views/games.jsp").forward(request, response);
        System.out.println("+++++++++++++++++++++++++" + SinglCollectGame.getInstance().getGames().size());
    }
}
