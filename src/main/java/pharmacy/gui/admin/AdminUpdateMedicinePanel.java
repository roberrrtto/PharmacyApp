package pharmacy.gui.admin;

import pharmacy.service.MedicineService;
import pharmacy.service.UserProfileService;
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

public class AdminUpdateMedicinePanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, medicineLabel, medicineNameLabel, priceLabel, medicineDescriptionLabel;
    private JButton goBackButton, submitButton;
    private JTextField medicineNameTextField, priceTextField;
    private JTextArea medicineDescriptionTextField;
    private JFormattedTextField priceFormattedTextField;
    private InternationalFormatter priceFormatter;
    private NumberFormat priceFormat;
    private MedicineService medicineService;
    private BufferedImage img;

    private GetCurrentDate getCurrentDate = new GetCurrentDate();

    public AdminUpdateMedicinePanel(MedicineService medicineService){
        setPriceFormat();
        setLayout(null);
        try {
            img = ImageIO.read(getClass().getResource("/background.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.medicineService = medicineService;

        loggedNameLabel = new JLabel(UserProfileService.getFirstName(), SwingConstants.CENTER);
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
            medicineService.setMedicineDataForUpdate(medicineNameTextField.getText(),(Double) priceFormattedTextField.getValue(),
                    medicineDescriptionTextField.getText());
        });

        goBackButton = new JButton("Go Back");
        goBackButton.setBounds(250, 600, 100, 40);
        goBackButton.setFont(goBackButton.getFont().deriveFont(13f));
        goBackButton.addActionListener(e -> {
            medicineService.updateMedicineList();
            mainFrame.panelSwitchOver(new AdminShowMedicinesPanel());
        });

        setFields();

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

    private void setFields() {
        medicineNameTextField.setText(medicineService.readMedicineData().getMedicineName());
        priceFormattedTextField.setValue(medicineService.readMedicineData().getPrice());
        medicineDescriptionTextField.setText(medicineService.readMedicineData().getMedicineDescription());
    }

    private void setPriceFormat() {
        priceFormat = DecimalFormat.getInstance();
        priceFormat.setMinimumFractionDigits(2);
        priceFormat.setMaximumFractionDigits(2);
        priceFormatter = new InternationalFormatter(priceFormat);
        priceFormatter.setMinimum(0.0);
        priceFormatter.setAllowsInvalid(false);
    }
}