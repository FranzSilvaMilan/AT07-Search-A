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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:search.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Statement state = null;
        try {
            state = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            state.execute("create table if not exists Criteria(id integer, criteriaJSON varchar(300), primary key(id));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
