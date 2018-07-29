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

public interface IBuilder {
    public void buildFile(String path, String fileName, boolean hidden, Long size, String operator);

    public void buildFileAdvance(boolean directory, boolean readOnly,
                                 String dateModifyIni, String dateModifyFin, String dateCreateIni,
                                 String dateCreateFin, String dateAccessini, String dateAccessFin);

    public void buildMultimedia();

    public Criteria build();
}
