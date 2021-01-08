package Const;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Keywords {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/casestudymodule3?useSSL=false";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD = "1234";

    public static final String SELECT_ACCOUNT = "select * from accounts where username=? and password =?;";
    public static final String INSERT_ACCOUNT = "insert into accounts" +
            "(username,password,email,bankAccountId,country) " +
            "value(?,?,?,?,?);";
    public static final String SELECT_GAMES = "select * from games";
    public static final String SELECT_10_TOP_SELLERS = "select games.id, games.name, games.releasedDate,count(games.id) as owned, games.price, games.discount" +
            "from games" +
            "join gameorderdetails as god on games.id = god.id" +
            "join gameorder on gameorder.id = god.gameorderid" +
            "where gameorder.daybought >= (now() - interval 7 day)" +
            "group by games.id" +
            "order by count(games.id) desc" +
            "limit 10; ";
    public static final String SELECT_All_TOP_SELLERS = "select games.id, games.name, games.releasedDate,count(games.id) as owned, games.price, games.discount" +
            "from games" +
            "join gameorderdetails as god on games.id = god.id" +
            "join gameorder on gameorder.id = god.gameorderid" +
            "where gameorder.daybought >= (now() - interval 7 day)" +
            "group by games.id" +
            "order by count(games.id) desc;" ;
    public static final String SELECT_10_NEW_RELEASED_GAME = "select * " +
            "from games " +
            "where releasedDate >= (now() - interval 7 day) " +
            "order by releasedDate desc" +
            "limit 10;";
    public static final String SELECT_ALL_GAMES_ORDER_BY_RELEASED_DATE = "select * from games order by releasedDate DESC;";
    public static final String SELECT_10_HOT_RELEASED_GAMES = "select games.id, games.name,games.releasedDate,count(games.id) as owned, games.price, games.discount" +
            "from games" +
            "join gameorderdetails as god on god.gameid = games.id" +
            "join gameorder on gameorder.id = god.gameorderid" +
            "where gameorder.daybought >= (now() - interval 7 day)" +
            "group by games.id" +
            "order by owned desc"+
            "limit 10;";
    public static final String SELECT_10_HOT_UPCOMING_GAMES = "select games.id, games.name,games.releasedDate,count(games.id) as preordered, games.price, games.discount" +
            "from games" +
            "join gameorderdetails as god on god.gameid = games.id" +
            "join gameorder on gameorder.id = god.gameorderid" +
            "where games.releasedDate > now()" +
            "group by games.id" +
            "order by preordered desc" +
            "limit 10;";
    public static final String SELECT_ALL_UPCOMING_GAMES = "select * from games where releasedDate >= now();";
    public static final String INSERT_GAME = "insert into games" +
            "(appType,name,releasedDate,price,developerName,publisherName)" +
            "value(?,?,?,?,?,?);";
}
