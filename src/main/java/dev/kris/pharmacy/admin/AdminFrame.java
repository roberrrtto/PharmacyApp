package dev.kris.pharmacy.admin;

import javax.swing.*;

public class AdminFrame extends JFrame {

    public AdminFrame(){
        setSize(1000,1000);
        setResizable(false);
        setTitle("Pharmacy");
        setLocationRelativeTo(null);

        AdminPanel adminPanel = new AdminPanel();

        add(adminPanel);
    }
}
