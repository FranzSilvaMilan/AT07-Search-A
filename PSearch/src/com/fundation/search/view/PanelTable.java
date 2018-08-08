/*
 * @(#)PanelTable.java
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

import com.fundation.search.utils.LoggerSearch;
import org.apache.log4j.Logger;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * This class Search for four critearias path, name, size  and hidden.
 *
 * @author Franz Silva - AT-[07].
 * @version 1.0.
 */
public class PanelTable extends JPanel{
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;
    private static final Logger LOGGER = LoggerSearch.getInstance().getLogger();


    public PanelTable(){
        initTable();
    }
    //public void getPanelTable(){

    //}

    private void initTable() {
        LOGGER.info("initTable: enter");
        String columnHead[] = {"FOLDER","FILE", "SIZE", "PATH", "HIDDEN","EXTENSION",
                "OWNER","READ_ONLY","DATE_CREATE","DATE_MODIFIED","DATA_LAST_ACCESS",
                "FRAME_RATE","RESOLUTION","VIDEO_CODE","AUDIO_CODE","DURATION"};
        scrollPane = new JScrollPane();
        model = new DefaultTableModel(columnHead, 0);
        table = new JTable(model);
        int vertical = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int horizontal = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
        scrollPane = new JScrollPane(table,vertical,horizontal);
        setLayout(new BorderLayout());
        add(scrollPane);
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setPreferredSize(new Dimension(0, 0));
        setBounds(10, 310, 1180, 450);
        setBackground(new Color(250, 252, 252));
        LOGGER.info("initTable: exit");
    }



    public void addRow(String[] newRow) {
        model.addRow(newRow);
    }

    public void clean(){
        model.setNumRows(0);
    }


}
