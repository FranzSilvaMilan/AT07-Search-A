/*
 * @(#)AssetFile.java
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

package com.fundation.search.model;

/**
 *
 */
public class AssetFile {
    private String path;
    private String fileName;
    private long size;
    private boolean ishidden;

    public AssetFile(String path, String fileName, long size, boolean ishidden) {
        this.path = path;
        this.fileName = fileName;
        this.size = size;
        this.ishidden = ishidden;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    private int operator;

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public boolean getIsIshidden() {
        return ishidden;
    }

    public void setIshidden(boolean ishidden) {
        this.ishidden = ishidden;
    }
}
