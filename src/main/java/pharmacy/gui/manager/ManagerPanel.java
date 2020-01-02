package pharmacy.gui.manager;

import pharmacy.service.*;
import pharmacy.utils.CurrentDate;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Date;
import java.text.NumberFormat;
import java.text.ParseException;

import static pharmacy.Main.mainFrame;

public class ManagerPanel extends JPanel {

    private JLabel userNameLabel, dateLabel, employeeLabel, availableMedicineLabel, receiptLabel, medicineQtyUpdateLabel,
            receiptIdLabel, saleLabel, totalSaleLabel, formatDateLabel, fromLabel, toLabel;
    private JButton logOutButton, updateButton, getButton, userDetailsButton, getReceiptButton;
    private JTextField totalSaleTF;
    private JTextArea receiptTextArea;
    private JFormattedTextField medicineQtyUpdateField, receiptId, date1yyyy, date1mm, date1dd, date2yyyy, date2mm, date2dd;
    private MaskFormatter formatYYYY, formatMM, formatDD;
    private InternationalFormatter integerFormatter;
    private NumberFormat integerFormat;
    private JList<String> employeeList, medicineList;
    private JScrollPane storageScroller, teamScroller, receiptScroller;
    private BufferedImage img;
    private Date dateFrom, dateTo;

    private ManagerReadUserPanel managerReadUserPanel;
    private CurrentDate currentDate = new CurrentDate();
    private PharmacyStorageService pharmacyStorageService = new PharmacyStorageServiceImpl(UserProfileService.getPharmacyId());
    private UserService userService = new UserServiceImpl(UserProfileService.getPharmacyId());
    private ReceiptService receiptService = new ReceiptServiceImpl();


    public ManagerPanel() {
        setLayout(null);
        try {
            img = ImageIO.read(getClass().getResource("/background.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        setIntFormat();
        try {
            setFormatForDate();
        } catch (ParseException ex) {
            ex.printStackTrace();
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

        employeeLabel = new JLabel("YOUR TEAM", SwingConstants.CENTER);
        employeeLabel.setBounds(145, 110, 100, 50 );
        employeeLabel.setFont(employeeLabel.getFont().deriveFont(15f));

        employeeList = new JList(userService.getUnitEmployeeList());
        employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeList.setFont(employeeList.getFont().deriveFont(15f));

        teamScroller = new JScrollPane();
        teamScroller.setViewportView(employeeList);
        teamScroller.setBounds(70, 155, 250, 120);

        userDetailsButton = new JButton("DETAILS");
        userDetailsButton.setBounds(155, 288, 80, 36 );
        userDetailsButton.setFont(userDetailsButton.getFont().deriveFont(13f));
        userDetailsButton.addActionListener(e -> {
            if (employeeList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(this,"Nothing is selected!");
            } else {
                userService.setUnitUser(employeeList.getSelectedIndex());
                managerReadUserPanel = new ManagerReadUserPanel(userService);
                mainFrame.panelSwitchOver(managerReadUserPanel);
            }
        });

        availableMedicineLabel = new JLabel("STORAGE", SwingConstants.CENTER);
        availableMedicineLabel.setBounds(455, 110, 100, 50 );
        availableMedicineLabel.setFont(availableMedicineLabel.getFont().deriveFont(15f));

        medicineList = new JList(pharmacyStorageService.getMedicinesWithQtyDisplayList());
        medicineList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        medicineList.setFont(medicineList.getFont().deriveFont(15f));

        storageScroller = new JScrollPane();
        storageScroller.setViewportView(medicineList);
        storageScroller.setBounds(380, 155, 250, 120);

        medicineQtyUpdateLabel = new JLabel("Qty update");
        medicineQtyUpdateLabel.setBounds(390, 286, 90, 40 );
        medicineQtyUpdateLabel.setFont(medicineQtyUpdateLabel.getFont().deriveFont(15f));

        medicineQtyUpdateField = new JFormattedTextField(integerFormatter);
        medicineQtyUpdateField.setBounds(480, 288, 50, 36);
        medicineQtyUpdateField.setValue(0);
        medicineQtyUpdateField.setFont(medicineQtyUpdateField.getFont().deriveFont(15f));

        updateButton = new JButton("UPDATE");
        updateButton.setBounds(545, 288, 80, 36);
        updateButton.setFont(updateButton.getFont().deriveFont(13f));
        updateButton.addActionListener(e -> {
            if (medicineList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(this,"Nothing is selected!");
            } else {
                pharmacyStorageService.readMedicineDetails(medicineList.getSelectedIndex());
                pharmacyStorageService.updatePharmacyStorageQuantityData((Integer) medicineQtyUpdateField.getValue());
                revalidateMedicineList();
                medicineQtyUpdateField.setValue(0);
            }
        });

        receiptLabel = new JLabel("RECEIPT QUICK CHECK", SwingConstants.CENTER);
        receiptLabel.setBounds(95, 350, 200, 50);
        receiptLabel.setFont(receiptLabel.getFont().deriveFont(15f));

        receiptIdLabel = new JLabel("Rcpt ID    ", SwingConstants.CENTER);
        receiptIdLabel.setBounds(95, 390, 100, 35);
        receiptIdLabel.setFont(receiptIdLabel.getFont().deriveFont(15f));

        receiptId = new JFormattedTextField(integerFormatter);
        receiptId.setBounds(170, 390, 50, 35);
        receiptId.setValue(0);
        receiptId.setFont(receiptId.getFont().deriveFont(15f));

        receiptTextArea = new JTextArea();
        receiptTextArea.setEditable(false);
        receiptTextArea.setFont(receiptTextArea.getFont().deriveFont(15f));

        receiptScroller = new JScrollPane();
        receiptScroller.setViewportView(receiptTextArea);
        receiptScroller.setBounds(70, 435, 250, 210);

        getReceiptButton = new JButton("GET");
        getReceiptButton.setBounds(225, 390, 70, 35);
        getReceiptButton.setFont(getReceiptButton.getFont().deriveFont(13f));
        getReceiptButton.addActionListener(e -> {
            receiptService.setReceiptData((Integer) receiptId.getValue());
            if (receiptService.getReceiptData().getReceiptId() != 0) {
                receiptTextArea.setText(receiptService.getReceiptData().toString());
                receiptScroller.setViewportView(receiptTextArea);
            } else {
                JOptionPane.showMessageDialog(this, "There is no receipt with the given ID");
            }
        });

        saleLabel = new JLabel("SALES", SwingConstants.CENTER);
        saleLabel.setBounds(455, 350, 100, 50);
        saleLabel.setFont(saleLabel.getFont().deriveFont(15f));

        formatDateLabel = new JLabel("  YYYY     MM   DD", SwingConstants.LEFT);
        formatDateLabel.setBounds(450, 415, 200, 30);
        formatDateLabel.setFont(formatDateLabel.getFont().deriveFont(13f));

        fromLabel = new JLabel("FROM", SwingConstants.RIGHT);
        fromLabel.setBounds(380, 390, 60, 40);
        fromLabel.setFont(fromLabel.getFont().deriveFont(15f));

        date1yyyy = new JFormattedTextField(formatYYYY);
        date1yyyy.setColumns(4);
        date1yyyy.setBounds(450, 390, 50, 35);
        date1yyyy.setFont(date1yyyy.getFont().deriveFont(15f));

        date1mm = new JFormattedTextField(formatMM);
        date1mm.setColumns(2);
        date1mm.setBounds(505, 390, 30, 35);
        date1mm.setFont(date1mm.getFont().deriveFont(15f));

        date1dd = new JFormattedTextField(formatDD);
        date1dd.setColumns(2);
        date1dd.setBounds(540, 390, 30, 35);
        date1dd.setFont(date1dd.getFont().deriveFont(15f));

        date2yyyy = new JFormattedTextField(formatYYYY);
        date2yyyy.setColumns(4);
        date2yyyy.setBounds(450, 435, 50, 35);
        date2yyyy.setFont(date2yyyy.getFont().deriveFont(15f));

        date2mm = new JFormattedTextField(formatMM);
        date2mm.setColumns(2);
        date2mm.setBounds(505, 435, 30, 35);
        date2mm.setFont(date2mm.getFont().deriveFont(15f));

        date2dd = new JFormattedTextField(formatDD);
        date2dd.setColumns(2);
        date2dd.setBounds(540, 435, 30, 35);
        date2dd.setFont(date2dd.getFont().deriveFont(15f));

        toLabel = new JLabel("TO", SwingConstants.RIGHT);
        toLabel.setBounds(380, 435, 60, 40);
        toLabel.setFont(toLabel.getFont().deriveFont(15f));

        getButton = new JButton("GET");
        getButton.setBounds(470, 500, 70, 35);
        getButton.setFont(getButton.getFont().deriveFont(13f));
        getButton.addActionListener(e -> {
            setDate();
            receiptService.setTotalSale(dateFrom, dateTo);
            totalSaleTF.setText(receiptService.getTotalSale() + "$");
        });

        totalSaleLabel = new JLabel("TOTAL", SwingConstants.RIGHT);
        totalSaleLabel.setBounds(380, 540, 60, 40);
        totalSaleLabel.setFont(totalSaleLabel.getFont().deriveFont(15f));

        totalSaleTF = new JTextField();
        totalSaleTF.setEditable(false);
        totalSaleTF.setBounds(460, 540, 90, 35);
        totalSaleTF.setFont(totalSaleTF.getFont().deriveFont(15f));

        add(userNameLabel);
        add(dateLabel);
        add(employeeLabel);
        add(availableMedicineLabel);
        add(receiptLabel);
        add(logOutButton);
        add(teamScroller);
        add(updateButton);
        add(userDetailsButton);
        add(storageScroller);
        add(totalSaleTF);
        add(receiptScroller);
        add(receiptId);
        add(receiptIdLabel);
        add(getReceiptButton);
        add(medicineQtyUpdateLabel);
        add(medicineQtyUpdateField);
        add(getButton);
        add(saleLabel);
        add(formatDateLabel);
        add(fromLabel);
        add(toLabel);
        add(date1yyyy);
        add(date1mm);
        add(date1dd);
        add(date2yyyy);
        add(date2mm);
        add(date2dd);
        add(totalSaleLabel);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    private void setDate() {
        try {
            if (Integer.parseInt(date1yyyy.getText()) > 2000) {
                String date1 = date1yyyy.getText() + "-" + date1mm.getText() + "-" + date1dd.getText();
                String date2 = date2yyyy.getText() + "-" + date2mm.getText() + "-" + date2dd.getText();
                dateFrom = Date.valueOf(date1);
                dateTo = Date.valueOf(date2);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Check your inputs (incorrect year)","Warning",2);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Check your inputs (incorrect month or day)","Warning",2);
        }
    }

    private void setIntFormat() {
        integerFormat = NumberFormat.getIntegerInstance();
        integerFormatter = new InternationalFormatter(integerFormat);
        integerFormatter.setMinimum(0);
        integerFormatter.setAllowsInvalid(false);
    }

    private void revalidateMedicineList() {
        pharmacyStorageService.updateMedicinesWithQtyDisplayList();
        medicineList = new JList(pharmacyStorageService.getMedicinesWithQtyDisplayList());
        medicineList.setFont(medicineList.getFont().deriveFont(15f));
        storageScroller.setViewportView(medicineList);
    }

    private void setFormatForDate() throws ParseException {
        formatYYYY = new MaskFormatter("####");
        formatMM = new MaskFormatter("##");
        formatDD = new MaskFormatter("##");
    }
}