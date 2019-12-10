package pharmacy;

import pharmacy.manager.ManagerOperations;
import pharmacy.manager.ManagerPanel;
import pharmacy.sqlStaff.DataBaseInit;
import pharmacy.sqlStaff.UserInfoDataManger;
import pharmacy.sqlStaff.UserInitData;

import java.util.List;

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
                Main.pharmacistFrame.setVisible(true);
            } else if (userInitData.getRole().equals(UnitManager)) {
                managerOperations = new ManagerOperations(userInitData, dataBaseInit);
                managerPanel = new ManagerPanel(managerOperations);
                Main.managerFrame.add(managerPanel);
                Main.managerFrame.setVisible(true);
            } else if (userInitData.getRole().equals(Admin)) {
                Main.adminFrame.setVisible(true);
            }
            Main.logFrame.setVisible(false);
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
