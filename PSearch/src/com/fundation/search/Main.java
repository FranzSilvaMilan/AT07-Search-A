package com.fundation.search;


import com.fundation.search.controller.Controller;
import com.fundation.search.controller.Criteria;
import com.fundation.search.model.AssetFile;
import com.fundation.search.model.Search;

import java.util.List;

public class Main {


    public static void main(String[] args){
       /* System.out.println("hola mundo");
        Search search = new Search();
        Criteria critera = new Criteria("C:\\Users\\Omen\\Desktop\\fundacion_jala\\modulo 2\\PROGRA 102\\testFiles","a",0,true);
        search.searchByCriteria(critera);
        List<AssetFile> result = search.getResult();

        for(int i= 0;i<result.size();i++){
            System.out.println(result.get(i).getPath()+ " " + result.get(i).getFileName());
        }*/
        Controller controller=new Controller();
    }
}
