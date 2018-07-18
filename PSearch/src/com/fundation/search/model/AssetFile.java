/*
 * @(#)Search.java
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
 * This class Search for four critearias path, name, size  and hidden.
 *
 * @author Denis Camacho - AT-[07].
 * @version 1.0.
 */
public class AssetFile {
    /**
     * This path contain the path of files.
     */
    private String path;
    /**
     * This size contain the size of files.
     */
    private long size;
    /**
     * fileName contain the name of files.
     */
    private String fileName;
    /**
     * ext contain the extension of files.
     */
    private String ext;
    /**
     * select contain the decision about search.
     */
    private String select;
    /**
     * hidden variable we said if file is hidden or no.
     */
    private boolean hidden;

    /**
     * @return the path.
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path is the directory.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return size of file.
     */
    public long getSize() {
        return size;
    }

    /**
     * @param size of file.
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * @return fileName of the file.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return extension of file.
     */
    public String getExt() {
        return ext;
    }

    /**
     * @param ext.
     */
    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     * @return if file is hidden or no.
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * @param hidden.
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * @return select of option.
     */
    public String getSelect() {
        return select;
    }

    /**
     * @param select.
     */
    public void setSelect(String select) {
        this.select = select;
    }
}
