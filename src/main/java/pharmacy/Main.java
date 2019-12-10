package pharmacy;

import pharmacy.admin.AdminFrame;
import pharmacy.admin.AdminPanel;
import pharmacy.log.LogFrame;
import pharmacy.log.LogPanel;
import pharmacy.manager.ManagerFrame;
import pharmacy.pharmacist.PharmacistFrame;
import pharmacy.pharmacist.PharmacistPanel;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static LogFrame logFrame = new LogFrame();
    public static PharmacistFrame pharmacistFrame = new PharmacistFrame();
    public static ManagerFrame managerFrame = new ManagerFrame();
    public static AdminFrame adminFrame = new AdminFrame();
    public static PharmacyApp pharmacyApp = new PharmacyApp();

    public static void main(String[] args) {

        LogPanel logPanel = new LogPanel();
        logFrame.add(logPanel);

        AdminPanel adminPanel = new AdminPanel();
        adminFrame.add(adminPanel);

        PharmacistPanel pharmacistPanel = new PharmacistPanel();
        pharmacistFrame.add(pharmacistPanel);

        ///////// get initial data (logon process) /////////

//        UserInitData userInitData = dataBaseInit.getUserData("frawas", "frawas2019");
//        if (userInitData.isCorrect()) {
//            System.out.println(userInitData.toString());
//        } else {
//            System.out.println("WRONG! but it's working ;)");
//        }
//
//        int phId = userInitData.getPharmacyId();
//        System.out.println(phId);

        ///////// get all users data (list all info when requested by the Unit Manager /////////
//        List<UserInfoData> userInfoDataList = dataBaseInit.getAllUsers();
//
//        for (UserInfoData uid : userInfoDataList) {
//            System.out.println(uid);
//        }

//        List<UserInfoDataManger> userInfoDataMangerList = dataBaseInit.getUnitUsersData(userInitData.getUserId());
//        for (UserInfoDataManger uidm : userInfoDataMangerList) {
//            System.out.println(uidm);
//        }

//        List<StorageData> storageDataList = dataBaseInit.getStorageData(1);
//        for (StorageData sd : storageDataList) {
//            System.out.println(sd);
//        }

//        dataBaseInit.updateStorageQuantity(25,2,2);

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
        });

    }
}
