package servlet.controller.pon.al;

import game.pon.al.Game;
import game.pon.al.SinglCollectGame;
import servlet.util.SUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SCreateGame", urlPatterns = "/create")
public class SCreateGame extends HttpServlet {
    private SUtil util;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        util = new SUtil();
        Game game;
        if(request.getParameter("option").equals("create")){
            game = new Game((String) util.getSession(request).getAttribute("nickname"));
            game.setStatus(true);
            SinglCollectGame.getInstance().getGames().add(game);
            response.sendRedirect(request.getContextPath() + "/play");
        }else if(!request.getParameter("option").equals("create")){
            if(SinglCollectGame.getInstance().getByNickName(request.getParameter("option")) != null){
                util.getSession(request).setAttribute("connect", request.getParameter("option"));
                SinglCollectGame.getInstance().removeGameByNickName(request.getParameter("option"));
            }
            response.sendRedirect(request.getContextPath() + "/play");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        util = new SUtil();
        request.setAttribute("list",SinglCollectGame.getInstance().getGames());
        HttpSession session = util.getSession(request);
        if(session.getAttribute("connect") != null){
            session.removeAttribute("connect");
        }
        request.getRequestDispatcher("WEB-INF/views/games.jsp").forward(request, response);
    }
}
