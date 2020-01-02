package pharmacy.gui.admin;

import pharmacy.service.UserProfileService;
import pharmacy.service.UserService;
import pharmacy.service.UserServiceImpl;
import pharmacy.utils.CurrentDate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static pharmacy.Main.mainFrame;

public class AdminShowUsersPanel extends JPanel {

    private JLabel userNameLabel, dateLabel, allEmployeesLabel;
    private JButton logOutButton, deleteEmpButton, addEmpButton, editEmpButton, readEmpButton, backToMenu;
    private JList<String> employeeList;
    private JScrollPane employeeListScroller;
    private AdminAddUserPanel adminAddUserPanel;
    private AdminReadUserPanel adminReadUserPanel;
    private AdminUpdateUserPanel adminUpdateUserPanel;
    private BufferedImage img;

    private CurrentDate currentDate = new CurrentDate();
    private UserService userService = new UserServiceImpl();

    public AdminShowUsersPanel() {
        setLayout(null);
        try {
            img = ImageIO.read(getClass().getResource("/background.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        userNameLabel = new JLabel(UserProfileService.getFirstName(), SwingConstants.CENTER);
        userNameLabel.setBounds(555, 15, 80, 50);
        userNameLabel.setFont(userNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(currentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100, 50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        logOutButton = new JButton("LOG OUT");
        logOutButton.setBounds(555, 55, 80, 30);
        logOutButton.setFont(logOutButton.getFont().deriveFont(12f));
        logOutButton.addActionListener(e -> {
            mainFrame.logout();
        });

        backToMenu = new JButton("MENU");
        backToMenu.setBounds(555, 85, 80, 30);
        backToMenu.setFont(backToMenu.getFont().deriveFont(12f));
        backToMenu.addActionListener(e -> {
            mainFrame.panelSwitchOver(new AdminMenuPanel());
        });

        allEmployeesLabel = new JLabel("USERS: ", SwingConstants.CENTER);
        allEmployeesLabel.setBounds(100, 50, 500, 50);
        allEmployeesLabel.setFont(allEmployeesLabel.getFont().deriveFont(15f));

        employeeList = new JList(userService.getAllEmployeeList());
        employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeList.setFont(employeeList.getFont().deriveFont(15f));

        employeeListScroller = new JScrollPane();
        employeeListScroller.setViewportView(employeeList);
        employeeListScroller.setBounds(225, 100, 250, 250);

        addEmpButton = new JButton("ADD");
        addEmpButton.setBounds(155, 370, 90, 40);
        addEmpButton.setFont(addEmpButton.getFont().deriveFont(13f));
        addEmpButton.addActionListener(e -> {
            adminAddUserPanel = new AdminAddUserPanel(userService);
            mainFrame.panelSwitchOver(adminAddUserPanel);
        });

        readEmpButton = new JButton("DETAILS");
        readEmpButton.setBounds(255, 370, 90, 40);
        readEmpButton.setFont(dateLabel.getFont().deriveFont(13f));
        readEmpButton.addActionListener(e -> {
            if (employeeList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null,"Nothing is selected!","Information", 1);
            } else {
                userService.setUserData(employeeList.getSelectedIndex());
                adminReadUserPanel = new AdminReadUserPanel(userService);
                mainFrame.panelSwitchOver(adminReadUserPanel);
            }
        });

        editEmpButton = new JButton("EDIT");
        editEmpButton.setBounds(355, 370, 90, 40);
        editEmpButton.setFont(dateLabel.getFont().deriveFont(13f));
        editEmpButton.addActionListener(e -> {
            if (employeeList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null,"Nothing is selected!","Information", 1);
            } else {
                userService.setUserData(employeeList.getSelectedIndex());
                adminUpdateUserPanel = new AdminUpdateUserPanel(userService);
                mainFrame.panelSwitchOver(adminUpdateUserPanel);
            }
        });

        deleteEmpButton = new JButton("DELETE");
        deleteEmpButton.setBounds(455, 370, 90, 40);
        deleteEmpButton.setFont(dateLabel.getFont().deriveFont(13f));
        deleteEmpButton.addActionListener(e -> {
            if (employeeList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null,"Nothing is selected!","Information", 1);
            } else {
                userService.removeUser(employeeList.getSelectedIndex());
                employeeList = new JList(userService.getAllEmployeeList());
                employeeList.setFont(employeeList.getFont().deriveFont(15f));
                employeeListScroller.setViewportView(employeeList);
            }
        });

        add(userNameLabel);
        add(dateLabel);
        add(allEmployeesLabel);
        add(logOutButton);
        add(backToMenu);
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