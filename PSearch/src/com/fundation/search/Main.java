package com.fundation.search;


import com.fundation.search.controller.Controller;
import com.fundation.search.utils.LoggerSearch;

public class Main {


    public static void main(String[] args){
        LoggerSearch.getInstance().getLogger().info("main : inicio");
        new Controller();
        LoggerSearch.getInstance().getLogger().info("main : fin");
    }
}
