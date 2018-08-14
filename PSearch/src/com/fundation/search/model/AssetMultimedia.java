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
     * Codec Long Name is the codecLongName.
     */
    private String codecLongName;

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
     * Start Time is the starTime.
     */
    private double starTime;

    /**
     * Duration is the duration.
     */
    private double duration;

    /**
     * BitRate is the bitRate.
     */
    private long bitRate;

    /**
     * Nb Frames is the nbFrames.
     */
    private long nbFrames;


    /**Declaration of variables Only for Audio.*/

    /**
     * Audio Codec Name is the audioCodecName.
     */
    private String audioCodecName;

    /**
     * Audio Codec Long Name is the audioCodecLongName.
     */
    private String audioCodecLongName;

    /**
     * Audio Codec Tag is the audioCodecTag.
     */
    private String audioCodecTag;

    /**
     * Audio Channels is the audioChannels.
     */
    private int audioChannels;

    /**
     * Audio Channel Layout is the audioChannelLayout.
     */
    private String audioChannelLayout;

    /**
     * Audio Start Time is the audioStarTime.
     */
    private double audioStarTime;

    /**
     * Audio Duration is the audioDuration.
     */
    private double audioDuration;

    /**
     * Audio BitRate is the audioBitRate.
     */
    private long audioBitRate;

    /**
     * Audio Max BitRate is the audioMaxBitRate.
     */
    private long audioMaxBitRate;

    /**
     * Audio Nb Frame is the audioNbFrame.
     */
    private long audioNbFrame;
    public AssetMultimedia(String path, boolean hidden, long size, String owner,
                           Date lastAccessTime, Date lastCreationtime, Date lasModified, boolean readOnly, String nameFile,
                           String exten, String codecName, String codecLongName, int width, int height, String displayAspect, Fraction rFrameRate,
                           double duration, long bitRate, long nbFrames, String audioCodecName){
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
        setCodecLongName(codecLongName);
        //resolution
        setWidth(width);//320
        setHeight(height); //430
        setDisplayAspect(displayAspect);// e. g. 4:3
        //end resolution
        setrFrameRate(rFrameRate);
        setDuration(duration);
        setBitRate(bitRate);
        setNbFrames(nbFrames);
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
     * This method return a Codec  Name Log.
     */
    public String getCodecLongName() {
        return codecLongName;
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
     * This method return a Start Time.
     */
    public double getStarTime() {
        return starTime;
    }

    /**
     * This method return a bitRate.
     */
    public long getBitRate() {
        return bitRate;
    }

    /**
     * This method return a Nb Frames.
     */
    public long getNbFrames() {
        return nbFrames;
    }

    /**
     * This method return a Audio Codec Name.
     */
    public String getAudioCodecName() {
        return audioCodecName;
    }

    /**
     * This method return a Audio Codec Long Name.
     */
    public String getAudioCodecLongName() {
        return audioCodecLongName;
    }

    /**
     * This method return a Audio Codec Tag.
     */
    public String getAudiofCodecTag() {
        return audioCodecTag;
    }

    /**
     * This method return a Audio Channels.
     */
    public int getAudioChannels() {
        return audioChannels;
    }

    /**
     * This method return a Audio Channel Layout.
     */
    public String getAudioChannelLayout() {
        return audioChannelLayout;
    }

    /**
     * This method return a Audio Start Time.
     */
    public double getAudioStarTime() {
        return audioStarTime;
    }

    /**
     * This method return a Audio Duration.
     */
    public double getAudioDuration() {
        return audioDuration;
    }

    /**
     * This method return a Audio BitRate.
     */
    public long getAudioBitRate() {
        return audioBitRate;
    }

    /**
     * This method return a Audio Max BitRate.
     */
    public long getAudioMaxBitRate() {
        return audioMaxBitRate;
    }

    /**
     * This method return a Audio Nb Frame.
     */
    public long getAudioNbFrame() {
        return audioNbFrame;
    }

    public void setCodecName(String codecName) {
        this.codecName = codecName;
    }

    public void setCodecLongName(String codecLongName) {
        this.codecLongName = codecLongName;
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

    public void setStarTime(double starTime) {
        this.starTime = starTime;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setBitRate(long bitRate) {
        this.bitRate = bitRate;
    }

    public void setNbFrames(long nbFrames) {
        this.nbFrames = nbFrames;
    }

    public void setAudioCodecName(String audioCodecName) {
        this.audioCodecName = audioCodecName;
    }

    public void setAudioCodecLongName(String audioCodecLongName) {
        this.audioCodecLongName = audioCodecLongName;
    }

    public void setAudioCodecTag(String audioCodecTag) {
        this.audioCodecTag = audioCodecTag;
    }

    public void setAudioChannels(int audioChannels) {
        this.audioChannels = audioChannels;
    }

    public void setAudioChannelLayout(String audioChannelLayout) {
        this.audioChannelLayout = audioChannelLayout;
    }

    public void setAudioStarTime(double audioStarTime) {
        this.audioStarTime = audioStarTime;
    }

    public void setAudioDuration(double audioDuration) {
        this.audioDuration = audioDuration;
    }

    public void setAudioBitRate(long audioBitRate) {
        this.audioBitRate = audioBitRate;
    }

    public void setAudioMaxBitRate(long audioMaxBitRate) {
        this.audioMaxBitRate = audioMaxBitRate;
    }

    public void setAudioNbFrame(long audioNbFrame) {
        this.audioNbFrame = audioNbFrame;
    }

}
