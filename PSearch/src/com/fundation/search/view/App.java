package com.fundation.search.view;

/**
 * This class main of the interface.
 *q
 * @author Ketty Camacho Vasquez.
 */
public class App {
    public static void main(String[] arg) {
        FrameMain seaMain=new FrameMain();
        String[]  strings = new String[]{"aaa","123","11111","asdww"};
        try{seaMain.getPanelSearch().insertRow(strings);}catch (NullPointerException e){}
    }
}