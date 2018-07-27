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

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;

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


    public PanelTable(){
        initTable();
    }

    private void initTable() {
        String columnHead[] = {"FOLDER","FILE", "SIZE", "PATH", "HIDDEN","EXTENSION","OWNER","DATE_CREATE","DATE_MODIFIED"};
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
        setBounds(10, 220, 1150, 450);
    }

    public void addRow(String[] newRow) {
        model.addRow(newRow);
    }

    public void clean(){
        model.setNumRows(0);
    }


}
