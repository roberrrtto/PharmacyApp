package pharmacy;

import pharmacy.admin.AdminFrame;
import pharmacy.admin.AdminPanel;
import pharmacy.log.LogFrame;
import pharmacy.log.LogPanel;
import pharmacy.manager.ManagerFrame;
import pharmacy.manager.UserDetailsFrame;
import pharmacy.pharmacist.PharmacistFrame;
import pharmacy.pharmacist.PharmacistPanel;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static LogFrame logFrame = new LogFrame();
    public static PharmacistFrame pharmacistFrame = new PharmacistFrame();
    public static ManagerFrame managerFrame = new ManagerFrame();
    public static AdminFrame adminFrame = new AdminFrame();
    public static UserDetailsFrame userDetailsFrame = new UserDetailsFrame();
    public static PharmacyApp pharmacyApp = new PharmacyApp();

    public static void main(String[] args) {

        LogPanel logPanel = new LogPanel();
        logFrame.add(logPanel);

        AdminPanel adminPanel = new AdminPanel();
        adminFrame.add(adminPanel);

        PharmacistPanel pharmacistPanel = new PharmacistPanel();
        pharmacistFrame.add(pharmacistPanel);



        /////// Testing GUI /////////

        EventQueue.invokeLater(() ->{
            logFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            logFrame.setVisible(true);
            pharmacistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pharmacistFrame.setVisible(false);
            managerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            managerFrame.setVisible(false);
            adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            adminFrame.setVisible(false);
            userDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            userDetailsFrame.setVisible(false);
        });

    }
}
