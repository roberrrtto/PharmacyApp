package pharmacy.gui.admin;

import pharmacy.service.UserProfileService;
import pharmacy.service.UserService;
import pharmacy.utils.CurrentDate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static pharmacy.Main.mainFrame;

public class AdminReadUserPanel extends JPanel {

    private JLabel userNameLabel, dateLabel, employeeLabel, firstNameLabel, lastNameLabel, addressLabel;
    private JLabel emailLabel, phoneNoLabel, loginLabel, passwordLabel, jobTitleLabel, salaryLabel, pharmacyIdLabel;
    private JTextField firstNameTextField, lastNameTextField, addressTextField, emailTextField, phoneNoTextField;
    private JTextField loginTextField, passwordTextField, jobTitleTextField, salaryTextField, pharmacyIdTextField;
    private JButton goBackButton;
    private BufferedImage img;
    private UserService userService;

    private CurrentDate currentDate = new CurrentDate();

    public AdminReadUserPanel(UserService userService){
        setLayout(null);
        try {
            img = ImageIO.read(getClass().getResource("/background.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.userService = userService;

        userNameLabel = new JLabel(UserProfileService.getFirstName(), SwingConstants.CENTER);
        userNameLabel.setBounds(555, 15, 80, 50);
        userNameLabel.setFont(userNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(currentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100,50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        employeeLabel = new JLabel("Employee", SwingConstants.CENTER);
        employeeLabel.setBounds(100, 50, 500, 50 );
        employeeLabel.setFont(employeeLabel.getFont().deriveFont(15f));

        firstNameLabel = new JLabel("first name", SwingConstants.LEFT);
        firstNameLabel.setBounds(100, 100, 110, 50 );
        firstNameLabel.setFont(firstNameLabel.getFont().deriveFont(15f));

        firstNameTextField = new JTextField();
        firstNameTextField.setEditable(false);
        firstNameTextField.setBounds(220, 100, 360, 40);
        firstNameTextField.setFont(firstNameTextField.getFont().deriveFont(15f));

        lastNameLabel = new JLabel("last name", SwingConstants.LEFT);
        lastNameLabel.setBounds(100, 150, 110, 50 );
        lastNameLabel.setFont(employeeLabel.getFont().deriveFont(15f));

        lastNameTextField = new JTextField();
        lastNameTextField.setEditable(false);
        lastNameTextField.setBounds(220, 150, 360, 40);
        lastNameTextField.setFont(lastNameTextField.getFont().deriveFont(15f));

        addressLabel = new JLabel("home address", SwingConstants.LEFT);
        addressLabel.setBounds(100, 200, 110, 50 );
        addressLabel.setFont(employeeLabel.getFont().deriveFont(15f));

        addressTextField = new JTextField();
        addressTextField.setEditable(false);
        addressTextField.setBounds(220, 200, 360, 40);
        addressTextField.setFont(addressTextField.getFont().deriveFont(15f));

        emailLabel = new JLabel("email", SwingConstants.LEFT);
        emailLabel.setBounds(100, 250, 110, 50 );
        emailLabel.setFont(emailLabel.getFont().deriveFont(15f));

        emailTextField = new JTextField();
        emailTextField.setEditable(false);
        emailTextField.setBounds(220, 250, 360, 40);
        emailTextField.setFont(emailTextField.getFont().deriveFont(15f));

        phoneNoLabel = new JLabel("tel. no.", SwingConstants.LEFT);
        phoneNoLabel.setBounds(100, 300, 110, 50 );
        phoneNoLabel.setFont(phoneNoLabel.getFont().deriveFont(15f));

        phoneNoTextField = new JTextField();
        phoneNoTextField.setEditable(false);
        phoneNoTextField.setBounds(220, 300, 360, 40);
        phoneNoTextField.setFont(phoneNoTextField.getFont().deriveFont(15f));

        loginLabel = new JLabel("login", SwingConstants.LEFT);
        loginLabel.setBounds(100, 350, 110, 50 );
        loginLabel.setFont(loginLabel.getFont().deriveFont(15f));

        loginTextField = new JTextField();
        loginTextField.setEditable(false);
        loginTextField.setBounds(220, 350, 360, 40);
        loginTextField.setFont(loginTextField.getFont().deriveFont(15f));

        passwordLabel = new JLabel("password", SwingConstants.LEFT);
        passwordLabel.setBounds(100, 400, 110, 50 );
        passwordLabel.setFont(passwordLabel.getFont().deriveFont(15f));

        passwordTextField = new JTextField();
        passwordTextField.setEditable(false);
        passwordTextField.setBounds(220, 400, 360, 40);
        passwordTextField.setFont(passwordTextField.getFont().deriveFont(15f));

        jobTitleLabel = new JLabel("job title", SwingConstants.LEFT);
        jobTitleLabel.setBounds(100, 450, 110, 50 );
        jobTitleLabel.setFont(jobTitleLabel.getFont().deriveFont(15f));

        jobTitleTextField = new JTextField();
        jobTitleTextField.setEditable(false);
        jobTitleTextField.setBounds(220, 450, 360, 40);
        jobTitleTextField.setFont(jobTitleTextField.getFont().deriveFont(15f));

        salaryLabel = new JLabel("salary", SwingConstants.LEFT);
        salaryLabel.setBounds(100, 500, 110, 50 );
        salaryLabel.setFont(salaryLabel.getFont().deriveFont(15f));

        salaryTextField = new JTextField();
        salaryTextField.setEditable(false);
        salaryTextField.setBounds(220, 500, 360, 40);
        salaryTextField.setFont(salaryTextField.getFont().deriveFont(15f));

        pharmacyIdLabel = new JLabel("pharmacy ID", SwingConstants.LEFT);
        pharmacyIdLabel.setBounds(100, 550, 110, 50 );
        pharmacyIdLabel.setFont(pharmacyIdLabel.getFont().deriveFont(15f));

        pharmacyIdTextField = new JTextField();
        pharmacyIdTextField.setEditable(false);
        pharmacyIdTextField.setBounds(220, 550, 360, 40);
        pharmacyIdTextField.setFont(pharmacyIdTextField.getFont().deriveFont(15f));

        goBackButton = new JButton("Go Back");
        goBackButton.setBounds(300, 600, 100, 40);
        goBackButton.setFont(goBackButton.getFont().deriveFont(13f));
        goBackButton.addActionListener(e -> {
            mainFrame.panelSwitchOver(new AdminShowUsersPanel());
        });

        setFields();

        add(userNameLabel);
        add(dateLabel);
        add(employeeLabel);
        add(goBackButton);
        add(firstNameLabel);
        add(lastNameLabel);
        add(addressLabel);
        add(emailLabel);
        add(phoneNoLabel);
        add(loginLabel);
        add(passwordLabel);
        add(jobTitleLabel);
        add(salaryLabel);
        add(pharmacyIdLabel);
        add(firstNameTextField);
        add(lastNameTextField);
        add(addressTextField);
        add(emailTextField);
        add(phoneNoTextField);
        add(loginTextField);
        add(passwordTextField);
        add(jobTitleTextField);
        add(salaryTextField);
        add(pharmacyIdTextField);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    public void setFields() {
        firstNameTextField.setText(userService.readUserData().getFirstName());
        lastNameTextField.setText(userService.readUserData().getLastName());
        addressTextField.setText(userService.readUserData().getAddress());
        emailTextField.setText(userService.readUserData().getEmail());
        phoneNoTextField.setText(userService.readUserData().getPhoneNumber());
        loginTextField.setText(userService.readUserData().getLogin());
        passwordTextField.setText(userService.readUserData().getPassword());
        jobTitleTextField.setText(userService.readUserData().getJobTitle());
        salaryTextField.setText(userService.readUserData().getSalary()+"");
        pharmacyIdTextField.setText(userService.readUserData().getPharmacyId()+"");
    }
}