package Const;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Keywords {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/casestudymodule3?useSSL=false";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD = "1234";

    public static final String SELECT_ACCOUNT = "select * from accounts where username=? and password =?;";
    public static final String INSERT_ACCOUNT = "insert into accounts" +
            "(username,password,email,bankAccountId,country,role) " +
            "value(?,?,?,?,?,?);";
    public static final String UPDATE_ACCOUNT = "update accounts set username = ?, password = ?, email = ?, country = ? ,bankAccountId = ? ,role = ? where id = ?;";
    public static final String SELECT_ALL_GAMES = "select * from all_games;";
    public static final String SELECT_ALL_APP_TYPES = "select distinct apptype from games;";
    public static final String SELECT_GAME = "select * from all_games where id=?";
    public static final String SELECT_GAME_BY_NAME = "select * from all_games where name like ?;";
    public static final String GET_GAMES_OWNED = "select * from games_owned where userid = ? ;";
    public static final String SELECT_10_TOP_SELLERS_7_DAYS = "select * from top_sellers_7_days limit 10";
    public static final String SELECT_TOP_SELLERS_ALL_TIME = "select * from top_sellers_all_time" ;
    public static final String SELECT_10_NEW_RELEASED_GAME = "select * from new_released_games limit 10;";
    public static final String SELECT_ALL_GAMES_ORDER_BY_RELEASED_DATE = "select * from games order by releasedDate DESC;";
    public static final String SELECT_10_HOT_RELEASED_GAMES = "select * from hot_released_games_7_days limit 10";
    public static final String SELECT_10_HOT_UPCOMING_GAMES = "select * from top_upcoming_games limit 10;";
    public static final String SELECT_ALL_UPCOMING_GAMES = "select * from games where releasedDate >= now() order by releasedDate asc;";
    public static final String INSERT_GAME = "insert into games" +
            "(appType,name,releasedDate,price,developerName,publisherName)" +
            "value(?,?,?,?,?,?);";
    public static final String SELECT_ALL_COMPANY = "select * from company";
}
