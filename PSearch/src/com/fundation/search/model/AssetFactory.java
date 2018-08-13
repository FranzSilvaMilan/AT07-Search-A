package com.fundation.search.model;

import java.util.Date;

public class AssetFactory {

    public Asset assetFile(String path,boolean hidden,long size,String owner,boolean directory,
                           Date lastAccessTime,Date lastCreationtime,Date lasModified,boolean readOnly,
                           String nameExt,String nameFile,String exten){
        AssetFile data = new AssetFile();
        data.setPath(path);
        data.setIshidden(hidden);
        data.setSize(size);
        data.setOwner(owner);
        data.setDirectory(directory);
        data.setDateAccess(lastAccessTime);
        data.setDateCreate(lastCreationtime);
        data.setDateModificate(lasModified);
        data.setReadOnly(readOnly);
        data.setFileNameExt(nameExt);
        data.setFileName(nameFile);
        data.setExtensions(exten);
        return data;
    }
    public Asset assetMultimedia(){
        AssetMultimedia assetMultimedia = new AssetMultimedia();
        return assetMultimedia;
    }
}
