package com.fundation.search.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
//import static com.sun.tools.internal.xjc.reader.Ring.add;

/**
 * class panel of DATA BASE;
 */
public class PanelTableBD extends JPanel{

        private DefaultTableModel modelDB;
        private JTable table;
        private JScrollPane scrollPane;

    public PanelTableBD (){

        tableBD();
    }
        private void tableBD(){
        String columnHeadBD[] = {"Nro","NAMES"};
        scrollPane = new JScrollPane();
        modelDB = new DefaultTableModel(columnHeadBD, 0);
        table = new JTable(modelDB);
        int vertical = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        int horizontal = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
        scrollPane = new JScrollPane(table,vertical,horizontal);
        setLayout(new BorderLayout());
        add(scrollPane);
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        render.setPreferredSize(new Dimension(0, 0));
        setBounds(700, 100, 450, 100);

        setBackground(new Color(250, 252, 252));

    }

        public void addRow(String[] newRow) {
        modelDB.addRow(newRow);
    }

        public void clean(){
        modelDB.setNumRows(0);
    }


    }


