package pharmacy.pharmacist;

import javax.swing.*;

public class PharmacistFrame extends JFrame {

    public PharmacistFrame(){
        setSize(700,700);
        setResizable(false);
        setTitle("Pharmacist");
        setLocationRelativeTo(null);

        PharmacistPanel pharmacistPanel = new PharmacistPanel();
        add(pharmacistPanel);
    }
}
