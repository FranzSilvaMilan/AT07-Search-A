package com.fundation.search;


import com.fundation.search.controller.Controller;
import com.fundation.search.utils.LoggerSearch;
import com.fundation.search.database.SearchConnection;

public class Main {


    public static void main(String[] args) {
        SearchConnection.getInstance();
        LoggerSearch.getInstance().getLogger().info(Main.class.toString().concat(":into"));
        new Controller();
        LoggerSearch.getInstance().getLogger().info("main : fin");
    }
}
