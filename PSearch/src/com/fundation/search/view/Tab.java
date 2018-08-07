/*
 * @(#)Tab.java
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
package com.fundation.search.view;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.*;

/**
 * This class Search for four critearias path, name, size  and hidden.
 *
 * @author Franz Silva - AT-[07].
 * @version 1.0.
 */
public class Tab extends JTabbedPane{

    PanelSearch panelSearch;
    PanelMultimedia panelMultimedia;
    //panel data base
    //PanelDataBase panelDataBase;


    public void iniComponentsTab(){
        panelSearch = new PanelSearch();
        panelMultimedia = new PanelMultimedia();


        panelSearch.setBackground(Color.white);
        //panelMultimedia.setBounds(10,10,1180,200);
        setBounds(10, 10, 1180, 800);
        add("FILE", panelSearch);
        addTab("MULTIMEDIA", panelMultimedia);

        //addTab("Welcome",new JLabel(new ImageIcon("bksqla_xlargecover.jpg")));
        //ImageIcon tab1Icon = new ImageIcon(
        //this.getClass().getResource("/images/test-pass-icon.png"));
    }

    public PanelSearch getPanelSearch(){
        return panelSearch;
    }

    public PanelMultimedia getPanelMultimedia() {
        return panelMultimedia;
    }
}
