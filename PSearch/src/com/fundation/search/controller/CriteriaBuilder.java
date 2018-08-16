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
    public void buildFile(String path, String fileName, boolean hidden, Long size, String operator, String unitForSize) {
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
        criteria.setUnitForSize(unitForSize);
    }

    @Override
    public void buildFileAdvance(boolean directory, boolean readOnly,
                                 Date dateModifyFrom, Date dateModifyTo, Date dateCreateFrom,
                                 Date dateCreateTo, Date dateAccessFrom, Date dateAccessTo,
                                 boolean keysensitive, String owner, String contain, ArrayList<String> extensions,
                                 boolean endWith, boolean startWith, boolean multimediaSelected, boolean dateCreate,
                                 boolean dateModified, boolean dateLassAccess) {

        if (directory) criteria.setDirectory(directory);
        if (endWith) criteria.setEndWith(endWith);
        if (dateCreate) criteria.setEnableCreate(dateCreate);
        if (dateModified) criteria.setEnableModified(dateModified);
        if (dateLassAccess) criteria.setEnableLastAccess(dateLassAccess);
        if (startWith) criteria.setStartWith(startWith);
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

    @Override
    public void buildMultimedia(String frameRare, String videoCode, String audioCode, String resolution, double duration,
                                String operatorDurationTime,String unitTime ,ArrayList<String> extensionVideo, String aspectRatio) {
        System.out.println("buildea multimedia");
        if (frameRare != null) {
            criteria.setFrameRate(frameRare);
        }
        if (videoCode != null) {
            criteria.setVideoCode(videoCode);
        }
        if (audioCode != null) {
            criteria.setAudioCode(audioCode);
        }
        if (resolution != null) {
            criteria.setResolution(resolution);
        }
        if (duration >= 0) {
            criteria.setDuration(duration);
        }
        if (operatorDurationTime != null) {
            criteria.setOperatorDurationTime(operatorDurationTime);
        }
        if (!extensionVideo.isEmpty()) {
            System.out.println(" setea extensions");
            criteria.setExtensionVideo(extensionVideo);
        }
        if (aspectRatio != null) {
            criteria.setAspectRatio(aspectRatio);
        }
        criteria.setUnitTime(unitTime);

    }

    @Override
    public Criteria build() {
        return criteria;
    }
}
