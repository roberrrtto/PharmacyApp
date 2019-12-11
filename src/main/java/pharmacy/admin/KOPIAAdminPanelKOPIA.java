package pharmacy.admin;

import pharmacy.GetCurrentDate;

import javax.swing.*;

import static pharmacy.Main.adminFrame;
import static pharmacy.Main.logFrame;

public class KOPIAAdminPanelKOPIA extends JPanel {

    private JLabel loggedNameLabel, dateLabel, allEmployeesLabel, allMedicinesLabel, allSalesOfTheDayLabel, medicineEditLabel, employeeEditLabel;
    private JButton logOutButton, deleteEmpButton, addEmpButton, deleteMedButton, addMedButton, searchDateButton;
    private JTextField employeeList, medicineList, dateTextField, saleTextField, medicineEditTextField, employeeEditTextField;

    private GetCurrentDate getCurrentDate = new GetCurrentDate();

    public KOPIAAdminPanelKOPIA(AdminOperations adminOperations) {
        setLayout(null);

        loggedNameLabel = new JLabel(adminOperations.getUserInitData().getFirstName(), SwingConstants.CENTER);
        loggedNameLabel.setBounds(580, 15, 80, 50);
        loggedNameLabel.setFont(loggedNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(getCurrentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100, 30);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        logOutButton = new JButton("Log out");
        logOutButton.setBounds(555, 45, 80, 30);
        logOutButton.setFont(logOutButton.getFont().deriveFont(12f));
        logOutButton.addActionListener(e -> {
            logFrame.setVisible(true);
            adminFrame.setVisible(false);
        });

        allEmployeesLabel = new JLabel("All employees: ");
        allEmployeesLabel.setBounds(100, 70, 500, 50);
        allEmployeesLabel.setFont(allEmployeesLabel.getFont().deriveFont(15f));

        employeeList = new JTextField();
        employeeList.setBounds(100, 110, 500, 100);
        employeeList.setFont(employeeList.getFont().deriveFont(15f));


        employeeEditLabel = new JLabel("Employee name: ");
        employeeEditLabel.setBounds(100, 215, 150, 40);
        employeeEditLabel.setFont(employeeEditLabel.getFont().deriveFont(15f));

        employeeEditTextField = new JTextField();
        employeeEditTextField.setBounds(250, 215, 150, 40);
        employeeEditTextField.setFont(employeeEditTextField.getFont().deriveFont(15f));

        addEmpButton = new JButton("ADD");
        addEmpButton.setBounds(410, 215, 90, 40);
        addEmpButton.setFont(addEmpButton.getFont().deriveFont(13f));

        deleteEmpButton = new JButton("DELETE");
        deleteEmpButton.setBounds(510, 215, 90, 40);
        deleteEmpButton.setFont(dateLabel.getFont().deriveFont(13f));

        allMedicinesLabel = new JLabel("Medicines: ");
        allMedicinesLabel.setBounds(100, 275, 500, 50);
        allMedicinesLabel.setFont(allMedicinesLabel.getFont().deriveFont(15f));

        medicineList = new JTextField();
        medicineList.setBounds(100, 315, 500, 100);
        medicineList.setFont(medicineList.getFont().deriveFont(15f));

        medicineEditLabel = new JLabel("Medicine name: ");
        medicineEditLabel.setBounds(100, 430, 150, 40);
        medicineEditLabel.setFont(medicineEditLabel.getFont().deriveFont(15f));

        medicineEditTextField = new JTextField();
        medicineEditTextField.setBounds(250, 430, 150, 40);
        medicineEditTextField.setFont(medicineEditTextField.getFont().deriveFont(15f));

        addMedButton = new JButton("ADD");
        addMedButton.setBounds(410, 430, 90, 40);
        addMedButton.setFont(addMedButton.getFont().deriveFont(13f));

        deleteMedButton = new JButton("DELETE");
        deleteMedButton.setBounds(510, 430, 90, 40);
        deleteMedButton.setFont(deleteMedButton.getFont().deriveFont(13f));

        allSalesOfTheDayLabel = new JLabel("All sales of day: ");
        allSalesOfTheDayLabel.setBounds(100, 490, 150, 40);
        allSalesOfTheDayLabel.setFont(allSalesOfTheDayLabel.getFont().deriveFont(15f));

        dateTextField = new JTextField();
        dateTextField.setBounds(250, 490, 150, 40);
        dateTextField.setFont(dateTextField.getFont().deriveFont(15f));

        saleTextField = new JTextField();
        saleTextField.setBounds(100, 550, 500, 60);
        saleTextField.setFont(saleTextField.getFont().deriveFont(15f));

        searchDateButton = new JButton("SEARCH");
        searchDateButton.setBounds(410, 490, 90, 40);
        searchDateButton.setFont(searchDateButton.getFont().deriveFont(13f));

        add(loggedNameLabel);
        add(dateLabel);
        add(allEmployeesLabel);
        add(allMedicinesLabel);
        add(allSalesOfTheDayLabel);
        add(logOutButton);
        add(deleteEmpButton);
        add(addEmpButton);
        add(employeeList);
        add(medicineList);
        add(dateTextField);
        add(saleTextField);
        add(medicineEditLabel);
        add(medicineEditTextField);
        add(searchDateButton);
        add(addMedButton);
        add(deleteMedButton);
        add(employeeEditLabel);
        add(employeeEditTextField);
    }
}