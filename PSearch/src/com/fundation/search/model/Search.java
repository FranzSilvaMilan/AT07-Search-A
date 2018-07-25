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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private List<AssetFile> fileList;
    private AssetFile data;

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
    private void searchByPath(String path) {
        try {
            File[] files = new File(path).listFiles();
            for (File file : files) {
                Path path1 = Paths.get(file.getPath());
                String owner = Files.getOwner(path1).toString();
                data = new AssetFile();
                data.setPath(file.getPath());
                data.setFileName(file.getName());
                data.setIsHidden(file.isHidden());
                data.setSize(file.length());
                data.setOwner1(owner);
                data.setDateCreate(dateCreate(file.getPath()));
                data.setDateModified(dateModified(file.getPath()));
                fileList.add(data);
                if (file.isDirectory()) {
                    searchByPath(file.getPath());
                }
            }
        } catch (NullPointerException | IOException e) {
        }
    }

    /**
     * @param nameFile .
     */
    private void searchByName(String nameFile) {
        List<AssetFile> listFilter = new ArrayList<>();
        for (AssetFile file : fileList) {
            if (!file.getFileName().contains(nameFile)) {
                listFilter.add(file);
            }
        }
        fileList.removeAll(listFilter);
    }

    /**
     * @param size     is the file size.
     * @param operator is "<" or ">" or "=".
     */
    private void searchBySize(double size, char operator) {

        List<AssetFile> listFilter = new ArrayList<>();
        for (AssetFile file : fileList) {
            if (operator == '=') {
                if (file.getSize() != size) {
                    listFilter.add(file);
                }
            }
            if (operator == '>') {
                if (file.getSize() < size) {
                    listFilter.add(file);
                }
            }
            if (operator == '<') {
                if (file.getSize() > size) {

                    listFilter.add(file);
                }
            }
        }
        fileList.removeAll(listFilter);
    }

    /**
     * @param isHidden true.
     */

    private void searchHiddenFiles(boolean isHidden) {
        List<AssetFile> listFilter = new ArrayList<>();
        if (isHidden) {
            for (AssetFile file : fileList) {
                if (!file.getIsIsHidden()) {
                    listFilter.add(file);
                }
            }
            fileList.removeAll(listFilter);

        }
    }

    /**
     * this medthod search extension.
     *
     * @param extension type of extension that search.
     */
    public void searchByExtention(String extension) {
        fileList.stream().filter(file -> file.getFileName().endsWith(extension)).collect(Collectors.toList());
    }

    /**
     * @param date is of date of creation.
     * @return date of creation of file.
     */
    public String dateCreate(String date) {
        String formatted = "";
        BasicFileAttributes attrs;
        try {
            Path path = Paths.get(date);
            attrs = Files.readAttributes(path, BasicFileAttributes.class);
            FileTime time = attrs.creationTime();
            String pattern = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            formatted = simpleDateFormat.format(new Date(time.toMillis()));
            return formatted;
        } catch (IOException e) {
        }
        return formatted;
    }

    /**
     * @param date is date of modified.
     * @return of date of modified of file.
     */
    public String dateModified(String date) {
        String formatted = "";
        try {
            Path path = Paths.get(date);
            FileTime time = Files.getLastModifiedTime(path);
            String pattern = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            formatted = simpleDateFormat.format(new Date(time.toMillis()));
            return formatted;
        } catch (IOException e) {
        }
        return formatted;
    }

    /**
     * @param criteria receives Search Criteria object.
     *                 Is a method that filter a List according that receive of SearchCriteria.
     */
    public void searchByCriteria(Criteria criteria) {
        if (criteria.getPath() != null) {
            fileList = new ArrayList<>();
            searchByPath(criteria.getPath());
            if (criteria.getFileName() != null) {
                searchByName(criteria.getFileName());
            }
            if (criteria.getSize() > -1) {
                searchBySize(criteria.getSize(), criteria.getOperator().charAt(0));
            }
            if (criteria.getIsIshidden()) {
                searchHiddenFiles(criteria.getIsIshidden());
            }
        }
    }

    /**
     * this method result of a search by criterias.
     *
     * @return File Result list with the files already searched
     */
    public List<AssetFile> getResult() {

        return fileList;
    }
}