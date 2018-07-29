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


import java.util.ArrayList;

/**
 * This class is a object that have a criterias for search.
 *
 * @author Franz Silva - AT-[07].
 * @author ketty Camacho -AT[07].
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
    private String operator;
    /**
     * this is a owner.
     */
    private String owner;
    /**
     * this is a list about extensions.
     */
    private ArrayList<String> listExtensions;
    /**
     * contais if select folder.
     */
    private boolean directory;
    /**
     * this variable is a date Craete From.
     */
    private String dateCreateFrom;
    /**
     * this variable contains date Create TO.
     */
    private String dateCreateTo;
    /**
     * this variable contains date Modificate From.
     */
    private String dateModificateFrom;
    /**
     * this varaible contains date Modificate To.
     */
    private String dateModificateTo;
    /**
     * this variable contains date Access From.
     */
    private String dateAccessFrom;
    /**
     * this variable contains date Access To.
     */
    private String dateAccessTo;
    /**
     * this cariable contains if is keySensitive.
     */
    private boolean keySensitive;
    /**
     * this variable contains  is file is redOnly.
     */
    private boolean readOnly;
    /**
     * this variable contains the word if search on into file.
     */
    private String content;

    /**
     * this  is a constuctot.
     */
    Criteria() {
        listExtensions = new ArrayList<>();
    }

    /**
     * this method get
     *
     * @return vauel of variable
     */
    public String getDateCreateFrom() {
        return dateCreateFrom;
    }
    /**
     * set a new value.
     *
     * @param dateCreateFrom with a new value.
     */
    public void setDateCreateFrom(String dateCreateFrom) {
        this.dateCreateFrom = dateCreateFrom;
    }

    /**
     * this method get date Create Ini.
     *
     * @return value of variable
     */
    public String getDateCreateTo() {
        return dateCreateTo;
    }
    /**
     * set a new value.
     *
     * @param dateCreateTo with a new value.
     */
    public void setDateCreateTo(String dateCreateTo) {
        this.dateCreateTo = dateCreateTo;
    }

    /**
     * this method get date modify ini.
     *
     * @return valueof variable
     */
    public String getDateModificateFrom() {
        return dateModificateFrom;
    }
    /**
     * set a new value.
     *
     * @param dateModificateFrom with a new value.
     */
    public void setDateModificateFrom(String dateModificateFrom) {
        this.dateModificateFrom = dateModificateFrom;
    }

    /**
     * this method get date modify fin.
     *
     * @return value of variable
     */
    public String getDateModificateTo() {
        return dateModificateTo;
    }
    /**
     * set a new value.
     *
     * @param dateModificateTo with a new value.
     */
    public void setDateModificateTo(String dateModificateTo) {
        this.dateModificateTo = dateModificateTo;
    }

    /**
     * this method get date access ini.
     *
     * @return value of variable
     */
    public String getDateAccessFrom() {
        return dateAccessFrom;
    }
    /**
     * set a new value.
     * @param dateAccessFrom with a new value.
     */
    public void setDateAccessFrom(String dateAccessFrom) {
        this.dateAccessFrom = dateAccessFrom;
    }

    /**
     * this method get date of access fin.
     *
     * @return value of variable
     */
    public String getDateAccessTo() {
        return dateAccessTo;
    }
    /**
     * set a new value.
     *
     * @param dateAccessTo with a new value.
     */
    public void setDateAccessTo(String dateAccessTo) {
        this.dateAccessTo = dateAccessTo;
    }

    /**
     * this method get is
     *
     * @return vauel of variable
     */
    public boolean getDirectory() {
        return directory;
    }
    /**
     * set a new value.
     *
     * @param directory with a new value.
     */
    public void setDirectory(boolean directory) {
        this.directory = directory;
    }

    /**
     * this method get value if is read only.
     *
     * @return  true if user selecct.
     */
    public boolean getReadOnly() {
        return readOnly;
    }
    /**
     * set a new value.
     *
     * @param readOnly with a new value.
     */
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    /**
     * this method get if is key sentive the word.
     *
     * @return value of variable
     */
    public boolean isKeySensitive() {
        return keySensitive;
    }
    /**
     * set a new value.
     *
     * @param keySensitive with a new value.
     */
    public void setKeySensitive(boolean keySensitive) {
        this.keySensitive = keySensitive;
    }

    /**
     * this method get the word that will search.
     *
     * @return value of variable.
     */
    public String getContent() {
        return content;
    }
    /**
     * set a new value.
     *
     * @param content with a new value.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * this method get
     *
     * @return value of variable
     */
    public String getOwner() {
        return owner;
    }
    /**
     * set a new value.
     *
     * @param owner with a new value.
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * this method get list of extensions.
     *
     * @return list of selecced.
     */
    public ArrayList<String> getListExtensions() {
        return listExtensions;
    }
    /**
     * set a new value.
     *
     * @param listExtensions  with a new value.
     */
    public void setListExtensions(ArrayList<String> listExtensions) {
        this.listExtensions = listExtensions;
    }


    /**
     * method that get operator.
     *
     * @return operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * method that modify  variable operator.
     *
     * @param operator is a new value
     */
    public void setOperator(String operator) {
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
     * @param fileName with a new value.
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
