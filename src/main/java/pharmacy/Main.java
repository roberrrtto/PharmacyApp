package pharmacy;

import pharmacy.admin.AdminFrame;
import pharmacy.admin.UserAddFrame;
import pharmacy.log.LogFrame;
import pharmacy.log.LogPanel;
import pharmacy.manager.ManagerFrame;
import pharmacy.manager.UserDetailsFrame;
import pharmacy.pharmacist.PharmacistFrame;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static LogFrame logFrame = new LogFrame();
    public static PharmacistFrame pharmacistFrame = new PharmacistFrame();
    public static ManagerFrame managerFrame = new ManagerFrame();
    public static AdminFrame adminFrame = new AdminFrame();
    public static UserDetailsFrame userDetailsFrame = new UserDetailsFrame();
    public static PharmacyApp pharmacyApp = new PharmacyApp();
    public static UserAddFrame userAddFrame = new UserAddFrame();

    public static void main(String[] args) {

        LogPanel logPanel = new LogPanel();
        logFrame.add(logPanel);

//        DataBaseInit dataBaseInit = new DataBaseInit();
//        CreateUserForm createUserForm = new CreateUserForm("first","last",
//                "add","wrwr","21342352","rsdffs","rw","rw",
//                432,424323);
//        dataBaseInit.createNewUser(createUserForm);
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
            userAddFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            userAddFrame.setVisible(false);
        });

    }
}
