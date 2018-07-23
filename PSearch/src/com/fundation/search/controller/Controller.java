/**
 * @(#)Controller.java Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.fundation.search.controller;


//import com.fundation.search.model.AssetFile;

import com.fundation.search.model.AssetFile;
import com.fundation.search.model.Search;
import com.fundation.search.utils.ValidatorData;
import com.fundation.search.view.FrameMain;
import com.fundation.search.view.PanelSearch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
//import java.util.List;

/**
 * This class controller can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Denis Camacho - AT-[07].
 * @author Ketty Camacho- AT -[07].
 * @version 1.0.
 */
public class Controller {
    FrameMain frame;

    ValidatorData validator;
    Criteria criteria;
    Search search;

    //List<AssetFile> listResult;
    public Controller() {
        frame = new FrameMain();
        criteria = new Criteria();
        search = new Search();
        validator = new ValidatorData();
        actionListener();


    }

    /**
     * this method has the accion listeenr of the button.
     */
    public void actionListener() {
        frame.getPanelSearch().getButtoSearsh().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (validator.isPathValid(frame.getPanelSearch().getTextPath())) {

                    search.searchByCriteria(criteria.getSearchCriteria(frame.getPanelSearch()));
                    List<AssetFile> listResult = search.getResult();

                    for (AssetFile file : listResult) {

                        String[] row = new String[]{file.getFileName(), Long.toString(file.getSize()), file.getPath(), Boolean.toString(file.getIsIsHidden())};
                        frame.getPanelSearch().addRow(row);
                    }

                } else {
                    System.out.println("Path no valid");
                }
            }
        });
    }
}
