package dev.kris.pharmacy.manager;

import javax.swing.*;

public class ManagerFrame extends JFrame {

    public ManagerFrame(){

        setSize(1000,1100);
        setResizable(false);
        setTitle("Pharmacy");
        setLocationRelativeTo(null);

        ManagerPanel managerPanel = new ManagerPanel();
        add(managerPanel);
    }
}

