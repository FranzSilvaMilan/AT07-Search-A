/*
 * @(#)SearchQuery.java
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
import java.sql.*;
/**
 * This class SearchQuery make insert to the data base.
 *
 * @author Denis Camacho AT-07.
 * @version 1.0.
 */
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
