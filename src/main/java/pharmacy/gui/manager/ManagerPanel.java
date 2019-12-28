package pharmacy.gui.manager;

import pharmacy.service.*;
import pharmacy.utils.GetCurrentDate;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.NumberFormat;

import static pharmacy.Main.mainFrame;

public class ManagerPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, employeeLabel, availableMedicineLabel, saleLabel, medicineQtyUpdateLabel;
    private JButton logOutButton, switchToSaleButton, updateButton, getButton, userDetailsButton;
    private JTextField dateTextField, saleTextField;
    private JFormattedTextField medicineQtyUpdateField;
    private InternationalFormatter integerFormatter;
    private NumberFormat integerFormat;
    private JList<String> employeeList, medicineList;
    private JScrollPane storageScroller, teamScroller;
    private BufferedImage img;

    private ManagerReadUserPanel managerReadUserPanel;
    private GetCurrentDate getCurrentDate = new GetCurrentDate();
    private PharmacyStorageService pharmacyStorageService = new PharmacyStorageServiceImpl(UserProfileServiceImpl.getPharmacyId());
    private UserService userService = new UserServiceImpl(UserProfileServiceImpl.getPharmacyId());


    public ManagerPanel(){
        setLayout(null);
        try {
            img = ImageIO.read(getClass().getResource("/background.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        setIntFormat();

        loggedNameLabel = new JLabel(UserProfileServiceImpl.getFirstName(), SwingConstants.CENTER);
        loggedNameLabel.setBounds(555, 15, 80, 50);
        loggedNameLabel.setFont(loggedNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(getCurrentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100, 50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        logOutButton = new JButton("LOG OUT");
        logOutButton.setBounds(555, 55, 80, 30);
        logOutButton.setFont(logOutButton.getFont().deriveFont(12f));
        logOutButton.addActionListener(e -> {
            mainFrame.logout();
        });

        employeeLabel = new JLabel("YOUR TEAM", SwingConstants.CENTER);
        employeeLabel.setBounds(145, 115, 100, 50 );
        employeeLabel.setFont(employeeLabel.getFont().deriveFont(15f));

        employeeList = new JList(userService.getUnitEmployeeList());
        employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeList.setFont(employeeList.getFont().deriveFont(15f));

        teamScroller = new JScrollPane();
        teamScroller.setViewportView(employeeList);
        teamScroller.setBounds(70, 160, 250, 120);

        userDetailsButton = new JButton("DETAILS");
        userDetailsButton.setBounds(155, 293, 80, 36 );
        userDetailsButton.setFont(userDetailsButton.getFont().deriveFont(13f));
        userDetailsButton.addActionListener(e -> {
            if (employeeList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null,"Pick the user!","Information", 1);
            } else {
                userService.setUnitUser(employeeList.getSelectedIndex());
                managerReadUserPanel = new ManagerReadUserPanel(userService);
                mainFrame.panelSwitchOver(managerReadUserPanel);
            }
        });

        availableMedicineLabel = new JLabel("STORAGE", SwingConstants.CENTER);
        availableMedicineLabel.setBounds(455, 115, 100, 50 );
        availableMedicineLabel.setFont(availableMedicineLabel.getFont().deriveFont(15f));

        medicineList = new JList(pharmacyStorageService.getMedicinesInStorageList());
        medicineList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        medicineList.setFont(medicineList.getFont().deriveFont(15f));

        storageScroller = new JScrollPane();
        storageScroller.setViewportView(medicineList);
        storageScroller.setBounds(380, 160, 250, 120);

        medicineQtyUpdateLabel = new JLabel("Qty update");
        medicineQtyUpdateLabel.setBounds(390, 291, 90, 40 );
        medicineQtyUpdateLabel.setFont(medicineQtyUpdateLabel.getFont().deriveFont(15f));

        medicineQtyUpdateField = new JFormattedTextField(integerFormatter);
        medicineQtyUpdateField.setBounds(480, 293, 50, 36);
        medicineQtyUpdateField.setValue(0);
        medicineQtyUpdateField.setFont(medicineQtyUpdateField.getFont().deriveFont(15f));

        updateButton = new JButton("UPDATE");
        updateButton.setBounds(545, 293, 80, 36);
        updateButton.setFont(updateButton.getFont().deriveFont(13f));
        updateButton.addActionListener(e -> {
            if (medicineList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null,"Pick the medicine!","Information", 1);
            } else {
                pharmacyStorageService.setUpdateMedicineInStorageData(medicineList.getSelectedIndex());
                pharmacyStorageService.setPharmacyStorageDataForUpdate((Integer) medicineQtyUpdateField.getValue());
                revalidateMedicineList();
                medicineQtyUpdateField.setValue(0);
            }
        });

        saleLabel = new JLabel("Total sale for: ");
        saleLabel.setBounds(100, 490, 150, 40);
        saleLabel.setFont(saleLabel.getFont().deriveFont(15f));

        dateTextField = new JTextField("YYYY-MM-DD");
        dateTextField.setBounds(250, 490, 150, 40);
        dateTextField.setFont(dateTextField.getFont().deriveFont(15f));

        saleTextField = new JTextField();
        saleTextField.setBounds(100, 550, 500, 60);
        saleTextField.setFont(saleTextField.getFont().deriveFont(15f));

        getButton = new JButton("GET");
        getButton.setBounds(410, 490, 90, 40);
        getButton.setFont(getButton.getFont().deriveFont(13f));
        getButton.addActionListener(e -> {
//            double sale = managerService.getDataBaseInit().getTotalSale(dateTextField.getText()).getTotalSale();
            saleTextField.setText("Total sale for " + dateTextField.getText() + ": " + "$");
        });

        add(loggedNameLabel);
        add(dateLabel);
        add(employeeLabel);
        add(availableMedicineLabel);
        add(saleLabel);
        add(logOutButton);
        add(teamScroller);
        add(updateButton);
        add(userDetailsButton);
        add(storageScroller);
        add(dateTextField);
        add(saleTextField);
        add(medicineQtyUpdateLabel);
        add(medicineQtyUpdateField);
        add(getButton);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    private void setIntFormat() {
        integerFormat = NumberFormat.getIntegerInstance();
        integerFormatter = new InternationalFormatter(integerFormat);
        integerFormatter.setMinimum(0);
        integerFormatter.setAllowsInvalid(false);
    }

    private void revalidateMedicineList() {
        pharmacyStorageService.updateMedicinesInStorageList();
        medicineList = new JList(pharmacyStorageService.getMedicinesInStorageList());
        medicineList.setFont(medicineList.getFont().deriveFont(15f));
        storageScroller.setViewportView(medicineList);
    }
}