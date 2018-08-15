package com.fundation.search.model;

import org.apache.commons.lang3.math.Fraction;

import java.util.Date;

public class AssetFactory {

    public static Asset getAsset(String path,boolean hidden,long size,String owner,boolean directory,
                           Date lastAccessTime,Date lastCreationtime,Date lasModified,boolean readOnly,
                           String nameExt,String nameFile,String exten){
         return new AssetFile(path,hidden,size,owner,directory,lastAccessTime,lastCreationtime,lasModified,readOnly,nameExt,nameFile,exten);
    }
    public static Asset getAsset(String path, boolean hidden, long size, String owner,
                                 Date lastAccessTime, Date lastCreationtime, Date lasModified, boolean readOnly, String nameFile,
                                 String exten, String codecName, int width, int height, String displayAspect, Fraction rFrameRate,
                                 double duration,String audioCodecName){
        return new AssetMultimedia(path,hidden,size,owner,lastAccessTime,lastCreationtime,lasModified,readOnly,nameFile,
                exten,codecName,width,height,displayAspect,rFrameRate,duration,audioCodecName);
    }
}
