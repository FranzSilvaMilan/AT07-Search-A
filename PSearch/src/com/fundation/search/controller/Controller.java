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

import com.fundation.search.model.AssetFile;
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
    private CriteriaBuilder criteriaBuilder;
    private Criteria criteria;

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
                    buildCriteria();
                    search.searchByCriteria(criteria);
                    List<AssetFile> listResult = search.getResult();
                    frame.getPanelSearch().cleanTable();
                    for (AssetFile file : listResult) {
                        String[] row = new String[]{Boolean.toString(file.getDirectory()),file.getFileName(),
                                Long.toString(file.getSize()),
                                file.getPath(),
                                Boolean.toString(file.getIsIshidden()),file.getExtensions(),file.getOwner(),Boolean.toString(file.getReadOnly()),
                        file.getDateCreateFrom(),file.getDateCreateFrom()};
                        frame.getPanelSearch().addRow(row);
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
        System.out.println(fileName);
        String operator = frame.getPanelSearch().getOperator();
        Long valueOFView = Long.parseLong(frame.getPanelSearch().getSizeFile());
        String unityForSize = frame.getPanelSearch().getOptionUnitsSize();
        Long sizeValue = convert.convertTOLong(valueOFView, unityForSize);
        boolean hidden = frame.getPanelSearch().getHidden();

        //values of search advanced
        boolean readOnly = frame.getPanelSearch().getOnlyRead();
        boolean keySensitive = frame.getPanelSearch().getKeySensitive();
        String dateCreateFrom = convert.convertDateToString(frame.getPanelSearch().getDateCreate());
        String dateCreateTo = convert.convertDateToString(frame.getPanelSearch().getDateCreateTo());
        String dateModifyFrom = convert.convertDateToString(frame.getPanelSearch().getDateModified());
        String dateModifyTo = convert.convertDateToString(frame.getPanelSearch().getDateModifiedTo());
        String dateAccessFrom = convert.convertDateToString(frame.getPanelSearch().getDateLastAccess());
        String dateAccessTo = convert.convertDateToString(frame.getPanelSearch().getDateLastAccess());
        String owner = frame.getPanelSearch().getOwner();
        String contain = frame.getPanelSearch().getContain();
        boolean folder = frame.getPanelSearch().getSearchFolder();
        ArrayList<String> listExtensions= frame.getPanelSearch().getExtensions();

        CriteriaBuilder criteriaBuilder = new CriteriaBuilder();
        criteriaBuilder.buildFile(path, fileName, hidden, sizeValue, operator);
        criteriaBuilder.buildFileAdvance(folder,readOnly,dateModifyFrom,dateModifyTo,dateCreateFrom,
                dateCreateTo,dateAccessFrom,dateAccessTo,keySensitive,owner,contain,listExtensions);
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
