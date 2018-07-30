package com.fundation.search.model;

public class AssetFile extends Asset {
    public boolean isFolder() {
        return isFolder;
    }

    public void setFolder(boolean folder) {
        isFolder = folder;
    }

    private boolean isFolder;

    public AssetFile(){
        super();
    }

}
