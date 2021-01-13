package Controller;

import Const.Keywords;
import DAO.CompanyDAO;
import DAO.GameDAOImplement;
import Model.Account;
import Model.Company;
import Model.Game;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/app")
public class AppServlet extends HttpServlet {
    private GameDAOImplement gameDAO;
    private CompanyDAO companyDAO;
    @Override
    public void init() throws ServletException {
        gameDAO = new GameDAOImplement();
        companyDAO = new CompanyDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "view":
                view(request,response);
                break;
            case "search":
                search(request,response);
                break;
            default:
                showHomepage(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view":
                view(req,resp);
                break;
            case "search":
                search(req,resp);
                break;
            default:
                showHomepage(req,resp);
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("namesearch");
        name = "%" + name + "%";
        ArrayList<Company> companies = companyDAO.getAllCompany();
//        ArrayList<String> appTypes = gameDAO.
        req.setAttribute("listCompany",companies);
        ArrayList<Game> allGames = gameDAO.getAllGame();
        ArrayList<Game> searchedGames =  gameDAO.getGamesByName(name);
        if (name .equals("%null%") || name.equals("%%") || searchedGames.size() == 0){
            req.setAttribute("listGame", allGames);
            RequestDispatcher dispatcher = req.getRequestDispatcher("app/search.jsp");
            dispatcher.forward(req,resp);
        }else {
            req.setAttribute("listGame", searchedGames);
            RequestDispatcher dispatcher = req.getRequestDispatcher("app/search.jsp");
            dispatcher.forward(req,resp);
        }
    }

    private void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Game game = gameDAO.selectGame(id);
        req.setAttribute("game",game);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/app/game.jsp");
        dispatcher.forward(req,resp);
    }

    private void showHomepage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Game> tenHotReleasedGames = gameDAO.getGamesGroupBy(Keywords.SELECT_10_HOT_RELEASED_GAMES);
        ArrayList<Game> tenTopSellers = gameDAO.getGamesGroupBy(Keywords.SELECT_10_TOP_SELLERS_7_DAYS);
        ArrayList<Game> tenTopUpcomingGames = gameDAO.getGamesGroupBy(Keywords.SELECT_10_HOT_UPCOMING_GAMES);
        req.setAttribute("tenHotReleasedGames",tenHotReleasedGames);
        req.setAttribute("tenTopSellers",tenTopSellers);
        req.setAttribute("tenTopUpcomingGames",tenTopUpcomingGames);
        RequestDispatcher dispatcher = req.getRequestDispatcher("app/homepage.jsp");
        dispatcher.forward(req,resp);
    }
}
