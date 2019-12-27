package pharmacy.gui.admin;

import pharmacy.service.PharmacyService;
import pharmacy.service.PharmacyServiceImpl;
import pharmacy.service.UserProfileService;
import pharmacy.utils.GetCurrentDate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static pharmacy.Main.mainFrame;

public class AdminPharmacyPanel extends JPanel {

    private JLabel pharmacyNameLabel, addressLabel, emailLabel, phoneNumberLabel, unitMangerLabel;
    private JLabel loggedNameLabel, dateLabel, pharmacyLabel;
    private JTextField pharmacyNameTF, addressTF, emailTF, phoneNumberTF, unitMangerTF;
    private JButton logOutButton, backToMenu, editModeButton, readModeButton, submitButton;
    private JComboBox pharmacyList;
    private BufferedImage img;

    private GetCurrentDate getCurrentDate = new GetCurrentDate();
    private PharmacyService pharmacyService = new PharmacyServiceImpl();

    public AdminPharmacyPanel() {
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

        pharmacyLabel = new JLabel("PHARMACY", SwingConstants.CENTER);
        pharmacyLabel.setBounds(100, 50, 500, 50);
        pharmacyLabel.setFont(pharmacyLabel.getFont().deriveFont(15f));

        pharmacyList = new JComboBox();
        pharmacyList.addItem("----------");
        for (int i = 0; i < pharmacyService.getPharmacyList().length; i++) {
            pharmacyList.addItem(pharmacyService.getPharmacyList()[i]);
        }
        pharmacyList.setBounds(240, 100, 220, 50);
        pharmacyList.setFont(pharmacyList.getFont().deriveFont(15f));
        pharmacyList.addItemListener(e -> {
            if (pharmacyList.getSelectedIndex() > 0) {
                pharmacyService.setUpdatePharmacyData(pharmacyList.getSelectedIndex()-1);
                setFields();
            } else {
                resetFields();
            }
        });

        pharmacyNameLabel = new JLabel("pharmacy name", SwingConstants.RIGHT);
        pharmacyNameLabel.setBounds(90, 150, 120, 50 );
        pharmacyNameLabel.setFont(pharmacyNameLabel.getFont().deriveFont(15f));

        pharmacyNameTF = new JTextField("", SwingConstants.LEFT);
        pharmacyNameTF.setBounds(220, 150, 360, 40);
        pharmacyNameTF.setEditable(false);
        pharmacyNameTF.setFont(pharmacyNameTF.getFont().deriveFont(15f));

        addressLabel = new JLabel("address", SwingConstants.RIGHT);
        addressLabel.setBounds(100, 200, 110, 50 );
        addressLabel.setFont(addressLabel.getFont().deriveFont(15f));

        addressTF = new JTextField("", SwingConstants.LEFT);
        addressTF.setBounds(220, 200, 360, 40);
        addressTF.setEditable(false);
        addressTF.setFont(addressTF.getFont().deriveFont(15f));

        emailLabel = new JLabel("email", SwingConstants.RIGHT);
        emailLabel.setBounds(100, 250, 110, 50 );
        emailLabel.setFont(emailLabel.getFont().deriveFont(15f));

        emailTF = new JTextField("", SwingConstants.LEFT);
        emailTF.setBounds(220, 250, 360, 40);
        emailTF.setEditable(false);
        emailTF.setFont(emailTF.getFont().deriveFont(15f));

        phoneNumberLabel = new JLabel("phone number", SwingConstants.RIGHT);
        phoneNumberLabel.setBounds(90, 300, 120, 50 );
        phoneNumberLabel.setFont(phoneNumberLabel.getFont().deriveFont(15f));

        phoneNumberTF = new JTextField("", SwingConstants.LEFT);
        phoneNumberTF.setBounds(220, 300, 360, 40);
        phoneNumberTF.setEditable(false);
        phoneNumberTF.setFont(phoneNumberTF.getFont().deriveFont(15f));

        unitMangerLabel = new JLabel("unit manager", SwingConstants.RIGHT);
        unitMangerLabel.setBounds(90, 350, 120, 50 );
        unitMangerLabel.setFont(unitMangerLabel.getFont().deriveFont(15f));

        unitMangerTF = new JTextField("", SwingConstants.LEFT);
        unitMangerTF.setBounds(220, 350, 360, 40);
        unitMangerTF.setEditable(false);
        unitMangerTF.setFont(unitMangerTF.getFont().deriveFont(15f));

        readModeButton = new JButton("READ");
        readModeButton.setBounds(200, 410, 100, 40);
        readModeButton.setFont(readModeButton.getFont().deriveFont(13f));
        readModeButton.addActionListener(e -> {
            setReadMode();
        });
        readModeButton.setEnabled(false);
        readModeButton.setVisible(false);

        editModeButton = new JButton("EDIT");
        editModeButton.setBounds(300, 410, 100, 40);
        editModeButton.setFont(editModeButton.getFont().deriveFont(13f));
        editModeButton.addActionListener(e -> {
            setEditMode();
        });

        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(400, 410, 100, 40);
        submitButton.setFont(submitButton.getFont().deriveFont(13f));
        submitButton.addActionListener(e -> {
            pharmacyService.setPharmacyDataForUpdate(addressTF.getText(), emailTF.getText(), phoneNumberTF.getText());
            pharmacyList.setSelectedIndex(0);
            resetFields();
        });
        submitButton.setEnabled(false);
        submitButton.setVisible(false);


        add(loggedNameLabel);
        add(dateLabel);
        add(pharmacyNameLabel);
        add(addressLabel);
        add(emailLabel);
        add(phoneNumberLabel);
        add(unitMangerLabel);
        add(logOutButton);
        add(backToMenu);
        add(pharmacyLabel);
        add(pharmacyList);
        add(pharmacyNameTF);
        add(addressTF);
        add(emailTF);
        add(phoneNumberTF);
        add(unitMangerTF);
        add(readModeButton);
        add(editModeButton);
        add(submitButton);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    private void setFields() {
        pharmacyNameTF.setText(pharmacyService.readPharmacyData().getPharmacyName());
        addressTF.setText(pharmacyService.readPharmacyData().getAddress());
        emailTF.setText(pharmacyService.readPharmacyData().getEmail());
        phoneNumberTF.setText(pharmacyService.readPharmacyData().getPhoneNumber());
        unitMangerTF.setText(pharmacyService.getPharmacyUnitManager());
    }

    private void resetFields() {
        pharmacyNameTF.setText("");
        addressTF.setText("");
        emailTF.setText("");
        phoneNumberTF.setText("");
        unitMangerTF.setText("");
    }

    private void setEditMode() {
        readModeButton.setEnabled(true);
        readModeButton.setVisible(true);
        editModeButton.setVisible(false);
        editModeButton.setEnabled(false);
        submitButton.setEnabled(true);
        submitButton.setVisible(true);
        addressTF.setEditable(true);
        emailTF.setEditable(true);
        phoneNumberTF.setEditable(true);
    }

    private void setReadMode() {
        readModeButton.setEnabled(false);
        readModeButton.setVisible(false);
        editModeButton.setVisible(true);
        editModeButton.setEnabled(true);
        submitButton.setEnabled(false);
        submitButton.setVisible(false);
        addressTF.setEditable(false);
        emailTF.setEditable(false);
        phoneNumberTF.setEditable(false);
    }
}