package pharmacy.gui.manager;

import pharmacy.service.UserProfileServiceImpl;
import pharmacy.service.UserService;
import pharmacy.utils.GetCurrentDate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static pharmacy.Main.mainFrame;

public class ManagerReadUserPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, employeeLabel, firstNameLabel, lastNameLabel, addressLabel;
    private JLabel emailLabel, phoneNoLabel, loginLabel, jobTitleLabel, salaryLabel;
    private JTextField firstNameTextField, lastNameTextField, addressTextField, emailTextField, phoneNoTextField;
    private JTextField loginTextField, jobTitleTextField, salaryTextField;
    private UserService userService;
    private JButton goBackButton;
    private BufferedImage img;

    private GetCurrentDate getCurrentDate = new GetCurrentDate();

    public ManagerReadUserPanel(UserService userService){
        setLayout(null);
        try {
            img = ImageIO.read(getClass().getResource("/background.png")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.userService = userService;

        loggedNameLabel = new JLabel(UserProfileServiceImpl.getFirstName(), SwingConstants.CENTER);
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

        salaryLabel = new JLabel("salary", SwingConstants.LEFT);
        salaryLabel.setBounds(100, 400, 110, 50 );
        salaryLabel.setFont(salaryLabel.getFont().deriveFont(15f));

        salaryTextField = new JTextField();
        salaryTextField.setEditable(false);
        salaryTextField.setBounds(220, 400, 360, 40);
        salaryTextField.setFont(salaryTextField.getFont().deriveFont(15f));

        jobTitleLabel = new JLabel("job title", SwingConstants.LEFT);
        jobTitleLabel.setBounds(100, 450, 110, 50 );
        jobTitleLabel.setFont(jobTitleLabel.getFont().deriveFont(15f));

        jobTitleTextField = new JTextField();
        jobTitleTextField.setEditable(false);
        jobTitleTextField.setBounds(220, 450, 360, 40);
        jobTitleTextField.setFont(jobTitleTextField.getFont().deriveFont(15f));

        goBackButton = new JButton("Go Back");
        goBackButton.setBounds(300, 500, 100, 40);
        goBackButton.setFont(goBackButton.getFont().deriveFont(13f));
        goBackButton.addActionListener(e -> {
            mainFrame.panelSwitchOver(new ManagerPanel());
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
        add(jobTitleLabel);
        add(salaryLabel);
        add(firstNameTextField);
        add(lastNameTextField);
        add(addressTextField);
        add(emailTextField);
        add(phoneNoTextField);
        add(loginTextField);
        add(jobTitleTextField);
        add(salaryTextField);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    public void setFields() {
        firstNameTextField.setText(userService.readUnitUser().getFirstName());
        lastNameTextField.setText(userService.readUnitUser().getLastName());
        addressTextField.setText(userService.readUnitUser().getAddress());
        emailTextField.setText(userService.readUnitUser().getEmail());
        phoneNoTextField.setText(userService.readUnitUser().getPhoneNumber());
        loginTextField.setText(userService.readUnitUser().getLogin());
        jobTitleTextField.setText(userService.readUnitUser().getJobTitle());
        salaryTextField.setText(userService.readUnitUser().getSalary()+"");
    }
}