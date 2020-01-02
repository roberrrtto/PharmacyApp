package pharmacy.gui.admin;

import pharmacy.service.MedicineService;
import pharmacy.service.UserProfileService;
import pharmacy.utils.CurrentDate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static pharmacy.Main.mainFrame;

public class AdminReadMedicinePanel extends JPanel {

    private JLabel userNameLabel, dateLabel, medicineLabel, medicineNameLabel, priceLabel, medicineDescriptionLabel;
    private JTextField medicineNameTextField, priceTextField;
    private JTextArea medicineDescriptionTextField;
    private MedicineService medicineService;
    private JButton goBackButton;
    private BufferedImage img;

    private CurrentDate currentDate = new CurrentDate();

    public AdminReadMedicinePanel(MedicineService medicineService){
        setLayout(null);
        try {
            img = ImageIO.read(getClass().getResource("/background.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.medicineService = medicineService;

        userNameLabel = new JLabel(UserProfileService.getFirstName(), SwingConstants.CENTER);
        userNameLabel.setBounds(555, 15, 80, 50);
        userNameLabel.setFont(userNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(currentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100,50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        medicineLabel = new JLabel("Medicine", SwingConstants.CENTER);
        medicineLabel.setBounds(100, 50, 500, 50 );
        medicineLabel.setFont(medicineLabel.getFont().deriveFont(15f));

        medicineNameLabel = new JLabel("medicine name", SwingConstants.RIGHT);
        medicineNameLabel.setBounds(100, 100, 110, 50 );
        medicineNameLabel.setFont(medicineNameLabel.getFont().deriveFont(15f));

        medicineNameTextField = new JTextField("", SwingConstants.LEFT);
        medicineNameTextField.setBounds(220, 100, 360, 40);
        medicineNameTextField.setEditable(false);
        medicineNameTextField.setFont(medicineNameTextField.getFont().deriveFont(15f));

        priceLabel = new JLabel("price", SwingConstants.RIGHT);
        priceLabel.setBounds(100, 150, 110, 50 );
        priceLabel.setFont(medicineLabel.getFont().deriveFont(15f));

        priceTextField = new JTextField("", SwingConstants.LEFT);
        priceTextField.setBounds(220, 150, 360, 40);
        priceTextField.setEditable(false);
        priceTextField.setFont(priceTextField.getFont().deriveFont(15f));

        medicineDescriptionLabel = new JLabel("medicine desc.", SwingConstants.RIGHT);
        medicineDescriptionLabel.setBounds(100, 195, 110, 50 );
        medicineDescriptionLabel.setFont(medicineLabel.getFont().deriveFont(15f));

        medicineDescriptionTextField = new JTextArea();
        medicineDescriptionTextField.setBounds(222, 205, 356, 160);
        medicineDescriptionTextField.setWrapStyleWord(true);
        medicineDescriptionTextField.setLineWrap(true);
        medicineDescriptionTextField.setEditable(false);
        medicineDescriptionTextField.setFont(medicineDescriptionTextField.getFont().deriveFont(15f));

        goBackButton = new JButton("Go Back");
        goBackButton.setBounds(300, 600, 100, 40);
        goBackButton.setFont(goBackButton.getFont().deriveFont(13f));
        goBackButton.addActionListener(e -> {
            mainFrame.panelSwitchOver(new AdminShowMedicinesPanel());
        });

        setFields();

        add(userNameLabel);
        add(dateLabel);
        add(medicineLabel);
        add(goBackButton);
        add(medicineNameLabel);
        add(priceLabel);
        add(medicineDescriptionLabel);
        add(medicineNameTextField);
        add(priceTextField);
        add(medicineDescriptionTextField);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    public void setFields() {
        medicineNameTextField.setText(medicineService.readMedicineData().getMedicineName());
        priceTextField.setText(medicineService.readMedicineData().getPrice()+"");
        medicineDescriptionTextField.setText(medicineService.readMedicineData().getMedicineDescription());
    }
}