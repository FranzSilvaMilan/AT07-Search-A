/**
 * @(#)LoggerSearch.java Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.fundation.search.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * This class LoggerSearch is by saved all place where enter the program.
 *
 * @author Denis Camacho - AT-[07].
 * @version 1.0.
 */

public class LoggerSearch {
    // logSearch is the instance of the class LoggerSearch.
    private static LoggerSearch logSearch;
    // log is the logger of where stay the program.
    private Logger log;

    /**
     * This is the builder of class.
     */
    private LoggerSearch() {

        log = Logger.getLogger("LoggerSearch.getName().class");
        PropertyConfigurator.configure("info/log4j.properties");
    }

    /**
     * @return logSearch  init.
     */
    public static LoggerSearch getInstance() {
        if (logSearch == null) {
            logSearch = new LoggerSearch();
        }
        return logSearch;
    }

    /**
     * @return the log the program.
     */
    public Logger getLogger() {
        return log;
    }

}