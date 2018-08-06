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

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class Convert can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Denis Camacho - AT-[07].
 * @version 1.0.
 */
public class Convert {
    private static final int MODIFIER = 1024;

    /**
     * @param size   long of file.
     * @param choose of size.
     * @return size in bits.
     */
    public long convertTOLong(long size, String choose) {
        switch (choose) {
            case "Gb":
                size *= MODIFIER * MODIFIER * MODIFIER;
                break;
            case "Mb":
                size *= MODIFIER * MODIFIER;
                break;
            case "Kb":
                size *= MODIFIER;
                break;
        }
        return size;
    }

    /**
     * @param way of size up, down or equals.
     * @return the way take.
     */
    public int convertTOWay(String way) {
        int wayTake = 0;
        switch (way) {
            case ">":
                wayTake = 1;
                break;
            case "<":
                wayTake = 2;
                break;
        }
        return wayTake;
    }

    public String convertDateToString(Date date) {
        String result = "";
        if (date != null) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            result = dateFormat.format(date);
        }
        return result;
    }

    /**
     * @param time     on seconds of a multimedia file.
     * @param unitTime the unit second, minute, hour.
     * @return The duration converted.
     */
    public String convertTimeUnit(double time, String unitTime) {
        StringBuilder buildResult = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (unitTime.equalsIgnoreCase("second")) {
            return buildResult.append(String.valueOf(decimalFormat.format(time))).append(" " + unitTime).toString();
        }
        if (unitTime.equalsIgnoreCase("minute")) {
            return buildResult.append(String.valueOf(decimalFormat.format(time / 60.0))).append(" " + unitTime).toString();
        }
        if (unitTime.equalsIgnoreCase("hour")) {
            return buildResult.append(String.valueOf(decimalFormat.format(time / 3600.0))).append(" " + unitTime).toString();
        }
        return String.valueOf(time);
    }
}
