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
import com.fundation.search.utils.ValidatorData;
import com.fundation.search.view.FrameMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
    public Controller() {
        frame = new FrameMain();
        criteria = new Criteria();
        validator = new ValidatorData();
        actionListener();


    }

    /**
     *
     */


    public void actionListener(){
        frame.getPanelSearch().getButtoSearsh().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if(validator.isPathValid(frame.getPanelSearch().getTextPath())){

                    System.out.println(frame.getPanelSearch().getOperator());
                    System.out.println(frame.getPanelSearch().getSize());


                    Criteria criteria = new Criteria()
                            .path(frame.getPanelSearch().getTextPath())
                            .fileName(frame.getPanelSearch().getTextFile())
                            .operator(frame.getPanelSearch().getOperator());

                    getFilesFilterByCriteria(criteria);
                }else {

                }




                // System.out.println("This is my Name:");
            }

        });
    }

    /**
     *
     * @param criteria
     */
    public void getFilesFilterByCriteria(Criteria criteria)
    {

        List<AssetFile> files = new ArrayList<AssetFile>();
        try (Stream<Path> filePathStream=Files.walk(Paths.get(criteria.getPath()))) {
            filePathStream.forEach(filePath -> {

                File file = new File(filePath.toString());
                AssetFile fileInf = new AssetFile();
                fileInf.setSize(file.length());
                fileInf.setFileName(file.getName());
                fileInf.setIsHidden(file.isHidden());
                fileInf.setPath(file.getPath());

                files.add(fileInf);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("steps");


        for (AssetFile f: getFilterByCriteria(files, criteria)) {

            System.out.println("steps 1");
            String[] row=new String[]{f.getFileName(),String.valueOf

                    (f.getSize()),f.getPath(),Boolean.toString(f.getIsIsHidden())};
            frame.getPanelSearch().addRow(row);
        }
    }

    private List<AssetFile> getFilterByCriteria(List<com.fundation.search.model.AssetFile> files, Criteria criteria) {
        return files.stream().filter(afile -> afile.getFileName().equalsIgnoreCase(criteria.getFileName()) && criteria.getSize() < afile.getSize()).collect(Collectors.toList());
    }


}
