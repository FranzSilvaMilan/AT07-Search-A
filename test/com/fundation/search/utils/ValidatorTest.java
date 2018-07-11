package com.fundation.search.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * This is the main class test.
 */
public class ValidatorTest {
    private Validator data;

    /**
     *init the object.
     */
    @Before
    public void before() {
        data = new Validator();
    }

    /**
     * test.
     */
    @Test
    public void testValidator() {
        final String path = "H:\\videos_musicales";
        assertTrue(data.isPathValidation(path));

    }

}
