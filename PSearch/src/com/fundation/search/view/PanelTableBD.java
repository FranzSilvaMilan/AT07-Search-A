/*
 * @(#)PanelTableDB.java
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

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;

/**
 * This class Search for four critearias path, name, size  and hidden.
 *
 * @author Ketty Camacho - AT-[07].
 * @author Denis Camacho - AT-[07].
 * @version 1.0.
 */
public class PanelTableBD extends JPanel {

    private DefaultTableModel modelDB;
    private DefaultTableCellRenderer render;
    private JTable table;
    private JScrollPane scrollPane;

    /**
     *
     */
    public PanelTableBD() {

        tableBD();
    }

    /**
     *
     */
    private void tableBD() {
        String columnHeadBD[] = {"Nro", "NAMES"};

        scrollPane = new JScrollPane();
        modelDB = new DefaultTableModel(columnHeadBD, 0);
        table = new JTable(modelDB);
        int vertical = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int horizontal = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
        scrollPane = new JScrollPane(table, vertical, horizontal);
        setLayout(new BorderLayout());
        add(scrollPane);
        render = new DefaultTableCellRenderer();
        render.setPreferredSize(new Dimension(0, 0));
        setBounds(700, 100, 450, 100);

        setBackground(new Color(250, 252, 252));

    }

    /**
     * @param newRow
     */
    public void addRow(String[] newRow) {
        modelDB.addRow(newRow);
    }

    /**
     *
     */
    public void clean() {
        modelDB.setNumRows(0);
    }

    /**
     * @return
     */
    public DefaultTableModel getModelDB() {
        return modelDB;
    }

    /**
     * @return
     */
    public JTable getTable() {
        return table;
    }
}


