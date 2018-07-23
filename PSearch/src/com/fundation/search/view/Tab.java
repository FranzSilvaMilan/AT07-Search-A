package com.fundation.search.view;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.*;

public class Tab extends JTabbedPane{

    PanelSearch panelSearch;
    PanelMultimedia panelMultimedia;


    public void iniComponentsTab(){
        panelSearch = new PanelSearch();
        panelMultimedia = new PanelMultimedia();
        panelSearch.setBackground(Color.white);
        setBounds(10, 10, 1180, 800);
        add("FILE", panelSearch);
        addTab("MULTIMEDIA", panelMultimedia);
        addTab("Welcome",new JLabel(new ImageIcon("bksqla_xlargecover.jpg")));
        //ImageIcon tab1Icon = new ImageIcon(
              //  this.getClass().getResource("/images/test-pass-icon.png"));
    }

    public PanelSearch getPanelSearch(){
        return panelSearch;
    }
}
