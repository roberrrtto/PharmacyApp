package dev.kris.pharmacy.manager;

import javax.swing.*;

import static dev.kris.pharmacy.Main.*;

public class ManagerPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, employeeLabel, availableMedicineLabel, saleLabel, medicineEditLabel;
    private JButton logOutButton, deleteButton, addButton;
    private JTextField medicineList, dateTextField, saleTextField, medicineEditTextField;
    private JList<String> employeeList;
    private ManagerOperations managerOperations;

    public ManagerPanel(ManagerOperations managerOperations){
        this.managerOperations = managerOperations;

        setLayout(null);

        loggedNameLabel = new JLabel(managerOperations.getUserInitData().getFirstName());
//        loggedNameLabel = new JLabel(pharmacyApp.userInitData.getFirstName());
        loggedNameLabel.setBounds(750, 25, 150, 50);
        loggedNameLabel.setFont(loggedNameLabel.getFont().deriveFont(15f));

        logOutButton = new JButton("Log out");
        logOutButton.setBounds(750, 75, 100, 30);
        logOutButton.setFont(logOutButton.getFont().deriveFont(15f));
        logOutButton.addActionListener(e -> {
            logFrame.setVisible(true);
            managerFrame.setVisible(false);
        });

        dateLabel = new JLabel("Data");
        dateLabel.setBounds(100, 25, 50,50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(20f));

        employeeLabel = new JLabel("Employees: ");
        employeeLabel.setBounds(200, 100, 600, 50);
        employeeLabel.setFont(employeeLabel.getFont().deriveFont(20f));

        employeeList = new JList();
        employeeList.setBounds(200, 175, 600, 200);
        employeeList.setFont(employeeList.getFont().deriveFont(15f));

        availableMedicineLabel = new JLabel("Available medicines: ");
        availableMedicineLabel.setBounds(200, 400, 600, 50);
        availableMedicineLabel.setFont(availableMedicineLabel.getFont().deriveFont(20f));

        medicineList = new JTextField();
        medicineList.setBounds(200, 475, 600, 200);
        medicineList.setFont(medicineList.getFont().deriveFont(15f));

        medicineEditLabel = new JLabel("Medicine name: ");
        medicineEditLabel.setBounds(200, 700, 150, 50 );
        medicineEditLabel.setFont(medicineEditLabel.getFont().deriveFont(15f));

        medicineEditTextField = new JTextField();
        medicineEditTextField.setBounds(350, 700, 200, 50);
        medicineEditTextField.setFont(medicineEditTextField.getFont().deriveFont(15f));

        addButton = new JButton("ADD");
        addButton.setBounds(590, 700, 90, 50);
        addButton.setFont(addButton.getFont().deriveFont(15f));

        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(700, 700, 100, 50);
        deleteButton.setFont(dateLabel.getFont().deriveFont(15f));

        saleLabel = new JLabel("Sale of day: ");
        saleLabel.setBounds(200, 775, 200, 50);
        saleLabel.setFont(saleLabel.getFont().deriveFont(15f));

        dateTextField = new JTextField();
        dateTextField.setBounds(350, 775, 350, 50);
        dateTextField.setFont(dateTextField.getFont().deriveFont(15f));

        saleTextField = new JTextField();
        saleTextField.setBounds(200, 850, 600, 125);
        saleTextField.setFont(saleTextField.getFont().deriveFont(15f));

        add(loggedNameLabel);
        add(dateLabel);
        add(employeeLabel);
        add(availableMedicineLabel);
        add(saleLabel);
        add(logOutButton);
        add(deleteButton);
        add(addButton);
        add(employeeList);
        add(medicineList);
        add(dateTextField);
        add(saleTextField);
        add(medicineEditLabel);
        add(medicineEditTextField);

    }
}
