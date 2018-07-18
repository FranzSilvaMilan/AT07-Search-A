package com.fundation.search.view;


import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;

/**
 * This class Asset can be FileResult SearchFolder.
 *
 * @author ketty camacho Vasquez- AT-[07].
 * @version 1.0.
 */


public class PanelSearch extends JPanel {


    private JTextField textFile;
    private JTextField textPath;
    private JButton bottoSearsh;
    private JComboBox<String> operator;
    String[] tipeList = new String[]{">", "<", "="};
    //create a arreglo of contain ListSize the bytes,kb,Mb and Gb.
    String[] ListSize = new String[]{"bytes", "kb", "Mb", "Gb"};
    JComboBox<String> tipeListSize;

    JLabel LabelSize;
    JLabel labelFile;
    JLabel labelPhat;

    //JTable tables;
    //here look at size the cant.
    JSpinner spinnerSize;

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

        String column[] = {"FILE", "SIZE", "PATH"};
        DefaultTableModel model = new DefaultTableModel(column, 30);
        JTable table = new JTable(model);
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
        //create a text field whit columns 10.
        textFile = new JTextField(10);
        //look at "FILE-NAME" on text field.
        textFile.setToolTipText("text file");
        //position x,y,width and height.
        textFile.setBounds(90, 20, 100, 30);
        //add on panelSearch.
        add(textFile);
        //text reference JtexField.
        labelFile = new JLabel("FILE NAME:");
        //position x,y,width and height.
        labelFile.setBounds(10, 20, 100, 30);
        //create a text field whit columns 10 of path.
        textPath = new JTextField(10);
        textPath.setText("PATH");
        //position of path.
        textPath.setBounds(90, 50, 100, 30);
        //title reference a JtextFileld of File.
        labelPhat = new JLabel("PATH:");
        //position.
        labelPhat.setBounds(10, 50, 100, 30);
        //create a botton search for search.
        bottoSearsh = new JButton();
        //name of botton.
        bottoSearsh.setText("SEARCH");
        //position of botton.
        bottoSearsh.setBounds(200, 50, 100, 30);
        bottoSearsh.setBackground(Color.YELLOW);
        LabelSize = new JLabel("SIZE:");
        LabelSize.setBounds(320, 50, 100, 30);
        //dropdown a list that contain =`,`>` and ´<`.
        operator = new JComboBox<>(tipeList);
        operator.setBounds(440, 50, 60, 30);
        //create a size  tipe dropdown.
        tipeListSize = new JComboBox<>(ListSize);
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
        add(bottoSearsh);
        add(LabelSize);
        add(operator);
        add(tipeListSize);
        add(textPath);
    }

    public String getTipeListSize() {
        System.out.println(tipeListSize.getSelectedItem().toString());
        return tipeListSize.getSelectedItem().toString();
    }

    public String getOperator() {
        System.out.println(operator.getSelectedItem().toString());
        return operator.getSelectedItem().toString();
    }

    public String getTextFile() {
        return textFile.getText();
    }

    public String getTextPath() {
        return textPath.getText();
    }

    public String getBottoSearsh() {
        return bottoSearsh.getText();
    }


}
