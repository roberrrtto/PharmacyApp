package pharmacy.gui.admin;

import pharmacy.service.MedicineService;
import pharmacy.service.UserProfileServiceImpl;
import pharmacy.utils.GetCurrentDate;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import static pharmacy.Main.mainFrame;

public class AdminAddMedicinePanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, medicineLabel, medicineNameLabel, priceLabel, medicineDescriptionLabel;
    private JButton goBackButton, submitButton;
    private JTextField medicineNameTextField;
    private JTextArea medicineDescriptionTextField;
    private JFormattedTextField priceFormattedTextField;
    private InternationalFormatter priceFormatter;
    private NumberFormat priceFormat;
    private BufferedImage img;

    private GetCurrentDate getCurrentDate = new GetCurrentDate();

    public AdminAddMedicinePanel(MedicineService medicineService){
        setPriceFormat();
        setLayout(null);
        try {
            img = ImageIO.read(getClass().getResource("/background.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        loggedNameLabel = new JLabel(UserProfileServiceImpl.getFirstName(), SwingConstants.CENTER);
        loggedNameLabel.setBounds(555, 15, 80, 50);
        loggedNameLabel.setFont(loggedNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(getCurrentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100,50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        medicineLabel = new JLabel("Medicine", SwingConstants.CENTER);
        medicineLabel.setBounds(100, 50, 500, 50 );
        medicineLabel.setFont(medicineLabel.getFont().deriveFont(15f));

        medicineNameLabel = new JLabel("medicine name", SwingConstants.RIGHT);
        medicineNameLabel.setBounds(100, 100, 110, 50 );
        medicineNameLabel.setFont(medicineNameLabel.getFont().deriveFont(15f));

        medicineNameTextField = new JTextField();
        medicineNameTextField.setBounds(220, 100, 360, 40);
        medicineNameTextField.setFont(medicineNameTextField.getFont().deriveFont(15f));

        priceLabel = new JLabel("price", SwingConstants.RIGHT);
        priceLabel.setBounds(100, 150, 110, 50 );
        priceLabel.setFont(medicineLabel.getFont().deriveFont(15f));

        priceFormattedTextField = new JFormattedTextField(priceFormatter);
        priceFormattedTextField.setBounds(220, 150, 360, 40);
        priceFormattedTextField.setFont(priceFormattedTextField.getFont().deriveFont(15f));
        priceFormattedTextField.setValue(0.0);

        medicineDescriptionLabel = new JLabel("medicine desc", SwingConstants.RIGHT);
        medicineDescriptionLabel.setBounds(100, 195, 110, 50 );
        medicineDescriptionLabel.setFont(medicineLabel.getFont().deriveFont(15f));

        medicineDescriptionTextField = new JTextArea();
        medicineDescriptionTextField.setBounds(222, 205, 356, 160);
        medicineDescriptionTextField.setWrapStyleWord(true);
        medicineDescriptionTextField.setLineWrap(true);
        medicineDescriptionTextField.setFont(medicineDescriptionTextField.getFont().deriveFont(15f));

        submitButton = new JButton("Submit");
        submitButton.setBounds(400, 600, 100, 40);
        submitButton.setFont(submitButton.getFont().deriveFont(13f));
        submitButton.addActionListener(e -> {
            medicineService.addNewMedicine(medicineNameTextField.getText(),(Double) priceFormattedTextField.getValue(),
                    medicineDescriptionTextField.getText());
            resetFields();
            medicineService.updateMedicineList();
        });

        goBackButton = new JButton("Go Back");
        goBackButton.setBounds(250, 600, 100, 40);
        goBackButton.setFont(goBackButton.getFont().deriveFont(13f));
        goBackButton.addActionListener(e -> {
            mainFrame.panelSwitchOver(new AdminShowMedicinesPanel());
        });

        add(loggedNameLabel);
        add(dateLabel);
        add(medicineLabel);
        add(goBackButton);
        add(submitButton);
        add(medicineNameLabel);
        add(priceLabel);
        add(medicineDescriptionLabel);
        add(medicineNameTextField);
        add(priceFormattedTextField);
        add(medicineDescriptionTextField);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    private void setPriceFormat() {
        priceFormat = DecimalFormat.getInstance();
        priceFormat.setMinimumFractionDigits(2);
        priceFormat.setMaximumFractionDigits(2);
        priceFormatter = new InternationalFormatter(priceFormat);
        priceFormatter.setMinimum(0.0);
        priceFormatter.setAllowsInvalid(false);
    }

    private void resetFields() {
        medicineNameTextField.setText("");
        medicineDescriptionTextField.setText("");
        priceFormattedTextField.setValue(0.0);
    }
}