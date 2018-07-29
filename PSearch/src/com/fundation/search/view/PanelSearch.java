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


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileSystemView;

import com.toedter.calendar.JDateChooser;

import java.util.ArrayList;
import java.util.Date;

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
    private JTextField textOwner;
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

    //array that contains units of the bytes,kb,Mb and Gb.

    private String[] listUnitSize;
    private JComboBox<String> optionUnitsSize;

    private JLabel LabelSize;
    private JLabel labelFile;
    private JLabel labelPhat;
    private JLabel labelHidden;
    private JLabel labelOwner;
    private JLabel labelSearchExtension;
    private JLabel labelSearchOthers;
    private JLabel labelTo;
    private JLabel labelToM;
    private JLabel labelToL;

    private PanelTable panelTable;

    private JSpinner spinnerSize;
    public ButtonGroup radioGruop;

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
    private JCheckBox enableKeySensitive;
    private Border blacking;
    private Border loweredetched;
    private boolean changeCreate;
    private boolean changeModified;
    private boolean changeLastAccess;

    /**
     * this is constructor of the class PanelSearch.
     */

    public PanelSearch() {
        settingPanelSearch();
        initComponent();
        initComponentTable();
        settingPanel();
        addComponents();
    }

    private void initComponent() {
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
        textOwner = new JTextField();
        labelPhat = new JLabel("PATH:");
        buttonSearch = new JButton("SEARCH");
        LabelSize = new JLabel("SIZE:");
        labelHidden = new JLabel("HIDDEN");
        labelOwner = new JLabel("OWNER");
        labelSearchExtension = new JLabel("EXTENSION OF FILE");
        labelSearchOthers = new JLabel("CONTAIN");
        labelTo = new JLabel("TO:");
        labelToM = new JLabel("TO:");
        labelToL = new JLabel("TO:");
        operator = new JComboBox<>(operatorOptions);
        optionUnitsSize = new JComboBox<>(listUnitSize);
        spinnerSize = new JSpinner();
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
        enableKeySensitive = new JCheckBox("Key Sensitive");
        blacking = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        changeCreate = false;
        changeModified = false;
        changeLastAccess = false;
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
        textFile.setBounds(90, 20, 320, 30);
        textFile.setBackground(new Color(250, 252, 252));
        textFile.setBorder(blacking);

        //In this field you enter the path of file,

        labelPhat.setBounds(10, 50, 80, 30);
        labelPhat.setBorder(blacking);
        textPath.setBounds(90, 50, 320, 30);
        textPath.setBorder(blacking);
        textPath.setBackground(new Color(250, 252, 252));

        //Search by Calendar for date create.
        enableCreate.setEnabled(true);
        enableCreate.setBounds(235, 140, 100, 20);
        enableCreate.setBackground(new Color(250, 252, 252));

        dateCreate.setBounds(5, 140, 100, 20);
        dateCreate.setBorder(loweredetched);
        dateCreate.setEnabled(false);

        labelTo.setBounds(105, 140, 30, 20);
        labelTo.setForeground(new Color(1, 1, 33));
        labelTo.setBorder(loweredetched);

        dateCreateTo.setBounds(135, 140, 100, 20);
        dateCreateTo.setBorder(loweredetched);
        dateCreateTo.setEnabled(false);

        //Search by Calendar for date modified.

        enableModified.setEnabled(true);
        enableModified.setBounds(235, 160, 110, 20);
        enableModified.setBackground(new Color(250, 252, 252));

        dateModified.setBounds(5, 160, 100, 20);
        dateModified.setBorder(loweredetched);
        dateModified.setEnabled(false);

        labelToM.setBounds(105, 160, 30, 20);
        labelToM.setForeground(new Color(1, 1, 33));
        labelToM.setBorder(loweredetched);

        dateModifiedTo.setBounds(135, 160, 100, 20);
        dateModifiedTo.setBorder(loweredetched);
        dateModifiedTo.setEnabled(false);


        //Search by Calendar for date last access.

        enableLastAccess.setEnabled(true);
        enableLastAccess.setBounds(235, 180, 130, 20);
        enableLastAccess.setBackground(new Color(250, 252, 252));

        dateLastAccess.setBounds(5, 180, 100, 20);
        dateLastAccess.setBorder(loweredetched);
        dateLastAccess.setEnabled(false);

        labelToL.setBounds(105, 180, 30, 20);
        labelToL.setForeground(new Color(1, 1, 33));
        labelToL.setBorder(loweredetched);

        dateLastAccessTo.setBounds(135, 180, 100, 20);
        dateLastAccessTo.setBorder(loweredetched);
        dateLastAccessTo.setEnabled(false);

        //Button and operators.

        btSelect.setText("Select Path");
        btSelect.setBounds(290, 80, 120, 30);
        btSelect.setBackground(new Color(250, 252, 252));
        btSelect.setBorder(blacking);

        LabelSize.setBounds(10, 80, 100, 30);
        operator.setBounds(230, 80, 50, 30);
        operator.setBackground(new Color(250, 252, 252));
        operator.setBorder(blacking);
        optionUnitsSize.setBounds(160, 80, 70, 30);
        optionUnitsSize.setBackground(new Color(250, 252, 252));
        optionUnitsSize.setBorder(blacking);
        spinnerSize.setValue(0);
        spinnerSize.setBounds(90, 80, 70, 30);
        spinnerSize.setBackground(new Color(250, 252, 252));
        spinnerSize.setBorder(blacking);
        buttonSearch.setBounds(1000, 180, 150, 30);
        buttonSearch.setBackground(new Color(250, 252, 252));
        buttonSearch.setBorder(blacking);

        //Search by extension.

        labelSearchExtension.setBounds(910, 3, 140, 20);
        labelSearchExtension.setForeground(new Color(1, 1, 33));
        textExtension.setBounds(1050, 30, 100, 30);
        textExtension.setBackground(new Color(250, 252, 252));
        textExtension.setBorder(blacking);
        labelSearchExtension.setBorder(blacking);

        pdf.setEnabled(true);
        pdf.setBounds(910, 40, 60, 23);
        pdf.setBackground(new Color(250, 252, 252));

        docx.setEnabled(true);
        docx.setBounds(980, 40, 60, 23);
        docx.setBackground(new Color(250, 252, 252));

        exe.setEnabled(true);
        exe.setBounds(910, 60, 60, 23);
        exe.setBackground(new Color(250, 252, 252));

        gif.setEnabled(true);
        gif.setBounds(980, 60, 60, 23);
        gif.setBackground(new Color(250, 252, 252));

        ppt.setEnabled(true);
        ppt.setBounds(910, 80, 60, 23);
        ppt.setBackground(new Color(250, 252, 252));

        zip.setEnabled(true);
        zip.setBounds(980, 80, 60, 23);
        zip.setBackground(new Color(250, 252, 252));

        xlsx.setEnabled(true);
        xlsx.setBounds(910, 100, 60, 23);
        xlsx.setBackground(new Color(250, 252, 252));

        rar.setEnabled(true);
        rar.setBounds(980, 100, 60, 23);
        rar.setBackground(new Color(250, 252, 252));

        //Search by owner of files.

        labelOwner.setBounds(730, 3, 150, 20);
        labelOwner.setForeground(new Color(1, 1, 33));
        labelOwner.setBorder(blacking);

        textOwner.setBounds(730, 30, 150, 30);
        textOwner.setBackground(new Color(250, 252, 252));
        textOwner.setBorder(blacking);

        //Search by contain of files.

        labelSearchOthers.setBounds(550, 3, 150, 20);
        labelSearchOthers.setForeground(new Color(1, 1, 33));
        labelSearchOthers.setBorder(blacking);

        textContain.setBounds(550, 30, 150, 30);
        textContain.setBackground(new Color(250, 252, 252));
        textContain.setBorder(blacking);

        //Search by only read,hidden and sensitive file.

        enableOnlyRead.setEnabled(true);
        enableOnlyRead.setBounds(550, 80, 100, 20);
        enableOnlyRead.setBackground(new Color(250, 252, 252));

        hiddenCheck.setBounds(550, 100, 70, 20);
        hiddenCheck.setBackground(new Color(250, 252, 252));

        enableKeySensitive.setBounds(550, 120, 110, 20);
        enableKeySensitive.setBackground(new Color(250, 252, 252));

        actionBottom();

        //Events of check.

        enableCreate.addChangeListener(evt -> chSearchTextStateChanged(evt));
        enableModified.addChangeListener(evt -> chSearchTextStateChanged(evt));
        enableLastAccess.addChangeListener(evt -> chSearchTextStateChanged(evt));
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
     * @param e is a event.
     */
    private void chSearchTextStateChanged(ChangeEvent e) {
        if (this.changeCreate != enableCreate.isSelected()) {
            this.changeCreate = enableCreate.isSelected();
            dateCreate.setEnabled(changeCreate);
            dateCreateTo.setEnabled(changeCreate);
        }
        if (this.changeModified != enableModified.isSelected()) {
            this.changeModified = enableModified.isSelected();
            dateModified.setEnabled(changeModified);
            dateModifiedTo.setEnabled(changeModified);
        }
        if (this.changeLastAccess != enableLastAccess.isSelected()) {
            this.changeLastAccess = enableLastAccess.isSelected();
            dateLastAccess.setEnabled(changeLastAccess);
            dateLastAccessTo.setEnabled(changeLastAccess);
        }

    }

    /**
     * this method add all components.
     */
    public void addComponents() {
        add(textFile);
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
        add(labelTo);
        add(labelToM);
        add(labelToL);
        add(enableCreate);
        add(enableModified);
        add(enableLastAccess);
        add(enableOnlyRead);
        add(enableKeySensitive);
        add(dateCreate);
        add(dateCreateTo);
        add(dateModified);
        add(dateModifiedTo);
        add(dateLastAccess);
        add(dateLastAccessTo);
        add(pdf);
        add(docx);
        add(exe);
        add(gif);
        add(ppt);
        add(zip);
        add(xlsx);
        add(rar);
        add(textOwner);
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
     * @return the contain of file.
     */
    public String getContain() {
        return textContain.getText();
    }

    /**
     * @return the owner of file.
     */
    public String getOwner() {
        return textOwner.getText();
    }

    public ArrayList<String> getExtensions() {
        ArrayList<String> extensions = new ArrayList<>();
        if (!textContain.getText().isEmpty()) {
            extensions.add(textContain.getText());
        }
        if (pdf.isSelected()) {
            extensions.add(pdf.getName());
        }
        if (docx.isSelected()) {
            extensions.add(docx.getName());
        }
        if (ppt.isSelected()) {
            extensions.add(ppt.getName());
        }
        if (zip.isSelected()) {
            extensions.add(zip.getName());
        }
        if (rar.isSelected()) {
            extensions.add(rar.getName());
        }
        if (xlsx.isSelected()) {
            extensions.add(xlsx.getName());
        }
        if (exe.isSelected()) {
            extensions.add(exe.getName());
        }
        if (gif.isSelected()) {
            extensions.add(gif.getName());
        }
        return extensions;
    }

    /**
     * this method get button
     *
     * @return button
     */
    public JButton getButtonSearch() {
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
     * @return true if selected.
     */
    public boolean getOnlyRead() {
        return enableOnlyRead.isSelected();
    }

    /**
     * @return true if selected.
     */
    public boolean getKeySensitive() {
        return enableKeySensitive.isSelected();
    }

    /**
     * @return
     */
    public Date getDateCreate() {
        return dateCreate.getDate();
    }

    /**
     * @return
     */
    public Date getDateCreateTo() {
        return dateCreateTo.getDate();
    }

    /**
     * @return
     */
    public Date getDateModified() {
        return dateModified.getDate();
    }

    /**
     * @return
     */
    public Date getDateModifiedTo() {
        return dateModifiedTo.getDate();
    }

    /**
     * @return
     */
    public Date getDateLastAccess() {
        return dateLastAccess.getDate();
    }

    /**
     * @return
     */
    public Date getDateLastAccessTo() {
        return dateLastAccessTo.getDate();
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
        System.out.println(getDateCreate());
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            textPath.setText(selectedFile.getAbsolutePath());
        }
    }
}
