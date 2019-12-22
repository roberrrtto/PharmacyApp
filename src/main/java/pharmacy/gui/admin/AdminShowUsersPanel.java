package pharmacy.gui.admin;

import pharmacy.utils.GetCurrentDate;
import pharmacy.service.AdminOperations;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static pharmacy.Main.mainFrame;

public class AdminShowUsersPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, allEmployeesLabel;
    private JButton logOutButton, deleteEmpButton, addEmpButton, editEmpButton, readEmpButton;
    private JList<String> employeeList;
    private JScrollPane employeeListScroller;
    private AdminAddUserPanel adminAddUserPanel;
    private AdminReadUserPanel adminReadUserPanel;
    private AdminUpdateUserPanel adminUpdateUserPanel;
    private GetCurrentDate getCurrentDate = new GetCurrentDate();
    private BufferedImage img;

    public AdminShowUsersPanel(AdminOperations adminOperations) {
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

        allEmployeesLabel = new JLabel("USERS: ", SwingConstants.CENTER);
        allEmployeesLabel.setBounds(100, 50, 500, 50);
        allEmployeesLabel.setFont(allEmployeesLabel.getFont().deriveFont(15f));

        employeeList = new JList(adminOperations.getEmployeeList());
        employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeList.setFont(employeeList.getFont().deriveFont(15f));

        employeeListScroller = new JScrollPane();
        employeeListScroller.setViewportView(employeeList);
        employeeListScroller.setBounds(225, 100, 250, 250);

        addEmpButton = new JButton("ADD");
        addEmpButton.setBounds(155, 370, 90, 40);
        addEmpButton.setFont(addEmpButton.getFont().deriveFont(13f));
        addEmpButton.addActionListener(e -> {
            adminAddUserPanel = new AdminAddUserPanel(adminOperations);
            mainFrame.panelSwitchOver(adminAddUserPanel);
        });

        readEmpButton = new JButton("DETAILS");
        readEmpButton.setBounds(255, 370, 90, 40);
        readEmpButton.setFont(dateLabel.getFont().deriveFont(13f));
        readEmpButton.addActionListener(e -> {
            adminOperations.setUpdateUser(employeeList.getSelectedIndex());
            adminReadUserPanel = new AdminReadUserPanel(adminOperations);
            mainFrame.panelSwitchOver(adminReadUserPanel);
        });

        editEmpButton = new JButton("EDIT");
        editEmpButton.setBounds(355, 370, 90, 40);
        editEmpButton.setFont(dateLabel.getFont().deriveFont(13f));
        editEmpButton.addActionListener(e -> {
            adminOperations.setUpdateUser(employeeList.getSelectedIndex());
            adminUpdateUserPanel = new AdminUpdateUserPanel(adminOperations);
            mainFrame.panelSwitchOver(adminUpdateUserPanel);
        });

        deleteEmpButton = new JButton("DELETE");
        deleteEmpButton.setBounds(455, 370, 90, 40);
        deleteEmpButton.setFont(dateLabel.getFont().deriveFont(13f));
        deleteEmpButton.addActionListener(e -> {
            adminOperations.removeUser(employeeList.getSelectedIndex());
            employeeList = new JList(adminOperations.getEmployeeList());
            employeeList.setFont(employeeList.getFont().deriveFont(15f));
            employeeListScroller.setViewportView(employeeList);
        });

        add(loggedNameLabel);
        add(dateLabel);
        add(allEmployeesLabel);
        add(logOutButton);
        add(deleteEmpButton);
        add(editEmpButton);
        add(addEmpButton);
        add(readEmpButton);
        add(employeeListScroller);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }
}