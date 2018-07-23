package com.fundation.search.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
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
public class PanelMultimedia extends JPanel {
    private JTextField textFile;
    private JTextField textPath;
    private JButton buttonSearsh;

    String[] operatiorOptions;
    private JComboBox<String> operator;

    /**
     * array that contains units of the bytes,kb,Mb and Gb.
     */
    String[] listUnitSize;
    private JComboBox<String> tipeListSize;

    JLabel LabelSize;
    JLabel labelFile;
    JLabel labelPhat;

    JScrollPane scroll;

    //JTable tables;
    //here look at size the cant.
    JSpinner spinnerSize;
    private DefaultTableModel model;
    JTable table;

    /**
     * this is constructor of the class PanelSearch.
     */

    public PanelMultimedia() {
        settingPanelSearch();
        initComponetTable();
        initComponet();
        settingPanel();
        addComponents();
    }

    private void initComponet() {


        textFile = new JTextField();
        labelFile = new JLabel("FILE NAME:");
        textPath = new JTextField("C:\\");
        labelPhat = new JLabel("PATH:");
        buttonSearsh = new JButton("SEARCH");
        LabelSize = new JLabel("SIZE:");
        operator = new JComboBox<>(operatiorOptions);
        tipeListSize = new JComboBox<>(listUnitSize);
        spinnerSize = new JSpinner();
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
        String columnHead[] = {"FILE", "SIZE", "PATH", "HIDDEN"};

        model = new DefaultTableModel(columnHead, 0);
        table = new JTable(model);

        JTableHeader heard = table.getTableHeader();
        JPanel panel = new JPanel();
        //scroll = new JScrollPane(table);
        panel.setLayout(new BorderLayout());
        panel.add(heard, BorderLayout.NORTH);

        panel.add(table, BorderLayout.CENTER);
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setPreferredSize(new Dimension(0, 0));
        //position of table.
        panel.setBounds(15, 120, 650, 340);
        //panel.add(scroll);
        add(panel);
    }

    /**
     * this method contain is have the location and other property as color and text
     * for look for archive.
     */

    public void settingPanel() {
        textFile.setBounds(90, 20, 100, 30);

        labelFile.setBounds(10, 20, 100, 30);

        textPath.setBounds(90, 50, 100, 30);
        textPath.setBackground(new Color(204, 255, 229));

        labelPhat.setBounds(10, 50, 100, 30);

        buttonSearsh.setBounds(500, 20, 100, 30);
        buttonSearsh.setBackground(Color.YELLOW);

        LabelSize.setBounds(320, 50, 100, 30);

        operator.setBounds(440, 50, 60, 30);

        tipeListSize.setBounds(500, 50, 100, 30);

        spinnerSize.setValue(10);
        spinnerSize.setBounds(350, 50, 70, 30);
    }

    /**
     * this method add all components.
     */
    public void addComponents() {
        add(textFile);
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
     *
     * @return value that selected
     */
    public String getTipeListSize() {
        return tipeListSize.getSelectedItem().toString();
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
        return buttonSearsh;
    }

    /**
     * This method add row in the table.
     *
     * @param newRow
     */
    public void addRow(String[] newRow) {
        model.addRow(newRow);
    }
}
