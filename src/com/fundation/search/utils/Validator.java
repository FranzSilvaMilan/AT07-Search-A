package com.fundation.search.utils;

/**
 * This is the main class of Validator.
 */
public class Validator {
    /**
     * @param path is the data from finds the files.
     * @return if is validate of data.
     */
    public boolean isPathValidation(String path) {
        return path.matches("([A-Z]:)?(\\\\[a-zA-Z0-9_-]+)+\\\\?");

    }
}
