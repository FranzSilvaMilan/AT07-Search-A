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
import java.util.Date;

public interface IBuilder {
    public void buildFile(String path, String fileName, boolean hidden, Long size, String operator);

    public void buildFileAdvance(boolean directory, boolean readOnly,
                                 Date dateModifyIni, Date dateModifyFin, Date dateCreateIni,
                                 Date dateCreateFin, Date dateAccessini, Date dateAccessFin,
                                 boolean keysensitive, String owner, String contain, ArrayList<String> extensions,boolean multimediaSelected);

    public void buildMultimedia(String frameRare,String videoCode,String audioCode,String resolution,double duration,String operatorDurationTime,
                                ArrayList<String> extensionVideo);

    public Criteria build();
}
