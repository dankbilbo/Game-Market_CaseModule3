package DAO;

import Const.Keywords;
import Model.Company;
import Model.Game;

import java.sql.*;
import java.util.ArrayList;

public class CompanyDAO {
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

    public ArrayList<Company> getAllCompany() {

        ArrayList<Company> companies = new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(Keywords.SELECT_ALL_COMPANY);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String companyURL = rs.getString("url");
                Company company = new Company(id, name, companyURL);
                companies.add(company);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }

}
