/*******************************************************************************
 *
 *  * @(#)Criteria.java
 *  *
 *  * Copyright (c) 2018 Jala Foundation.
 *  * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  * All rights reserved.
 *  *
 *  * This software is the confidential and proprietary information of
 *  * Jala Foundation, ("Confidential Information").  You shall not
 *  * disclose such Confidential Information and shall use it only in
 *  * accordance with the terms of the license agreement you entered into
 *  * with Jala Foundation.
 *
 ******************************************************************************/

package com.fundation.search.controller;

import java.util.ArrayList;
import java.util.Date;

public class CriteriaBuilder implements IBuilder {
    private Criteria criteria;


    public CriteriaBuilder() {
        criteria = new Criteria();
    }

    @Override
    public void buildFile(String path, String fileName, boolean hidden, Long size, String operator) {
        if (!path.isEmpty()) {
            criteria.setPath(path);
        }
        if (!fileName.isEmpty()) {
            criteria.setFileName(fileName);
        }
        if (hidden) {
            criteria.setIshidden(hidden);
        }
        criteria.setSize(size);
        criteria.setOperator(operator);
    }

    @Override
    public void buildFileAdvance(boolean directory, boolean readOnly,
                                 Date dateModifyFrom, Date dateModifyTo, Date dateCreateFrom,
                                 Date dateCreateTo, Date dateAccessFrom, Date dateAccessTo,
                                 boolean keysensitive, String owner, String contain, ArrayList<String> extensions, boolean multimediaSelected) {

        if (directory) criteria.setDirectory(directory);
        if (readOnly) criteria.setReadOnly(readOnly);
        if (dateModifyFrom != null) criteria.setDateModificateFrom(dateModifyFrom);
        if (dateModifyTo != null) criteria.setDateModificateTo(dateModifyTo);
        if (dateCreateFrom != null) criteria.setDateCreateFrom(dateCreateFrom);
        if (dateCreateTo != null) criteria.setDateCreateTo(dateCreateTo);
        if (dateAccessFrom != null) criteria.setDateAccessFrom(dateAccessFrom);
        if (dateAccessTo != null) criteria.setDateAccessTo(dateAccessTo);
        if (keysensitive) criteria.setKeySensitive(keysensitive);
        if (!owner.isEmpty()) criteria.setOwner(owner);
        if (!contain.isEmpty()) criteria.setContent(contain);
        if (!extensions.isEmpty()) criteria.setListExtensions(extensions);
        if (multimediaSelected) {
            criteria.setMultimediaSelected(multimediaSelected);
        }

    }

    private String videoCode;
    private String audioCode;
    private String resolution;
    private long duration;
    private String operatorDurationTime;
    private ArrayList<String> extensionVideo;
    private boolean isMultimediaSelected;

    @Override
    public void buildMultimedia(String frameRare, String videoCode, String audioCode, String resolution, double duration, String operatorDurationTime,
                                ArrayList<String> extensionVideo) {
        if (!frameRare.isEmpty()) {
            criteria.setFrameRate(frameRare);
        }
        if (!videoCode.isEmpty()) {
            criteria.setVideoCode(videoCode);
        }
        if (!audioCode.isEmpty()) {
            criteria.setAudioCode(audioCode);
        }
        if(!resolution.isEmpty()){
            criteria.setResolution(resolution);
        }
        if(criteria.getDuration()>=0){
            criteria.setDuration(duration);
        }
        if(!operatorDurationTime.isEmpty()){
            criteria.setOperatorDurationTime(operatorDurationTime);
        }
        if(!extensionVideo.isEmpty()){
            criteria.setExtensionVideo(extensionVideo);
        }
    }

    @Override
    public Criteria build() {
        return criteria;
    }
}
