package com.fundation.search.database;


import java.sql.*;

public class SearchQuery {
    private Connection connection;

    public SearchQuery() {
        connection = SearchConnection.getInstance().getConnection();
    }

    public void insertCriteria(String criteriaJSON, String nameCriterial) {
        String insert = "insert into criteria  values(?, ? , ?);";
        PreparedStatement pre = null;
        try {
            pre = connection.prepareStatement(insert);
            pre.setString(2, criteriaJSON);
            pre.setString(3, nameCriterial);
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getAllCriteria() {

        Statement state = null;
        ResultSet set = null;
        try {
            state = connection.createStatement();
            set = state.executeQuery("Select id, criteriaJSON , nameCriteria from criteria");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return set;
    }

}
