package pharmacy.manager;

import pharmacy.GetCurrentDate;
import pharmacy.Main;

import javax.swing.*;

import static pharmacy.Main.managerFrame;
import static pharmacy.Main.pharmacistFrame;

public class ManagerPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, employeeLabel, availableMedicineLabel, saleLabel, medicineEditLabel;
    private JButton logOutButton, switchToSaleButton, addButton, searchButton, userDetailsButton;
    private JTextField dateTextField, saleTextField, medicineEditTextField;
    private JList<String> employeeList, medicineList;
    private JScrollPane listScroller;
    private GetCurrentDate getCurrentDate = new GetCurrentDate();

    private ManagerOperations managerOperations;

    public ManagerPanel(ManagerOperations managerOperations){
        this.managerOperations = managerOperations;

        setLayout(null);

        loggedNameLabel = new JLabel(managerOperations.getUserInitData().getFirstName(), SwingConstants.CENTER);
        loggedNameLabel.setBounds(555, 15, 80, 50);
        loggedNameLabel.setFont(loggedNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(getCurrentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100,50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        logOutButton = new JButton("Log out");
        logOutButton.setBounds(555, 55, 80, 30);
        logOutButton.setFont(logOutButton.getFont().deriveFont(12f));
        logOutButton.addActionListener(e -> {
            Main.logFrame.setVisible(true);
            managerFrame.setVisible(false);
        });

        switchToSaleButton = new JButton("Sale");
        switchToSaleButton.setBounds(555, 95, 80, 30);
        switchToSaleButton.setFont(dateLabel.getFont().deriveFont(13f));
        switchToSaleButton.addActionListener(e -> {
            pharmacistFrame.setVisible(true);
        });

        employeeLabel = new JLabel("Employees", SwingConstants.CENTER);
        employeeLabel.setBounds(100, 115, 500, 50 );
        employeeLabel.setFont(employeeLabel.getFont().deriveFont(15f));

        employeeList = new JList(managerOperations.getNames());
        employeeList.setBounds(170, 160, 360, 80);
        employeeList.setFont(employeeList.getFont().deriveFont(15f));

        userDetailsButton = new JButton("Details");
        userDetailsButton.setBounds(555, 175, 80, 50 );
        userDetailsButton.setFont(userDetailsButton.getFont().deriveFont(15f));

        availableMedicineLabel = new JLabel("Available medicines: ", SwingConstants.CENTER);
        availableMedicineLabel.setBounds(100, 270, 500, 50);
        availableMedicineLabel.setFont(availableMedicineLabel.getFont().deriveFont(15f));

        medicineList = new JList(managerOperations.getStorageDetails());
        medicineList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        medicineList.setFont(medicineList.getFont().deriveFont(15f));

        listScroller = new JScrollPane();
        listScroller.setViewportView(medicineList);
        listScroller.setBounds(170, 315, 360, 100);

        medicineEditLabel = new JLabel("Update quantity: ");
        medicineEditLabel.setBounds(100, 430, 150, 40 );
        medicineEditLabel.setFont(medicineEditLabel.getFont().deriveFont(15f));

        medicineEditTextField = new JTextField();
        medicineEditTextField.setBounds(250, 430, 150, 40);
        medicineEditTextField.setFont(medicineEditTextField.getFont().deriveFont(15f));

        addButton = new JButton("ADD");
        addButton.setBounds(410, 430, 90, 40);
        addButton.setFont(addButton.getFont().deriveFont(13f));

        saleLabel = new JLabel("Sale of day: ");
        saleLabel.setBounds(100, 490, 150, 40);
        saleLabel.setFont(saleLabel.getFont().deriveFont(15f));

        dateTextField = new JTextField();
        dateTextField.setBounds(250, 490, 150, 40);
        dateTextField.setFont(dateTextField.getFont().deriveFont(15f));

        saleTextField = new JTextField();
        saleTextField.setBounds(100, 550, 500, 60);
        saleTextField.setFont(saleTextField.getFont().deriveFont(15f));

        searchButton = new JButton("SEARCH");
        searchButton.setBounds(410, 490, 90, 40);
        searchButton.setFont(searchButton.getFont().deriveFont(13f));

        add(loggedNameLabel);
        add(dateLabel);
        add(employeeLabel);
        add(availableMedicineLabel);
        add(saleLabel);
        add(logOutButton);
        add(switchToSaleButton);
        add(addButton);
        add(userDetailsButton);
        add(employeeList);
        add(listScroller);
        add(dateTextField);
        add(saleTextField);
        add(medicineEditLabel);
        add(medicineEditTextField);
        add(searchButton);

    }

    public String getLoggedNameLabel() {
        return loggedNameLabel.getText();
    }
}
