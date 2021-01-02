package DAO;

import Model.Game;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GameDAOInterface {
    public ArrayList<Game> getAllGame();
    public int insertGame(Game game) throws SQLException;
    public Game selectGame(int id);
    public boolean deleteGame(int id) throws SQLException;
    public boolean updateGame(int id,Game game)throws SQLException;
}
