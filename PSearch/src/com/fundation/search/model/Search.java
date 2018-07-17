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

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
    private List<File> fileList;

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
    public List<File> searchByPath(String path) {
        try {
            File[] files = new File(path).listFiles();
            Arrays.stream(files).forEachOrdered(file -> {
                fileList.add(file);
                if (file.isDirectory()) {
                    searchByPath(file.getPath());
                }
            });
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
    public List<File> searchByName(List<File> listFile, String nameFile) {
        return listFile.stream().filter(file -> file.getName().contains(nameFile)).collect(Collectors.toList());
    }

    /**
     * This method search by Size.
     *
     * @param listFile This list contains files
     * @param size     that search
     * @param operator that have the criteria
     * @return files that are filters
     */
    public List<File> searchBySize(List<File> listFile, long size, int operator) {
        List<File> listFilter = new ArrayList<>();
        listFile.forEach(file -> {
            if (operator == 0) {
                if (file.length() == size) {
                    listFilter.add(file);
                }
            }
            if (operator == 1) {
                if (file.length() < size) {
                    listFilter.add(file);
                }
            }
            if (operator == 2) {
                if (file.length() > size) {
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
    public List<File> searchByHidden(List<File> listFile, boolean isHidden) {
        if (isHidden) {
            return listFile.stream().filter(File::isHidden).collect(Collectors.toList());
        }
        return listFile;
    }

    public List<File> searchByExtention(List<File> listfile, String extension) {
        return listfile.stream().filter(file -> file.getName().endsWith(extension)).collect(Collectors.toList());
    }

    /**
     * @param criteria
     */
    public void searchByCriteria(Criteria criteria) {
        if (criteria.getPath() == null) {
            return;
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
    }

    public List<AssetFile> getResult() {
        return fileList.stream()
                .map(file -> new AssetFile(file.getPath(), file.getName(), file.length(), file.isHidden()))
                .collect(Collectors.toList());
    }
}
