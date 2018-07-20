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

/**
 * This class is a object that have a criterias for search.
 *
 * @author Franz Silva - AT-[07].
 * @version 1.0.
 */
public class Criteria {

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
}
