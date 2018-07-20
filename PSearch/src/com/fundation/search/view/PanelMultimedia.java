package com.fundation.search.view;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * this is class of the tab of contain the search of multimedia.
 */
public class PanelMultimedia extends JPanel {
    /**
     * this is a constructor for tha class {@link PanelMultimedia}.
     */

    public PanelMultimedia() {
        setLayout(null);
        setVisible(true);
        contains();
    }

    /**
     * method of contains, it will contain all of multimedia.
     */
    private void contains() {
        JLabel et_p2 = new JLabel("this is on the panel two");
        add(et_p2);
    }

}
