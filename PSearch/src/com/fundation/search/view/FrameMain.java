package com.fundation.search.view;


import javax.swing.JFrame;
import javax.swing.JLabel;
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
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setLayout(null);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        setVisible(true);
    }

    public void iniComponent() {

        tab = new Tab();
        tab.iniComponentsTab();
        add(tab);
    }

    public PanelSearch getPanelSearch() {
        return tab.getPanelSearch();
    }
}
