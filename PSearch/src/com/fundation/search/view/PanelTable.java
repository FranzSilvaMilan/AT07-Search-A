package com.fundation.search.view;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;


public class PanelTable extends JPanel{
    private DefaultTableModel model;
    private JTable table;
    private JScrollPane scrollPane;


    public PanelTable(){
        initTable();
    }

    private void initTable() {
        String columnHead[] = {"FILE", "SIZE", "PATH", "HIDDEN","EXTENTION"};
        scrollPane = new JScrollPane();
        model = new DefaultTableModel(columnHead, 0);
        table = new JTable(model);
        int vertical = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int horizontal = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
        scrollPane = new JScrollPane(table,vertical,horizontal);
        setLayout(new BorderLayout());

        add(scrollPane);
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setPreferredSize(new Dimension(0, 0));
        setBounds(10, 220, 1150, 450);
    }

    public void addRow(String[] newRow) {
        model.addRow(newRow);
    }


}
