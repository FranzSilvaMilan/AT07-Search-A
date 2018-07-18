package com.fundation.search.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Color;

/**
 * @author Ketty Camacho Vasquez.
 * this is class is a Jframe fisrt,it contain panel of.
 * search panel of a archive and path.
 */

public class FrameMain  extends JFrame {
    /**
     * instance the object panelSearch, panelMultimedia, title and tab.
     */

    PanelSearch panelSearch;
    PanelMultimedia panelMultimedia;
    JLabel title;
    JTabbedPane Tab;

    /**
     * this is constructor of class {@link FrameMain}
     */

    public FrameMain() {

        iniComponent();
        settingFameMain();

    }

    /**
     * this is method of configuration of Frame Main.
     */
    public void settingFameMain() {
        setLayout(null);
        setTitle("SEARCH");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(Color.lightGray);
        setVisible(true);
    }

    public void iniComponent() {
        //create panel Search.
        panelSearch = new PanelSearch();

        panelSearch.setBackground(Color.CYAN);
        //create of panel multimedia.
        panelMultimedia = new PanelMultimedia();
        //create a JtabbedPane
        Tab = new JTabbedPane();
        //position
        Tab.setBounds(15, 35, 650, 540);
        //this is title AT07, and setBounds position of the title middle.
        title = new JLabel("AT07-team-A");
        title.setBounds(300, 10, 300, 30);

        // add a tab of the panel Search.
        Tab.add("FILE", panelSearch);
        // add a tab of the panel Multimedia.
        Tab.addTab("MULTIMEDIA", panelMultimedia);
        // add the tab that with flange of the searchFile.
        add(Tab);
        //add of title AT07-team-A.
        add(title);
    }


}
