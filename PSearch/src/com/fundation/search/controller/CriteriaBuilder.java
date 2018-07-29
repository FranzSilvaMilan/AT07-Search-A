/*******************************************************************************
 *
 *  * @(#)Criteria.java
 *  *
 *  * Copyright (c) 2018 Jala Foundation.
 *  * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 *  * All rights reserved.
 *  *
 *  * This software is the confidential and proprietary information of
 *  * Jala Foundation, ("Confidential Information").  You shall not
 *  * disclose such Confidential Information and shall use it only in
 *  * accordance with the terms of the license agreement you entered into
 *  * with Jala Foundation.
 *
 ******************************************************************************/

package com.fundation.search.controller;

import java.util.ArrayList;

public class CriteriaBuilder implements IBuilder {
    private Criteria criteria;


    public CriteriaBuilder() {
        criteria = new Criteria();
    }

    @Override
    public void buildFile(String path, String fileName, boolean hidden, Long size, String operator) {
        if (!path.isEmpty()) {
            criteria.setPath(path);
        }
        if (!fileName.isEmpty()) {
            criteria.setFileName(fileName);
        }
        if (hidden) {
            criteria.setIshidden(hidden);
        }
        criteria.setSize(size);
        criteria.setOperator(operator);
    }

    @Override
    public void buildFileAdvance(boolean directory, boolean readOnly,
                                 String dateModifyFrom, String dateModifyTo, String dateCreateFrom,
                                 String dateCreateTo, String dateAccessFrom, String dateAccessTo,
                                 boolean keysensitive, String owner, String contain, ArrayList<String> extensions) {

        if (directory) criteria.setDirectory(directory);
        if (readOnly) criteria.setReadOnly(readOnly);
        if (!dateModifyFrom.isEmpty()) criteria.setDateModificateFrom(dateModifyFrom);
        if (!dateModifyTo.isEmpty()) criteria.setDateModificateTo(dateModifyTo);
        if (!dateCreateFrom.isEmpty()) criteria.setDateCreateFrom(dateCreateFrom);
        if (!dateCreateTo.isEmpty()) criteria.setDateCreateTo(dateCreateTo);
        if (!dateAccessFrom.isEmpty()) criteria.setDateAccessFrom(dateAccessFrom);
        if (!dateAccessTo.isEmpty()) criteria.setDateAccessTo(dateAccessTo);
        if (keysensitive) criteria.setKeySensitive(keysensitive);
        if (!owner.isEmpty()) criteria.setOwner(owner);
        if (!contain.isEmpty()) criteria.setContent(contain);
        if (!extensions.isEmpty()) criteria.setListExtensions(extensions);
    }

    @Override
    public void buildMultimedia() {

    }

    @Override
    public Criteria build() {
        return criteria;
    }
}
