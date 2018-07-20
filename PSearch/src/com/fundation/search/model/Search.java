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
 * @version 1.0.
 */
public class Search {
    /**
     * This variable contens all files searched.
     */
    private List<AssetFile> fileList;
    private AssetFile data;

    /**
     * Search Class constructor.
     */
    public Search() {
        fileList = new ArrayList<>();
    }

    /**
     * This method search by path.
     *
     * @param path is a String that contains path
     * @return list of Files filters
     */
    public List<AssetFile> searchByPath(String path) {
        try {
            File[] files = new File(path).listFiles();
            for (File file : files) {
                data = new AssetFile();
                data.setPath(file.getPath());
                data.setFileName(file.getName());
                data.setIsHidden(file.isHidden());
                data.setSize(file.length());
                fileList.add(data);
                if (file.isDirectory()) {
                    searchByPath(file.getPath());
                }
            }
        } catch (NullPointerException e) {
        }
        return fileList;
    }

    /**
     * This method search by Name.
     *
     * @param listFile the list that contains files
     * @param nameFile criteria with file name
     * @return the list filter
     */
    public List<AssetFile> searchByName(List<AssetFile> listFile, String nameFile) {
        return listFile.stream().filter(file -> file.getFileName().contains(nameFile)).collect(Collectors.toList());
    }

    /**
     * This method search by Size.
     *
     * @param listFile This list contains files
     * @param size     that search
     * @param operator that have the criteria
     * @return files that are filters
     */
    public List<AssetFile> searchBySize(List<AssetFile> listFile, long size, int operator) {
        List<AssetFile> listFilter = new ArrayList<>();
        listFile.forEach(file -> {
            if (operator == 0) {
                if (file.getSize() == size) {
                    listFilter.add(file);
                }
            }
            if (operator == 1) {
                if (file.getSize() < size) {
                    listFilter.add(file);
                }
            }
            if (operator == 2) {
                if (file.getSize() > size) {
                    listFilter.add(file);
                }
            }
        });
        return listFilter;
    }

    /**
     * This method search by hidden.
     *
     * @param listFile This list contains files
     * @param isHidden Criteria is hidden
     * @return list that is filterd
     */
    public List<AssetFile> searchByHidden(List<AssetFile> listFile, boolean isHidden) {
        if (isHidden) {
            return listFile.stream().filter(AssetFile::getIsIsHidden).collect(Collectors.toList());
        }
        return listFile;
    }

    /**
     * this medthod search extension.
     *
     * @param listfile  is a list filterd.
     * @param extension type of extension that search.
     * @return a list that is filterd.
     */
    public List<AssetFile> searchByExtention(List<AssetFile> listfile, String extension) {
        return listfile.stream().filter(file -> file.getFileName().endsWith(extension)).collect(Collectors.toList());
    }

    /**
     * this method search a object criteria.
     *
     * @param criteria is a criteria for search.
     */
    public List<AssetFile> searchByCriteria(Criteria criteria) {
        if (criteria.getPath() == null) {
            return null;
        }
        fileList = searchByPath(criteria.getPath());
        if (criteria.getFileName() != null) {
            fileList = searchByName(fileList, criteria.getFileName());
        }
        if (criteria.getSize() >= 0) {
            fileList = searchBySize(fileList, criteria.getSize(), criteria.getOperator());
        }
        if (criteria.getIsIshidden()) {
            fileList = searchByHidden(fileList, criteria.getIsIshidden());
        }
        return fileList;
    }

    /**
     * @return the list of file find.
     */
    public List<AssetFile> getResult() {
        return fileList;
    }
}
