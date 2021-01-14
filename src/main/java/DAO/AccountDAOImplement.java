package DAO;

import Const.Keywords;
import Model.Account;

import java.sql.*;

public class AccountDAOImplement implements AccoutnDAOInterface {

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
    public Account getAccount(String username,String password) {
        Account account = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Keywords.SELECT_ACCOUNT);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                account = new Account();
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String bankAccountId = rs.getString("bankAccountId");
                String role = rs.getString("role");
                account.setUsername(username);
                account.setPassword(password);
                account.setEmail(email);
                account.setBankAccountNumber(bankAccountId);
                account.setCountry(country);
                account.setId(id);
                account.setRole(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public int insertAccount(Account account) {
        int resultUpdate = 0;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Keywords.INSERT_ACCOUNT);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());
            preparedStatement.setString(3,account.getEmail());
            preparedStatement.setString(4,account.getCountry());
            preparedStatement.setString(5,account.getBankAccountNumber());
            preparedStatement.setString(6,account.getRole());
            resultUpdate = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultUpdate;
    }

    @Override
    public int updateAccount(Account account) {
        int resultUpdate = 0;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Keywords.UPDATE_ACCOUNT);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());
            preparedStatement.setString(3,account.getEmail());
            preparedStatement.setString(4,account.getCountry());
            preparedStatement.setString(5,account.getBankAccountNumber());
            preparedStatement.setString(6,account.getRole());
            preparedStatement.setInt(7,account.getId());
            resultUpdate = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultUpdate;
    }


}
