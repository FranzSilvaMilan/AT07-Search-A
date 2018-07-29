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

public class CriteriaBuilder implements IBuilder {
    private Criteria criteria;


    public CriteriaBuilder() {
        criteria = new Criteria();
    }

    @Override
    public void buildFile(String path, String fileName, boolean hidden, Long size, String operator) {
        if (!path.isEmpty()) {
            System.out.println("set Path");
            criteria.setPath(path);
        }
        if (!fileName.isEmpty()) {
            System.out.println("set file ");
            criteria.setPath(fileName);
        }
        if (hidden) {
            System.out.println("set Hidden");
            criteria.setIshidden(hidden);
        }
        criteria.setSize(size);
        criteria.setOperator(operator);
    }

    @Override
    public void buildFileAdvance(boolean directory, boolean readOnly,
                                 String dateModifyFrom, String dateModifyTo, String dateCreateFrom,
                                 String dateCreateTo, String dateAccessFrom, String dateAccessTo) {

        if (directory) {
            criteria.setDirectory(directory);
        }
        if (readOnly) {
            criteria.setReadOny(readOnly);
        }
        if (!dateModifyFrom.isEmpty()) {
            criteria.setDateModificateFrom(dateModifyFrom);
        }
        if (!dateModifyTo.isEmpty()) {
            criteria.setDateModificateTo(dateModifyTo);
        }
        if (!dateCreateFrom.isEmpty()) {
            criteria.setDateCreateFrom(dateCreateFrom);
        }
        if (!dateCreateTo.isEmpty()) {
            criteria.setDateCreateTo(dateCreateTo);
        }
        if (!dateAccessFrom.isEmpty()) {
            criteria.setDateAccessFrom(dateAccessFrom);
        }
        if (!dateAccessTo.isEmpty()) {
            criteria.setDateAccessTo(dateAccessTo);
        }
    }

    @Override
    public void buildMultimedia() {

    }

    @Override
    public Criteria build() {
        return criteria;
    }
}
