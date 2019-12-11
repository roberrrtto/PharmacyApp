package pharmacy;

import pharmacy.admin.AdminFrame;
import pharmacy.admin.AdminPanel;
import pharmacy.log.LogFrame;
import pharmacy.log.LogPanel;
import pharmacy.manager.ManagerFrame;
import pharmacy.manager.UserDetailsFrame;
import pharmacy.pharmacist.PharmacistFrame;
import pharmacy.pharmacist.PharmacistOperations;
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

<<<<<<< HEAD
        ///////// get initial data (logon process) /////////
=======
        AdminPanel adminPanel = new AdminPanel();
        adminFrame.add(adminPanel);

        PharmacistPanel pharmacistPanel = new PharmacistPanel();
        pharmacistFrame.add(pharmacistPanel);

>>>>>>> 475a05f3a2266c8514e96e03838be77d2b81f219


        /////// Testing GUI /////////

        EventQueue.invokeLater(() ->{
            logFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            logFrame.setVisible(true);
            pharmacistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pharmacistFrame.setVisible(true);
            managerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            managerFrame.setVisible(true);
            adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< HEAD
            adminFrame.setVisible(true);
=======
            adminFrame.setVisible(false);
            userDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            userDetailsFrame.setVisible(false);
>>>>>>> 475a05f3a2266c8514e96e03838be77d2b81f219
        });

    }
}
