package com.fundation.search.model;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is about search path with diferent criteria.
 */
public class Search {

    private List<File> fileList;

    /**
     * Search Class constructor.
     */
    public Search() {
        fileList = new ArrayList<>();
    }

    /**
     * search by path.
     * @param path is a String that contains path
     * @return list of Filesgi
     */
    public  List<File> searchByPath(String path) {
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
}
