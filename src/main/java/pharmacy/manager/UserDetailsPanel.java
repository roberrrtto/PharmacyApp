package pharmacy.manager;

import pharmacy.GetCurrentDate;

import javax.swing.*;

import static pharmacy.Main.managerFrame;
import static pharmacy.Main.userDetailsFrame;

public class UserDetailsPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, employeeLabel;
    private JButton searchButton;
    private JTextField dateTextField;
    private JList<String> employeeList;
    private GetCurrentDate getCurrentDate = new GetCurrentDate();

    private ManagerOperations managerOperations;

    public UserDetailsPanel(ManagerOperations managerOperations){
        this.managerOperations = managerOperations;

        setLayout(null);

        loggedNameLabel = new JLabel(managerOperations.getUserInitData().getFirstName(), SwingConstants.CENTER);
        loggedNameLabel.setBounds(555, 15, 80, 50);
        loggedNameLabel.setFont(loggedNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(getCurrentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100,50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        employeeLabel = new JLabel("Employees", SwingConstants.CENTER);
        employeeLabel.setBounds(100, 85, 500, 50 );
        employeeLabel.setFont(employeeLabel.getFont().deriveFont(15f));

        employeeList = new JList(managerOperations.getUserDetails());
        employeeList.setBounds(170, 100, 360, 450);
        employeeList.setFont(employeeList.getFont().deriveFont(15f));

        dateTextField = new JTextField();
        dateTextField.setBounds(250, 490, 150, 40);
        dateTextField.setFont(dateTextField.getFont().deriveFont(15f));

        searchButton = new JButton("Go Back");
        searchButton.setBounds(300, 600, 100, 40);
        searchButton.setFont(searchButton.getFont().deriveFont(13f));
        searchButton.addActionListener(e -> {
            managerFrame.setVisible(true);
            userDetailsFrame.setVisible(false);
        });

        add(loggedNameLabel);
        add(dateLabel);
        add(employeeLabel);
        add(employeeList);
        add(dateTextField);
        add(searchButton);

    }

    public String getLoggedNameLabel() {
        return loggedNameLabel.getText();
    }
}
