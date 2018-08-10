package com.fundation.search.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchConnection {
    private static SearchConnection searchConnection;
    private static Connection connection;

    private SearchConnection() {
        init();
    }

    public static SearchConnection getInstance() {
        if (searchConnection == null) {
            searchConnection = new SearchConnection();
        }
        return searchConnection;
    }

    private void init() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:search.db");
            Statement state = null;
            state = connection.createStatement();
            state.execute("create table if not exists Criteria(id integer, criteriaJSON varchar(300), nameCriteria varchar(50), primary key(id));");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
