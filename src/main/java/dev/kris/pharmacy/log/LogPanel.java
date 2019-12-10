package dev.kris.pharmacy.log;

import javax.swing.*;

public class LogPanel extends JPanel {

    private JLabel pharmacyName, usernameLabel, passwordLabel;
    private JButton loginButton;
    private JTextField usernameTextField, passwordTextField;

    public LogPanel(){
        setLayout(null);

        pharmacyName = new JLabel("PHARMACY");
        pharmacyName.setBounds(220, 200, 800,80);
        pharmacyName.setFont(pharmacyName.getFont().deriveFont(100f));

        usernameLabel = new JLabel("username: ");
        usernameLabel.setBounds(220, 420, 180, 50);
        usernameLabel.setFont(usernameLabel.getFont().deriveFont(30f));

        passwordLabel = new JLabel("password: ");
        passwordLabel.setBounds(220, 520, 180, 50);
        passwordLabel.setFont(passwordLabel.getFont().deriveFont(30f));

        usernameTextField = new JTextField();
        usernameTextField.setBounds(400, 420, 400, 50);
        usernameTextField.setFont(usernameTextField.getFont().deriveFont(30f));

        passwordTextField = new JTextField();
        passwordTextField.setBounds(400, 520, 400, 50);
        passwordTextField.setFont(passwordTextField.getFont().deriveFont(30f));

        loginButton = new JButton("Log in");
        loginButton.setBounds(400, 650, 200, 50);
        loginButton.setFont(loginButton.getFont().deriveFont(30f));

        add(pharmacyName);
        add(usernameLabel);
        add(passwordLabel);
        add(passwordTextField);
        add(usernameTextField);
        add(loginButton);
    }

    public JLabel getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(JLabel pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public void setUsernameLabel(JLabel usernameLabel) {
        this.usernameLabel = usernameLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(JTextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(JTextField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }
}
