/*
 * @(#)FrameMain.java
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


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;

/**
 * @author Ketty Camacho Vasquez.
 * @author Franz Elmer Silva Milan.
 * this is class is a Jframe fisrt,it contain panel of.
 * search panel of a archive and path.
 */
public class FrameMain  extends JFrame {
    /**
     * instance the object panelSearch, panelMultimedia, title and tab.
     */

    JLabel title;
    Tab tab;
    private PanelTable panelTable;

    /**
     * this is constructor of class {@link FrameMain}
     */

    public FrameMain() {
        iniComponent();
        settingFameMain();
        initComponentTable();
    }

    /**
     * this is method of configuration of Frame Main.
     */
    public void settingFameMain() {
        setLayout(null);
        setTitle("SEARCH");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        setVisible(true);
    }
    private void initComponentTable() {
        panelTable = new PanelTable();
        this.getContentPane().add(panelTable);
    }
    public void iniComponent() {

        tab = new Tab();
        tab.iniComponentsTab();
        add(tab);
    }
    public void addRow(String[] newRow) {
        panelTable.addRow(newRow);
    }
    public void cleanTable() {
        panelTable.clean();
    }

    public PanelSearch getPanelSearch() {
        return tab.getPanelSearch();
    }
    public PanelMultimedia getPanelMultimedia(){
        return  tab.panelMultimedia;
    }
}
