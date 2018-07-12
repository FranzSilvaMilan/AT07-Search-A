package com.fundation.search.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * this class is about search path with diferent criteria.
 */
public class Search {

    private List<File> fileListResults;//list that store the result

    /**
     * Search Class constructor.
     */
    public Search() {
        fileListResults = new ArrayList<>();
    }

    /**
     * search by path.
     *
     * @param path is a String that contains path
     * @return list of Files
     */
    public List<File> searchByPath(String path) {
        try {
            File[] files = new File(path).listFiles();
            Arrays.stream(files).forEachOrdered(file -> {
                fileListResults.add(file);
                if (file.isDirectory()) {
                    searchByPath(file.getPath());
                }
            });
        } catch (NullPointerException e) {
        }
        return fileListResults;
    }

    /**
     * this method filter about file name.
     *
     * @param listFile list files that contains all files.
     * @param nameFile the name of file that
     * @return
     */
    public List<File> searchByName(List<File> listFile, String nameFile) {
        return listFile.stream().filter(file -> file.getName().contains(nameFile)).collect(Collectors.toList());
    }
}
