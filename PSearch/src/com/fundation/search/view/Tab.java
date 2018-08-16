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

import javax.swing.*;

import java.awt.*;

/**
 * This class Search for four critearias path, name, size  and hidden.
 *
 * @author Franz Silva - AT-[07].
 * @author Ketty Camacho - AT-[07].
 * @author Denis Camacho - AT-[07].
 * @version 1.0.
 */
public class Tab extends JTabbedPane {

    PanelSearch panelSearch;
    PanelMultimedia panelMultimedia;

    public void iniComponentsTab() {
        panelSearch = new PanelSearch();
        panelMultimedia = new PanelMultimedia();
        enableSetupContainer(false);

        panelSearch.setBackground(Color.white);
        setBounds(10, 10, 1180, 300);

        panelMultimedia.enableMediaSetup.addActionListener(event -> {
            JCheckBox cb = (JCheckBox) event.getSource();
            if (cb.isSelected()) {
                enableSetupContainer(true);
            } else {
                enableSetupContainer(false);
            }
        });

        add("FILE", panelSearch);
        addTab("MULTIMEDIA/DB", panelMultimedia);
    }


    public void enableSetupContainer(boolean b) {

        panelMultimedia.containerFileExtensions.setEnabled(b);
        for (Component cp : panelMultimedia.containerFileExtensions.getComponents()) {
            cp.setEnabled(b);
        }

        panelMultimedia.containerFileSetup.setEnabled(b);
        for (Component cp : panelMultimedia.containerFileSetup.getComponents()) {
            cp.setEnabled(b);
        }

        panelSearch.enableComponents(!b);

    }

    /**
     * @return
     */
    public PanelSearch getPanelSearch() {
        return panelSearch;
    }

}
