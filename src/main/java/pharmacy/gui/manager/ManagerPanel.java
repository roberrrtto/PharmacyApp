package pharmacy.gui.manager;

import pharmacy.utils.GetCurrentDate;
import pharmacy.service.ManagerOperations;

import javax.swing.*;

import static pharmacy.Main.*;

public class ManagerPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, employeeLabel, availableMedicineLabel, saleLabel, medicineQtyUpdateLabel;
    private JButton logOutButton, switchToSaleButton, updatButton, getButton, userDetailsButton;
    private JTextField dateTextField, saleTextField, medicineQtyUpdateField;
    private JList<String> employeeList, medicineList;
    private JScrollPane listScroller;
    private GetCurrentDate getCurrentDate = new GetCurrentDate();
    private ManagerEmployeeDetailsPanel managerEmployeeDetailsPanel;
    private ManagerOperations managerOperations;

    public ManagerPanel(ManagerOperations managerOperations){
        this.managerOperations = managerOperations;

        setLayout(null);

        loggedNameLabel = new JLabel(managerOperations.getUserInitData().getFirstName(), SwingConstants.CENTER);
        loggedNameLabel.setBounds(555, 15, 80, 50);
        loggedNameLabel.setFont(loggedNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(getCurrentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100,50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        logOutButton = new JButton("Log out");
        logOutButton.setBounds(555, 55, 80, 30);
        logOutButton.setFont(logOutButton.getFont().deriveFont(12f));
        logOutButton.addActionListener(e -> {
            mainFrame.logout();
        });

        switchToSaleButton = new JButton("SALE");
        switchToSaleButton.setBounds(555, 95, 80, 30);
        switchToSaleButton.setFont(dateLabel.getFont().deriveFont(13f));
        switchToSaleButton.addActionListener(e -> {
            // >>>> switch to SALE (Pharmacist Panel)
        });

        employeeLabel = new JLabel("Employees", SwingConstants.CENTER);
        employeeLabel.setBounds(100, 115, 500, 50 );
        employeeLabel.setFont(employeeLabel.getFont().deriveFont(15f));

        employeeList = new JList(managerOperations.getNames());
        employeeList.setBounds(170, 160, 360, 80);
        employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeList.setFont(employeeList.getFont().deriveFont(15f));

        userDetailsButton = new JButton("DETAILS");
        userDetailsButton.setBounds(555, 175, 80, 40 );
        userDetailsButton.setFont(userDetailsButton.getFont().deriveFont(11f));
        userDetailsButton.addActionListener(e -> {
            if (employeeList.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null,"Pick the user!","Information", 1);
            } else {
                managerOperations.setUserDetails(employeeList.getSelectedIndex());
                managerEmployeeDetailsPanel = new ManagerEmployeeDetailsPanel(managerOperations);
                mainFrame.panelSwitchOver(managerEmployeeDetailsPanel);
            }
        });

        availableMedicineLabel = new JLabel("Available medicines: ", SwingConstants.CENTER);
        availableMedicineLabel.setBounds(100, 270, 500, 50);
        availableMedicineLabel.setFont(availableMedicineLabel.getFont().deriveFont(15f));

        medicineList = new JList(managerOperations.getStorageDetails());
        medicineList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        medicineList.setFont(medicineList.getFont().deriveFont(15f));

        listScroller = new JScrollPane();
        listScroller.setViewportView(medicineList);
        listScroller.setBounds(170, 315, 360, 100);

        medicineQtyUpdateLabel = new JLabel("Update quantity: ");
        medicineQtyUpdateLabel.setBounds(200, 430, 150, 40 );
        medicineQtyUpdateLabel.setFont(medicineQtyUpdateLabel.getFont().deriveFont(15f));

        medicineQtyUpdateField = new JTextField();
        medicineQtyUpdateField.setBounds(350, 430, 50, 40);
        medicineQtyUpdateField.setFont(medicineQtyUpdateField.getFont().deriveFont(15f));

        updatButton = new JButton("UPDATE");
        updatButton.setBounds(410, 430, 90, 40);
        updatButton.setFont(updatButton.getFont().deriveFont(13f));
        updatButton.addActionListener(e -> {
            revalidateStorageQty();
        });

        saleLabel = new JLabel("Total sale for: ");
        saleLabel.setBounds(100, 490, 150, 40);
        saleLabel.setFont(saleLabel.getFont().deriveFont(15f));

        dateTextField = new JTextField("YYYY-MM-DD");
        dateTextField.setBounds(250, 490, 150, 40);
        dateTextField.setFont(dateTextField.getFont().deriveFont(15f));

        saleTextField = new JTextField();
        saleTextField.setBounds(100, 550, 500, 60);
        saleTextField.setFont(saleTextField.getFont().deriveFont(15f));

        getButton = new JButton("GET");
        getButton.setBounds(410, 490, 90, 40);
        getButton.setFont(getButton.getFont().deriveFont(13f));
        getButton.addActionListener(e -> {
            double sale = managerOperations.getDataBaseInit().getTotalSale(dateTextField.getText()).getTotalSale();
            saleTextField.setText("Total sale for " + dateTextField.getText() + ": " + sale + "$");
        });
//220 width
        add(loggedNameLabel);
        add(dateLabel);
        add(employeeLabel);
        add(availableMedicineLabel);
        add(saleLabel);
        add(logOutButton);
        add(switchToSaleButton);
        add(updatButton);
        add(userDetailsButton);
        add(employeeList);
        add(listScroller);
        add(dateTextField);
        add(saleTextField);
        add(medicineQtyUpdateLabel);
        add(medicineQtyUpdateField);
        add(getButton);

    }

    private void revalidateStorageQty() {
        try {
            int quantity = Integer.parseInt(medicineQtyUpdateField.getText());
            if (quantity < 0) {
                JOptionPane.showMessageDialog(null,"The value cannot be less than 0","Warning", 2);
            } else
            managerOperations.storageUpdateForJPanel(quantity, medicineList.getSelectedIndex()+1);
            medicineList = new JList(managerOperations.getStorageDetails());
            medicineList.setFont(medicineList.getFont().deriveFont(15f));
            listScroller.setViewportView(medicineList);
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null,"Invalid data","Error", 0);
        }
    }
}