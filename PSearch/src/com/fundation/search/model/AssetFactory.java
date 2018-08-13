package com.fundation.search.model;

import org.apache.commons.lang3.math.Fraction;

import java.util.Date;

public class AssetFactory {

    public static Asset getAsset(String path,boolean hidden,long size,String owner,boolean directory,
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
    public static Asset getAsset(String path, boolean hidden, long size, String owner,
                                 Date lastAccessTime, Date lastCreationtime, Date lasModified, boolean readOnly, String nameFile,
                                 String exten, String codecName, String codecLongName, int width, int height, String displayAspect, Fraction rFrameRate,
                                 double duration,long bitRate,long nbFrames,String audioCodecName){
        AssetMultimedia assetMultimedia = new AssetMultimedia();
        assetMultimedia.setPath(path);
        assetMultimedia.setIshidden(hidden);
        assetMultimedia.setSize(size);
        assetMultimedia.setOwner(owner);
        assetMultimedia.setDateAccess(lastAccessTime);
        assetMultimedia.setDateCreate(lastCreationtime);
        assetMultimedia.setDateModificate(lasModified);
        assetMultimedia.setReadOnly(readOnly);
        assetMultimedia.setFileName(nameFile);
        assetMultimedia.setExtensions(exten);
        assetMultimedia.setCodecName(codecName);
        assetMultimedia.setCodecLongName(codecLongName);
        //resolution
        assetMultimedia.setWidth(width);//320
        assetMultimedia.setHeight(height); //430
        assetMultimedia.setDisplayAspect(displayAspect);// e. g. 4:3
        //end resolution
        assetMultimedia.setrFrameRate(rFrameRate);
        assetMultimedia.setDuration(duration);
        assetMultimedia.setBitRate(bitRate);
        assetMultimedia.setNbFrames(nbFrames);
        assetMultimedia.setAudioCodecName(audioCodecName);
        return assetMultimedia;
    }
}
