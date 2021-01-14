package DAO;

import Model.Game;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface GameDAOInterface {
    public ArrayList<Game> getAllGame();
    public int insertGame(Game game) throws SQLException;
    public Game selectGame(int id);
    public boolean deleteGame(int id) throws SQLException;
    public boolean updateGame(int id,Game game)throws SQLException;
    public ArrayList<Game> getGamesGroupBy(String query);
    public ArrayList<Game> getGamesByName(String name);
    public ArrayList<Game> searchGames(String query);
    public ArrayList<String> getAllAppTypes();
}
