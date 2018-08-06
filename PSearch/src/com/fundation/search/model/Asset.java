package com.fundation.search.model;

import java.util.Date;

public class Asset {

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
     * this is a owner.
     */
    private String owner;
    /**
     * this is a list about extensions.
     */
    private String extensions;

    /**
     * this variable is a date Craete From.
     */
    private Date dateCreate;

    /**
     * this variable contains date Modificate From.
     */
    private Date dateModificate;

    /**
     * this variable contains date Access From.
     */
    private Date dateAccess;

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
     * this method get
     *
     * @return vauel of variable
     */
    public Date getDateCreate() {
        return dateCreate;
    }

    /**
     * set a new value.
     *
     * @param dateCreate with a new value.
     */
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    /**
     * this method get date modify ini.
     *
     * @return valueof variable
     */
    public Date getDateModificate() {
        return dateModificate;
    }

    /**
     * set a new value.
     *
     * @param dateModificate with a new value.
     */
    public void setDateModificate(Date dateModificate) {
        this.dateModificate = dateModificate;
    }

    /**
     * this method get date access ini.
     *
     * @return value of variable
     */
    public Date getDateAccess() {
        return dateAccess;
    }

    /**
     * set a new value.
     *
     * @param dateAccess with a new value.
     */
    public void setDateAccess(Date dateAccess) {
        this.dateAccess = dateAccess;
    }

    /**
     * this method get value if is read only.
     *
     * @return true if user selecct.
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
    public String getExtensions() {
        return extensions;
    }

    /**
     * set a new value.
     *
     * @param listExtensions with a new value.
     */
    public void setExtensions(String listExtensions) {
        this.extensions = listExtensions;
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
