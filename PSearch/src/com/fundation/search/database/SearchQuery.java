package com.fundation.search.database;


import java.sql.*;

public class SearchQuery {
    private Connection connection;

    public SearchQuery() {
        connection = SearchConnection.getInstance().getConnection();
    }

    public void insertCriteria(String criteriaJSON) {
        String insert = "insert into criteria  values(?, ?);";
        PreparedStatement pre = null;
        try {
            pre = connection.prepareStatement(insert);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pre.setString(2, criteriaJSON);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllCriteria() {

        Statement state = null;
        try {
            state = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet set = null;
        try {
            set = state.executeQuery("Select id, criteriaJSON from criteria");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

}
