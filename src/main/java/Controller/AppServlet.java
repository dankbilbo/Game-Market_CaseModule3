package Controller;

import Const.Keywords;
import DAO.GameDAOImplement;
import Model.Account;
import Model.Game;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(urlPatterns = "/app")
public class AppServlet extends HttpServlet {
    private GameDAOImplement gameDAO;

    @Override
    public void init() throws ServletException {
        gameDAO = new GameDAOImplement();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("app/homepage.jsp");
        dispatcher.forward(req,resp);
    }

    private void showHomepage() {
        ArrayList<Game> tenHotReleasedGames = gameDAO.getGamesGroupBy(Keywords.SELECT_10_HOT_RELEASED_GAMES);
        ArrayList<Game> tenTopSellers = gameDAO.getGamesGroupBy(Keywords.SELECT_10_TOP_SELLERS);
        ArrayList<Game> tenTopUpcomingGaames = gameDAO.getGamesGroupBy(Keywords.SELECT_10_HOT_UPCOMING_GAMES);
    }
}
