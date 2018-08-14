package com.fundation.search.model;

import java.util.Date;

public class AssetFile extends Asset {

    /**
     * variable of FileNameExt
     */
    private String fileNameExt;

    /**
     * contais if select folder.
     */
    private boolean directory;
    public AssetFile(String path, boolean hidden, long size, String owner, boolean directory,
                     Date lastAccessTime, Date lastCreationtime, Date lasModified, boolean readOnly,
                     String nameExt, String nameFile, String exten){
        setPath(path);
        setIshidden(hidden);
        setSize(size);
        setOwner(owner);
        setDirectory(directory);
        setDateAccess(lastAccessTime);
        setDateCreate(lastCreationtime);
        setDateModificate(lasModified);
        setReadOnly(readOnly);
        setFileNameExt(nameExt);
        setFileName(nameFile);
        setExtensions(exten);

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
     * @return
     */
    public String getFileNameExt() {
        return fileNameExt;
    }

    /**
     * @param fileNameExt
     */
    public void setFileNameExt(String fileNameExt) {
        this.fileNameExt = fileNameExt;
    }
}
