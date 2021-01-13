package DAO;

import Const.Keywords;
import Model.Company;
import Model.Game;

import java.sql.*;
import java.util.ArrayList;

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
    public ArrayList<Game> getAllGame() {
        ArrayList<Game> games = new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Keywords.SELECT_ALL_GAMES);
            while (rs.next()){
                int id = rs.getInt("id");
                String appType = rs.getString("appType");
                String name = rs.getString("name");
                Date releasedDate = rs.getDate("releasedDate");
                double price = rs.getDouble("price");
                int discount = rs.getInt("discount");
                int developerId = rs.getInt("developerId");
                String devName = rs.getString("devname");
                int publisherId = rs.getInt("publisherId");
                String pubName = rs.getString("pubname");
                String logoURl = rs.getString("logoURL");
                String imgURL = rs.getString("imgURL");
                Game game = new Game(id,appType,name,new Company(developerId,devName),new Company(publisherId,pubName),releasedDate,price,discount,logoURl,imgURL);
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
            preparedStatement.setString(5, game.getDeveloper().getName());
            preparedStatement.setString(6, game.getPublisher().getName());
            resultUpdate = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultUpdate;
    }

    @Override
    public Game selectGame(int id) {
        Game game = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Keywords.SELECT_GAME);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String appType = rs.getString("appType");
                String name = rs.getString("name");
                Date releasedDate = rs.getDate("releasedDate");
                double price = rs.getDouble("price");
                int discount = rs.getInt("discount");
                int developerId = rs.getInt("developerId");
                String devName = rs.getString("devname");
                int publisherId = rs.getInt("publisherId");
                String pubName = rs.getString("pubname");
                String logoURl = rs.getString("logoURL");
                String imgURL = rs.getString("imgURL");
                game = new Game(id,appType,name,new Company(developerId,devName),new Company(publisherId,pubName),releasedDate,price,discount,logoURl,imgURL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return game;
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
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date releasedDate =  rs.getDate("releasedDate");
                int numberOwned = rs.getInt(4);
                double price = rs.getDouble("price");
                int discount = rs.getInt("discount");
                price = price - price * discount / 100;
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

    @Override
    public ArrayList<Game> getGamesByName(String name) {
        ArrayList<Game> games = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Keywords.SELECT_GAME_BY_NAME);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                name = rs.getString("name");
                String appType = rs.getString("appType");
                Date releasedDate = rs.getDate("releasedDate");
                double price = rs.getDouble("price");
                int discount = rs.getInt("discount");
                int developerId = rs.getInt("developerId");
                String devName = rs.getString("devname");
                int publisherId = rs.getInt("publisherId");
                String pubName = rs.getString("pubname");
                String logoURl = rs.getString("logoURL");
                String imgURL = rs.getString("imgURL");
                Game game = new Game(id,appType,name,new Company(developerId,devName),new Company(publisherId,pubName),releasedDate,price,discount,logoURl,imgURL);
                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

}
