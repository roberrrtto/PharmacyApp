package dev.kris.pharmacy;

import dev.kris.pharmacy.log.LogFrame;
import dev.kris.pharmacy.manager.ManagerFrame;

import javax.swing.*;
import java.awt.*;

public class Main {

//    static LogFrame logFrame = new LogFrame();
//    static PharmacistFrame pharmacistFrame = new PharmacistFrame();
//    static ManagerFrame managerFrame = new ManagerFrame();
//    static AdminFrame adminFrame = new AdminFrame();

    public static void main(String[] args) {

        LogFrame logFrame = new LogFrame();
//        PharmacistFrame pharmacistFrame = new PharmacistFrame();
        ManagerFrame managerFrame = new ManagerFrame();
//        AdminFrame adminFrame = new AdminFrame();
//        DataBaseInit dataBaseInit = new DataBaseInit();

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
//            pharmacistFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            pharmacistFrame.setVisible(false);
            managerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            managerFrame.setVisible(true);
//            adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            adminFrame.setVisible(false);
        });

    }
}
