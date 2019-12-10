package pharmacy.manager;

import pharmacy.Main;

import javax.swing.*;

public class ManagerPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, employeeLabel, availableMedicineLabel, saleLabel, medicineEditLabel;
    private JButton logOutButton, deleteButton, addButton, searchButton;
    private JTextField employeeList, medicineList, dateTextField, saleTextField, medicineEditTextField;
    private ManagerOperations managerOperations;

    public ManagerPanel(ManagerOperations managerOperations){
        this.managerOperations = managerOperations;

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
        logOutButton.addActionListener(e -> {
            Main.logFrame.setVisible(true);
            Main.managerFrame.setVisible(false);
        });

        employeeLabel = new JLabel("Employees: ");
        employeeLabel.setBounds(100, 115, 500, 50 );
        employeeLabel.setFont(employeeLabel.getFont().deriveFont(15f));

        employeeList = new JTextField();
        employeeList.setBounds(100, 160, 500, 100);
        employeeList.setFont(employeeList.getFont().deriveFont(15f));

        availableMedicineLabel = new JLabel("Available medicines: ");
        availableMedicineLabel.setBounds(100, 270, 500, 50);
        availableMedicineLabel.setFont(availableMedicineLabel.getFont().deriveFont(15f));

        medicineList = new JTextField();
        medicineList.setBounds(100, 315, 500, 100);
        medicineList.setFont(medicineList.getFont().deriveFont(15f));

        medicineEditLabel = new JLabel("Medicine name: ");
        medicineEditLabel.setBounds(100, 430, 150, 40 );
        medicineEditLabel.setFont(medicineEditLabel.getFont().deriveFont(15f));

        medicineEditTextField = new JTextField();
        medicineEditTextField.setBounds(250, 430, 150, 40);
        medicineEditTextField.setFont(medicineEditTextField.getFont().deriveFont(15f));

        addButton = new JButton("ADD");
        addButton.setBounds(410, 430, 90, 40);
        addButton.setFont(addButton.getFont().deriveFont(13f));

        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(510, 430, 90, 40);
        deleteButton.setFont(dateLabel.getFont().deriveFont(13f));

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
        add(deleteButton);
        add(addButton);
        add(employeeList);
        add(medicineList);
        add(dateTextField);
        add(saleTextField);
        add(medicineEditLabel);
        add(medicineEditTextField);
        add(searchButton);

    }
}
