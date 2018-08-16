/**
 * @(#)ValidatorData.java Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.fundation.search.utils;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


/**
 * This class Convert can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Denis Camacho - AT-[07].
 * @version 1.0.
 */

/**
 * This class is the class main od test.
 */
public class ValidatorDataTest {
    //data is the object with work the methods.
    private ValidatorData data;

    /**
     * In this method it was init the object.
     */
    @Before
    public void setUp() {
        data = new ValidatorData();
    }

    /**
     * this method is for valid the method isPathValid.
     */
    @Test
    public void testPathValidPass() {
        final String path = "C:\\";
        assertTrue(data.isPathValid(path));
    }

    /**
     * this method is for valid the method isSizeValid.
     */
    @Test
    public void testSizeValidPass() {
        final String size = "20";
        assertTrue(data.isSizeValid(size));
        assertFalse(data.isSizeValid("2a"));
    }

    /**
     * this method is for valid method isDateValid.
     */
    @Test
    public void testDateValidPass() {
        final String date = "12/12/2018";
        final String dateInvalid = "13/13/2018";
        assertTrue(data.isDateValid(date));
        assertFalse(data.isDateValid(dateInvalid));
    }
}
