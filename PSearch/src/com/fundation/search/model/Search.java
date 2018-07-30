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
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

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
                data.setIshidden(file.isHidden());
                data.setSize(file.length());
                data.setOwner(owner);
                data.setDirectory(file.isDirectory());
                data.setDateCreateFrom("");
                data.setDateModificateFrom("");
                data.setReadOnly(!file.canWrite());
                fileList.add(data);
                if (file.isDirectory()) {
                    data.setFileName(file.getName());
                    data.setExtensions("");
                    searchByPath(file.getPath());
                } else {
                    String[] fileN = file.getName().split("\\.");
                    StringJoiner name = new StringJoiner(".");
                    for(int i =0; i<fileN.length-1;i++){
                        name.add(fileN[i]);
                    }
                    data.setFileName(name.toString());
                    data.setExtensions("."+fileN[fileN.length-1]);
                }

            }
        } catch (NullPointerException | IOException e) {
        }
    }

    /**
     * @param nameFile .
     */
    private void searchByName(String nameFile, boolean keysensitive) {
        List<AssetFile> listFilter = new ArrayList<>();
        for (AssetFile file : fileList) {
            if (keysensitive) {
                if (file.getFileName().contains(nameFile)) {
                    listFilter.add(file);
                }
            } else {
                if (file.getFileName().toUpperCase().contains(nameFile.toUpperCase())) {
                    listFilter.add(file);
                }
            }
        }
        fileList.clear();
        fileList.addAll(listFilter);
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
     * This method has the function to filter file by hidden
     *
     * @param isHidden has the value true or false to display the hidden files.
     */

    private void searchHiddenFiles(boolean isHidden) {
        List<AssetFile> listFilter = new ArrayList<>();
        if (isHidden) {
            for (AssetFile file : fileList) {
                if (!file.getIsIshidden()) {
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
    // public void searchByExtention(String extension) {
    //   fileList.stream().filter(file -> file.getFileName().endsWith(extension)).collect(Collectors.toList());
    //}

    /**
     * MODIFIC.
     * modificar los metodo date.
     * sheardateCrete:
     * data timpedate.
     *
     * @param date is of date of creation.
     * @return date of creation of file.
     */
    public Timestamp fileDateCreate(String date) {
        String formatted = "";
        BasicFileAttributes attrs;
        try {
            Path path = Paths.get(date);
            attrs = Files.readAttributes(path, BasicFileAttributes.class);
            FileTime time = attrs.creationTime();
            String pattern = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            formatted = simpleDateFormat.format(new Date(time.toMillis()));
            //return formatted;
        } catch (IOException e) {
        }
        return null;
    }

    /**
     * changeDate
     * Time stamp
     *
     * @param date is date of modified.
     * @return of date of modified of file.
     */
    public Timestamp fileDateModified(String date) {
        String formatted = "";
        try {
            Path path = Paths.get(date);
            FileTime time = Files.getLastModifiedTime(path);
            String pattern = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            formatted = simpleDateFormat.format(new Date(time.toMillis()));
            //return formatted;
            //return time.
        } catch (IOException e) {
        }
        return null;
    }

    /**
     * This method has the function to filter files by all setted parameters
     *
     * @param criteria receives Search Criteria object.
     *                 Is a method that filter a List according that receive of SearchCriteria.
     */
    public void searchByCriteria(Criteria criteria) {
        if (criteria.getPath() != null) {
            fileList = new ArrayList<>();
            searchByPath(criteria.getPath());
            if (criteria.getFileName() != null) {
                searchByName(criteria.getFileName(), criteria.isKeySensitive());
            }
            if (criteria.getSize() > -1) {
                searchBySize(criteria.getSize(), criteria.getOperator().charAt(0));
            }
            if (criteria.getIsIshidden()) {
                searchHiddenFiles(criteria.getIsIshidden());
            }
            if (criteria.getReadOnly()) {
                searchByReadOnly(criteria.getReadOnly());
            }
            if (!criteria.getListExtensions().isEmpty()) {

                searchByExtension(criteria.getListExtensions());
            }
            if (criteria.getOwner() != null) {
                searchByOwner(criteria.getOwner());
            }
            if (criteria.getDirectory()) {
                searchByFolder(criteria.getDirectory());
            }
        }
    }

    /**
     * This Method has the function to filter by extension e.g. exe, pdf, txt.
     *
     * @param extensions content the extensions tha must be filter.
     */
    public void searchByExtension(List<String> extensions) {
        List<AssetFile> listFilter = new ArrayList<AssetFile>();

        for (AssetFile file : fileList) {
            for (String fileExt : extensions) {
                if (file.getExtensions().endsWith(fileExt)) {
                    listFilter.add(file);
                }
            }
        }
        fileList.clear();
        fileList.addAll(listFilter);
    }

    /**
     * This method has the function to filter by privilege
     *
     * @param readOnly has the value true o false to display the file with privilege read only.
     */

    public void searchByReadOnly(boolean readOnly) {
        List<AssetFile> listFilter = new ArrayList<>();

        if (readOnly) {

            for (AssetFile file : fileList) {

                if (file.getReadOnly()) {
                    listFilter.add(file);
                }

            }
            fileList.clear();
            fileList.addAll(listFilter);
        }
    }

    /**
     * This metho has the function to filter by owner.
     *
     * @param owner is the name of the owner of the file
     */
    public void searchByOwner(String owner) {
        List<AssetFile> listFilter = new ArrayList<AssetFile>();
        for (AssetFile file : fileList) {
            if (file.getOwner().equalsIgnoreCase(owner)) {
                listFilter.add(file);
            }
        }
        fileList.clear();
        fileList.addAll(listFilter);
    }


    /**
     * This metho has the function to filter the folders
     *
     * @param isFolder has the value true or false if the folder is going to display.
     */
    public void searchByFolder(boolean isFolder) {
        List<AssetFile> listFilter = new ArrayList<AssetFile>();
        for (AssetFile file : fileList) {
            if (file.getDirectory() == isFolder) {
                listFilter.add(file);
            }
        }
        fileList.clear();
        fileList.addAll(listFilter);
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