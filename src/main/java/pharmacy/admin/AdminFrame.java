package pharmacy.admin;

import javax.swing.*;

public class AdminFrame extends JFrame {

    public AdminFrame(){
        setSize(700,700);
        setResizable(false);
        setTitle("Admin");
        setLocationRelativeTo(null);

        AdminPanel adminPanel = new AdminPanel();

        add(adminPanel);
    }
}
