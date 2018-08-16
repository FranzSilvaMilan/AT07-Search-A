/*
 * @(#)SearchConnection.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.fundation.search.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * This class SearchConnection make connection to data base.
 *
 * @author Denis Camacho AT-07.
 * @version 1.0.
 */
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
