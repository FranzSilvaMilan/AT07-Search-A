/*
 * @(#)AssetMultimedia.java
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

import org.apache.commons.lang3.math.Fraction;

import java.util.Date;

/**
 * @autor Franz Silva Milan [AT-07]
 */
public class AssetMultimedia extends Asset {

    /**
     * Codec Name is the codecName.
     */
    private String codecName;

    /**
     * Width is the width.
     */
    private int width;

    /**
     * Height is the height.
     */
    private int height;

    /**
     * Display Aspect is the displayAspect.
     */
    private String displayAspect;

    /**
     * Frame Rate is the rFrameRate.
     */
    private Fraction rFrameRate;

    /**
     * Duration is the duration.
     */
    private double duration;


    /**Declaration of variables Only for Audio.*/

    /**
     * Audio Codec Name is the audioCodecName.
     */
    private String audioCodecName;

    public AssetMultimedia(String path, boolean hidden, long size, String owner,
                           Date lastAccessTime, Date lastCreationtime, Date lasModified, boolean readOnly, String nameFile,
                           String exten, String codecName, int width, int height, String displayAspect, Fraction rFrameRate,
                           double duration, String audioCodecName){
        setPath(path);
        setIshidden(hidden);
        setSize(size);
        setOwner(owner);
        setDateAccess(lastAccessTime);
        setDateCreate(lastCreationtime);
        setDateModificate(lasModified);
        setReadOnly(readOnly);
        setFileName(nameFile);
        setExtensions(exten);
        setCodecName(codecName);
        //resolution
        setWidth(width);//320
        setHeight(height); //430
        setDisplayAspect(displayAspect);// e. g. 4:3
        //end resolution
        setrFrameRate(rFrameRate);
        setDuration(duration);
        setAudioCodecName(audioCodecName);
    }

    /**
     * This method return a duration.
     */
    public double getDuration() {
        return this.duration;
    }

    /**
     * This method return a Codec Name.
     */
    public String getCodecName() {
        return codecName;
    }

    /**
     * This method return a width of multimedia.
     */
    public int getWidth() {
        return width;
    }

    /**
     * This method return a height of multimedia.
     */
    public int getHeight() {
        return height;
    }

    /**
     * This method return a Display Aspect (resolution).
     */
    public String getDisplayAspect() {
        return displayAspect;
    }

    /**
     * This method return a Frame Rate.
     */
    public Fraction getrFrameRate() {
        return rFrameRate;
    }

    /**
     * This method return a Audio Codec Name.
     */
    public String getAudioCodecName() {
        return audioCodecName;
    }

    public void setCodecName(String codecName) {
        this.codecName = codecName;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDisplayAspect(String displayAspect) {
        this.displayAspect = displayAspect;
    }

    public void setrFrameRate(Fraction rFrameRate) {
        this.rFrameRate = rFrameRate;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }



    public void setAudioCodecName(String audioCodecName) {
        this.audioCodecName = audioCodecName;
    }

}
