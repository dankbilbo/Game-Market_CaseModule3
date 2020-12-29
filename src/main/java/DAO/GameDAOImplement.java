package DAO;

import Const.Keywords;
import Model.Game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameDAOImplement implements GameDAOInterface{
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(Keywords.JDBC_URL, Keywords.JDBC_USERNAME, Keywords.JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public int insertGame(Game game) throws SQLException {
        int resultUpdate = 0;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Keywords.INSERT_GAME);
            preparedStatement.setString(1,game.getAppType());
            preparedStatement.setString(2,game.getName());
            preparedStatement.setObject(3,game.getReleasedDate());
            preparedStatement.setDouble(4,game.getPrice());
            preparedStatement.setInt(5,game.getDeveloperID());
            preparedStatement.setInt(6,game.getPublisherID());
            resultUpdate = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultUpdate;
    }

    @Override
    public Game selectGame(int id) {
        return null;
    }

    @Override
    public boolean deleteGame(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateGame(int id, Game game) throws SQLException {
        return false;
    }
}
