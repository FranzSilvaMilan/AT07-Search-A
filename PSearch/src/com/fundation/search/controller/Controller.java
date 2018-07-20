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
import com.fundation.search.utils.ValidatorData;
import com.fundation.search.view.FrameMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.List;

/**
 *
 * This class controller can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Denis Camacho - AT-[07].
 * @author Ketty Camacho- AT -[07].
 * @version 1.0.
 *
 */
public class Controller {
    FrameMain frame;
    Criteria criteria;
    ValidatorData validator;
    //List<AssetFile> listResult;
    public  Controller()
    {
        frame = new FrameMain();
        criteria = new Criteria();
        validator = new ValidatorData();
        actionListener();


    }
    public void actionListener(){
        frame.getPanelSearch().getButtoSearsh().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if(validator.isPathValid(frame.getPanelSearch().getTextPath())){
                    criteria.setPath(frame.getPanelSearch().getTextPath());
                }else {
                    System.out.println("Path no valid");
                    System.out.println(frame.getPanelSearch().getTextPath());
                    String valu = frame.getPanelSearch().getTextFile();
                    String[] row=new String[]{valu,"Size","file","ii"};
                    frame.getPanelSearch().addRow(row);
                }




                // System.out.println("This is my Name:");
            }

        });
    }

}
