/**
 * @(#)Convert.java Copyright (c) 2018 Jala Foundation.
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

import static junit.framework.TestCase.assertEquals;
/**
 * This class Convert can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Denis Camacho - AT-[07].
 * @version 1.0.
 */

/**
 * This class is the class main od test.
 */
public class TestConvert {
    // convert is the object with work the methods.
    private Convert convert;

    /**
     * In this method it was init the object.
     */
    @Before
    public void ini() {
        convert = new Convert();
    }

    /**
     * this method is for valid of method convertTOLong.
     */
    @Test
    public void testConvertSizePass() {
        final String[] size = {"Gb", "Mb", "Kb", "byte"};
        int value = 1;
        long spectedResult[] = {1073741824, 1048576, 1024, 1};
        assertEquals(spectedResult[0], convert.convertTOLong(value, size[0]));
        assertEquals(spectedResult[1], convert.convertTOLong(value, size[1]));
        assertEquals(spectedResult[2], convert.convertTOLong(value, size[2]));
        assertEquals(spectedResult[3], convert.convertTOLong(value, size[3]));
    }

    /**
     * this method is for valid the method convertTOWay.
     */
    @Test
    public void testConvertTOWayePass() {
        final String[] way = {">", "<", "="};
        int spectedResult[] = {1, 2, 0};
        assertEquals(spectedResult[0], convert.convertTOWay(way[0]));
        assertEquals(spectedResult[1], convert.convertTOWay(way[1]));
        assertEquals(spectedResult[2], convert.convertTOWay(way[2]));
    }
}
