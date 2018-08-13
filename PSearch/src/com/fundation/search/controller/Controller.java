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
import com.fundation.search.utils.LoggerSearch;
import com.fundation.search.utils.ValidatorData;
import com.fundation.search.view.FrameMain;
import org.apache.log4j.Logger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * This class controller can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Denis Camacho - AT-[07].
 * @author Ketty Camacho - AT -[07].
 * @author Franz Silva - AT - [07].
 * @version 1.0.
 */
public class Controller {
    /**
     * variable that contains frame
     */
    private FrameMain frame;
    /**
     * varaible that contains validator
     */
    private ValidatorData validator;
    /**
     * variable that contains search.
     */
    private Search search;
    /**
     * variable that contains converts.
     */
    private Convert convert;
    /**
     * varaible that contains criteria.
     */
    private Criteria criteria;
    /**
     * variablbe that contains unityForSize
     */
    private String unityForSize;
    /**
     * lOGGER
     */
    private static final Logger LOGGER = LoggerSearch.getInstance().getLogger();

    /**
     * this a constuctor.
     */
    public Controller() {
        LOGGER.info("Constructor Controller : into");
        frame = new FrameMain();
        search = new Search();
        validator = new ValidatorData();
        convert = new Convert();
        criteria = new Criteria();
        dataBaseLoad();
        actionListener();
        actionListenerDataBaseSave();
        actionListenerDataBaseLoad();
        //actionMouse();
        LOGGER.info("Constructor Controller : exit");
    }

    /**
     * this method has the accion listeenr of the button.
     */
    private void actionListener() {
        LOGGER.info("actionListener: into");
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
                                    String.format("%.3f", convert.convertTOLongShow(assetFile.getSize(), unityForSize)).concat(" ").concat(unityForSize), assetFile.getPath(),
                                    Boolean.toString(assetFile.getIsIshidden()), assetFile.getExtensions(), assetFile.getOwner(), Boolean.toString(assetFile.getReadOnly()),
                                    convert.convertDateToString(assetFile.getDateCreate()), convert.convertDateToString(assetFile.getDateModificate()),
                                    convert.convertDateToString(assetFile.getDateAccess())};
                            frame.addRow(row);

                        } else {
                            AssetMultimedia assetMultimedia = (AssetMultimedia) file;
                            String resolution = assetMultimedia.getDisplayAspect() + " " + assetMultimedia.getWidth() + "x" + assetMultimedia.getHeight();
                            row = new String[]{Boolean.toString(false), assetMultimedia.getFileName(),
                                    String.format("%.3f", convert.convertTOLongShow(assetMultimedia.getSize(), unityForSize)).concat(" ").concat(unityForSize), assetMultimedia.getPath(),
                                    Boolean.toString(assetMultimedia.getIsIshidden()), assetMultimedia.getExtensions(), assetMultimedia.getOwner(), Boolean.toString(assetMultimedia.getReadOnly()),
                                    convert.convertDateToString(assetMultimedia.getDateCreate()), convert.convertDateToString(assetMultimedia.getDateModificate()),
                                    convert.convertDateToString(assetMultimedia.getDateAccess()), assetMultimedia.getrFrameRate().toString(),
                                    resolution, assetMultimedia.getCodecName(), assetMultimedia.getAudioCodecName(), Double.toString(assetMultimedia.getDuration())};
                            frame.addRow(row);
                        }
                    }
                }
            }
        });
        LOGGER.info("actionListener : exit");
    }

    /**
     * this method has the accion listeenr of the button.
     */
    private void actionListenerDataBaseSave() {
        frame.getPanelMultimedia().getButtonSave().addActionListener(e -> {
            if (validateAllFields()) {
                criteria = new Criteria();
                buildCriteria();
                String nameCriteria = frame.getPanelMultimedia().getTextCriteria();
                search.createJson(criteria, nameCriteria);
                dataBaseLoad();
            }
        });
    }

    /**
     * this method has the accion listeenr of the button.
     */
    private void actionListenerDataBaseLoad() {
        frame.getPanelMultimedia().getButtonLoad().addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int idSelect = frame.getPanelMultimedia().getPanelTableBD().getTable().getSelectedRow() + 1;
                    System.out.println(idSelect);
                    frame.getPanelMultimedia().setTextCriteria(frame.getPanelMultimedia().
                            getPanelTableBD().getModelDB().getValueAt(idSelect - 1, 1).toString());
                    Map<Integer, Criteria> database = search.getJSONCriteria();
                    final Criteria[] selectCriteria = {new Criteria()};
                    database.forEach((id, criterial) -> {
                        if (id == idSelect) {
                            selectCriteria[0] = criterial;
                        }
                    });
                    frame.getPanelSearch().setTextPath(selectCriteria[0].getPath());
                    frame.getPanelSearch().setTextFile(selectCriteria[0].getFileName());
                    frame.getPanelSearch().setTextContain(selectCriteria[0].getContent());
                    frame.getPanelSearch().setTextOwner(selectCriteria[0].getOwner());
                    frame.getPanelSearch().setExtensions(selectCriteria[0].getListExtensions());
                    frame.getPanelSearch().setOperator(selectCriteria[0].getOperator());
                    frame.getPanelSearch().setOptionUnitsSize(selectCriteria[0].getUnitForSize());
                    frame.getPanelSearch().setSpinnerSize((int) convert.convertTOLongShow(selectCriteria[0].getSize(),
                            selectCriteria[0].getUnitForSize()));
                    frame.getPanelSearch().setEnableKeySensitive(selectCriteria[0].isKeySensitive());
                    frame.getPanelSearch().setEnableOnlyRead(selectCriteria[0].getReadOnly());
                    frame.getPanelSearch().setFolder(selectCriteria[0].getDirectory());
                    frame.getPanelSearch().setHiddenCheck(selectCriteria[0].getIsIshidden());
                    frame.getPanelSearch().setEndWith(selectCriteria[0].isEndWith());
                    frame.getPanelSearch().setStartWith(selectCriteria[0].isStartWith());
                    frame.getPanelSearch().setEnableCreate(selectCriteria[0].isEnableCreate());
                    frame.getPanelSearch().setDateCreate(selectCriteria[0].getDateCreateFrom());
                    frame.getPanelSearch().setDateCreateTo(selectCriteria[0].getDateCreateTo());
                    frame.getPanelSearch().setEnableModified(selectCriteria[0].isEnableModified());
                    frame.getPanelSearch().setDateModified(selectCriteria[0].getDateModificateFrom());
                    frame.getPanelSearch().setDateModifiedTo(selectCriteria[0].getDateModificateTo());
                    frame.getPanelSearch().setEnableLastAccess(selectCriteria[0].isEnableLastAccess());
                    frame.getPanelSearch().setDateLastAccess(selectCriteria[0].getDateAccessFrom());
                    frame.getPanelSearch().setDateLastAccessTo(selectCriteria[0].getDateAccessTo());
                    //Multimedia
                    frame.getTab().enableSetupContainer(selectCriteria[0].getIsMultimediaSelected());
                    frame.getPanelMultimedia().setSelectedMultiMediaSetup(selectCriteria[0].getIsMultimediaSelected());
                    frame.getPanelMultimedia().setOptionAudioCodec(selectCriteria[0].getAudioCode());
                    frame.getPanelMultimedia().setOptionVideoCode(selectCriteria[0].getVideoCode());
                    frame.getPanelMultimedia().setOptionFrameRate(selectCriteria[0].getFrameRate());
                    frame.getPanelMultimedia().setOptionUnitsResolution(selectCriteria[0].getResolution());
                    frame.getPanelMultimedia().setOptionAspecRadio(selectCriteria[0].getAspectRatio());
                    frame.getPanelMultimedia().setExtensionsMultimedia(selectCriteria[0].getExtensionVideo());

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

    /**
     * this method has the accion listeenr of the button.
     */
    private void dataBaseLoad() {
        frame.getPanelMultimedia().cleanTableDB();
        try {
            Map<Integer, String> database = search.getJSONCriteriaUI();
            database.forEach((id, nameCriteria) -> frame.getPanelMultimedia().
                    addRowDB(new String[]{id.toString(), nameCriteria}));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * this method build object criteria.
     */
    private void buildCriteria() {
        LOGGER.info("buildCriteria : into");
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
        boolean endWith = frame.getPanelSearch().getEndWith();
        boolean startWith = frame.getPanelSearch().getStartWith();
        boolean dateCreate = frame.getPanelSearch().getEnableCreate();
        boolean dateModified = frame.getPanelSearch().getEnableModified();
        boolean dateLassAccess = frame.getPanelSearch().getEnableLastAccess();
        ArrayList<String> listExtensions = frame.getPanelSearch().getExtensions();
        boolean multimediaSelected = frame.getPanelMultimedia().getenableMediaSetup();


        //builder criteria
        CriteriaBuilder criteriaBuilder = new CriteriaBuilder();
        criteriaBuilder.buildFile(path, fileName, hidden, sizeValue, operator, unityForSize);
        criteriaBuilder.buildFileAdvance(folder, readOnly, dateModifyFrom, dateModifyTo, dateCreateFrom,
                dateCreateTo, dateAccessFrom, dateAccessTo, keySensitive, owner, contain, listExtensions,
                endWith, startWith, multimediaSelected, dateCreate, dateModified, dateLassAccess);
        if (multimediaSelected) {
            //multimedia
            String frameRate = frame.getPanelMultimedia().getOptionFrameRate();
            String videoCode = frame.getPanelMultimedia().getOptionVideoCode();
            String audioCode = frame.getPanelMultimedia().getOptionAudioCodec();
            String resolution = frame.getPanelMultimedia().getOptionUnitsResolution();
            String operatorDurationTime = frame.getPanelMultimedia().getOperator();// < > =
            String unitDuration = frame.getPanelMultimedia().getOperationTime();//e.g. second
            double duration = convert.convertTimeDurationToDouble(frame.getPanelMultimedia().getDuration(), unitDuration);
            ArrayList<String> extensionsMultimedia = frame.getPanelMultimedia().getOtherExtensions();
            String aspectRatio = frame.getPanelMultimedia().getAspectRadio();
            criteriaBuilder.buildMultimedia(frameRate, videoCode, audioCode,
                    resolution, duration, operatorDurationTime, extensionsMultimedia, aspectRatio);
        }
        this.criteria = criteriaBuilder.build();
        LOGGER.info("buildCriteria: exit");
    }

    /**
     * this method calidate the fields get of UI.
     *
     * @return true if all fields is correct.
     */
    private boolean validateAllFields() {
        LOGGER.info("validateAllFields : into");
        LOGGER.info("validateAllFields : exit");
        return validator.isPathValid(frame.getPanelSearch().
                getTextPath()) && validator.isSizeValid(frame.getPanelSearch().getSizeFile());

    }
}
