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
    public Account getAccount(String username) {
        Account account = new Account();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Keywords.SELECT_ACCOUNT);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String password = rs.getString("password");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String bankAccountId = rs.getString("bankAccountId");
                account.setUsername(username);
                account.setPassword(password);
                account.setEmail(email);
                account.setBankAccountNumber(bankAccountId);
                account.setCountry(country);
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
            resultUpdate = preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultUpdate;
    }

//    @Override
//    public boolean updateAccount(String username, Account account) {
//        return false;
//    }


}
