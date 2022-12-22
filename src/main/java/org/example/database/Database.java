package org.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection DbConn() {

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://babar.db.elephantsql.com/hbxjswcz",
                    "hbxjswcz",
                    "eGjFxNZztQ5Hf0QnPjf3qLz6OYK5z1uH");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
