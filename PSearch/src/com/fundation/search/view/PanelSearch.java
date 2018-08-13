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


import com.fundation.search.utils.LoggerSearch;
import com.toedter.calendar.JDateChooser;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
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
    //these variables are for text fields.
    private JTextField textFile;
    private JTextField textPath;
    private JTextField textExtension;
    private JTextField textOwner;
    private JTextField textContain;

    //these variables are for the dates.
    private JDateChooser dateCreate;
    private JDateChooser dateCreateTo;
    private JDateChooser dateModified;
    private JDateChooser dateModifiedTo;
    private JDateChooser dateLastAccess;
    private JDateChooser dateLastAccessTo;
    //these variables are for button of select path and search.
    private JButton buttonSearch;
    private JButton btSelect;
    //these variables are for text fields.
    private String[] operatorOptions;
    private JComboBox<String> operator;
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

    /**
     * type of extensions of the file
     */
    private JCheckBox pdf;
    private JCheckBox docx;
    private JCheckBox exe;
    private JCheckBox txt;
    private JCheckBox ppt;
    private JCheckBox zip;
    private JCheckBox xlsx;
    private JCheckBox rar;


    private JCheckBox hiddenCheck;
    private JCheckBox enableCreate;
    private JCheckBox enableModified;
    private JCheckBox enableLastAccess;
    private JCheckBox enableOnlyRead;
    private JCheckBox enableKeySensitive;
    private JCheckBox folder;
    private JCheckBox endWith;
    private JCheckBox startWith;

    private Border blacking;
    private Border loweredetched;

    private boolean changeCreate;
    private boolean changeModified;
    private boolean changeLastAccess;
    //private URL imagen1;
    //Logger
    JLabel labelImagen ;
    JLabel labelImagenFile;
    JLabel labelFondo;
    String url = "imagen1.png";

    private static final Logger LOGGER = LoggerSearch.getInstance().getLogger();

    /**
     * this is constructor of the class PanelSearch.
     */

    public PanelSearch() {
        LOGGER.info("PanelSearch : enter");
        settingPanelSearch();
        initComponent();
        initComponentTable();
        settingPanel();
        addComponents();
        letersNumberEnable(textPath);
        numbers(spinnerSize);
        LOGGER.info("PanelSearch : exit");

    }

    private void initComponent() {
        LOGGER.info("initComponent : enter");
        ImageIcon icone = new ImageIcon("src/com/fundation/search/view/imagen/imagen2.png");
        labelImagen = new JLabel(icone);

        ImageIcon iconeFile = new ImageIcon("src/com/fundation/search/view/imagen/fileColor.png");
        labelImagenFile = new JLabel(iconeFile);

        ImageIcon iconeFondo = new ImageIcon("src/com/fundation/search/view/imagen/fondo3.jpg");
        labelFondo = new JLabel(iconeFondo);


        listUnitSize = new String[]{"bytes", "Kb", "Mb", "Gb"};
        operatorOptions = new String[]{">", "<", "="};

        dateCreate = new JDateChooser(null, "dd/MM/yyyy");
        dateCreateTo = new JDateChooser(null, "dd/MM/yyyy");
        dateModified = new JDateChooser(null, "dd/MM/yyyy");
        dateModifiedTo = new JDateChooser(null, "dd/MM/yyyy");
        dateLastAccess = new JDateChooser(null, "dd/MM/yyyy");
        dateLastAccessTo = new JDateChooser(null, "dd/MM/yyyy");

        labelFile = new JLabel("FILE NAME:");
        textFile = new JTextField();
        textPath = new JTextField("C:\\");
        textExtension = new JTextField();
        textContain = new JTextField();
        textOwner = new JTextField();

        labelPhat = new JLabel("PATH:");
        LabelSize = new JLabel("SIZE:");
        labelHidden = new JLabel("HIDDEN");
        labelOwner = new JLabel("OWNER:");
        labelSearchExtension = new JLabel("EXTENSION:");
        labelSearchOthers = new JLabel("CONTAIN:");
        labelTo = new JLabel("TO:");
        labelToM = new JLabel("TO:");
        labelToL = new JLabel("TO:");


        operator = new JComboBox<>(operatorOptions);
        optionUnitsSize = new JComboBox<>(listUnitSize);
        int min = 0;
        int max = 1000000000;
        int step = 1;
        int initValue = 0;
        SpinnerModel model = new SpinnerNumberModel(initValue, min, max, step);
        spinnerSize = new JSpinner(model);
        ((JSpinner.DefaultEditor) spinnerSize.getEditor()).getTextField().setEditable(false);


        radioGruop = new ButtonGroup();
        ImageIcon iconeSelectPhat = new ImageIcon("src/com/fundation/search/view/imagen/selectPath.png");
        btSelect = new JButton(iconeSelectPhat);
       ImageIcon iconeSearch = new ImageIcon("src/com/fundation/search/view/imagen/search.png");
        buttonSearch = new JButton(iconeSearch);

        hiddenCheck = new JCheckBox("Hidden");
        folder = new JCheckBox("Folder");
        pdf = new JCheckBox(".pdf");
        docx = new JCheckBox(".docx");
        exe = new JCheckBox(".exe");
        txt = new JCheckBox(".txt");
        ppt = new JCheckBox(".pptx");
        zip = new JCheckBox(".zip");
        xlsx = new JCheckBox(".xlsx");
        rar = new JCheckBox(".rar");
        enableCreate = new JCheckBox("Date Create");
        enableModified = new JCheckBox("Date Modified");
        enableLastAccess = new JCheckBox("Date Last Access");
        enableOnlyRead = new JCheckBox("ReadOnly");
        enableKeySensitive = new JCheckBox("Key Sensitive");
        endWith = new JCheckBox("ENDWITH");
        startWith = new JCheckBox("STARTWITH");

        blacking = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        changeCreate = false;
        changeModified = false;
        changeLastAccess = false;
        // imagen1 = getClass().getResource("/view/432ee7c1-ffcd-4873-aed5-4ec30b3a5dc3.png");
        //Image image = new ImageIcon(imagen1).getImage();
        //imagen = this.getClass().getResource("/src/com/fundation/search/view/432ee7c1-ffcd-4873-aed5-4ec30b3a5dc3.png");
        LOGGER.info("initComponent : exit");
    }

    /**
     * it is method contain configuration.
     */
    public void settingPanelSearch() {
        LOGGER.info("settingPanelSearch : enter");
        setLayout(null);
        setVisible(true);
        LOGGER.info("settingPanelSearch : exit");
    }

    /**
     * this method containTable contain table of information list archive.
     */
    public void initComponentTable() {
        panelTable = new PanelTable();
    }

    /**
     * this method contain is have the location and other property as color and text
     * for look for archive.
     */
    public void settingPanel() {
        LOGGER.info("settingPanel : enter");

        /**
         * In this field you search by file name.
         */
        labelFile.setBounds(10, 20, 80, 30);
        labelFile.setBorder(blacking);
        textFile.setBounds(90, 20, 320, 30);
        textFile.setBackground(new Color(250, 252, 252));
        textFile.setBorder(blacking);

        //In this field you enter the path of file,

        labelPhat.setBounds(10, 70, 80, 30);
        labelPhat.setBorder(blacking);
        textPath.setBounds(90, 70, 320, 30);
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
        btSelect.setBounds(290, 100, 120, 33);
        //btSelect.setBackground(Color.blue);
        btSelect.setForeground(Color.blue);


        //btSelect.setBackground(new Color(9, 244, 184));
        btSelect.setBorder(blacking);

        LabelSize.setBounds(10, 100, 100, 30);
        operator.setBounds(230, 100, 50, 30);
        operator.setBackground(new Color(250, 252, 252));
        operator.setBorder(blacking);
        optionUnitsSize.setBounds(160, 100, 70, 30);
        optionUnitsSize.setBackground(new Color(250, 252, 252));
        optionUnitsSize.setBorder(blacking);
        spinnerSize.setValue(0);
        spinnerSize.setBounds(90, 100, 70, 30);
        spinnerSize.setBackground(new Color(250, 252, 252));
        spinnerSize.setBorder(blacking);
        buttonSearch.setBounds(450, 180, 150, 41);
        buttonSearch.setBackground(new Color(9, 244, 184));
        buttonSearch.setBorder(blacking);

        //Search by extension.

        labelSearchExtension.setBounds(550, 80, 80, 30);
        labelSearchExtension.setForeground(new Color(1, 1, 33));

        textExtension.setBounds(631, 80, 150, 30);
        textExtension.setBackground(new Color(250, 252, 252));
        textExtension.setBorder(blacking);
        labelSearchExtension.setBorder(blacking);

        pdf.setEnabled(true);
        pdf.setBounds(630, 115, 60, 23);
        pdf.setBackground(new Color(250, 252, 252));

        docx.setEnabled(true);
        docx.setBounds(700, 115, 60, 23);
        docx.setBackground(new Color(250, 252, 252));

        exe.setEnabled(true);
        exe.setBounds(630, 135, 60, 23);
        exe.setBackground(new Color(250, 252, 252));

        txt.setEnabled(true);
        txt.setBounds(700, 135, 60, 23);
        txt.setBackground(new Color(250, 252, 252));

        ppt.setEnabled(true);
        ppt.setBounds(630, 155, 60, 23);
        ppt.setBackground(new Color(250, 252, 252));

        zip.setEnabled(true);
        zip.setBounds(700, 155, 60, 23);
        zip.setBackground(new Color(250, 252, 252));

        xlsx.setEnabled(true);
        xlsx.setBounds(630, 175, 60, 23);
        xlsx.setBackground(new Color(250, 252, 252));

        rar.setEnabled(true);
        rar.setBounds(700, 175, 60, 23);
        rar.setBackground(new Color(250, 252, 252));

        //Search by owner of files.

        labelOwner.setBounds(550, 50, 80, 30);
        labelOwner.setForeground(new Color(1, 1, 33));
        labelOwner.setBorder(blacking);

        textOwner.setBounds(631, 50, 150, 30);
        textOwner.setBackground(new Color(250, 252, 252));
        textOwner.setBorder(blacking);

        //Search by contain of files.

        labelSearchOthers.setBounds(550, 20, 80, 30);
        labelSearchOthers.setForeground(new Color(1, 1, 33));
        labelSearchOthers.setBorder(blacking);

        textContain.setBounds(631, 20, 150, 30);
        textContain.setBackground(new Color(250, 252, 252));
        textContain.setBorder(blacking);

        endWith.setBounds(410, 18, 100, 18);
        endWith.setBackground(new Color(250, 252, 252));
        startWith.setBounds(410, 40, 100, 18);
        startWith.setBackground(new Color(250, 252, 252));

        //Search by only read,hidden and sensitive file.

        enableOnlyRead.setEnabled(true);
        enableOnlyRead.setBounds(10, 50, 90, 20);
        enableOnlyRead.setBackground(new Color(250, 252, 252));

        hiddenCheck.setBounds(100, 50, 80, 20);
        hiddenCheck.setBackground(new Color(250, 252, 252));

        enableKeySensitive.setBounds(180, 50, 120, 20);
        enableKeySensitive.setBackground(new Color(250, 252, 252));

        folder.setEnabled(true);
        folder.setBounds(300, 50, 80, 20);
        folder.setBackground(new Color(250, 252, 252));
        /**
         * this is format of image interface.
         */
        labelImagen.setBounds(800,0,400,100);
        labelImagenFile.setBounds(850,0,300,300);
        labelFondo.setBounds(0,0,900,400);
        //labelImagen.setIcon(icone);

        actionBottom();

        //Events of check.

        enableCreate.addChangeListener(evt -> chSearchTextStateChanged(evt));
        enableModified.addChangeListener(evt -> chSearchTextStateChanged(evt));
        enableLastAccess.addChangeListener(evt -> chSearchTextStateChanged(evt));
        LOGGER.info("settingPanel : exit");
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
        LOGGER.info("chSearchTextStateChanged : enter");
        if (this.changeCreate != enableCreate.isSelected()) {
            this.changeCreate = enableCreate.isSelected();
            dateCreate.setCalendar(null);
            dateCreateTo.setCalendar(null);
            dateCreate.setEnabled(changeCreate);
            dateCreateTo.setEnabled(changeCreate);

        }
        if (this.changeModified != enableModified.isSelected()) {
            this.changeModified = enableModified.isSelected();
            dateModified.setCalendar(null);
            dateModifiedTo.setCalendar(null);
            dateModified.setEnabled(changeModified);
            dateModifiedTo.setEnabled(changeModified);
        }
        if (this.changeLastAccess != enableLastAccess.isSelected()) {
            this.changeLastAccess = enableLastAccess.isSelected();
            dateLastAccess.setCalendar(null);
            dateLastAccessTo.setCalendar(null);
            dateLastAccess.setEnabled(changeLastAccess);
            dateLastAccessTo.setEnabled(changeLastAccess);
        }
        LOGGER.info("chSearchTextStateChanged : exit");
    }

    /**
     * this method add all components.
     */
    public void addComponents() {
        LOGGER.info("addComponents : enter");
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
        add(txt);
        add(ppt);
        add(zip);
        add(xlsx);
        add(rar);
        add(textOwner);
        add(folder);
        add(endWith);
        add(startWith);
        add(labelImagen);
        add(labelImagenFile);
        add(labelFondo);
        LOGGER.info("addComponents : exit");
    }
    public void letersNumberEnable(JTextField textPath){

        textPath.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                //super.keyTyped(e);
                if (!Character.isLetter(c) || Character.isLetter(c)) {
                    getToolkit().beep();
                    e.consume();
                    JOptionPane.showMessageDialog(null, "go to -Select Path-");


                }

            }
        });
    }
    public void showErrorMessage(String showError){
        JOptionPane.showMessageDialog(null,showError);
    }

    public void numbers(JSpinner spinnerSize) {
        spinnerSize.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                //super.keyTyped(e);
                if (!Character.isLetter(c)) {
                    getToolkit().beep();
                    e.consume();
                    //JOptionPane.showMessageDialog(, "Faltan dato.");

                    // error.setText("ingrese path");
                }
            }
        });
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

    /**
     * @return the list od extension of the files.
     */
    public ArrayList<String> getExtensions() {
        ArrayList<String> extensions = new ArrayList<>();
        if (!textExtension.getText().isEmpty()) {
            extensions.add(textExtension.getText());
        }
        if (pdf.isSelected()) {
            extensions.add(pdf.getText());
        }
        if (docx.isSelected()) {
            extensions.add(docx.getText());
        }
        if (ppt.isSelected()) {
            extensions.add(ppt.getText());
        }
        if (zip.isSelected()) {
            extensions.add(zip.getText());
        }
        if (rar.isSelected()) {
            extensions.add(rar.getText());
        }
        if (xlsx.isSelected()) {
            extensions.add(xlsx.getText());
        }
        if (exe.isSelected()) {
            extensions.add(exe.getText());
        }
        if (txt.isSelected()) {
            extensions.add(txt.getText());
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
     * @return
     */
    public boolean getEndWith() {
        return endWith.isSelected();
    }

    /**
     * @return
     */
    public boolean getStartWith() {
        return startWith.isSelected();
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
     * @return if the search is by folder.
     */
    public boolean getSearchFolder() {
        return folder.isSelected();
    }

    /**
     * @return true if selected.
     */
    public boolean getKeySensitive() {
        return enableKeySensitive.isSelected();
    }

    /**
     * @return date if selected.
     */
    public Date getDateCreate() {
        return dateCreate.getDate();
    }

    /**
     * @return date of selected date create.
     */
    public Date getDateCreateTo() {
        return dateCreateTo.getDate();
    }

    /**
     * @return date of selected date modified.
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

    public void setTextFile(String textFile) {
        this.textFile.setText(textFile);
    }

    public void setTextPath(String textPath) {
        this.textPath.setText(textPath);
    }


    public void setTextOwner(String textOwner) {
        this.textOwner.setText(textOwner);
    }

    public void setTextContain(String textContain) {
        this.textContain.setText(textContain);
    }


    public void setOperator(String operator) {
        this.operator.setSelectedItem(operator);
    }

    public void setOptionUnitsSize(String optionUnitsSize) {
        this.optionUnitsSize.setSelectedItem(optionUnitsSize);
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate.setDate(dateCreate);
    }

    public void setDateCreateTo(Date dateCreateTo) {
        this.dateCreateTo.setDate(dateCreateTo);
    }

    public void setDateModified(Date dateModified) {
        this.dateModified.setDate(dateModified);
    }

    public void setDateModifiedTo(Date dateModifiedTo) {
        this.dateModifiedTo.setDate(dateModifiedTo);
    }

    public void setDateLastAccess(Date dateLastAccess) {
        this.dateLastAccess.setDate(dateLastAccess);
    }

    public void setDateLastAccessTo(Date dateLastAccessTo) {
        this.dateLastAccessTo.setDate(dateLastAccessTo);
    }


    /* public void setDateLastAccessTo(JDateChooser dateLastAccessTo) {
         this.dateLastAccessTo.setDate(dateLastAccessTo);
     }*/
    public void setSpinnerSize(double spinnerSize) {
        this.spinnerSize.setValue(spinnerSize);
    }

    public void setHiddenCheck(boolean hiddenCheck) {
        this.hiddenCheck.setSelected(hiddenCheck);
    }

    public void setEnableOnlyRead(boolean enableOnlyRead) {
        this.enableOnlyRead.setSelected(enableOnlyRead);
    }

    public void setEnableKeySensitive(boolean enableKeySensitive) {
        this.enableKeySensitive.setSelected(enableKeySensitive);
    }

    public void setFolder(boolean folder) {
        this.folder.setSelected(folder);
    }

    public void setEndWith(boolean endWith) {
        this.endWith.setSelected(endWith);
    }

    public void setStartWith(boolean startWith) {
        this.startWith.setSelected(startWith);
    }

    public void setExtensions(ArrayList<String> listExtencions) {
        for (String valuesExtencion : listExtencions) {
            if (valuesExtencion.contains("pdf")) {
                pdf.setSelected(true);
                continue;
            }
            if (valuesExtencion.contains("exe")) {
                exe.setSelected(true);
                continue;
            }
            if (valuesExtencion.contains("ppt")) {
                ppt.setSelected(true);
                continue;
            }
            if (valuesExtencion.contains("xlsx")) {
                xlsx.setSelected(true);
                continue;
            }
            if (valuesExtencion.contains("zip")) {
                zip.setSelected(true);
                continue;
            }
            if (valuesExtencion.contains("rar")) {
                rar.setSelected(true);
                continue;
            }
            if (valuesExtencion.contains("xlsx")) {
                xlsx.setSelected(true);
                continue;
            }
            if (valuesExtencion.contains("txt")) {
                txt.setSelected(true);
                continue;
            }
            if (valuesExtencion.contains("docx")) {
                docx.setSelected(true);
                continue;
            }
            textExtension.setText(valuesExtencion);
        }

    }

    /**
     * this method clean table.
     */
    public void cleanTable() {
        panelTable.clean();
    }

    /**
     * @return
     */
    public PanelTable getPanelTable() {
        return panelTable;
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

    public void enableComponents(boolean enable) {
        endWith.setEnabled(enable);
        startWith.setEnabled(enable);
        pdf.setEnabled(enable);
        txt.setEnabled(enable);
        ppt.setEnabled(enable);
        rar.setEnabled(enable);
        zip.setEnabled(enable);
        exe.setEnabled(enable);
        docx.setEnabled(enable);
        xlsx.setEnabled(enable);

        textExtension.enable(enable);
        textOwner.enable(enable);
        textContain.enable(enable);
        folder.setEnabled(enable);
    }
}
