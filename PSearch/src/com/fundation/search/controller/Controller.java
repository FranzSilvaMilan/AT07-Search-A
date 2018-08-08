/*
 * @(#)Controller.java
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
package com.fundation.search.controller;

import com.fundation.search.model.Asset;
import com.fundation.search.model.AssetFile;
import com.fundation.search.model.AssetMultimedia;
import com.fundation.search.model.Search;
import com.fundation.search.utils.Convert;
import com.fundation.search.utils.ValidatorData;
import com.fundation.search.view.FrameMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class controller can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Denis Camacho - AT-[07].
 * @author Ketty Camacho - AT -[07].
 * @author Franz Silva - AT - [07].
 * @version 1.0.
 */
public class Controller {
    private FrameMain frame;
    private ValidatorData validator;
    private Search search;
    private Convert convert;
    private Criteria criteria;
    String unityForSize;

    /**
     * this a constuctor.
     */
    public Controller() {
        frame = new FrameMain();
        search = new Search();
        validator = new ValidatorData();
        convert = new Convert();
        criteria = new Criteria();
        actionListener();
    }

    /**
     * this method has the accion listeenr of the button.
     */
    private void actionListener() {
        frame.getPanelSearch().getButtonSearch().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateAllFields()) {
                    criteria = new Criteria();
                    buildCriteria();
                    search.setCriteria(criteria);
                    search.searchByCriteria(criteria);
                    List<Asset> listResult = search.getResult();
                    frame.cleanTable();
                    for (Asset file : listResult) {
                        String[] row;
                        if (file instanceof AssetFile) {
                            AssetFile assetFile = (AssetFile) file;
                            row = new String[]{Boolean.toString(assetFile.getDirectory()), assetFile.getFileName(),
                                    String.format("%.3f", convert.convertTOLongShow(assetFile.getSize(),unityForSize)).concat(" ").concat(unityForSize), assetFile.getPath(),
                                    Boolean.toString(assetFile.getIsIshidden()), assetFile.getExtensions(), assetFile.getOwner(), Boolean.toString(assetFile.getReadOnly()),
                                    convert.convertDateToString(assetFile.getDateCreate()), convert.convertDateToString(assetFile.getDateModificate()),
                                    convert.convertDateToString(assetFile.getDateAccess())};
                                     frame.addRow(row);


                        } else {
                            AssetMultimedia assetMultimedia = (AssetMultimedia) file;
                            row = new String[]{Boolean.toString(false), assetMultimedia.getFileName(),
                                    String.format("%.3f", convert.convertTOLongShow(assetMultimedia.getSize(),unityForSize)).concat(" ").concat(unityForSize), assetMultimedia.getPath(),
                                    Boolean.toString(assetMultimedia.getIsIshidden()), assetMultimedia.getExtensions(), assetMultimedia.getOwner(), Boolean.toString(assetMultimedia.getReadOnly()),
                                    convert.convertDateToString(assetMultimedia.getDateCreate()), convert.convertDateToString(assetMultimedia.getDateModificate()),
                                    convert.convertDateToString(assetMultimedia.getDateAccess())};
                                    //frame.getPanelSearch().addRow(row);
                                   frame.addRow(row);

                        }
                    }
                }
            }
        });
    }

    /**
     * this method build object criteria.
     */
    private void buildCriteria() {
        //values of search basic
        String path = frame.getPanelSearch().getTextPath();
        String fileName = frame.getPanelSearch().getTextFile();
        String operator = frame.getPanelSearch().getOperator();
        Long valueOFView = Long.parseLong(frame.getPanelSearch().getSizeFile());
        unityForSize = frame.getPanelSearch().getOptionUnitsSize();
        Long sizeValue = convert.convertTOLong(valueOFView, unityForSize);
        boolean hidden = frame.getPanelSearch().getHidden();

        //values of search advanced
        boolean readOnly = frame.getPanelSearch().getOnlyRead();
        boolean keySensitive = frame.getPanelSearch().getKeySensitive();
        Date dateCreateFrom = frame.getPanelSearch().getDateCreate();
        Date dateCreateTo = frame.getPanelSearch().getDateCreateTo();
        Date dateModifyFrom = frame.getPanelSearch().getDateModified();
        Date dateModifyTo = frame.getPanelSearch().getDateModifiedTo();
        Date dateAccessFrom = frame.getPanelSearch().getDateLastAccess();
        Date dateAccessTo = frame.getPanelSearch().getDateLastAccessTo();
        String owner = frame.getPanelSearch().getOwner();
        String contain = frame.getPanelSearch().getContain();
        boolean folder = frame.getPanelSearch().getSearchFolder();
        ArrayList<String> listExtensions = frame.getPanelSearch().getExtensions();
        boolean multimediaSelected = frame.getPanelMultimedia().getenableMediaSetup();


        //builder criteria
        CriteriaBuilder criteriaBuilder = new CriteriaBuilder();
        criteriaBuilder.buildFile(path, fileName, hidden, sizeValue, operator);
        criteriaBuilder.buildFileAdvance(folder, readOnly, dateModifyFrom, dateModifyTo, dateCreateFrom,
                dateCreateTo, dateAccessFrom, dateAccessTo, keySensitive, owner, contain, listExtensions, multimediaSelected);
        if (multimediaSelected) {
            //multimedia
            String frameRate = frame.getPanelMultimedia().getOptionFrameRate();
            String videoCode = frame.getPanelMultimedia().getOptionVideoCode();
            String audioCode = frame.getPanelMultimedia().getOptionAudioCodec();
            String resolution = frame.getPanelMultimedia().getOptionUnitsResolution();
            String operatorDurationTime = frame.getPanelMultimedia().getOperator();// < > =
            String unitDuration = frame.getPanelMultimedia().getOperationTime();//e.g. second
            double duration = convert.convertTimeDurationToDouble(frame.getPanelMultimedia().getDuration(),unitDuration );
            ArrayList<String> extensionsMultimedia = frame.getPanelMultimedia().getOtherExtensions();
            criteriaBuilder.buildMultimedia(frameRate, videoCode, audioCode, resolution, duration, operatorDurationTime, extensionsMultimedia);
        }
        this.criteria = criteriaBuilder.build();

    }

    /**
     * this method calidate the fields get of UI.
     *
     * @return true if all fields is correct.
     */
    private boolean validateAllFields() {
        return validator.isPathValid(frame.getPanelSearch().getTextPath()) && validator.isSizeValid(frame.getPanelSearch().getSizeFile());
    }
}
