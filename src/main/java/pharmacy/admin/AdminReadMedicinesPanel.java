package pharmacy.admin;

import pharmacy.GetCurrentDate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static pharmacy.Main.mainFrame;

public class AdminReadMedicinesPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, allEmployeesLabel, allMedicinesLabel;
    private JButton logOutButton, deleteEmpButton, addEmpButton, editEmpButton, deleteMedButton, addMedButton, editMedButton;
    private JList<String> employeeList, medicineList;
    private JScrollPane employeeListScroller, medicineListScroller;
    private AdminAddUserPanel adminAddUserPanel;
    private AdminUpdateUserPanel adminUpdateUserPanel;

    private GetCurrentDate getCurrentDate = new GetCurrentDate();

    private BufferedImage img;

    public AdminReadMedicinesPanel(AdminOperations adminOperations) {
        setLayout(null);
        try {
            img = ImageIO.read(getClass().getResource("/background.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

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
            mainFrame.logout();
        });

        allEmployeesLabel = new JLabel("All employees: ");
        allEmployeesLabel.setBounds(100, 50, 500, 50);
        allEmployeesLabel.setFont(allEmployeesLabel.getFont().deriveFont(15f));

        employeeList = new JList(adminOperations.getEmployeePanel());
        employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeList.setFont(employeeList.getFont().deriveFont(15f));

        employeeListScroller = new JScrollPane();
        employeeListScroller.setViewportView(employeeList);
        employeeListScroller.setBounds(225, 85, 250, 145);

        addEmpButton = new JButton("ADD");
        addEmpButton.setBounds(200, 240, 90, 40);
        addEmpButton.setFont(addEmpButton.getFont().deriveFont(13f));
        addEmpButton.addActionListener(e -> {
            adminAddUserPanel = new AdminAddUserPanel(adminOperations);
            mainFrame.panelSwitchOver(adminAddUserPanel);
        });

        deleteEmpButton = new JButton("DELETE");
        deleteEmpButton.setBounds(410, 240, 90, 40);
        deleteEmpButton.setFont(dateLabel.getFont().deriveFont(13f));
        deleteEmpButton.addActionListener(e -> {
            adminOperations.removeUser(employeeList.getSelectedIndex());
            employeeList = new JList(adminOperations.getEmployeePanel());
            employeeList.setFont(employeeList.getFont().deriveFont(15f));
            employeeListScroller.setViewportView(employeeList);
        });

        editEmpButton = new JButton("EDIT");
        editEmpButton.setBounds(305, 240, 90, 40);
        editEmpButton.setFont(dateLabel.getFont().deriveFont(13f));
        editEmpButton.addActionListener(e -> {
            adminOperations.setUpdateUser(employeeList.getSelectedIndex());
            adminUpdateUserPanel = new AdminUpdateUserPanel(adminOperations);
            mainFrame.panelSwitchOver(adminUpdateUserPanel);
        });

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
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }
}