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
import java.awt.*;
import java.util.ArrayList;

/**
 * This class Asset can be FileResult SearchFolder.
 *
 * @author ketty camacho Vasquez- AT-[07].
 * @author Franz Elmer Silva Milan.
 * @author Franz Denis Camacho.
 * @version 1.0.
 */
public class PanelMultimedia extends JPanel {

    private static final Logger LOGGER = LoggerSearch.getInstance().getLogger();
    // JPanel to multimedia.
    public JPanel containerFileSetup;
    public JPanel containerFileExtensions;
    private JPanel containerFileDateBase;

    //JChecxBox to multimedia.
    public JCheckBox enableMediaSetup;
    private JCheckBox mp4;
    private JCheckBox mpeg;
    private JCheckBox mov;
    private JCheckBox wmv;
    private JCheckBox avi;
    private JCheckBox xvidi;
    private JCheckBox mpg;
    private JCheckBox flv;

    // JTextField to multimedia.
    private JTextField textCriteria;
    private JTextField textOtherExtension;

    //JButton to multimedia
    private JButton buttonLoad;
    private JButton buttonSave;

    //JComboBox<String> to multimedia.
    private JComboBox<String> optionUnitsResolution;
    private JComboBox<String> optionVideoCode;
    private JComboBox<String> optionFrameRate;
    private JComboBox<String> optionAudioCodec;
    private JComboBox<String> optionAspecRadio;
    private JComboBox<String> operatorTime;
    private JComboBox<String> unitTime;

    // JSpinner to multimedia.
    private JSpinner spinnerDuration;
    /**
     * array that contains units of the resolution, video code, frame rate, Audio Codec, Aspect Ratio.
     */
    private String[] listResolution;
    private String[] listVideoCode;
    private String[] listFrameRate;
    private String[] listAduioCodec;
    private String[] listAspecRadio;
    private String[] operatiorOptions;
    private String[] listTime;

    // title of each textLabel.
    private JLabel LabelResolution;
    private JLabel labelDataBase;
    private JLabel labelCriteria;
    private JLabel labelDuration;
    private JLabel labelVideoCode;
    private JLabel labelFrameRate;
    private JLabel labelOtherExtension;
    private JLabel labelAudioCodec;
    private JLabel labelAspecRadio;
    private JLabel labelFondo;

    // PanelTable to multimedia.
    private PanelTable panelTable;
    private PanelTableBD panelTableBD;

    // declare of checkBox multimedia extensions.
    private Border blacking;

    /**
     * this is constructor of the class PanelSearch.
     */

    public PanelMultimedia() {
        LOGGER.info("PanelMultimedia: enter");
        settingPanelMultimedia();
        initComponet();
        initComponetTable();
        settingPanel();
        addComponents();
        LOGGER.info("PanelMultimedia: exit");
    }

    /**
     * method init of componet multimedia.
     */
    private void initComponet() {

        LOGGER.info("initComponet: enter");
        containerFileSetup = new JPanel();
        containerFileExtensions = new JPanel();
        containerFileDateBase = new JPanel();

        // checkbox of the extensions.
        mp4 = new JCheckBox(".MP4");
        mpeg = new JCheckBox(".MPEG");
        mov = new JCheckBox(".MOV");
        wmv = new JCheckBox(".WMV");
        avi = new JCheckBox(".AVI");
        xvidi = new JCheckBox(".XVIDI");
        mpg = new JCheckBox(".MPG");
        flv = new JCheckBox(".FLV");
        enableMediaSetup = new JCheckBox("Enable Multimedia");
        enableMediaSetup.setBounds(10, 10, 210, 30);
        enableMediaSetup.setSelected(false);

        labelDataBase = new JLabel("DATA BASE");
        labelCriteria = new JLabel("CRITERIA:");
        labelDuration = new JLabel("DURATION: ");
        labelFrameRate = new JLabel("FRAME RATE:");
        labelAudioCodec = new JLabel("AUDIO CODEC:");
        LabelResolution = new JLabel("RESOLUTION:");
        labelVideoCode = new JLabel("VIDEO CODE:");
        labelAspecRadio = new JLabel("ASPECT RADIO:");
        labelOtherExtension = new JLabel("OTHER EXTENSION:");
        // add image fund of multimedia.
        ImageIcon iconeFondo = new ImageIcon("src/com/fundation/search/view/imagen/fondo3.jpg");
        labelFondo = new JLabel(iconeFondo);

        textCriteria = new JTextField(50);
        textOtherExtension = new JTextField();

        buttonLoad = new JButton("LOAD");
        buttonSave = new JButton("SAVE");

        listResolution = new String[]{" ", "0:1 480x360", "640:343 1280x686",
                "3:2 720x480", "4:3 176x144", "4:3 178x576", "4:3 320x240", "16:9 1280x720", "45:19 720x304", "180:101 720x404"};
        operatiorOptions = new String[]{">", "<", "="};
        listTime = new String[]{" ", "second", "minutes", "hours"};
        listVideoCode = new String[]{" ", "H264", "H263", "MPEG4", "WNV1"};
        listFrameRate = new String[]{" ", "24 fps", "25 fps", "30 fps", "60 fps"};
        listAduioCodec = new String[]{" ", "mp3", "aac", "amr_nb"};
        listAspecRadio = new String[]{" ", "0:1", "3:2", "4:3", "16:9", "21:9", "45:19", "180:101"};

        operatorTime = new JComboBox<>(operatiorOptions);
        optionUnitsResolution = new JComboBox<>(listResolution);
        unitTime = new JComboBox<>(listTime);
        optionVideoCode = new JComboBox<>(listVideoCode);
        optionFrameRate = new JComboBox<>(listFrameRate);
        optionAudioCodec = new JComboBox<>(listAduioCodec);
        optionAspecRadio = new JComboBox<>(listAspecRadio);

        int min = 0;
        int max = 1000000000;
        int step = 1;
        int initValue = 0;
        SpinnerModel model = new SpinnerNumberModel(initValue, min, max, step);
        spinnerDuration = new JSpinner(model);
        ((JSpinner.DefaultEditor) spinnerDuration.getEditor()).getTextField().setEditable(false);

        blacking = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

        LOGGER.info("initComponet: exit");


    }

    /**
     *
     */
    public void settingPanelMultimedia() {
        LOGGER.info("settingPanelMultimedia: enter");
        setLayout(null);
        setVisible(true);
    }

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
     * for look for archive and apply layout of multimedia.
     */

    public void settingPanel() {
        LOGGER.info("settingPanel: enter");

        GridBagLayout multimediaSetup = new GridBagLayout();
        GridBagConstraints multimediaConfig = new GridBagConstraints();
        containerFileSetup.setBounds(10, 50, 300, 200);
        containerFileSetup.setVisible(true);

        containerFileSetup.setBackground(new java.awt.Color(201, 222, 244));

        containerFileSetup.setLayout(multimediaSetup);
        containerFileSetup.setBorder(BorderFactory.createTitledBorder("Multimedia Setup"));

        multimediaConfig.gridx = 0;
        multimediaConfig.gridy = 0;
        multimediaConfig.gridwidth = 1;
        multimediaConfig.gridheight = 1;
        multimediaConfig.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(labelAudioCodec, multimediaConfig);

        multimediaConfig.gridx = 1;
        multimediaConfig.gridy = 0;
        multimediaConfig.gridwidth = 2;
        multimediaConfig.gridheight = 1;
        multimediaConfig.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(optionAudioCodec, multimediaConfig);

        multimediaConfig.gridx = 0;
        multimediaConfig.gridy = 1;
        multimediaConfig.gridwidth = 1;
        multimediaConfig.gridheight = 1;
        multimediaConfig.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(labelVideoCode, multimediaConfig);

        multimediaConfig.gridx = 1;
        multimediaConfig.gridy = 1;
        multimediaConfig.gridwidth = 2;
        multimediaConfig.gridheight = 1;
        multimediaConfig.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(optionVideoCode, multimediaConfig);

        multimediaConfig.gridx = 0;
        multimediaConfig.gridy = 2;
        multimediaConfig.gridwidth = 1;
        multimediaConfig.gridheight = 1;
        multimediaConfig.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(labelFrameRate, multimediaConfig);

        multimediaConfig.gridx = 1;
        multimediaConfig.gridy = 2;
        multimediaConfig.gridwidth = 2;
        multimediaConfig.gridheight = 1;
        multimediaConfig.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(optionFrameRate, multimediaConfig);

        multimediaConfig.gridx = 0;
        multimediaConfig.gridy = 3;
        multimediaConfig.gridwidth = 1;
        multimediaConfig.gridheight = 1;
        multimediaConfig.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(LabelResolution, multimediaConfig);

        multimediaConfig.gridx = 1;
        multimediaConfig.gridy = 3;
        multimediaConfig.gridwidth = 2;
        multimediaConfig.gridheight = 1;
        multimediaConfig.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(optionUnitsResolution, multimediaConfig);

        multimediaConfig.gridx = 0;
        multimediaConfig.gridy = 4;
        multimediaConfig.gridwidth = 1;
        multimediaConfig.gridheight = 1;
        multimediaConfig.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(labelAspecRadio, multimediaConfig);

        multimediaConfig.gridx = 1;
        multimediaConfig.gridy = 4;
        multimediaConfig.gridwidth = 2;
        multimediaConfig.gridheight = 1;
        multimediaConfig.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(optionAspecRadio, multimediaConfig);

        multimediaConfig.gridx = 1;
        multimediaConfig.gridy = 5;
        multimediaConfig.gridwidth = 2;
        multimediaConfig.gridheight = 1;
        multimediaConfig.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(labelDuration, multimediaConfig);

        multimediaConfig.gridx = 0;
        multimediaConfig.gridy = 6;
        multimediaConfig.gridwidth = 1;
        multimediaConfig.gridheight = 1;
        multimediaConfig.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(unitTime, multimediaConfig);

        multimediaConfig.gridx = 1;
        multimediaConfig.gridy = 6;
        multimediaConfig.gridwidth = 1;
        multimediaConfig.gridheight = 1;
        multimediaConfig.weightx = 1.0;
        multimediaConfig.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(spinnerDuration, multimediaConfig);

        multimediaConfig.gridx = 2;
        multimediaConfig.gridy = 6;
        multimediaConfig.gridwidth = 2;
        multimediaConfig.gridheight = 1;
        multimediaConfig.fill = GridBagConstraints.HORIZONTAL;
        containerFileSetup.add(operatorTime, multimediaConfig);


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

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints dataBaseLayout = new GridBagConstraints();

        containerFileDateBase.setBounds(620, 50, 530, 200);
        containerFileDateBase.setVisible(true);

        containerFileDateBase.setLayout(gbl);
        containerFileDateBase.setBorder(BorderFactory.createTitledBorder("Data Base"));

        dataBaseLayout.gridx = 0;
        dataBaseLayout.gridy = 0;
        dataBaseLayout.gridwidth = 1;
        dataBaseLayout.gridheight = 1;

        dataBaseLayout.fill = GridBagConstraints.HORIZONTAL;
        containerFileDateBase.add(labelCriteria, dataBaseLayout);

        dataBaseLayout.gridx = 1;
        dataBaseLayout.gridy = 0;
        dataBaseLayout.gridwidth = 3;
        dataBaseLayout.gridheight = 1;
        dataBaseLayout.weightx = 1.0;
        dataBaseLayout.fill = GridBagConstraints.HORIZONTAL;
        containerFileDateBase.add(textCriteria, dataBaseLayout);

        dataBaseLayout.gridx = 1;
        dataBaseLayout.gridy = 1;
        dataBaseLayout.gridwidth = 1;
        dataBaseLayout.gridheight = 1;
        containerFileDateBase.add(buttonSave, dataBaseLayout);

        dataBaseLayout.gridx = 2;
        dataBaseLayout.gridy = 1;
        dataBaseLayout.gridwidth = 1;
        dataBaseLayout.gridheight = 1;
        containerFileDateBase.add(buttonLoad, dataBaseLayout);

        dataBaseLayout.gridx = 0;
        dataBaseLayout.gridy = 2;
        dataBaseLayout.gridwidth = 3;
        dataBaseLayout.gridheight = 2;
        dataBaseLayout.weighty = 1.0;
        dataBaseLayout.weightx = 1.0;
        dataBaseLayout.fill = GridBagConstraints.BOTH;
        containerFileDateBase.add(panelTableBD, dataBaseLayout);

        labelFondo.setBounds(0, 0, 1500, 400);

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
        add(labelFondo);
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
     * @return operatorTime selected
     */
    public String getOperatorTime() {
        LOGGER.info("getOperatorTime: enter");
        LOGGER.info("getOperatorTime: exit");
        if (operatorTime.getSelectedItem().equals(" ")) {
            return null;
        } else {
            return operatorTime.getSelectedItem().toString();
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
    public String getUnitTime() {
        LOGGER.info("getUnitTime: enter");
        LOGGER.info("getUnitTime: exit");
        if (unitTime.getSelectedItem().equals(" ")) {
            return null;
        } else {
            return unitTime.getSelectedItem().toString();
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
     * @param dateEnableMediaSetup state of enable multimedia.
     */
    public void setSelectedMultiMediaSetup(boolean dateEnableMediaSetup) {
        this.enableMediaSetup.setSelected(dateEnableMediaSetup);
    }

    /**
     * this is method of set criteria.
     *
     * @param textCriteria
     */
    public void setTextCriteria(String textCriteria) {
        this.textCriteria.setText(textCriteria);
    }

    /**
     * this method of set resolution
     *
     * @param dateOptionUnitsResolution2 is string selected.
     */
    public void setOptionUnitsResolution(String dateOptionUnitsResolution2) {
        if (dateOptionUnitsResolution2 != null) {
            this.optionUnitsResolution.setSelectedItem(dateOptionUnitsResolution2);
        } else {
            optionUnitsResolution.setSelectedItem(" ");
        }
    }

    /**
     * this method set Aspect Ratio multimedia.
     *
     * @param dateOptionAspecRadio is string selected.
     */
    public void setOptionAspecRadio(String dateOptionAspecRadio) {
        if (dateOptionAspecRadio != null) {
            this.optionAspecRadio.setSelectedItem(dateOptionAspecRadio);
        } else {
            optionAspecRadio.setSelectedItem(" ");
        }
    }

    /**
     * this method set Video Code multimedia.
     *
     * @param dateOptionVideoCode is string selected.
     */
    public void setOptionVideoCode(String dateOptionVideoCode) {
        if (dateOptionVideoCode != null) {
            this.optionVideoCode.setSelectedItem(dateOptionVideoCode);
        } else {
            optionVideoCode.setSelectedItem(" ");
        }
    }

    /**
     * this method set Frame Rate multimedia.
     *
     * @param dateOptionFrameRate is string selected.
     */
    public void setOptionFrameRate(String dateOptionFrameRate) {
        if (dateOptionFrameRate != null) {
            this.optionFrameRate.setSelectedItem(dateOptionFrameRate);
        } else {
            optionFrameRate.setSelectedItem(" ");
        }
    }

    /**
     * this method set Audio Codec multimedia.
     *
     * @param dateOptionAudioCodec is string selected.
     */
    public void setOptionAudioCodec(String dateOptionAudioCodec) {
        if (dateOptionAudioCodec != null) {
            this.optionAudioCodec.setSelectedItem(dateOptionAudioCodec);
        } else {
            optionAudioCodec.setSelectedItem(" ");
        }
    }

    /**
     * this method set operatorTime of multimedia multimedia.
     *
     * @param operatorTime is string selected.
     */
    public void setOperatorTime(String operatorTime) {
        if (operatorTime != null) {
            this.operatorTime.setSelectedItem(operatorTime);
        } else {
            this.operatorTime.setSelectedItem(" ");
        }
    }

    /**
     * this method set operatorTime time
     *
     * @param unitTime is string selected.
     */
    public void setUnitTime(String unitTime) {
        this.unitTime.setSelectedItem(unitTime);
    }

    /**
     * @param spinnerDuration
     */
    public void setTimeDuration(int spinnerDuration) {
        this.spinnerDuration.setValue(spinnerDuration);

    }

    /**
     * @param listextencionsMultimedia list is select setter of extensions extencion.
     */
    public void setExtensionsMultimedia(ArrayList<String> listextencionsMultimedia) {
        mp4.setSelected(false);
        wmv.setSelected(false);
        mov.setSelected(false);
        xvidi.setSelected(false);
        avi.setSelected(false);
        mpg.setSelected(false);

        for (String valuesExtension : listextencionsMultimedia) {
            if (valuesExtension.contains("MP4")) {
                mp4.setSelected(true);
                continue;
            }
            if (valuesExtension.contains("WMV")) {
                wmv.setSelected(true);
                continue;
            }
            if (valuesExtension.contains("MOV")) {
                mov.setSelected(true);
                continue;
            }
            if (valuesExtension.contains("AVI")) {
                avi.setSelected(true);
                continue;
            }
            if (valuesExtension.contains("XVIDI")) {
                xvidi.setSelected(true);
                continue;
            }
            if (valuesExtension.contains("MPG")) {
                mpg.setSelected(true);
                continue;
            }

        }
    }

    /**
     * @return
     */
    public PanelTableBD getPanelTableBD() {
        return panelTableBD;
    }

    /**
     * This method add row in the table.
     *
     * @param newRow
     */
    public void addRowDB(String[] newRow) {
        panelTableBD.addRow(newRow);
    }

    /**
     * clean of table of data base.
     */
    public void cleanTableDB() {
        panelTableBD.clean();
    }
}
