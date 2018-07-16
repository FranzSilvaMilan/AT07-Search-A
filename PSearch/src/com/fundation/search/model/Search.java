package com.fundation.search.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is about search path with diferent criteria.
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
    public List<File> searchBySize(List<File> listFile, int size, int operator) {
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
}
