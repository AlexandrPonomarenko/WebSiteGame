package servlet.controller.pon.al;

import servlet.util.HistoryGame;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SHome", urlPatterns = "/home")
public class SHome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HistoryGame historyGame = new HistoryGame();
        request.setAttribute("setGame", historyGame.getList(request));
        request.setAttribute("sumVins", historyGame.getAllVin());
        request.setAttribute("sumLost", historyGame.getSunGame() - historyGame.getAllVin());
        request.setAttribute("allGame", historyGame.getSunGame());
//        System.out.println(historyGame.getAllVin() + "+_+_+_+_+_++_+_+_+_" + c);
        request.getRequestDispatcher("WEB-INF/views/home.jsp").forward(request, response);
    }
}
