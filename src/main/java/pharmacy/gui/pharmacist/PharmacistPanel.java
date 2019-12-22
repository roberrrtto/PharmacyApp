package pharmacy.gui.pharmacist;

import pharmacy.service.PharmacistOperations;
import pharmacy.utils.GetCurrentDate;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static pharmacy.Main.mainFrame;

public class PharmacistPanel extends JPanel {

    private JLabel loggedNameLabel, dateLabel, medicineLabel;
    private JButton logOutButton, addMedicineButton, sellButton;
    private JList medicineList;
    private JTextArea basketTextField;
    private JScrollPane medicineListScroller, basketListScroller;
    private GetCurrentDate getCurrentDate = new GetCurrentDate();
    private double toPay = 0;

    private PharmacistOperations pharmacistOperations;

    public PharmacistPanel(PharmacistOperations pharmacistOperations){
        this.pharmacistOperations = pharmacistOperations;

        setLayout(null);

        loggedNameLabel = new JLabel(pharmacistOperations.getUserInitData().getFirstName(), SwingConstants.CENTER);
        loggedNameLabel.setBounds(580, 15, 70, 50);
        loggedNameLabel.setFont(loggedNameLabel.getFont().deriveFont(15f));

        dateLabel = new JLabel(getCurrentDate.getCurrentDate());
        dateLabel.setBounds(50, 15, 100,50);
        dateLabel.setFont(dateLabel.getFont().deriveFont(15f));

        logOutButton = new JButton("Log out");
        logOutButton.setBounds(555, 65, 80, 30);
        logOutButton.setFont(logOutButton.getFont().deriveFont(12f));
        logOutButton.addActionListener(e -> {
            mainFrame.logout();
        });

        medicineLabel = new JLabel("Medicines: " );
        medicineLabel.setBounds(100, 115, 500, 50 );
        medicineLabel.setFont(medicineLabel.getFont().deriveFont(15f));

        medicineList = new JList(pharmacistOperations.getStorageDetails());
        medicineList.setBounds(100, 160, 500, 180);
        medicineList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        medicineList.setFont(medicineList.getFont().deriveFont(15f));

        medicineListScroller = new JScrollPane();
        medicineListScroller.setViewportView(medicineList);
        medicineListScroller.setBounds(100, 160, 500, 180);

        basketTextField = new JTextArea();
        basketTextField.setBounds(100, 420, 500, 140);
        basketTextField.setFont(basketTextField.getFont().deriveFont(15f));

        basketListScroller = new JScrollPane();
        basketListScroller.setViewportView(basketTextField);
        basketTextField.setBounds(100, 420, 500, 140);

        addMedicineButton = new JButton("Add to the basket");
        addMedicineButton.setBounds(250, 360, 200, 40);
        addMedicineButton.setFont(addMedicineButton.getFont().deriveFont(15f));
        addMedicineButton.addActionListener(e -> {
            if(medicineList.isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "Pick the medicine.");
            } else {
                String str = medicineList.getSelectedValue().toString();
                Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(str);
                if (m.find())
                    toPay += Double.parseDouble(m.group(1));
                basketTextField.setText(basketTextField.getText() + medicineList.getSelectedValue() + "\r\n");
            }
        });

        sellButton = new JButton("Sell");
        sellButton.setBounds(555, 615, 80, 30);
        sellButton.setFont(sellButton.getFont().deriveFont(12f));
        sellButton.addActionListener(e -> {
            String str = "To pay: " + Double.toString(toPay);
            JOptionPane.showMessageDialog(null, str);

        });


        add(loggedNameLabel);
        add(dateLabel);
        add(logOutButton);
        add(medicineLabel);
        add(basketTextField);
        add(medicineListScroller);
        add(basketListScroller);
        add(sellButton);
        add(addMedicineButton);
    }

//    private void updateStorageQuantity(){
//        try{
//            int qty = 1;
//
//        }
//    }

}
