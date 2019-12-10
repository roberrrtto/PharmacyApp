package pharmacy.pharmacist;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PharmacistPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, medicineLabel;
    private JButton logOutButton, submitButton, nextSaleButton;
    private JTextField medicineList, summaryList;
    private JList list;
    private JScrollPane listScroller;
    static List<String> klientList = new ArrayList<>();

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

        list = new JList<>(klientList.toArray(new String[klientList.size()]));
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(7);
        listScroller = new JScrollPane();
        listScroller.setViewportView(list);
        listScroller.setBounds(100, 160, 500, 180);

//        medicineList = new JTextField();
//        medicineList.setBounds(100, 160, 500, 180);
//        medicineList.setFont(medicineList.getFont().deriveFont(15f));

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
