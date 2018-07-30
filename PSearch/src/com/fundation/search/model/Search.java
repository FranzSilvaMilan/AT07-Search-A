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
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
                data.setDateCreate(fileDateCreate(file.getPath()));
                data.setFileDateModified(fileDateModified(file.getPath()));
                data.setReadOnly(!file.canWrite());
                String[] folders = file.getParent().split("/");
                System.out.println("Folder path:"+folders.toString());
                data.setFolderName(folders[folders.length-1]);
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
    private void searchByName(String nameFile, boolean keysensitive) {
        List<AssetFile> listFilter = new ArrayList<>();
        for (AssetFile file : fileList) {
            if(keysensitive){
                if(file.getFileName().equals(nameFile)){
                    listFilter.add(file);
                }
            }else {
                if (file.getFileName().equalsIgnoreCase(nameFile)) {
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
    // public void searchByExtention(String extension) {
    //   fileList.stream().filter(file -> file.getFileName().endsWith(extension)).collect(Collectors.toList());
    //}

    /**MODIFIC.
     * modificar los metodo date.
     * sheardateCrete:
     * data timpedate.
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

    /** changeDate
     * Time stamp
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

            if(criteria.getReadOnly())
            {
                searchByReadOnly(criteria.getReadOnly());
            }

            /**if (!criteria.getListExtensions().isEmpty()) {

                searchByExtension(criteria.getListExtensions());
            }**/

            if (!criteria.getListExtensions().isEmpty()) {

                searchByExtension(criteria.getListExtensions());
            }



        }
    }

    /**
     *
     * @param extensions
     */
    public void searchByExtension(List<String> extensions) {
        List<AssetFile> listFilter = new ArrayList<AssetFile>();

        for (AssetFile file : fileList) {
            for (String fileExt : extensions) {
                if (file.getFileName().endsWith(fileExt)) {
                    listFilter.add(file);
                }
            }
        }
        fileList.clear();
        fileList.addAll(listFilter);
    }

    /**
     *
     * @param readOnly
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
     * this method result of a search by criterias.
     *
     * @return File Result list with the files already searched
     */
    public List<AssetFile> getResult() {

        return fileList;
    }
}