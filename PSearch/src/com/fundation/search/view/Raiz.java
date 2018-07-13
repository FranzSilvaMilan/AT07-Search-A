package com.fundation.search.view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class Raiz extends JFrame {


    PanelSearch panelSearch;

    PanelMultimedia panelMultimedia;

    JLabel titulo;

    //PESTAÑAS.....
    JTabbedPane flange;

    public Raiz() {
        setLayout(null);
        setTitle("SEARCH");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        inicialComponentes();
        setVisible(true);
    }
    private void inicialComponentes() {
        panelSearch=new PanelSearch();
        panelMultimedia=new PanelMultimedia();

        flange=new JTabbedPane();
        flange.setBounds(30, 50, 700, 200);
        titulo=new JLabel("ARCHIVE");
        titulo.setBounds(10,10,180,30);


        flange.add("FILE", panelSearch);
        flange.addTab("MULTIMEDIA", panelMultimedia);

        add(flange);
        add(titulo);
        // TODO Auto-generated method stub

        // TODO Auto-generated method stub

    }

}

