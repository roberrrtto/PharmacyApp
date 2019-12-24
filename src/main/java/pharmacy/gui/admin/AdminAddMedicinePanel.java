package pharmacy.gui.admin;

import pharmacy.service.AdminMedicinesService;
import pharmacy.service.UserProfileService;
import pharmacy.utils.GetCurrentDate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static pharmacy.Main.mainFrame;

public class AdminAddMedicinePanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, medicineLabel, medicineNameLabel, priceLabel, medicineDescriptionLabel;
    private JButton goBackButton, submitButton;
    private JTextField medicineNameTextField, priceTextField, medicineDescriptionTextField;
    private GetCurrentDate getCurrentDate = new GetCurrentDate();
    private BufferedImage img;

    public AdminAddMedicinePanel(AdminMedicinesService adminMedicinesService){
        setLayout(null);
        try {
            img = ImageIO.read(getClass().getResource("/background.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        loggedNameLabel = new JLabel(UserProfileService.getFirstName(), SwingConstants.CENTER);
        loggedNameLabel.setBounds(555, 15, 80, 50);
        loggedNameLabel.setFont(loggedNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(getCurrentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100,50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        medicineLabel = new JLabel("Medicine", SwingConstants.CENTER);
        medicineLabel.setBounds(100, 50, 500, 50 );
        medicineLabel.setFont(medicineLabel.getFont().deriveFont(15f));

        medicineNameLabel = new JLabel("medicine name", SwingConstants.LEFT);
        medicineNameLabel.setBounds(100, 100, 110, 50 );
        medicineNameLabel.setFont(medicineNameLabel.getFont().deriveFont(15f));

        medicineNameTextField = new JTextField();
        medicineNameTextField.setBounds(220, 100, 360, 40);
        medicineNameTextField.setFont(medicineNameTextField.getFont().deriveFont(15f));

        priceLabel = new JLabel("price", SwingConstants.LEFT);
        priceLabel.setBounds(100, 150, 110, 50 );
        priceLabel.setFont(medicineLabel.getFont().deriveFont(15f));

        priceTextField = new JTextField();
        priceTextField.setBounds(220, 150, 360, 40);
        priceTextField.setFont(priceTextField.getFont().deriveFont(15f));

        medicineDescriptionLabel = new JLabel("medicine desc", SwingConstants.LEFT);
        medicineDescriptionLabel.setBounds(100, 200, 110, 50 );
        medicineDescriptionLabel.setFont(medicineLabel.getFont().deriveFont(15f));

        medicineDescriptionTextField = new JTextField();
        medicineDescriptionTextField.setBounds(220, 200, 360, 40);
        medicineDescriptionTextField.setFont(medicineDescriptionTextField.getFont().deriveFont(15f));

        submitButton = new JButton("Submit");
        submitButton.setBounds(400, 600, 100, 40);
        submitButton.setFont(submitButton.getFont().deriveFont(13f));
        submitButton.addActionListener(e -> {
            adminMedicinesService.addNewMedicine(medicineNameTextField.getText(), Double.parseDouble(priceTextField.getText()),
                    medicineDescriptionTextField.getText());
            resetFields();
            adminMedicinesService.updateMedicineList();
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
        add(priceTextField);
        add(medicineDescriptionTextField);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    public void resetFields() {
        medicineNameTextField.setText("");
        priceTextField.setText("");
        medicineDescriptionTextField.setText("");
    }
}