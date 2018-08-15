package com.fundation.search.controller;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestController {
    private  Criteria criteria;

    @Before
    public void setUp(){
        criteria = new Criteria();
    }
    @Test
    public void testCriteria(){
        criteria.setPath("E:\\testFiles");
        ArrayList<String> extensions=new ArrayList<>();
        extensions.add("mp3");
        extensions.add("txt");
        criteria.setListExtensions(extensions);

        assertEquals(extensions,criteria.getListExtensions());

    }
}