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

public class FrameMain extends JFrame {
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
        setLayout(null);
        setTitle("SEARCH");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        initialComponent();
        this.getContentPane().setBackground(Color.lightGray);
        setVisible(true);
    }

    /**
     * this is  initialComponent method of contain {@link JTabbedPane} {@link PanelSearch}
     * {@link JLabel} and size location.
     */

    private void initialComponent() {
        panelSearch = new PanelSearch();
        panelMultimedia = new PanelMultimedia();

        Tab = new JTabbedPane();
        Tab.setBounds(15, 35, 650, 540);

        title = new JLabel("AT07-team-A");
        title.setBounds(300, 10, 300, 30);


        Tab.add("FILE", panelSearch);
        Tab.addTab("MULTIMEDIA", panelMultimedia);

        add(Tab);
        add(title);


    }

}

