package com.fundation.search.view;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
/**
 * This class Asset can be FileResult SearchFolder.
 *
 * @author ketty camacho Vasquez- AT-[07].
 * @version 1.0.
 */


public class PanelSearch extends JPanel {
    private JTextField textFile;
    private JTextField textPath;
    private JButton buttonSearsh;
    private JComboBox<String> operator;
    String[] operatiorOptions;
    /**
     * array that contains units of the bytes,kb,Mb and Gb.
     */
    String[] listUnitSize;
    JComboBox<String> tipeListSize;

    JLabel LabelSize;
    JLabel labelFile;
    JLabel labelPhat;

    //JTable tables;
    //here look at size the cant.
    JSpinner spinnerSize;
    private DefaultTableModel model;
    JTable table;

    /**
     * this is constructor of the class PanelSearch.
     */

    public PanelSearch() {
        settingPanelSearch();
        initComponetTable();
        initComponetPanel();
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
        listUnitSize = new String[]{"bytes", "kb", "Mb", "Gb"};
        operatiorOptions = new String[]{">", "<", "="};
        String columnHead[] = {"FILE", "SIZE", "PATH","HIDDEN"};

        Object[][] data = {
                {"USA", "Washington DC", 280, true},
                {"Canada", "Ottawa", 32, true},
                {"United Kingdom", "London", 60, true},
                {"Germany", "Berlin", 83, true},
                {"France", "Paris", 60, true},
                {"Norway", "Oslo", 4.5, true},
                {"India", "New Delhi", 1046, true}
        };

        model = new DefaultTableModel(columnHead,0);
        table = new JTable(model);

        JTableHeader heard = table.getTableHeader();
        JPanel panel = new JPanel();

        //review on interface the table.
        panel.setLayout(new BorderLayout());
        panel.add(heard, BorderLayout.NORTH);

        panel.add(table, BorderLayout.CENTER);
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setPreferredSize(new Dimension(0, 0));
        //position of table.
        panel.setBounds(15, 120, 600, 340);
        add(panel);
    }

    /**
     * this method contain is have the location and other property as color and text
     * for look for archive.
     */

    public void initComponetPanel() {
        textFile = new JTextField(10);
        textFile.setText("FILE-NAME");
        textFile.setBounds(90, 20, 100, 30);
        add(textFile);
        labelFile = new JLabel("FILE NAME:");
        labelFile.setBounds(10, 20, 100, 30);
        textPath = new JTextField(10);
        textPath.setText("PATH");
        textPath.setBounds(90, 50, 100, 30);
        labelPhat = new JLabel("PATH:");
        //position.
        labelPhat.setBounds(10, 50, 100, 30);
        //create a botton search for search.
        buttonSearsh = new JButton();
        //name of botton.
        buttonSearsh.setText("SEARCH");
        //position of botton.
        buttonSearsh.setBounds(500, 20, 100, 30);
        //bottoSearsh.setIcon(new ImageIcon(Class.class.getResource("/images/lupa.jpg")));
        buttonSearsh.setBackground(Color.YELLOW);
        LabelSize = new JLabel("SIZE:");
        LabelSize.setBounds(320, 50, 100, 30);
        //dropdown a list that contain =`,`>` and ´<`.
        operator = new JComboBox<>(operatiorOptions);
        operator.setBounds(440, 50, 60, 30);
        //create a size  tipe dropdown.
        tipeListSize = new JComboBox<>(listUnitSize);
        //position size.
        tipeListSize.setBounds(500, 50, 100, 30);
        //create spinner.
        spinnerSize = new JSpinner();
        //on field look ten
        spinnerSize.setValue(10);
        //position of spinner Size
        spinnerSize.setBounds(350, 50, 70, 30);
        //add the panel is panelSearch.
        add(spinnerSize);
        add(textFile);
        add(textPath);
        add(labelFile);
        add(labelPhat);
        add(buttonSearsh);
        add(LabelSize);
        add(operator);
        add(tipeListSize);
        add(textPath);
    }

    /**
     * get value that is selected.
     * @return value that selected
     */
    public String getTipeListSize() {
        return tipeListSize.getSelectedItem().toString();
    }

    /**
     * this method get operatod.
     * @return operator selected
     */
    public String getOperator() {
        return operator.getSelectedItem().toString();
    }

    /**
     * this method get file text.
     * @return value of file text
     */
    public String getTextFile() {
        return textFile.getText();
    }

    /**
     * this method get path.
     * @return  value of camp path
     */
    public String getTextPath() {
        return textPath.getText();
    }

    /**
     * this method get button
     * @return button
     */
    public String getButtoSearsh() {
        return buttonSearsh.getText();
    }
}
