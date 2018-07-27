/*
 * @(#)PanelSearch.java
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

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileSystemView;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * This class Asset can be FileResult SearchFolder.
 *
 * @author ketty camacho Vasquez- AT-[07].
 * @author Franz Elmer Silva Milan.
 * @author Denis camacho Camacho- AT-[07].
 * @version 1.0.
 */
public class PanelSearch extends JPanel {
    private JTextField textFile;
    private JTextField textPath;
    private JTextField textExtension;
    private JTextField textContain;
    private JDateChooser dateCreate;
    private JDateChooser dateCreateTo;
    private JDateChooser dateModified;
    private JDateChooser dateModifiedTo;
    private JDateChooser dateLastAccess;
    private JDateChooser dateLastAccessTo;
    private JButton buttonSearch;
    private JCheckBox hiddenCheck;
    private String[] operatorOptions;
    private JComboBox<String> operator;
    private JButton btSelect;
    /**
     * array that contains units of the bytes,kb,Mb and Gb.
     */
    private String[] listUnitSize;
    private JComboBox<String> optionUnitsSize;

    private JLabel LabelSize;
    private JLabel labelFile;
    private JLabel labelPhat;
    private JLabel labelHidden;
    private JLabel labelOwner;
    private JLabel labelSearchExtension;
    private JLabel labelSearchOthers;
    private JLabel labelFrom;
    private JLabel labelTo;
    private JLabel labelFromM;
    private JLabel labelToM;
    private JLabel labelFromL;
    private JLabel labelToL;

    PanelTable panelTable;

    JSpinner spinnerSize;
    JRadioButton hidden;
    ButtonGroup radioGruop;

    private JCheckBox pdf;
    private JCheckBox docx;
    private JCheckBox exe;
    private JCheckBox gif;
    private JCheckBox ppt;
    private JCheckBox zip;
    private JCheckBox xlsx;
    private JCheckBox rar;
    private JCheckBox enableCreate;
    private JCheckBox enableModified;
    private JCheckBox enableLastAccess;
    private JCheckBox enableOnlyRead;
    private JCheckBox enableSensitiveFile;
    private Border blacking;
    private Border loweredetched;


    /**
     * this is constructor of the class PanelSearch.
     */

    public PanelSearch() {
        settingPanelSearch();
        initComponet();
        initComponentTable();
        settingPanel();
        addComponents();
    }

    private void initComponet() {
        listUnitSize = new String[]{"bytes", "Kb", "Mb", "Gb"};
        operatorOptions = new String[]{">", "<", "="};
        textFile = new JTextField();
        dateCreate = new JDateChooser(null, "dd/MM/yyyy");
        dateCreateTo = new JDateChooser(null, "dd/MM/yyyy");
        dateModified = new JDateChooser(null, "dd/MM/yyyy");
        dateModifiedTo = new JDateChooser(null, "dd/MM/yyyy");
        dateLastAccess = new JDateChooser(null, "dd/MM/yyyy");
        dateLastAccessTo = new JDateChooser(null, "dd/MM/yyyy");
        labelFile = new JLabel("FILE NAME:");
        textPath = new JTextField("C:\\");
        textExtension = new JTextField();
        textContain = new JTextField();
        labelPhat = new JLabel("PATH:");
        buttonSearch = new JButton("SEARCH");
        LabelSize = new JLabel("SIZE:");
        labelHidden = new JLabel("HIDDEN");
        labelOwner = new JLabel("OWNER");
        labelSearchExtension = new JLabel("SEARCH BY EXTENSION OF FILES");
        labelSearchOthers = new JLabel("SEARCH BY CONTAIN");
        labelFrom = new JLabel("FROM:");
        labelTo = new JLabel("TO:");
        labelFromM = new JLabel("FROM:");
        labelToM = new JLabel("TO:");
        labelFromL = new JLabel("FROM:");
        labelToL = new JLabel("TO:");
        operator = new JComboBox<>(operatorOptions);
        optionUnitsSize = new JComboBox<>(listUnitSize);
        spinnerSize = new JSpinner();
        hidden = new JRadioButton("hidden");
        radioGruop = new ButtonGroup();
        hiddenCheck = new JCheckBox("Hidden");
        btSelect = new JButton();
        pdf = new JCheckBox(".pdf");
        docx = new JCheckBox(".docx");
        exe = new JCheckBox(".exe");
        gif = new JCheckBox(".gif");
        ppt = new JCheckBox(".ppt");
        zip = new JCheckBox(".zip");
        xlsx = new JCheckBox(".xlsx");
        rar = new JCheckBox(".rar");
        enableCreate = new JCheckBox("Date Create");
        enableModified = new JCheckBox("Date Modified");
        enableLastAccess = new JCheckBox("Date Last Access");
        enableOnlyRead = new JCheckBox("Only Read");
        enableSensitiveFile = new JCheckBox("Sensitive File");
        blacking = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

    }

    /**
     * it is method contain configuration.
     */
    public void settingPanelSearch() {
        setLayout(null);
        setVisible(true);
    }

    /**
     * this method containTable contain table of information list archive.
     */
    private void initComponentTable() {
        panelTable = new PanelTable();
    }

    /**
     * this method contain is have the location and other property as color and text
     * for look for archive.
     */

    public void settingPanel() {

        /**
         * In this field you search by file name.
         */
        labelFile.setBounds(10, 20, 100, 30);
        labelFile.setBorder(blacking);
        textFile.setBounds(90, 20, 300, 30);
        textFile.setBackground(new Color(204, 255, 229));
        textFile.setBorder(blacking);
        /**
         * In this field you enter the path of file,
         */
        labelPhat.setBounds(10, 50, 80, 30);
        labelPhat.setBorder(blacking);
        textPath.setBounds(90, 50, 300, 30);
        textPath.setBorder(blacking);
        textPath.setBackground(new Color(204, 255, 229));

        /**
         * Search by Calendar for date create.
         */
        enableCreate.setEnabled(true);
        enableCreate.setBounds(5, 150, 100, 23);
        this.add(enableCreate);

        labelFrom.setBounds(120, 130, 60, 20);
        labelFrom.setForeground(new Color(1, 1, 33));
        labelFrom.setBorder(loweredetched);
        dateCreate.setBounds(120, 150, 150, 25);
        dateCreate.setBorder(loweredetched);
        this.add(dateCreate);

        labelTo.setBounds(120, 175, 60, 20);
        labelTo.setForeground(new Color(1, 1, 33));
        labelTo.setBorder(loweredetched);
        dateCreateTo.setBounds(120, 195, 150, 25);
        dateCreateTo.setBorder(loweredetched);
        this.add(dateCreateTo);
        /**
         * Search by Calendar for date modified.
         */
        enableModified.setEnabled(true);
        enableModified.setBounds(280, 150, 110, 23);
        this.add(enableModified);

        labelFromM.setBounds(400, 130, 60, 20);
        labelFromM.setForeground(new Color(1, 1, 33));
        labelFromM.setBorder(loweredetched);
        dateModified.setBounds(400, 150, 150, 25);
        dateModified.setBorder(loweredetched);
        this.add(dateModified);

        labelToM.setBounds(400, 175, 60, 20);
        labelToM.setForeground(new Color(1, 1, 33));
        labelToM.setBorder(loweredetched);
        dateModifiedTo.setBounds(400, 195, 150, 25);
        dateModifiedTo.setBorder(loweredetched);
        this.add(dateModifiedTo);
        /**
         * Search by Calendar for date last access.
         */
        enableLastAccess.setEnabled(true);
        enableLastAccess.setBounds(570, 150, 130, 23);
        this.add(enableLastAccess);

        labelFromL.setBounds(720, 130, 60, 20);
        labelFromL.setForeground(new Color(1, 1, 33));
        labelFromL.setBorder(loweredetched);
        dateLastAccess.setBounds(720, 150, 150, 25);
        dateLastAccess.setBorder(loweredetched);
        this.add(dateLastAccess);

        labelToL.setBounds(720, 175, 60, 20);
        labelToL.setForeground(new Color(1, 1, 33));
        labelToL.setBorder(loweredetched);
        dateLastAccessTo.setBounds(720, 195, 150, 25);
        dateLastAccessTo.setBorder(loweredetched);
        this.add(dateLastAccessTo);
        /**
         * Button and operators.
         */
        btSelect.setText("Select Path");
        btSelect.setBounds(400, 50, 120, 30);

        LabelSize.setBounds(10, 80, 100, 30);
        operator.setBounds(230, 80, 50, 30);
        optionUnitsSize.setBounds(160, 80, 70, 30);
        spinnerSize.setValue(0);
        spinnerSize.setBounds(90, 80, 70, 30);
        buttonSearch.setBounds(1000, 180, 150, 30);

        /**
         * Search by extension.
         */
        labelSearchExtension.setBounds(800, 3, 200, 23);
        labelSearchExtension.setForeground(new Color(1, 1, 33));
        textExtension.setBounds(800, 30, 100, 30);
        textExtension.setBackground(new Color(204, 255, 229));
        textExtension.setBorder(blacking);
        labelSearchExtension.setBorder(blacking);

        pdf.setEnabled(true);
        pdf.setBounds(910, 40, 60, 23);
        this.add(pdf);

        docx.setEnabled(true);
        docx.setBounds(980, 40, 60, 23);
        this.add(docx);

        exe.setEnabled(true);
        exe.setBounds(910, 60, 60, 23);
        this.add(exe);

        gif.setEnabled(true);
        gif.setBounds(980, 60, 60, 23);
        this.add(gif);

        ppt.setEnabled(true);
        ppt.setBounds(910, 80, 60, 23);
        this.add(ppt);

        zip.setEnabled(true);
        zip.setBounds(980, 80, 60, 23);
        this.add(zip);

        xlsx.setEnabled(true);
        xlsx.setBounds(910, 100, 60, 23);
        this.add(xlsx);

        rar.setEnabled(true);
        rar.setBounds(980, 100, 60, 23);
        this.add(rar);
        /**
         * Search by contain of files.
         */
        labelSearchOthers.setBounds(550, 3, 200, 23);
        labelSearchOthers.setForeground(new Color(1, 1, 33));
        labelSearchOthers.setBorder(blacking);

        textContain.setBounds(550, 30, 200, 30);
        textContain.setBackground(new Color(204, 255, 229));
        textContain.setBorder(blacking);
        /**
         * Search by only read,hidden and sensitive file.
         */
        enableOnlyRead.setEnabled(true);
        enableOnlyRead.setBounds(550, 80, 100, 23);
        this.add(enableOnlyRead);

        hiddenCheck.setBounds(680, 80, 70, 23);

        enableSensitiveFile.setBounds(770, 80, 110, 23);
        this.add(enableSensitiveFile);
        actionBottom();


    }

    /**
     * this method run when click on button path.
     */
    public void actionBottom() {
        btSelect.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btSelectMouseClicked(evt);
            }
        });
    }

    /**
     * this method add all components.
     */
    public void addComponents() {
        add(textFile);
        add(hidden);
        add(spinnerSize);
        add(textFile);
        add(textPath);
        add(textExtension);
        add(textContain);
        add(labelFile);
        add(labelPhat);
        add(buttonSearch);
        add(LabelSize);
        add(labelHidden);
        add(labelOwner);
        add(operator);
        add(optionUnitsSize);
        add(textPath);
        add(panelTable);
        add(hiddenCheck);
        add(btSelect);
        add(labelSearchExtension);
        add(labelSearchOthers);
        add(labelFrom);
        add(labelTo);
        add(labelFromM);
        add(labelToM);
        add(labelFromL);
        add(labelToL);
    }

    /**
     * get value that is selected.
     *
     * @return value that selected
     */
    public String getOptionUnitsSize() {
        return optionUnitsSize.getSelectedItem().toString();
    }

    /**
     * this method get operator.
     *
     * @return operator selected
     */
    public String getOperator() {
        return operator.getSelectedItem().toString();
    }

    /**
     * this method get file text.
     *
     * @return value of file text
     */
    public String getTextFile() {
        return textFile.getText();
    }

    /**
     * this method get path.
     *
     * @return value of camp path
     */
    public String getTextPath() {
        return textPath.getText();
    }

    /**
     * this method get button
     *
     * @return button
     */
    public JButton getButtoSearsh() {
        return buttonSearch;
    }

    /**
     * This method add row in the table.
     *
     * @param newRow
     */
    public void addRow(String[] newRow) {
        panelTable.addRow(newRow);
    }

    /**
     * this method get value of field size.
     *
     * @return value of size
     */
    public String getSizeFile() {
        return spinnerSize.getValue().toString();
    }

    /**
     * this method get value of radio button hidden.
     *
     * @return true if selected.
     */
    public boolean getHidden() {
        return hiddenCheck.isSelected();
    }

    /**
     * this method clean table.
     */
    public void cleanTable() {
        panelTable.clean();
    }

    /**
     * this method
     *
     * @param evt
     */
    private void btSelectMouseClicked(MouseEvent evt) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            textPath.setText(selectedFile.getAbsolutePath());
        }
    }

}
