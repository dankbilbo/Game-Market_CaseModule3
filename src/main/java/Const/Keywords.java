package Const;

public class Keywords {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/casestudymodule3?useSSL=false";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD = "1234";

    public static final String SELECT_ACCOUNT = "select id,username,password,email,country,bankAccountId from accounts where username=?";
    public static final String INSERT_ACCOUNT = "insert into accounts" +
            "(username,password,email,bankAccountId,country) " +
            "value(?,?,?,?,?);";
    public static final String SELECT_GAMES = "select * from games";
    public static final String INSERT_GAME = "insert into games" +
            "(appType,name,releasedDate,price,developerName,publisherName)" +
            "value(?,?,?,?,?,?);";
}
