package pharmacy.admin;

import pharmacy.GetCurrentDate;

import javax.swing.*;

import static pharmacy.Main.logFrame;
import static pharmacy.Main.userAddFrame;
import static pharmacy.admin.AdminMenuPanel.adminFrame;

public class AdminPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, allEmployeesLabel, allMedicinesLabel;
    private JButton logOutButton, deleteEmpButton, addEmpButton, editEmpButton, deleteMedButton, addMedButton, editMedButton;
    private JList<String> employeeList, medicineList;
    private UserAddPanel userAddPanel;
    private JScrollPane employeeListScroller, medicineListScroller;

    private GetCurrentDate getCurrentDate = new GetCurrentDate();

    public AdminPanel(AdminOperations adminOperations) {
        setLayout(null);

        loggedNameLabel = new JLabel(adminOperations.getUserInitData().getFirstName(), SwingConstants.CENTER);
        loggedNameLabel.setBounds(555, 15, 80, 50);
        loggedNameLabel.setFont(loggedNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(getCurrentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100, 50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        logOutButton = new JButton("Log out");
        logOutButton.setBounds(555, 55, 80, 30);
        logOutButton.setFont(logOutButton.getFont().deriveFont(12f));
        logOutButton.addActionListener(e -> {
            logFrame.setVisible(true);
            adminFrame.setVisible(false);
        });

        allEmployeesLabel = new JLabel("All employees: ");
        allEmployeesLabel.setBounds(100, 50, 500, 50);
        allEmployeesLabel.setFont(allEmployeesLabel.getFont().deriveFont(15f));

        employeeList = new JList(adminOperations.getNames());
        employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeList.setFont(employeeList.getFont().deriveFont(15f));

        employeeListScroller = new JScrollPane();
        employeeListScroller.setViewportView(employeeList);
        employeeListScroller.setBounds(225, 85, 250, 145);

        addEmpButton = new JButton("ADD");
        addEmpButton.setBounds(200, 240, 90, 40);
        addEmpButton.setFont(addEmpButton.getFont().deriveFont(13f));
        addEmpButton.addActionListener(e -> {
            userAddPanel = new UserAddPanel(adminOperations);
            userAddFrame.add(userAddPanel);
            userAddFrame.setVisible(true);
            adminFrame.setVisible(false);
        });

        deleteEmpButton = new JButton("DELETE");
        deleteEmpButton.setBounds(410, 240, 90, 40);
        deleteEmpButton.setFont(dateLabel.getFont().deriveFont(13f));

        editEmpButton = new JButton("EDIT");
        editEmpButton.setBounds(305, 240, 90, 40);
        editEmpButton.setFont(dateLabel.getFont().deriveFont(13f));

        allMedicinesLabel = new JLabel("Medicines: ");
        allMedicinesLabel.setBounds(100, 275, 500, 50);
        allMedicinesLabel.setFont(allMedicinesLabel.getFont().deriveFont(15f));

//        medicineList = new JList();
//        medicineList.setBounds(100, 315, 500, 200);
//        medicineList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        medicineList.setFont(medicineList.getFont().deriveFont(15f));

        addMedButton = new JButton("ADD");
        addMedButton.setBounds(200, 550, 90, 40);
        addMedButton.setFont(addMedButton.getFont().deriveFont(13f));

        deleteMedButton = new JButton("DELETE");
        deleteMedButton.setBounds(410, 550, 90, 40);
        deleteMedButton.setFont(deleteMedButton.getFont().deriveFont(13f));
        deleteEmpButton.addActionListener(e -> {
            adminOperations.removeUser(employeeList.getSelectedIndex());
            employeeList = new JList(adminOperations.getNames());
            employeeList.setFont(employeeList.getFont().deriveFont(15f));
            employeeListScroller.setViewportView(employeeList);
        });

        editMedButton = new JButton("EDIT");
        editMedButton.setBounds(305, 550, 90, 40);
        editMedButton.setFont(editMedButton.getFont().deriveFont(13f));

        add(loggedNameLabel);
        add(dateLabel);
        add(allEmployeesLabel);
        add(allMedicinesLabel);
        add(logOutButton);
        add(deleteEmpButton);
        add(editEmpButton);
        add(addEmpButton);
        add(employeeListScroller);
//        add(medicineList);
        add(editMedButton);
        add(addMedButton);
        add(deleteMedButton);
    }
}