package com.fundation.search.model;

import java.security.Timestamp;

public class Asset {

    private String path;
    private String fileName;
    private long size;
    private boolean isHidden;
    private String extension;
    private Timestamp fileDateCreation;
    private Timestamp fileDateModified;
    private Timestamp fileDateAccess;

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    private String folderName;

    public Timestamp getFileDateAccess() {
        return fileDateAccess;
    }

    public void setFileDateAccess(Timestamp fileDateAccess) {
        this.fileDateAccess = fileDateAccess;
    }

    private String owner;
    private boolean readOnly;



    public Asset() {


    }

    public String getPath() {
        return path;
    }

    public String getFileName() {
        return fileName;
    }

    /**
     * @return size of search.
     */
    public long getSize() {
        return size;
    }

    public boolean getIsIsHidden() {
        return isHidden;
    }

    public String getExtension() {
        return extension;
    }

    public Timestamp getFileDateCreation() {
        return fileDateCreation;
    }

    public Timestamp getFileDateModified() {
        return fileDateModified;
    }

    public String getOwner() {
        return owner;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setDateCreate(Timestamp date) {
        this.fileDateCreation = date;
    }

    public void setOwner1(String owner) {
        this.owner = owner;
    }

    public void setFileDateModified(Timestamp fileDateModified) {
        this.fileDateModified = fileDateModified;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean getReadOnly() {
        return readOnly;
    }


}
