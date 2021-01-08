package DAO;

import Const.Keywords;
import Model.Game;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameDAOImplement implements GameDAOInterface {
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
    public ArrayList<Game> getAllGame(String query) {
        ArrayList<Game> games = new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt(1);
                String appType = rs.getString(2);
                String name = rs.getString(3);
                LocalDate releasedDate = (LocalDate) rs.getObject(4);
                double price = rs.getDouble(5);
                String developerName = rs.getString(6);
                String publisherName = rs.getString(7);
                int discount = rs.getInt(8);
                price = price * discount / 100;
                Game game = new Game(id,appType,name,developerName,publisherName,releasedDate,price,discount);
                games.add(game);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public int insertGame(Game game) throws SQLException {
        int resultUpdate = 0;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Keywords.INSERT_GAME);
            preparedStatement.setString(1, game.getAppType());
            preparedStatement.setString(2, game.getName());
            preparedStatement.setObject(3, game.getReleasedDate());
            preparedStatement.setDouble(4, game.getPrice());
            preparedStatement.setString(5, game.getDeveloper());
            preparedStatement.setString(6, game.getPublisher());
            resultUpdate = preparedStatement.executeUpdate();
        } catch (SQLException e) {
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

    @Override
    public ArrayList<Game> getGamesGroupBy(String query) {
        ArrayList<Game> games = new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                LocalDate releasedDate = (LocalDate) rs.getObject(3);
                int numberOwned = rs.getInt(4);
                double price = rs.getDouble(5);
                int discount = rs.getInt(6);
                price = price * discount / 100;
                Game game = new Game();
                game.setId(id);
                game.setName(name);
                game.setDiscount(discount);
                game.setReleasedDate(releasedDate);
                game.setNumberUserOwned(numberOwned);
                game.setPrice(price);
                games.add(game);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }


}
