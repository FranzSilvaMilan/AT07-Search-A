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

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This class ValidatorData can be valid, MultimediaResult and maybe SearchFolder.
 *
 * @author Denis Camacho - AT-[07].
 * @version 1.0.
 */

public class ValidatorData {
    /**
     * @param path is the directory of files.
     * @return if is valid or no.
     */
    public boolean isPathValid(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * @param size verify if data is integer or no.
     * @return if is valid or no.
     */
    public boolean isSizeValid(String size) {

        try {
            return Integer.parseInt(size) > 0;

        } catch (NumberFormatException excepcion) {
            return false;
        }
    }

    /**
     * @param date verify date.
     * @return id date is valid or no.
     */
    public boolean isDateValid(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            dateFormat.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
