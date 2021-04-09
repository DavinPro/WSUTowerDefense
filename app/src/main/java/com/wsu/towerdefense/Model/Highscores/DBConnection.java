package com.wsu.towerdefense.Model.Highscores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getDBCon() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String userName = "GroupLogin";
            String port = "3306";
            String password = "Towerdefense321";
            String dbName = "HighscoresTest";
            String hostname = "databaseclassdb.cznsvkc1cyzq.us-east-1.rds.amazonaws.com";

            String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;

            return DriverManager.getConnection(jdbcUrl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getDBCon(String dbName) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String userName = "GroupLogin";
            String port = "3306";
            String password = "Towerdefense321";
            String hostname = "databaseclassdb.cznsvkc1cyzq.us-east-1.rds.amazonaws.com";

            String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;

            return DriverManager.getConnection(jdbcUrl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}