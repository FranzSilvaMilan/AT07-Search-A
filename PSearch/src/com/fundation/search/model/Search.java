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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.io.IOException;
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
     */
    public void searchByPath(String path) {
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
     * This method search by Name.
     *
     * @param nameFile criteria with file name
     */
    public void searchByName(String nameFile) {
        fileList.stream().filter(file -> file.getFileName().contains(nameFile)).collect(Collectors.toList());
    }

    /**
     * This method search by Size.
     *
     * @param size     that search
     * @param operator that have the criteria
     */
    public void searchBySize(long size, String operator) {
        List<AssetFile> listFilter = new ArrayList<>();
        fileList.forEach(file -> {
            if (operator.equals("=")) {
                if (file.getSize() == size) {
                    listFilter.add(file);
                }
            }
            if (operator.equals("<")) {
                if (file.getSize() < size) {
                    listFilter.add(file);
                }
            }
            if (operator.equals(">")) {
                if (file.getSize() > size) {
                    listFilter.add(file);
                }
            }
        });
    }

    /**
     * This method search by hidden.
     *
     * @param isHidden Criteria is hidden
     */
    public void searchByHidden(boolean isHidden) {
        if (isHidden) {
            fileList.stream().filter(AssetFile::getIsIsHidden).collect(Collectors.toList());
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
     * this medthod search date Creation.
     *
     * @param date is date of creation file.
     */
    public void searchByDateCreation(String date) {
        List<AssetFile> listFilter = new ArrayList<>();
        fileList.forEach(file -> {
            if (file.getDateCreate().equals(date)) {
                listFilter.add(file);

            }
        });
    }

    /**
     * this medthod search date Modified.
     *
     * @param date is date of modified file.
     */
    public void searchByDateModified(String date) {
        List<AssetFile> listFilter = new ArrayList<>();
        fileList.forEach(file -> {
            if (file.getDateModified().equals(date)) {
                listFilter.add(file);

            }
        });
    }

    /**
     * this method search a object criteria.
     *
     * @param criteria
     *            is a criteria for search.
     */

    /**
     * this method search a object criteria.
     *
     * @param criteria is a criteria for search.
     */
    public void searchByCriteria(Criteria criteria) {
        if (criteria.getPath() == null) {
            // return null;
        }
        searchByPath(criteria.getPath());
        if (criteria.getFileName() != null) {
            searchByName(criteria.getFileName());
        }
        if (criteria.getSize() >= 0) {
            searchBySize(criteria.getSize(), criteria.getOperator());
        }
        if (criteria.getIsIshidden()) {
            searchByHidden(criteria.getIsIshidden());
        }

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
     * @return the list of file find.
     */
    public List<AssetFile> getResult() {
        return fileList;
    }
}