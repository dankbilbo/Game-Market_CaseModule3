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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

@WebServlet(urlPatterns = "/app")
public class AppServlet extends HttpServlet {
    private GameDAOImplement gameDAO;
    private CompanyDAO companyDAO;
    HttpSession session = null;
    @Override
    public void init() throws ServletException {
        gameDAO = new GameDAOImplement();
        companyDAO = new CompanyDAO();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "view":
                view(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "viewgamesowned":
                viewGameOwned(request,response);
                break;
            default:
                showHomepage(request, response);
        }
    }

    private void viewGameOwned(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account) session.getAttribute("account");
        LinkedHashMap<Game,Integer> gamesOwned = gameDAO.getGamesOwned(account);
        request.setAttribute("gamesOwned",gamesOwned);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/app/gamesowned.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                search(req, resp);
                break;
            default:
                showHomepage(req, resp);
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("namesearch");
        String devId = req.getParameter("dev");
        String releasedDate = req.getParameter("releaseddate");
        String price = req.getParameter("price");
        String appType = req.getParameter("apptype");
        String discount = req.getParameter("discount");
        String queryDev = (devId == null || devId.equals("")) ? "" : " and (developerId =" +devId + " or publisherId =" + devId + ")";
        String queryAppType = (appType == null || appType.equals("")) ? "" : " and appType = '" + appType + "'";
        String queryName = null;
        if (name == null){
            queryName = "true";
        }else if (name.equals("")){
            queryName = "true";
        }else{
            queryName = "name like '%" + name +"%'";
        }
        if (releasedDate == null){
            releasedDate = "";
        }
        if (price == null){
            price = "";
        }
        if (discount == null){
            discount = "";
        }
        String queryReleasedDate =  null;
        String queryPrice = null;
        String queryDiscount = null;
        if (releasedDate == null){
            queryReleasedDate = "";
        }
        if (price == null){
            queryPrice = "";
        }
        if (discount == null){
            queryDiscount = "";
        }
        switch (releasedDate) {
            case "1":
                queryReleasedDate = " and releasedDate > now()";
                break;
            case "2":
                queryReleasedDate = " and releasedDate >= (now() - interval 1 month) and releasedDate <= now()";
                break;
            case "3":
                queryReleasedDate = " and releasedDate >= (now() - interval 1 year) and releasedDate <= now()";
                break;
            case "4":
                queryReleasedDate = " and releasedDate < (now() - interval 1 year)";
                break;
            default:
                queryReleasedDate = "";
        }
        switch (price) {
            case "1":
                queryPrice = " and price = 0";
                break;
            case "2":
                queryPrice = " and price < 5";
                break;
            case "3":
                queryPrice = " and price between 5 and 10";
                break;
            case "4":
                queryPrice = " and price > 10";
                break;
            default:
                queryPrice = "";

        }
        switch (discount) {
            case "1":
                queryDiscount = " and discount <= 25 and discount > 0";
                break;
            case "2":
                queryDiscount = " and discount > 25 and discount <= 50";
                break;
            case "3":
                queryDiscount = " and discount > 50";
                break;
            default:
                queryDiscount = "";
        }
        String query = "select * from all_games where " + queryName + queryDev + queryAppType + queryDiscount + queryPrice + queryReleasedDate + ";";
        ArrayList <Company> companies = companyDAO.getAllCompany();
        ArrayList<String> appTypes = gameDAO.getAllAppTypes();
        req.setAttribute("listCompany", companies);
        req.setAttribute("appTypes", appTypes);
        ArrayList<Game> searchedGames = gameDAO.searchGames(query);
        req.setAttribute("listGame", searchedGames);
        RequestDispatcher dispatcher = req.getRequestDispatcher("app/search.jsp");
        dispatcher.forward(req, resp);

    }

    private void view(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Game game = gameDAO.selectGame(id);
        req.setAttribute("game", game);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/app/game.jsp");
        dispatcher.forward(req, resp);
    }

    private void showHomepage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Game> tenHotReleasedGames = gameDAO.getGamesGroupBy(Keywords.SELECT_10_HOT_RELEASED_GAMES);
        ArrayList<Game> tenTopSellers = gameDAO.getGamesGroupBy(Keywords.SELECT_10_TOP_SELLERS_7_DAYS);
        ArrayList<Game> tenTopUpcomingGames = gameDAO.getGamesGroupBy(Keywords.SELECT_10_HOT_UPCOMING_GAMES);
        req.setAttribute("tenHotReleasedGames", tenHotReleasedGames);
        req.setAttribute("tenTopSellers", tenTopSellers);
        req.setAttribute("tenTopUpcomingGames", tenTopUpcomingGames);
        RequestDispatcher dispatcher = req.getRequestDispatcher("app/homepage.jsp");
        dispatcher.forward(req, resp);
    }
}
