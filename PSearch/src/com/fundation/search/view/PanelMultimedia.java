/*
 * @(#)PanelMultimedia.java
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
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

/**
 * This class Asset can be FileResult SearchFolder.
 *
 * @author ketty camacho Vasquez- AT-[07].
 * @author Franz Elmer Silva Milan.
 * @version 1.0.
 */
public class PanelMultimedia extends JPanel {

    // private JTextField timeDuration;

    private JPanel containerFileSetup;
    private JPanel containerFileExtensions;
    private JPanel containerFileDateBase;



    private JTextField textCriteria;
    private  JTextField textOtherExtension;
    private JButton buttonLoad;
    private JButton buttonSave;
    //private JTextField textDuration;
    JCheckBox hiddenCheck;
    String[] operatiorOptions;
    private JComboBox<String> operator;
    private JButton btSelect;
    /**
     * array that contains units of the bytes,kb,Mb and Gb.
     */
    String[] listResolution;
    String[] listTime;
    String[] listVideoCode;
    String[] listFrameRate;
    String[] listAduioCodec;

    private JComboBox<String> optionUnitsResolution;
    private JComboBox<String> operationTime;
    private JComboBox<String> optionVideoCode;
    private JComboBox<String> optionFrameRate;
    private JComboBox<String> optionAudioCodec;

    JLabel LabelResolution;
    JLabel labelDataBase;
    //JLabel labelFile;
    JLabel labelCriteria;
    JLabel labelHidden;
    JLabel labelDuration;
    JLabel labelVideoCode;
    JLabel labelFrameRate;
    JLabel labelOtherExtension;
    JLabel labelAudioCodec;


    PanelTable panelTable;
    PanelTableBD panelTableBD;

    JSpinner spinnerSize;
    JRadioButton hidden;
    ButtonGroup radioGruop;
    private Border blacking;

    private JCheckBox mp4;
    private JCheckBox mpeg;
    private JCheckBox mov;
    private JCheckBox wmv;
    private JCheckBox avi;
    private JCheckBox xvidi;
    private JCheckBox mpg;
    private JCheckBox flv;

    private JSpinner spinnerDuration;



    /**
     * this is constructor of the class PanelSearch.
     */

    public PanelMultimedia() {
        settingPanelSearch();
        initComponet();
        initComponetTable();
        settingPanel();
        addComponents();
    }

    private void initComponet() {

        containerFileSetup = new JPanel();
        containerFileExtensions = new JPanel();
        containerFileDateBase = new JPanel();


        //labelFile = new JLabel("FILE NAME:");
       //textPath = new JTextField("C:\\");
        labelDataBase = new JLabel("DATA BASE");
        textCriteria = new JTextField(50);
        labelCriteria = new JLabel("CRITERIA:");
        buttonLoad = new JButton("LOAD");
        buttonSave = new JButton("SAVE");

        //labelHidden = new JLabel("HIDDEN");




        spinnerSize = new JSpinner();
        hidden = new JRadioButton("hidden");
        radioGruop = new ButtonGroup();
        hiddenCheck = new JCheckBox("Hidden");
        btSelect = new JButton();


        labelDuration = new JLabel("DURATION: ");
        labelFrameRate = new JLabel("FRAME RATE:");
        labelAudioCodec = new JLabel("AUDIO CODEC:");
        LabelResolution = new JLabel("RESOLUTION:");
        labelVideoCode = new JLabel("VIDEO CODE:");
        listResolution = new String[]{"320 X 240", "480 X 360", "128 X 720"};
        operatiorOptions = new String[]{">", "<", "="};
        listTime = new String [] {"second","minutes","hours"};
        listVideoCode = new String [] {"H264","H263","MPEG4","WNV1"};
        listFrameRate = new String[] {"24 fps","25 fps","30 fps","60 fps"};
        listAduioCodec = new String[] {"DoD RELP","DoD CELP","DoD VSELP","DoD RPE-LTP"};
        operator = new JComboBox<>(operatiorOptions);
        optionUnitsResolution = new JComboBox<>(listResolution);
        operationTime = new JComboBox<>(listTime);
        optionVideoCode = new JComboBox<>(listVideoCode);
        optionFrameRate = new JComboBox<>(listFrameRate);
        optionAudioCodec = new JComboBox<>(listAduioCodec);
        spinnerDuration = new JSpinner();

        //textDuration = new JTextField("Duration");

        textOtherExtension = new JTextField();
        labelOtherExtension = new JLabel("OTHER EXTENSION:");
        mp4 = new  JCheckBox (".MP4");
        mpeg = new JCheckBox (".MPEG");
        mov = new JCheckBox (".MOV");
        wmv = new JCheckBox (".WMV");
        avi = new  JCheckBox (".AVI");
        xvidi = new  JCheckBox (".XVIDI");
        mpg = new  JCheckBox (".MPG");
        flv= new JCheckBox (".FLV");



        blacking = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

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
    private void initComponetTable() {
       panelTable = new PanelTable();
        panelTableBD = new PanelTableBD();


    }

    /**
     * this method contain is have the location and other property as color and text
     * for look for archive.
     */

    public void settingPanel() {

       // labelFile.setBounds(10, 20, 100, 30);
        //
       // timeDuration.setBounds(100, 170, 50, 30);
        //timeDuration.setBackground(new Color(204, 255, 229));
        

        //labelPhat.setBounds(10, 50, 100, 30);
        //textPath.setBounds(90, 50, 700, 30);
        //textPath.setBackground(new Color(204, 255, 229));
        //btSelect.setText("Select Path");
        //btSelect.setBounds(810, 50, 120, 30);
        textCriteria.setBounds(0,0,200,30);
        /**
        LabelResolution.setBounds(40, 100, 500, 40);
        textCriteria.setBounds(770,50,200,30);
        textOtherExtension.setBounds(540,170,100,30);

        labelDataBase.setBounds(850,20,100,30);

        labelCriteria.setBounds(700,47,100,30);
        //labelCriteria.setBorder(blacking);
        labelVideoCode.setBounds(40,78,100,30);
        //labelVideoCode.setBorder(blacking);
        labelFrameRate.setBounds(40,50,100,30);
        //labelFrameRate.setBorder(blacking);
        labelAudioCodec.setBounds(40,20,100,30);

        operator.setBounds(40, 170, 60, 30);
        optionUnitsResolution.setBounds(120, 105, 150, 30);
        operationTime.setBounds(180,170,100,30);
        optionVideoCode.setBounds(120,80,100,30);
        optionFrameRate.setBounds(120,50,100,30);
        optionAudioCodec.setBounds(132,20,150,30);


        labelDuration.setBounds(130,140,100,30);
        labelOtherExtension.setBounds(410,170,200,30);

        buttonLoad.setBounds(990, 50, 150, 35);
        buttonSave.setBounds(990,20,150,33);

        mp4.setEnabled(true);
        mp4.setBounds(400, 50, 100, 23);
        mp4.setBackground(new Color(250, 252, 252));

        wmv.setEnabled(true);
        wmv.setBounds(460, 50, 100, 23);
        wmv.setBackground(new Color(250, 252, 252));

        mpeg.setEnabled(true);
        mpeg.setBounds(520, 50, 100, 23);
        mpeg.setBackground(new Color(250, 252, 252));

        mov.setEnabled(true);
        mov.setBounds(400, 90, 100, 23);
        mov.setBackground(new Color(250, 252, 252));

        avi.setEnabled(true);
        avi.setBounds(460, 90, 100, 23);
        avi.setBackground(new Color(250, 252, 252));

        xvidi.setEnabled(true);
        xvidi.setBounds(520,90,100,23);
        xvidi.setBackground(new Color(250,252,252));

        mpg.setEnabled(true);
        mpg.setBounds(400, 130, 100, 23);
        mpg.setBackground(new Color(250, 252, 252));

        flv.setEnabled(true);
        flv.setBounds(460,130,100,23);
        flv.setBackground(new Color(250,252,252));

        spinnerDuration.setValue(0);
        spinnerDuration.setBounds(100, 170, 70, 30);*/

        //

        GridBagLayout gblsetup=new GridBagLayout();
        GridBagConstraints gbcsetup=new GridBagConstraints();
        containerFileSetup.setBounds(10,10,300,200);
        containerFileSetup.setVisible(true);




        containerFileSetup.setLayout(gblsetup);
        containerFileSetup.setBorder(BorderFactory.createTitledBorder("Multimedia Setup"));



        gbcsetup.gridx=0;
        gbcsetup.gridy=0;
        gbcsetup.gridwidth=1;
        gbcsetup.gridheight=1;
        gbcsetup.fill=GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(labelAudioCodec, gbcsetup);

        gbcsetup.gridx=1;
        gbcsetup.gridy=0;
        gbcsetup.gridwidth=2;
        gbcsetup.gridheight=1;
        gbcsetup.fill=GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(optionAudioCodec, gbcsetup);

        gbcsetup.gridx=0;
        gbcsetup.gridy=1;
        gbcsetup.gridwidth=1;
        gbcsetup.gridheight=1;
        gbcsetup.fill=GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(labelVideoCode, gbcsetup);

        gbcsetup.gridx=1;
        gbcsetup.gridy=1;
        gbcsetup.gridwidth=2;
        gbcsetup.gridheight=1;
        gbcsetup.fill=GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(optionVideoCode, gbcsetup);

        gbcsetup.gridx=0;
        gbcsetup.gridy=2;
        gbcsetup.gridwidth=1;
        gbcsetup.gridheight=1;
        gbcsetup.fill=GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(labelFrameRate, gbcsetup);

        gbcsetup.gridx=1;
        gbcsetup.gridy=2;
        gbcsetup.gridwidth=2;
        gbcsetup.gridheight=1;
        gbcsetup.fill=GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(optionFrameRate, gbcsetup);

        gbcsetup.gridx=0;
        gbcsetup.gridy=3;
        gbcsetup.gridwidth=1;
        gbcsetup.gridheight=1;
        gbcsetup.fill=GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(LabelResolution, gbcsetup);

        gbcsetup.gridx=1;
        gbcsetup.gridy=3;
        gbcsetup.gridwidth=2;
        gbcsetup.gridheight=1;
        gbcsetup.fill=GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(optionUnitsResolution, gbcsetup);

        gbcsetup.gridx=1;
        gbcsetup.gridy=4;
        gbcsetup.gridwidth=2;
        gbcsetup.gridheight=1;
        gbcsetup.fill=GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(labelDuration, gbcsetup);


        gbcsetup.gridx=0;
        gbcsetup.gridy=5;
        gbcsetup.gridwidth=1;
        gbcsetup.gridheight=1;
        gbcsetup.fill=GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(operator, gbcsetup);

        gbcsetup.gridx=1;
        gbcsetup.gridy=5;
        gbcsetup.gridwidth=1;
        gbcsetup.gridheight=1;
        gbcsetup.weightx=1.0;
        gbcsetup.fill=GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(spinnerDuration, gbcsetup);

        gbcsetup.gridx=2;
        gbcsetup.gridy=5;
        gbcsetup.gridwidth=1;
        gbcsetup.gridheight=1;
        gbcsetup.fill=GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(operationTime, gbcsetup);








        GridLayout extensionsLayout = new GridLayout(0,3);
        containerFileExtensions.setBounds(310,10,300,200);
        containerFileExtensions.setVisible(true);

        containerFileExtensions.setLayout(extensionsLayout);
        containerFileExtensions.setBorder(BorderFactory.createTitledBorder("Multimedia extensions"));

        containerFileExtensions.add(mp4);
        containerFileExtensions.add(wmv);
        containerFileExtensions.add(mpg);
        containerFileExtensions.add(mov);
        containerFileExtensions.add(avi);
        containerFileExtensions.add(xvidi);
        containerFileExtensions.add(mpg);
        containerFileExtensions.add(flv);
        containerFileExtensions.add(labelOtherExtension);
        containerFileExtensions.add(textOtherExtension);


        GridBagLayout gbl=new GridBagLayout();
        GridBagConstraints gbc=new GridBagConstraints();

        containerFileDateBase.setBounds(620,10,530,200);
        containerFileDateBase.setVisible(true);

        containerFileDateBase.setLayout(gbl);
        containerFileDateBase.setBorder(BorderFactory.createTitledBorder("Data Base"));

        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=1;
        gbc.gridheight=1;

        gbc.fill=GridBagConstraints.HORIZONTAL;
        containerFileDateBase.add(labelCriteria, gbc);

        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=3;
        gbc.gridheight=1;
        gbc.weightx=1.0;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        containerFileDateBase.add(textCriteria, gbc);

        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        containerFileDateBase.add(buttonSave, gbc);

        gbc.gridx=2;
        gbc.gridy=1;
        gbc.gridwidth=1;
        gbc.gridheight=1;
        containerFileDateBase.add(buttonLoad, gbc);

        gbc.gridx=0;
        gbc.gridy=2;
        gbc.gridwidth=3;
        gbc.gridheight=2;
        gbc.weighty=1.0;
        gbc.weightx=1.0;
        gbc.fill=GridBagConstraints.BOTH;
        containerFileDateBase.add(panelTableBD, gbc);

        /**containerFileDateBase.setEnabled(false);

        for (Component cp : containerFileDateBase.getComponents() ){
            cp.setEnabled(false);
        }*/

        //setupLayout.addLayoutComponent(labelAudioCodec);


        //buttonSearch.setBackground(Color.YELLOW);

       /* btSelect.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                btSelectMouseClicked(evt);
            }
        });

*/

    }

    /**
     * this method add all components.
     */
    public void addComponents() {
        //add(timeDuration);
        /**add(hidden);
        add(spinnerSize);
        //add(timeDuration);

        add(buttonLoad);
        add(buttonSave);
        add(LabelResolution);
//        add(labelHidden);
        add(operator);
        add(optionUnitsResolution);
        add(optionVideoCode);
        add(optionFrameRate);

        add(panelTable);
        add(panelTableBD);
        add(hiddenCheck);

        add(labelDuration);
        add(operationTime);
        add(labelDataBase);
        add(labelCriteria);
        add(labelVideoCode);
        add(labelFrameRate);
        add(textCriteria);

        add(mpeg);
        add(wmv);
        add(mp4);
        add(flv);
        add(xvidi);
        add(mpg);
        add(avi);
        add(mov);
        add(labelOtherExtension);
        add(textOtherExtension);
        add(optionAudioCodec);
        add(labelAudioCodec);*/




        //add(spinnerDuration);

        add(containerFileSetup);
        add(containerFileExtensions);
        add(containerFileDateBase);

        add(panelTable);

    }


    public ArrayList<String> getOtherExtensions() {
        ArrayList<String> extensions = new ArrayList<>();
        if (!textOtherExtension.getText().isEmpty()) {
            extensions.add(textOtherExtension.getText());
        }
        if (mp4.isSelected()) {
            extensions.add(mp4.getText());
        }
        if (mov.isSelected()) {
            extensions.add(mov.getText());
        }
        if (mpg.isSelected()) {
            extensions.add(mpg.getText());
        }
        if (wmv.isSelected()) {
            extensions.add(wmv.getText());
        }
        if (avi.isSelected()) {
            extensions.add(avi.getText());
        }
        if (flv.isSelected()) {
            extensions.add(flv.getText());
        }
        if (mpeg.isSelected()) {
            extensions.add(mpeg.getText());
        }
        if (xvidi.isSelected()) {
            extensions.add(xvidi.getText());
        }
        return extensions;
    }
    /**
     * this method get operatod.
     *
     * @return operator selected
     */
    public String getOperator(){
        return operator.getSelectedItem().toString();
    }

    public String getOptionVideoCode(){
        return optionVideoCode.getSelectedItem().toString();
    }
    public String getOptionUnitsResolution(){
        return optionUnitsResolution.getSelectedItem().toString();
    }
    public String getOperationTime(){
        return operationTime.getSelectedItem().toString();
    }
    public String getOptionFrameRate(){
        return optionFrameRate.getSelectedItem().toString();
    }
    public String getOptionAudioCodec(){
        return optionAudioCodec.getSelectedItem().toString();
    }
    public String getTextCriteria(){
        return textCriteria.getText();
    }
    public JButton getButtonLoad() {
        return buttonLoad;
    }
    public JButton getButtonSave() {
        return buttonSave;
    }
    public String getDuration(){
        return spinnerDuration.getValue().toString();
    }



    /**
     *
     *
     * @return value of file text
     */
    /*
    public String getTextFile() {
        return timeDuration.getText();
    }*/

    /**
     * this method get path.
     *
     * @return value of camp path
     */
    /*
    public String getTextPath() {
        return textPath.getText();
    }*/



    /**
     * This method add row in the table.
     *
     * @param newRow
     */
    public void addRow(String[] newRow) {
        panelTable.addRow(newRow);
        panelTableBD.addRow(newRow);
    }

    public void cleanTable() {
        panelTable.clean();
        panelTableBD.clean();
    }


}
