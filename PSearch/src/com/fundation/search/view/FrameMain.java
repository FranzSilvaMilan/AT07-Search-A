package com.fundation.search.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Color;

/**
 * @author Ketty Camacho Vasquez.
 * @author Franz Elmer Silva Milan.
 * this is class is a Jframe fisrt,it contain panel of.
 * search panel of a archive and path.
 */

public class FrameMain  extends JFrame {
    /**
     * instance the object panelSearch, panelMultimedia, title and tab.
     */

    PanelSearch panelSearch;
    JLabel title;
    Tab tab;

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

        tab = new Tab();
        tab.iniComponentsTab();
        title = new JLabel("AT07-team-A");
        title.setBounds(300, 10, 300, 30);
        add(tab);
        add(title);
    }

    public PanelSearch getPanelSearch() {
        return tab.getPanelSearch();
    }
}
