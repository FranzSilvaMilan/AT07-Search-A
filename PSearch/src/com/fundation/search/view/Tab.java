package com.fundation.search.view;

import javax.swing.JTabbedPane;
import java.awt.*;

public class Tab extends JTabbedPane{

    PanelSearch panelSearch;
    PanelMultimedia panelMultimedia;


    public void iniComponentsTab(){
        panelSearch = new PanelSearch();
        panelMultimedia = new PanelMultimedia();
        panelSearch.setBackground(Color.getHSBColor(33,363,234));
        setBounds(15, 35, 650, 540);
        add("FILE", panelSearch);
        addTab("MULTIMEDIA", panelMultimedia);
    }

    public PanelSearch getPanelSearch(){
        return panelSearch;
    }
}
