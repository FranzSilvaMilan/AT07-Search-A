package com.fundation.search.view;
import javax.swing.JTextField;
import javax.swing.JLabel;
import  javax.swing.JPanel;
import javax.swing.JButton;

public class PanelSearch extends JPanel{

    JTextField textFile;
    JLabel  labelFile;
    JTextField textPhat;
    JLabel labelPhat;
    JButton bottoSearsh;
    public PanelSearch() {
        setLayout(null);

        contain();
        setVisible(true);
    }
    public void contain() {
        textFile=new JTextField();
        textFile.setText("FILE-NAME");
        textFile.setBounds(200, 200, 100, 30);
        add(textFile);

        labelFile=new JLabel();
        labelFile.setBounds(200, 400, 100, 30);

        textPhat=new JTextField();
        textPhat.setText("PATH");
        textPhat.setBounds(400, 200, 100, 30);
        add(textPhat);

        labelPhat=new JLabel();
        labelPhat.setBounds(400, 200, 100, 30);

        bottoSearsh=new JButton();
        bottoSearsh.setText("SEARCH");
        bottoSearsh.setBounds(400, 300, 70, 30);

        add(textFile);
        add(textPhat);
        add(labelFile);
        add(labelPhat);
        add(bottoSearsh);



    }

}
