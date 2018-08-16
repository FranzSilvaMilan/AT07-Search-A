package com.fundation.search.controller;

import com.fundation.search.Main;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class TestController {
    private Criteria criteria;

    /**
     * this method  get  a critera
     */
    @Before
    public void setUp() {
        criteria = new Criteria();
    }

    /**
     * this method get if path is correct.
     */
    @Test
    public void testCriteria() {
        criteria.setPath("E:\\testFiles");
        ArrayList<String> extensions = new ArrayList<>();
        extensions.add("mp3");
        extensions.add("txt");
        criteria.setListExtensions(extensions);

        assertEquals(extensions, criteria.getListExtensions());

    }

    /**
     * this method test that correct init of UI.
     */
    @Test
    public void testController() {
        Main.main(new String[]{});
        new Controller().actionListener();

    }
}