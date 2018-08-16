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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    /**
     * this method test convert long for show on table.
     */
    @Test
    public void testConvertTOLongShow() {
        long numerActual = 100;
        double expectedMb = numerActual;
        expectedMb /= (1024 * 1024);
        double expectedGb = numerActual;
        expectedGb /= (1024 * 1024 * 1024);
        double expecteBy = numerActual;
        double expectedKb = numerActual;
        expectedKb /= 1024;
        String unitMb = "Mb";
        String unitGb = "Gb";
        String unitKb = "Kb";
        String unitBytes = "bytes";
        assertEquals(expecteBy, convert.convertTOLongShow(numerActual, unitBytes));
        assertEquals(expectedKb, convert.convertTOLongShow(numerActual, unitKb));
        assertEquals(expectedMb, convert.convertTOLongShow(numerActual, unitMb));
        assertEquals(expectedGb, convert.convertTOLongShow(numerActual, unitGb));
    }

    /**
     * this method test convert Date To String.
     */
    @Test
    public void testConvertDateToString() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateTest = "08/10/2018";
        Date newDate = formatter.parse(dateTest);
        String stringExpected = "08/10/2018";
        assertEquals(stringExpected, convert.convertDateToString(newDate));
        assertEquals("",convert.convertDateToString(null));
    }

    /**
     * this method test convert string to date.
     */
    @Test
    public void testConvertStringToDate() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String stringDateExpected = "08/10/2018";
        Date dateExpected = formatter.parse(stringDateExpected);
        assertEquals(dateExpected,convert.convertStringToDate(stringDateExpected));
        assertEquals(null,convert.convertStringToDate(null));
    }

    /**
     * this method test date to date init for day.
     */
    @Test
    public void testConvertDateToDateIni() {
        assertEquals(null,convert.convertDateToDateIni(null));

    }

    /**
     * this method is for valid the method convertTOWay.
     */
    @Test
    public void testConvertDateToDateFin() {
        assertEquals(null,convert.convertDateToDateFin(null));
    }

    public void testConvertTimeDurationToDouble() {

    }

    public void testConvertTimeDurationToDoubleShow() {

    }

    public void testConvertTimeDurationToDoubleReverse() {

    }
}
