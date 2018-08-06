package com.fundation.search.model;

public class AssetFile extends Asset {

    private String contentIntoDocument;

    /**
     * this method get the word that will search.
     *
     * @return value of variable.
     */
    public String getContentIntoDocument() {
        return contentIntoDocument;
    }

    /**
     * set a new value.
     *
     * @param contentIntoDocument with a new value.
     */
    public void setContentIntoDocument(String contentIntoDocument) {
        this.contentIntoDocument = contentIntoDocument;
    }
    /**
     * contais if select folder.
     */
    private boolean directory;
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


}
