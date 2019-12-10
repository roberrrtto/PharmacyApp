package dev.kris.pharmacy;

import dev.kris.pharmacy.manager.ManagerOperations;
import dev.kris.pharmacy.manager.ManagerPanel;
import dev.kris.pharmacy.sqlStaff.DataBaseInit;
import dev.kris.pharmacy.sqlStaff.UserInfoDataManger;
import dev.kris.pharmacy.sqlStaff.UserInitData;

import java.util.List;

import static dev.kris.pharmacy.Main.*;

public class PharmacyApp {

    private static final String Pharmacist = "Pharmacist";
    private static final String UnitManager = "Unit Manager";
    private static final String Admin = "Admin";

    public UserInitData userInitData;
    public List<UserInfoDataManger> userInfoDataMangerList;
    private DataBaseInit dataBaseInit = new DataBaseInit();
    public ManagerOperations managerOperations;
    public ManagerPanel managerPanel;

    public boolean logging(String userLogin, String userPassword) {
        userInitData = dataBaseInit.getUserData(userLogin, userPassword);
        if (userInitData.isCorrect()) {
            if (userInitData.getRole().equals(Pharmacist)) {
                pharmacistFrame.setVisible(true);
            } else if (userInitData.getRole().equals(UnitManager)) {
                managerOperations = new ManagerOperations(userInitData, dataBaseInit);
                managerPanel = new ManagerPanel(managerOperations);
                managerFrame.add(managerPanel);
                managerFrame.setVisible(true);
            } else if (userInitData.getRole().equals(Admin)) {
                adminFrame.setVisible(true);
            }
            logFrame.setVisible(false);
            return true;
        } else {
            return false;
        }
    }


    public DataBaseInit getDataBaseInit() {
        return dataBaseInit;
    }

    public void setDataBaseInit(DataBaseInit dataBaseInit) {
        this.dataBaseInit = dataBaseInit;
    }

}
