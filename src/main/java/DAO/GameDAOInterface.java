package DAO;

import Model.Game;

import java.sql.SQLException;

public interface GameDAOInterface {
    public int insertGame(Game game) throws SQLException;
    public Game selectGame(int id);
    public boolean deleteGame(int id) throws SQLException;
    public boolean updateGame(int id,Game game)throws SQLException;
}
