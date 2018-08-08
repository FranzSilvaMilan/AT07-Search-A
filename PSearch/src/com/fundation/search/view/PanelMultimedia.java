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


import com.fundation.search.utils.LoggerSearch;
import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import java.awt.*;
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
    private static final Logger LOGGER = LoggerSearch.getInstance().getLogger();

    private JPanel containerFileSetup;
    private JPanel containerFileExtensions;
    private JPanel containerFileDateBase;

    private JCheckBox enableMediaSetup;


    private JTextField textCriteria;
    private JTextField textOtherExtension;
    private JButton buttonLoad;
    private JButton buttonSave;
    //private JTextField textDuration;
    private JCheckBox hiddenCheck;
    private String[] operatiorOptions;
    private JComboBox<String> operator;
    private JButton btSelect;
    /**
     * array that contains units of the bytes,kb,Mb and Gb.
     */
    private String[] listResolution;
    private String[] listTime;
    private String[] listVideoCode;
    private String[] listFrameRate;
    private String[] listAduioCodec;
    private String[] listAspecRadio;

    private JComboBox<String> optionUnitsResolution;
    private JComboBox<String> operationTime;
    private JComboBox<String> optionVideoCode;
    private JComboBox<String> optionFrameRate;
    private JComboBox<String> optionAudioCodec;
    private JComboBox<String> optionAspecRadio;

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
    private JLabel labelAspecRadio;


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
        LOGGER.info("PanelMultimedia: enter");
        settingPanelMultimedia();
        //settingPanelSearch();
        initComponet();
        initComponetTable();
        settingPanel();
        addComponents();
        LOGGER.info("PanelMultimedia: exit");
    }

    public void stateChanged(ChangeEvent e) {

    }

    private void initComponet() {
        LOGGER.info("initComponet: enter");

        containerFileSetup = new JPanel();
        containerFileExtensions = new JPanel();
        containerFileDateBase = new JPanel();

        enableMediaSetup = new JCheckBox("Enable Multimedia");

        enableMediaSetup.setBounds(10, 10, 210, 30);
        enableMediaSetup.setSelected(false);

        enableMediaSetup.addActionListener(event -> {
            JCheckBox cb = (JCheckBox) event.getSource();
            if (cb.isSelected()) {
                enableSetupContainer(true);
            } else {
                enableSetupContainer(false);
            }
        });


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
        labelAspecRadio = new JLabel("ASPECT RADIO:");
        listResolution = new String[]{" ", "0:1 480x360", "640:343 1280x686",
                "3:2 720x480", "4:3 320x240", "16:9 1280x720", "45:19 720x304", "180:101 720x404"};
        operatiorOptions = new String[]{">", "<", "="};
        listTime = new String[]{" ", "second", "minutes", "hours"};
        listVideoCode = new String[]{" ", "H264", "H263", "MPEG4", "WNV1"};
        listFrameRate = new String[]{" ", "24 fps", "25 fps", "30 fps", "60 fps"};
        listAduioCodec = new String[]{" ", "mp3", "aac"};
        listAspecRadio = new String[]{"", "0:1", "3:2", "4:3", "16:9", "21:9", "45:19", "180:101"};
        operator = new JComboBox<>(operatiorOptions);
        optionUnitsResolution = new JComboBox<>(listResolution);
        operationTime = new JComboBox<>(listTime);
        optionVideoCode = new JComboBox<>(listVideoCode);
        optionFrameRate = new JComboBox<>(listFrameRate);
        optionAudioCodec = new JComboBox<>(listAduioCodec);
        optionAspecRadio = new JComboBox<>(listAspecRadio);
        spinnerDuration = new JSpinner();

        //textDuration = new JTextField("Duration");

        textOtherExtension = new JTextField();
        labelOtherExtension = new JLabel("OTHER EXTENSION:");
        mp4 = new JCheckBox(".MP4");
        mpeg = new JCheckBox(".MPEG");
        mov = new JCheckBox(".MOV");
        wmv = new JCheckBox(".WMV");
        avi = new JCheckBox(".AVI");
        xvidi = new JCheckBox(".XVIDI");
        mpg = new JCheckBox(".MPG");
        flv = new JCheckBox(".FLV");


        blacking = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

        LOGGER.info("initComponet: exit");

    }

    private void enableSetupContainer(boolean b) {
        LOGGER.info("enableSetupContainer: enter");
        containerFileExtensions.setEnabled(b);
        for (Component cp : containerFileExtensions.getComponents()) {
            cp.setEnabled(b);
        }

        containerFileSetup.setEnabled(b);
        for (Component cp : containerFileSetup.getComponents()) {
            cp.setEnabled(b);
        }
        LOGGER.info("enableSetupContainer: exit");
    }

    public void settingPanelMultimedia() {
        LOGGER.info("settingPanelMultimedia: enter");
        setLayout(null);
        setVisible(true);
        LOGGER.info("settingPanelMultimedia: exit");
    }
    /**
     * it is method contain configuration.
     */
   /* public void settingPanelSearch() {
        setLayout(null);
        setVisible(true);
    }*/

    /**
     * this method containTable contain table of information list archive.
     */
    private void initComponetTable() {
        LOGGER.info("initComponetTable: enter");
        panelTable = new PanelTable();
        panelTableBD = new PanelTableBD();
        LOGGER.info("initComponetTable: exit");
    }

    /**
     * this method contain is have the location and other property as color and text
     * for look for archive.
     */

    public void settingPanel() {
        //textCriteria.setBounds(0,0,200,30);
        LOGGER.info("settingPanel: enter");
        GridBagLayout gblsetup = new GridBagLayout();
        GridBagConstraints gbcsetup = new GridBagConstraints();
        containerFileSetup.setBounds(10, 50, 300, 200);
        containerFileSetup.setVisible(true);

        containerFileSetup.setBackground(new java.awt.Color(201, 222, 244));

        containerFileSetup.setLayout(gblsetup);
        containerFileSetup.setBorder(BorderFactory.createTitledBorder("Multimedia Setup"));

        gbcsetup.gridx = 0;
        gbcsetup.gridy = 0;
        gbcsetup.gridwidth = 1;
        gbcsetup.gridheight = 1;
        gbcsetup.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(labelAudioCodec, gbcsetup);

        gbcsetup.gridx = 1;
        gbcsetup.gridy = 0;
        gbcsetup.gridwidth = 2;
        gbcsetup.gridheight = 1;
        gbcsetup.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(optionAudioCodec, gbcsetup);

        gbcsetup.gridx = 0;
        gbcsetup.gridy = 1;
        gbcsetup.gridwidth = 1;
        gbcsetup.gridheight = 1;
        gbcsetup.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(labelVideoCode, gbcsetup);

        gbcsetup.gridx = 1;
        gbcsetup.gridy = 1;
        gbcsetup.gridwidth = 2;
        gbcsetup.gridheight = 1;
        gbcsetup.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(optionVideoCode, gbcsetup);

        gbcsetup.gridx = 0;
        gbcsetup.gridy = 2;
        gbcsetup.gridwidth = 1;
        gbcsetup.gridheight = 1;
        gbcsetup.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(labelFrameRate, gbcsetup);

        gbcsetup.gridx = 1;
        gbcsetup.gridy = 2;
        gbcsetup.gridwidth = 2;
        gbcsetup.gridheight = 1;
        gbcsetup.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(optionFrameRate, gbcsetup);

        gbcsetup.gridx = 0;
        gbcsetup.gridy = 3;
        gbcsetup.gridwidth = 1;
        gbcsetup.gridheight = 1;
        gbcsetup.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(LabelResolution, gbcsetup);

        gbcsetup.gridx = 1;
        gbcsetup.gridy = 3;
        gbcsetup.gridwidth = 2;
        gbcsetup.gridheight = 1;
        gbcsetup.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(optionUnitsResolution, gbcsetup);

        gbcsetup.gridx = 0;
        gbcsetup.gridy = 4;
        gbcsetup.gridwidth = 1;
        gbcsetup.gridheight = 1;
        gbcsetup.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(labelAspecRadio, gbcsetup);

        gbcsetup.gridx = 1;
        gbcsetup.gridy = 4;
        gbcsetup.gridwidth = 2;
        gbcsetup.gridheight = 1;
        gbcsetup.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(optionAspecRadio, gbcsetup);

        gbcsetup.gridx = 1;
        gbcsetup.gridy = 5;
        gbcsetup.gridwidth = 2;
        gbcsetup.gridheight = 1;
        gbcsetup.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(labelDuration, gbcsetup);

        gbcsetup.gridx = 0;
        gbcsetup.gridy = 6;
        gbcsetup.gridwidth = 1;
        gbcsetup.gridheight = 1;
        gbcsetup.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(operator, gbcsetup);

        gbcsetup.gridx = 1;
        gbcsetup.gridy = 6;
        gbcsetup.gridwidth = 1;
        gbcsetup.gridheight = 1;
        gbcsetup.weightx = 1.0;
        gbcsetup.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(spinnerDuration, gbcsetup);

        gbcsetup.gridx = 2;
        gbcsetup.gridy = 6;
        gbcsetup.gridwidth = 1;
        gbcsetup.gridheight = 1;
        gbcsetup.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(operationTime, gbcsetup);

        GridLayout extensionsLayout = new GridLayout(0, 3);
        containerFileExtensions.setBounds(310, 50, 300, 200);
        containerFileExtensions.setVisible(true);

        containerFileExtensions.setBackground(new java.awt.Color(201, 222, 244));
        containerFileExtensions.setLayout(extensionsLayout);
        containerFileExtensions.setBorder(BorderFactory.createTitledBorder("Multimedia extensions"));

        containerFileExtensions.add(mp4);
        containerFileExtensions.add(wmv);
        containerFileExtensions.add(mpg);
        containerFileExtensions.add(mov);
        containerFileExtensions.add(avi);
        containerFileExtensions.add(xvidi);
        containerFileExtensions.add(mpg);
        //containerFileExtensions.add(flv);
        //containerFileExtensions.add(labelOtherExtension);
        //containerFileExtensions.add(textOtherExtension);

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        containerFileDateBase.setBounds(620, 50, 530, 200);
        containerFileDateBase.setVisible(true);

        containerFileDateBase.setLayout(gbl);
        containerFileDateBase.setBorder(BorderFactory.createTitledBorder("Data Base"));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        containerFileDateBase.add(labelCriteria, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        containerFileDateBase.add(textCriteria, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        containerFileDateBase.add(buttonSave, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        containerFileDateBase.add(buttonLoad, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 2;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        containerFileDateBase.add(panelTableBD, gbc);
        enableSetupContainer(false);

        /**containerFileDateBase.setEnabled(false);

         for (Component cp : containerFileDateBase.getComponents() ){
         cp.setEnabled(false);
         }*/
        LOGGER.info("settingPanel: exit");
    }

    /**
     * this method add all components.
     */
    public void addComponents() {
        LOGGER.info("addComponents: enter");
        add(enableMediaSetup);
        add(containerFileSetup);
        add(containerFileExtensions);
        add(containerFileDateBase);
        add(panelTable);
        LOGGER.info("addComponents: exit");
    }

    /**
     * this method get the extensions of multimedia
     *
     * @return list of multimedia
     */

    public ArrayList<String> getOtherExtensions() {
        LOGGER.info("getOtherExtensions: enter");
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
        LOGGER.info("getOtherExtensions: exit");
        return extensions;
    }

    /**
     * this method get operatod.
     *
     * @return operator selected
     */
    public String getOperator() {
        LOGGER.info("getOperator: enter");
        LOGGER.info("getOperator: exit");
        if (operator.getSelectedItem().equals(" ")) {
            return null;
        } else {

            return operator.getSelectedItem().toString();
        }
    }

    /**
     * this method of video code.
     *
     * @return a string of video code.
     */
    public String getOptionVideoCode() {
        LOGGER.info("getOptionVideoCode: enter");
        LOGGER.info("getOptionVideoCode: exit");
        if (optionVideoCode.getSelectedItem().equals(" ")) {
            return null;
        } else {
            return optionVideoCode.getSelectedItem().toString();
        }
    }

    /**
     * @return String selected of Resolution.
     */
    public String getOptionUnitsResolution() {
        LOGGER.info("getOptionUnitsResolution: enter");
        LOGGER.info("getOptionUnitsResolution: exit");
        if (optionUnitsResolution.getSelectedItem().equals(" ")) {
            return null;
        } else {

            return optionUnitsResolution.getSelectedItem().toString();
        }
    }

    /**
     * @return selected option of aspect radio of file multimedia.
     */
    public String getAspectRadio() {
        if (optionAspecRadio.getSelectedItem().equals(" ")) {
            return null;
        } else {
            return optionAspecRadio.getSelectedItem().toString();
        }
    }

    /**
     * @return String selected of Operation Time.
     */
    public String getOperationTime() {
        LOGGER.info("getOperationTime: enter");
        LOGGER.info("getOperationTime: exit");
        if (operationTime.getSelectedItem().equals(" ")) {
            return null;
        } else {
            return operationTime.getSelectedItem().toString();
        }
    }

    /**
     * @return String Option of frame selected
     */
    public String getOptionFrameRate() {
        LOGGER.info("getOptionFrameRate: enter");
        LOGGER.info("getOptionFrameRate: exit");
        if (optionFrameRate.getSelectedItem().equals(" ")) {
            return null;
        } else {
            return optionFrameRate.getSelectedItem().toString();
        }
    }

    /**
     * @return string when selected of audio.
     */
    public String getOptionAudioCodec() {
        LOGGER.info("getOptionAudioCodec: enter");
        LOGGER.info("getOptionAudioCodec: exit");
        if (optionAudioCodec.getSelectedItem().equals(" ")) {
            return null;
        } else {

            return optionAudioCodec.getSelectedItem().toString();
        }
    }

    /**
     * @return criteria.
     */
    public String getTextCriteria() {
        LOGGER.info("getTextCriteria: enter");
        LOGGER.info("getTextCriteria: exit");
        return textCriteria.getText();
    }

    /**
     * @return button of load.
     */
    public JButton getButtonLoad() {
        LOGGER.info("getButtonLoad: enter");
        LOGGER.info("getButtonLoad: exit");
        return buttonLoad;
    }

    /**
     * @return button save.
     */
    public JButton getButtonSave() {
        return buttonSave;
    }

    /**
     * @return value of duration.
     */
    public String getDuration() {
        LOGGER.info("getDuration: enter");
        LOGGER.info("getDuration: exit");
        return spinnerDuration.getValue().toString();
    }

    /**
     * @return boolean of active multimedia.
     */
    public boolean getenableMediaSetup() {
        LOGGER.info("getenableMediaSetup: enter");
        LOGGER.info("getenableMediaSetup: exit");
        return enableMediaSetup.isSelected();
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
