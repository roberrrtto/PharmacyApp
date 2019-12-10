package dev.kris.pharmacy.pharmacist;

import javax.swing.*;

public class PharmacistPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, medicineLabel;
    private JButton logOutButton, submitButton, nextSaleButton;
    private JTextField medicineList, summaryList;

    public PharmacistPanel(){
        setLayout(null);

        loggedNameLabel = new JLabel("Imię zalogowanego");
        loggedNameLabel.setBounds(750, 25, 150, 50);
        loggedNameLabel.setFont(loggedNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel("Data");
        dateLabel.setBounds(100, 25, 50,50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(20f));

        medicineLabel = new JLabel("Medicines: " );
        medicineLabel.setBounds(200, 175, 500, 50 );
        medicineLabel.setFont(medicineLabel.getFont().deriveFont(20f));

        logOutButton = new JButton("Log out");
        logOutButton.setBounds(750, 75, 100, 30);
        logOutButton.setFont(logOutButton.getFont().deriveFont(15f));

        medicineList = new JTextField();
        medicineList.setBounds(200, 250, 600, 300);
        medicineList.setFont(medicineList.getFont().deriveFont(15f));

        submitButton = new JButton("Submit");
        submitButton.setBounds(400, 575, 200, 50);
        submitButton.setFont(submitButton.getFont().deriveFont(15f));

        summaryList = new JTextField();
        summaryList.setBounds(200, 650, 600, 200);
        summaryList.setFont(summaryList.getFont().deriveFont(15f));

        nextSaleButton = new JButton("Next");
        nextSaleButton.setBounds(800, 900, 100, 50);
        nextSaleButton.setFont(nextSaleButton.getFont().deriveFont(15f));

        add(loggedNameLabel);
        add(dateLabel);
        add(logOutButton);
        add(medicineLabel);
        add(medicineList);
        add(nextSaleButton);
        add(submitButton);
        add(summaryList);
    }
}
