package pharmacy.pharmacist;

import javax.swing.*;

public class PharmacistPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, medicineLabel;
    private JButton logOutButton, submitButton, nextSaleButton;
    private JTextField medicineList, summaryList;

    public PharmacistPanel(){
        setLayout(null);

        loggedNameLabel = new JLabel("Imię");
        loggedNameLabel.setBounds(580, 15, 70, 50);
        loggedNameLabel.setFont(loggedNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel("Data");
        dateLabel.setBounds(50, 15, 50,50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        logOutButton = new JButton("Log out");
        logOutButton.setBounds(555, 65, 80, 30);
        logOutButton.setFont(logOutButton.getFont().deriveFont(12f));

        medicineLabel = new JLabel("Medicines: " );
        medicineLabel.setBounds(100, 115, 500, 50 );
        medicineLabel.setFont(medicineLabel.getFont().deriveFont(15f));

        medicineList = new JTextField();
        medicineList.setBounds(100, 160, 500, 180);
        medicineList.setFont(medicineList.getFont().deriveFont(15f));

        submitButton = new JButton("Submit");
        submitButton.setBounds(300, 360, 100, 40);
        submitButton.setFont(submitButton.getFont().deriveFont(15f));

        summaryList = new JTextField();
        summaryList.setBounds(100, 420, 500, 140);
        summaryList.setFont(summaryList.getFont().deriveFont(15f));

        nextSaleButton = new JButton("Next");
        nextSaleButton.setBounds(555, 615, 80, 30);
        nextSaleButton.setFont(nextSaleButton.getFont().deriveFont(12f));

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
