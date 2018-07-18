/**
 * @(#)Asset.java Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package com.fundation.search.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Model.Model;
import View.ViewInterface;
import utils.ValidatorData;

/**
 *
 * This class Asset can be FileResult, MultimediaResult and maybe SearchFolder.
 *
 * @author Denis Camacho - AT-[07].
 * @version 1.0.
 */
public class Controller {
    private Model model;
    private ViewInterface view;
    private ValidatorData valid;
    private String path;
    private String size;

    /**
     * builder of class Controller.
     */
    public Controller() {
        model = new Model();
        view = new ViewInterface();
        valid = new ValidatorData();
    }

    /**
     * Show the file in the UI.
     */
    public void showFile() {

        if (valid.isPathValid(getPath())) {
            List<File> resultSearch = new ArrayList<>();
            resultSearch = this.model.searchByPath(getPath());
            for (File file : resultSearch) {
                System.out.println(file);
            }
        } else {
            System.out.println("path no valido");
        }
    }

    /**
     * view if data of size is valid.
     */
    public void viewValidSize() {
        System.out.println(valid.isSizeValid(getSize()));
    }

    /**
     *
     * @return getters of methods.
     */
    public String getPath() {
        return path;
    }

    public String getSize() {
        return size;
    }

    /**
     *
     * @param path
     *            is of data of setup.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     *
     * @param size
     *            is of data of setup.
     */
    public void setSize(String size) {
        this.size = size;
    }

}

