package pharmacy.gui.admin;

import pharmacy.service.AdminUsersService;
import pharmacy.service.UserProfileService;
import pharmacy.utils.GetCurrentDate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static pharmacy.Main.mainFrame;

public class AdminReadUserPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, employeeLabel, firstNameLabel, lastNameLabel, addressLabel,
            emailLabel, phoneNoLabel, loginLabel, passwordLabel, jobTitleLabel, salaryLabel, pharmacyIdLabel;
    private JButton goBackButton;
    private JLabel firstNameTextField, lastNameTextField, addressTextField, emailTextField, phoneNoTextField,
            loginTextField, passwordTextField, jobTitleTextField, salaryTextField, pharmacyIdTextField;
    private GetCurrentDate getCurrentDate = new GetCurrentDate();
    private AdminUsersService adminUsersService;
    private BufferedImage img;

    public AdminReadUserPanel(AdminUsersService adminUsersService){
        setLayout(null);
        try {
            img = ImageIO.read(getClass().getResource("/background.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.adminUsersService = adminUsersService;

        loggedNameLabel = new JLabel(UserProfileService.getFirstName(), SwingConstants.CENTER);
        loggedNameLabel.setBounds(555, 15, 80, 50);
        loggedNameLabel.setFont(loggedNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(getCurrentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100,50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        employeeLabel = new JLabel("Employee", SwingConstants.CENTER);
        employeeLabel.setBounds(100, 50, 500, 50 );
        employeeLabel.setFont(employeeLabel.getFont().deriveFont(15f));

        firstNameLabel = new JLabel("first name", SwingConstants.LEFT);
        firstNameLabel.setBounds(100, 100, 110, 50 );
        firstNameLabel.setFont(firstNameLabel.getFont().deriveFont(15f));

        firstNameTextField = new JLabel("", SwingConstants.LEFT);
        firstNameTextField.setBackground(Color.LIGHT_GRAY);
        firstNameTextField.setBounds(220, 110, 360, 30);
        firstNameTextField.setFont(firstNameTextField.getFont().deriveFont(15f));
        firstNameTextField.setOpaque(true);

        lastNameLabel = new JLabel("last name", SwingConstants.LEFT);
        lastNameLabel.setBounds(100, 150, 110, 50 );
        lastNameLabel.setFont(employeeLabel.getFont().deriveFont(15f));

        lastNameTextField = new JLabel("", SwingConstants.LEFT);
        lastNameTextField.setBackground(Color.LIGHT_GRAY);
        lastNameTextField.setBounds(220, 160, 360, 30);
        lastNameTextField.setFont(firstNameTextField.getFont().deriveFont(15f));
        lastNameTextField.setOpaque(true);

        addressLabel = new JLabel("home address", SwingConstants.LEFT);
        addressLabel.setBounds(100, 200, 110, 50 );
        addressLabel.setFont(employeeLabel.getFont().deriveFont(15f));

        addressTextField = new JLabel("", SwingConstants.LEFT);
        addressTextField.setBackground(Color.LIGHT_GRAY);
        addressTextField.setBounds(220, 210, 360, 30);
        addressTextField.setFont(addressTextField.getFont().deriveFont(15f));
        addressTextField.setOpaque(true);

        emailLabel = new JLabel("email", SwingConstants.LEFT);
        emailLabel.setBounds(100, 250, 110, 50 );
        emailLabel.setFont(emailLabel.getFont().deriveFont(15f));

        emailTextField = new JLabel("", SwingConstants.LEFT);
        emailTextField.setBackground(Color.LIGHT_GRAY);
        emailTextField.setBounds(220, 260, 360, 30);
        emailTextField.setFont(emailTextField.getFont().deriveFont(15f));
        emailTextField.setOpaque(true);

        phoneNoLabel = new JLabel("tel. no.", SwingConstants.LEFT);
        phoneNoLabel.setBounds(100, 300, 110, 50 );
        phoneNoLabel.setFont(phoneNoLabel.getFont().deriveFont(15f));

        phoneNoTextField = new JLabel("", SwingConstants.LEFT);
        phoneNoTextField.setBackground(Color.LIGHT_GRAY);
        phoneNoTextField.setBounds(220, 310, 360, 30);
        phoneNoTextField.setFont(phoneNoTextField.getFont().deriveFont(15f));
        phoneNoTextField.setOpaque(true);

        loginLabel = new JLabel("login", SwingConstants.LEFT);
        loginLabel.setBounds(100, 350, 110, 50 );
        loginLabel.setFont(loginLabel.getFont().deriveFont(15f));

        loginTextField = new JLabel("", SwingConstants.LEFT);
        loginTextField.setBackground(Color.LIGHT_GRAY);
        loginTextField.setBounds(220, 360, 360, 30);
        loginTextField.setFont(loginTextField.getFont().deriveFont(15f));
        loginTextField.setOpaque(true);

        passwordLabel = new JLabel("password", SwingConstants.LEFT);
        passwordLabel.setBounds(100, 400, 110, 50 );
        passwordLabel.setFont(passwordLabel.getFont().deriveFont(15f));

        passwordTextField = new JLabel("", SwingConstants.LEFT);
        passwordTextField.setBackground(Color.LIGHT_GRAY);
        passwordTextField.setBounds(220, 410, 360, 30);
        passwordTextField.setFont(passwordTextField.getFont().deriveFont(15f));
        passwordTextField.setOpaque(true);

        jobTitleLabel = new JLabel("job title", SwingConstants.LEFT);
        jobTitleLabel.setBounds(100, 450, 110, 50 );
        jobTitleLabel.setFont(jobTitleLabel.getFont().deriveFont(15f));

        jobTitleTextField = new JLabel("", SwingConstants.LEFT);
        jobTitleTextField.setBackground(Color.LIGHT_GRAY);
        jobTitleTextField.setBounds(220, 460, 360, 30);
        jobTitleTextField.setFont(jobTitleTextField.getFont().deriveFont(15f));
        jobTitleTextField.setOpaque(true);

        salaryLabel = new JLabel("salary", SwingConstants.LEFT);
        salaryLabel.setBounds(100, 500, 110, 50 );
        salaryLabel.setFont(salaryLabel.getFont().deriveFont(15f));

        salaryTextField = new JLabel("", SwingConstants.LEFT);
        salaryTextField.setBackground(Color.LIGHT_GRAY);
        salaryTextField.setBounds(220, 510, 360, 30);
        salaryTextField.setFont(salaryTextField.getFont().deriveFont(15f));
        salaryTextField.setOpaque(true);

        pharmacyIdLabel = new JLabel("pharmacy ID", SwingConstants.LEFT);
        pharmacyIdLabel.setBounds(100, 550, 110, 50 );
        pharmacyIdLabel.setFont(pharmacyIdLabel.getFont().deriveFont(15f));

        pharmacyIdTextField = new JLabel("", SwingConstants.LEFT);
        pharmacyIdTextField.setBackground(Color.LIGHT_GRAY);
        pharmacyIdTextField.setBounds(220, 560, 360, 30);
        pharmacyIdTextField.setFont(pharmacyIdTextField.getFont().deriveFont(15f));
        pharmacyIdTextField.setOpaque(true);

        goBackButton = new JButton("Go Back");
        goBackButton.setBounds(300, 600, 100, 40);
        goBackButton.setFont(goBackButton.getFont().deriveFont(13f));
        goBackButton.addActionListener(e -> {
            mainFrame.panelSwitchOver(new AdminShowUsersPanel());
        });

        setFields();

        add(loggedNameLabel);
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
        firstNameTextField.setText(adminUsersService.readUserData().getFirstName()+"");
        lastNameTextField.setText(adminUsersService.readUserData().getLastName());
        addressTextField.setText(adminUsersService.readUserData().getAddress());
        emailTextField.setText(adminUsersService.readUserData().getEmail());
        phoneNoTextField.setText(adminUsersService.readUserData().getPhoneNumber());
        loginTextField.setText(adminUsersService.readUserData().getLogin());
        passwordTextField.setText(adminUsersService.readUserData().getPassword());
        jobTitleTextField.setText(adminUsersService.readUserData().getJobTitle());
        salaryTextField.setText(adminUsersService.readUserData().getSalary()+"");
        pharmacyIdTextField.setText(adminUsersService.readUserData().getPharmacyId()+"");
    }
}