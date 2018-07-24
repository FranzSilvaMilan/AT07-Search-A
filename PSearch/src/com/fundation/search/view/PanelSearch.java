package com.fundation.search.view;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * This class Asset can be FileResult SearchFolder.
 *
 * @author ketty camacho Vasquez- AT-[07].
 * @version 1.0.
 */
public class PanelSearch extends JPanel {
    private JTextField textFile;
    private JTextField textPath;
    private JButton buttonSearch;
    JCheckBox hiddenCheck;
    String[] operatiorOptions;
    private JComboBox<String> operator;
    private JButton btSelect;
    /**
     * array that contains units of the bytes,kb,Mb and Gb.
     */
    String[] listUnitSize;
    private JComboBox<String> optionUnitsSize;

    JLabel LabelSize;
    JLabel labelFile;
    JLabel labelPhat;
    JLabel labelHidden;

    PanelTable panelTable;

    JSpinner spinnerSize;
    JRadioButton hidden;
    ButtonGroup radioGruop;




    /**
     * this is constructor of the class PanelSearch.
     */

    public PanelSearch() {
        settingPanelSearch();
        initComponet();
        initComponetTable();
        settingPanel();
        addComponents();
    }

    private void initComponet() {
        listUnitSize = new String[]{"bytes", "Kb", "Mb", "Gb"};
        operatiorOptions = new String[]{">", "<", "="};
        textFile = new JTextField();
        labelFile = new JLabel("FILE NAME:");
        textPath = new JTextField("C:\\");
        labelPhat = new JLabel("PATH:");
        buttonSearch = new JButton("SEARCH");
        LabelSize = new JLabel("SIZE:");
        labelHidden = new JLabel("HIDDEN");
        operator = new JComboBox<>(operatiorOptions);
        optionUnitsSize = new JComboBox<>(listUnitSize);
        spinnerSize = new JSpinner();
        hidden = new JRadioButton("hidden");
        radioGruop = new ButtonGroup();
        hiddenCheck = new JCheckBox("Hidden");
        btSelect = new JButton();
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


    }

    /**
     * this method contain is have the location and other property as color and text
     * for look for archive.
     */

    public void settingPanel() {

        labelFile.setBounds(10, 20, 100, 30);
        textFile.setBounds(90, 20, 700, 30);
        textFile.setBackground(new Color(204, 255, 229));

        labelPhat.setBounds(10, 50, 100, 30);
        textPath.setBounds(90, 50, 700, 30);
        textPath.setBackground(new Color(204, 255, 229));
        btSelect.setText("Select Path");
        btSelect.setBounds(810, 50, 120, 30);


        LabelSize.setBounds(10, 80, 100, 30);
        operator.setBounds(230, 80, 50, 30);
        optionUnitsSize.setBounds(160, 80, 70, 30);
        spinnerSize.setValue(0);
        spinnerSize.setBounds(90, 80, 70, 30);

        labelHidden.setBounds(10, 110, 100, 30);
        hiddenCheck.setBounds(90, 110, 70, 30);
        //radioGruop.add(hiddenCheck);

        buttonSearch.setBounds(1000, 180, 150, 30);
        buttonSearch.setBackground(Color.YELLOW);

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
        add(labelFile);
        add(labelPhat);
        add(buttonSearch);
        add(LabelSize);
        add(labelHidden);
        add(operator);
        add(optionUnitsSize);
        add(textPath);
        add(panelTable);
        add(hiddenCheck);
        add(btSelect);


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
     * this method get operatod.
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
     * @return value of size
     */
    public String getSizeFile(){
        return spinnerSize.getValue().toString();
    }

    /**
     * this method get value of radio button hidden.
     * @return true if selected.
     */
    public boolean getHidden(){
        return hiddenCheck.isSelected();
    }

    public void cleanTable() {
        panelTable.clean();
    }

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

