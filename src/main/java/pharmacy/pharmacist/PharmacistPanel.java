package pharmacy.pharmacist;

import pharmacy.GetCurrentDate;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static pharmacy.Main.*;

public class PharmacistPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, medicineLabel;
    private JButton logOutButton, submitButton, nextSaleButton;
    private JTextField summaryList;
    private JList medicineList;
    private JScrollPane listScroller;
    static List<String> klientList = new ArrayList<>();
    private GetCurrentDate getCurrentDate = new GetCurrentDate();

    private PharmacistOperations pharmacistOperations;

    public PharmacistPanel(PharmacistOperations pharmacistOperations){
        this.pharmacistOperations = pharmacistOperations;

        setLayout(null);

        loggedNameLabel = new JLabel(pharmacistOperations.getUserInitData().getFirstName(), SwingConstants.CENTER);
        loggedNameLabel.setBounds(580, 15, 70, 50);
        loggedNameLabel.setFont(loggedNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(getCurrentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100,50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        logOutButton = new JButton("Log out");
        logOutButton.setBounds(555, 65, 80, 30);
        logOutButton.setFont(logOutButton.getFont().deriveFont(12f));
        logOutButton.addActionListener(e -> {
            logFrame.setVisible(true);
            pharmacistFrame.setVisible(false);
        });

        medicineLabel = new JLabel("Medicines: " );
        medicineLabel.setBounds(100, 115, 500, 50 );
        medicineLabel.setFont(medicineLabel.getFont().deriveFont(15f));

        medicineList = new JList(pharmacistOperations.getStorageDetails());
        medicineList.setBounds(100, 160, 500, 180);
        medicineList.setFont(medicineList.getFont().deriveFont(15f));

        listScroller = new JScrollPane();
        listScroller.setViewportView(medicineList);
        listScroller.setBounds(100, 160, 500, 180);

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
        add(listScroller);
//        add(medicineList);
        add(nextSaleButton);
        add(submitButton);
        add(summaryList);
    }
}
