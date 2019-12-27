package pharmacy.gui.admin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static pharmacy.Main.mainFrame;

public class AdminMenuPanel extends JPanel {

    private JLabel menuLabel;
    private JButton logOutButton, usersButton, pharmaciesButton, medicinesButton;

    private BufferedImage img;

    public AdminMenuPanel() {
        setLayout(null);
        try {
            img = ImageIO.read(getClass().getResource("/background.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        menuLabel = new JLabel("MENU", SwingConstants.CENTER);
        menuLabel.setBounds(300, 130, 100,50);
        menuLabel.setFont(menuLabel.getFont().deriveFont(35f));

        usersButton = new JButton("USERS");
        usersButton.setBounds(225, 190, 250, 50);
        usersButton.setFont(usersButton.getFont().deriveFont(20f));
        usersButton.addActionListener(e -> {
            AdminShowUsersPanel adminShowUsersPanel = new AdminShowUsersPanel();
            mainFrame.panelSwitchOver(adminShowUsersPanel);
        });

        medicinesButton = new JButton("MEDICINES");
        medicinesButton.setBounds(225, 300, 250, 50);
        medicinesButton.setFont(medicinesButton.getFont().deriveFont(20f));
        medicinesButton.addActionListener(e -> {
            AdminShowMedicinesPanel adminShowMedicinesPanel = new AdminShowMedicinesPanel();
            mainFrame.panelSwitchOver(adminShowMedicinesPanel);
        });

        pharmaciesButton = new JButton("PHARMACIES");
        pharmaciesButton.setBounds(225, 245, 250, 50);
        pharmaciesButton.setFont(pharmaciesButton.getFont().deriveFont(20f));
        pharmaciesButton.addActionListener(e -> {
            AdminPharmacyPanel adminPharmacyPanel = new AdminPharmacyPanel();
            mainFrame.panelSwitchOver(adminPharmacyPanel);
        });

        logOutButton = new JButton("LOG OUT");
        logOutButton.setBounds(225, 355, 250, 50);
        logOutButton.setFont(logOutButton.getFont().deriveFont(20f));
        logOutButton.addActionListener(e -> {
            mainFrame.logout();
        });

        add(menuLabel);
        add(usersButton);
        add(medicinesButton);
        add(pharmaciesButton);
        add(logOutButton);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }
}