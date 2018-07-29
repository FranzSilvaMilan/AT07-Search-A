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
        frame.getPanelSearch().getButtoSearsh().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (validateAllFields()) {
                    buildCriteria();
                    search.searchByCriteria(criteria);
                    List<AssetFile> listResult = search.getResult();
                    frame.getPanelSearch().cleanTable();
                    for (AssetFile file : listResult) {
                        String[] row = new String[]{file.getFileName(),
                                Long.toString(file.getSize()),
                                file.getPath(),
                                Boolean.toString(file.getIsIsHidden())};
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
        String path = frame.getPanelSearch().getTextPath();
        String fieName = frame.getPanelSearch().getTextFile();
        String operator = frame.getPanelSearch().getOperator();
        Long valueOFView = Long.parseLong(frame.getPanelSearch().getSizeFile());
        String unityForSize = frame.getPanelSearch().getOptionUnitsSize();
        Long sizeValue = convert.convertTOLong(valueOFView, unityForSize);
        boolean hidden = frame.getPanelSearch().getHidden();

        CriteriaBuilder criteriaBuilder = new CriteriaBuilder();
        criteriaBuilder.buildFile(path, fieName, hidden, sizeValue, operator);
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
