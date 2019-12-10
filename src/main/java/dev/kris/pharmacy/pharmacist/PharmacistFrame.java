package dev.kris.pharmacy.pharmacist;

import javax.swing.*;

public class PharmacistFrame extends JFrame {

    public PharmacistFrame(){
        setSize(1000,1000);
        setResizable(false);
        setTitle("Pharmacy");
        setLocationRelativeTo(null);

        PharmacistPanel pharmacistPanel = new PharmacistPanel();
        add(pharmacistPanel);
    }
}
