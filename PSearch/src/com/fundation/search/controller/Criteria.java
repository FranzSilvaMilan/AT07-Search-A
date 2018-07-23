/*
 * @(#)Criteria.java
 *
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.fundation.search.controller;

import com.fundation.search.utils.Convert;
import com.fundation.search.view.PanelSearch;

/**
 * This class is a object that have a criterias for search.
 *
 * @author Franz Silva - AT-[07].
 * @author ketty Camacho -AT[07].
 * @version 1.0.
 */
public class Criteria {

    /**
     * this object has some funtion to convert values.
     */
    Convert convert = new Convert();

    /**
     * path of criteria.
     */
    private String path;

    /**
     * fileName of criteria.
     */
    private String fileName;

    /**
     * size of criteria.
     */
    private long size;

    /**
     * status if is hidden of criteria.
     */
    private boolean ishidden;

    /**
     * operator that help search by size.
     */
    private int operator;

    /**
     * method that get operator.
     *
     * @return operator
     */
    public int getOperator() {
        return operator;
    }

    /**
     * method that modify  variable operator.
     *
     * @param operator is a new value
     */
    public void setOperator(int operator) {
        this.operator = operator;
    }

    /**
     * get a size of file.
     *
     * @return size
     */
    public long getSize() {
        return size;
    }

    /**
     * set the size.
     *
     * @param size is a new value.
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * set the file name.
     *
     * @return file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * set file name.
     *
     * @param fileName is a new value.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * this method return get path.
     *
     * @return a path
     */
    public String getPath() {
        return path;
    }

    /**
     * set a new value of varaible path.
     *
     * @param path is a new value of path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * this method get a state hidden.
     *
     * @return value of variable isHidden
     */
    public boolean getIsIshidden() {
        return ishidden;
    }

    /**
     * this method set hidden.
     *
     * @param ishidden new value of hidden
     */
    public void setIshidden(boolean ishidden) {
        this.ishidden = ishidden;
    }

    /**
     * this method has the function to build the criteria model
     *
     * @param panelSearch this is the panel where has the UI components to collect information.
     * @return Criteria with all information populated.
     */
    public Criteria getSearchCriteria(PanelSearch panelSearch) {
        this.setFileName(panelSearch.getTextFile());
        this.setPath(panelSearch.getTextPath());
        this.setOperator(convert.convertTOWay(panelSearch.getOperator()));
        this.setSize(convert.convertTOLong(Long.parseLong(panelSearch.getSpinnerSize().getValue().toString()), panelSearch.getTypeListSize()));

        return this;
    }

    /**
     * This method hast the function to changes the size in bytes according the selected type.
     *
     * @param sizeString   this is the value of the size
     * @param typeListSize this is the value of the extencion of the size e.g. bytes,kb,mb,gb
     * @return value in bytes
     */
    private long getFileSizeByType(String sizeString, String typeListSize) {

        Long size = Long.parseLong(sizeString);

        if (typeListSize.equalsIgnoreCase("bytes"))
            return size;
        if (typeListSize.equalsIgnoreCase("Kb"))
            return size * 1024;
        if (typeListSize.equalsIgnoreCase("Mb"))
            return size * 1024 * 1024;
        if (typeListSize.equalsIgnoreCase("Gb"))
            return size * 1024 * 1024 * 1024;

        return -1;
    }

    /**
     * This method provide the operator in number, e.g. > has a value 0, = has a value 1, and the < has the value 2
     * @param operator string value, where its value is > , = or <
     * @return int value 0,1,2.
     */
    private int getSizeOperator(String operator) {
        if (operator.equalsIgnoreCase(">"))
            return 0;
        if (operator.equalsIgnoreCase("="))
            return 1;
        if (operator.equalsIgnoreCase("<"))
            return 2;
        return -1;
    }
}
