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
     * fileName contain the name of files.
     */
    private String fileName;
    /**
     * This size contain the size of files.
     */
    private long size;
    /**
     * hidden variable we said if file is hidden or no.
     */
    private boolean isHidden;
    /**
     * ext contain the extension of files.
     */
    private String extension;
    /**
     * dateCreation is date of file.
     */
    private String dateCreation;
    /**
     * dateModified is date of file.
     */
    private String dateModified;
    /**
     * owner of file.
     */
    private String owner;

    /**
     * @return size of search.
     */
    public long getSize() {
        return size;
    }

    /**
     * @param size set of search.
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * @return fileNme of search.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName set of search.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return path of search.
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path set of search.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return is hidden or no.
     */

    public boolean getIsIsHidden() {
        return isHidden;
    }

    /**
     * @param isHidden set isHidden.
     */
    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    /**
     * @return the extension of file.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param extension set.
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * @return date current.
     */
    public String getDateCreate() {
        return dateCreation;
    }

    /**
     * @param date set.
     */
    public void setDateCreate(String date) {
        this.dateCreation = date;
    }

    /**
     * @return the owner
     */
    public String getOwner1() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner1(String owner) {
        this.owner = owner;
    }

    /**
     * @return the dateModified
     */
    public String getDateModified() {
        return dateModified;
    }

    /**
     * @param dateModified the dateModified to set
     */
    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }
}
