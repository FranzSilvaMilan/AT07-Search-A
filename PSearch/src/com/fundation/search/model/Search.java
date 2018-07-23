/*
 * @(#)Search.java
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

package com.fundation.search.model;

import com.fundation.search.controller.Criteria;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class Search for four critearias path, name, size  and hidden.
 *
 * @author Franz Silva - AT-[07].
 * @author Denis Camacho - AT-[07].
 * @version 1.0.
 */
public class Search {



    private Criteria criteria;
    /**
     * fileList is a file list that save files according to criterias
     */
    private List<File> fileList;

    /**
     * Search Class constructor.
     */
    public Search() {
        fileList = new ArrayList<>();
    }

    /**
     * @param path .
     * @return list all the files contained within the path.
     */
    private List<File> searchByPath(String path) {
        try {
            File[] files = new File(path).listFiles();
            for (File file : files) {
                fileList.add(file);
                if (file.isDirectory()) {
                    searchByPath(file.getPath());
                }
            }
        } catch (NullPointerException e) {
        }
        return fileList;
    }

    /**
     * @param listFile .
     * @param nameFile .
     * @return list all the files that contains the name of a file.
     */
    private List<File> searchByName(List<File> listFile, String nameFile) {
        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            if (!file.getName().contains(nameFile)) {
                listFilter.add(file);
            }
        }
        listFile.removeAll(listFilter);
        return listFile;
    }

    /**
     * @param listFile file list.
     * @param size     is the file size.
     * @param operator is "<" or ">" or "=".
     * @return list all the files minor or major or equal to given size.
     */
    private List<File> searchBySize(List<File> listFile, double size, char operator) {

        List<File> listFilter = new ArrayList<>();
        for (File file : listFile) {
            if (operator == '=') {
                if (file.length() != size) {
                    listFilter.add(file);
                }
            }
            if (operator == '>') {
                if (file.length() < size) {
                    listFilter.add(file);
                }
            }
            if (operator == '<') {
                if (file.length() > size) {

                    listFilter.add(file);
                }
            }
        }
        listFile.removeAll(listFilter);
        return listFile;
    }

    /**
     * @param listFile list file
     * @param isHidden true.
     * @return list all the files minor or major or equal to given size.
     */

    private List<File> searchHiddenFiles(List<File> listFile, boolean isHidden) {
        if (isHidden) {
            return listFile.stream().filter(File::isHidden).collect(Collectors.toList());
        }
        return listFile;
    }

    /**
     * @param criteria receives Search Criteria object.
     *                 Is a method that filter a List according that receive of SearchCriteria.
     */
    public void searchByCriteria(Criteria criteria) {
        fileList =  new ArrayList<>();
        if (criteria.getPath() != null) {
            fileList = searchByPath(criteria.getPath());
            if (criteria.getFileName() != null) {
                fileList = searchByName(fileList, criteria.getFileName());
            }
            if (criteria.getSize() > -1) {
                fileList = searchBySize(fileList, criteria.getSize(), criteria.getOperator().charAt(0));
            }
            if (criteria.getIsIshidden()) {
                fileList = searchHiddenFiles(fileList, criteria.getIsIshidden());
            }
        }
    }

    /**
     * this method result of a search by criterias.
     *@return File Result list with the files already searched
     */
    public List<AssetFile> getResult() {
        List<AssetFile> result = new ArrayList<>();
        if (!fileList.isEmpty()) {
            for (File file : fileList) {
                result.add(new AssetFile(file.getPath(), file.getName(), file.length(), file.isHidden()));
            }
        }
        return result;
    }
}